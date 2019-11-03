package uniandes.isis2304.EPSAndes.interfazAppPaneles;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.datanucleus.transaction.jta.JBossTransactionManagerLocator;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;

import uniandes.isis2304.EPSAndes.interfazApp.InterfazEPSAndesApu;
import uniandes.isis2304.EPSAndes.negocio.Servicios;

public class PanelConfirmacionEliminacion extends JDialog implements ActionListener, ListSelectionListener
{
    
    private static final String NO = "NO";
    
    private static final String SI = "SI";
  	
    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------
    
    private DialogoEliminarCampana ventana;
  
    private JLabel etiquetaCon;
    
    private JLabel etiquetaCon1;
    
    private JLabel etiquetaCon2;
    
    private JButton botonSi;
    
    private JButton botonNo;
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel creando las etiquetas y los campos de texto necesarios para crear un nuevo disco
     */
    public PanelConfirmacionEliminacion( DialogoEliminarCampana dec, InterfazEPSAndesApu id )
    {
    	super( id, true );
    	
    	ventana = dec;
    	
    	JPanel prinp = new JPanel();
    	JPanel aux = new JPanel();
    	setLayout(new BorderLayout());
        prinp.setLayout( new GridLayout( 0, 2, 5, 5 ) );
        aux.setLayout( new GridLayout( 0, 1, 5, 5 ) );
        
        etiquetaCon = new JLabel( "Todos los servicios de la campana estan selecccionados");
        etiquetaCon.setFont( etiquetaCon.getFont( ).deriveFont( Font.PLAIN ) );
        aux.add( etiquetaCon );
        
        etiquetaCon1 = new JLabel("Esto eliminara la campana.");
        etiquetaCon1.setFont( etiquetaCon1.getFont( ).deriveFont( Font.PLAIN ) );
        aux.add( etiquetaCon1 );
        
        etiquetaCon2 = new JLabel("Desea Continuar? " );
        etiquetaCon2.setFont( etiquetaCon2.getFont( ).deriveFont( Font.PLAIN ) );
        aux.add( etiquetaCon2 );
        
        botonSi = new JButton( "Si" );
        botonSi.setActionCommand( SI );
        botonSi.addActionListener( this );
        prinp.add(botonSi);
        
        botonNo = new JButton( "No" );
        botonNo.setActionCommand( NO );
        botonNo.addActionListener( this );
        prinp.add(botonNo);
        
        getContentPane( ).add(aux, BorderLayout.NORTH);
        
        getContentPane( ).add(prinp, BorderLayout.SOUTH);
        
        setTitle( "Crear Disco" );
        pack( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    
    /**
     * Ejecuta una acción cuando se hace click sobre un botón
     * @param evento el evento del click sobre un botón
     */
    public void actionPerformed( ActionEvent evento )
    {
    	 String comando = evento.getActionCommand( );
    	 
         if(NO.equals(comando))
         {
        	 dispose();
         }
         else if(SI.equals(comando))
         {
        	 ventana.eliminarCampana();
        	 dispose();
         }
    }
    public void valueChanged( ListSelectionEvent e )
    {   

    }
}
