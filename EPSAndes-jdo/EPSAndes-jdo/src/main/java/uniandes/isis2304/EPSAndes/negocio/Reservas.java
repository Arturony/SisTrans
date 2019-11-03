
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
	
	private int capacidadReserva;

	
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
		this.capacidadReserva = 0;
	}

	public Reservas(long idServicio, long idCampana, int capacidad) 
	{
		this.servicioSaludID = idServicio;
		this.campanaID = idCampana;
		this.capacidadReserva = capacidad;
	}

	public long getServicioID() {
		return servicioSaludID;
	}

	public void setServicioID(long medicosID) {
		this.servicioSaludID = medicosID;
	}

	public long getCampanaID() {
		return campanaID;
	}

	public void setCampanaID(long iPSID) {
		this.campanaID = iPSID;
	}
	

	public int getCapacidadReserva() {
		return capacidadReserva;
	}

	public void setCapacidadReserva(int capacidadReserva) {
		this.capacidadReserva = capacidadReserva;
	}

	@Override
	public String toString() 
	{
		return "Reservas [idMedico=" + servicioSaludID + ", idIps=" + campanaID + "capacidad Usada: " + capacidadReserva +"]";
	}


}
