

package uniandes.isis2304.EPSAndes.negocio;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 *
 * @author 
 */
public class Afiliado implements VOAfiliado
{

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	private String correo;
	
	private long afiliadoID;
	
	private String nombre;
	
	private long epsID;
	
	private String tipoDocumento;
	
	private String fechaNacimiento;
	
	private List<Object []> citasRealizadas;

	private List<Object []> ordenesRealizadas;
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Afiliado() 
	{
		this.nombre = "Default";
		this.correo = "Default";
		this.afiliadoID = 0;
		this.tipoDocumento = "Default";
		this.epsID = 0;
		this.fechaNacimiento = "";
		citasRealizadas = new LinkedList<Object[]>();
		ordenesRealizadas = new LinkedList<Object[]>();
	}

	public Afiliado(String tipo, String nombre, String correo, long documento, long idEps, String fecha) 
	{
		this.nombre = nombre;
		this.correo = correo;
		this.afiliadoID = documento;
		this.tipoDocumento = tipo;
		this.epsID = idEps;
		this.fechaNacimiento = fecha;
		citasRealizadas = new LinkedList<Object[]>();
		ordenesRealizadas = new LinkedList<Object[]>();
	}


	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public long getAfiliadoID() {
		return afiliadoID;
	}

	public void setAfiliadoID(long afiliadoID) {
		this.afiliadoID = afiliadoID;
	}

	public long getEpsID() {
		return epsID;
	}

	public void setEpsID(long epsID) {
		this.epsID = epsID;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setCitasRealizadas(List<Object[]> citasRealizadas) {
		this.citasRealizadas = citasRealizadas;
	}

	public void setOrdenesRealizadas(List<Object[]> ordenesRealizadas) {
		this.ordenesRealizadas = ordenesRealizadas;
	}

	public List<Object[]> getCitasRealizadas() {
		return citasRealizadas;
	}

	public List<Object[]> getOrdenesRealizadas() {
		return ordenesRealizadas;
	}

	/**
	 * @return Una cadena con la información básica 
	 */
	@Override
	public String toString() 
	{
		return "Afiliado [idAfiliado="+ afiliadoID + ", nombre=" + nombre + ", correo=" + 
	", idEps=" + epsID + ", TipoDocumento="+ tipoDocumento + ", fecha de Nacimiento=" + fechaNacimiento +"]";
	}

	public String toStringCompleto () 
	{
		String resp =  this.toString();
		resp += "\n --- Citas realizadas\n";
		int i = 1;
		for (Object [] cita : citasRealizadas)
		{
			Servicios serv = (Servicios) cita [0];
			String llego = (String) cita [1];
			String horario = (String) cita [2];
			String sesiones = (String) cita [3];
			resp += i++ + ". " + "[" +serv.toString() + ", llegó= " + llego + ", horario= " + horario + "sesiones=" + sesiones +"]\n";
		}
		resp += "\n\n --- Ordenes Realizadas\n";
		i = 1;
		for (Object [] orden : ordenesRealizadas)
		{
			Servicios serv = (Servicios) orden [0];
			String idOrden = (String) orden [1];
			resp += i++ + ". " + "[" + serv.toString() + ", Id Orden= " + idOrden + "]\n";
		}
		return resp;
	}
}
