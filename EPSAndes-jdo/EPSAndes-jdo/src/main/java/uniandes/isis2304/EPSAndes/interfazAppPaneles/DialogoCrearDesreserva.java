package uniandes.isis2304.EPSAndes.interfazAppPaneles;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import uniandes.isis2304.EPSAndes.interfazApp.InterfazEPSAndesApu;
import uniandes.isis2304.EPSAndes.negocio.Servicios;


public class DialogoCrearDesreserva extends JDialog
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
    private PanelCrearDesreserva panelDatos;

    /**
     * Es el panel con los botones para guardar el disco
     */
    private PanelBotonesDesreserva panelBotones;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el diálogo
     * @param id es una referencia a la clase principal de la interfaz
     */
    public DialogoCrearDesreserva( InterfazEPSAndesApu id )
    {
        super( id, true );
        principal = id;

        panelDatos = new PanelCrearDesreserva(principal.consultarServiciosReservados());
        panelBotones = new PanelBotonesDesreserva(this);

        getContentPane( ).add( panelDatos, BorderLayout.CENTER );
        getContentPane( ).add( panelBotones, BorderLayout.SOUTH );

        setTitle( "Crear Disco" );
        pack( );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Guarda el disco
     */
    public void crearDesreserva( )
    {
        for(Servicios s: panelDatos.getServiciosTrue())
        {
        	principal.desreservarServicio(s.getServicioSaludID());
        }
        dispose();
    }
    
    public void darServicios()
    {
    	panelDatos.setList(principal.consultarServiciosReservados());
    }
}
