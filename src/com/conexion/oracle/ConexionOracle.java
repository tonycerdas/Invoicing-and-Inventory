/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.conexion.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionOracle {

    private Connection conn = null;
    public String user;
    public String password;
    private String url = "jdbc:oracle:thin:@localhost:1521:orcl";

    public Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, user, password);
            conn.setSchema("INVENTARIO");
            conn.setAutoCommit(true);
           /* System.out.println("info: " conn);*/
            if (conn != null) {
                System.out.println("Conexión exitosa a " + conn.getSchema());
                setSuccess(1);
            } else {
                System.out.println("Conexión fallida");
                setSuccess(0);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Exception conexión " + e.getMessage());
        }
        return conn;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }
    
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    int success = 0;

}
