

package uniandes.isis2304.EPSAndes.negocio;

/**
 * Interfaz para los métodos get
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 * 
 * @author
 */
public interface VOMedico 
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/

	public long getIdMedico();
	
	public int getNumeroRegistro();
	
	public String getNombre();
	
	public String getTipo();
	
	public String getEspecialidad();
	
	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString();
	
}
