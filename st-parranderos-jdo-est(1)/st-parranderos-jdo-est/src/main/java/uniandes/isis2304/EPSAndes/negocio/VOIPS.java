
package uniandes.isis2304.EPSAndes.negocio;




public interface VOIPS 
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	
	public long getIdIps();

	public String getNombre();

	public String getLocalizacion();

	public long getIdEps();
	@Override
	public String toString();

	//public String toStringCompleto ();

}
