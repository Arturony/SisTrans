
package uniandes.isis2304.EPSAndes.negocio;

/**
 * Interfaz para los métodos get.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 * 
 * @author
 */
public interface VOCitaMedica 
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	
	public String getHorario();
	
	public long getCitaMedicaID();
	
	public int getLlego();
	
	public int getSesiones();
	
	public long getAfiliadoID();
	
	public long getServicioSaludID();
	

	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString();

}
