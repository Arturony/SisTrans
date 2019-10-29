package uniandes.isis2304.EPSAndes.interfazAppPaneles;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import uniandes.isis2304.EPSAndes.interfazApp.InterfazEPSAndesApu;


public class DialogoCrearOrganizador extends JDialog
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
    private PanelCrearOrganizador panelDatos;

    /**
     * Es el panel con los botones para guardar el disco
     */
    private PanelBotonesOrganizador panelBotones;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el diálogo
     * @param id es una referencia a la clase principal de la interfaz
     */
    public DialogoCrearOrganizador( InterfazEPSAndesApu id )
    {
        super( id, true );
        principal = id;

        panelDatos = new PanelCrearOrganizador(principal.darEPS() );
        panelBotones = new PanelBotonesOrganizador( this );

        getContentPane( ).add( panelDatos, BorderLayout.CENTER );
        getContentPane( ).add( panelBotones, BorderLayout.SOUTH );

        setTitle( "Crear Organizador" );
        pack( );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Guarda el disco
     */
    public void crearOrganizador( )
    {
        boolean parametersOk = true;
        String nombre = panelDatos.darNombre();
        String documento = panelDatos.darDocumento();
        String tipo = panelDatos.darTipoDocumento();
        String contrasenia = panelDatos.darContrasenia();
        String correo = panelDatos.darCorreo();
        String eps = panelDatos.darEps();
        try 
        {
			int document = Integer.parseInt(documento);
			int idEps = Integer.parseInt(eps);
			if(document < 0 && idEps < 0)
				JOptionPane.showMessageDialog( this, "Ingrese datos positivos" );
			if( ( nombre.equals( "" ) || documento.equals( "" ) ) || ( tipo.equals( "" ) || contrasenia.equals( "" ) || correo.equals( "" ) || eps.equals("")) )
			{
				parametersOk = false;
				JOptionPane.showMessageDialog( this, "Todos los campos deben ser llenados para crear el disco" );
			}

			if( parametersOk )
			{
				boolean ok = principal.adicionarOrganizador(nombre, document, tipo, contrasenia, correo, idEps);
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
