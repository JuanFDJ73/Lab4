/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.ModeloVenta;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Venta implements Serializable {
    private String nombreProducto;
    private String idCliente;
    String rutaArchivoProductos = "src/archivos/archivoProductos";
    String rutaArchivoClientes = "src/archivos/archivoClientes";

    
    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    
    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
    
    public boolean validarProducto(String nombreProducto){
        
        
        
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoProductos))) {
            String line;
            ArrayList<String> productsList = new ArrayList<>();

            // Lee el archivo y almacena cada línea en el ArrayList
            while ((line = br.readLine()) != null) {
                productsList.add(line);
            }

            // Busca el nombre en el ArrayList
            for (String productsData : productsList) { 
                String[] dataArray = productsData
                        .replaceAll("[\\[\\]]", "") // Elimina corchetes "[" y "]"
                        .split(", "); // Suponiendo que los datos están separados por ", "

                for (String data : dataArray) {
                    String[] keyValue = data.split(": ");
                    if (keyValue[1].trim().equals(nombreProducto)) {
                        
                        // Si se encuentra el nombre, muestra los datos
                        
                        for (String entry : dataArray) {
                            
                            System.out.println("Datos del producto: " + entry);
                        }
                        
                        JOptionPane.showMessageDialog(null,"El producto existe");
                            
                        return true; // Indica que se encontró el producto
                    }
                }
            }

            JOptionPane.showMessageDialog(null,"Producto no encontrado.");
            return false; // Indica que no se encontró el producto

        } catch (IOException e) {
                e.printStackTrace();
            return false; // Manejo de excepciones
        }
    }
    
    public boolean validarcliente(String idCliente){
        
        
        
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoClientes))) {
            String line;
            ArrayList<String> productsList = new ArrayList<>();

            // Lee el archivo y almacena cada línea en el ArrayList
            while ((line = br.readLine()) != null) {
                productsList.add(line);
            }

            // Busca el nombre en el ArrayList
            for (String productsData : productsList) { 
                String[] dataArray = productsData
                        .replaceAll("[\\[\\]]", "") // Elimina corchetes "[" y "]"
                        .split(", "); // Suponiendo que los datos están separados por ", "

                for (String data : dataArray) {
                    String[] keyValue = data.split(": ");
                    if (keyValue[1].trim().equals(idCliente)) {
                        
                        // Si se encuentra el nombre, muestra los datos
                        
                        for (String entry : dataArray) {
                            
                            System.out.println("Datos del producto: " + entry);
                        }
                        
                        JOptionPane.showMessageDialog(null,"El producto existe");
                            
                        return true; // Indica que se encontró el producto
                    }
                }
            }

            JOptionPane.showMessageDialog(null,"Producto no encontrado.");
            return false; // Indica que no se encontró el producto

        } catch (IOException e) {
                e.printStackTrace();
            return false; // Manejo de excepciones
        }
    }
    
}
