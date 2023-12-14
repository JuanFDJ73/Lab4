/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.ModeloCliente;
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
public class ActualizarCliente {
    
    private String nombreActualizado;
    private String apellidoActualizado;
    private String idActualizada;
    private String emailActualizado;
        
    String rutaArchivoClientes = "src/archivos/archivoClientes";

    public String getNombreActualizado() {
        return nombreActualizado;
    }

    public void setNombreActualizado(String nombreActualizado) {
        this.nombreActualizado = nombreActualizado;
    }

    public String getApellidoActualizado() {
        return apellidoActualizado;
    }

    public void setApellidoActualizado(String apellidoActualizado) {
        this.apellidoActualizado = apellidoActualizado;
    }

    public String getIdActualizada() {
        return idActualizada;
    }

    public void setIdActualizada(String idActualizada) {
        this.idActualizada = idActualizada;
    }

    public String getEmailActualizado() {
        return emailActualizado;
    }

    public void setEmailActualizado(String emailActualizado) {
        this.emailActualizado = emailActualizado;
    }

    public String getRutaArchivoClientes() {
        return rutaArchivoClientes;
    }

    public void setRutaArchivoClientes(String rutaArchivoClientes) {
        this.rutaArchivoClientes = rutaArchivoClientes;
    }
    
    public boolean actualizarCliente(String id) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoClientes))) {

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
                        dataArray[0] = "Nombre: " + nombreActualizado;
                        dataArray[1] = "Apellido: " + apellidoActualizado;
                        dataArray[3] = "email: " + emailActualizado;
                        clientFound = true;
                    }
                }

                updatedClientList.add(String.join(", ", dataArray));
            }

            if (clientFound) {
                // Escribe la lista actualizada en el archivo de texto
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivoClientes))) {
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