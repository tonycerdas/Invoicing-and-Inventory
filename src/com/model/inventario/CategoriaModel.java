/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model.inventario;

public class CategoriaModel {

    public CategoriaModel() {
    }

    public CategoriaModel(int num_cateogoria, String descripcion) {
        this.num_cateogoria = num_cateogoria;
        this.descripcion = descripcion;
    }

    public int getNum_cateogoria() {
        return num_cateogoria;
    }

    public void setNum_cateogoria(int num_cateogoria) {
        this.num_cateogoria = num_cateogoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    int num_cateogoria;
    String descripcion;
}
