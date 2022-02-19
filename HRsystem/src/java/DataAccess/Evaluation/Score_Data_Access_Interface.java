/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Evaluation;

import Entity.Employee_Data;
import java.util.ArrayList;

/**
 *
 * @author Zak
 */
interface Score_Data_Access_Interface 
{
    public ArrayList<Employee_Data> get_employees_scores () ; 
    public ArrayList<Employee_Data> Employee_History_Scores(int id);
    public boolean updateScore(String id, int score);
}
