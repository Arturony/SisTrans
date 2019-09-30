

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

	public long getMedicosID();
	
	public int getNumeroRegistroMedico();
	
	public String getNombre();
	
	public String getTipoDocumento();
	
	public String getEspecialidad();
	
	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString();
	
}
