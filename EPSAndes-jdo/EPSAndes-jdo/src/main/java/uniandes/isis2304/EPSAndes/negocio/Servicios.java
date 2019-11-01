

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
	
	private int iPSID;
	
	private int reservado;

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
		this.iPSID = 0;
		this.reservado = 0;
	}

	public Servicios (long idServicio, int medicosDisponibles, String horario, String nombre, int idIps, int reserva) 
	{
		this.servicioSaludID = idServicio;
		this.medicosDisponibles = medicosDisponibles;
		this.horario = horario;
		this.nombre = nombre;
		this.iPSID = idIps;
		this.reservado = reserva;
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

	public int getIPSID() {
		return iPSID;
	}

	public void setIPSID(int iPSID) {
		this.iPSID = iPSID;
	}

	public int getReservado() {
		return reservado;
	}

	public void setReservado(int reservado) {
		this.reservado = reservado;
	}

	/** 
	 * @return Una cadena con la información básica
	 */
	public String toString1() 
	{
		return "Servicio de Salud [idServicio=" + servicioSaludID + ", nombre=" + nombre + ", horario=" + horario + 
				", medicos disponibles=" + medicosDisponibles + "id Ips= " + iPSID + "]";
	}
	
	@Override
	public String toString()
	{
		return nombre + " || " + horario + " || " + medicosDisponibles;
	}
}
