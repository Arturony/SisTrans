package uniandes.isis2304.EPSAndes.interfazAppPaneles;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import uniandes.isis2304.EPSAndes.interfazApp.InterfazEPSAndesApu;


public class DialogoRegistrarLlegada extends JDialog
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
    private PanelRegistrarLlegada panelDatos;

    /**
     * Es el panel con los botones para guardar el disco
     */
    private PanelBotonesRegistrar panelBotones;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el diálogo
     * @param id es una referencia a la clase principal de la interfaz
     */
    public DialogoRegistrarLlegada( InterfazEPSAndesApu id )
    {
        super( id, true );
        principal = id;

        panelDatos = new PanelRegistrarLlegada( );
        panelBotones = new PanelBotonesRegistrar( this );

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
    public void registrarLlegada( )
    {
        boolean parametersOk = true;
        String cita = panelDatos.darCita();
        String afilia3 = panelDatos.darAfiliado();
        try 
        {
			int idAfiliado = Integer.parseInt(afilia3);
			int idCita = Integer.parseInt(cita);
			if(idAfiliado < 0 && idCita < 0)
				JOptionPane.showMessageDialog( this, "Ingrese datos válidos" );
			if( ( cita.equals( "" ) || afilia3.equals( "" ) ) )
			{
				parametersOk = false;
				JOptionPane.showMessageDialog( this, "Todos los campos deben ser llenados para crear el disco" );
			}

			if( parametersOk )
			{
				boolean ok = principal.prestarServicio(idAfiliado, idCita);
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
