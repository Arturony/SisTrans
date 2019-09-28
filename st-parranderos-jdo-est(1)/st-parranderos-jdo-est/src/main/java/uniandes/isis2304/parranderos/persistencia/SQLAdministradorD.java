
package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.Medico;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos 
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 * 
 * @author
 */
class SQLAdministradorD 
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
	public SQLAdministradorD (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un GUSTAN a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @param idAdmin - El identificador del bebedor
	 * @param contrasenia - El identificador de la bebida
	 * @return EL número de tuplas insertadas
	 */
	public long adicionarAdministrador(PersistenceManager pm, long idAdmin, String contrasenia, String correo,String nombre, String tipoDocumento, long epsID) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaAdmin() + "(contraseña, correo, nombre, tipoDocumento, administradorID, epsID) values (?, ?, ?, ?, ?, ?)");
        q.setParameters(contrasenia, correo, nombre, tipoDocumento, idAdmin, epsID);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar UN GUSTAN de la base de datos de Parranderos, por sus identificador
	 * @param pm - El manejador de persistencia
	 * @param idBebedor - El identificador del bebedor
	 * @param idBebida - El identificador de la bebida
	 * @return EL número de tuplas eliminadas
	 */
	public long adicionarAfiliado(PersistenceManager pm, long idAfiliado, String fechaNacimiento, String correo, String nombre, String tipoDocumento, long epsID)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaAfiliado() + "(afiliadoID, correo, nombre, tipoDocumento, fechaNacimiento, epsID) values (?, ?, ?, ?, ?, ?)");
        q.setParameters(idAfiliado, correo, nombre, tipoDocumento, fechaNacimiento, epsID);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de los GUSTAN de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos GUSTAN
	 */
	public long adicionarGerente (PersistenceManager pm, long idGerente, String correo, String nombre, String tipoDocumento, long epsID)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaGerente() + "(gerenteID, correo, nombre, tipoDocumento, epsID) values (?, ?, ?, ?, ?)");
        q.setParameters(idGerente, correo, nombre, tipoDocumento, epsID);
        return (long) q.executeUnique();
	}
	
	public long adicionarMedico (PersistenceManager pm, long idMedico, String especialidad, String nombre, String tipoDocumento, long numReg)
	{
		return pp.getSqlIPS().adicionarMedico(pm, idMedico, especialidad, nombre, tipoDocumento, numReg);
	}
	
	public long adicionarRecepcionista (PersistenceManager pm, long idRecepcionista, String correo, String nombre, String tipoDocumento, long idIPS)
	{
		return pp.getSqlIPS().adicionarRecepcionista(pm, idRecepcionista, correo, nombre, tipoDocumento, idIPS);
	}
	
	public long adicionarServicio (PersistenceManager pm, long idServicio, String horario, String nombre, long medicosDisponibles, long citaMedicaID)
	{
		return pp.getSqlIPS().adicionarServicio(pm, idServicio, horario, nombre, medicosDisponibles, citaMedicaID);
	}
	
	
	public long adicionarIPS (PersistenceManager pm, long idIps, String localizacion, String nombre, long epsID)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaIPS() + "(iPSID, localizacion, nombre, epsID) values (?, ?, ?, ?)");
        q.setParameters(idIps, localizacion, nombre, epsID);
        return (long) q.executeUnique();
	}

}
