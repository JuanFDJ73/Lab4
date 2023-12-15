/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.ModeloProducto;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class EliminarProducto {
    String rutaArchivoProductos = "src/main/java/textFiles/archivoProductos";
    
    private String nombreProductoEliminado;
    private String marcaProductoEliminado;
    private String precioProductoEliminado;
    private String cantidadProductoEliminado;
    private String idProductoEliminado;

    public String getNombreProductoEliminado() {
        return nombreProductoEliminado;
    }

    public void setNombreProductoEliminado(String nombreProductoEliminado) {
        this.nombreProductoEliminado = nombreProductoEliminado;
    }

    public String getMarcaProductoEliminado() {
        return marcaProductoEliminado;
    }

    public void setMarcaProductoEliminado(String marcaProductoEliminado) {
        this.marcaProductoEliminado = marcaProductoEliminado;
    }

    public String getIdProductoEliminado() {
        return idProductoEliminado;
    }

    public void setIdProductoEliminado(String idProductoEliminado) {
        this.idProductoEliminado = idProductoEliminado;
    }

    public String getPrecioProductoEliminado() {
        return precioProductoEliminado;
    }

    public void setPrecioProductoEliminado(String precioProductoEliminado) {
        this.precioProductoEliminado = precioProductoEliminado;
    }
    
    public String getCantidadProductoEliminado(){
        return cantidadProductoEliminado;
    }
    
    public void setCantidadProductoEliminado(String cantidadProductoEliminado){
        this.cantidadProductoEliminado = cantidadProductoEliminado;
    }

    public String getRutaArchivoProductos() {
        return rutaArchivoProductos;
    }

    public void setRutaArchivoProductos(String rutaArchivoProductos) {
        this.rutaArchivoProductos = rutaArchivoProductos;
    }
    

    public boolean eliminarProducto(String id){
        
        try (BufferedReader br = new BufferedReader(new FileReader("src/archovos/archivoClientes"))) {

        String line;
        ArrayList<String> clientList = new ArrayList<>();

        // Lee el archivo y almacena cada línea en el ArrayList
        while ((line = br.readLine()) != null) {
            clientList.add(line);
        }

        // Busca la cédula en el ArrayList
        for (int i = 0; i < clientList.size(); i++) {
            
            String clientData = clientList.get(i);
            String[] dataArray = clientData
                    .replaceAll("[\\[\\]]", "") // Elimina corchetes "[" y "]"
                    .split(", "); // Suponiendo que los datos están separados por ", "

                for (String data : dataArray) {
                    String[] keyValue = data.split(": ");
                    if (keyValue[0].trim().equals("Identificación") && keyValue[1].trim().equals(id)) {
                        // Elimina el cliente del ArrayList
                        clientList.remove(i);

                        // Escribe el ArrayList actualizado en el archivo de texto
                        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/archivos/archivosClientes"))) {
                            
                            for (String updatedClient : clientList) {
                                writer.write(updatedClient);
                                writer.newLine();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        System.out.println("Cliente eliminado:");
                            for (String entry : dataArray) {
                                
                                System.out.println("Datos del cliente: " + entry);


                            }
                            
                            this.nombreProductoEliminado = dataArray[0];
                            this.marcaProductoEliminado = dataArray[1];
                            this.idProductoEliminado = dataArray[2];
                            this.precioProductoEliminado = dataArray[3];
                            this.cantidadProductoEliminado = dataArray[4];

                            return true; // Indica que se encontró la cédula y se eliminó el cliente
                        }
                    }
                }

                    JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
                    return false; // Indica que no se encontró la cédula
        }catch (IOException e) {
            e.printStackTrace();
        return false; // Manejo de excepciones
    }
}
}