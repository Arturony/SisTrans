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

public class PanelRegistrarLlegada extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------
    /**
     * Es la etiqueta "Nombre"
     */
    private JLabel etiquetaCita;

    /**
     * Es el campo de texto para ingresar el título del nuevo disco
     */
    private JTextField txtCita;

    /**
     * Es la etiqueta "Documento"
     */
    private JLabel etiquetaAfiliado;

    /**
     * Es el campo de texto para ingresar el artista del nuevo disco
     */
    private JTextField txtAfiliado;
    

    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel creando las etiquetas y los campos de texto necesarios para crear un nuevo disco
     */
    public PanelRegistrarLlegada( )
    {
        setLayout( new GridLayout( 2, 2, 5, 5 ) );
        
        etiquetaCita = new JLabel( "ID de Cita: " );
        etiquetaCita.setFont( etiquetaCita.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaCita );

        txtCita = new JTextField( 2 );
        add( txtCita );

        etiquetaAfiliado = new JLabel( "ID de Afiliado: " );
        etiquetaAfiliado.setFont( etiquetaAfiliado.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaAfiliado );

        txtAfiliado = new JTextField( 2 );
        add( txtAfiliado );

        setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Da el valor del campo de texto con el título del disco
     * @return El texto con el título
     */
    public String darCita( )
    {
        return txtCita.getText( );
    }

    /**
     * Da el valor del campo de texto con el artista del disco
     * @return El texto con el artista
     */
    public String darAfiliado( )
    {
        return txtAfiliado.getText( );
    }

    /**
     * Ejecuta una acción cuando se hace click sobre un botón
     * @param evento el evento del click sobre un botón
     */
    public void actionPerformed( ActionEvent evento )
    {
        
    }
}
