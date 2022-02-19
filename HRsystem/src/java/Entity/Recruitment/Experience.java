/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity.Recruitment;

/**
 *
 * @author maria
 */
public class Experience {
    private String title;
    private JobType type;
    private int years;
    public Experience(String f, JobType t,int y){
        title=f;
        years=y;
        type=t;
    }
    public String getTitle(){
        return title;
    }
    public int getYears(){
        return years;
    }
    public JobType getType(){
        return type;
    }
    
    
}
