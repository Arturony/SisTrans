
package uniandes.isis2304.EPSAndes.negocio;

import java.util.List;

/**
 * Interfaz para los métodos get
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 * 
 * @author 
 */
public interface VOAfiliado 
{
	public long getEpsID();

	public String getNombre();
	
	public String getCorreo();
	
	public long getAfiliadoID();
	
	public String getTipoDocumento();
	
	public String getFechaNacimiento();
	
	public List<Object[]> getOrdenesRealizadas();
	
	public List<Object[]> getCitasRealizadas();

	/**
	 * @return Una cadena con la información básica de la bebida
	 */
	@Override
	public String toString();
	
	public String toStringCompleto ();

}
