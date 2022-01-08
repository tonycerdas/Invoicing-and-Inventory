/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao.oracle;

import com.conexion.oracle.ConexionOracle;
import com.model.inventario.CategoriaModel;
import com.model.inventario.UsuarioModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    private ConexionOracle c;
    final String GETONE = "SELECT cedula, password, tipo FROM usuario WHERE password = ?";

    public UsuarioDAO(ConexionOracle conn) {
        c = conn;
    }

    public UsuarioModel getRegistro(String password) {
        PreparedStatement st = null;
        ResultSet rs = null;
        UsuarioModel um = null;
        try {
            st = c.getConnection().prepareStatement(GETONE);
            st.setString(1, password);
            rs = st.executeQuery();
            System.out.println("PASS: " + password);
            if (rs.next()) {
                um = convertir(rs);
            } else {
                System.out.println("Registro no encontrado");
            }
        } catch (SQLException e) {
            System.out.println("Excepcion: user " + e.getMessage());
        }
        return um;
    }

    private UsuarioModel convertir(ResultSet rs) throws SQLException {
        int usuario = Integer.valueOf(rs.getString("cedula"));
        String password = rs.getString("password");
        String tipo = rs.getString("tipo");
        UsuarioModel um = new UsuarioModel(usuario, password, tipo);
        return um;
    }
}
