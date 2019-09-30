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

public class PanelCrearServicio extends JPanel implements ActionListener
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
    private JLabel etiquetaHorario;

    /**
     * Es el campo de texto para ingresar el artista del nuevo disco
     */
    private JTextField txtHorario;

    /**
     * Es la etiqueta "Registro"
     */
    private JLabel etiquetaCapacidad;

    /**
     * Es el campo de texto para ingresar la imagen del nuevo disco
     */
    private JTextField txtCapacidad;
    
    /**
     * Es la etiqueta "Especialidad"
     */
    private JLabel etiquetaID;

    /**
     * Es el campo de texto para ingresar el género del nuevo disco
     */
    private JTextField txtID;
    
    private JLabel etiquetaIPSID;

    /**
     * Es el campo de texto para ingresar el género del nuevo disco
     */
    private JTextField txtIPSID;
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel creando las etiquetas y los campos de texto necesarios para crear un nuevo disco
     */
    public PanelCrearServicio( )
    {
        setLayout( new GridLayout( 6, 2, 5, 5 ) );
        setSize(300, 400);
        
        etiquetaNombre = new JLabel( "Nombre: " );
        etiquetaNombre.setFont( etiquetaNombre.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaNombre );

        txtNombre = new JTextField( 2 );
        add( txtNombre );

        etiquetaHorario = new JLabel( "Horario: " );
        etiquetaHorario.setFont( etiquetaHorario.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaHorario );

        txtHorario = new JTextField( 2 );
        add( txtHorario );

        etiquetaCapacidad = new JLabel( "Capacidad: " );
        etiquetaCapacidad.setFont( etiquetaCapacidad.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaCapacidad );

        txtCapacidad = new JTextField( 2 );
        add( txtCapacidad );
        
        etiquetaID = new JLabel( "ID: " );
        etiquetaID.setFont( etiquetaID.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaID );

        txtID = new JTextField( 2 );
        add( txtID );
        
        etiquetaIPSID = new JLabel( "ID IPS: " );
        etiquetaIPSID.setFont( etiquetaIPSID.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaIPSID );

        txtIPSID = new JTextField( 2 );
        add( txtIPSID );

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
    public String darHorario( )
    {
        return txtHorario.getText( );
    }

    
    public String darCapacidad()
    {
    	return txtCapacidad.getText();
    }
    
    public String darID()
    {
    	return txtID.getText();
    }
    
    public String darIDIPS()
    {
    	return txtIPSID.getText();
    }
    
    /**
     * Ejecuta una acción cuando se hace click sobre un botón
     * @param evento el evento del click sobre un botón
     */
    public void actionPerformed( ActionEvent evento )
    {
        
    }
}
