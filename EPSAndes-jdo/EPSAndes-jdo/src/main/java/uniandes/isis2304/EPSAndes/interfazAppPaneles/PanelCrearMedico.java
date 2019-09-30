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

public class PanelCrearMedico extends JPanel implements ActionListener
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
    private JLabel etiquetaDocumento;

    /**
     * Es el campo de texto para ingresar el artista del nuevo disco
     */
    private JTextField txtDocumento;
    
    private JLabel etiquetaTipoDocumento;
    
    private JComboBox comboDocumento;

    /**
     * Es la etiqueta "Especialidad"
     */
    private JLabel etiquetaEspecialidad;

    /**
     * Es el campo de texto para ingresar el género del nuevo disco
     */
    private JTextField txtEspecialidad;

    /**
     * Es la etiqueta "Registro"
     */
    private JLabel etiquetaRegistro;

    /**
     * Es el campo de texto para ingresar la imagen del nuevo disco
     */
    private JTextField txtRegistro;
    

    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel creando las etiquetas y los campos de texto necesarios para crear un nuevo disco
     */
    public PanelCrearMedico( )
    {
        setLayout( new GridLayout( 6, 2, 5, 5 ) );
        setSize(300, 400);

        String[] tipoDocumentos = {"Cedula Ciudadania", "Pasaporte", "Cedula Extrangeria"};
        
        etiquetaNombre = new JLabel( "Nombre: " );
        etiquetaNombre.setFont( etiquetaNombre.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaNombre );

        txtNombre = new JTextField( 2 );
        add( txtNombre );

        etiquetaDocumento = new JLabel( "Documento: " );
        etiquetaDocumento.setFont( etiquetaDocumento.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaDocumento );

        txtDocumento = new JTextField( 2 );
        add( txtDocumento );
        
        etiquetaTipoDocumento = new JLabel( "Tipo de Documento: " );
        etiquetaTipoDocumento.setFont( etiquetaTipoDocumento.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaTipoDocumento );
        
        comboDocumento = new JComboBox<String>(tipoDocumentos);
        add(comboDocumento);

        etiquetaEspecialidad = new JLabel( "Especialidad: " );
        etiquetaEspecialidad.setFont( etiquetaEspecialidad.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaEspecialidad );

        txtEspecialidad = new JTextField( 2 );
        add( txtEspecialidad );

        etiquetaRegistro = new JLabel( "Registro Medico: " );
        etiquetaRegistro.setFont( etiquetaRegistro.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaRegistro );

        txtRegistro = new JTextField( 2 );
        add( txtRegistro );

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
    public String darDocumento( )
    {
        return txtDocumento.getText( );
    }

    /**
     * Da el valor del campo de texto con el género del disco
     * @return El texto con el género
     */
    public String darEspecialidad( )
    {
        return txtEspecialidad.getText( );
    }

    public String darTipoDocumento()
    {
    	return (String)comboDocumento.getSelectedItem();
    }
    
    public String darRegistro()
    {
    	return txtRegistro.getText();
    }
    
    /**
     * Ejecuta una acción cuando se hace click sobre un botón
     * @param evento el evento del click sobre un botón
     */
    public void actionPerformed( ActionEvent evento )
    {
        
    }
}
