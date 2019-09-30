
package uniandes.isis2304.EPSAndes.negocio;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

/**
 * @author
 */
public class Trabajan implements VOTrabajan
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	private long medicosID;	

	private long iPSID;

	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Trabajan() 
	{
		this.medicosID = 0;
		this.iPSID = 0;
	}

	public Trabajan(long idM, long idI) 
	{
		this.medicosID = idM;
		this.iPSID = idI;	
	}

	public long getMedicosID() {
		return medicosID;
	}

	public void setMedicosID(long medicosID) {
		this.medicosID = medicosID;
	}

	public long getiPSID() {
		return iPSID;
	}

	public void setiPSID(long iPSID) {
		this.iPSID = iPSID;
	}

	@Override
	public String toString() 
	{
		return "Trabajan [idMedico=" + medicosID + ", idIps=" + iPSID + "]";
	}


}
