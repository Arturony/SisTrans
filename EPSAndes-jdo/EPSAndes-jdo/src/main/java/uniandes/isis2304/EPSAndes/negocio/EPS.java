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

/**
 * Clase para modelar el concepto EPS
 *
 * @author
 */
public class EPS implements VOEPS
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador
	 */
	private long epsID;
	
	/**
	 * El nombre
	 */
	private String nombre;

	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
    /**
     * Constructor por defecto
     */
	public EPS() 
    {
    	this.epsID = 0;
		this.nombre = "";
	}

	/**
	 * Constructor con valores
	 * @param id - El id
	 * @param nombre - El nombre 
	 */
    public EPS(long id, String nombre) 
    {
    	this.epsID = id;
		this.nombre = nombre;
	}

    /**
	 * @return El id del bar
	 */
	public long getEpsID() 
	{
		return epsID;
	}
	
	/**
	 * @param id - El nuevo id del bar
	 */
	public void setEpsID(long id) 
	{
		this.epsID = id;
	}
	
	/**
	 * @return el nombre del bar
	 */
	public String getNombre() 
	{
		return nombre;
	}
	
	/**
	 * @param nombre El nuevo nombre del bar
	 */
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	
	@Override
	/**
	 * @return Una cadena de caracteres con todos los atributos
	 */
	public String toString() 
	{
		return "Eps [id=" + epsID + ", nombre=" + nombre + "]";
	}
	

}
