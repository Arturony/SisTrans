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

package uniandes.isis2304.parranderos.negocio;

/**
 * Clase para modelar el concepto BAR del negocio de los Parranderos
 *
 * @author Germán Bravo
 */
public class Orden implements VOOrden
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador del tipo de bebida
	 */
	private long id;

	/**
	 * El nombre del tipo de bebida
	 */
	private long idAfiliado;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Orden() 
	{
		this.id = 0;
		this.idAfiliado = 0;
	}
	
	public Orden(long id, long nombre) 
	{
		this.id = id;
		this.idAfiliado = nombre;
	}

	/**
	 * @return El id
	 */
	public long getId() 
	{
		return id;
	}

	/**
	 * @param id - El nuevo id a
	 */
	public void setId(long id) 
	{
		this.id = id;
	}


	public long getIdAfiliado() 
	{
		return idAfiliado;
	}

	public void setIdAfiliado(long nombre) 
	{
		this.idAfiliado = nombre;
	}


	/**
	 * @return Una cadena de caracteres con la información
	 */
	@Override
	public String toString() 
	{
		return "Orden [id=" + id + ", idAfiliado=" + idAfiliado + "]";
	}

}
