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

import uniandes.isis2304.EPSAndes.negocio.Servicios;

public class PanelCrearDesreserva extends JPanel implements ActionListener, ListSelectionListener
{
    
    private static final String AGREGAR = "Agregar";
  	
    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------
    
    private DialogoCrearDesreserva ventana;
  
    private JList servicios;
    
    private JList serviciosTrue;
    
    private JScrollPane scroll;
    
    private JButton botonAgregar;
    
    private JScrollPane scrollTrue;
    
    private ArrayList<Servicios> tmp = new ArrayList<Servicios>();
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel creando las etiquetas y los campos de texto necesarios para crear un nuevo disco
     */
    public PanelCrearDesreserva( List<Servicios> services )
    {
    
    	JPanel aux2 = new JPanel();
    	JPanel prinp = new JPanel();
    	JPanel aux1 = new JPanel();
    	JPanel aux3 = new JPanel();
    	setLayout(new BorderLayout());
        prinp.setLayout( new GridLayout( 0, 2, 5, 5 ) );
        aux1.setLayout(new BorderLayout());
        aux2.setLayout(new BorderLayout());
        aux3.setLayout(new BorderLayout());
        setPreferredSize(new Dimension(400,400));
        
        scroll = new JScrollPane();
        servicios = new JList();
        setList(services);
        servicios.addListSelectionListener(this);
        scroll.getViewport().add(servicios);
        aux1.add(scroll, BorderLayout.NORTH);
        
        botonAgregar = new JButton( "Agregar" );
        botonAgregar.setActionCommand( AGREGAR );
        botonAgregar.addActionListener( this );
        aux1.add(botonAgregar, BorderLayout.SOUTH);
        
        aux2.add(aux1, BorderLayout.NORTH);
        
        scrollTrue = new JScrollPane();
        serviciosTrue = new JList();
        serviciosTrue.addListSelectionListener(this);
        scrollTrue.getViewport().add(serviciosTrue);
        aux2.add(scrollTrue, BorderLayout.SOUTH);
        
        JScrollPane jc = new JScrollPane(aux2);
        add(jc, BorderLayout.CENTER);
        
        setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Da el valor del campo de texto con el artista del disco
     * @return El texto con el artista
     */
    
    public void setList(List<Servicios> services)
    {
        servicios.setListData(services.toArray());
        scroll.getViewport().removeAll();
        scroll.getViewport().add(servicios);
    }
    
    public void setListTrue(List<Servicios> services)
    {
        serviciosTrue.setListData(services.toArray());
        scrollTrue.getViewport().removeAll();
        scrollTrue.getViewport().add(serviciosTrue);
    }
    
    public ArrayList<Servicios> getServiciosTrue()
    {
    	return tmp;
    }
    
    /**
     * Ejecuta una acción cuando se hace click sobre un botón
     * @param evento el evento del click sobre un botón
     */
    public void actionPerformed( ActionEvent evento )
    {
    	 String comando = evento.getActionCommand( );
    	 
         if(AGREGAR.equals(comando))
         {
        	 Servicios serv = ( Servicios )servicios.getSelectedValue( );
        	 if(!tmp.contains(serv))
        		 tmp.add(serv);
        	 setListTrue(tmp);
         }
    }
    public void valueChanged( ListSelectionEvent e )
    {   

    }
}
