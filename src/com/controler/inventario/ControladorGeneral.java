/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controler.inventario;

import com.conexion.oracle.ConexionOracle;
import com.dao.oracle.CategoriaDAO;
import com.dao.oracle.DetalleFacturaDAO;
import com.dao.oracle.FacturaDAO;
import com.dao.oracle.ProductoDAO;
import com.dao.oracle.UsuarioDAO;

public class ControladorGeneral {

    public ControladorGeneral(ConexionOracle conn) {
        init(conn);
    }

    private void init(ConexionOracle conn) {
        categoria = new CategoriaDAO(conn);
        detalle_factura = new DetalleFacturaDAO(conn);
        factura = new FacturaDAO(conn);
        producto = new ProductoDAO(conn);
        usuario = new UsuarioDAO(conn);
    }

    public CategoriaDAO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDAO categoria) {
        this.categoria = categoria;
    }

    public DetalleFacturaDAO getDetalle_factura() {
        return detalle_factura;
    }

    public void setDetalle_factura(DetalleFacturaDAO detalle_factura) {
        this.detalle_factura = detalle_factura;
    }

    public FacturaDAO getFactura() {
        return factura;
    }

    public void setFactura(FacturaDAO factura) {
        this.factura = factura;
    }

    public ProductoDAO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDAO producto) {
        this.producto = producto;
    }

    public UsuarioDAO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDAO usuario) {
        this.usuario = usuario;
    }
    CategoriaDAO categoria;
    DetalleFacturaDAO detalle_factura;
    FacturaDAO factura;
    ProductoDAO producto;
    UsuarioDAO usuario;
}
