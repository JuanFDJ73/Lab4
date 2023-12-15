/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.ModeloProveedor;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class LectorProveedor {
    private String nombreProveedor;
    private String emailProveedor;
    private String RUT;
    private String nombreProductoProveedor;
    
    String rutaArchivoProveedores = "src/archivos/archivoProveedores"; 

    
    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombre(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getEmailProveedor() {
        return emailProveedor;
    }

    public void setEmailProveedor(String emailProveedor) {
        this.emailProveedor = emailProveedor;
    }
    
    public String getRUT(){
        return RUT;
    }
    
    public void setRUT(String RUT){
        this.RUT = RUT;
    }
    
    public String getNombreProductoProveedor(){
        return nombreProductoProveedor;
    }
    
    public void setNombreProductoProveedor(String nombreProductoProveedor){
        this.nombreProductoProveedor = nombreProductoProveedor;
    }
    
    public String getRutaArchivoProveedores() {
        return rutaArchivoProveedores;
    }

    public void setRutaArchivoProveedores(String rutaArchivoProveedores) {
        this.rutaArchivoProveedores = rutaArchivoProveedores;
    }
    
    public boolean leerProducto(String id) {
        
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoProveedores))) {
            String line;
            ArrayList<String> listaProductos = new ArrayList<>();

            // Lee el archivo y almacena cada línea en el ArrayList
            while ((line = br.readLine()) != null) {
                listaProductos.add(line);
            }

            // Busca la cédula en el ArrayList
            for (String productsData : listaProductos) {
                String[] dataProductsArray = productsData
                        .replaceAll("[\\[\\]]", "") // Elimina corchetes "[" y "]"
                        .split(", "); // Suponiendo que los datos están separados por ", "

                for (String data : dataProductsArray) {
                    String[] keyValue = data.split(": ");
                    
                    if (keyValue[0].trim().equals("Id") && keyValue[1].trim().equals(id)) {
                        // Si se encuentra la cédula, muestra los datos
                        
                        this.nombreProveedor = dataProductsArray[0];
                        this.emailProveedor = dataProductsArray[1];
                        this.RUT = dataProductsArray[2];
                        this.nombreProductoProveedor = dataProductsArray[3];
                              
                        return true; // Indica que se encontró la cédula
                    }
                }
            }

            JOptionPane.showMessageDialog(null,"Producto no encontrado.");
            return false; // Indica que no se encontró el id

        } catch (IOException e) {
            e.printStackTrace();
            return false; // Manejo de excepciones
        }
    }
}
