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

public class PanelCrearCampana extends JPanel implements ActionListener, ListSelectionListener
{

    private static final String BUSCAR = "Buscar";
    
    private static final String AGREGAR = "Agregar";
    
    private static final String ADD_SERV ="Add_Serv";
	
    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------
    
    private DialogoCrearCampana ventana;
    
    /**
     * Es la etiqueta "Nombre"
     */
    
    private JLabel etiquetaNombre;
    
    private JTextField txtNombre;
    
    private JLabel etiquetaFecha;
    
    private JLabel etiquetaId;
    
    private JTextField txtId;

    private JLabel etiquetaCapacidad;

    private JTextField txtCapacidad;
    
    private JButton botonAddServ;
    
    private JDateChooser chooser;
    
    private JList servicios;
    
    private JList serviciosTrue;
    
    private JButton botonBuscar;
    
    private JScrollPane scroll;
    
    private JButton botonAgregar;
    
    private JScrollPane scrollTrue;
    
    private JPanel adde;
    
    private ArrayList<PanelCrearCampanaTmp> panels;
    
    private ArrayList<Servicios> tmp = new ArrayList<Servicios>();
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel creando las etiquetas y los campos de texto necesarios para crear un nuevo disco
     */
    public PanelCrearCampana( DialogoCrearCampana dcc )
    {
    	ventana = dcc;
    	
    	panels = new ArrayList<PanelCrearCampanaTmp>();
    	JPanel aux2 = new JPanel();
    	JPanel prinp = new JPanel();
    	JPanel aux1 = new JPanel();
    	JPanel aux3 = new JPanel();
    	JPanel aux4 = new JPanel();
    	JPanel aux5 = new JPanel();
    	JPanel aux6 = new JPanel();
    	adde = new JPanel();
    	setLayout(new BorderLayout());
        prinp.setLayout( new GridLayout( 0, 2, 5, 5 ) );
        aux1.setLayout(new BorderLayout());
        aux2.setLayout(new BorderLayout());
        aux3.setLayout(new BorderLayout());
        aux4.setLayout(new BorderLayout());
        aux5.setLayout(new BorderLayout());
        aux6.setLayout(new BorderLayout());
        adde.setLayout(new GridLayout(0,1,5,5));
        setPreferredSize(new Dimension(400,400));
        
        etiquetaNombre = new JLabel( "Nombre: " );
        etiquetaNombre.setFont( etiquetaNombre.getFont( ).deriveFont( Font.PLAIN ) );
        prinp. add( etiquetaNombre );
        
        txtNombre = new JTextField( 2 );
        prinp. add( txtNombre );
        
        etiquetaFecha = new JLabel( "Fecha: " );
        etiquetaFecha.setFont( etiquetaFecha.getFont( ).deriveFont( Font.PLAIN ) );
        prinp.add( etiquetaFecha );

        chooser = new JDateChooser();
        prinp.add(chooser);

        etiquetaId = new JLabel( "ID: " );
        etiquetaId.setFont( etiquetaId.getFont( ).deriveFont( Font.PLAIN ) );
        prinp.add( etiquetaId );
        
        txtId = new JTextField( 2 );
        prinp.add( txtId );

        etiquetaCapacidad = new JLabel( "Capacidad Campaña: " );
        etiquetaCapacidad.setFont( etiquetaCapacidad.getFont( ).deriveFont( Font.PLAIN ) );
        prinp. add( etiquetaCapacidad );

        txtCapacidad = new JTextField( 2 );
        txtCapacidad.setEditable(true);
        prinp.add( txtCapacidad );
        
        PanelCrearCampanaTmp pCT = new PanelCrearCampanaTmp();
        panels.add(pCT);
        adde.add(pCT);
        aux1.add(adde, BorderLayout.NORTH);
        
        botonAddServ = new JButton( "+" );
        botonAddServ.setActionCommand( ADD_SERV );
        botonAddServ.addActionListener( this );
        aux1.add( botonAddServ, BorderLayout.SOUTH );
        
        aux2.add(prinp,BorderLayout.NORTH);
        aux2.add(aux1,BorderLayout.SOUTH);
        
        aux3.add(aux2,BorderLayout.NORTH);
        
        botonBuscar = new JButton( "Buscar" );
        botonBuscar.setActionCommand( BUSCAR );
        botonBuscar.addActionListener( this );
        aux3.add( botonBuscar, BorderLayout.SOUTH );
        
        aux4.add(aux3, BorderLayout.NORTH);
        
        scroll = new JScrollPane();
        servicios = new JList();
        servicios.addListSelectionListener(this);
        scroll.getViewport().add(servicios);
        aux4.add(scroll, BorderLayout.SOUTH);
        
        aux5.add(aux4,BorderLayout.NORTH);
        
        botonAgregar = new JButton( "Agregar" );
        botonAgregar.setActionCommand( AGREGAR );
        botonAgregar.addActionListener( this );
        aux5.add( botonAgregar, BorderLayout.SOUTH );
        
        aux6.add(aux5, BorderLayout.NORTH);
        
        scrollTrue = new JScrollPane();
        serviciosTrue = new JList();
        serviciosTrue.addListSelectionListener(this);
        scrollTrue.getViewport().add(serviciosTrue);
        
        aux6.add(scrollTrue, BorderLayout.SOUTH);
        JScrollPane jc = new JScrollPane(aux6);
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
    public String darNombre( )
    {
        return txtNombre.getText( );
    }

    
    public String darCapacidad()
    {
    	return txtCapacidad.getText();
    }
    
    
    public String darID() 
    {
		return txtId.getText();
	}
    
    public String darFecha()
    {
    	DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
    	return f.format(chooser.getDate());
    }
    
    
    public String darDia()
    {
    	int dia = chooser.getDate().getDay();
    	
    	if(dia == 0)
    		return "Domingo";
    	else if(dia == 1)
    		return "Lunes";
    	else if(dia == 2)
    		return "Martes";
    	else if(dia == 3)
    		return "Miercoles";
    	else if(dia == 4)
    		return "Jueves";
    	else if(dia == 5)
    		return "Viernes";
    	else 
    		return "Sabado";
    	
    }
    
    public String darHorario()
    {
    	return darDia() + "," + darFecha(); 
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
    
    public ArrayList<String> getServicios()
    {
    	ArrayList<String> rta = new ArrayList<String>(); 
    	for(PanelCrearCampanaTmp p: panels)
    	{
    		rta.add(p.getNombreServ());
    	}
    	return rta;
    }

    
    public ArrayList<Servicios> getServiciosTrue()
    {
    	return tmp;
    }
    
    public ArrayList<Integer> getCapacidades()
    {
    	ArrayList<Integer> rta = new ArrayList<Integer>(); 
    	for(PanelCrearCampanaTmp p: panels)
    	{
    		rta.add(p.getCapacidad());
    	}
    	return rta;
    }
    
    /**
     * Ejecuta una acción cuando se hace click sobre un botón
     * @param evento el evento del click sobre un botón
     */
    public void actionPerformed( ActionEvent evento )
    {
    	 String comando = evento.getActionCommand( );

         if( BUSCAR.equals( comando ) )
         {
        	 ventana.buscarServicios();
         }
         else if(ADD_SERV.equals(comando))
         { 	 
        	 PanelCrearCampanaTmp pCT = new PanelCrearCampanaTmp();
             panels.add(pCT);
             adde.add(pCT);
             this.repaint();
         }
         else if(AGREGAR.equals(comando))
         {
        	 Servicios serv = ( Servicios )servicios.getSelectedValue( );
        	 if(!tmp.contains(serv))
        		 tmp.add(serv);
        	 setListTrue(tmp);
         }
    }
    public void valueChanged( ListSelectionEvent e )
    {
        Servicios serv = ( Servicios )servicios.getSelectedValue( );

        if( serv != null )
        {
        	txtCapacidad.setText(serv.getServicioSaludID()+"");
        }
            

    }
}
