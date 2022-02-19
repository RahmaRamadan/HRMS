/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Recruitment;

import DataAccess.DatabaseConnection;
import Entity.Department;
import Entity.Recruitment.Degree;
import Entity.Recruitment.Education;
import Entity.Recruitment.Job;
import Entity.Recruitment.JobType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author maria
 */
public class MySQL_Job_DataAccess implements Applicant_Job_DataAccess_Interface, Employee_Job_DataAccess_Interface {

    public String[] getRequiredSkills(int jobID) throws SQLException, Exception {

        java.sql.Connection connection = DatabaseConnection.getConnection();
        java.sql.Statement statement = connection.createStatement();

        ArrayList<String> temp = new ArrayList<>();
        ResultSet rs = statement.executeQuery("SELECT name FROM job_skills WHERE jobID=" + jobID + " ;");

        while (rs.next()) {
            temp.add(rs.getString(1));

        }
        statement.close();
        connection.close();

        String[] skills = new String[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            skills[i] = temp.get(i);
            // System.out.println(skills[i]+"       mmm");
        }
        return skills;
    }

    @Override
    public int generateJobID() throws SQLException {
        try {
            java.sql.Connection connection = DatabaseConnection.getConnection();
            java.sql.Statement statement = connection.createStatement();

            int n = 0;
            ResultSet rs = statement.executeQuery("SELECT MAX(ID) FROM job");
            while (rs.next()) {
                n = rs.getInt(1);
            }
            statement.close();
            connection.close();

            n += 1;
            return n;
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public boolean insertJob(Job job) throws SQLException {

        try {
            java.sql.Connection connection = DatabaseConnection.getConnection();
            java.sql.Statement statement = connection.createStatement();

            try {

                System.out.println("INSERT INTO job VALUES(" + job.getID() + ",'" + job.getTitle() + "','" + job.getDescription() + "','" + job.getRequiredEducation().getDegree().toString() + "','" + job.getRequiredEducation().getField() + "'," + job.getYears() + ",'" + job.getTime() + "','" + job.getPosterUsername() + "','" + job.getType().toString() + "', " + job.getRequiredEducation().getGPA() + ",'" + job.getCategory().toString() + "'," + job.getScore() + " );");

                statement.executeUpdate("INSERT INTO job VALUES(" + job.getID() + ",'" + job.getTitle() + "','" + job.getDescription() + "','" + job.getRequiredEducation().getDegree().toString() + "','" + job.getRequiredEducation().getField() + "'," + job.getYears() + ",'" + job.getTime() + "','" + job.getPosterUsername() + "','" + job.getType().toString() + "', " + job.getRequiredEducation().getGPA() + ",'" + job.getCategory().toString() + "'," + job.getScore() + " );");

                for (int i = 0; i < job.getRequiredSkills().length; i++) {

                    statement.executeUpdate("INSERT INTO job_skills VALUES(" + job.getID() + ",'" + job.getRequiredSkills()[i] + "');");
                }
                statement.close();
                connection.close();

                return true;

            } catch (SQLException e) {
                statement.close();
                connection.close();

                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public ArrayList<Job> getAllJobs() throws SQLException {
try{
        java.sql.Connection connection = DatabaseConnection.getConnection();
        java.sql.Statement statement = connection.createStatement();

        ArrayList<Job> allJobs = new ArrayList<>();
        ResultSet rs = statement.executeQuery("SELECT * FROM job ORDER BY time DESC;");

        while (rs.next()) {
            Job job = new Job(rs.getInt(1), rs.getString(2), rs.getString(3), new Education(Degree.valueOf(rs.getString(4)), rs.getString(5), rs.getDouble(10)), rs.getInt(6), rs.getString(7), rs.getString(8), JobType.valueOf(rs.getString(9)), Department.valueOf(rs.getString(11)));
            job.setScore(rs.getDouble(12));
            allJobs.add(job);

        }
        statement.close();
        connection.close();

        for (int i = 0; i < allJobs.size(); i++) {
            Job job = allJobs.get(i);

            job.setRequiredSkills(getRequiredSkills(job.getID()));
            Employee_Applicant_DataAccess_Interface temp = new MySQL_Applicant_DataAccess();
            job.setApplicants(temp.getApplicants(job.getID()));
            allJobs.set(i, job);
        }

        return allJobs;
    }
catch(Exception e)
{
    return null;
}
    }

    @Override
    public Job getJobByID(int ID) throws SQLException {
try{
        java.sql.Connection connection = DatabaseConnection.getConnection();
        java.sql.Statement statement = connection.createStatement();

        Job job = null;
        ResultSet rs = statement.executeQuery("SELECT * FROM job WHERE ID=" + ID + ";");

        while (rs.next()) {

            job = new Job(rs.getInt(1), rs.getString(2), rs.getString(3), new Education(Degree.valueOf(rs.getString(4)), rs.getString(5), rs.getDouble(10)), rs.getInt(6), rs.getString(7), rs.getString(8), JobType.valueOf(rs.getString(9)), Department.valueOf(rs.getString(11)));
            job.setScore(rs.getDouble(12));
        }
        job.setRequiredSkills(getRequiredSkills(job.getID()));
        Employee_Applicant_DataAccess_Interface temp = new MySQL_Applicant_DataAccess();
        job.setApplicants(temp.getApplicants(job.getID()));
        statement.close();
        connection.close();
        return job;}
catch(Exception e)
{
    return null;
}
    }

    @Override
    public Boolean checkThereAreJobs() throws SQLException {

        try{
        java.sql.Connection connection = DatabaseConnection.getConnection();
        java.sql.Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM job;");

        int n = 0;
        while (rs.next()) {
            n = rs.getInt(1);
        }
        statement.close();
        connection.close();

        if (n == 0) {
            return false;
        } else {
            System.out.print(n);
            return true;
        }}
        catch(Exception e)
        {
            return false;
        }
    }

    @Override
    public boolean updateJob(Job temp) throws SQLException {
        Applicant_Applicant_DataAccess_Interface inter = new MySQL_Applicant_DataAccess();

        boolean delete = deleteJobByID(temp.getID());
        boolean insert = insertJob(temp);
        for (int i = 0; i < temp.getApplicants().size(); i++) {
            inter.insertApplicant(temp.getApplicants().get(i));
        }
        return delete && insert;
    }

    @Override
    public boolean deleteJobByID(int ID) throws SQLException {
        Job temp = getJobByID(ID);
        Employee_Applicant_DataAccess_Interface da = new MySQL_Applicant_DataAccess();
        for (int i = 0; i < temp.getApplicants().size(); i++) {
            da.deleteApplicant(temp.getApplicants().get(i).getID());
        }
try{
        java.sql.Connection connection = DatabaseConnection.getConnection();
        java.sql.Statement statement = connection.createStatement();

        try {

            System.out.println("Oppa");
            statement.executeUpdate("DELETE FROM job_skills WHERE jobID=" + ID + ";");
            statement.executeUpdate("DELETE FROM job WHERE ID=" + ID + ";");
            statement.close();
            connection.close();
          
            return true;
        } catch (SQLException e) {
            statement.close();
            connection.close();
        
            return false;
        }

    }
        catch (Exception e)
    {
        return false;
    }
    }


    @Override
    public ArrayList<Department> getJobsCategory() throws SQLException {
        ArrayList<Department> categories = new ArrayList<>();
    try{
        try (java.sql.Connection connection = DatabaseConnection.getConnection()) {
            java.sql.Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT DISTINCT(category) FROM job;");

            while (rs.next()) {
                categories.add(Department.valueOf(rs.getString(1)));
            }
            statement.close();
        }


        return categories;

    }
    catch(Exception e){return categories; }}

}
