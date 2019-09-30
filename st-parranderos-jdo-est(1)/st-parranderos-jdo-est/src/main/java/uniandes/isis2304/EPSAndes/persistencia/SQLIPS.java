
package uniandes.isis2304.EPSAndes.persistencia;

import java.math.BigDecimal;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.EPSAndes.negocio.IPS;
import uniandes.isis2304.EPSAndes.negocio.Medico;
import uniandes.isis2304.EPSAndes.negocio.Orden;

/**
 * @author
 */
class SQLIPS 
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
	public SQLIPS (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarMedico (PersistenceManager pm, long idMedico, String especialidad, String nombre, String tipoDocumento, long numReg)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaMedico() + " (\"Especialidad\", \"nombre\", \"numeroRegistroMedico\", \"tipoDocumento\", \"medicosID\") values (?, ?, ?, ?, ?)");
        q.setParameters(especialidad, nombre, numReg, tipoDocumento, idMedico);
        return (long) q.executeUnique();
	}
	
	public long adicionarRecepcionista (PersistenceManager pm, long idRecepcionista, String correo, String nombre, String tipoDocumento, long idIPS)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaRecepcionista() + "(\"recepcionistaID\", \"correo\", \"nombre\", \"tipoDocumento\", \"iPSID\") values (?, ?, ?, ?, ?)");
        q.setParameters(idRecepcionista, correo, nombre, tipoDocumento, idIPS);
        return (long) q.executeUnique();
	}
	
	public long adicionarServicio (PersistenceManager pm, long idServicio, String horario, String nombre, long medicosDisponibles)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaServicio() + "(\"servicioSaludID\", \"horario\", \"nombre\", \"medicosDisponibles\") values (?, ?, ?, ?)");
        q.setParameters(idServicio, horario, nombre, medicosDisponibles);
        return (long) q.executeUnique();
	}
	
	public String darMedicos (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT \"nombre\" FROM " + pp.darTablaMedico() + "WHERE \"medicosID\" = 1");
		q.setResultClass(Medico.class);
		String resp =  q.execute().toString();
		return resp;
	}

}
