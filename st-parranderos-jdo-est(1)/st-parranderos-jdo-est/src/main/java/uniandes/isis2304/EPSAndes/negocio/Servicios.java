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

package uniandes.isis2304.EPSAndes.negocio;

/**
 *
 * Cada objeto de esta clase representa el hecho que un bar sirve una bebida y viceversa.
 * Se modela mediante los identificadores del bar y de la bebida respectivamente
 * Debe existir un bar con el identificador dado
 * Debe existir una bebida con el identificador dado 
 * Adicionalmente contiene el horario (DIURNO, NOCTURNO, TODOS) en el cual el bar sirve la bebida
 * 
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

	public Servicios (long idBar, int medicosDisponibles, String horario, String nombre) 
	{
		this.idServicio = idBar;
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
		return "Servicio de Salud [idServicior=" + idServicio + ", nombre=" + nombre + ", horario=" + horario + 
				", medicos disponibles=" + medicosDisponibles + "]";
	}
}
