/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Recruitment;

import DataAccess.DatabaseConnection;
import Entity.Recruitment.Applicant;
import Entity.Recruitment.Applicant_Type;
import Entity.Recruitment.Degree;
import Entity.Recruitment.Education;
import Entity.Recruitment.Experience;
import Entity.Recruitment.JobType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author maria
 */
public class MySQL_Applicant_DataAccess implements Applicant_Applicant_DataAccess_Interface, Employee_Applicant_DataAccess_Interface {

    public MySQL_Applicant_DataAccess() {

    }

    @Override
    public int generateApplicantID() throws SQLException {

       try{
        java.sql.Connection connection = DatabaseConnection.getConnection();
        java.sql.Statement statement = connection.createStatement();

        int n = 0;
        ResultSet rs = statement.executeQuery("SELECT MAX(ID) FROM applicant");
        while (rs.next()) {
            n = rs.getInt(1);
        }
        statement.close();
        connection.close();
    
        n += 1;
        return n;
    }
    catch (Exception e)
    {
        return -1;
    }}

    public String[] getSkills(int applicantID) throws SQLException, Exception {
        DatabaseConnection dc = new DatabaseConnection();
        java.sql.Connection connection = DatabaseConnection.getConnection();
        java.sql.Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT name FROM applicant_skills where applicantID=" + applicantID + " ;");
        ArrayList<String> skills = new ArrayList();
        while (rs.next()) {

            skills.add(rs.getString(1));

        }
        String[] sk = new String[skills.size()];
        for (int i = 0; i < skills.size(); i++) {
            sk[i] = skills.get(i);
        }
        statement.close();
        connection.close();
 

        return sk;
    }

    public ArrayList<Experience> getExperience(int applicantID) throws SQLException, Exception {
        
        java.sql.Connection connection = DatabaseConnection.getConnection();
        java.sql.Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM applicant_experience where applicantID=" + applicantID + " ;");
        ArrayList<Experience> experience = new ArrayList();
        while (rs.next()) {

            experience.add(new Experience(rs.getString(2), JobType.valueOf(rs.getString(3)), rs.getInt(4)));

        }
        statement.close();
        connection.close();

        return experience;
    }

    public Education getEducation(int applicantID) throws SQLException, Exception {
      
        java.sql.Connection connection = DatabaseConnection.getConnection();
        java.sql.Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM applicant_education where applicantID=" + applicantID + " ;");
        Education education = null;
        while (rs.next()) {

            education = new Education(Degree.valueOf(rs.getString(2)), rs.getString(3), rs.getDouble(4));

        }
        statement.close();
        connection.close();
     
        return education;
    }

    @Override
    public ArrayList<Applicant> getApplicants(int jobID) throws SQLException {
        try{
   
        java.sql.Connection connection = DatabaseConnection.getConnection();
        java.sql.Statement statement = connection.createStatement();

        ArrayList<Applicant> applicants = new ArrayList<>();
        ResultSet rs = statement.executeQuery("SELECT * FROM applicant where jobID=" + jobID + " ORDER BY score DESC ;");

        while (rs.next()) {

            Applicant temp = new Applicant(rs.getInt(1), rs.getString(7), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(6), Applicant_Type.valueOf(rs.getString(8)));
           
            temp.setScore(rs.getDouble(5));
            temp.setEducation(getEducation(temp.getID()));
            temp.setExperience(getExperience(temp.getID()));
            temp.setSkills(getSkills(temp.getID()));
            applicants.add(temp);

        }
        statement.close();
        connection.close();
   

        return applicants;
    }
        catch(Exception e)
        {
            return null;
        }
    
    }
    

    @Override
    public Applicant getApplicantByID(int applicantID) throws SQLException {
        try{
        java.sql.Connection connection = DatabaseConnection.getConnection();
        java.sql.Statement statement = connection.createStatement();

        Applicant applicant = null;
        ResultSet rs = statement.executeQuery("SELECT * FROM applicant where ID=" + applicantID + "  ;");

        while (rs.next()) {

            applicant = new Applicant(rs.getInt(1), rs.getString(7), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(6), Applicant_Type.valueOf(rs.getString(8)));
            applicant.setScore(rs.getDouble(5));

        }
        statement.close();
        connection.close();
        

        applicant.setEducation(getEducation(applicant.getID()));
        applicant.setExperience(getExperience(applicant.getID()));
        applicant.setSkills(getSkills(applicant.getID()));

        return applicant;
    }
        catch(Exception e)
        {
            return null;
        }
    
    }

