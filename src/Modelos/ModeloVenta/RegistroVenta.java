/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.ModeloVenta;
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
    private ArrayList<Venta> listaVenta;
    
    public RegistroVenta(){
        listaVenta = new ArrayList<>();
    }

    public ArrayList<Venta> getListaVenta() {
        return listaVenta;
    }

    public void setListaVenta(ArrayList<Venta> listaVenta) {
        this.listaVenta = listaVenta;
    }            
    
    
}
