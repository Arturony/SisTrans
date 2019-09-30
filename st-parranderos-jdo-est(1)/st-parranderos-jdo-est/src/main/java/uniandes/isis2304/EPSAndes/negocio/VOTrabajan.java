

package uniandes.isis2304.EPSAndes.negocio;

import java.util.List;

/**
 * Interfaz para los métodos get
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 * 
 * @author 
 */
public interface VOTrabajan 
{
	public long getIdMedico();
	
	public long getIdIps();
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	
	@Override
	public String toString();

}
