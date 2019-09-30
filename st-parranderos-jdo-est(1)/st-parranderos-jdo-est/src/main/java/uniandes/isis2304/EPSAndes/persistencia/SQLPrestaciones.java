
package uniandes.isis2304.EPSAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.EPSAndes.negocio.Medico;
import uniandes.isis2304.EPSAndes.negocio.Prestaciones;

/**
 * @author 
 */
class SQLPrestaciones 
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
	public SQLPrestaciones (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	

	public long adicionarPrestaciones(PersistenceManager pm, long idServicio, long idIps) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaPrestaciones () + "(\"servicioSaludID\", \"iPSID\") values (?, ?)");
        q.setParameters(idServicio, idIps);
        return (long) q.executeUnique();
	}

	public long eliminarPrestaciones (PersistenceManager pm, long idServicio, long idIps)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPrestaciones () + " WHERE \"servicioSaludID\" = ? AND iPSID = ?");
        q.setParameters(idServicio, idIps);
        return (long) q.executeUnique();
	}

	public List<Prestaciones> darPrestaciones (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPrestaciones());
		q.setResultClass(Prestaciones.class);
		List<Prestaciones> resp = (List<Prestaciones>) q.execute();
		return resp;
	}

}
