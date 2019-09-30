package uniandes.isis2304.EPSAndes.interfazAppPaneles;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import uniandes.isis2304.EPSAndes.interfazApp.InterfazEPSAndesApu;
import uniandes.isis2304.EPSAndes.negocio.AdministradorD;


public class DialogoUsuario extends JDialog
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
    private PanelSeleccionarUsuario panelDatos;

    /**
     * Es el panel con los botones para guardar el disco
     */
    private PanelBotonesUsuario panelBotones;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el diálogo
     * @param id es una referencia a la clase principal de la interfaz
     */
    public DialogoUsuario( InterfazEPSAndesApu id )
    {
        super( id, true );
        principal = id;
        panelDatos = new PanelSeleccionarUsuario( );
        panelBotones = new PanelBotonesUsuario( this );

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
    public void entrar( )
    {
        boolean parametersOk = true;
        String nombreU = panelDatos.darNombreUsuario();
        String documento = panelDatos.darDocumento();
        String tipo = panelDatos.darTipoDocumento();
        String tipoU = panelDatos.darTipoUsuario();
        String correo = panelDatos.darCorreo();
        String contra = panelDatos.darContrasenia();
        try 
        {
			int document = Integer.parseInt(documento);
			
			if(document < 0)
				JOptionPane.showMessageDialog( this, "Ingrese datos positivos" );
			if( ( nombreU.equals( "" ) || documento.equals( "" ) ) || ( tipo.equals( "" ) || correo.equals( "" ) || contra.equals( "" ) ) )
			{
				parametersOk = false;
				JOptionPane.showMessageDialog( this, "Todos los campos deben ser llenados para crear el disco" );
			}
			if( parametersOk )
			{
				if(tipoU.equals("Administrador de Datos") && principal.consultarAdmin(document) != null)
				{
					principal.setLogin("Administrador");
					principal.getPanelDatos().actualizarLogin("Hola! " + nombreU +  " \n Tipo de Usuario: " + principal.getLogin());
					dispose();
				}
				else if(tipoU.equals("Afiliado") && principal.consultarAfilaido(document) != null)
				{
					principal.setLogin("Afiliado");
					principal.getPanelDatos().actualizarLogin("Hola! " + nombreU + " Tipo de Usuario: " + principal.getLogin());

					dispose();
				}
				else if(tipoU.equals("Gerente") && principal.consultarGerente(document) != null)
				{
					principal.setLogin("Gerente");
					principal.getPanelDatos().actualizarLogin("Hola! " + nombreU + " Tipo de Usuario: " + principal.getLogin());

					dispose();
				}
				else if(tipoU.equals("Medico") && principal.consultarMedico(document) != null)
				{
					principal.setLogin("Medico");
					principal.getPanelDatos().actualizarLogin("Hola! " + nombreU + " Tipo de Usuario: " + principal.getLogin());

					dispose();
				}
				else if(tipoU.equals("Recepcionista") && principal.consultarRecepcionista(document) != null)
				{
					principal.setLogin("Recepcionista");
					principal.getPanelDatos().actualizarLogin("Hola! " + nombreU + " Tipo de Usuario: " + principal.getLogin());
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog( this, "Datos Invalidos" );
				}
			}
		} 
        catch (Exception e) 
        {
        	JOptionPane.showMessageDialog( this, "Ingrese datos numericos para Documento y Registro Medico" );
		}
    }
    
    public void cerrarApp()
    {
    	System.exit(0);
    }
}
