

package uniandes.isis2304.EPSAndes.negocio;

/**
 * @author
 */
public class Servicios implements VOServicios
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	private long idServicio;
	
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
		this.idServicio = 0;
		this.medicosDisponibles = 0;
		this.horario = "";
		this.nombre = "";
	}

	public Servicios (long idServicio, int medicosDisponibles, String horario, String nombre) 
	{
		this.idServicio = idServicio;
		this.medicosDisponibles = medicosDisponibles;
		this.horario = horario;
	}

	
	public long getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(long idServicio) {
		this.idServicio = idServicio;
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
	@Override
	public String toString() 
	{
		return "Servicio de Salud [idServicio=" + idServicio + ", nombre=" + nombre + ", horario=" + horario + 
				", medicos disponibles=" + medicosDisponibles + "]";
	}
}
