/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao.oracle;

import com.conexion.oracle.ConexionOracle;
import com.model.inventario.ProductoModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    private ConexionOracle c;

    public ProductoDAO(ConexionOracle conn){
        c = conn;
    }
    final String INSERT = "INSERT INTO producto(num_producto,num_categoria,ean,plu,descripcion,precio,peso,cantidad) values(?,?,?,?,?,?,?,?)";
    final String UPDATE = "UPDATE producto SET num_categoria = ?,ean = ?,plu = ?,descripcion = ?,precio = ?,peso = ? ,cantidad = ? WHERE num_producto = ?";
    final String DELETE = "DELETE FROM producto WHERE num_producto = ?";
    final String GETALL = "SELECT num_producto,num_categoria,ean,plu,descripcion,precio,peso,cantidad FROM producto  order by num_producto";
    final String GETONE = "SELECT num_producto,num_categoria,ean,plu,descripcion,precio,peso,cantidad FROM producto WHERE num_producto = ?";
    final String UPDATECANTIDAD = "UPDATE producto SET cantidad = ? WHERE num_producto = ?";

    public void insertar(ProductoModel pm) {
        PreparedStatement st = null;
        try {
            st = c.getConnection().prepareStatement(INSERT);
            st.setInt(1, pm.getNum_producto());
            st.setInt(2, pm.getNum_categoria());
            st.setInt(3, pm.getEan());
            st.setInt(4, pm.getPlu());
            st.setString(5, pm.getDescripcion());
            st.setFloat(6, pm.getPrecio());
            st.setFloat(7, pm.getPeso());
            st.setInt(8, pm.getCantidad());
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

    public void eliminar(int num_producto) {
        PreparedStatement st = null;
        try {
            st = c.getConnection().prepareStatement(DELETE);
            st.setInt(1, num_producto);
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

    public void modificar(int num_producto, int num_categoria, int ean, int plu, float peso, String descripcion, float precio, int cantidad) {
        PreparedStatement st = null;
        try {
            st = c.getConnection().prepareStatement(UPDATE);
            st.setInt(1, num_categoria);
            st.setInt(2, ean);
            st.setInt(3, plu);
            st.setString(4, descripcion);
            st.setFloat(5, precio);
            st.setFloat(6, peso);
            st.setInt(7, cantidad);
            st.setInt(8, num_producto);
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

    public void modificarCantidad(int num_producto, float cantidad) {
        PreparedStatement st = null;
        try {
            st = c.getConnection().prepareStatement(UPDATECANTIDAD);
            st.setFloat(1, cantidad);
            st.setInt(2, num_producto);
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

    public List<ProductoModel> getAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        List<ProductoModel> listaProductos = new ArrayList<>();
        try {
            st = c.getConnection().prepareStatement(GETALL);
            rs = st.executeQuery();
            while (rs.next()) {
                listaProductos.add(convertir(rs));
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
        return listaProductos;
    }

    public ProductoModel getRegistro(int num_producto) {
        PreparedStatement st = null;
        ResultSet rs = null;
        ProductoModel pm = null;
        try {
            st = c.getConnection().prepareStatement(GETONE);
            st.setInt(1, num_producto);
            rs = st.executeQuery();
            if (rs.next()) {
                pm = convertir(rs);
            } else {
                System.out.println("Registro no encontrado");
            }
        } catch (SQLException e) {
            System.out.println("Excepcion: " + e.getMessage());
        }
        return pm;
    }

    private ProductoModel convertir(ResultSet rs) throws SQLException {
        String num_producto = rs.getString("num_producto");
        String num_categoria = rs.getString("num_categoria");
        String ean = rs.getString("ean");
        String plu = rs.getString("plu");
        String descripcion = rs.getString("descripcion");
        String precio = rs.getString("precio");
        String peso = rs.getString("peso");
        String cantidad = rs.getString("cantidad");

        int nump = Integer.parseInt(num_producto);
        int numc = Integer.parseInt(num_categoria);
        int numean = Integer.parseInt(ean);
        int numplu = Integer.parseInt(plu);
        float numpeso = Float.parseFloat(peso);
        float numprecio = Float.parseFloat(precio);
        int numcant = Integer.parseInt(cantidad);

        ProductoModel pm = new ProductoModel(nump, numc, numean, numplu, numpeso, descripcion, numprecio, numcant);
        return pm;
    }

}
