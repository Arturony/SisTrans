package uniandes.isis2304.EPSAndes.interfazAppPaneles;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import uniandes.isis2304.EPSAndes.interfazApp.InterfazEPSAndesApu;


public class DialogoEjecutarQuery extends JDialog
{
	// -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia a la clase principal de la interfaz
     */
    private InterfazEPSAndesApu principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Es el panel con los datos para crear el nuevo disco
     */
    private PanelEjecutarQuery panelDatos;


    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el diálogo
     * @param id es una referencia a la clase principal de la interfaz
     */
    public DialogoEjecutarQuery( InterfazEPSAndesApu id )
    {
        super( id, true );
        principal = id;

        panelDatos = new PanelEjecutarQuery(this);

        getContentPane( ).add( panelDatos, BorderLayout.CENTER );

        setTitle( "Crear Disco" );
        pack( );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Guarda el disco
     */
    public void ejecutarQuery( )
    {
        try
        {
        	String rta = principal.ejecutarQuery(panelDatos.getText());
        	panelDatos.actualizarText(rta);
        }
        catch (Exception e) 
        {
        	JOptionPane.showMessageDialog( this, "No se pudo ejecutar el query por: " + e.getMessage() );
        }
    }
    
    public void end()
    {
    	dispose();
    }
}
