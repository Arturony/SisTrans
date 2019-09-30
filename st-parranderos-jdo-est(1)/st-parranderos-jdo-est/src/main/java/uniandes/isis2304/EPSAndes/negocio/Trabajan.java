
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
	private long idMedico;	

	private long idIps;

	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Trabajan() 
	{
		this.idMedico = 0;
		this.idIps = 0;
	}

	public Trabajan(long idM, long idI) 
	{
		this.idMedico = idM;
		this.idIps = idI;	
	}

	
	
	public long getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(long idMedico) {
		this.idMedico = idMedico;
	}

	public long getIdIps() {
		return idIps;
	}

	public void setIdIps(long idIps) {
		this.idIps = idIps;
	}

	@Override
	public String toString() 
	{
		return "Trabajan [idMedico=" + idMedico + ", idIps=" + idIps + "]";
	}


}
