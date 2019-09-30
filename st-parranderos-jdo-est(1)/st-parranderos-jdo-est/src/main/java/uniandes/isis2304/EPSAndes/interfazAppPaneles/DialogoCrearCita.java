package uniandes.isis2304.EPSAndes.interfazAppPaneles;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import uniandes.isis2304.EPSAndes.interfazApp.InterfazEPSAndesApu;


public class DialogoCrearCita extends JDialog
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
    private PanelCrearCita panelDatos;

    /**
     * Es el panel con los botones para guardar el disco
     */
    private PanelBotonesCita panelBotones;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el diálogo
     * @param id es una referencia a la clase principal de la interfaz
     */
    public DialogoCrearCita( InterfazEPSAndesApu id )
    {
        super( id, true );
        principal = id;

        panelDatos = new PanelCrearCita( );
        panelBotones = new PanelBotonesCita( this );

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
    public void crearCita( )
    {
        boolean parametersOk = true;
        String horario = panelDatos.darHorario();
        String sesiones = panelDatos.darSesiones();
        String idAfiliado = panelDatos.darAfiliado();
        String idServicio = panelDatos.darServicio();
        String id = panelDatos.darID();
        try 
        {
			int sesion = Integer.parseInt(sesiones);
			int serv = Integer.parseInt(idServicio);
			int afil = Integer.parseInt(idAfiliado);
			int idOrden = Integer.parseInt(id);
			if(sesion < 0 && serv < 0 && afil < 0 && idOrden < 0)
				JOptionPane.showMessageDialog( this, "Ingrese datos positivos" );
			if( ( horario.equals( "" ) || sesiones.equals( "" ) ) || ( idAfiliado.equals( "" ) || idServicio.equals( "" ) || id.equals( "" ) ) )
			{
				parametersOk = false;
				JOptionPane.showMessageDialog( this, "Todos los campos deben ser llenados para crear el disco" );
			}

			if( parametersOk )
			{
				boolean ok = principal.adicionarCita(afil, serv, idOrden, horario, sesion);
				if( ok )
				dispose( );
				else
					dispose();
			}
		} 
        catch (Exception e) 
        {
        	JOptionPane.showMessageDialog( this, "Ingrese datos numericos para Documento y Registro Medico" );
		}
    }
}
