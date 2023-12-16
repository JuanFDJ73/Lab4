/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.ModeloProducto;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ModificarEliminarProducto {
    
    private String nombreProducto;
    private String marcaProducto;
    private String idProducto;
    private String precioProducto;
    private String cantidadProducto;
        
    String rutaArchivoProductos = "src/archivos/archivoProductos";

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(String marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(String precioProducto) {
        this.precioProducto = precioProducto;
    }
    
    public String getCantidadProducto(){
        return cantidadProducto;
    }
    
    public void setCantidadProducto(String cantidadProducto){
        this.cantidadProducto = cantidadProducto;
    }

    public String getRutaArchivoClientes() {
        return rutaArchivoProductos;
    }

    public void setRutaArchivoClientes(String rutaArchivoProductos) {
        this.rutaArchivoProductos = rutaArchivoProductos;
    }
    
    public boolean actualizarProducto(String id) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoProductos))) {

            String line;
            ArrayList<String> updatedProductsList = new ArrayList<>();
            boolean clientFound = false;

            while ((line = br.readLine()) != null) {
                String[] dataArray = line
                        .replaceAll("[\\[\\]]", "")
                        .split(", ");

                for (String data : dataArray) {
                    String[] keyValue = data.split(": ");

                    if (keyValue[1].trim().equals(id)) {
                        dataArray[0] = "Nombre: " + nombreProducto;
                        dataArray[1] = "Marca: " + marcaProducto;
                        dataArray[2] = "Precio: " + precioProducto;
                        clientFound = true;
                    }
                }

                updatedProductsList.add(String.join(", ", dataArray));
            }

            if (clientFound) {
                // Escribe la lista actualizada en el archivo de texto
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivoProductos))) {
                    for (String updatedProduct : updatedProductsList) {
                        writer.write(updatedProduct);
                        writer.newLine();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return false; // Manejo de excepciones al escribir en el archivo
                }

                System.out.println("Producto actualizado:");
                for (String entry : updatedProductsList) {
                    System.out.println("Datos del producto: " + entry);
                }

                return true; // Indica que se encontró la cédula y se actualizó el cliente
            } else {
                System.out.println("Producto no encontrado.");
                return false; // Indica que no se encontró la cédula
            }

        } 
        catch (IOException e) {
            e.printStackTrace();
            return false; // Manejo de excepciones al leer el archivo
        }
    }
    
    public boolean eliminarProducto(String idProducto) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoProductos))) {

            String line;
            ArrayList<String> dealerList = new ArrayList<>();

            // Lee el archivo y almacena cada línea en el ArrayList
            while ((line = br.readLine()) != null) {
                dealerList.add(line);
            }

            // Usar un iterador para recorrer la lista y eliminar elementos de manera segura
            Iterator<String> iterator = dealerList.iterator();
            while (iterator.hasNext()) {
                String dealerData = iterator.next();
                String[] dataArray = dealerData
                        .replaceAll("[\\[\\]]", "") // Elimina corchetes "[" y "]"
                        .split(", "); // Suponiendo que los datos están separados por ", "

                for (String data : dataArray) {
                    String[] keyValue = data.split(": ");
                    if (keyValue[1].trim().equals(idProducto)) {
                        // Elimina el proveedor usando el iterador
                        int result = JOptionPane.showConfirmDialog(null, "Se eliminaran los datos del producto, ¿Está de acuerdo?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if(result == JOptionPane.YES_OPTION){
                           iterator.remove(); 
                        }else {
                            break;
                        }

                        // Escribe el ArrayList actualizado en el archivo de texto
                        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivoProductos))) {
                            for (String updatedDealer : dealerList) {
                                writer.write(updatedDealer);
                                writer.newLine();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return true; // Indica que se encontró la cédula y se eliminó el proveedor
                    }
                }
            }

            JOptionPane.showMessageDialog(null, "Producto no encontrado.");
            return false; // Indica que no se encontró la cédula
        } catch (IOException e) {
            e.printStackTrace();
            return false; // Manejo de excepciones
        }
    }
}