
package uniandes.isis2304.EPSAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.EPSAndes.negocio.Medico;
import uniandes.isis2304.EPSAndes.negocio.Orden;

/**
 * @author
 */
class SQLOrdenes 
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
	public SQLOrdenes (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}

	public long eliminarOrden (PersistenceManager pm, long idServicio, long idAfiliado, long idOrden)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaOrdenes() + " WHERE \"servicioID\" = ? AND = \"afiliadoId\" ? AND \"ordenesID\" = ?");
        q.setParameters(idServicio, idAfiliado, idOrden);
        return (long) q.executeUnique();
	}

	public List<Orden> darOrdenes (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOrdenes());
		q.setResultClass(Orden.class);
		return (List<Orden>) q.execute();
	}

	public Orden darOrdenes(PersistenceManager pm, int servicio, int afiliado, int ordenes) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOrdenes() + "WHERE \"ordenesID\" = ? AND = \"afiliadoId\" ? AND \"servicioID\" = ?");
		q.setParameters(ordenes, afiliado, servicio);
		q.setResultClass(Orden.class);
		return (Orden) q.executeUnique();
	}

}
