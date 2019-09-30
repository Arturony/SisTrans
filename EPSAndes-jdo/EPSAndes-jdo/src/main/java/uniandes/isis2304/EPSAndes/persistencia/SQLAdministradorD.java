
package uniandes.isis2304.EPSAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.EPSAndes.negocio.Medico;

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
	
	public long adicionarAdministrador(PersistenceManager pm, long idAdmin, String contrasenia, String correo,String nombre, String tipoDocumento, long epsID) 
	{
		return pp.getSqlEPS().adicionarAdministrador(pm, idAdmin, contrasenia, correo, nombre, tipoDocumento, epsID);
	}


	public long adicionarAfiliado(PersistenceManager pm, long idAfiliado, String fechaNacimiento, String correo, String nombre, String tipoDocumento, long epsID)
	{
		return pp.getSqlEPS().adicionarAfiliado(pm, idAfiliado, fechaNacimiento, correo, nombre, tipoDocumento, epsID);
	}

	public long adicionarGerente (PersistenceManager pm, long idGerente, String correo, String nombre, String tipoDocumento, long epsID)
	{
		return pp.getSqlEPS().adicionarGerente(pm, idGerente, correo, nombre, tipoDocumento, epsID);
	}
	
	public long adicionarMedico (PersistenceManager pm, long idMedico, String especialidad, String nombre, String tipoDocumento, long numReg)
	{
		return pp.getSqlIPS().adicionarMedico(pm, idMedico, especialidad, nombre, tipoDocumento, numReg);
	}
	
	public long adicionarRecepcionista (PersistenceManager pm, long idRecepcionista, String correo, String nombre, String tipoDocumento, long idIPS)
	{
		return pp.getSqlIPS().adicionarRecepcionista(pm, idRecepcionista, correo, nombre, tipoDocumento, idIPS);
	}
	
	public long adicionarServicio (PersistenceManager pm, long idServicio, String horario, String nombre, long medicosDisponibles)
	{
		return pp.getSqlIPS().adicionarServicio(pm, idServicio, horario, nombre, medicosDisponibles);
	}
	
	
	public long adicionarIPS (PersistenceManager pm, long idIps, String localizacion, String nombre, long epsID)
	{
		return pp.getSqlEPS().adicionarIPS(pm, idIps, localizacion, nombre, epsID);
	}

}
