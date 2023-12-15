/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.ModeloProveedor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ActualizarProveedor {
    private String nombreProveedor;
    private String emailProveedor;
    private String RUT;
    private String nombreProductoProveedor;
    
    File archivoProveedores;
    
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
    
    public String getRutaArchivoProveedores() {
        return rutaArchivoProveedores;
    }

    public void setRutaArchivoProveedores(String rutaArchivoProveedores) {
        this.rutaArchivoProveedores = rutaArchivoProveedores;
    }
    
    public boolean actualizarProveedor(String id) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoProveedores))) {

            String line;
            ArrayList<String> updatedClientList = new ArrayList<>();
            boolean clientFound = false;

            while ((line = br.readLine()) != null) {
                String[] dataArray = line
                        .replaceAll("[\\[\\]]", "")
                        .split(", ");

                for (String data : dataArray) {
                    String[] keyValue = data.split(": ");

                    if (keyValue[0].trim().equals("Identificación") && keyValue[1].trim().equals(id)) {
                        dataArray[0] = "Nombre: " + nombreProveedor;
                        dataArray[1] = "RUT: " + RUT;
                        dataArray[3] = "email: " + emailProveedor;
                        clientFound = true;
                    }
                }

                updatedClientList.add(String.join(", ", dataArray));
            }

            if (clientFound) {
                // Escribe la lista actualizada en el archivo de texto
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivoProveedores))) {
                    for (String updatedClient : updatedClientList) {
                        writer.write(updatedClient);
                        writer.newLine();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return false; // Manejo de excepciones al escribir en el archivo
                }

                System.out.println("Cliente actualizado:");
                for (String entry : updatedClientList) {
                    System.out.println("Datos del cliente: " + entry);
                }

                return true; // Indica que se encontró la cédula y se actualizó el cliente
            } else {
                System.out.println("Cliente no encontrado.");
                return false; // Indica que no se encontró la cédula
            }

        } catch (IOException e) {
            e.printStackTrace();
            return false; // Manejo de excepciones al leer el archivo
        }
    }
}
