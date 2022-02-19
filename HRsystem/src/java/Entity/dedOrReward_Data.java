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
public class dedOrReward_Data {
          private String salID;
          private String name;
          private String idd;
          private String dedOrReward;
          private String date;
          private String amount;
          private String reason;
          
          public dedOrReward_Data(String sal,String n, String id, String deduction_reward, String datee, String am, String reas){
              salID = sal;
              name = n;
              idd = id;
              dedOrReward = deduction_reward;
              date = datee;
              amount = am;
              reason = reas;
          }
          
          public String getSalID(){
              return salID;
          }
          public String getName(){
              return name;
          }
          public String getID(){
              return idd;
          }
          public String getType(){
              return dedOrReward;
          }
          public String getDate(){
              return date;
          }
          public String getAmount(){
              return amount;
          }
          public String getReason(){
              return reason;
          }
}
