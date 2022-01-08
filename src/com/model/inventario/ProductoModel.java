/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model.inventario;

public class ProductoModel {

    public ProductoModel() {
    }

    public ProductoModel(int num_producto, int num_categoria, int ean, int plu, float peso, String descripcion, float precio, int cantidad) {
        this.num_producto = num_producto;
        this.num_categoria = num_categoria;
        this.ean = ean;
        this.plu = plu;
        this.peso = peso;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getNum_producto() {
        return num_producto;
    }

    public void setNum_producto(int num_producto) {
        this.num_producto = num_producto;
    }

    public int getNum_categoria() {
        return num_categoria;
    }

    public void setNum_categoria(int num_categoria) {
        this.num_categoria = num_categoria;
    }

    public int getEan() {
        return ean;
    }

    public void setEan(int ean) {
        this.ean = ean;
    }

    public int getPlu() {
        return plu;
    }

    public void setPlu(int plu) {
        this.plu = plu;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

  
    int num_producto;
    int num_categoria;
    int ean;
    int plu;
    float peso;
    String descripcion;
    float precio;
    int cantidad;

}
