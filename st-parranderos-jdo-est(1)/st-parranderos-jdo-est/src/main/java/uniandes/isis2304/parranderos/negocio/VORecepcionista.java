
package uniandes.isis2304.parranderos.negocio;

/**
 * @author 
 */
public interface VORecepcionista 
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/

	public long getIdRecepcionista();
	
	public String getCorreo();
	
	public String getNombre();
	 
	public String getTipoDocumento();
	
	public long getIdIps();
	
	@Override
	public String toString();

}
