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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VentanaCrear1 extends JFrame {
    
        private JButton btnReturn;
        private JButton btnComplete;
        private JLabel jlTituloWc;
        private JTextField[] camposTexto;
        private JLabel labelCampoNombre;
        private JTextField campoTextoNombre;
        private JLabel labelCampoApellido;
        private JTextField campoTextoApellido;
        private JLabel labelCampoID;
        private JTextField campoTextoID;
        private JLabel labelCampoEmail;
        private JTextField campoTextoEmail;
    
    public PanelFondo jpFondoInicial;
    
    
    //Método constructor
    public VentanaCrear1(){
        iniciarComponentes();
}
     private void iniciarComponentes(){
         //Configuración de la ventana
        setTitle("VentanaCrear1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,500);
        setLocationRelativeTo(null);
        setVisible(false); 
        setResizable(false);
        
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        
        jlTituloWc = new JLabel("VentanaCrear1",SwingConstants.CENTER );
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
        
        btnComplete = new JButton("complete");
        btnComplete.setFont(new Font("Arial", Font.BOLD, 12));
        btnComplete.setBounds(385,360, 110,35);
        btnComplete.setActionCommand("Prueba2");

        
        labelCampoNombre = new JLabel("Nombre:");
        labelCampoNombre.setFont(new Font("Arial", Font.PLAIN, 12));
        labelCampoNombre.setBounds(100, 40, 80, 25);
        campoTextoNombre = new JTextField();
        campoTextoNombre.setBounds(200, 40, 150, 25);

        jpFondoInicial.add(labelCampoNombre);
        jpFondoInicial.add(campoTextoNombre);
        
        labelCampoApellido = new JLabel("Apellido:");
        labelCampoApellido.setFont(new Font("Arial", Font.PLAIN, 12));
        labelCampoApellido.setBounds(100, 80, 80, 25);
        campoTextoApellido = new JTextField();
        campoTextoApellido.setBounds(200, 80, 150, 25);

        jpFondoInicial.add(labelCampoApellido);
        jpFondoInicial.add(campoTextoApellido);
        
        labelCampoID = new JLabel("ID:");
        labelCampoID.setFont(new Font("Arial", Font.PLAIN, 12));
        labelCampoID.setBounds(100, 120, 80, 25);
        campoTextoID = new JTextField();
        campoTextoID.setBounds(200, 120, 150, 25);

        jpFondoInicial.add(labelCampoID);
        jpFondoInicial.add(campoTextoID);
        
        labelCampoEmail = new JLabel("Email:");
        labelCampoEmail.setFont(new Font("Arial", Font.PLAIN, 12));
        labelCampoEmail.setBounds(100, 160, 80, 25);
        campoTextoEmail = new JTextField();
        campoTextoEmail.setBounds(200, 160, 150, 25);

        jpFondoInicial.add(labelCampoEmail);
        jpFondoInicial.add(campoTextoEmail);
        
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
   
    

