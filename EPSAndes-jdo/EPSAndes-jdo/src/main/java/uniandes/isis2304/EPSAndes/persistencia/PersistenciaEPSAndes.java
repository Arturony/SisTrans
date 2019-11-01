
package uniandes.isis2304.EPSAndes.persistencia;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import uniandes.isis2304.EPSAndes.negocio.AdministradorD;
import uniandes.isis2304.EPSAndes.negocio.Afiliado;
import uniandes.isis2304.EPSAndes.negocio.CitaMedica;
import uniandes.isis2304.EPSAndes.negocio.EPS;
import uniandes.isis2304.EPSAndes.negocio.EPSAndes;
import uniandes.isis2304.EPSAndes.negocio.Gerente;
import uniandes.isis2304.EPSAndes.negocio.IPS;
import uniandes.isis2304.EPSAndes.negocio.Medico;
import uniandes.isis2304.EPSAndes.negocio.Orden;
import uniandes.isis2304.EPSAndes.negocio.Organizador;
import uniandes.isis2304.EPSAndes.negocio.Recepcionista;
import uniandes.isis2304.EPSAndes.negocio.Servicios;
import uniandes.isis2304.EPSAndes.negocio.Trabajan;
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
	
	public final static String GENERAL = "Consulta medico general";
	
	public final static String URGENCIA = "Urgencias";

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
	
	
	private SQLTrabajan sqlTrabajan;
	
	private SQLServicios sqlServicios;
	
	/**
	 * Atributo para el acceso a la tabla VISITAN de la base de datos
	 */
	private SQLRecepcionista sqlRecepcionista;
	
	private SQLOrganizador sqlOrganizador;
	
	private SQLParticipa sqlParticipa;
	
	private SQLReservas sqlReservas;
	
	private SQLCampana sqlCampana;
	
	/* ****************************************************************
	 * 			Métodos del MANEJADOR DE PERSISTENCIA
	 *****************************************************************/

	/**
	 * Constructor privado con valores por defecto - Patrón SINGLETON
	 */
	private PersistenciaEPSAndes ()
	{
		pmf = JDOHelper.getPersistenceManagerFactory("EPSUNIANDES");		
		crearClasesSQL ();
		
		// Define los nombres por defecto de las tablas de la base de datos
		tablas = new LinkedList<String> ();
		tablas.add ("\"ISIS2304C191920\".\"EPSUNIANDES_sequence\"");
		tablas.add ("\"ISIS2304C191920\".\"Administrador\"");
		tablas.add ("\"ISIS2304C191920\".\"Afiliado\"");
		tablas.add ("\"ISIS2304C191920\".\"CitaMedica\"");
		tablas.add ("\"ISIS2304C191920\".\"Eps\"");
		tablas.add ("\"ISIS2304C191920\".\"Gerente\"");
		tablas.add ("\"ISIS2304C191920\".\"IPS\"");
		tablas.add ("\"ISIS2304C191920\".\"Medicos\"");
		tablas.add ("\"ISIS2304C191920\".\"Ordenes\"");
		tablas.add ("\"ISIS2304C191920\".\"Organizador\"");
		tablas.add ("\"ISIS2304C191920\".\"Recepcionista\"");
		tablas.add ("\"ISIS2304C191920\".\"ServicioSalud\"");
		tablas.add ("\"ISIS2304C191920\".\"Trabajan\"");
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
		sqlTrabajan = new SQLTrabajan(this);
		sqlServicios = new SQLServicios(this);
		sqlOrganizador = new SQLOrganizador(this);
		sqlParticipa = new SQLParticipa(this);
		sqlReservas = new SQLReservas(this);
		sqlCampana = new SQLCampana(this);
	}

	public String darSeqEPSAndes ()
	{
		return tablas.get (0);
	}

	public String darTablaAdmin ()
	{
		return tablas.get (1);
	}

	public String darTablaAfiliado()
	{
		return tablas.get (2);
	}

	public String darTablaCitas()
	{
		return tablas.get (3);
	}

	public String darTablaEps()
	{
		return tablas.get (4);
	}

	public String darTablaGerente ()
	{
		return tablas.get (5);
	}

	public String darTablaIPS ()
	{
		return tablas.get (6);
	}

	public String darTablaMedico()
	{
		return tablas.get (7);
	}
	
	public String darTablaOrdenes()
	{
		return tablas.get (8);
	}
	
	public String darTablaOrganizador()
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
	
	public Afiliado adicionarAfiliado(String nombre, String correo, long id, String tipo, String fechaNacimiento, long epsID)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlAdministradorD.adicionarAfiliado(pm, id, fechaNacimiento, correo, nombre, tipo, epsID);
            tx.commit();
            
            log.trace ("Inserción de Afiliado: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Afiliado(tipo, nombre, correo, id, epsID, fechaNacimiento);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public Medico adicionarMedico(String nombre, long id, String especialidad, String tipoDocumento, int numReg)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlAdministradorD.adicionarMedico(pm, id, especialidad, nombre, tipoDocumento, numReg);
            tx.commit();
            
            log.trace ("Inserción de Medico: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Medico(tipoDocumento, id, nombre, numReg, especialidad);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public Recepcionista adicionarRecepcionista(String nombre, String correo, long id, String tipo, long idIPS)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlAdministradorD.adicionarRecepcionista(pm, id, correo, nombre, tipo, idIPS);
            tx.commit();
            
            log.trace ("Inserción de recepcionista: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Recepcionista(idIPS, nombre, correo, tipo, id);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public AdministradorD adicionarAdministrador(String nombre, String correo, long idAdmin, String tipoDocumento, String contrasenia, long epsID)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlAdministradorD.adicionarAdministrador(pm, idAdmin, contrasenia, correo, nombre, tipoDocumento, epsID);
            tx.commit();
            
            log.trace ("Inserción de Administrador: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new AdministradorD(nombre, correo, contrasenia, idAdmin, epsID);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public Organizador adicionarOrganizador(String nombre, String correo, long idAdmin, String tipoDocumento, String contrasenia, long epsID)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlAdministradorD.adicionarOrganizador(pm, idAdmin, contrasenia, correo, nombre, tipoDocumento, epsID);
            tx.commit();
            
            log.trace ("Inserción de Organizadorr: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Organizador(nombre, correo, contrasenia, idAdmin, epsID);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public Gerente adicionarGerente(String nombre, String correo, long idGerente, String tipoDocumento, long epsID)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlAdministradorD.adicionarGerente(pm, idGerente, correo, nombre, tipoDocumento, epsID);
            tx.commit();
            
            log.trace ("Inserción de Gerente: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Gerente(idGerente, nombre, correo, tipoDocumento, epsID);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public IPS adicionarIPS(String nombre, String localizacion, long idIps, long epsID)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlAdministradorD.adicionarIPS(pm, idIps, localizacion, nombre, epsID);
            tx.commit();
            
            log.trace ("Inserción de IPS: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new IPS(idIps, nombre, localizacion, epsID);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public EPS adicionarEPS(String nombre, long epsID)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlEPS.adicionarEPS(pm, nombre, epsID);
            tx.commit();
            
            log.trace ("Inserción de EPS: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new EPS(epsID, nombre);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public Servicios adicionarServicio(String nombre, String horario, long idServicio, int medicosDisponibles, int idIps)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlAdministradorD.adicionarServicio(pm, idServicio, horario, nombre, medicosDisponibles, idIps);
            tx.commit();
            
            log.trace ("Inserción de Servicio: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Servicios(idServicio, medicosDisponibles, horario, nombre, idIps, 0);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	
	public Trabajan adicionarTrabajan(long idMedico, long idIps) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlTrabajan.adicionarTrabajan (pm, idMedico, idIps);
            tx.commit();

            log.trace ("Inserción de trabajan: [" + idMedico + ", " + idIps + "]. " + tuplasInsertadas + " tuplas insertadas");

            return new Trabajan(idMedico, idIps);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public Orden adicionarOrden(long idServicio, long idAfiliado, long idOrden) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlMedico.crearOrden(pm, idAfiliado, idServicio, idOrden);
            tx.commit();

            log.trace ("Inserción de Orden: [" + idServicio + ", " + idAfiliado + "," + idOrden + "]. " + tuplasInsertadas + " tuplas insertadas");

            return new Orden(idOrden, idAfiliado, idServicio);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public CitaMedica adicionarCita(long idServicio, long idAfiliado, long idCitaMedica, String horario, int llego, int sesiones) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            if(puedePedirCita(idAfiliado, idServicio) != true)
            {
            	throw new Exception("El afiliado no tiene orden para este servicio");
            }
            long tuplasInsertadas = sqlAfiliado.adicionarCitaMedica(pm, idAfiliado, idCitaMedica, sesiones, horario, llego, idServicio);
            tx.commit();

            log.trace ("Inserción de Cita Medica: [" + idServicio + ", " + idAfiliado + "," + idCitaMedica + "," + horario + "," + llego + "," + sesiones + "]. " + tuplasInsertadas + " tuplas insertadas");
            
            reducirCapacidad(idServicio);
            
            return new CitaMedica(idServicio, idAfiliado, horario, idCitaMedica, sesiones, llego);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	private boolean puedePedirCita(long idAfiliado, long idServicio)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		
		Servicios serv = sqlServicios.darServicioEspecifico(pm, idServicio);
		
		if(serv.getNombre().equalsIgnoreCase(GENERAL) || serv.getNombre().equalsIgnoreCase(URGENCIA))
			return true;
		
		List<Orden> ordenes = sqlAfiliado.darOrdenesAfiliado(pm, idAfiliado);
		
		for (Orden orden : ordenes) 
		{
			long idServ = orden.getServicioID();
			if(idServ == idServicio)
			{
				return true;
			}
		}	
		return false;
	}
	
	private void reducirCapacidad(long idServicio)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		
		Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
   
            long serv = sqlServicios.reducirCapacidad(pm, idServicio);
            tx.commit();
            log.trace ("Actualización de servicio " + serv);

        }
        catch (Exception e)
        {
        	//e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public CitaMedica registrarPrestacion(long idAfiliado,int idCitaMedica) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            
            if(!verificarPrestacion(idAfiliado, idCitaMedica))
            {
            	throw new Exception("El afiliado ya llegó a esta cita");
            }
   
            long tuplasInsertadas = sqlRecepcionista.actualizarEstado(pm, idAfiliado, idCitaMedica);
            tx.commit();
            log.trace ("Actualización de Cita Medica: [" + idCitaMedica + ", " + idAfiliado +"]. " + tuplasInsertadas + " tuplas actualizadas");

            return sqlAfiliado.darCitaEspecifica(pm, idCitaMedica, idAfiliado);
        }
        catch (Exception e)
        {
        	//e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	
	
	private boolean verificarPrestacion(long idAfiliado, int idCitaMedica) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		
		CitaMedica cita = sqlAfiliado.darCitaEspecifica(pm, idCitaMedica, idAfiliado);
		
		if(cita.getLlego() == 1)
		{
			return false;
		}
		else
			return true;
		
	}

	public EPS darEPSporID (long epsID)
	{
		return sqlEPS.darEPSID(pmf.getPersistenceManager(), epsID);
	}
	
	public EPS darEPS (String nombre, long epsID)
	{
		return sqlEPS.darEPS(pmf.getPersistenceManager(), nombre, epsID);
	}
	
	public AdministradorD darAdminporID (long adminID)
	{
		return sqlEPS.darAdminID(pmf.getPersistenceManager(), adminID);
	}
	
	public AdministradorD darAdmin (String nombre, String correo, long idAdmin, String tipoDocumento, int contrasenia)
	{
		return sqlEPS.darAdmin(pmf.getPersistenceManager(), nombre, correo, idAdmin, tipoDocumento, contrasenia);
	}
	
	public Organizador darOrganizador (String nombre, String correo, long idAdmin, String tipoDocumento, int contrasenia)
	{
		return sqlEPS.darOrganizador(pmf.getPersistenceManager(), nombre, correo, idAdmin, tipoDocumento, contrasenia);
	}
	
	public Gerente darGerenteID (long adminID)
	{
		return sqlEPS.darGerenteID(pmf.getPersistenceManager(), adminID);
	}
	
	public Gerente darGerente(String nombre, String correo, long idGerente, String tipoDocumento)
	{
		return sqlEPS.darGerente(pmf.getPersistenceManager(), nombre, correo, idGerente, tipoDocumento);
	}
	
	public Medico darMedicoID (long adminID)
	{
		return sqlIPS.darMedicoID(pmf.getPersistenceManager(), adminID);
	}
	
	public Medico darMedico (String nombre, int id, String tipoDocumento, int reg)
	{
		return sqlIPS.darMedico(pmf.getPersistenceManager(), nombre, reg, id, tipoDocumento);
	}
	
	public Afiliado darAfiliadoID (long adminID)
	{
		return sqlIPS.darAfiliadoID(pmf.getPersistenceManager(), adminID);
	}
	
	public Afiliado darAfiliado (String nombre, String correo, int id, String tipo)
	{
		return sqlIPS.darAfiliado(pmf.getPersistenceManager(), nombre, correo, id, tipo);
	}
	
	public Recepcionista darRecepcionistaID (long adminID)
	{
		return sqlIPS.darRecepcionistaID(pmf.getPersistenceManager(), adminID);
	}
	
	public Recepcionista darRecepcionista(String nombre, String correo, int id, String tipo)
	{
		return sqlIPS.darRecepcionista(pmf.getPersistenceManager(), nombre, correo, id, tipo);
	}
	
	public IPS darIPS(String nombre, int documento, String localizacion) {
		return sqlEPS.darIPS(pmf.getPersistenceManager(), nombre, documento, localizacion);
	}
	
	public Servicios darServicio(String nombre, int idServ, String horario) {
		return sqlServicios.darServicio(pmf.getPersistenceManager(), nombre, idServ, horario);
	}
	
	public Orden darOrden(int servicio, int afiliado, int ordenes) {
		return sqlOrdenes.darOrdenes(pmf.getPersistenceManager(), servicio, afiliado, ordenes);
	}
	
	public CitaMedica darCita(int servicio, int afiliado, int idCita, String horario, int sesiones) {
		// TODO Auto-generated method stub
		return sqlCitasMedicas.darCita(pmf.getPersistenceManager(), servicio, afiliado, idCita, horario, sesiones);
	}
	
	public List<Servicios> darServicios()
	{
		return sqlEPS.darServicios(pmf.getPersistenceManager());
	}
	
	public List<IPS> darIPS()
	{
		return sqlEPS.darIPS(pmf.getPersistenceManager());
	}
	
	public List<EPS> darEPS()
	{
		return sqlEPS.darEPS(pmf.getPersistenceManager());
	}
	
	public List<Servicios> consultarServicios(String horario)
	{
		String horario1 = horario.split(",")[0];
		return sqlEPS.consultarServicios(pmf.getPersistenceManager(), horario1);
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


	public SQLTrabajan getSqlTrabajan() {
		return sqlTrabajan;
	}
	
	public SQLOrganizador getSqlOrganizador()
	{
		return sqlOrganizador;
	}
	
	public SQLParticipa getSqlParticipa()
	{
		return sqlParticipa;
	}

	public SQLReservas getSqlReservas() {
		return sqlReservas;
	}

	public SQLCampana getSqlCampana() {
		return sqlCampana;
	}
	
	public long [] limpiarEPS ()
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long [] resp = sqlUtil.limpiarEPSAndes(pm);
            tx.commit ();
            log.info ("Borrada la base de datos");
            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return new long[] {-1, -1, -1, -1, -1, -1, -1};
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
		
	}

	

	

	

	
	
 }
