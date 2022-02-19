/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author egypt2
 */
public class DatabaseConnection {

    static Connection con;

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/hr_system", "root", "myPassword");
    }
}


