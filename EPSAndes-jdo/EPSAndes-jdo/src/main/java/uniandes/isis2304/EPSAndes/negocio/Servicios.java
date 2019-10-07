

package uniandes.isis2304.EPSAndes.negocio;

/**
 * @author
 */
public class Servicios implements VOServicios
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	private long servicioSaludID;
	
	private String horario;
	
	private int medicosDisponibles;
	
	private String nombre;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Servicios () 
	{
		this.servicioSaludID = 0;
		this.medicosDisponibles = 0;
		this.horario = "";
		this.nombre = "";
	}

	public Servicios (long idServicio, int medicosDisponibles, String horario, String nombre) 
	{
		this.servicioSaludID = idServicio;
		this.medicosDisponibles = medicosDisponibles;
		this.horario = horario;
	}

	public long getServicioSaludID() {
		return servicioSaludID;
	}

	public void setServicioSaludID(long servicioSaludID) {
		this.servicioSaludID = servicioSaludID;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public int getMedicosDisponibles() {
		return medicosDisponibles;
	}

	public void setMedicosDisponibles(int medicosDisponibles) {
		this.medicosDisponibles = medicosDisponibles;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/** 
	 * @return Una cadena con la información básica
	 */
	public String toString1() 
	{
		return "Servicio de Salud [idServicio=" + servicioSaludID + ", nombre=" + nombre + ", horario=" + horario + 
				", medicos disponibles=" + medicosDisponibles + "]";
	}
	
	@Override
	public String toString()
	{
		return nombre + " || " + horario + " || " + medicosDisponibles;
	}
}
