
package uniandes.isis2304.EPSAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.EPSAndes.negocio.Medico;

class SQLCitaMedica 
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
	public SQLCitaMedica (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	
	public long cambiarEstado (PersistenceManager pm, String afiliadoID)
	{
        Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaCitas() + " SET llego = 1 WHERE afiliadoID = ?");
        q.setParameters(afiliadoID);
        return (long) q.executeUnique();
	}

}
