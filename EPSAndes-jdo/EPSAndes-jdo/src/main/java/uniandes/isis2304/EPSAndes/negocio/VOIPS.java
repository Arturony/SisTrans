
package uniandes.isis2304.EPSAndes.negocio;




public interface VOIPS 
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	
	public long getIPSID();

	public String getNombre();

	public String getLocalizacion();

	public long getEpsID();
	@Override
	public String toString();

}
