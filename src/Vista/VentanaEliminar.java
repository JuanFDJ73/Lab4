
package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class VentanaEliminar extends JFrame{
    
       private JButton btnPrueba1;
       private JButton btnPrueba2;
       private JLabel jlTituloWd;
    
    public PanelFondo jpFondoInicial;
    
    
    //Método constructor
    public VentanaEliminar(){
        iniciarComponentes();
        agregarListeners();
    }
    
    private void agregarListeners() {
        btnPrueba1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí creas una instancia de la nueva clase a la que quieres dirigirte
                VentanaEliminar1 nuevaVentana = new VentanaEliminar1();

                // Haces visible la nueva ventana
                nuevaVentana.setVisible(true);

                // Cierras la ventana actual
                dispose();
            }
        });
        
        btnPrueba2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí creas una instancia de la nueva clase a la que quieres dirigirte
                VentanaEliminar2 nuevaVentana = new VentanaEliminar2();

                // Haces visible la nueva ventana
                nuevaVentana.setVisible(true);

                // Cierras la ventana actual
                dispose();
            }
        });
        
    }
    
    
    private void iniciarComponentes(){
         //Configuración de la ventana
        setTitle("Eliminar Datos");
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
        
        btnPrueba1 = new JButton("Boton1");
        btnPrueba1.setFont(new Font("Arial", Font.BOLD, 12));
        btnPrueba1.setBounds(205,360, 110,35);
        btnPrueba1.setActionCommand("Prueba1");
        
        btnPrueba2 = new JButton("Boton2");
        btnPrueba2.setFont(new Font("Arial", Font.BOLD, 12));
        btnPrueba2.setBounds(385,360, 110,35);
        btnPrueba2.setActionCommand("Prueba2");
         
        jpFondoInicial.add(btnPrueba1);
        jpFondoInicial.add(btnPrueba2);
        jpFondoInicial.add(jlTituloWd);


     }   

     public void iniciarVentanaEliminar(){
             VentanaEliminar eliminar = new VentanaEliminar(); 
             eliminar.setVisible(true);
             dispose();

        }

}
   
    

