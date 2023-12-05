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

public class VentanaLeer extends JFrame {
    
       private JButton btnRead;
        private JLabel jlTituloWr;
    
    public PanelFondo jpFondoInicial;
    
    
    //Método constructor
    public VentanaLeer(){
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
        
        jlTituloWr = new JLabel("Leer Datos",SwingConstants.CENTER );
        jlTituloWr.setBounds(150,40, 400,35);
        jlTituloWr.setForeground(Color.WHITE);
        jlTituloWr.setFont(new Font("Cambria Bold", Font.BOLD, 30)); 
        
        //Configuración del Encabezado
        jpFondoInicial = new PanelFondo("/modelo/fondoRojo.jpg"); 
        jpFondoInicial.setSize(700,500);     
        jpFondoInicial.setLayout(null);
        add(jpFondoInicial);
        
        btnRead = new JButton("Leer");
        btnRead.setFont(new Font("Arial", Font.BOLD, 12));
        btnRead.setBounds(295,360, 110,35);
        btnRead.setActionCommand("read");
         
        jpFondoInicial.add(btnRead);
        jpFondoInicial.add(jlTituloWr);

     }   

     public void iniciarVentanaLeer(){
             VentanaLeer leer = new VentanaLeer(); 
             leer.setVisible(true);
             dispose();

        }

}
   
    

