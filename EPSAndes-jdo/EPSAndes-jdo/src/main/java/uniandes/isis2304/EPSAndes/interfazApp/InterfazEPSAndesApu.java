
package uniandes.isis2304.EPSAndes.interfazApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import uniandes.isis2304.EPSAndes.interfazAppPaneles.DialogoCrearAdmin;
import uniandes.isis2304.EPSAndes.interfazAppPaneles.DialogoCrearAfiliado;
import uniandes.isis2304.EPSAndes.interfazAppPaneles.DialogoCrearCampana;
import uniandes.isis2304.EPSAndes.interfazAppPaneles.DialogoCrearCita;
import uniandes.isis2304.EPSAndes.interfazAppPaneles.DialogoCrearDesreserva;
import uniandes.isis2304.EPSAndes.interfazAppPaneles.DialogoCrearEPS;
import uniandes.isis2304.EPSAndes.interfazAppPaneles.DialogoCrearGerente;
import uniandes.isis2304.EPSAndes.interfazAppPaneles.DialogoCrearIPS;
import uniandes.isis2304.EPSAndes.interfazAppPaneles.DialogoCrearMedico;
import uniandes.isis2304.EPSAndes.interfazAppPaneles.DialogoCrearOrden;
import uniandes.isis2304.EPSAndes.interfazAppPaneles.DialogoCrearOrganizador;
import uniandes.isis2304.EPSAndes.interfazAppPaneles.DialogoCrearRecepcionista;
import uniandes.isis2304.EPSAndes.interfazAppPaneles.DialogoCrearReserva;
import uniandes.isis2304.EPSAndes.interfazAppPaneles.DialogoCrearServicio;
import uniandes.isis2304.EPSAndes.interfazAppPaneles.DialogoRegistrarLlegada;
import uniandes.isis2304.EPSAndes.interfazAppPaneles.DialogoUsuario;
import uniandes.isis2304.EPSAndes.negocio.AdministradorD;
import uniandes.isis2304.EPSAndes.negocio.Afiliado;
import uniandes.isis2304.EPSAndes.negocio.EPS;
import uniandes.isis2304.EPSAndes.negocio.EPSAndes;
import uniandes.isis2304.EPSAndes.negocio.Gerente;
import uniandes.isis2304.EPSAndes.negocio.IPS;
import uniandes.isis2304.EPSAndes.negocio.Medico;
import uniandes.isis2304.EPSAndes.negocio.Organizador;
import uniandes.isis2304.EPSAndes.negocio.Recepcionista;
import uniandes.isis2304.EPSAndes.negocio.Servicios;
import uniandes.isis2304.EPSAndes.negocio.VOAdministradorD;
import uniandes.isis2304.EPSAndes.negocio.VOAfiliado;
import uniandes.isis2304.EPSAndes.negocio.VOCampana;
import uniandes.isis2304.EPSAndes.negocio.VOCitaMedica;
import uniandes.isis2304.EPSAndes.negocio.VOEPS;
import uniandes.isis2304.EPSAndes.negocio.VOGerente;
import uniandes.isis2304.EPSAndes.negocio.VOIPS;
import uniandes.isis2304.EPSAndes.negocio.VOMedico;
import uniandes.isis2304.EPSAndes.negocio.VOOrden;
import uniandes.isis2304.EPSAndes.negocio.VOOrganizador;
import uniandes.isis2304.EPSAndes.negocio.VOParticipa;
import uniandes.isis2304.EPSAndes.negocio.VORecepcionista;
import uniandes.isis2304.EPSAndes.negocio.VOReservas;
import uniandes.isis2304.EPSAndes.negocio.VOServicios;

/**
 * Clase principal de la interfaz
 * @author 
 */
@SuppressWarnings("serial")

