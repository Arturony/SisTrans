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

package uniandes.isis2304.parranderos.negocio;

/**
 * 
 *
 * @author
 */
public class AdministradorD implements VOAdministradorD
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	private String contrasenia;
	
	private String correo;
	
	private long idAdmin;
	
	private String nombre;
	
	private long idEps;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public AdministradorD() 
	{
		this.contrasenia = "Default";
		this.nombre = "Default";
		this.correo = "Default";
		this.idAdmin = 10000;
		this.idEps = 0;
	}

	public AdministradorD(String nombre, String correo, String contrasenia, long documento, long idEps) 
	{
		this.contrasenia = contrasenia;
		this.nombre = nombre;
		this.correo = correo;
		this.idAdmin = documento;
		this.idEps = 0;
	}

	
	
	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public long getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(long documento) {
		this.idAdmin = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public long getIdEps() {
		return idEps;
	}

	public void setIdEps(long idEps) {
		this.idEps = idEps;
	}

	/**
	 * @return Una cadena de caracteres con la información del tipo de bebida
	 */
	@Override
	public String toString() 
	{
		return "Administrador [idAdmin="+ idAdmin + ", nombre=" + nombre + ", correo=" + correo + ", contraseña="
				+ contrasenia + ", idEps=" + idEps + "]";
	}

}
