package uniandes.isis2304.EPSAndes.interfazAppPaneles;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import uniandes.isis2304.EPSAndes.interfazApp.InterfazEPSAndesApu;


public class DialogoCrearAdmin extends JDialog
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
    private PanelCrearAdmin panelDatos;

    /**
     * Es el panel con los botones para guardar el disco
     */
    private PanelBotonesAdmin panelBotones;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el diálogo
     * @param id es una referencia a la clase principal de la interfaz
     */
    public DialogoCrearAdmin( InterfazEPSAndesApu id )
    {
        super( id, true );
        principal = id;

        panelDatos = new PanelCrearAdmin( );
        panelBotones = new PanelBotonesAdmin( this );

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
    public void crearAdmin( )
    {
        boolean parametersOk = true;
        String nombre = panelDatos.darNombre();
        String documento = panelDatos.darDocumento();
        String tipo = panelDatos.darTipoDocumento();
        String contrasenia = panelDatos.darContrasenia();
        String correo = panelDatos.darCorreo();
        try 
        {
			int document = Integer.parseInt(documento);
			int contra = Integer.parseInt(contrasenia);
			if(document < 0)
				JOptionPane.showMessageDialog( this, "Ingrese datos positivos" );
			if( ( nombre.equals( "" ) || documento.equals( "" ) ) || ( tipo.equals( "" ) || contrasenia.equals( "" ) || correo.equals( "" ) ) )
			{
				parametersOk = false;
				JOptionPane.showMessageDialog( this, "Todos los campos deben ser llenados para crear el disco" );
			}

			if( parametersOk )
			{
				boolean ok = principal.adicionarAdministrador(nombre, document, tipo, contrasenia, correo);
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
