/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class VentanaEliminar extends JFrame{
    
       private JButton btnDelete;
        private JLabel jlTituloWd;
    
    public PanelFondo jpFondoInicial;
    
    
    //Método constructor
    public VentanaEliminar(){
        iniciarComponentes();
}
     private void iniciarComponentes(){
         //Configuración de la ventana
        setTitle("Crear Datos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,500);
        setLocationRelativeTo(null);
        setVisible(false); 
        setResizable(false);
        
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        
        jlTituloWd = new JLabel("Eliminar Datos",SwingConstants.CENTER );
        jlTituloWd.setBounds(150,40, 400,35);
        jlTituloWd.setForeground(Color.RED);
        jlTituloWd.setFont(new Font("Cambria Bold", Font.BOLD, 30)); 
        
        //Configuración del Encabezado
        jpFondoInicial = new PanelFondo("/modelo/fondo.jpg"); 
        jpFondoInicial.setSize(700,500);     
        jpFondoInicial.setLayout(null);
        add(jpFondoInicial);
        
        btnDelete = new JButton("Eliminar");
        btnDelete.setFont(new Font("Arial", Font.BOLD, 12));
        btnDelete.setBounds(295,360, 110,35);
        btnDelete.setActionCommand("delete");
         
        jpFondoInicial.add(btnDelete);
        jpFondoInicial.add(jlTituloWd);

     }   

     public void iniciarVentanaEliminar(){
             VentanaEliminar eliminar = new VentanaEliminar(); 
             eliminar.setVisible(true);
             dispose();

        }

}
   
    

