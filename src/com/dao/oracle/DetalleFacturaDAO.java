/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao.oracle;

import com.conexion.oracle.ConexionOracle;
import com.model.inventario.DetalleFacturaModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class DetalleFacturaDAO {

    private ConexionOracle c;

    public DetalleFacturaDAO(ConexionOracle conn) {
        c = conn;
    }
    final String INSERT = "INSERT INTO detalle_factura(num_detalle_factura,num_factura,fecha_hora,cajero,num_caja,num_producto,cantidad,subtotal) values(?,?,?,?,?,?,?,?)";
    final String UPDATE = "UPDATE detalle_factura SET num_factura = ?,cajero = ?,num_caja=?,num_producto =?,cantidad = ?,subtotal = ? WHERE num_detalle_factura = ?";
    final String DELETE = "DELETE FROM detalle_factura WHERE num_detalle_factura = ?";
    final String GETALL = "SELECT num_detalle_factura,num_factura,fecha_hora,cajero,num_caja,num_producto,cantidad,subtotal FROM detalle_factura order by num_factura";
    final String GETONE = "SELECT num_detalle_factura,num_factura,fecha_hora,cajero,num_caja,num_producto,cantidad,subtotal FROM detalle_factura WHERE num_factura = ?";

    public void insertar(DetalleFacturaModel dfm) throws ParseException {
        PreparedStatement st = null;
        java.util.Date date = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        java.sql.Timestamp sqlTime = new java.sql.Timestamp(date.getTime());

        try {
            st = c.getConnection().prepareStatement(INSERT);
            st.setInt(1, dfm.getNum_detalle_factura());
            st.setInt(2, dfm.getNum_factura());
            st.setDate(3, sqlDate);
            st.setString(4, dfm.getCajero());
            st.setString(5,dfm.getNum_Caja());
            st.setInt(6, dfm.getNum_producto());
            st.setFloat(7, dfm.getCantidad());
            st.setFloat(8, dfm.getSubtotal());
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

    public void eliminar(int num_detalle_factura) {
        PreparedStatement st = null;
        try {
            st = c.getConnection().prepareStatement(DELETE);
            st.setInt(1, num_detalle_factura);
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

    public void modificar(int num_detalle_factura, int num_factura, String cajero,String num_caja, int num_producto, float cantidad, float subtotal, float total) {
        PreparedStatement st = null;
        try {
            st = c.getConnection().prepareStatement(UPDATE);
            st.setInt(1, num_factura);
            st.setString(2, cajero);
            st.setString(3, num_caja);
            st.setInt(4, num_producto);
            st.setFloat(5, cantidad);
            st.setFloat(6, subtotal);
            st.setInt(7, num_detalle_factura);
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

    public List<DetalleFacturaModel> getAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        List<DetalleFacturaModel> listaDetalleFactura = new ArrayList<>();
        try {
            st = c.getConnection().prepareStatement(GETALL);
            rs = st.executeQuery();
            while (rs.next()) {
                listaDetalleFactura.add(convertir(rs));
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
        return listaDetalleFactura;
    }

    public List<DetalleFacturaModel> getRegistro(int num_factura) {
        PreparedStatement st = null;
        ResultSet rs = null;
        list = new ArrayList<>();
        try {
            st = c.getConnection().prepareStatement(GETONE);
            st.setInt(1, num_factura);
            rs = st.executeQuery();
            while (rs.next()) {
                list.add(convertir(rs));
                System.out.println(list.size());
            }
        } catch (SQLException e) {
            System.out.println("Excepcion: " + e.getMessage());
        }
        return list;
    }

    private DetalleFacturaModel convertir(ResultSet rs) throws SQLException {
        String num_detalle_factura = rs.getString("num_detalle_factura");
        String num_factura = rs.getString("num_factura");
        String fecha_hora = rs.getString("fecha_hora");
        String cajero = rs.getString("cajero");
        String num_caja=rs.getString("num_caja");
        String num_producto = rs.getString("num_producto");
        String cantidad = rs.getString("cantidad");
        String subtotal = rs.getString("subtotal");

        int numdf = Integer.parseInt(num_detalle_factura);
        int numf = Integer.parseInt(num_factura);
        int nump = Integer.parseInt(num_producto);
        float numsub = Float.parseFloat(subtotal);
        int numcant = Integer.parseInt(cantidad);

        DetalleFacturaModel dfm = new DetalleFacturaModel(numdf, numf, fecha_hora, cajero,num_caja, nump, numcant, numsub);
        return dfm;
    }
    List<DetalleFacturaModel> list;
}
