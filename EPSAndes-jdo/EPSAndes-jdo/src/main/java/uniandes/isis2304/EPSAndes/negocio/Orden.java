
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
	private long ordenesID;

	private long afiliadoID;
	
	private long servicioID;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Orden() 
	{
		this.ordenesID = 0;
		this.afiliadoID = 0;
		servicioID = 0;
	}
	
	public Orden(long idOrden, long idAfiliado, long idServicio) 
	{
		this.ordenesID = idOrden;
		this.afiliadoID = idAfiliado;
		this.servicioID = idServicio;
	}

	public long getOrdenesID() {
		return ordenesID;
	}

	public void setOrdenesID(long ordenesID) {
		this.ordenesID = ordenesID;
	}

	public long getAfiliadoID() {
		return afiliadoID;
	}

	public void setAfiliadoID(long afiliadoID) {
		this.afiliadoID = afiliadoID;
	}

	public long getServicioID() {
		return servicioID;
	}

	public void setServicioID(long servicioID) {
		this.servicioID = servicioID;
	}

	/**
	 * @return Una cadena de caracteres con la información
	 */
	@Override
	public String toString() 
	{
		return "Orden [id=" + ordenesID + ", idAfiliado=" + afiliadoID + "]";
	}

}
