package uniandes.isis2304.EPSAndes.interfazAppPaneles;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import sun.java2d.Disposer;
import uniandes.isis2304.EPSAndes.negocio.EPS;
import uniandes.isis2304.EPSAndes.negocio.Servicios;

public class PanelEjecutarQuery extends JPanel implements ActionListener
{
	
	private static final String ACCEPT = "Accept";
	
	private static final String FINISH = "Finish";
	
	private static final String CANCEL = "Cancel";

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------
	
	private DialogoEjecutarQuery ventana;
	
    /**
     * Es la etiqueta "Nombre"
     */
    private JLabel etiquetaQuery;

    /**
     * Es el campo de texto para ingresar el título del nuevo disco
     */
    private JTextArea areaQuery;

    /**
     * Es la etiqueta "Documento"
     */
    private JButton buttonAccept;

    /**
     * Es el campo de texto para ingresar el artista del nuevo disco
     */
    private JTextArea areaResult;
    
    private JButton buttonFinish;

    private JButton buttonCancel;
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel creando las etiquetas y los campos de texto necesarios para crear un nuevo disco
     */
    public PanelEjecutarQuery(DialogoEjecutarQuery ven)
    {
        setLayout( new GridLayout( 0, 1, 5, 5 ) );
        
        ventana = ven;
        
        JPanel aux = new JPanel();
        aux.setLayout(new GridLayout());
        
        etiquetaQuery = new JLabel( "Inserte aqui el query a ejecutar: " );
        etiquetaQuery.setFont( etiquetaQuery.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaQuery );

        areaQuery = new JTextArea(5,10 );
        add( areaQuery );

        buttonAccept = new JButton( "Aceptar" );
        buttonAccept.setActionCommand( ACCEPT );
        buttonAccept.addActionListener( this );
        buttonAccept.setPreferredSize(new Dimension(20,100));
        add(buttonAccept);

        areaResult = new JTextArea("Aqui aparece el resultado del query");
        areaResult.setEditable(false);
        add( areaResult );

        buttonFinish = new JButton( "Finish" );
        buttonFinish.setActionCommand( FINISH );
        buttonFinish.addActionListener( this );
        aux.add(buttonFinish);
        
        buttonCancel = new JButton( "Cancel" );
        buttonCancel.setActionCommand( CANCEL );
        buttonCancel.addActionListener( this );
        aux.add(buttonCancel);
        
        add(aux);

        setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    public String getText()
    {
    	return areaQuery.getText();
    }
    
    public void actualizarText (String texto)
    {
    	areaResult.setText(texto);
    }
    
    /**
     * Ejecuta una acción cuando se hace click sobre un botón
     * @param evento el evento del click sobre un botón
     */
    public void actionPerformed( ActionEvent evento )
    {
    	String comando = evento.getActionCommand( );
    	 
         if(ACCEPT.equals(comando))
         {
        	 ventana.ejecutarQuery();
         }
         else if(FINISH.equals(comando))
         {
        	 ventana.end();
         }
         else if(CANCEL.equals(comando))
         {
        	 ventana.end();
         }
    
    }
}
