package uniandes.isis2304.EPSAndes.interfazAppPaneles;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import uniandes.isis2304.EPSAndes.interfazApp.InterfazEPSAndesApu;


public class DialogoCrearOrden extends JDialog
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
    private PanelCrearOrden panelDatos;

    /**
     * Es el panel con los botones para guardar el disco
     */
    private PanelBotonesOrden panelBotones;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el diálogo
     * @param id es una referencia a la clase principal de la interfaz
     */
    public DialogoCrearOrden( InterfazEPSAndesApu id )
    {
        super( id, true );
        principal = id;

        panelDatos = new PanelCrearOrden( );
        panelBotones = new PanelBotonesOrden( this );

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
    public void crearOrden( )
    {
        boolean parametersOk = true;
        String id = panelDatos.darID();
        String idA = panelDatos.darAfiliado();
        String idS = panelDatos.darServicio();
        try 
        {
			int idOrden = Integer.parseInt(id);
			int idAfiliado = Integer.parseInt(idA);
			int idServicio = Integer.parseInt(idS);
			if(idOrden < 0 && idAfiliado < 0 && idServicio < 0)
				JOptionPane.showMessageDialog( this, "Ingrese datos positivos" );
			if( ( id.equals( "" ) || idA.equals( "" ) ) || (idS.equals( "" ) ) )
			{
				parametersOk = false;
				JOptionPane.showMessageDialog( this, "Todos los campos deben ser llenados para crear la orden" );
			}

			if( parametersOk )
			{
				boolean ok = principal.adicionarOrden(idAfiliado, idServicio, idOrden);
				if( ok )
				dispose( );
				else
					dispose();
			}
		} 
        catch (Exception e) 
        {
        	JOptionPane.showMessageDialog( this, "Ingrese datos numericos" );
		}
    }
}
