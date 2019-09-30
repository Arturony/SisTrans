

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
	
	private long citaMedicaID;
	
	private int llego;
	
	private int sesiones;
	
	private long afiliadoID;
	
	private long servicioSaludID;
	
	
	//private long idOrden;
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public CitaMedica () 
	{
		this.servicioSaludID = 0;
		this.afiliadoID = 0;
		this.horario = "";
		this.citaMedicaID = 0;
		this.sesiones = 0;
		this.llego = 0;
	}

	
	public CitaMedica (long idServicio, long idAfiliado, String horario, long idCita, int sesiones, int llego) 
	{
		this.servicioSaludID = idServicio;
		this.afiliadoID = idAfiliado;
		this.horario = horario;
		this.citaMedicaID = idCita;
		this.sesiones = sesiones;
		this.llego =llego;
	}

	public String getHorario() {
		return horario;
	}


	public void setHorario(String horario) {
		this.horario = horario;
	}


	public long getCitaMedicaID() {
		return citaMedicaID;
	}


	public void setCitaMedicaID(long citaMedicaID) {
		this.citaMedicaID = citaMedicaID;
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


	public long getAfiliadoID() {
		return afiliadoID;
	}


	public void setAfiliadoID(long afiliadoID) {
		this.afiliadoID = afiliadoID;
	}


	public long getServicioSaludID() {
		return servicioSaludID;
	}


	public void setServicioSaludID(long servicioSaludID) {
		this.servicioSaludID = servicioSaludID;
	}


	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString() 
	{
		return "Cita Medica [idCita=" + citaMedicaID + ", horario=" + horario +", sesiones="+ sesiones + ", idAfiliado="
	+ afiliadoID  + ", idServicio= " +servicioSaludID + ", llego=" +llego+ "]";
	}
}
