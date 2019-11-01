
package uniandes.isis2304.EPSAndes.negocio;




public interface VOCampana 
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	
	public long getCampanaID();

	public String getNombre();

	public String getFecha();

	public int getCapacidad();
	
	public long getEpsID();
	@Override
	public String toString();

}
