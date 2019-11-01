
package uniandes.isis2304.EPSAndes.negocio;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

/**
 * @author
 */
public class Reservas implements VOReservas
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	private long servicioSaludID;	

	private long campanaID;

	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Reservas() 
	{
		this.servicioSaludID = 0;
		this.campanaID = 0;
	}

	public Reservas(long idM, long idI) 
	{
		this.servicioSaludID = idM;
		this.campanaID = idI;	
	}

	public long getServicioSaludID() {
		return servicioSaludID;
	}

	public void getServicioSaludID(long medicosID) {
		this.servicioSaludID = medicosID;
	}

	public long getCampanaID() {
		return campanaID;
	}

	public void setCampanaID(long iPSID) {
		this.campanaID = iPSID;
	}

	@Override
	public String toString() 
	{
		return "Reservas [idMedico=" + servicioSaludID + ", idIps=" + campanaID + "]";
	}


}
