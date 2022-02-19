/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.EmployeesAffairs;

import DataAccess.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author maria
 */
public class MySQL_Attendance_DataAccess implements Employee_Attendance_Interface {

    private static String typee;
    private static String Dep;
    private static String HRType;

    public void setType(String t) {
        typee = t;
    }

    public void setHRType(String hr) {
        if (hr != null) {
            HRType = hr;
        } else {
            HRType = null;
        }

    }
    public void setDepID(String dep) {
        Dep = dep;
    }

    public boolean validateLogin(String id, String Password, String uname) throws Exception {
        try {
            Connection con;
            PreparedStatement pat;
            ResultSet rs;
            con = DatabaseConnection.getConnection();
            String type, pass, unamee, hrType, depId;
            String query;
            query = "SELECT username, password, empType,dep_id, hrComponent from employee where id = ?";

            pat = con.prepareStatement(query);
            pat.setString(1, id);
            rs = pat.executeQuery();

            Date CurrentDate = GregorianCalendar.getInstance().getTime();
            DateFormat df = DateFormat.getDateInstance();
            String dateString = df.format(CurrentDate);
            SimpleDateFormat f = new SimpleDateFormat("MMMMMMMMM");
            checkAttendance(dateString);
            String strMonth;
            strMonth = f.format(new Date());
            SimpleDateFormat f2 = new SimpleDateFormat("YYYY");
            String strYear;
            strYear = f2.format(new Date());

            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            String timeString = sdf.format(d);
            int value = timeString.compareTo("10:15");
            Connection con2;
            PreparedStatement pat2;
            ResultSet rs2;
            con2 = DatabaseConnection.getConnection();
            String query2;

            if (rs.next()) {
                unamee = rs.getString(1);
                pass = rs.getString(2);
                type = rs.getString(3);
                depId = rs.getString(4);
                hrType = rs.getString(5);
                setType(type);
                setDepID(depId);
                setHRType(hrType);
                if (Password.equals(pass) && uname.equals(unamee)) {
                    if (type.equals("Employee") || type.equals("Manager")) {
                        //response.sendRedirect("homePage.jsp"); 

                        if (value > 0) { //After 10 AM

                            query2 = "INSERT INTO attendance (attendance, sysDate, status, userID, month, year) VALUES (?,?,?,?,?,?)";
                            pat2 = con2.prepareStatement(query2);
                            pat2.setString(1, "Present");
                            pat2.setString(2, dateString);
                            pat2.setString(3, "Late");
                            pat2.setString(4, id);
                            pat2.setString(5, strMonth);
                            pat2.setString(6, strYear);
                            pat2.executeUpdate();
                        } else if (value == 0) {
                            query2 = "INSERT INTO attendance (attendance, sysDate, status, userID, month, year) VALUES (?,?,?,?,?,?)";

                            pat2 = con2.prepareStatement(query2);
                            pat2.setString(1, "Present");
                            pat2.setString(2, dateString);
                            pat2.setString(3, "On Time");
                            pat2.setString(4, id);
                            pat2.setString(5, strMonth);
                            pat2.setString(6, strYear);
                            pat2.executeUpdate();
                        } else {
                            query2 = "INSERT INTO attendance (attendance, sysDate, status, userID, month, year) VALUES (?,?,?,?,?,?)";

                            pat2 = con2.prepareStatement(query2);
                            pat2.setString(1, "Present");
                            pat2.setString(2, dateString);
                            pat2.setString(3, "Early");
                            pat2.setString(4, id);
                            pat2.setString(5, strMonth);
                            pat2.setString(6, strYear);
                            pat2.executeUpdate();
                        }
                    }

                    return true;
                } else {
                    return false;

                }

            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public String getType() {
        return typee;
    }

    public String getHRType() {
        if (HRType != null) {
            return HRType;
        } else {
            return "Not an HR Employee";
        }
    }
     public String getDepID() {
        return Dep;
    }

    @Override
    public boolean checkAttendance(String date) throws Exception {
        try {
            Connection con = DatabaseConnection.getConnection();
            ResultSet rs, rs2;
            PreparedStatement pat;
            Date CurrentDate = GregorianCalendar.getInstance().getTime();
            DateFormat df = DateFormat.getDateInstance();
            String dateString = df.format(CurrentDate);
            SimpleDateFormat f = new SimpleDateFormat("MMMMMMMMM");
            String strMonth;
            strMonth = f.format(new Date());
            SimpleDateFormat f2 = new SimpleDateFormat("YYYY");
            String strYear;
            strYear = f2.format(new Date());

            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            String timeString = sdf.format(d);
            ArrayList<String> ids = new ArrayList<>();
            String query = "select userID from attendance where sysDate = " + date;
            Statement st = con.createStatement();
            rs = st.executeQuery(query);

            String query3 = "INSERT INTO attendance (attendance, sysDate, status, userID, month, year) VALUES (?,?,?,?,?,?)";

            pat = con.prepareStatement(query3);
            pat.setString(1, "Absent");
            pat.setString(2, dateString);
            pat.setString(3, "null");
            pat.setString(4, "109");
            pat.setString(5, strMonth);
            pat.setString(6, strYear);
            pat.executeUpdate();

            while (rs.next()) {
                ids.add(rs.getString("userID"));
                return true;

            }

            ArrayList<String> origIds = new ArrayList<>();
            String query2 = "select id from employee";
            Statement st2 = con.createStatement();
            rs = st.executeQuery(query);
            //Counter = rs.getInt(2); 

            while (rs.next()) {
                origIds.add(rs.getString("id"));

            }

            List<String> finalRes = compareArrayList(origIds, ids);
            List<String> finalResExec = new ArrayList<>(origIds);
            finalResExec.removeAll(finalRes);
//      String query3;
            for (int i = 0; i < finalResExec.size(); i++) {
                query3 = "INSERT INTO attendance (attendance, sysDate, status, userID, month, year) VALUES (?,?,?,?,?,?)";

                pat = con.prepareStatement(query3);
                pat.setString(1, "Absent");
                pat.setString(2, dateString);
                pat.setString(3, "null");
                pat.setString(4, finalResExec.get(i));
                pat.setString(5, strMonth);
                pat.setString(6, strYear);
                pat.executeUpdate();

            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<String> compareArrayList(List<String> a, List<String> b) {

        List<String> copy = new ArrayList<>(a);

        copy.retainAll(b);
        return copy;

    }

}
