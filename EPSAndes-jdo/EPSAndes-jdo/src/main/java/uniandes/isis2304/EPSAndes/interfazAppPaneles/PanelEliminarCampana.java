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

import uniandes.isis2304.EPSAndes.negocio.Campana;
import uniandes.isis2304.EPSAndes.negocio.EPS;
import uniandes.isis2304.EPSAndes.negocio.Servicios;

public class PanelEliminarCampana extends JPanel implements ActionListener, ListSelectionListener
{
    
    private static final String AGREGAR = "Agregar";
    
    private static final String CAMBIO = "Cambio";
  	
    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------
    
    private DialogoEliminarCampana ventana;
    
    private JLabel etiquetaCampanas;
    
    private JComboBox<String> comboCampanas;
  
    private JList servicios;
    
    private JList serviciosTrue;
    
    private JScrollPane scroll;
    
    private JButton botonAgregar;
    
    private JScrollPane scrollTrue;
    
    private ArrayList<Servicios> tmp = new ArrayList<Servicios>();
    
    private List<Campana> campana;
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel creando las etiquetas y los campos de texto necesarios para crear un nuevo disco
     */
    public PanelEliminarCampana( DialogoEliminarCampana dec, List<Campana> camp, List<Servicios> serv)
    {
    	ventana = dec;
    	
    	this.campana = camp;
    
    	JPanel aux2 = new JPanel();
    	JPanel prinp = new JPanel();
    	JPanel aux1 = new JPanel();
    	JPanel aux3 = new JPanel();
    	JPanel aux4 = new JPanel();
    	setLayout(new BorderLayout());
        aux1.setLayout(new BorderLayout());
        aux2.setLayout(new BorderLayout());
        aux3.setLayout(new BorderLayout());
        prinp.setLayout(new BorderLayout());
        aux4.setLayout(new GridLayout( 1 , 2 , 5 , 5));
        setPreferredSize(new Dimension(400,400));
        
        
        etiquetaCampanas = new JLabel( "Campana: " );
        etiquetaCampanas.setFont( etiquetaCampanas.getFont( ).deriveFont( Font.PLAIN ) );
        aux4.add( etiquetaCampanas );
        
        comboCampanas = new JComboBox<String>(darNombres(camp));
        comboCampanas.setActionCommand( CAMBIO );
        comboCampanas.addActionListener(this);
        
        aux4.add(comboCampanas);
        
        prinp.add(aux4, BorderLayout.NORTH);
        
        scroll = new JScrollPane();
        servicios = new JList();
        setList(serv);
        servicios.addListSelectionListener(this);
        scroll.getViewport().add(servicios);
        aux1.add(scroll, BorderLayout.NORTH);
        
        botonAgregar = new JButton( "Agregar" );
        botonAgregar.setActionCommand( AGREGAR );
        botonAgregar.addActionListener( this );
        aux1.add(botonAgregar, BorderLayout.SOUTH);
        
        prinp.add(aux1, BorderLayout.SOUTH);
        
        aux2.add(prinp, BorderLayout.NORTH);
        
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

    
    public long darCampaniaID()
    {
    	return campana.get(comboCampanas.getSelectedIndex()).getCampanaID();
    }
    
    public Campana darCampanaSelect()
    {
    	return campana.get(comboCampanas.getSelectedIndex());
    }

    public String[] darNombres(List<Campana> campana)
    {
    	String[] rta = new String[campana.size()];
    	
    	for(int i = 0; i < campana.size(); i++)
    	{
    		rta[i] = campana.get(i).getNombre();
    	}
    	
    	return rta;
    }
    
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
         else if(CAMBIO.equals(comando))
         {
        	 setList(ventana.darServicioCampana());
        	 scrollTrue.getViewport().removeAll();
         }
    }
    public void valueChanged( ListSelectionEvent e )
    {   

    }
}
