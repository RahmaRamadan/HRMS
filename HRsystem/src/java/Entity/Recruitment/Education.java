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
public class Education {
    private Degree degree;
    private String field;
    private double GPA;
    
    public Education(Degree d, String f, double GP){
        degree=d;
        field=f;
        GPA = GP;
      
    }
    public Degree getDegree(){
        return degree;
    }
    public String getField(){
        return field;
    }
    public double getGPA(){
        return GPA;
    }
    
}
