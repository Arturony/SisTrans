

package uniandes.isis2304.EPSAndes.negocio;

/**
 * @author
 */
public class CitaMedica implements VOCitaMedica
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	private String horario;
	
	private long idCita;
	
	private int llego;
	
	private int sesiones;
	
	private long idAfiliado;
	
	private long idServicio;
	
	
	//private long idOrden;
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public CitaMedica () 
	{
		this.idServicio = 0;
		this.idAfiliado = 0;
		this.horario = "";
		this.idCita = 0;
		this.sesiones = 0;
		this.llego = 0;
		//this.idOrden = 0;
	}

	
	public CitaMedica (long idServicio, long idAfiliado, String horario, long idCita, int sesiones, int llego) 
	{
		this.idServicio = idServicio;
		this.idAfiliado = idAfiliado;
		this.horario = horario;
		this.idCita = idCita;
		this.sesiones = sesiones;
		this.llego =llego;
		//this.idOrden = idOrden;
	}
	
	

	public String getHorario() {
		return horario;
	}


	public void setHorario(String horario) {
		this.horario = horario;
	}


	public long getIdCita() {
		return idCita;
	}


	public void setIdCita(long idCita) {
		this.idCita = idCita;
	}


	public int getLlego() {
		return llego;
	}


	public void setLlego(int llego) {
		this.llego = llego;
	}


	public int getSesiones() {
		return sesiones;
	}


	public void setSesiones(int sesiones) {
		this.sesiones = sesiones;
	}


	public long getIdAfiliado() {
		return idAfiliado;
	}


	public void setIdAfiliado(long idAfiliado) {
		this.idAfiliado = idAfiliado;
	}


	public long getIdServicio() {
		return idServicio;
	}


	public void setIdServicio(long idServicio) {
		this.idServicio = idServicio;
	}
	/*
	public long getIdOrden() {
		return idOrden;
	}


	public void setIdOrden(long idOrden) {
		this.idOrden = idOrden;
	}
*/

	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString() 
	{
		return "Cita Medica [idCita=" + idCita + ", horario=" + horario +", sesiones="+ sesiones + ", idAfiliado="
	+ idAfiliado  + ", idServicio= " +idServicio + ", llego=" +llego+ "]";
	}
}
