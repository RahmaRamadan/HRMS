package DataAccess.Evaluation;

import Entity.Employee_Data;
import Entity.Training;
import Entity.Training_Acceptance;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zak
 */
interface Training_Data_Access_Interface
{
    public  ArrayList<Training> Get_Trainings_Data();
    public boolean setTraining(Training t);
    public boolean deleteTraining(int trainingID);
    //public boolean setTrainingSkills(int trainingID, String skill);
    public ArrayList<String> get_training_Skills(int id);
    public boolean insert_trainScore(String emp_id , int t_id , double s);
    public ArrayList<Training_Acceptance> getAcceptedEmployees(int t_id);
    
}
