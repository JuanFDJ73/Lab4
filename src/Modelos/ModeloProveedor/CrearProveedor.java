/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.ModeloProveedor;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class CrearProveedor {
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
    
    public void crearArchivoTexto(){
        
        try{
            
            archivoProveedores = new File(rutaArchivoProveedores);
            
            if(!archivoProveedores.exists()){
                
                archivoProveedores.createNewFile();
                System.out.println("archivo creado, la ruta es: " + archivoProveedores.getAbsolutePath());
            }
        }
        
        catch(IOException e){
            
            System.err.println("Error al crear o escribir archivo " + e.getMessage());
            
        }
    
    }
    
    //Metodo para agregar los datos de los distribuidores a una coleccion y al archivo de texto
   public void agragarColeccionProveedores() {

        ArrayList<ArrayList<String>> principalDealersArray = new ArrayList<>();
        ArrayList<String> dataDealersArray = new ArrayList<>();

        dataDealersArray.add(this.nombreProveedor);
        dataDealersArray.add(this.emailProveedor);
        dataDealersArray.add(this.RUT);
        dataDealersArray.add(this.nombreProductoProveedor);

        // Verificar si la cédula ya existe en el archivo
        
        if (isRUTUnico(this.RUT)) {
            principalDealersArray.add(dataDealersArray);
            System.out.println("Los siguientes datos fueron guardados " + principalDealersArray);

            // Escribir en el archivo solo si la cédula es única
            try {
                FileWriter fileWriter = new FileWriter(rutaArchivoProveedores, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(String.valueOf(dataDealersArray));
                bufferedWriter.newLine();  // Agregar una nueva línea para cada usuario
                bufferedWriter.close();
                JOptionPane.showMessageDialog(null,"Datos del distribuidor almacenados");

            } catch (IOException e) {
                System.err.println("Error al añadir texto al archivo: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null,"La cédula ya existe. No se puede agregar el distriubidor.");
        }
    }

    // Método para verificar si la cédula ya existe en el archivo
    private boolean isRUTUnico(String cedula) {
        
        try (Scanner scanner = new Scanner(new File(rutaArchivoProveedores))) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            // Verificar que la línea tiene al menos tres campos
            if (line.split(",").length < 3) {
                System.err.println("La línea no tiene al menos tres campos.");
                continue; // Saltar a la siguiente línea
            }

            String[] userData = line.substring(1, line.length() - 1).split(",");
            String existingCedula = userData[2].trim(); // Obtener la cédula

            if (existingCedula.equals(cedula)) {
                return false; // Cédula duplicada
            }
        }
    } catch (FileNotFoundException e) {
        // Manejar la excepción si el archivo no existe (puede ser la primera vez que se ejecuta)
        System.err.println("El archivo no existe, se creará uno nuevo.");
    }
    return true; // Cédula única
    }
}
