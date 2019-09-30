
package uniandes.isis2304.EPSAndes.negocio;




/**
 * @author 
 */
public class IPS implements VOIPS
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	private long iPSID;	
	
	
	private String nombre;
	
	
	private String localizacion;
	
	private long epsID;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public IPS() 
	{
		this.iPSID = 0;
		this.nombre = "";
		this.localizacion = "";
		this.epsID = 0;


	}

	/**
	 * Constructor con valores
	 * @param id - El id del bebedor
	 * @param nombre - El nombre del bebedor
	 * @param ciudad - La ciudad del bebedor
	 * @param presupuesto - El presupuesto del bebedor (ALTO, MEDIO, BAJO)
	 */
	public IPS(long id, String nombre, String ciudad, long ideps) 
	{
		this.iPSID = id;
		this.nombre = nombre;
		this.localizacion = ciudad;
		this.epsID = ideps;
	}


	public String getNombre() 
	{
		return nombre;
	}


	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	


	public long getiPSID() {
		return iPSID;
	}

	public void setiPSID(long iPSID) {
		this.iPSID = iPSID;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
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
		return "IPS con id" + iPSID + ", nombre=" + nombre + ", localizacion=" + localizacion + ", idEps=" + "]";
	}

}
