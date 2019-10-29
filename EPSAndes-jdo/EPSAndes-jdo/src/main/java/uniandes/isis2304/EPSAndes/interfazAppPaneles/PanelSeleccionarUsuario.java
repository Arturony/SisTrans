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

public class PanelSeleccionarUsuario extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------
    /**
     * Es la etiqueta "Nombre"
     */
    private JLabel etiquetaUsuario;

    /**
     * Es el campo de texto para ingresar el título del nuevo disco
     */
    private JTextField txtUsuario;

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
    
    private JLabel etiquetaTipoUsuario;

    /**
     * Es la etiqueta "Especialidad"
     */
    private JComboBox comboTipousuario;
    
    private JLabel etiquetaCorreo;
    
    private JTextField txtCorreo;

    /**
     * Es el campo de texto para ingresar el género del nuevo disco
     */

    /**
     * Es la etiqueta "Registro"
     */
    private JLabel etiquetaContrasenia;

    /**
     * Es el campo de texto para ingresar la imagen del nuevo disco
     */
    private JTextField txtContrasenia;
    
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
    public PanelSeleccionarUsuario( )
    {
        setLayout( new GridLayout( 8, 2, 6, 6 ) );

        String[] tipoDocumentos = {"Cedula Ciudadania", "Pasaporte", "Cedula Extrangeria"};
        String[] tipoUsuario = {"Administrador de Datos", "Organizador de Campañas", "Afiliado", "Gerente", "Medico", "Recepcionista"};
        
        etiquetaUsuario = new JLabel( "Nombre de Usuario: " );
        etiquetaUsuario.setFont( etiquetaUsuario.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaUsuario );

        txtUsuario = new JTextField( 2 );
        add( txtUsuario );

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
        
        etiquetaTipoUsuario = new JLabel( "Tipo de Usuario: " );
        etiquetaTipoUsuario.setFont( etiquetaTipoUsuario.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaTipoUsuario );

        comboTipousuario = new JComboBox<String>(tipoUsuario);
        comboTipousuario.setActionCommand("CambioValor");
        comboTipousuario.addActionListener(this);
        comboTipousuario.setFont( comboTipousuario.getFont( ).deriveFont( Font.PLAIN ) );
        add( comboTipousuario );
        
        etiquetaRegistro = new JLabel( "Registro Médico: " );
        etiquetaRegistro.setFont( etiquetaRegistro.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaRegistro );

        txtRegistro = new JTextField( 2 );
        add( txtRegistro);
        txtRegistro.setEditable(false);
        
        etiquetaCorreo = new JLabel( "Correo: " );
        etiquetaCorreo.setFont( etiquetaCorreo.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaCorreo );

        txtCorreo = new JTextField( 2 );
        add( txtCorreo);

        etiquetaContrasenia = new JLabel( "Contraseña: " );
        etiquetaContrasenia.setFont( etiquetaContrasenia.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaContrasenia );

        txtContrasenia = new JTextField( 2 );
        add( txtContrasenia );


        setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Da el valor del campo de texto con el título del disco
     * @return El texto con el título
     */
    public String darNombreUsuario( )
    {
        return txtUsuario.getText( );
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
    
    public String darTipoUsuario()
    {
    	return (String)comboTipousuario.getSelectedItem();
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
        String e = evento.getActionCommand();
        
        if(e.equals("CambioValor"))
        {
        	String user = ((String)comboTipousuario.getSelectedItem());
        	if(user.equals("Medico"))
        	{
        		txtRegistro.setEditable(true);
        		txtContrasenia.setEditable(false);
        		txtCorreo.setEditable(false);
        	}
        	else if(user.equals("Recepcionista") || user.equals("Afiliado") || user.equals("Gerente"))
        	{
        		txtContrasenia.setEditable(false);
        		txtCorreo.setEditable(true);
        		txtRegistro.setEditable(false);
        	}
        	else
        	{
        		txtContrasenia.setEditable(true);
        		txtCorreo.setEditable(true);
        		txtRegistro.setEditable(false);
        	}
        		
        }
    }

	
}
