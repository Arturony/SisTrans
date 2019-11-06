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
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;

import uniandes.isis2304.EPSAndes.negocio.Servicios;

public class PanelCrearCita extends JPanel implements ActionListener, ListSelectionListener
{

    private static final String BUSCAR = "Buscar";
	
    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------
    
    private DialogoCrearCita ventana;
    
    /**
     * Es la etiqueta "Nombre"
     */
    private JLabel etiquetaFecha;

    /**
     * Es el campo de texto para ingresar el título del nuevo disco
     */
    private JTextField txtHorario;
    
    private JLabel etiquetaHorario;
    
    private JComboBox<String> hora;
    
    private JComboBox<String> minutos;

    /**
     * Es la etiqueta "Documento"
     */
    private JLabel etiquetaSesiones;

    /**
     * Es el campo de texto para ingresar el artista del nuevo disco
     */
    private JTextField txtSesiones;
    
    private JLabel etiquetaAfiliado;
    
    private JTextField txtAfiliado;;

    /**
     * Es la etiqueta "Registro"
     */
    private JLabel etiquetaServicio;

    /**
     * Es el campo de texto para ingresar la imagen del nuevo disco
     */
    private JTextField txtServicio;
    
    /**
     * Es la etiqueta "Especialidad"
     */
    private JLabel etiquetaID;

    /**
     * Es el campo de texto para ingresar el género del nuevo disco
     */
    private JTextField txtID;
    
    private JDateChooser chooser;
    
    private JList servicios;
    
    private JButton botonBuscar;
    
    private JScrollPane scroll;
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel creando las etiquetas y los campos de texto necesarios para crear un nuevo disco
     */
    public PanelCrearCita( DialogoCrearCita dcc )
    {
    	ventana = dcc;
    	
    	JPanel prinp = new JPanel();
    	JPanel aux1 = new JPanel();
    	setLayout(new BorderLayout());
        prinp.setLayout( new GridLayout( 0, 2, 5, 5 ) );
        aux1.setLayout(new BorderLayout());
        setPreferredSize(new Dimension(400,400));
        
        etiquetaFecha = new JLabel( "Fecha: " );
        etiquetaFecha.setFont( etiquetaFecha.getFont( ).deriveFont( Font.PLAIN ) );
        prinp.add( etiquetaFecha );

        chooser = new JDateChooser();
        prinp.add(chooser);
        
        etiquetaHorario = new JLabel( "Horario: " );
        etiquetaHorario.setFont( etiquetaHorario.getFont( ).deriveFont( Font.PLAIN ) );
        prinp.add( etiquetaHorario );
        
        JPanel aux = new JPanel();
        
        aux.setLayout(new GridLayout(1,2));
        hora = new JComboBox<String>();
        aux.add(hora);
        
        minutos = new JComboBox<String>();
        aux.add(minutos);
        
        prinp.add(aux);
        
        etiquetaSesiones = new JLabel( "Sesiones: " );
        etiquetaSesiones.setFont( etiquetaSesiones.getFont( ).deriveFont( Font.PLAIN ) );
        prinp. add( etiquetaSesiones );

        txtSesiones = new JTextField( 2 );
        prinp. add( txtSesiones );
        
        etiquetaAfiliado = new JLabel( "ID del Afiliado: " );
        etiquetaAfiliado.setFont( etiquetaAfiliado.getFont( ).deriveFont( Font.PLAIN ) );
        prinp.add( etiquetaAfiliado );
        
        txtAfiliado = new JTextField( 2 );
        prinp.add( txtAfiliado );

        etiquetaServicio = new JLabel( "ID del Servicio: " );
        etiquetaServicio.setFont( etiquetaServicio.getFont( ).deriveFont( Font.PLAIN ) );
        prinp. add( etiquetaServicio );

        txtServicio = new JTextField( 2 );
        txtServicio.setEditable(false);
        prinp.add( txtServicio );
        
        etiquetaID = new JLabel( "ID: " );
        etiquetaID.setFont( etiquetaID.getFont( ).deriveFont( Font.PLAIN ) );
        prinp.add( etiquetaID );

        txtID = new JTextField( 2 );
        prinp.add( txtID );
        
        aux1.add(prinp,BorderLayout.NORTH);
        
        botonBuscar = new JButton( "Buscar" );
        botonBuscar.setActionCommand( BUSCAR );
        botonBuscar.addActionListener( this );
        aux1.add( botonBuscar, BorderLayout.SOUTH );
        
        add(aux1, BorderLayout.NORTH);
        
        scroll = new JScrollPane();
        servicios = new JList();
        servicios.addListSelectionListener(this);
        scroll.getViewport().add(servicios);
        add(scroll, BorderLayout.SOUTH);

        for( int i = 0; i < 60; i++ )
        {
        	if(i < 1)
        	{
        		minutos.addItem( new Integer( i )+ "0" );
        	}
        	else if(i > 0 && i < 10)
        	{
        		minutos.addItem("0" + new Integer( i ) );
        	}
        	else
        	{
        		minutos.addItem( new Integer( i )+ "" );
        	}
        		
            
        }
        
        for( int i = 0; i < 24; i++ )
        {
        	if(i < 1)
        	{
        		hora.addItem( new Integer( i )+ "0" );
        	}
        	else if(i > 0 && i < 10)
        	{
        		hora.addItem("0" + new Integer( i ) );
        	}
        	else
        	{
        		hora.addItem( new Integer( i )+ "" );
        	}
        }

        setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Da el valor del campo de texto con el artista del disco
     * @return El texto con el artista
     */
    public String darSesiones( )
    {
        return txtSesiones.getText( );
    }

    
    public String darServicio()
    {
    	return txtServicio.getText();
    }
    
    public String darID()
    {
    	return txtID.getText();
    }
    
    public String darAfiliado() 
    {
		return txtAfiliado.getText();
	}
    
    public String darFecha()
    {
    	DateFormat f = new SimpleDateFormat("YYYY-MM-dd");
    	return f.format(chooser.getDate());
    }
    
    public String darHora()
    {
    	return (String) hora.getSelectedItem();
    }
    
    public String darMinutos()
    {
    	return (String) minutos.getSelectedItem();
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
    	return  darFecha() + " " + darHora() + ":" + darMinutos() + ":00"; 
    }
    
    public void setList(List<Servicios> services)
    {
        servicios.setListData(services.toArray());
        scroll.getViewport().removeAll();
        scroll.getViewport().add(servicios);
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
    }
    public void valueChanged( ListSelectionEvent e )
    {
        Servicios serv = ( Servicios )servicios.getSelectedValue( );

        if( serv != null )
        {
        	txtServicio.setText(serv.getServicioSaludID()+"");
        }
            

    }
}
