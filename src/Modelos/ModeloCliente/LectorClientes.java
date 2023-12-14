/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.ModeloCliente;
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
public class LectorClientes{
    
    private String idCliente;
    
    //Variables que se mostraran en pantalla
    
    private String nombre;
    private String apellido;
    private String email;
    private String id;

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCel() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean readClient(String id) {
        
        try (BufferedReader br = new BufferedReader(new FileReader("src/archivos/archivoClientes"))) {
            String line;
            ArrayList<String> clientList = new ArrayList<>();

            // Lee el archivo y almacena cada línea en el ArrayList
            while ((line = br.readLine()) != null) {
                clientList.add(line);
            }

            // Busca la cédula en el ArrayList
            for (String clientData : clientList) {
                String[] dataArray = clientData
                        .replaceAll("[\\[\\]]", "") // Elimina corchetes "[" y "]"
                        .split(", "); // Suponiendo que los datos están separados por ", "

                for (String data : dataArray) {
                    String[] keyValue = data.split(": ");
                    if (keyValue[0].trim().equals("Identificación") && keyValue[1].trim().equals(id)) {
                        // Si se encuentra la cédula, muestra los datos
                        //System.out.println("Datos del cliente:");
                        
                        for (String entry : dataArray) {
                            
                            System.out.println("Datos del cliente: " + entry);
                        }
                            this.nombre = dataArray[0];
                            this.apellido = dataArray[1];
                            this.id = dataArray[2];
                            this.email = dataArray[3];
                            
                            System.out.println(nombre);
                            System.out.println(apellido);
                            System.out.println(id);
                            System.out.println(email);
                            
                        return true; // Indica que se encontró la cédula
                    }
                }
            }

            JOptionPane.showMessageDialog(null,"Cliente no encontrado.");
            return false; // Indica que no se encontró la cédula

        } catch (IOException e) {
                e.printStackTrace();
            return false; // Manejo de excepciones
        }
    }
    
    
}