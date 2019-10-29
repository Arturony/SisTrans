

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
	
	public Medico conusltarMedico(String nombre, String tipoDocumento, int id, int reg)
	{
		log.info ("Consultando Medico: " + nombre);
        Medico medico = pp.darMedico(nombre, id, tipoDocumento, reg);		
        log.info ("Consultando Medico: " + medico);
        return medico;
	}
	
	public Afiliado adicionarAfiliado(String nombre, int documento, String tipoDocumento, String fecha, String correo)
	{
		log.info ("Adicionando Afiliado: " + nombre);
        Afiliado afiliado = pp.adicionarAfiliado(nombre, correo, documento, tipoDocumento, fecha, 1);		
        log.info ("Adicionando Afiliado: " + afiliado);
        return afiliado;
	}
	
	public Afiliado consultarAfiliado(String nombre, int documento, String tipoDocumento, String correo)
	{
		log.info ("Consultando Afiliado: " + nombre);
        Afiliado afiliado = pp.darAfiliado(nombre, correo, documento, tipoDocumento);		
        log.info ("Consultando Afiliado: " + afiliado);
        return afiliado;
	}
	
	public Recepcionista adicionarRecepcionista(String nombre, int documento, String tipo, int idIps, String correo)
	{
		log.info ("Adicionando recepcionista: " + nombre);
        Recepcionista recep = pp.adicionarRecepcionista(nombre, correo, documento, tipo, idIps);		
        log.info ("Adicionando recepcionista: " + recep);
        return recep;
	}
	
	public Recepcionista consultarRecepcionista(String nombre, int documento, String tipo, String correo)
	{
		log.info ("Consultando recepcionista: " + nombre);
        Recepcionista recep = pp.darRecepcionista(nombre, correo, documento, tipo);		
        log.info ("Consultando recepcionista: " + recep);
        return recep;
	}
	
	public AdministradorD adicionarAdministrador(String nombre, int documento, String tipo, String contrasenia, String correo)
	{
		log.info ("Adicionando Administrador: " + nombre);
        AdministradorD admin = pp.adicionarAdministrador(nombre, correo, documento, tipo, contrasenia, 1);		
        log.info ("Adicionando Administrador: " + admin);
        return admin;
	}
	
	public AdministradorD consultarAdministrador(String nombre, int documento, String tipo, int contrasenia, String correo)
	{
		log.info ("Consultando Administrador: " + nombre);
        AdministradorD admin = pp.darAdmin(nombre, correo, documento, tipo, contrasenia);		
        log.info ("Consultando Administrador: " + admin);
        return admin;
	}
	
	public Gerente adicionarGerente(String nombre, String correo, int idGerente, String tipo)
	{
		log.info ("Adicionando gerente: " + idGerente);
       	Gerente gerente = pp.adicionarGerente(nombre, correo, idGerente, tipo, 1);		
        log.info ("Adicionando gerente: " + gerente);
        return gerente;
	}
	
	public Gerente consultarGerente(String nombre, String correo, int idGerente, String tipo)
	{
		log.info ("Consultando gerente: " + idGerente);
       	Gerente gerente = pp.darGerente(nombre, correo, idGerente, tipo);		
        log.info ("Consultando gerente: " + gerente);
        return gerente;
	}
	
	public IPS adicionarIPS(String nombre, int documento, String localizacion, int idEps)
	{
		log.info ("Adicionando ips: " + nombre);
        IPS ips = pp.adicionarIPS(nombre, localizacion, documento, idEps);		
        log.info ("Adicionando ips: " + ips);
        return ips;
	}
	
	public IPS consultarIPS(String nombre, int documento, String localizacion)
	{
		log.info ("Consultando ips: " + nombre);
        IPS ips = pp.darIPS(nombre, documento, localizacion);		
        log.info ("Consultando ips: " + ips);
        return ips;
	}
	
	public EPS adicionarEPS(String nombre, int epsID)
	{
		log.info ("Adicionando eps: " + nombre);
        EPS eps = pp.adicionarEPS(nombre, epsID);		
        log.info ("Adicionando eps: " + eps);
        return eps;
	}
	
	public EPS consultarEPS(String nombre, int epsID)
	{
		log.info ("Consultando eps: " + nombre);
        EPS eps = pp.darEPS(nombre, epsID);		
        log.info ("Consultando eps: " + eps);
        return eps;
	}
	
	public Servicios adicionarServicio(String nombre, int idServ, String horario, int medicosDisponibles, int idIps)
	{
		log.info ("Adicionando servicio: " + nombre);
        Servicios servicio = pp.adicionarServicio(nombre, horario, idServ, medicosDisponibles, idIps);		
        log.info ("Adicionando servicio: " + servicio);
        return servicio;
	}
	
	public Servicios consultarServicio(String nombre, int idServ, String horario)
	{
		log.info ("Consultando servicio: " + nombre);
        Servicios servicio = pp.darServicio(nombre, idServ, horario);		
        log.info ("Consultando servicio: " + servicio);
        return servicio;
	}
	
	public Orden adicionarOrden(int afiliado, int servicio, int ordenes)
	{
		log.info ("Adicionando orden: " + ordenes);
       	Orden orden = pp.adicionarOrden(servicio, afiliado, ordenes);		
        log.info ("Adicionando orden: " + orden);
        return orden;
	}
	
	public Orden consultarOrden(int afiliado, int servicio, int ordenes)
	{
		log.info ("Consultando orden: " + ordenes);
       	Orden orden = pp.darOrden(servicio, afiliado, ordenes);		
        log.info ("Consultando orden: " + orden);
        return orden;
	}
	
	public CitaMedica adicionarCita(int afiliado, int servicio, int idCita, String horario, int sesiones)
	{
		log.info ("Adicionando cita: " + idCita);
       	CitaMedica cita = pp.adicionarCita(servicio, afiliado, idCita, horario, 0, sesiones);		
        log.info ("Adicionando cita: " + cita);
        return cita;
	}
	
	public CitaMedica consultarCita(int afiliado, int servicio, int idCita, String horario, int sesiones)
	{
		log.info ("Consultando cita: " + idCita);
       	CitaMedica cita = pp.darCita(servicio, afiliado, idCita, horario, sesiones);		
        log.info ("Consultando cita: " + cita);
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
	
	public AdministradorD consultarAdminID(long epsID)
	{
		log.info ("Buscando Admin: " + epsID);
        AdministradorD eps = pp.darAdminporID(epsID);		
        log.info ("Buscando Admin: " + eps);
        return eps;
	}
	
	public Gerente consultarGerenteID(long epsID)
	{
		log.info ("Buscando Gerente: " + epsID);
        Gerente eps = pp.darGerenteID(epsID);		
        log.info ("Buscando Gerente: " + eps);
        return eps;
	}
	
	public Afiliado consultarAfiliadoID(long id)
	{
		log.info ("Buscando Afiliado: " + id);
        Afiliado medico = pp.darAfiliadoID(id);		
        log.info ("Buscando Afiliado: " + medico);
        return medico;
	}
	
	public Medico consultarMedicoID(long id)
	{
		log.info ("Buscando Medico: " + id);
        Medico medico = pp.darMedicoID(id);		
        log.info ("Buscando Medico: " + medico);
        return medico;
	}
	
	public Recepcionista consultarRecepcionistaID(long id)
	{
		log.info ("Buscando Recepcionista: " + id);
        Recepcionista medico = pp.darRecepcionistaID(id);		
        log.info ("Buscando Recepcionista: " + medico);
        return medico;
	}
	
	public CitaMedica prestarServicio(int idAfiliado, int idCita)
	{
		log.info ("Modificando cita: " + idCita);
       	CitaMedica cita = pp.registrarPrestacion(idAfiliado, idCita);		
        log.info ("Modificando cita: " + cita);
        return cita;
	}
	
	public List<Servicios> darServicios()
	{
		log.info ("Retornando Servicios: ");
       	List<Servicios> servicios = pp.darServicios();		
        log.info ("Retornando Servicios: ");
        return servicios;
	}
	
	public List<Servicios> consultarServiciosFecha(String horario)
	{
		log.info ("Retornando Servicios: ");
       	List<Servicios> servicios = pp.consultarServicios(horario);		
        log.info ("Retornando Servicios: ");
        return servicios;
	}
}
