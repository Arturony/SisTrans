
package uniandes.isis2304.EPSAndes.persistencia;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.EPSAndes.negocio.Gerente;
import uniandes.isis2304.EPSAndes.negocio.Orden;
import uniandes.isis2304.EPSAndes.negocio.Servicios;

/**
 * @author 
 */
class SQLServicios 
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos
	 * Se renombra acá para facilitar la escritura de las sentencias
	 */
	private final static String SQL = PersistenciaEPSAndes.SQL;

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia general de la aplicación
	 */
	private PersistenciaEPSAndes pp;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor
	 * @param pp - El Manejador de persistencia de la aplicación
	 */
	public SQLServicios (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	
	public Servicios darServicioEspecifico (PersistenceManager pm, long idServicio)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio() + "WHERE \"servicioSaludID\" = ?");
		q.setParameters(idServicio);
		q.setResultClass(Servicios.class);
		return (Servicios) q.execute();
	}
	
	public List<Servicios> darServicios (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio());
		q.setResultClass(Servicios.class);
		List<Servicios> resp = (List<Servicios>) q.execute();
		return resp;
	}

	public Servicios darServicio(PersistenceManager pm, String nombre, int idServ, String horario) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio() + "WHERE \"servicioSaludID\" = ? AND \"nombre\" = ? AND \"horario\" = ? ");
		q.setParameters(idServ, nombre, horario);
		q.setResultClass(Servicios.class);
		return (Servicios) q.execute();
	}
		 	
}
