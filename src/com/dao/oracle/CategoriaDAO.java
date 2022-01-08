/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao.oracle;

import com.conexion.oracle.ConexionOracle;
import com.model.inventario.CategoriaModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    private ConexionOracle c;

    public CategoriaDAO(ConexionOracle conn) {
        c = conn;
    }
    final String INSERT = "INSERT INTO categoria(num_categoria,descripcion) values(?,?)";
    final String UPDATE = "UPDATE categoria SET descripcion = ? WHERE num_categoria = ?";
    final String DELETE = "DELETE FROM categoria WHERE num_categoria = ?";
    final String GETALL = "SELECT num_categoria,descripcion FROM categoria  order by num_categoria";
    final String GETONE = "SELECT num_categoria,descripcion FROM categoria WHERE num_categoria = ?";

    public void insertar(CategoriaModel cm) {
        PreparedStatement st = null;
        try {
            st = c.getConnection().prepareStatement(INSERT);
            st.setInt(1, cm.getNum_cateogoria());
            st.setString(2, cm.getDescripcion());
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

    public void eliminar(int num_categoria) {
        PreparedStatement st = null;
        try {
            st = c.getConnection().prepareStatement(DELETE);
            st.setInt(1, num_categoria);
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

    public void modificar(int num_categoria, String descripcion) {
        PreparedStatement st = null;
        try {
            st = c.getConnection().prepareStatement(UPDATE);
            st.setString(1, descripcion);
            st.setInt(2, num_categoria);
            st.executeUpdate();
            System.out.println("Update exitoso");
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

    public List<CategoriaModel> getAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        List<CategoriaModel> listaCategorias = new ArrayList<>();
        try {
            st = c.getConnection().prepareStatement(GETALL);
            rs = st.executeQuery();
            while (rs.next()) {
                listaCategorias.add(convertir(rs));
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
        return listaCategorias;
    }

    public CategoriaModel getRegistro(int num_categoria) {
        PreparedStatement st = null;
        ResultSet rs = null;
        CategoriaModel cm = null;
        try {
            st = c.getConnection().prepareStatement(GETONE);
            st.setInt(1, num_categoria);
            rs = st.executeQuery();
            if (rs.next()) {
                cm = convertir(rs);
            } else {
                System.out.println("Registro no encontrado");
            }
        } catch (SQLException e) {
            System.out.println("Excepcion: " + e.getMessage());
        }
        return cm;
    }

    private CategoriaModel convertir(ResultSet rs) throws SQLException {
        String num_categoria = rs.getString("num_categoria");
        String descripcion = rs.getString("descripcion");
        int numcasteo = Integer.parseInt(num_categoria);
        CategoriaModel cm = new CategoriaModel(numcasteo, descripcion);
        return cm;
    }
}
