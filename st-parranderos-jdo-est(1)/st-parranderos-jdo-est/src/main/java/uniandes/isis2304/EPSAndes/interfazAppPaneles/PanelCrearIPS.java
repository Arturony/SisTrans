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

public class PanelCrearIPS extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------
    /**
     * Es la etiqueta "Nombre"
     */
    private JLabel etiquetaNombre;

    /**
     * Es el campo de texto para ingresar el título del nuevo disco
     */
    private JTextField txtNombre;

    /**
     * Es la etiqueta "Documento"
     */
    private JLabel etiquetaID;

    /**
     * Es el campo de texto para ingresar el artista del nuevo disco
     */
    private JTextField txtID;
    /**
     * Es la etiqueta "Especialidad"
     */
    private JLabel etiquetaLocal;

    /**
     * Es el campo de texto para ingresar el género del nuevo disco
     */
    private JTextField txtLocal;

    

    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel creando las etiquetas y los campos de texto necesarios para crear un nuevo disco
     */
    public PanelCrearIPS( )
    {
        setLayout( new GridLayout( 4, 2, 5, 5 ) );
        
        etiquetaNombre = new JLabel( "Nombre: " );
        etiquetaNombre.setFont( etiquetaNombre.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaNombre );

        txtNombre = new JTextField( 2 );
        add( txtNombre );

        etiquetaID = new JLabel( "Id: " );
        etiquetaID.setFont( etiquetaID.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaID );

        txtID = new JTextField( 2 );
        add( txtID );

        etiquetaLocal = new JLabel( "Localización: " );
        etiquetaLocal.setFont( etiquetaLocal.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaLocal );

        txtLocal = new JTextField( 2 );
        add( txtLocal );

        add( new JLabel( ) );

        setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Da el valor del campo de texto con el título del disco
     * @return El texto con el título
     */
    public String darNombre( )
    {
        return txtNombre.getText( );
    }

    /**
     * Da el valor del campo de texto con el artista del disco
     * @return El texto con el artista
     */
    public String darID( )
    {
        return txtID.getText( );
    }

    /**
     * Da el valor del campo de texto con el género del disco
     * @return El texto con el género
     */
    public String darLocal( )
    {
        return txtLocal.getText( );
    }
    
    /**
     * Ejecuta una acción cuando se hace click sobre un botón
     * @param evento el evento del click sobre un botón
     */
    public void actionPerformed( ActionEvent evento )
    {
        
    }
}
