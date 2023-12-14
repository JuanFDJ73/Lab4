/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.ModeloProducto;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author Usuario
 */
public class CrearProducto {
    
    private String nombreProducto;
    private String marcaProducto;
    private String precioProducto;
    private String cantidadProducto;
    private String idProducto;
    
    File archivoProductos;
    
    String rutaArchivoProductos = "src/main/java/textFiles/archivoProductos";

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

    public File getArchivoProductos() {
        return archivoProductos;
    }

    public void setArchivoProductos(File archivoProductos) {
        this.archivoProductos = archivoProductos;
    }

    public String getRutaArchivoProductos() {
        return rutaArchivoProductos;
    }

    public void setRutaArchivoProductos(String rutaArchivoProductos) {
        this.rutaArchivoProductos = rutaArchivoProductos;
    }
    
    
    
     //Metodo para crear un archivo y establecerlo en una ruta especificada
    //------------------------------------------------------------------------------------------------
    public void crearArchivoTexto(){
        
        try{
            
            archivoProductos = new File(rutaArchivoProductos);
            
            if(!archivoProductos.exists()){
                
                archivoProductos.createNewFile();
                System.out.println("archivo creado, la ruta es: " + archivoProductos.getAbsolutePath());
            }
        }
        
        catch(IOException e){
            
            System.err.println("Error al crear o escribir archivo " + e.getMessage());
            
        }
    
    }


    // Método para verificar si el ID ya existe en el archivo
   private boolean esIdUnico(String id) {
    try (Scanner scanner = new Scanner(new File(rutaArchivoProductos))) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] productsData = line.split(", ");

            // Verificar que haya al menos 5 elementos en productsData
            if (productsData.length >= 5) {
                String existingIdProducts = productsData[4].trim(); // Obtener el ID del producto

                // Verificar que existingIdProducts y id no sean null antes de llamar a trim()
                if (existingIdProducts != null && id != null && existingIdProducts.equalsIgnoreCase(id.trim())) {
                    return false; // ID duplicado
                }
            }
        }
    } catch (FileNotFoundException e) {
        System.err.println("El archivo no existe, se creará uno nuevo.");
    }
    return true; // ID único
   }
   
   //Metodo para agregar los datos de los clientes a una coleccion y al archivo de texto
   public void agregarColeccionProductos() {
        // Verificar si el ID ya existe en el archivo
        if (esIdUnico(this.idProducto)) {
        // Agregar datos a la colección
        ArrayList<String> dataProductsArray = new ArrayList<>();
        dataProductsArray.add(this.nombreProducto);
        dataProductsArray.add(this.marcaProducto);
        dataProductsArray.add(this.precioProducto);
        dataProductsArray.add(this.cantidadProducto);
        dataProductsArray.add(this.idProducto);

        // Agregar datos a la colección principal
        ArrayList<ArrayList<String>> principalProductsArray = new ArrayList<>();
        principalProductsArray.add(dataProductsArray);
        System.out.println("Los siguientes datos fueron guardados " + principalProductsArray);

        // Escribir en el archivo solo si el ID es único
        try (FileWriter fileWriter = new FileWriter(rutaArchivoProductos, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            bufferedWriter.write(String.join(", ", dataProductsArray));
            bufferedWriter.newLine();  // Agregar una nueva línea para cada producto
            JOptionPane.showMessageDialog(null, "Datos del producto almacenados");

        } catch (IOException e) {
            throw new RuntimeException("Error al añadir texto al archivo: " + e.getMessage(), e);
            }
        } 
        else {
            JOptionPane.showMessageDialog(null, "El ID ya existe, no se puede agregar el producto.");
        }
    }

}