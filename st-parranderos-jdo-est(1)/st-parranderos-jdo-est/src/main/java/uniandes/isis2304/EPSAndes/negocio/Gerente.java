

package uniandes.isis2304.EPSAndes.negocio;


/**
 * @author
 */
public class Gerente implements VOGerente
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	private long idGerente;
	
	
	private String nombre;
	
	
	private String correo;
	
	/*el documento puede ser C.C o Pasaporte
	*/
	private String tipoDocumento;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Gerente() 
	{
		this.idGerente = 0;
		this.nombre="";
		this.tipoDocumento = "";
		this.correo = "";
	}


	public Gerente(long idGerente, String nombre, String correo, String tipoDocumento) 
	{
		this.idGerente = idGerente;
		this.correo = correo;
		this.nombre = nombre;
		this.tipoDocumento = tipoDocumento;
	}


	public long getIdGerente() 
	{
		return idGerente;
	}

	public void setIdBebedor(long idBebedor) 
	{
		this.idGerente = idBebedor;
	}

	
	public String getNombre() 
	{
		return nombre;
	}

	public void setNombre(String nombree) 
	{
		this.nombre = nombree;
	}


	public String getCorreo() 
	{
		return correo;
	}

	
	public void setFechaVisita(String correeo) 
	{
		this.correo = correeo;
	}

	public String getTipoDocumento() 
	{
		return tipoDocumento;
	}

	/**
	 * @param Documento - El nuevo TipoGerente se genero (PASAPORTE, C.C)
	 */
	public void setDocumento(String tipo) 
	{
		this.tipoDocumento = tipo;
	}

	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString() 
	{
		return "El gerente " + idGerente + ", correo=" + correo + ", nombre" + nombre + ", con tipo documento"
				+ tipoDocumento;
	}
}
