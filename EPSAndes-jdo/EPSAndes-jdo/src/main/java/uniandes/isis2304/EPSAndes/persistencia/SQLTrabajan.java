
package uniandes.isis2304.EPSAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.EPSAndes.negocio.Medico;
import uniandes.isis2304.EPSAndes.negocio.Trabajan;

/**
 * 
 * @author 
 */
class SQLTrabajan 
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
	public SQLTrabajan (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}

	public long adicionarTrabajan(PersistenceManager pm, long idMedico, long idIps) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaTrabajan() + "(\"medicosID\", \"iPSID\") values (?, ?)");
        q.setParameters(idMedico, idIps);
        return (long) q.executeUnique();
	}

	public long eliminarTrabajan (PersistenceManager pm, long idMedico, long idIps)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaTrabajan () + " WHERE \"medicosID\" = ? AND \"iPSID\" = ?");
        q.setParameters(idMedico, idIps);
        return (long) q.executeUnique();
	}

	public List<Trabajan> darGustan (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaTrabajan());
		q.setResultClass(Trabajan.class);
		List<Trabajan> resp = (List<Trabajan>) q.execute();
		return resp;
	}

}
