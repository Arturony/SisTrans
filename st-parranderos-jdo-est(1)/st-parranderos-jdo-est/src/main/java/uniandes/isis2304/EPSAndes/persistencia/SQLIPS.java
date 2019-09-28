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

import java.math.BigDecimal;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.EPSAndes.negocio.IPS;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BEBEDOR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 * 
 * @author Germán Bravo
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
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaMedico() + "(medicosID, especialidad, nombre, tipoDocumento, numReg) values (?, ?, ?, ?, ?)");
        q.setParameters(idMedico, especialidad, nombre, tipoDocumento, numReg);
        return (long) q.executeUnique();
	}
	
	public long adicionarRecepcionista (PersistenceManager pm, long idRecepcionista, String correo, String nombre, String tipoDocumento, long idIPS)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaRecepcionista() + "(recepcionistaID, correo, nombre, tipoDocumento, iPSID) values (?, ?, ?, ?, ?)");
        q.setParameters(idRecepcionista, correo, nombre, tipoDocumento, idIPS);
        return (long) q.executeUnique();
	}
	
	public long adicionarServicio (PersistenceManager pm, long idServicio, String horario, String nombre, long medicosDisponibles, long citaMedicaID)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaServicio() + "(servicioSaludID, horario, nombre, medicosDisponibles, citaMedicaID) values (?, ?, ?, ?, ?)");
        q.setParameters(idServicio, horario, nombre, medicosDisponibles, citaMedicaID);
        return (long) q.executeUnique();
	}

}
