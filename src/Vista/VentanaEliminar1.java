/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VentanaEliminar1 extends JFrame {
    
    private JButton btnReturn;
    private JButton btnComplete;
    private JLabel jlTituloWc;
    public PanelFondo jpFondoInicial;
    private JLabel labelCampoRutEliminar;
    private JTextField campoTextoRutEliminar;
    
    //Método constructor
    public VentanaEliminar1(){
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
         //Configuración de la ventana
        setTitle("VentanaEliminar1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,500);
        setLocationRelativeTo(null);
        setVisible(false); 
        setResizable(false);
        
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        
        jlTituloWc = new JLabel("VentanaEliminar1",SwingConstants.CENTER );
        jlTituloWc.setBounds(150,40, 400,35);
        jlTituloWc.setForeground(Color.WHITE);
        jlTituloWc.setFont(new Font("Cambria Bold", Font.BOLD, 30)); 
        
        //Configuración del Encabezado
        jpFondoInicial = new PanelFondo("/modelo/fondoRojo.jpg"); 
        jpFondoInicial.setSize(700,500);     
        jpFondoInicial.setLayout(null);
        add(jpFondoInicial);
        
        btnReturn = new JButton("Return");
        btnReturn.setFont(new Font("Arial", Font.BOLD, 12));
        btnReturn.setBounds(205,360, 110,35);
        btnReturn.setActionCommand("Prueba1");
        
        btnComplete = new JButton("Complete");
        btnComplete.setFont(new Font("Arial", Font.BOLD, 12));
        btnComplete.setBounds(385,360, 110,35);
        btnComplete.setActionCommand("Prueba2");
        
        
        labelCampoRutEliminar = new JLabel("RutEliminar");
        labelCampoRutEliminar.setFont(new Font("Arial", Font.PLAIN, 12));
        labelCampoRutEliminar.setBounds(100, 100, 80, 25);
        campoTextoRutEliminar = new JTextField();
        campoTextoRutEliminar.setBounds(200, 100, 150, 25);

        jpFondoInicial.add(labelCampoRutEliminar);
        jpFondoInicial.add(campoTextoRutEliminar);
         
        jpFondoInicial.add(btnReturn);
        jpFondoInicial.add(btnComplete);
        jpFondoInicial.add(jlTituloWc);

    }   

    public void iniciarVentanaCrear(){
        VentanaCrear crear = new VentanaCrear(); 
        crear.setVisible(true);
        dispose();

    }
    
}
   
    

