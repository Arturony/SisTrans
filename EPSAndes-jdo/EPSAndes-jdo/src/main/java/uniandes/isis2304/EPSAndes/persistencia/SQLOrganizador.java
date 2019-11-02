

package uniandes.isis2304.EPSAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.EPSAndes.negocio.Recepcionista;

class SQLOrganizador 
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
	public SQLOrganizador (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarCampana(PersistenceManager pm, long campanaId, String nombre, String fecha, int capacidad, long epsID) 
	{
		return pp.getSqlCampana().adicionarCampana(pm, campanaId, nombre, fecha, capacidad, epsID);
	}
	
	public long cancelarCampana(PersistenceManager pm, long campanaId, String nombre, long epsID)
	{
		return pp.getSqlCampana().cancelarCampana(pm, campanaId, nombre, epsID);
	}

}
