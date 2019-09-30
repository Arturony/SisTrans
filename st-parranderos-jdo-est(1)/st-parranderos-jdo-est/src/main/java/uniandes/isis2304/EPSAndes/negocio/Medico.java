

package uniandes.isis2304.EPSAndes.negocio;

/**
 * 
 * @author 
 */
public class Medico implements VOMedico
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	private String tipoDocumento;
	
	private long medicosID;
	
	private String nombre;
	
	private int numeroRegistroMedico;
	
	private String Especialidad;
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Medico() 
	{
		this.tipoDocumento = "";
		this.medicosID = 0;
		this.nombre = "Default";
		this.numeroRegistroMedico = 0;
		this.Especialidad = "";
	}

	
	public Medico(String idTipo, long id, String nombre, int numeroRegistro, String esp) 
	{
		this.tipoDocumento = idTipo;
		this.medicosID = id;
		this.nombre = nombre;
		this.numeroRegistroMedico = numeroRegistro;
		this.Especialidad = esp;
	}
	
	

	public String getTipoDocumento() {
		return tipoDocumento;
	}


	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}


	public long getMedicosID() {
		return medicosID;
	}


	public void setMedicosID(long medicosID) {
		this.medicosID = medicosID;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getNumeroRegistroMedico() {
		return numeroRegistroMedico;
	}


	public void setNumeroRegistroMedico(int numeroRegistroMedico) {
		this.numeroRegistroMedico = numeroRegistroMedico;
	}


	public String getEspecialidad() {
		return Especialidad;
	}


	public void setEspecialidad(String especialidad) {
		Especialidad = especialidad;
	}


	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString() 
	{
		return "Medico [idMedico=" + medicosID + ", Tipo Documento=" + tipoDocumento + ", nombre+" + nombre + ", Especialidad=" + Especialidad + ", Numero Registro="+numeroRegistroMedico +"]";
	}
	
}
