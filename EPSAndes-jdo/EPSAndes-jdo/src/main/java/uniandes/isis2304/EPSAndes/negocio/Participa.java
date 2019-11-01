
package uniandes.isis2304.EPSAndes.negocio;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

/**
 * @author
 */
public class Participa implements VOParticipa
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	private long afiliadoID;	

	private long campanaID;

	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Participa() 
	{
		this.afiliadoID = 0;
		this.campanaID = 0;
	}

	public Participa(long idM, long idI) 
	{
		this.afiliadoID = idM;
		this.campanaID = idI;	
	}

	public long getAfiliadoID() {
		return afiliadoID;
	}

	public void setAfiliadoID(long medicosID) {
		this.afiliadoID = medicosID;
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
		return "Participan [idMedico=" + afiliadoID + ", idIps=" + campanaID + "]";
	}


}
