package uniandes.isis2304.EPSAndes.interfazAppPaneles;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class PanelCrearOrden extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------
    /**
     * Es la etiqueta "Nombre"
     */
    private JLabel etiquetaID;

    /**
     * Es el campo de texto para ingresar el título del nuevo disco
     */
    private JTextField txtID;

    /**
     * Es la etiqueta "Documento"
     */
    private JLabel etiquetaAfiliado;

    /**
     * Es el campo de texto para ingresar el artista del nuevo disco
     */
    private JTextField txtAfiliado;
    

    /**
     * Es la etiqueta "Registro"
     */
    private JLabel etiquetaServicio;

    /**
     * Es el campo de texto para ingresar la imagen del nuevo disco
     */
    private JTextField txtServicio;
   
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel creando las etiquetas y los campos de texto necesarios para crear un nuevo disco
     */
    public PanelCrearOrden( )
    {
        setLayout( new GridLayout( 6, 2, 5, 5 ) );
        
        etiquetaID = new JLabel( "ID: " );
        etiquetaID.setFont( etiquetaID.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaID );

        txtID = new JTextField( 2 );
        add( txtID );

        etiquetaAfiliado = new JLabel( "ID del Afiliado: " );
        etiquetaAfiliado.setFont( etiquetaAfiliado.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaAfiliado );

        txtAfiliado = new JTextField( 2 );
        add( txtAfiliado );
        

        etiquetaServicio = new JLabel( "ID del Servicio: " );
        etiquetaServicio.setFont( etiquetaServicio.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaServicio );

        txtServicio = new JTextField( 2 );
        add( txtServicio );
       

        setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Da el valor del campo de texto con el título del disco
     * @return El texto con el título
     */
    public String darID( )
    {
        return txtID.getText( );
    }

    /**
     * Da el valor del campo de texto con el artista del disco
     * @return El texto con el artista
     */
    public String darAfiliado( )
    {
        return txtAfiliado.getText( );
    }
    
    public String darServicio()
    {
    	return txtServicio.getText();
    }

    
    /**
     * Ejecuta una acción cuando se hace click sobre un botón
     * @param evento el evento del click sobre un botón
     */
    public void actionPerformed( ActionEvent evento )
    {
        
    }
}
