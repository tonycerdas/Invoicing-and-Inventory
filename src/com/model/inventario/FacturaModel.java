/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model.inventario;

public class FacturaModel {

    public FacturaModel() {
    }

    public FacturaModel(int num_factura, float total) {
        this.num_factura = num_factura;
        this.total = total;
    }

    public int getNum_factura() {
        return num_factura;
    }

    public void setNum_factura(int num_factura) {
        this.num_factura = num_factura;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

   
    
      int num_factura;
      float total;
  
}
