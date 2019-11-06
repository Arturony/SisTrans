

package uniandes.isis2304.EPSAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.EPSAndes.negocio.AdministradorD;
import uniandes.isis2304.EPSAndes.negocio.Afiliado;
import uniandes.isis2304.EPSAndes.negocio.CitaMedica;
import uniandes.isis2304.EPSAndes.negocio.Orden;

/**
 * @author 
 */
class SQLAfiliado 
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
	public SQLAfiliado (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	public long adicionarOrden(PersistenceManager pm, long idAfiliado, long idServicioSalud, long idOrden)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaOrdenes() + "(\"ordenesID\", \"afiliadoID\", \"servicioID\") values (?, ?, ?)");
        q.setParameters(idOrden,idAfiliado,  idServicioSalud );
        return (long) q.executeUnique();
	}
	public long adicionarCitaMedica(PersistenceManager pm, long idAfiliado, long idCitaMedica, int sesiones, String horario, int llego, long serviciosSaludId)
	{
		String h = "TO_DATE('"+ horario +"', 'YYYY-MM-DD HH24:MI:SS')";
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaCitas() + "(\"horario\", \"llego\", \"sesiones\",\"citaMedicaID\",\"afiliadoID\",\"servicioSaludID\") values ("+h+",?, ?, ?, ?, ?)");
        q.setParameters(llego,sesiones,idCitaMedica,  idAfiliado, serviciosSaludId );
        return (long) q.executeUnique();
	}
	
	public CitaMedica darCitaEspecifica (PersistenceManager pm, long idCita, long idAfiliado)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCitas() + "WHERE \"citaMedicaID\" = ? AND \"afiliadoID\" = ?");
		q.setParameters(idCita, idAfiliado);
		q.setResultClass(CitaMedica.class);
		CitaMedica resp = (CitaMedica) q.executeUnique();
		return resp;
	}
	
	public Orden darOrdenEspecifica (PersistenceManager pm, long idOrden)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOrdenes() + "WHERE \"ordenesID\" = ?");
		q.setParameters(idOrden);
		q.setResultClass(Orden.class);
		Orden resp = (Orden) q.executeUnique();
		return resp;
	}
	public List<CitaMedica> darCitasAfiliado (PersistenceManager pm, long idAfiliado)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCitas() + "WHERE \"afiliadoID\" = ?");
		q.setParameters(idAfiliado);
		q.setResultClass(CitaMedica.class);
		List<CitaMedica> resp = (List<CitaMedica>) q.executeList();
		return resp;
	}
	
	public List<Orden> darOrdenesAfiliado (PersistenceManager pm, long idAfiliado)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOrdenes() + "WHERE \"afiliadoID\" = ?");
		q.setParameters(idAfiliado);
		q.setResultClass(Orden.class);
		List<Orden> resp = (List<Orden>) q.executeList();
		return resp;
	}

}
