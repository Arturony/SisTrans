package uniandes.isis2304.EPSAndes.interfazAppPaneles;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import uniandes.isis2304.EPSAndes.negocio.EPS;

public class PanelCrearOrganizador extends JPanel implements ActionListener
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
     * Es la etiqueta "Registro"
     */
    private JLabel etiquetaCorreo;

    /**
     * Es el campo de texto para ingresar la imagen del nuevo disco
     */
    private JTextField txtCorreo;
    
    /**
     * Es la etiqueta "Especialidad"
     */
    private JLabel etiquetaContrasenia;

    /**
     * Es el campo de texto para ingresar el género del nuevo disco
     */
    private JTextField txtContrasenia;
    
    private JLabel etiquetaEps;
    
    private JComboBox<String> comboEps;
    
    private List<EPS> eps;
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel creando las etiquetas y los campos de texto necesarios para crear un nuevo disco
     */
    public PanelCrearOrganizador( List<EPS> eps )
    {
    	
    	this.eps = eps;
        setLayout( new GridLayout( 7, 2, 5, 5 ) );
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

        etiquetaCorreo = new JLabel( "Correo: " );
        etiquetaCorreo.setFont( etiquetaCorreo.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaCorreo );

        txtCorreo = new JTextField( 2 );
        add( txtCorreo );
        
        etiquetaContrasenia = new JLabel( "Contraseña: " );
        etiquetaContrasenia.setFont( etiquetaContrasenia.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaContrasenia );

        txtContrasenia = new JTextField( 2 );
        add( txtContrasenia );
        
        etiquetaEps = new JLabel( "Eps: " );
        etiquetaEps.setFont( etiquetaEps.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaEps );

        comboEps = new JComboBox<String>(darNombres(eps));
        add( comboEps );

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


    public String darTipoDocumento()
    {
    	return (String)comboDocumento.getSelectedItem();
    }
    
    public String darCorreo()
    {
    	return txtCorreo.getText();
    }
    
    public String darContrasenia()
    {
    	return txtContrasenia.getText();
    }
    
    public String darEps()
    {
    	return eps.get(comboEps.getSelectedIndex()).getEpsID()+"";
    }
    
    public String[] darNombres(List<EPS> eps)
    {
    	String[] rta = new String[eps.size()];
    	
    	for(int i = 0; i < eps.size(); i++)
    	{
    		rta[i] = eps.get(i).getNombre();
    	}
    	
    	return rta;
    }
    
    /**
     * Ejecuta una acción cuando se hace click sobre un botón
     * @param evento el evento del click sobre un botón
     */
    public void actionPerformed( ActionEvent evento )
    {
        
    }
}