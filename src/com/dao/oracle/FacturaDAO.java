/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao.oracle;

import com.conexion.oracle.ConexionOracle;
import com.model.inventario.FacturaModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacturaDAO {

    private ConexionOracle c;

    public FacturaDAO(ConexionOracle conn){
        c = conn;
    }
    final String INSERT = "INSERT INTO factura(num_factura,total) values(?,?)";
    final String DELETE = "DELETE FROM factura WHERE num_factura = ?";
    final String GETALL = "SELECT num_factura,total FROM factura";
    final String GETONE = "SELECT num_factura,total FROM factura WHERE num_factura = ?";

    public void insertar(FacturaModel fm) {
        PreparedStatement st = null;
        try {
            st = c.getConnection().prepareStatement(INSERT);
            st.setInt(1, fm.getNum_factura());
            st.setFloat(2, fm.getTotal());
            st.executeUpdate();
            System.out.println("Insert exitoso");
        } catch (SQLException e) {
            System.out.println("Excepcion 1: " + e.getMessage());
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    System.out.println("Excepcion 2: " + e.getMessage());
                }
            }
        }
    }

    public void eliminar(int num_factura) {
        PreparedStatement st = null;
        try {
            st = c.getConnection().prepareStatement(DELETE);
            st.setInt(1, num_factura);
            st.executeUpdate();
            System.out.println("Delete exitoso");
        } catch (SQLException e) {
            System.out.println("Excepcion 1: " + e.getMessage());
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    System.out.println("Excepcion 2: " + e.getMessage());
                }
            }

        }

    }

    public List<FacturaModel> getAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        List<FacturaModel> listaFacturas = new ArrayList<>();
        try {
            st = c.getConnection().prepareStatement(GETALL);
            rs = st.executeQuery();
            while (rs.next()) {
                listaFacturas.add(convertir(rs));
            }
        } catch (SQLException e) {
            System.out.println("Excepcion 1: " + e.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println("Excepcion 2:" + e.getMessage());
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    System.out.println("Excepcion 3:" + e.getMessage());
                }
            }
        }
        return listaFacturas;
    }

    public FacturaModel getRegistro(int num_factura) {
        PreparedStatement st = null;
        ResultSet rs = null;
        FacturaModel fm = null;
        try {
            st = c.getConnection().prepareStatement(GETONE);
            st.setInt(1, num_factura);
            rs = st.executeQuery();
            if (rs.next()) {
                fm = convertir(rs);
            } else {
                System.out.println("Registro no encontrado");
            }
        } catch (SQLException e) {
            System.out.println("Excepcion: " + e.getMessage());
        }
        return fm;
    }

    private FacturaModel convertir(ResultSet rs) throws SQLException {
        String num_factura = rs.getString("num_factura");
        float total = Float.valueOf(rs.getString("total"));
        int numcasteo = Integer.parseInt(num_factura);
        FacturaModel fm = new FacturaModel(numcasteo, total);
        return fm;
    }

}
