
package uniandes.isis2304.EPSAndes.negocio;

/**
 * Clase para modelar el concepto BAR del negocio de los Parranderos
 *
 * @author 
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
	
	private long idServicio;

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
	
 
	public long getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(long idServicio) {
		this.idServicio = idServicio;
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
