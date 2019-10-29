/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad	de	los	Andes	(Bogotá	- Colombia)
 * Departamento	de	Ingeniería	de	Sistemas	y	Computación
 * Licenciado	bajo	el	esquema	Academic Free License versión 2.1
 * 		
 * Curso: isis2304 - Sistemas Transaccionales
 * Proyecto: Parranderos Uniandes
 * @version 1.0
 * @author Germán Bravo
 * Julio de 2018
 * 
 * Revisado por: Claudia Jiménez, Christian Ariza
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.isis2304.EPSAndes.negocio;

/**
 * 
 *
 * @author
 */
public class Organizador implements VOOrganizador
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	private String contraseña;
	
	private String correo;
	
	private long organizadorID;
	
	private String tipoDocumento;
	
	private String nombre;
	
	private long epsID;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Organizador() 
	{
		this.contraseña = "Default";
		this.nombre = "Default";
		this.correo = "Default";
		this.organizadorID = 10000;
		this.epsID = 0;
	}

	public Organizador(String nombre, String correo, String contrasenia, long documento, long idEps) 
	{
		this.contraseña = contrasenia;
		this.nombre = nombre;
		this.correo = correo;
		this.organizadorID = documento;
		this.epsID = 0;
	}

	
	
	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contrasenia) {
		this.contraseña = contrasenia;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public long getOrganizadorID() {
		return organizadorID;
	}

	public void setOrganizadorID(long documento) {
		this.organizadorID = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public long getEpsID() {
		return epsID;
	}

	public void setEpsID(long idEps) {
		this.epsID = idEps;
	}

	
	
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	/**
	 * @return Una cadena de caracteres con la información del tipo de bebida
	 */
	@Override
	public String toString() 
	{
		return "Organizador [idOrganizador="+ organizadorID + "tipoDocumento=" + tipoDocumento + ", nombre=" + nombre + ", correo=" + correo + ", contraseña="
				+ contraseña + ", idEps=" + epsID + "]";
	}

}
