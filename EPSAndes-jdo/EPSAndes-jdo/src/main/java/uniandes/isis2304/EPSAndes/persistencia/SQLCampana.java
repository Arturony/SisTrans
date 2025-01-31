
package uniandes.isis2304.EPSAndes.persistencia;

import java.math.BigDecimal;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import oracle.net.aso.n;
import uniandes.isis2304.EPSAndes.negocio.AdministradorD;
import uniandes.isis2304.EPSAndes.negocio.Afiliado;
import uniandes.isis2304.EPSAndes.negocio.Campana;
import uniandes.isis2304.EPSAndes.negocio.EPS;
import uniandes.isis2304.EPSAndes.negocio.IPS;
import uniandes.isis2304.EPSAndes.negocio.Medico;
import uniandes.isis2304.EPSAndes.negocio.Orden;
import uniandes.isis2304.EPSAndes.negocio.Recepcionista;
import uniandes.isis2304.EPSAndes.negocio.Servicios;

/**
 * @author
 */
class SQLCampana 
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
	public SQLCampana (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarCampana(PersistenceManager pm, long campanaId, String nombre, String fecha, int capacidad, long epsID) 
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaCampana() + "(\"campanaID\", \"capacidad\", \"fecha\", \"nombre\", \"epsID\") values (?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?)");
        q.setParameters(campanaId, capacidad, fecha, nombre, epsID);
        return (long) q.executeUnique();
	}

	public long cancelarCampana(PersistenceManager pm, long campanaId, String nombre, long epsID)
	{
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCampana() + "WHERE \"campanaID\" = ? AND \"nombre\" = ? AND \"epsID\" = ?");
        q.setParameters(campanaId,  nombre, epsID);
        return (long) q.executeUnique();
	}
	
	public List<Campana> getCampanas(PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCampana());
		q.setResultClass(Campana.class);	
		return (List<Campana>) q.executeList();
	}
	
}
