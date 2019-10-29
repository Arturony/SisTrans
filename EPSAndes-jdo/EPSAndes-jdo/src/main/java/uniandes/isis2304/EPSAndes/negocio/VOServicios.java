

package uniandes.isis2304.EPSAndes.negocio;

/**
 * @author 
 */
public interface VOServicios 
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	public String getHorario();
	
	public long getServicioSaludID();
	
	public int getMedicosDisponibles();
	
	public String getNombre();
	
	public int getIPSID();

	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString();

}