public class InterfazEPSAndesApu extends JFrame implements ActionListener
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(InterfazEPSAndesApu.class);
	
	/**
	 * Ruta al archivo de configuración de la interfaz
	 */
	private static final String CONFIG_INTERFAZ = "./src/main/resources/config/interfaceConfigApp"; 
	
	/**
	 * Ruta al archivo de configuración de los nombres de tablas de la base de datos
	 */
	private static final String CONFIG_TABLAS = "./src/main/resources/config/TablasBD_A.json"; 
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
    /**
     * Objeto JSON con los nombres de las tablas de la base de datos que se quieren utilizar
     */
    private JsonObject tableConfig;
    
    /**
     * Asociación a la clase principal del negocio.
     */
    private EPSAndes epsAndes;
    
	/* ****************************************************************
	 * 			Atributos de interfaz
	 *****************************************************************/
    /**
     * Objeto JSON con la configuración de interfaz de la app.
     */
    private JsonObject guiConfig;
    
    /**
     * Panel de despliegue de interacción para los requerimientos
     */
    private PanelDatos panelDatos;
    
    /**
     * Menú de la aplicación
     */
    private JMenuBar menuBar;
    
    private String login;
    
    private String nombreU;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
    /**
     * Construye la ventana principal de la aplicación. <br>
     * <b>post:</b> Todos los componentes de la interfaz fueron inicializados.
     */
    public InterfazEPSAndesApu( )
    {
    	String log4jConfPath = "src/main/resources/log4j.properties";
    	BasicConfigurator.configure();
    	epsAndes = new EPSAndes ();
    	panelDatos = new PanelDatos ( );
    	if(verificarExistenciaInicial() != true)
    	{
    		adicionarEPS("Eps Andes", 1);
    		adicionarAdministrador("Admin", 1, "Cedula Ciudadania", "1", "admin@epsandes.edu.co");
    	}
    	mostrarDialogoLogin();
    	
        // Carga la configuración de la interfaz desde un archivo JSON
        guiConfig = openConfig ("Interfaz", CONFIG_INTERFAZ + this.getLogin() + ".json");
        
        // Configura la apariencia del frame que contiene la interfaz gráfica
        configurarFrame ( );
        if (guiConfig != null) 	   
        {
     	   crearMenu( guiConfig.getAsJsonArray("menuBar") );
        }
        
        
        
    	String path = guiConfig.get("bannerPath").getAsString();

        setLayout (new BorderLayout());
        add (new JLabel (new ImageIcon (path)), BorderLayout.NORTH );          
        add( panelDatos, BorderLayout.CENTER );
       
        panelDatos.actualizarInterfaz("");
        panelDatos.actualizarLogin(nombreU);
        
	        
    }
    
	/* ****************************************************************
	 * 			Métodos de configuración de la interfaz
	 *****************************************************************/
    /**
     * Lee datos de configuración para la aplicació, a partir de un archivo JSON o con valores por defecto si hay errores.
     * @param tipo - El tipo de configuración deseada
     * @param archConfig - Archivo Json que contiene la configuración
     * @return Un objeto JSON con la configuración del tipo especificado
     * 			NULL si hay un error en el archivo.
     */
    private JsonObject openConfig (String tipo, String archConfig)
    {
    	JsonObject config = null;
		try 
		{
			Gson gson = new Gson( );
			FileReader file = new FileReader (archConfig);
			JsonReader reader = new JsonReader ( file );
			config = gson.fromJson(reader, JsonObject.class);
			log.info ("Se encontró un archivo de configuración válido: " + tipo);
		} 
		catch (Exception e)
		{
//			e.printStackTrace ();
			log.info ("NO se encontró un archivo de configuración válido");			
			JOptionPane.showMessageDialog(null, "No se encontró un archivo de configuración de interfaz válido: " + tipo, "Parranderos App", JOptionPane.ERROR_MESSAGE);
		}	
        return config;
    }
    
    /**
     * Método para configurar el frame principal de la aplicación
     */
    private void configurarFrame(  )
    {
    	int alto = 0;
    	int ancho = 0;
    	String titulo = "";	
    	
    	if ( guiConfig == null )
    	{
    		log.info ( "Se aplica configuración por defecto" );			
			titulo = "Parranderos APP Default";
			alto = 300;
			ancho = 500;
    	}
    	else
    	{
			log.info ( "Se aplica configuración indicada en el archivo de configuración" );
    		titulo = guiConfig.get("title").getAsString();
			alto= guiConfig.get("frameH").getAsInt();
			ancho = guiConfig.get("frameW").getAsInt();
    	}
    	
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setLocation (50,50);
        setResizable( true );
        setBackground( Color.WHITE );

        setTitle( titulo );
		setSize ( ancho, alto);        
    }

    /**
     * Método para crear el menú de la aplicación con base em el objeto JSON leído
     * Genera una barra de menú y los menús con sus respectivas opciones
     * @param jsonMenu - Arreglo Json con los menùs deseados
     */
    private void crearMenu(  JsonArray jsonMenu )
    {    	
    	// Creación de la barra de menús
        menuBar = new JMenuBar();       
        for (JsonElement men : jsonMenu)
        {
        	// Creación de cada uno de los menús
        	JsonObject jom = men.getAsJsonObject(); 

        	String menuTitle = jom.get("menuTitle").getAsString();        	
        	JsonArray opciones = jom.getAsJsonArray("options");
        	
        	JMenu menu = new JMenu( menuTitle);
        	
        	for (JsonElement op : opciones)
        	{       	
        		// Creación de cada una de las opciones del menú
        		JsonObject jo = op.getAsJsonObject(); 
        		String lb =   jo.get("label").getAsString();
        		String event = jo.get("event").getAsString();
        		
        		JMenuItem mItem = new JMenuItem( lb );
        		mItem.addActionListener( this );
        		mItem.setActionCommand(event);
        		
        		menu.add(mItem);
        	}       
        	menuBar.add( menu );
        }        
        setJMenuBar ( menuBar );	
    }
    
    private boolean verificarExistenciaInicial()
    {
    	if(epsAndes.consultarEPS(1) != null && epsAndes.consultarAdminID(1) != null)
    		return true;
    	return false;
    }

   


	/* ****************************************************************
	 * 			Métodos administrativos
	 *****************************************************************/
	/**
	 * Muestra el log de Parranderos
	 */
	public void mostrarLogParranderos ()
	{
		mostrarArchivo ("parranderos.log");
	}
	
	/**
	 * Muestra el log de datanucleus
	 */
	public void mostrarLogDatanuecleus ()
	{
		mostrarArchivo ("datanucleus.log");
	}
	
	/**
	 * Limpia el contenido del log de parranderos
	 * Muestra en el panel de datos la traza de la ejecución
	 */
	public void limpiarLogParranderos ()
	{
		// Ejecución de la operación y recolección de los resultados
		boolean resp = limpiarArchivo ("parranderos.log");

		// Generación de la cadena de caracteres con la traza de la ejecución de la demo
		String resultado = "\n\n************ Limpiando el log de parranderos ************ \n";
		resultado += "Archivo " + (resp ? "limpiado exitosamente" : "NO PUDO ser limpiado !!");
		resultado += "\nLimpieza terminada";

		panelDatos.actualizarInterfaz(resultado);
	}
	
	/**
	 * Limpia el contenido del log de datanucleus
	 * Muestra en el panel de datos la traza de la ejecución
	 */
	public void limpiarLogDatanucleus ()
	{
		// Ejecución de la operación y recolección de los resultados
		boolean resp = limpiarArchivo ("datanucleus.log");

		// Generación de la cadena de caracteres con la traza de la ejecución de la demo
		String resultado = "\n\n************ Limpiando el log de datanucleus ************ \n";
		resultado += "Archivo " + (resp ? "limpiado exitosamente" : "NO PUDO ser limpiado !!");
		resultado += "\nLimpieza terminada";

		panelDatos.actualizarInterfaz(resultado);
	}
	
	/**
	 * Limpia todas las tuplas de todas las tablas de la base de datos de parranderos
	 * Muestra en el panel de datos el número de tuplas eliminadas de cada tabla
	 */
	public void limpiarBD ()
	{
		try 
		{
    		// Ejecución de la demo y recolección de los resultados
			long eliminados [] = epsAndes.limpiarBD();
			
			// Generación de la cadena de caracteres con la traza de la ejecución de la demo
			String resultado = "\n\n************ Limpiando la base de datos ************ \n";
			resultado += eliminados [0] + " Administradores eliminados\n";
			resultado += eliminados [1] + " Afiliados eliminados\n";
			resultado += eliminados [2] + " Citas eliminados\n";
			resultado += eliminados [3] + " EPS eliminadas\n";
			resultado += eliminados [4] + " Gerentes eliminados\n";
			resultado += eliminados [5] + " IPS eliminados\n";
			resultado += eliminados [6] + " Medicos eliminados\n";
			resultado += eliminados [7] + " Prestaciones eliminados\n";
			resultado += eliminados [8] + " Recepcionistas eliminadas\n";
			resultado += eliminados [9] + " Servicios eliminados\n";
			resultado += eliminados [6] + " Trabajan eliminados\n";
			resultado += "\nLimpieza terminada";
   
			panelDatos.actualizarInterfaz(resultado);
		} 
		catch (Exception e) 
		{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}
	
	/**
	 * Muestra la presentación general del proyecto
	 */
	public void mostrarPresentacionGeneral ()
	{
		mostrarArchivo ("data/00-ST-ParranderosJDO.pdf");
	}
	
	/**
	 * Muestra el modelo conceptual de Parranderos
	 */
	public void mostrarModeloConceptual ()
	{
		mostrarArchivo ("data/Modelo Conceptual Parranderos.pdf");
	}
	
	/**
	 * Muestra el esquema de la base de datos de Parranderos
	 */
	public void mostrarEsquemaBD ()
	{
		mostrarArchivo ("data/Esquema BD Parranderos.pdf");
	}
	
	/**
	 * Muestra el script de creación de la base de datos
	 */
	public void mostrarScriptBD ()
	{
		mostrarArchivo ("data/EsquemaParranderos.sql");
	}
	
	/**
	 * Muestra la arquitectura de referencia para Parranderos
	 */
	public void mostrarArqRef ()
	{
		mostrarArchivo ("data/ArquitecturaReferencia.pdf");
	}
	
	/**
	 * Muestra la documentación Javadoc del proyectp
	 */
	public void mostrarJavadoc ()
	{
		mostrarArchivo ("doc/index.html");
	}
	
	/**
     * Muestra la información acerca del desarrollo de esta apicación
     */
    public void acercaDe ()
    {
		String resultado = "\n\n ************************************\n\n";

		panelDatos.actualizarInterfaz(resultado);		
    }
    

	/* ****************************************************************
	 * 			Métodos privados para la presentación de resultados y otras operaciones
	 *****************************************************************/

    /**
     * Genera una cadena de caracteres con la descripción de la excepcion e, haciendo énfasis en las excepcionsde JDO
     * @param e - La excepción recibida
     * @return La descripción de la excepción, cuando es javax.jdo.JDODataStoreException, "" de lo contrario
     */
	private String darDetalleException(Exception e) 
	{
		String resp = "";
		if (e.getClass().getName().equals("javax.jdo.JDODataStoreException"))
		{
			JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
			return je.getNestedExceptions() [0].getMessage();
		}
		return resp;
	}

	/**
	 * Genera una cadena para indicar al usuario que hubo un error en la aplicación
	 * @param e - La excepción generada
	 * @return La cadena con la información de la excepción y detalles adicionales
	 */
	private String generarMensajeError(Exception e) 
	{
		String resultado = "************ Error en la ejecución\n";
		resultado += e.getLocalizedMessage() + ", " + darDetalleException(e);
		resultado += "\n\nRevise datanucleus.log y parranderos.log para más detalles";
		return resultado;
	}

	/**
	 * Limpia el contenido de un archivo dado su nombre
	 * @param nombreArchivo - El nombre del archivo que se quiere borrar
	 * @return true si se pudo limpiar
	 */
	private boolean limpiarArchivo(String nombreArchivo) 
	{
		BufferedWriter bw;
		try 
		{
			bw = new BufferedWriter(new FileWriter(new File (nombreArchivo)));
			bw.write ("");
			bw.close ();
			return true;
		} 
		catch (IOException e) 
		{
//			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Abre el archivo dado como parámetro con la aplicación por defecto del sistema
	 * @param nombreArchivo - El nombre del archivo que se quiere mostrar
	 */
	private void mostrarArchivo (String nombreArchivo)
	{
		try
		{
			Desktop.getDesktop().open(new File(nombreArchivo));
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mostrarDialogoLogin()
	{
		DialogoUsuario dialogo = new DialogoUsuario( this );
        dialogo.setLocationRelativeTo( this );
        dialogo.setVisible( true );
	}
	
	public void mostrarDialogoEps()
	{
		DialogoCrearEPS dialogo = new DialogoCrearEPS( this );
        dialogo.setLocationRelativeTo( this );
        dialogo.setVisible( true );
	}
	
	public boolean adicionarEps(String nombre, int id)
	{
		
		try 
		{	    		
			VOEPS tb = epsAndes.adicionarEPS(nombre, id);
			if (tb == null)
			{
				throw new Exception ("No se pudo crear una EPS con nombre y id: " + nombre + ", " + id);
			}
			String resultado = "En adicionarEps\n\n";
			resultado += "Eps adicionado exitosamente: " + tb;
			resultado += "\n Operación terminada";
			panelDatos.actualizarInterfaz(resultado);
			return true;
		} 
		catch (Exception e) 
		{
			//				e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
			return false;
		}
	 }
	
	public void mostrarDialogoMedico()
	{
		DialogoCrearMedico dialogo = new DialogoCrearMedico( this );
        dialogo.setLocationRelativeTo( this );
        dialogo.setVisible( true );
	}
	
	public boolean adicionarMedico(String nombre, String especialidad, String tipoDocumento, int numReg, long id)
	{
		
		try 
		{	    		
			VOMedico tb = epsAndes.adicionarMedico(nombre, especialidad, tipoDocumento, numReg, id);
			if (tb == null)
			{
				throw new Exception ("No se pudo crear un medico con nombre y registro medico: " + nombre + ", " + id);
			}
			String resultado = "En adicionarMedico\n\n";
			resultado += "Medico adicionado exitosamente: " + tb;
			resultado += "\n Operación terminada";
			panelDatos.actualizarInterfaz(resultado);
			return true;
		} 
		catch (Exception e) 
		{
			//				e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
			return false;
		}
	 }
	
	public void mostrarDialogoAfiliado()
	{
		DialogoCrearAfiliado dialogo = new DialogoCrearAfiliado( this );
        dialogo.setLocationRelativeTo( this );
        dialogo.setVisible( true );
	}
	
	public boolean adicionarAfiliado(String nombre, int documento, String tipoDocumento, String fecha, String correo, int idEps)
	{
		
		try 
		{	    		
			VOAfiliado tb = epsAndes.adicionarAfiliado(nombre, documento, tipoDocumento, fecha, correo, idEps);
			if (tb == null)
			{
				throw new Exception ("No se pudo crear un Afiliado con nombre y registro medico: " + nombre + ", " + documento);
			}
			String resultado = "En adicionarAfiliado\n\n";
			resultado += "Afiliado adicionado exitosamente: " + tb;
			resultado += "\n Operación terminada";
			panelDatos.actualizarInterfaz(resultado);
			return true;
		} 
		catch (Exception e) 
		{
			//				e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
			return false;
		}
	 }
	
	public void mostrarDialogoAdmin()
	{
		DialogoCrearAdmin dialogo = new DialogoCrearAdmin( this );
        dialogo.setLocationRelativeTo( this );
        dialogo.setVisible( true );
	}
	
	public boolean adicionarOrganizador(String nombre, int documento, String tipoDocumento, String fecha, String correo, int idEps)
	{
		
		try 
		{	    		
			VOOrganizador tb = epsAndes.adicionarOrganizador(nombre, documento, tipoDocumento, fecha, correo, idEps);
			if (tb == null)
			{
				throw new Exception ("No se pudo crear un Organizador con nombre y documento: " + nombre + ", " + documento);
			}
			String resultado = "En adicionarOrganizador\n\n";
			resultado += "Organizador adicionado exitosamente: " + tb;
			resultado += "\n Operación terminada";
			panelDatos.actualizarInterfaz(resultado);
			return true;
		} 
		catch (Exception e) 
		{
			//				e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
			return false;
		}
	 }
	
	public void mostrarDialogoOrganizador()
	{
		DialogoCrearOrganizador dialogo = new DialogoCrearOrganizador( this );
        dialogo.setLocationRelativeTo( this );
        dialogo.setVisible( true );
	}
	
	public boolean adicionarAdministrador(String nombre, int documento, String tipoDocumento, String contrasenia, String correo)
	{
		
		try 
		{	    		
			VOAdministradorD tb = epsAndes.adicionarAdministrador(nombre, documento, tipoDocumento, contrasenia, correo);
			if (tb == null)
			{
				throw new Exception ("No se pudo crear un Adinistrador con nombre y documento: " + nombre + ", " + documento);
			}
			String resultado = "En adicionarAdministrador\n\n";
			resultado += "Adinistrador adicionado exitosamente: " + tb;
			resultado += "\n Operación terminada";
			panelDatos.actualizarInterfaz(resultado);
			return true;
		} 
		catch (Exception e) 
		{
			//				e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
			return false;
		}
	 }
	
	public void mostrarDialogoGerente()
	{
		DialogoCrearGerente dialogo = new DialogoCrearGerente( this );
        dialogo.setLocationRelativeTo( this );
        dialogo.setVisible( true );
	}
	
	public boolean adicionarGerente(String nombre, int documento, String tipoDocumento, String correo)
	{
		
		try 
		{	    		
			VOGerente tb = epsAndes.adicionarGerente(nombre, correo, documento, tipoDocumento);
			if (tb == null)
			{
				throw new Exception ("No se pudo crear un gerente con nombre y documento: " + nombre + ", " + documento);
			}
			String resultado = "En adicionarGerente\n\n";
			resultado += "Gerente adicionado exitosamente: " + tb;
			resultado += "\n Operación terminada";
			panelDatos.actualizarInterfaz(resultado);
			return true;
		} 
		catch (Exception e) 
		{
			//				e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
			return false;
		}
	 }
	
	public void mostrarDialogoRecepcionista()
	{
		DialogoCrearRecepcionista dialogo = new DialogoCrearRecepcionista( this );
        dialogo.setLocationRelativeTo( this );
        dialogo.setVisible( true );
	}
	
	public boolean adicionarRecepcionista(String nombre, int documento, String tipoDocumento, int idIps, String correo)
	{
		
		try 
		{	    		
			VORecepcionista tb = epsAndes.adicionarRecepcionista(nombre, documento, tipoDocumento, idIps, correo);
			if (tb == null)
			{
				throw new Exception ("No se pudo crear un Recepcionista con nombre y documento: " + nombre + ", " + documento);
			}
			String resultado = "En adicionarRecepcionista\n\n";
			resultado += "Recepcionista adicionado exitosamente: " + tb;
			resultado += "\n Operación terminada";
			panelDatos.actualizarInterfaz(resultado);
			return true;
		} 
		catch (Exception e) 
		{
			//				e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
			return false;
		}
	 }
	
	public void mostrarDialogoServicio()
	{
		DialogoCrearServicio dialogo = new DialogoCrearServicio( this );
        dialogo.setLocationRelativeTo( this );
        dialogo.setVisible( true );
	}
	
	public boolean adicionarServicio(String nombre, int idServ, String horario, int medicosDisponibles, int idIps, int reserva)
	{
		
		try 
		{	    		
			VOServicios tb = epsAndes.adicionarServicio(nombre, idServ, horario, medicosDisponibles, idIps, reserva);
			if (tb == null)
			{
				throw new Exception ("No se pudo crear un Servico con nombre y id: " + nombre + ", " + idServ);
			}
			String resultado = "En adicionarServicio\n\n";
			resultado += "Servicio adicionado exitosamente: " + tb;
			resultado += "\n Operación terminada";
			panelDatos.actualizarInterfaz(resultado);
			return true;
		} 
		catch (Exception e) 
		{
			//				e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
			return false;
		}
	 }
	
	public void mostrarDialogoCita()
	{
		DialogoCrearCita dialogo = new DialogoCrearCita( this );
        dialogo.setLocationRelativeTo( this );
        dialogo.setVisible( true );
	}
	
	public boolean adicionarCita(int afiliado, int servicio, int idCita, String horario, int sesiones)
	{
		
		try 
		{	    		
			VOCitaMedica tb = epsAndes.adicionarCita(afiliado, servicio, idCita, horario, sesiones);
			if (tb == null)
			{
				throw new Exception ("No se pudo crear una Cita con id: " + idCita);
			}
			String resultado = "En adicionarCita\n\n";
			resultado += "Cita adicionado exitosamente: " + tb;
			resultado += "\n Operación terminada";
			panelDatos.actualizarInterfaz(resultado);
			return true;
		} 
		catch (Exception e) 
		{
			//				e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
			return false;
		}
	 }
	
	public void mostrarDialogoOrden()
	{
		DialogoCrearOrden dialogo = new DialogoCrearOrden( this );
        dialogo.setLocationRelativeTo( this );
        dialogo.setVisible( true );
	}
	
	public boolean adicionarOrden(int afiliado, int servicio, int ordenes)
	{
		
		try 
		{	    		
			VOOrden tb = epsAndes.adicionarOrden(afiliado, servicio, ordenes);
			if (tb == null)
			{
				throw new Exception ("No se pudo crear una Orden con  id: " + ordenes);
			}
			String resultado = "En adicionarOrden\n\n";
			resultado += "Orden adicionado exitosamente: " + tb;
			resultado += "\n Operación terminada";
			panelDatos.actualizarInterfaz(resultado);
			return true;
		} 
		catch (Exception e) 
		{
			//				e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
			return false;
		}
	 }
	
	public void mostrarDialogoIPS()
	{
		DialogoCrearIPS dialogo = new DialogoCrearIPS( this );
        dialogo.setLocationRelativeTo( this );
        dialogo.setVisible( true );
	}
	
	public boolean adicionarIPS(String nombre, int id, String local, int idEps)
	{
		
		try 
		{	    		
			VOIPS tb = epsAndes.adicionarIPS(nombre, id, local, idEps);
			if (tb == null)
			{
				throw new Exception ("No se pudo crear una Ips con  id: " + id);
			}
			String resultado = "En adicionarIPS\n\n";
			resultado += "Ips adicionado exitosamente: " + tb;
			resultado += "\n Operación terminada";
			panelDatos.actualizarInterfaz(resultado);
			return true;
		} 
		catch (Exception e) 
		{
			//				e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
			return false;
		}
	 }
	
	public void mostrarDialogoRegistrarCampania()
	{
		DialogoCrearCampana dialogo = new DialogoCrearCampana( this );
        dialogo.setLocationRelativeTo( this );
        dialogo.setVisible( true );
	}
	
	public boolean adicionarCampana(String nombre, int id, String fecha, int cap ,int idEps)
	{
		
		try 
		{	    		
			VOCampana tb = epsAndes.agregarCampana(idEps, nombre, fecha, cap, idEps);
			if (tb == null)
			{
				throw new Exception ("No se pudo crear una Campaña	 con  id: " + id);
			}
			String resultado = "En adicionarCampana\n\n";
			resultado += "Campaña adicionado exitosamente: " + tb;
			resultado += "\n Operación terminada";
			panelDatos.actualizarInterfaz(resultado);
			return true;
		} 
		catch (Exception e) 
		{
			//				e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
			return false;
		}
	}
	 
	public boolean adicionarReservas(long idServicio, int idCampana)
	{
		
		try 
		{	    		
			VOReservas tb = epsAndes.adicionarReservan(idServicio, idCampana);
			if (tb == null)
			{
				throw new Exception ("No se pudo crear un Reserva: ");
			}
			String resultado = "En adicionarParticipan\n\n";
			resultado += "Reserva adicionado exitosamente: " + tb;
			resultado += "\n Operación terminada";
			panelDatos.actualizarInterfaz(resultado);
			return true;
		} 
		catch (Exception e) 
		{
			//				e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
			return false;
		}
	}
	
	public boolean adicionarParticipan(int idAfiliado, int idCampana)
	{
		
		try 
		{	    		
			VOParticipa tb = epsAndes.adicionarParticipan(idAfiliado, idCampana);
			if (tb == null)
			{
				throw new Exception ("No se pudo crear una Participan: ");
			}
			String resultado = "En adicionarParticipan\n\n";
			resultado += "Participan adicionado exitosamente: " + tb;
			resultado += "\n Operación terminada";
			panelDatos.actualizarInterfaz(resultado);
			return true;
		} 
		catch (Exception e) 
		{
			//				e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
			return false;
		}
	}
	
	public void mostrarDialogoLlegada()
	{
		DialogoRegistrarLlegada dialogo = new DialogoRegistrarLlegada(this );
        dialogo.setLocationRelativeTo( this );
        dialogo.setVisible( true );
	}
	
	public boolean prestarServicio(int idAfiliado, int idCita)
	{
		
		try 
		{	    		
			VOCitaMedica tb = epsAndes.prestarServicio(idAfiliado, idCita);
			if (tb == null)
			{
				throw new Exception ("No se pudo actualizar la cita con id: " + idCita);
			}
			String resultado = "En prestarServicio\n\n";
			resultado += "Cita Modificada exitosamente: " + tb;
			resultado += "\n Operación terminada";
			panelDatos.actualizarInterfaz(resultado);
			return true;
		} 
		catch (Exception e) 
		{
			//				e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
			return false;
		}
	 }
	
	public void mostrarDialogoReserva()
	{
		DialogoCrearReserva dialogo = new DialogoCrearReserva(this );
        dialogo.setLocationRelativeTo( this );
        dialogo.setVisible( true );
	}
	
	public void mostrarDialogoDesreserva()
	{
		DialogoCrearDesreserva dialogo = new DialogoCrearDesreserva(this );
        dialogo.setLocationRelativeTo( this );
        dialogo.setVisible( true );
	}
	
	public boolean reducirCapacidad(long idServicio, int reducion)
	{
		
		try 
		{	    		
			long tb = epsAndes.reducirCapacidadNumero(idServicio, reducion);
			if (tb == 0)
			{
				throw new Exception ("No se pudo actualizar la cita con id: " + idServicio);
			}
			String resultado = "En reducirCapacidad\n\n";
			resultado += "Servicio Modificado exitosamente: " + tb;
			resultado += "\n Operación terminada";
			panelDatos.actualizarInterfaz(resultado);
			return true;
		} 
		catch (Exception e) 
		{
			//				e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
			return false;
		}
	 }
	
	public boolean adicionarEPS(String nombre, int epsID)
	{
		
		try 
		{	    		
			VOEPS tb = epsAndes.adicionarEPS(nombre, epsID);
			if (tb == null)
			{
				throw new Exception ("No se pudo crear una eps con nombre y id: " + nombre + ", " + epsID);
			}
			String resultado = "En adicionarEPS\n\n";
			resultado += "EPS adicionado exitosamente: " + tb;
			resultado += "\n Operación terminada";
			panelDatos.actualizarInterfaz(resultado);
			return true;
		} 
		catch (Exception e) 
		{
			//				e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
			return false;
		}
	 }
	
	

	/* ****************************************************************
	 * 			Métodos de la Interacción
	 *****************************************************************/
    /**
     * Método para la ejecución de los eventos que enlazan el menú con los métodos de negocio
     * Invoca al método correspondiente según el evento recibido
     * @param pEvento - El evento del usuario
     */
    @Override
	public void actionPerformed(ActionEvent pEvento)
	{
		String evento = pEvento.getActionCommand( );		
        try 
        {
			Method req = InterfazEPSAndesApu.class.getMethod ( evento );			
			req.invoke ( this );
		} 
        catch (Exception e) 
        {
			e.printStackTrace();
		} 
	}
    
    
    
    public EPS consultarEPSID(int epsID)
    {
    	return epsAndes.consultarEPS(epsID);
    }
    
    public EPS consultarEPS(int epsID, String nombre)
    {
    	return epsAndes.consultarEPS(nombre, epsID);
    }
    
    public AdministradorD consultarAdminID(int epsID)
    {
    	return epsAndes.consultarAdminID(epsID);
    }

    public AdministradorD consultarAdmin(int documento, String nombre, String tipo, int contrasenia, String correo)
    {
    	return epsAndes.consultarAdministrador(nombre, documento, tipo, contrasenia, correo);
    }
    
    public Organizador consultarOrganizador(int documento, String nombre, String tipo, int contrasenia, String correo)
    {
    	return epsAndes.consultarOrganizador(nombre, documento, tipo, contrasenia, correo);
    }
    
    public Gerente consultarGerenteID(int epsID)
    {
    	return epsAndes.consultarGerenteID(epsID);
    }
    
    public Gerente consultarGerente(int idGerente, String nombre, String correo, String tipo)
    {
    	return epsAndes.consultarGerente(nombre, correo, idGerente, tipo);
    }
    
    public Afiliado consultarAfiliadoID(int epsID)
    {
    	return epsAndes.consultarAfiliadoID(epsID);
    }
    
    public Afiliado consultarAfiliado(int documento, String nombre, String tipoDocumento, String correo)
    {
    	return epsAndes.consultarAfiliado(nombre, documento, tipoDocumento, correo);
    }
    
    public Medico consultarMedicoID(int epsID)
    {
    	return epsAndes.consultarMedicoID(epsID);
    }
    
    public Medico consultarMedico(int id, String nombre, String tipoDocumento, int reg)
    {
    	return epsAndes.conusltarMedico(nombre, tipoDocumento, id, reg);
    }
    
    public Recepcionista consultarRecepcionistaID(int epsID)
    {
    	return epsAndes.consultarRecepcionistaID(epsID);
    }
    
    public Recepcionista consultarRecepcionista(int documento, String nombre, String tipo, String correo)
    {
    	return epsAndes.consultarRecepcionista(nombre, documento, tipo, correo);
    }
    
    public long reservarServicio(long idServicio)
    {
    	return epsAndes.reservarServicio(idServicio);
    }
    
    public long desreservarServicio(long idServicio)
    {
    	return epsAndes.desreservarServicio(idServicio);
    }
    
    public List<Servicios> darServicios()
    {
    	return epsAndes.darServicios();
    }
    
    public List<IPS> darIPS()
    {
    	return epsAndes.darIPS();
    }
    
    public List<EPS> darEPS()
    {
    	return epsAndes.darEPS();
    }
    
    public List<Servicios> consultarServiciosFecha(String horario)
    {
    	return epsAndes.consultarServiciosFecha(horario);
    }
    
    public List<Servicios> consultarServiciosNombre(String nombre)
    {
    	return epsAndes.consultarServiciosNombre(nombre);
    }
    
    public List<Servicios> consultarServiciosReservados()
    {
    	return epsAndes.consultarServiciosReservados();
    }
    
    public List<Servicios> consultarServiciosNoreservados()
    {
    	return epsAndes.consultarServiciosNoreservados();
    }
    
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public PanelDatos getPanelDatos()
	{
		return this.panelDatos;
	}

	public String getNombreU() {
		return nombreU;
	}

	public void setNombreU(String nombreU) {
		this.nombreU = nombreU;
	}

	/* ****************************************************************
	 * 			Programa principal
	 *****************************************************************/
    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz
     * @param args Arreglo de argumentos que se recibe por línea de comandos
     */
    public static void main( String[] args )
    {
        try
        {
        	
            // Unifica la interfaz para Mac y para Windows.
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );
            InterfazEPSAndesApu interfaz = new InterfazEPSAndesApu( );
            interfaz.setVisible( true );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }
}
