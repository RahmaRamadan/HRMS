/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author egypt2
 */
public class Vacation_Data {
    private String name;
    private String id;
    private String job;
    private String date;
    private String vacationType;
    private String numberOfDays;

    public Vacation_Data(String n, String idd, String jobb, String datee, String vacType, String numDays){
        name = n;
        id = idd;
        job = jobb;
        date = datee;
        vacationType = vacType;
        numberOfDays = numDays;
    }
    public String getName(){
        return name;
    }
    public String getID(){
        return id;
    }
    public String getJob(){
        return job;
    }
    public String getDate(){
        return date;
    }
    public String getVacType(){
        return vacationType;
    }
    public String getNumOfDays(){
        return numberOfDays;
    }
}
