
package uniandes.isis2304.EPSAndes.negocio;

/**
 * @author 
 */
public interface VORecepcionista 
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/

	public long getRecepcionistaID();
	
	public String getCorreo();
	
	public String getNombre();
	 
	public String getTipoDocumento();
	
	public long getiPSID();
	
	@Override
	public String toString();

}
