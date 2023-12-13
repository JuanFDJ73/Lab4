/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class RegistroCompra implements Serializable {
    public static final long serialVersionUID = 1L;
    private int numero;
    private Proveedor proveedor;
    private ArrayList<Producto> listaCompra;
    private double totalPagar;
    
    public RegistroCompra(int numero, double totalPagar, Proveedor proveedor){
        this.numero = numero;
        this.totalPagar = totalPagar;
        this.proveedor = proveedor;
        listaCompra = new ArrayList<>();
    }
    
    public int getNumero() {
        return numero;
    }
    
    
    public Proveedor getProveedor() {
        return proveedor;
    }

    public double getTotalPagar(){
        return totalPagar;
    }
    public void setCliente(Proveedor proveedor) {
        this.proveedor = proveedor;
    }


    public ArrayList<Producto> getListaCompra() {
        return listaCompra;
    }

    public void setListaVenta(ArrayList<Producto> listaCompra) {
        this.listaCompra = listaCompra;
    }
}