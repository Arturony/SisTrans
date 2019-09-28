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

package uniandes.isis2304.EPSAndes.negocio;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase para modelar el concepto BEBEDOR del negocio de los Parranderos
 *
 * @author Germán Bravo
 */
public class Prestaciones implements VOPrestaciones
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador ÚNICO del bebedor
	 */
	private long idIps;	
	
	private long idServicio;
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Prestaciones() 
	{
		this.idIps = 0;
		this.idServicio = 0;
	}

	/**
	 * Constructor con valores
	 * 
	 */
	public Prestaciones(long idIps, long idServicio) 
	{
		this.idIps = idIps;
		this.idServicio = idServicio;
	}

	/**
	 * @return El id 
	 */
	public long getIdIps() 
	{
		return idIps;
	}

	/**
	 * @param id - El nuevo id
	 */
	public void setIdIps(long id) 
	{
		this.idIps = id;
	}
	
	public long getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(long idServicio) {
		this.idServicio = idServicio;
	}

	@Override
	public String toString() 
	{
		return "Bebedor [id=" + idIps +"]";
	}

}
