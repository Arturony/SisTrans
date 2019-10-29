package uniandes.isis2304.EPSAndes.interfazAppPaneles;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import uniandes.isis2304.EPSAndes.interfazApp.InterfazEPSAndesApu;


public class DialogoCrearServicio extends JDialog
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
    private PanelCrearServicio panelDatos;

    /**
     * Es el panel con los botones para guardar el disco
     */
    private PanelBotonesServicio panelBotones;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el diálogo
     * @param id es una referencia a la clase principal de la interfaz
     */
    public DialogoCrearServicio( InterfazEPSAndesApu id )
    {
        super( id, true );
        principal = id;

        panelDatos = new PanelCrearServicio( principal.darIPS());
        panelBotones = new PanelBotonesServicio( this );

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
    public void crearServicio( )
    {
        boolean parametersOk = true;
        String nombre = panelDatos.darNombre();
        String horario = panelDatos.darHorario();
        String ipsId = panelDatos.darIDIPS();
        String id = panelDatos.darID();
        String capacidad = panelDatos.darCapacidad();
        try 
        {
			int idServ = Integer.parseInt(id);
			int idIps = Integer.parseInt(ipsId);
			int cap = Integer.parseInt(capacidad);
			if(cap < 0 && idServ < 0 && idIps < 0)
				JOptionPane.showMessageDialog( this, "Ingrese datos positivos" );
			if( ( nombre.equals( "" ) || horario.equals( "" ) ) || ( ipsId.equals( "" ) || id.equals( "" ) || capacidad.equals( "" ) ) )
			{
				parametersOk = false;
				JOptionPane.showMessageDialog( this, "Todos los campos deben ser llenados para crear el disco" );
			}

			if( parametersOk )
			{
				boolean ok = principal.adicionarServicio(nombre, idServ, horario, cap, idIps);
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
