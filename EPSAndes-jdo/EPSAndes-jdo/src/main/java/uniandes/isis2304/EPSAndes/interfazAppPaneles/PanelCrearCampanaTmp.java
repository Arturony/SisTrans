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

import org.datanucleus.transaction.jta.JBossTransactionManagerLocator;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;

import uniandes.isis2304.EPSAndes.negocio.Servicios;

public class PanelCrearCampanaTmp extends JPanel
{

	
    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------
   

    /**
     * Es la etiqueta "Registro"
     */
    private JLabel etiquetaServicio;

    private JComboBox<String> txtTipo;
    
    private JLabel etiquetaCapacidad;
    
    private JTextField txtCapacidad;

    
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel creando las etiquetas y los campos de texto necesarios para crear un nuevo disco
     */
    public PanelCrearCampanaTmp()
    {  	

    	setLayout(new GridLayout(2,2,5,5));
    	
    	etiquetaServicio = new JLabel( "Nombre: " );
        etiquetaServicio.setFont( etiquetaServicio.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaServicio );
        
        String[] servicios = {"Consulta medico general", "Consulta medico especialista", "Urgencias", "Examen Diagnostico", "Terapia", "Hospitalizacion", "Procedimientos médico especializado",
        		"Examen de Sangre", "Radiografia", "Consulta Odontologica", "Jornada de Vacunacion"};
        
        txtTipo = new JComboBox<String>(servicios);
        add( txtTipo );
        
        etiquetaCapacidad = new JLabel( "Capacidad: " );
        etiquetaCapacidad.setFont( etiquetaCapacidad.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaCapacidad );

        txtCapacidad = new JTextField( 2 );
        add( txtCapacidad );
    	
        setPreferredSize(new Dimension(200,60));

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    public String getNombreServ()
    {
    	return (String) txtTipo.getSelectedItem();
    }
    
    public int getCapacidad()
    {
    	return Integer.parseInt(txtCapacidad.getText());
    }
   
}
