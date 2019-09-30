
package uniandes.isis2304.EPSAndes.negocio;

/**
 * @author 
 */
public class Recepcionista implements VORecepcionista
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/

	private long iPSID;
	
	private String tipoDocumento;

	private String nombre;

	private String correo;
	
	private long recepcionistaID;
	
	public Recepcionista()
	{
		iPSID = 0;
		nombre = "";
		correo = "";
		tipoDocumento = "";
		recepcionistaID = 0;
	}
	
	public Recepcionista(long pIdIps, String pNombre, String pCorreo, String tipo, long idRe)
	{
		iPSID = pIdIps;
		nombre = pNombre;
		correo = pCorreo;
		tipoDocumento = tipo;
		recepcionistaID = idRe;
	}
	

	/*el documento puede ser C.C o Pasaporte
	*/
	
	public long getIPSID() {
		return iPSID;
	}


	public void setIPSID(long iPSID) {
		this.iPSID = iPSID;
	}


	public String getTipoDocumento() {
		return tipoDocumento;
	}


	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public long getRecepcionistaID() {
		return recepcionistaID;
	}


	public void setRecepcionistaID(long recepcionistaID) {
		this.recepcionistaID = recepcionistaID;
	}


	@Override
	public String toString() 
	{
		return " Recepcionista [ recepcionistaID=" + recepcionistaID + ", idIps=" + iPSID + ", nombre=" + nombre + "tipoDocumento=" + tipoDocumento + " correo="+ correo +"]" ;
	}
}
