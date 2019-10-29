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

public class PanelCrearServicio extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------
    /**
     * Es la etiqueta "Nombre"
     */
    private JLabel etiquetaTipo;

    /**
     * Es el campo de texto para ingresar el título del nuevo disco
     */
    private JComboBox<String> txtTipo;

    /**
     * Es la etiqueta "Documento"
     */
    private JLabel etiquetaHorario;

    /**
     * Es la etiqueta "Registro"
     */
    private JLabel etiquetaCapacidad;

    /**
     * Es el campo de texto para ingresar la imagen del nuevo disco
     */
    private JTextField txtCapacidad;
    
    /**
     * Es la etiqueta "Especialidad"
     */
    private JLabel etiquetaID;

    /**
     * Es el campo de texto para ingresar el género del nuevo disco
     */
    private JTextField txtID;
    
    private JLabel etiquetaIPSID;

    /**
     * Es el campo de texto para ingresar el género del nuevo disco
     */
    private JTextField txtIPSID;
    
    private JComboBox<String> cmbDia;
    
    private JComboBox<String> cmbDia1;
    
    private JComboBox<String> cmbHora;
    
    private JComboBox<String> cmbMinuto;
    
    private JComboBox<String> cmbHora1;
    
    private JComboBox<String> cmbMinuto1;
    
    private String[] semana;
    
    private JLabel a;
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel creando las etiquetas y los campos de texto necesarios para crear un nuevo disco
     */
    public PanelCrearServicio( )
    {
        setLayout( new GridLayout( 6, 2, 5, 5 ) );
        setSize(300, 400);
        
        semana = new String[]{"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
        
        String[] servicios = {"Consulta medico general", "Consulta medico especialista", "Urgencias", "Examen Diagnostico", "Terapia", "Hospitalizacion", "Procedimientos médico especializado"};
        
        etiquetaTipo = new JLabel( "Nombre: " );
        etiquetaTipo.setFont( etiquetaTipo.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaTipo );

        txtTipo = new JComboBox<String>(servicios);
        add( txtTipo );

        etiquetaHorario = new JLabel( "Horario: " );
        etiquetaHorario.setFont( etiquetaHorario.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaHorario );

        JPanel aux = new JPanel();
        
        aux.setLayout(new GridLayout(2,5));
        cmbDia = new JComboBox<String>(semana);
        aux.add(cmbDia);
        
        a = new JLabel( "a " );
        a.setFont( a.getFont( ).deriveFont( Font.PLAIN ) );
        aux.add( a );
        
        cmbDia1 = new JComboBox<String>(semana);
        aux.add(cmbDia1);
        
        aux.add(new JLabel());
        aux.add(new JLabel());
        
        cmbHora = new JComboBox<String>();
        aux.add(cmbHora);

        cmbMinuto = new JComboBox<String>();
        aux.add(cmbMinuto);
        
        a = new JLabel( "a " );
        a.setFont( a.getFont( ).deriveFont( Font.PLAIN ) );
        aux.add( a );
        
        cmbHora1 = new JComboBox<String>();
        aux.add(cmbHora1);

        cmbMinuto1 = new JComboBox<String>();
        aux.add(cmbMinuto1);
        
        add(aux);

        etiquetaCapacidad = new JLabel( "Capacidad: " );
        etiquetaCapacidad.setFont( etiquetaCapacidad.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaCapacidad );

        txtCapacidad = new JTextField( 2 );
        add( txtCapacidad );
        
        etiquetaID = new JLabel( "ID: " );
        etiquetaID.setFont( etiquetaID.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaID );

        txtID = new JTextField( 2 );
        add( txtID );
        
        etiquetaIPSID = new JLabel( "ID IPS: " );
        etiquetaIPSID.setFont( etiquetaIPSID.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaIPSID );

        txtIPSID = new JTextField( 2 );
        add( txtIPSID );

        for( int i = 0; i < 60; i++ )
        {
        	if(i < 1)
        	{
        		cmbMinuto.addItem( new Integer( i )+ "0" );
        		cmbMinuto1.addItem( new Integer( i ) + "0");
        	}
        	else if(i > 0 && i < 10)
        	{
        		cmbMinuto.addItem("0" + new Integer( i ) );
        		cmbMinuto1.addItem( "0" + new Integer( i ));
        	}
        	else
        	{
        		cmbMinuto1.addItem( new Integer( i )+ "" );
                cmbMinuto.addItem( new Integer( i ) + "");
        	}
        		
            
        }
        
        for( int i = 0; i < 24; i++ )
        {
        	if(i < 1)
        	{
        		cmbHora.addItem( new Integer( i )+ "0" );
                cmbHora1.addItem( new Integer( i ) + "0");
        	}
        	else if(i > 0 && i < 10)
        	{
        		cmbHora.addItem("0" + new Integer( i ) );
                cmbHora1.addItem( "0" + new Integer( i ));
        	}
        	else
        	{
        		cmbHora.addItem( new Integer( i )+ "" );
                cmbHora1.addItem( new Integer( i ) + "");
        	}
        }
        
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
        return (String) txtTipo.getSelectedItem();
    }
    
    public String darCapacidad()
    {
    	return txtCapacidad.getText();
    }
    
    public String darID()
    {
    	return txtID.getText();
    }
    
    public String darIDIPS()
    {
    	return txtIPSID.getText();
    }
    
    public Integer darDia()
    {
    	return (Integer) cmbDia.getSelectedIndex();
    }
    
    public Integer darDia1()
    {
    	return (Integer) cmbDia1.getSelectedIndex();
    }
    
    public String darHora()
    {
    	return (String) cmbHora.getSelectedItem();
    }

    public String darHora1()
    {
    	return (String) cmbHora1.getSelectedItem();
    }
    
    public String darMinutos()
    {
    	return (String) cmbMinuto.getSelectedItem();
    }
    
    public String darMinutos1()
    {
    	return (String) cmbMinuto1.getSelectedItem();
    }
    
    public String darHorario()
    {
    	return darDias() + " de " + darHora()+ ":" + darMinutos() + " a " + darHora1() + ":" + darMinutos1();
    }
    
    public String darDias()
    {
    	String rta = semana[darDia()];
    	for(int i = darDia(); i < darDia1(); i++)
    	{
    		rta+= "," + semana[i+1];
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
