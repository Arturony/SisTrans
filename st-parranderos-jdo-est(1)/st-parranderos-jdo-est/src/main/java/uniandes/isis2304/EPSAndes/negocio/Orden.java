
package uniandes.isis2304.EPSAndes.negocio;

/**
 *
 * @author 
 */
public class Orden implements VOOrden
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	private long idOrden;

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
		this.idOrden = 0;
		this.idAfiliado = 0;
		idServicio = 0;
	}
	
	public Orden(long idOrden, long idAfiliado, long idServicio) 
	{
		this.idOrden = idOrden;
		this.idAfiliado = idAfiliado;
		this.idServicio = idServicio;
	}

	/**
	 * @return El id
	 */
	public long getIdOrden() 
	{
		return idOrden;
	}

	/**
	 * @param id - El nuevo id a
	 */
	public void setIdOrden(long id) 
	{
		this.idOrden = id;
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
		return "Orden [id=" + idOrden + ", idAfiliado=" + idAfiliado + "]";
	}

}
