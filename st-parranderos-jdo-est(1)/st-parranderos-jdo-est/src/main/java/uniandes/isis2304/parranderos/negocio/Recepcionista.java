
package uniandes.isis2304.parranderos.negocio;

/**
 * @author 
 */
public class Recepcionista implements VORecepcionista
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/

	private long idIps;

	private String nombre;

	private String correo;

	/*el documento puede ser C.C o Pasaporte
	*/
	private String tipoDocumento;
	private long idRecepcionista;

	public long getIdRecepcionista() {
		return idRecepcionista;
	}
	public void setIdRecepcionista(long idRecepcionista) {
		this.idRecepcionista = idRecepcionista;
	}
	public long getIdIps() {
		return idIps;
	}
	public void setIdIps(long idIps) {
		this.idIps = idIps;
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
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	/**
	 * @param Documento - El nuevo TipoDocumento se genero que puede ser (PASAPORTE, C.C)
	 */
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	@Override
	public String toString() 
	{
		return "Sirven id recepcionista " + idRecepcionista + ", idIps " + idIps + ", nombre " + nombre + "tipoDocumento " + tipoDocumento + "y correo "+correo ;
	}
}
