package Algorithms.Evaluation;

import DataAccess.Evaluation.Score_Data_access;
import Entity.Employee_Data;
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
public class Score_Management 
{
    public ArrayList<Employee_Data> show_BestScores()
    {
        ArrayList<Employee_Data> Scores = new ArrayList<>();
        Score_Data_access Data = new Score_Data_access();
        Scores = Data.get_employees_scores();
        return Scores;
    }
    
    public boolean Update_Score(String emp_id, int score)
    {
        Score_Data_access s = new Score_Data_access();
        boolean updated;
        updated = s.updateScore(emp_id,score);
        return updated;
    }
}