    @Override
    public boolean insertApplicant(Applicant applicant) throws SQLException {
        applicant.setID(generateApplicantID());
        
      try{
       
        java.sql.Connection connection = DatabaseConnection.getConnection();
        java.sql.Statement statement = connection.createStatement();

        try {

            statement.executeUpdate("INSERT INTO applicant VALUES(" + applicant.getID() + ", " + applicant.getJobID() + ", '" + applicant.getName() + "', '" + applicant.getPhone() + "' ," + applicant.getScore() + ", '" + applicant.getGender() + "','" + applicant.getEmail() + "','applied' );");

            statement.executeUpdate("INSERT INTO applicant_education VALUES(" + applicant.getID() + ",'" + applicant.getEducation().getDegree().toString() + "', '" + applicant.getEducation().getField() + "', " + applicant.getEducation().getGPA() + ");");

            for (int i = 0; i < applicant.getExperience().size(); i++) {
                statement.executeUpdate("INSERT INTO applicant_experience VALUES(" + applicant.getID() + ",'" + applicant.getExperience().get(i).getTitle() + "','" + applicant.getExperience().get(i).getType().toString() + "'," + applicant.getExperience().get(i).getYears() + ");");
            }
            for (int i = 0; i < applicant.getSkills().length; i++) {
                statement.executeUpdate("INSERT INTO applicant_skills VALUES(" + applicant.getID() + "," + applicant.getJobID() + ",'" + applicant.getSkills()[i] + "');");
            }

            statement.close();
            connection.close();
            
            return true;

        } catch (SQLException e) {
            statement.close();
            connection.close();
           
            return false;
        }
    }
    catch(Exception e)
    { return false;
    }
        }

    @Override
    public boolean deleteApplicant(int applicantID) throws SQLException {
        try{
        java.sql.Connection connection = DatabaseConnection.getConnection();
        java.sql.Statement statement = connection.createStatement();

        try {
            statement.executeUpdate("DELETE FROM applicant_skills WHERE applicantID=" + applicantID + ";");
            statement.executeUpdate("DELETE FROM applicant_experience WHERE applicantID=" + applicantID + ";");
            statement.executeUpdate("DELETE FROM applicant_education WHERE applicantID=" + applicantID + ";");
            statement.executeUpdate("DELETE FROM applicant WHERE ID=" + applicantID + ";");
            statement.close();
            connection.close();
           
            return true;

        } catch (SQLException e) {
            statement.close();
            connection.close();
           
            return false;
        }}
        catch(Exception e)
        {
            return false;
        }

    }

    @Override
    public boolean updateApplicant(Applicant applicant) throws SQLException {

       try{
        java.sql.Connection connection = DatabaseConnection.getConnection();
        java.sql.Statement statement = connection.createStatement();
        try {

            statement.executeUpdate("UPDATE applicant SET score=" + applicant.getScore() + " WHERE ID=" + applicant.getID() + ";");
            statement.close();
            connection.close();
           
            return true;

        } catch (SQLException e) {
            statement.close();
            connection.close();
          
            return false;
        }}
       catch (Exception e)
       {
           return false;
       }
    }

    @Override
    public boolean updateApplicantType(int applicantID, Applicant_Type ty) throws SQLException {

        try{

        java.sql.Connection connection = DatabaseConnection.getConnection();
        java.sql.Statement statement = connection.createStatement();
        try {

            statement.executeUpdate("UPDATE applicant SET state='" + ty.toString() + "' WHERE ID=" + applicantID + ";");
            statement.close();
            connection.close();
          
            return true;

        } catch (SQLException e) {
            statement.close();
            connection.close();

            return false;
        }}
        catch (Exception e)
        {
            return false;
        }
    }

}
