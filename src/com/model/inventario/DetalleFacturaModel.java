/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model.inventario;

public class DetalleFacturaModel {

    

    public DetalleFacturaModel() {
    }

    public DetalleFacturaModel(int num_detalle_factura, int num_factura, String fecha_hora, String cajero,String num_caja, int num_producto, float cantidad, float subtotal) {
        this.num_detalle_factura = num_detalle_factura;
        this.num_factura = num_factura;
        this.fecha_hora = fecha_hora;
        this.cajero = cajero;
        this.num_caja=num_caja;
        this.num_producto = num_producto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public DetalleFacturaModel(int numdf, int numf, String fecha_hora, String cajero, String num_caja, int nump, int numcant, float numsub) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public DetalleFacturaModel(Integer valueOf, int x, String fecha_hora, String valueOf0, int num_producto, float cantidad, float subtotal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getNum_detalle_factura() {
        return num_detalle_factura;
    }

    public void setNum_detalle_factura(int num_detalle_factura) {
        this.num_detalle_factura = num_detalle_factura;
    }

    public int getNum_factura() {
        return num_factura;
    }

    public void setNum_factura(int num_factura) {
        this.num_factura = num_factura;
    }

    public String getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(String fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public String getCajero() {
        return cajero;
    }

    public void setCajero(String cajero) {
        this.cajero = cajero;
    }
    
    public String getNum_Caja(){
        return num_caja;
    }
    public void setNum_Caja(String num_caja){
        this.num_caja=num_caja;
    }
    public int getNum_producto() {
        return num_producto;
    }

    public void setNum_producto(int num_producto) {
        this.num_producto = num_producto;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }
    int num_detalle_factura;
    int num_factura;
    String fecha_hora;
    String cajero;
    String num_caja;
    int num_producto;
    float cantidad;
    float subtotal;
}
