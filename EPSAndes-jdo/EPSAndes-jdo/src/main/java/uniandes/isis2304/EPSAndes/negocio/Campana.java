
package uniandes.isis2304.EPSAndes.negocio;




/**
 * @author 
 */
public class Campana implements VOCampana
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	private long campanaID;	
	
	
	private String nombre;
	
	
	private String fecha;
	
	private int capacidad;
	
	private long epsID;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Campana() 
	{
		this.campanaID = 0;
		this.nombre = "";
		this.fecha = "";
		this.capacidad = 0;
		this.epsID = 0;

	}

	/**
	 * Constructor con valores
	 * @param id - El id del bebedor
	 * @param nombre - El nombre del bebedor
	 * @param fecha - La ciudad del bebedor
	 * @param presupuesto - El presupuesto del bebedor (ALTO, MEDIO, BAJO)
	 */
	public Campana(long id, String nombre, String fecha, int cap, int epsId) 
	{
		this.campanaID = id;
		this.nombre = nombre;
		this.fecha = fecha;
		this.capacidad = cap;
		this.epsID = epsId;
	}


	public String getNombre() 
	{
		return nombre;
	}


	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	
	

	public long getCampanaID() {
		return campanaID;
	}

	public void setCampanaID(long campanaID) {
		this.campanaID = campanaID;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public long getEpsID() {
		return epsID;
	}

	public void setEpsID(long epsID) {
		this.epsID = epsID;
	}

	/**
	 * @return Una cadena de caracteres con la información básica del bebedor
	 */
	@Override
	public String toString() 
	{
		return "Campaña con id" + campanaID + ", nombre=" + nombre + ", localizacion=" + fecha + ", idEps=" + capacidad + "]";
	}

}
