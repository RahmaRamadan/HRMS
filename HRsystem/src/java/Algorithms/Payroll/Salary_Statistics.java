/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.Payroll;

import DataAccess.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dell
 */
public class Salary_Statistics {

    public List<Map<Object, Object>> employeeSalaries(String id) throws SQLException, ClassNotFoundException, Exception {

        List<Map<Object, Object>> Emp_Salary = new ArrayList<Map<Object, Object>>();
        Connection con;
        ResultSet rs;
        try {
            DatabaseConnection db = new DatabaseConnection();
            con = db.getConnection();
            String query = "SELECT * FROM salaryhistory WHERE empID=" + id;
            Statement st = con.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {
                Map<Object, Object> map = new HashMap<Object, Object>();
                map.put("label", rs.getString("date"));
                map.put("y", rs.getInt("amount"));
                Emp_Salary.add((Map<Object, Object>) map);
            }
            st.close();
        } catch (SQLException sqle) {
            System.out.println("Sql Exception :" + sqle.getMessage());
        }

        return Emp_Salary;
    }

}
