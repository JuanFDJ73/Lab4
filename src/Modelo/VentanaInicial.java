/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


//Creo mi clase que hereda de JFrame
public final class VentanaInicial extends JFrame implements ActionListener{
    
    
    public PanelFondo jpFondoInicial;
    private JLabel jlTitulo;
    private JLabel jlTitulo2;
    private JTextField txtNombre;
    private JButton btnCrear; 
    private JButton btnUpdate;
    private JButton btnRead;
    private JButton btnDelete;
    
    //Método constructor
    public VentanaInicial(){
        iniciarComponentes();
        
    }
    
    //Método donde inicializo todos los componentes que tendrá mi ventana
    private void iniciarComponentes(){
        //Configuración de la ventana
        setTitle("Supermercado Univalle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,500);
        setLocationRelativeTo(null);
        setVisible(true); 
        setResizable(false);
        
        
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
       
        
        
        //Configuración del Encabezado
        jpFondoInicial = new PanelFondo("/modelo/fondo02.jpg"); 
        jpFondoInicial.setSize(700,500);     
        jpFondoInicial.setLayout(null);
        add(jpFondoInicial);
        
        
        //Jlabel donde pondré el titulo
        jlTitulo = new JLabel("S U P E R M E R C A D O",SwingConstants.CENTER );
        jlTitulo.setBounds(150,90, 400,35);
        jlTitulo.setForeground(Color.RED);
        jlTitulo.setFont(new Font("Cambria Bold", Font.BOLD, 30)); 
        
        jlTitulo2 = new JLabel("U N I V A L L E",SwingConstants.CENTER );
        jlTitulo2.setBounds(150,120, 400,35);
        jlTitulo2.setForeground(Color.RED);
        jlTitulo2.setFont(new Font("Cambria Bold", Font.BOLD, 30)); 
        
        /*//Jlabel donde preguntaré el nombre
        jlNombre = new JLabel("Ingresa tu nombre",SwingConstants.CENTER );
        jlNombre.setBounds(150,170, 400,35);
        jlNombre.setForeground(Color.GRAY);
        jlNombre.setFont(new Font("Agency FB", Font.BOLD, 30)); 
        */
        
        //Boton para Crear producto/proveedor/cliente
        btnCrear = new JButton("Crear");
        btnCrear.setFont(new Font("Arial", Font.BOLD, 15));
        btnCrear.setBounds(230,250, 110,35);
        
       //Botón para actuzalizar producto/proveedor/cliente
        btnUpdate = new JButton("Actualizar");
        btnUpdate.setFont(new Font("Arial", Font.BOLD, 15)); 
        btnUpdate.setBounds(230,310, 110,35);
        
        //Botón para leer producto/proveedor/cliente
        btnRead = new JButton("Leer");
        btnRead.setFont(new Font("Arial", Font.BOLD, 15)); 
        btnRead.setBounds(350,250, 110,35);
        
        //Botón para eliminar producto/proveedor/cliente
        btnDelete = new JButton("Eliminar");
        btnDelete.setFont(new Font("Arial", Font.BOLD, 15)); 
        btnDelete.setBounds(350,310, 110,35);
        
       //Caja para ingresar nombre
        txtNombre = new JTextField("");
        txtNombre.setHorizontalAlignment(JTextField.CENTER);
        txtNombre.setForeground(Color.gray);
        txtNombre.setFont(new Font("Arial", Font.BOLD, 15)); 
        txtNombre.setBounds(225,215,240, 25);
        
        
        //Agrego todos mis componentes
        //jpFondoInicial.add(txtNombre);
        //jpFondoInicial.add(jlNombre);
        jpFondoInicial.add(jlTitulo);    
        jpFondoInicial.add(jlTitulo2);  
        jpFondoInicial.add(btnCrear);
        jpFondoInicial.add(btnUpdate);
        jpFondoInicial.add(btnRead);
        jpFondoInicial.add(btnDelete);
        
        
        ManejadorDeEventos manejadorEventos = new ManejadorDeEventos();
        
        btnUpdate.addActionListener(this);
        btnCrear.addActionListener((ActionListener) manejadorEventos);
        btnUpdate.addActionListener((ActionListener) manejadorEventos);
        btnDelete.addActionListener((ActionListener) manejadorEventos);
        btnRead.addActionListener((ActionListener) manejadorEventos);
        
    }
    public void iniciarVentanaUpdate(){
             VentanaUpdate update = new VentanaUpdate(); 
             update.setVisible(true);
             dispose();
        }
    
    public void actionPerformed(ActionEvent evento){
            if(evento.getSource() == btnUpdate){
System.out.print("Presionó update");
                iniciarVentanaUpdate();
            }

     
    

    } 

}