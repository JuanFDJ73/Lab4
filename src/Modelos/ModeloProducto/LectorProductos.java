/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.ModeloProducto;
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
public class LectorProductos {
    
    //variables que se muestran en pantalla
    
    private String nombreProducto;
    private String marcaProducto;
    private String precioProducto;
    private String cantidadProducto;
    private String idProducto;
    
    public String getProductName() {
        return nombreProducto;
    }

    public void setProductName(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(String marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    public String getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(String precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(String cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }
    
    public boolean leerProducto(String id) {
        
        try (BufferedReader br = new BufferedReader(new FileReader("src/archivos/archivoProductos"))) {
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
                        
                        this.nombreProducto = dataProductsArray[0];
                        this.marcaProducto = dataProductsArray[1];
                        this.precioProducto = dataProductsArray[2];
                        this.cantidadProducto = dataProductsArray[3];
                        this.idProducto = dataProductsArray[4];
                              
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
