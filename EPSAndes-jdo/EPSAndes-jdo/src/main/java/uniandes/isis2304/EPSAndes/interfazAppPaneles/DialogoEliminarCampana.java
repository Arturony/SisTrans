package uniandes.isis2304.EPSAndes.interfazAppPaneles;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import uniandes.isis2304.EPSAndes.interfazApp.InterfazEPSAndesApu;
import uniandes.isis2304.EPSAndes.negocio.Campana;
import uniandes.isis2304.EPSAndes.negocio.Reservas;
import uniandes.isis2304.EPSAndes.negocio.Servicios;


public class DialogoEliminarCampana extends JDialog
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
    private PanelEliminarCampana panelDatos;

    /**
     * Es el panel con los botones para guardar el disco
     */
    private PanelBotonesECampana panelBotones;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el diálogo
     * @param id es una referencia a la clase principal de la interfaz
     */
    public DialogoEliminarCampana( InterfazEPSAndesApu id )
    {
        super( id, true );
        principal = id;

        panelDatos = new PanelEliminarCampana(this, principal.darCampanas(), principal.consultarServiciosEnCampania(principal.darCampanas().get(0).getCampanaID()));
        panelBotones = new PanelBotonesECampana(this);

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
    public void verificarEliminacion( )
    {
        if(panelDatos.getServiciosTrue().size() == darServicioCampana().size())
        {
        	PanelConfirmacionEliminacion p = new PanelConfirmacionEliminacion(this, principal);
        	p.setLocationRelativeTo( this );
            p.setVisible( true );
        }
        else
        {
        	modificarCampana();
        }
    }
    
    public void eliminarCampana()
    {
    	for(Reservas r : principal.consultarReservasCampana(panelDatos.darCampanaSelect().getCampanaID()))
    	{
    		principal.eliminarReservas(r.getServicioID(), r.getCampanaID());
    	}
    	principal.eliminarCampana(panelDatos.darCampanaSelect().getNombre(), panelDatos.darCampanaSelect().getCampanaID(), panelDatos.darCampanaSelect().getEpsID());
    	dispose();
    }
    
    public void modificarCampana()
    {
    	for(Servicios s: panelDatos.getServiciosTrue())
    	{
    		principal.eliminarReservas(s.getServicioSaludID(), panelDatos.darCampaniaID());
    	}
    	dispose();
    }
    
    public List<Campana> darCampanas()
    {
    	return principal.darCampanas();
    }
    
    public List<Servicios> darServicioCampana()
    {
    	return principal.consultarServiciosEnCampania(panelDatos.darCampaniaID());
    }
}
