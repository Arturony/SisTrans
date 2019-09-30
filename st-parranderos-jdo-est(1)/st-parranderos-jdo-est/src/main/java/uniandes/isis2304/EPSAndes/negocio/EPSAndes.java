

package uniandes.isis2304.EPSAndes.negocio;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import com.google.gson.JsonObject;

import uniandes.isis2304.EPSAndes.persistencia.PersistenciaEPSAndes;

/**
 * Clase principal del negocio
 * Sarisface todos los requerimientos funcionales del negocio
 *
 * @author
 */
public class EPSAndes 
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(EPSAndes.class.getName());
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia
	 */
	private PersistenciaEPSAndes pp;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * El constructor por defecto
	 */
	public EPSAndes()
	{
		pp = PersistenciaEPSAndes.getInstance ();
	}
	
	/**
	 * El constructor qye recibe los nombres de las tablas en tableConfig
	 * @param tableConfig - Objeto Json con los nombres de las tablas y de la unidad de persistencia
	 */
	public EPSAndes (JsonObject tableConfig)
	{
		pp = PersistenciaEPSAndes.getInstance (tableConfig);
	}
	
	/**
	 * Cierra la conexión con la base de datos (Unidad de persistencia)
	 */
	public void cerrarUnidadPersistencia ()
	{
		pp.cerrarUnidadPersistencia ();
	}
	
	public Medico adicionarMedico(String nombre, String especialidad, String tipoDocumento, int numReg, long id)
	{
		log.info ("Adicionando Medico: " + nombre);
        Medico medico = pp.adicionarMedico(nombre, id, especialidad, tipoDocumento, numReg);		
        log.info ("Adicionando Medico: " + medico);
        return medico;
	}
	
	public Afiliado adicionarAfiliado(String nombre, int documento, String tipoDocumento, String fecha, String correo)
	{
		log.info ("Adicionando Afiliado: " + nombre);
        Afiliado afiliado = pp.adicionarAfiliado(nombre, correo, documento, tipoDocumento, fecha, 1);		
        log.info ("Adicionando Afiliado: " + afiliado);
        return afiliado;
	}
	
	public Recepcionista adicionarRecepcionista(String nombre, int documento, String tipo, String fecha, String correo)
	{
		log.info ("Adicionando recepcionista: " + nombre);
        Recepcionista recep = pp.adicionarRecepcionista(nombre, correo, documento, tipo, fecha, 1);		
        log.info ("Adicionando recepcionista: " + recep);
        return recep;
	}
	
	public AdministradorD adicionarAdministrador(String nombre, int documento, String tipo, String contrasenia, String correo)
	{
		log.info ("Adicionando Administrador: " + nombre);
        AdministradorD admin = pp.adicionarAdministrador(nombre, correo, documento, tipo, contrasenia, 1);		
        log.info ("Adicionando Administrador: " + admin);
        return admin;
	}
	
	public Gerente adicionarGerente(String nombre, String correo, int idGerente, String tipo)
	{
		log.info ("Adicionando gerente: " + idGerente);
       	Gerente gerente = pp.adicionarGerente(nombre, correo, idGerente, tipo, 1);		
        log.info ("Adicionando gerente: " + gerente);
        return gerente;
	}
	
	public IPS adicionarIPS(String nombre, int documento, String localizacion)
	{
		log.info ("Adicionando ips: " + nombre);
        IPS ips = pp.adicionarIPS(nombre, localizacion, documento, 1);		
        log.info ("Adicionando ips: " + ips);
        return ips;
	}
	
	public EPS adicionarEPS(String nombre, int epsID)
	{
		log.info ("Adicionando eps: " + nombre);
        EPS eps = pp.adicionarEPS(nombre, epsID);		
        log.info ("Adicionando eps: " + eps);
        return eps;
	}
	
	public Servicios adicionarServicio(String nombre, int idServ, String horario, int medicosDisponibles)
	{
		log.info ("Adicionando servicio: " + nombre);
        Servicios servicio = pp.adicionarServicio(nombre, horario, idServ, medicosDisponibles);		
        log.info ("Adicionando servicio: " + servicio);
        return servicio;
	}
	
	public Orden adicionarOrden(int afiliado, int servicio, int ordenes)
	{
		log.info ("Adicionando orden: " + ordenes);
       	Orden orden = pp.adicionarOrden(servicio, afiliado, ordenes);		
        log.info ("Adicionando orden: " + orden);
        return orden;
	}
	
	public CitaMedica adicionarCita(int afiliado, int servicio, int idCita, String horario, int sesiones)
	{
		log.info ("Adicionando cita: " + idCita);
       	CitaMedica cita = pp.adicionarCita(servicio, afiliado, idCita, horario, 0, sesiones);		
        log.info ("Adicionando cita: " + cita);
        return cita;
	}
	
	public long[] limpiarBD()
	{
		log.info ("Limpiando base de datos");
       	long[] array = pp.limpiarEPS();	
       	log.info ("Limpiando base de datos");
        return array;
	}
	
	public EPS consultarEPS(long epsID)
	{
		log.info ("Buscando EPS: " + epsID);
        EPS eps = pp.darEPSporID(epsID);		
        log.info ("Buscando EPS: " + eps);
        return eps;
	}
	
	public AdministradorD consultarAdmin(long epsID)
	{
		log.info ("Buscando Admin: " + epsID);
        AdministradorD eps = pp.darAdminporID(epsID);		
        log.info ("Buscando Admin: " + eps);
        return eps;
	}
	
	public Gerente consultarGerente(long epsID)
	{
		log.info ("Buscando Gerente: " + epsID);
        Gerente eps = pp.darGerenteID(epsID);		
        log.info ("Buscando Gerente: " + eps);
        return eps;
	}
	
	public Afiliado consultarAfiliado(long id)
	{
		log.info ("Buscando Afiliado: " + id);
        Afiliado medico = pp.darAfiliadoID(id);		
        log.info ("Buscando Afiliado: " + medico);
        return medico;
	}
	
	public Medico consultarMedico(long id)
	{
		log.info ("Buscando Medico: " + id);
        Medico medico = pp.darMedicoID(id);		
        log.info ("Buscando Medico: " + medico);
        return medico;
	}
	
	public Recepcionista consultarRecepcionista(long id)
	{
		log.info ("Buscando Recepcionista: " + id);
        Recepcionista medico = pp.darRecepcionistaID(id);		
        log.info ("Buscando Recepcionista: " + medico);
        return medico;
	}
	
	
}
