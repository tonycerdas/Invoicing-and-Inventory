/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model.inventario;

/**
 *
 * @author HP
 */
public class DetalleTemporal {

    public DetalleTemporal(int num_detalle_factura, String fecha_hora, String cajero, float cantidadactual, int num_producto, float cantidad, float subtotal) {
        this.num_detalle_factura = num_detalle_factura;
        this.fecha_hora = fecha_hora;
        this.cajero = cajero;
        this.cantidadactual = cantidadactual;
        this.num_producto = num_producto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public int getNum_detalle_factura() {
        return num_detalle_factura;
    }

    public void setNum_detalle_factura(int num_detalle_factura) {
        this.num_detalle_factura = num_detalle_factura;
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

    public float getCantidadactual() {
        return cantidadactual;
    }

    public void setCantidadactual(float cantidadactual) {
        this.cantidadactual = cantidadactual;
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
    String fecha_hora;
    String cajero;
    float cantidadactual;
    int num_producto;
    float cantidad;
    float subtotal;
}
