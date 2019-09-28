
package uniandes.isis2304.parranderos.negocio;




/**
 * @author 
 */
public class IPS implements VOIPS
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	private long idIPS;	
	
	
	private String nombre;
	
	
	private String localizacion;
	
	
	private String presupuesto;
	
	private long idEps;
	
	/**
	 * Las visitas realizadas por el bebedor. 
	 * Cada visita es una tripleta de objetos [Bar, Timestamp, String], que representan el bar, la fecha 
	 * y el horario en que el bebedor realizó la visita
	 
	private List<Object []> visitasRealizadas;

	/**
	 * Las bebidas que le gustan el bebedor. 
	 * Cada visita es una pareja de objetos [Bebida, String], que representan la bebida y el nombre del 
	 * tipo de bebida que le gustan al bebedor 
	
	private List<Object []> bebidasQueLeGustan;
	*/
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public IPS() 
	{
		this.idIPS = 0;
		this.nombre = "";
		this.localizacion = "";
		this.idEps = 0;


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
		this.idIPS = id;
		this.nombre = nombre;
		this.localizacion = ciudad;
		this.idEps = ideps;
		
		// Estos valores no se conocen en el momento de la construcción del bebedor
	//	visitasRealizadas = new LinkedList<Object []> ();
		//bebidasQueLeGustan = new LinkedList<Object []> ();
	}

	
	public long getIdIps() 
	{
		return idIPS;
	}

	public void setIdIps(long id) 
	{
		this.idIPS = id;
	}
	
	public long getIdEps() 
	{
		return idEps;
	}

	public void setIdEps(long id) 
	{
		this.idEps = id;
	}



	public String getNombre() 
	{
		return nombre;
	}


	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}


	public String getLocalizacion() 
	{
		return localizacion;
	}


	public void setCiudad(String loca) 
	{
		this.localizacion = loca;
	}



	/**
	 * @return Una cadena de caracteres con la información básica del bebedor
	 */
	@Override
	public String toString() 
	{
		return "Bebedor con" + idIPS + ", nombre=" + nombre + ", localizacion=" + localizacion + ", idEps=" + presupuesto;
	}

	/**
	 * @return Una cadena de caracteres con la información COMPLEtA del bebedor.
	 * Además de la información básica, contiene las visitas realizadas (una por línea) y 
	 * las bebidas que le gustan al bebedor (una por línea)
	 	public String toStringCompleto () 
	{
		String resp =  this.toString();
		resp += "\n --- Visitas realizadas\n";
		int i = 1;
		for (Object [] visita : visitasRealizadas)
		{
			EPS bar = (EPS) visita [0];
			Timestamp fecha = (Timestamp) visita [1];
			String horario = (String) visita [2];
			resp += i++ + ". " + "[" +bar.toString() + ", fecha= " + fecha + ", horario= " + horario + "]\n";
		}
		resp += "\n\n --- Bebidas que le gustan\n";
		i = 1;
		for (Object [] gusta : bebidasQueLeGustan)
		{
			Afiliado bebida = (Afiliado) gusta [0];
			String tipoBebida = (String) gusta [1];
			resp += i++ + ". " + "[" + bebida.toString() + ", Tipo Bebida= " + tipoBebida + "]\n";
		}
		return resp;
	}
*/

}
