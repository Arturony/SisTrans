

package uniandes.isis2304.EPSAndes.negocio;

/**
 * Interfaz para los métodos get
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 * 
 * @author
 */
public interface VOOrden 
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * @return El id 
	 */
	public long getId();

	public long getIdAfiliado();
	
	public long getIdServicio();

	/**
	 * @return Una cadena de caracteres con la información
	 */
	@Override
	public String toString(); 
}
