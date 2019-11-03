
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
class SQLReservas 
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
	public SQLReservas (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}

	public long adicionarReserva(PersistenceManager pm, long idAfiliado, long idCampana) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaReservas() + "(\"servicioID\", \"campanaID\") values (?, ?)");
        q.setParameters(idAfiliado, idCampana);
        return (long) q.executeUnique();
	}

	public long eliminarReserva(PersistenceManager pm, long idAfiliado, long idCampana)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaReservas() + " WHERE \"servicioID\" = ? AND \"campanaID\" = ?");
        q.setParameters(idAfiliado, idCampana);
        return (long) q.executeUnique();
	}

}
