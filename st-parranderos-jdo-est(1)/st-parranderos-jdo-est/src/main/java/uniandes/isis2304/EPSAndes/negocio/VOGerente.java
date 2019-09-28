
package uniandes.isis2304.EPSAndes.negocio;



public interface VOGerente 
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/

	public long getIdGerente();


	public String getCorreo();

	
	public String getNombre();

	public String getTipoDocumento();

	
	@Override
	public String toString();

}
