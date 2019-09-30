
package uniandes.isis2304.EPSAndes.negocio;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 
 */
public class Prestaciones implements VOPrestaciones
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/

	private long iPSID;	
	
	private long servicioSaludID;
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Prestaciones() 
	{
		this.iPSID = 0;
		this.servicioSaludID = 0;
	}

	/**
	 * Constructor con valores
	 * 
	 */
	public Prestaciones(long idIps, long idServicio) 
	{
		this.iPSID = idIps;
		this.servicioSaludID = idServicio;
	}
	
	public long getiPSID() {
		return iPSID;
	}

	public void setiPSID(long iPSID) {
		this.iPSID = iPSID;
	}

	public long getServicioSaludID() {
		return servicioSaludID;
	}

	public void setServicioSaludID(long servicioID) {
		this.servicioSaludID = servicioID;
	}

	@Override
	public String toString() 
	{
		return "Prestaciones [id=" + iPSID + ", serviciosID="+ servicioSaludID +"]";
	}

}
