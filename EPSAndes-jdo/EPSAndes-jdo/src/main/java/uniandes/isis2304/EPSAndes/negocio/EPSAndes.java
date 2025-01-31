

package uniandes.isis2304.EPSAndes.negocio;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Transaction;

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
	
	public Afiliado adicionarAfiliado(String nombre, int documento, String tipoDocumento, String fecha, String correo, int idEps)
	{
		log.info ("Adicionando Afiliado: " + nombre);
        Afiliado afiliado = pp.adicionarAfiliado(nombre, correo, documento, tipoDocumento, fecha, idEps);		
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
	
	public Organizador adicionarOrganizador(String nombre, int documento, String tipo, String contrasenia, String correo, int idEps)
	{
		log.info ("Adicionando Organizador: " + nombre);
        Organizador org = pp.adicionarOrganizador(nombre, correo, documento, tipo, contrasenia, idEps);		
        log.info ("Adicionando Organizador: " + org);
        return org;
	}
	
	public Organizador consultarOrganizador(String nombre, int documento, String tipo, int contrasenia, String correo)
	{
		log.info ("Consultando Organizador: " + nombre);
        Organizador org = pp.darOrganizador(nombre, correo, documento, tipo, contrasenia);		
        log.info ("Consultando Organizador: " + org);
        return org;
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
	
	public Servicios adicionarServicio(String nombre, int idServ, String horario, int medicosDisponibles, int idIps, int reserva)
	{
		log.info ("Adicionando servicio: " + nombre);
        Servicios servicio = pp.adicionarServicio(nombre, horario, idServ, medicosDisponibles, idIps, reserva);		
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
	
	public Campana agregarCampana(long id, String nombre, String fecha, int cap, int epsId)
	{
		log.info ("Agregando Campaña: " + id);
       	Campana campana = pp.agregarCampana(id, nombre, fecha, cap, epsId);		
        log.info ("Agregando Campaña: " + campana);
        return campana;
	}

	public Participa adicionarParticipan(long idAfiliado, long idCampana) 
	{
		log.info ("Agregando Participan: ");
       	Participa participa = pp.adicionarParticipan(idAfiliado, idCampana);		
        log.info ("Agregando Participan: " + participa);
        return participa;
	}
	
	public Participa eliminarParticipan(long idAfiliado, long idCampana) 
	{
		log.info ("Agregando Participan: ");
       	Participa participa = pp.eliminarParticipan(idAfiliado, idCampana);		
        log.info ("Agregando Participan: " + participa);
        return participa;
	}
	
	public Reservas adicionarReservan(long idServicio, long idCampana, int reserva) 
	{
		log.info ("Agregando Participan: ");
       	Reservas participa = pp.adicionarReservas(idServicio, idCampana, reserva);		
        log.info ("Agregando Participan: " + participa);
        return participa;
	}
	
	public Reservas eliminarReservan(long idServicio, long idCampana) 
	{
		log.info ("Agregando Participan: ");
       	Reservas participa = pp.eliminarReservas(idServicio, idCampana);		
        log.info ("Agregando Participan: " + participa);
        return participa;
	}
	
	public long reservarServicio(long idServicio)
	{
		log.info ("Modificando Servicio: " + idServicio);
       	long participa = pp.reservarServicio(idServicio);		
        log.info ("Modificando Servicio: " + idServicio);
        return participa;
	}
	
	public long desreservarServicio(long idServicio)
	{
		log.info ("Modificando Servicio: " + idServicio);
       	long participa = pp.desreservarServicio(idServicio);		
        log.info ("Modificando Servicio: " + idServicio);
        return participa;
	}

	public Campana eliminarCampana(long id, String nombre, long epsId)
	{
		log.info ("Eliminando Campaña: " + id);
       	Campana campana = pp.eliminarCampana(id, nombre, epsId);		
        log.info ("Eliminando Campaña: " + campana);
        return campana;
	}
	
	public long reducirCapacidadNumero(long idServicio, int redusion)
	{
		log.info ("Modificando Servicio: " + idServicio);
       	long serv = pp.reducirCapacidadNumero(idServicio, redusion);		
        log.info ("Modificando Servicio: " + serv);
        return serv;
	}
	
	public List<Servicios> darServicios()
	{
		log.info ("Retornando Servicios: ");
       	List<Servicios> servicios = pp.darServicios();		
        log.info ("Retornando Servicios: ");
        return servicios;
	}
	
	public List<IPS> darIPS()
	{
		log.info ("Retornando IPS: ");
       	List<IPS> IPS = pp.darIPS();		
        log.info ("Retornando IPS: ");
        return IPS;
	}
	
	public List<EPS> darEPS()
	{
		log.info ("Retornando EPS: ");
       	List<EPS> EPS = pp.darEPS();		
        log.info ("Retornando EPS: ");
        return EPS;
	}
	
	public List<Campana> darCampanas()
	{
		log.info ("Retornando EPS: ");
       	List<Campana> campanas = pp.darCampanas();		
        log.info ("Retornando EPS: ");
        return campanas;
	}
	
	public List<Reservas> darReservasCampana(long idCampana)
	{
		log.info ("Retornando Reservas: ");
       	List<Reservas> reservas = pp.darReservasCampana(idCampana);		
        log.info ("Retornando Reservas: ");
        return reservas;
	}
	
	public List<Servicios> consultarServiciosFecha(String horario)
	{
		log.info ("Retornando Servicios: ");
       	List<Servicios> servicios = pp.consultarServicios(horario);		
        log.info ("Retornando Servicios: ");
        return servicios;
	}
	
	public List<Servicios> consultarServiciosNombre(String nombre)
	{
		log.info ("Retornando Servicios: ");
       	List<Servicios> servicios = pp.consultarServiciosNombre(nombre);		
        log.info ("Retornando Servicios: ");
        return servicios;
	}
	
	public List<Servicios> consultarServiciosReservados()
	{
		log.info ("Retornando Servicios: ");
       	List<Servicios> servicios = pp.consultarServiciosReservados();		
        log.info ("Retornando Servicios: ");
        return servicios;
	}
	
	public List<Servicios> consultarServiciosNoreservados()
	{
		log.info ("Retornando Servicios: ");
       	List<Servicios> servicios = pp.consultarServiciosNoreservados();		
        log.info ("Retornando Servicios: ");
        return servicios;
	}
	
	public List<Servicios> consultarServiciosEnCampania(long idCampania)
	{
		log.info ("Retornando Servicios: ");
       	List<Servicios> servicios = pp.consultarServiciosEnCampania(idCampania);		
        log.info ("Retornando Servicios: ");
        return servicios;
	}
	
	public Afiliado darAfiliadoAleatorio()
	{
		log.info ("Buscando Afiliado: ");
        Afiliado medico = pp.darAfiliadoAleatorio();		
        log.info ("Buscando Afiliado: " + medico);
        return medico;
	}
	
	public String ejecutarQuery(String query)
	{
		log.info ("Ejecutando Query: " + query);
       	String que = pp.ejecutarQuery(query);		
        log.info ("Ejecutando Query: " + query);
        return que;
	}
}
