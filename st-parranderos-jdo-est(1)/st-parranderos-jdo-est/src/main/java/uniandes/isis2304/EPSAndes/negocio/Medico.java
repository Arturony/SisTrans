

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
	private String tipo;
	
	private long idMedico;
	
	private String nombre;
	
	private int numeroRegistro;
	
	private String especialidad;
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Medico() 
	{
		this.tipo = "";
		this.idMedico = 0;
		this.nombre = "Default";
		this.numeroRegistro = 0;
		this.especialidad = "";
	}

	
	public Medico(String idTipo, long id, String nombre, int numeroRegistro, String esp) 
	{
		this.tipo = idTipo;
		this.idMedico = id;
		this.nombre = nombre;
		this.numeroRegistro = numeroRegistro;
		this.especialidad = esp;
	}
	
	
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String idTipo) {
		this.tipo = idTipo;
	}

	public long getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(long id) {
		this.idMedico = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumeroRegistro() {
		return numeroRegistro;
	}

	public void setNumeroRegistro(int numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}

	
	public String getEspecialidad() {
		return especialidad;
	}


	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString() 
	{
		return "Medico [idMedico=" + idMedico + ", Tipo Documento=" + tipo + ", nombre+" + nombre + ", Especialidad=" + especialidad + ", Numero Registro="+numeroRegistro +"]";
	}
	
}
