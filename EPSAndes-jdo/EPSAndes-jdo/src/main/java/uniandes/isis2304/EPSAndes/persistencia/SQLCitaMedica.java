
package uniandes.isis2304.EPSAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.EPSAndes.negocio.CitaMedica;
import uniandes.isis2304.EPSAndes.negocio.Medico;
import uniandes.isis2304.EPSAndes.negocio.Orden;

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
	
	public long cambiarEstado (PersistenceManager pm, long afiliadoID, long idCitaMedica)
	{
        Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaCitas() + " SET \"llego\" = 1 WHERE \"afiliadoID\" = ? AND \"citaMedicaID\" = ?");
        q.setParameters(afiliadoID, idCitaMedica);
        return (long) q.executeUnique();
	}
	
	public List<CitaMedica> darCitas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCitas());
		q.setResultClass(CitaMedica.class);
		return (List<CitaMedica>) q.execute();
	}

	public CitaMedica darCita(PersistenceManager pm, int servicio, int afiliado, int idCita,
			String horario, int sesiones) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCitas() + "WHERE \"afiliadoID\" = ? AND \"servicioSaludID\" = ? AND \"citaMedicaID\" = ? AND \"horario\" = ? AND \"sesiones\" = ?");
		q.setParameters(afiliado, servicio, idCita, horario, sesiones);
		q.setResultClass(CitaMedica.class);
		return (CitaMedica) q.executeUnique();
	}

}
