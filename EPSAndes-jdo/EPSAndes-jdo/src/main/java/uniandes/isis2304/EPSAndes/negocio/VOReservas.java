

package uniandes.isis2304.EPSAndes.negocio;

import java.util.List;

/**
 * Interfaz para los métodos get
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 * 
 * @author 
 */
public interface VOReservas 
{
	public long getServicioID();
	
	public long getCampanaID();
	
	public int getCapacidadReserva();
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	
	@Override
	public String toString();

}
