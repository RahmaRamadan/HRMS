/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Recruitment;

import Entity.Department;
import Entity.Recruitment.Job;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author maria
 */
public interface Employee_Job_DataAccess_Interface {

    public ArrayList<Job> getAllJobs() throws SQLException;

    public Job getJobByID(int ID) throws SQLException;

    public Boolean checkThereAreJobs() throws SQLException;

    public int generateJobID() throws SQLException;

    public boolean insertJob(Job job) throws SQLException;

    public boolean deleteJobByID(int ID) throws SQLException;

    public boolean updateJob(Job job) throws SQLException;

    public ArrayList<Department> getJobsCategory() throws SQLException;

}
