
package uniandes.isis2304.EPSAndes.persistencia;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import uniandes.isis2304.EPSAndes.negocio.AdministradorD;
import uniandes.isis2304.EPSAndes.negocio.Afiliado;
import uniandes.isis2304.EPSAndes.negocio.EPS;
import uniandes.isis2304.EPSAndes.negocio.Gerente;
import uniandes.isis2304.EPSAndes.negocio.IPS;
import uniandes.isis2304.EPSAndes.negocio.Medico;
import uniandes.isis2304.EPSAndes.negocio.Recepcionista;

/**
 * 
 * @author 
 */
public class PersistenciaEPSAndes 
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(PersistenciaEPSAndes.class.getName());
	
	/**
	 * Cadena para indicar el tipo de sentencias que se va a utilizar en una consulta
	 */
	public final static String SQL = "javax.jdo.query.SQL";

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * Atributo privado que es el único objeto de la clase - Patrón SINGLETON
	 */
	private static PersistenciaEPSAndes instance;
	
	/**
	 * Fábrica de Manejadores de persistencia, para el manejo correcto de las transacciones
	 */
	private PersistenceManagerFactory pmf;
	
	/**
	 * Arreglo de cadenas con los nombres de las tablas de la base de datos, en su orden:
	 * Secuenciador, tipoBebida, bebida, bar, bebedor, gustan, sirven y visitan
	 */
	private List <String> tablas;
	
	/**
	 * Atributo para el acceso a las sentencias SQL propias a PersistenciaParranderos
	 */
	private SQLUtil sqlUtil;
	
	/**
	 * Atributo para el acceso a la tabla TIPOBEBIDA de la base de datos
	 */
	private SQLMedico sqlMedico;
	
	/**
	 * Atributo para el acceso a la tabla BEBIDA de la base de datos
	 */
	private SQLAfiliado sqlAfiliado;
	
	/**
	 * Atributo para el acceso a la tabla BAR de la base de datos
	 */
	private SQLEPS sqlEPS;
	
	/**
	 * Atributo para el acceso a la tabla BEBIDA de la base de datos
	 */
	private SQLIPS sqlIPS;
	
	/**
	 * Atributo para el acceso a la tabla GUSTAN de la base de datos
	 */
	private SQLAdministradorD sqlAdministradorD;
	
	/**
	 * Atributo para el acceso a la tabla SIRVEN de la base de datos
	 */
	private SQLGerente sqlGerente;
	
	private SQLOrdenes sqlOrdenes;
	
	private SQLCitaMedica sqlCitasMedicas;
	
	private SQLPrestaciones sqlPrestaciones;
	
	private SQLTrabajan sqlTrabajan;
	
	/**
	 * Atributo para el acceso a la tabla VISITAN de la base de datos
	 */
	private SQLRecepcionista sqlRecepcionista;
	
	/* ****************************************************************
	 * 			Métodos del MANEJADOR DE PERSISTENCIA
	 *****************************************************************/

	/**
	 * Constructor privado con valores por defecto - Patrón SINGLETON
	 */
	private PersistenciaEPSAndes ()
	{
		pmf = JDOHelper.getPersistenceManagerFactory("Parranderos");		
		crearClasesSQL ();
		
		// Define los nombres por defecto de las tablas de la base de datos
		tablas = new LinkedList<String> ();
		tablas.add ("EPSUNIANDES_sequence");
		tablas.add ("Administrador");
		tablas.add ("Afiliado");
		tablas.add ("CitaMedica");
		tablas.add ("Eps");
		tablas.add ("Gerente");
		tablas.add ("IPS");
		tablas.add ("Medicos");
		tablas.add ("Ordenes");
		tablas.add ("Prestaciones");
		tablas.add ("Recepcionista");
		tablas.add ("ServicioSalud");
		tablas.add ("Trabajan");
}

	/**
	 * Constructor privado, que recibe los nombres de las tablas en un objeto Json - Patrón SINGLETON
	 * @param tableConfig - Objeto Json que contiene los nombres de las tablas y de la unidad de persistencia a manejar
	 */
	private PersistenciaEPSAndes (JsonObject tableConfig)
	{
		crearClasesSQL ();
		tablas = leerNombresTablas (tableConfig);
		
		String unidadPersistencia = tableConfig.get ("unidadPersistencia").getAsString ();
		log.trace ("Accediendo unidad de persistencia: " + unidadPersistencia);
		pmf = JDOHelper.getPersistenceManagerFactory (unidadPersistencia);
	}

	/**
	 * @return Retorna el único objeto PersistenciaParranderos existente - Patrón SINGLETON
	 */
	public static PersistenciaEPSAndes getInstance ()
	{
		if (instance == null)
		{
			instance = new PersistenciaEPSAndes ();
		}
		return instance;
	}
	
	/**
	 * Constructor que toma los nombres de las tablas de la base de datos del objeto tableConfig
	 * @param tableConfig - El objeto JSON con los nombres de las tablas
	 * @return Retorna el único objeto PersistenciaParranderos existente - Patrón SINGLETON
	 */
	public static PersistenciaEPSAndes getInstance (JsonObject tableConfig)
	{
		if (instance == null)
		{
			instance = new PersistenciaEPSAndes (tableConfig);
		}
		return instance;
	}

	/**
	 * Cierra la conexión con la base de datos
	 */
	public void cerrarUnidadPersistencia ()
	{
		pmf.close ();
		instance = null;
	}
	
	/**
	 * Genera una lista con los nombres de las tablas de la base de datos
	 * @param tableConfig - El objeto Json con los nombres de las tablas
	 * @return La lista con los nombres del secuenciador y de las tablas
	 */
	private List <String> leerNombresTablas (JsonObject tableConfig)
	{
		JsonArray nombres = tableConfig.getAsJsonArray("tablas") ;

		List <String> resp = new LinkedList <String> ();
		for (JsonElement nom : nombres)
		{
			resp.add (nom.getAsString ());
		}
		
		return resp;
	}
	
	/**
	 * Crea los atributos de clases de apoyo SQL
	 */
	private void crearClasesSQL ()
	{
		sqlMedico = new SQLMedico(this);
		sqlAfiliado = new SQLAfiliado(this);
		sqlEPS = new SQLEPS(this);
		sqlIPS = new SQLIPS(this);
		sqlAdministradorD = new SQLAdministradorD(this);
		sqlGerente = new SQLGerente (this);
		sqlRecepcionista = new SQLRecepcionista(this);		
		sqlUtil = new SQLUtil(this);
		sqlOrdenes = new SQLOrdenes(this);
		sqlCitasMedicas = new SQLCitaMedica(this);
		sqlPrestaciones = new SQLPrestaciones(this);
		sqlTrabajan = new SQLTrabajan(this);
	}

	/**
	 * @return La cadena de caracteres con el nombre del secuenciador de parranderos
	 */
	public String darSeqEPSAndes ()
	{
		return tablas.get (0);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de TipoBebida de parranderos
	 */
	public String darTablaAdmin ()
	{
		return tablas.get (1);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Bebida de parranderos
	 */
	public String darTablaAfiliado()
	{
		return tablas.get (2);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Bar de parranderos
	 */
	public String darTablaCitas()
	{
		return tablas.get (3);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Bebedor de parranderos
	 */
	public String darTablaEps()
	{
		return tablas.get (4);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Gustan de parranderos
	 */
	public String darTablaGerente ()
	{
		return tablas.get (5);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Sirven de parranderos
	 */
	public String darTablaIPS ()
	{
		return tablas.get (6);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Visitan de parranderos
	 */
	public String darTablaMedico()
	{
		return tablas.get (7);
	}
	
	public String darTablaOrdenes()
	{
		return tablas.get (8);
	}
	
	public String darTablaPrestaciones()
	{
		return tablas.get (9);
	}
	
	public String darTablaRecepcionista()
	{
		return tablas.get (10);
	}
	
	public String darTablaServicio()
	{
		return tablas.get (11);
	}
	
	public String darTablaTrabajan()
	{
		return tablas.get (12);
	}
	
	/**
	 * Transacción para el generador de secuencia de Parranderos
	 * Adiciona entradas al log de la aplicación
	 * @return El siguiente número del secuenciador de Parranderos
	 */
	private long nextval ()
	{
        long resp = sqlUtil.nextval (pmf.getPersistenceManager());
        log.trace ("Generando secuencia: " + resp);
        return resp;
    }
	
	/**
	 * Extrae el mensaje de la exception JDODataStoreException embebido en la Exception e, que da el detalle específico del problema encontrado
	 * @param e - La excepción que ocurrio
	 * @return El mensaje de la excepción JDO
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
	
	
	
	public SQLMedico getSqlMedico() {
		return sqlMedico;
	}
	
	public SQLAfiliado getSqlAfiliado() {
		return sqlAfiliado;
	}

	public SQLEPS getSqlEPS() {
		return sqlEPS;
	}

	public SQLIPS getSqlIPS() {
		return sqlIPS;
	}

	public SQLGerente getSqlGerente() {
		return sqlGerente;
	}

	public SQLRecepcionista getSqlRecepcionista() {
		return sqlRecepcionista;
	}

	public SQLOrdenes getSqlOrdenes() {
		return sqlOrdenes;
	}

	public SQLCitaMedica getSqlCitasMedicas() {
		return sqlCitasMedicas;
	}

	public SQLPrestaciones getSqlPrestaciones() {
		return sqlPrestaciones;
	}

	public SQLTrabajan getSqlTrabajan() {
		return sqlTrabajan;
	}
	
 }
