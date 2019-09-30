
package uniandes.isis2304.EPSAndes.negocio;



public interface VOGerente 
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/

	public long getGerenteID();


	public String getCorreo();

	
	public String getNombre();

	public String getTipoDocumento();
	
	public long getEpsID();

	
	@Override
	public String toString();

}
