

package uniandes.isis2304.EPSAndes.negocio;


/**
 * @author
 */
public class Gerente implements VOGerente
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	private long gerenteID;
	
	
	private String nombre;
	
	
	private String correo;
	
	/*el documento puede ser C.C o Pasaporte
	*/
	private String tipoDocumento;
	
	private long epsID;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Gerente() 
	{
		this.gerenteID = 0;
		this.nombre="";
		this.tipoDocumento = "";
		this.correo = "";
		this.epsID = 0;
	}


	public Gerente(long idGerente, String nombre, String correo, String tipoDocumento, long epsId) 
	{
		this.gerenteID = idGerente;
		this.correo = correo;
		this.nombre = nombre;
		this.tipoDocumento = tipoDocumento;
		this.epsID = epsId;
	}


	
	public String getNombre() 
	{
		return nombre;
	}

	public void setNombre(String nombree) 
	{
		this.nombre = nombree;
	}
	

	public long getGerenteID() {
		return gerenteID;
	}


	public void setGerenteID(long gerenteID) {
		this.gerenteID = gerenteID;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getTipoDocumento() {
		return tipoDocumento;
	}


	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}


	public long getEpsID() {
		return epsID;
	}


	public void setEpsID(long epsID) {
		this.epsID = epsID;
	}


	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString() 
	{
		return "El gerente " + gerenteID + ", correo=" + correo + ", nombre" + nombre + ", con tipo documento"
				+ tipoDocumento;
	}
}
