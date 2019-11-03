
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
class SQLParticipa 
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
	public SQLParticipa (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}

	public long adicionarParticipa(PersistenceManager pm, long afiliadoID, long campanaID) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaParticipan() + "(\"afiliadoID\", \"campanaID\") values (?, ?)");
        q.setParameters(afiliadoID, campanaID);
        return (long) q.executeUnique();
	}

	public long eliminarParticipan(PersistenceManager pm, long afiliadoID, long campanaID)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaParticipan() + " WHERE \"afiliadoID\" = ? AND \"campanaID\" = ?");
        q.setParameters(afiliadoID, campanaID);
        return (long) q.executeUnique();
	}

}
