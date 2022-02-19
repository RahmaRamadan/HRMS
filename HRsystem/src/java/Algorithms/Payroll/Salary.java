/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.Payroll;



public class Salary {
    public static int calculateNetpay(int gross,int deductions,int cash) {
        int total ;
        total = gross - deductions + cash;
        return total;
  }
}