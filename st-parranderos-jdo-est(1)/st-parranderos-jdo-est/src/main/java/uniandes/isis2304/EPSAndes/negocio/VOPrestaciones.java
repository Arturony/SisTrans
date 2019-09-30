
package uniandes.isis2304.EPSAndes.negocio;

import java.util.List;

/**
 * Interfaz para los métodos get
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 * 
 * @author 
 */
public interface VOPrestaciones 
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	public long getiPSID();
	
	public long getServicioSaludID();

	/**
	 * @return Una cadena de caracteres con la información básica del bebedor
	 */
	@Override
	public String toString();

}
