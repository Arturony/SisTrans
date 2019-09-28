/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad	de	los	Andes	(Bogotá	- Colombia)
 * Departamento	de	Ingeniería	de	Sistemas	y	Computación
 * Licenciado	bajo	el	esquema	Academic Free License versión 2.1
 * 		
 * Curso: isis2304 - Sistemas Transaccionales
 * Proyecto: Parranderos Uniandes
 * @version 1.0
 * @author Germán Bravo
 * Julio de 2018
 * 
 * Revisado por: Claudia Jiménez, Christian Ariza
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.isis2304.EPSAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.EPSAndes.negocio.EPS;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 * 
 * @author Germán Bravo
 */
class SQLEPS 
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
	public SQLEPS (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarAdministrador(PersistenceManager pm, long idAdmin, String contrasenia, String correo,String nombre, String tipoDocumento, long epsID) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaAdmin() + "(contraseña, correo, nombre, tipoDocumento, administradorID, epsID) values (?, ?, ?, ?, ?, ?)");
        q.setParameters(contrasenia, correo, nombre, tipoDocumento, idAdmin, epsID);
        return (long) q.executeUnique();
	}


	public long adicionarAfiliado(PersistenceManager pm, long idAfiliado, String fechaNacimiento, String correo, String nombre, String tipoDocumento, long epsID)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaAfiliado() + "(afiliadoID, correo, nombre, tipoDocumento, fechaNacimiento, epsID) values (?, ?, ?, ?, ?, ?)");
        q.setParameters(idAfiliado, correo, nombre, tipoDocumento, fechaNacimiento, epsID);
        return (long) q.executeUnique();
	}

	public long adicionarGerente (PersistenceManager pm, long idGerente, String correo, String nombre, String tipoDocumento, long epsID)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaGerente() + "(gerenteID, correo, nombre, tipoDocumento, epsID) values (?, ?, ?, ?, ?)");
        q.setParameters(idGerente, correo, nombre, tipoDocumento, epsID);
        return (long) q.executeUnique();
	}
	

	public long adicionarIPS (PersistenceManager pm, long idIps, String localizacion, String nombre, long epsID)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaIPS() + "(iPSID, localizacion, nombre, epsID) values (?, ?, ?, ?)");
        q.setParameters(idIps, localizacion, nombre, epsID);
        return (long) q.executeUnique();
	}
}
