

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
	
	private long idAfiliado;
	
	private String nombre;
	
	private long idEps;
	
	private String tipo;
	
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
		this.idAfiliado = 0;
		this.tipo = "Default";
		this.idEps = 0;
		citasRealizadas = new LinkedList<Object[]>();
		ordenesRealizadas = new LinkedList<Object[]>();
	}

	public Afiliado(String tipo, String nombre, String correo, long documento, long idEps) 
	{
		this.nombre = nombre;
		this.correo = correo;
		this.idAfiliado = documento;
		this.tipo = tipo;
		this.idEps = idEps;
		citasRealizadas = new LinkedList<Object[]>();
		ordenesRealizadas = new LinkedList<Object[]>();
	}


	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public long getIdAfiliado() {
		return idAfiliado;
	}

	public void setIdAfiliado(long documento) {
		this.idAfiliado = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public long getIdEps() {
		return idEps;
	}

	public void setIdEps(long idEps) {
		this.idEps = idEps;
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
		return "Afiliado [idAfiliado="+ idAfiliado + ", nombre=" + nombre + ", correo=" + 
	", idEps=" + idEps + ", TipoDocumento="+ tipo +"]";
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
