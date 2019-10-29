package uniandes.isis2304.EPSAndes.interfazAppPaneles;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import uniandes.isis2304.EPSAndes.interfazApp.InterfazEPSAndesApu;


public class DialogoCrearRecepcionista extends JDialog
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
    private PanelCrearRecepcionista panelDatos;

    /**
     * Es el panel con los botones para guardar el disco
     */
    private PanelBotonesRecepcionista panelBotones;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el diálogo
     * @param id es una referencia a la clase principal de la interfaz
     */
    public DialogoCrearRecepcionista( InterfazEPSAndesApu id )
    {
        super( id, true );
        principal = id;

        panelDatos = new PanelCrearRecepcionista( principal.darIPS());
        panelBotones = new PanelBotonesRecepcionista( this );

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
    public void crearRecepcionista( )
    {
        boolean parametersOk = true;
        String nombre = panelDatos.darNombre();
        String documento = panelDatos.darDocumento();
        String tipo = panelDatos.darTipoDocumento();
        String ips = panelDatos.darIPS();
        String correo = panelDatos.darCorreo();
        try 
        {
			int document = Integer.parseInt(documento);
			int contra = Integer.parseInt(ips);
			if(document < 0)
				JOptionPane.showMessageDialog( this, "Ingrese datos positivos" );
			if( ( nombre.equals( "" ) || documento.equals( "" ) ) || ( tipo.equals( "" ) || ips.equals( "" ) || correo.equals( "" ) ) )
			{
				parametersOk = false;
				JOptionPane.showMessageDialog( this, "Todos los campos deben ser llenados para crear al recepcionista" );
			}

			if( parametersOk )
			{
				boolean ok = principal.adicionarRecepcionista(nombre, document, tipo, contra, correo);
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
