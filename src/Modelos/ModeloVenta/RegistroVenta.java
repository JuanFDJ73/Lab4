/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.ModeloVenta;

import Modelos.ModeloProducto.Producto;
import Modelos.ModeloCliente.CrearCliente;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author Usuario
 */
public class RegistroVenta implements Serializable {
    public static final long serialVersionUID = 1L;
    private int numero;
    private CrearCliente cliente;
    private ArrayList<Producto> listaVenta;
    private double totalPagar;
    
    public RegistroVenta(int numero, double totalPagar, CrearCliente cliente){
        this.numero = numero;
        this.totalPagar = totalPagar;
        this.cliente = cliente;
        listaVenta = new ArrayList<>();
    }
    
    public int getNumero() {
        return numero;
    }
    
    
    public CrearCliente getCliente() {
        return cliente;
    }

    public double getTotalPagar(){
        return totalPagar;
    }
    public void setCliente(CrearCliente cliente) {
        this.cliente = cliente;
    }


    public ArrayList<Producto> getListaVenta() {
        return listaVenta;
    }

    public void setListaVenta(ArrayList<Producto> listaVenta) {
        this.listaVenta = listaVenta;
    }            
    
    public void addProductoVenta(Producto productoSelecc){
        
    }
    
    private boolean estaIncluido(String nombre, DefaultListModel modelo){
        
        boolean existe = false;
        if(modelo.size() != 0){            
            for (int i = 0; i < modelo.size(); i++){
                String nombreExistente = modelo.get(i).toString();
                StringTokenizer st = new StringTokenizer(nombreExistente);
                if (nombre.equalsIgnoreCase(st.nextElement().toString())){
                    existe = true;
                    i = modelo.size();
                }
            }            
        }        
        return existe;
    }
    
    /*
    @Override
    public String toString(){
        return "Cotizacion No. " + getNumero() + "\nDolares " + getCotizacionDolares();
    }
    */
    
    
    //private void setTotalPagar(){}
}
