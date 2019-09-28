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
public class Afiliado implements VOAfiliado
{

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	private String contrasenia;
	
	private String correo;
	
	private String documento;
	
	private String nombre;
	
	private long idEps;
	
	private String tipo;
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Afiliado() 
	{
		this.contrasenia = "Default";
		this.nombre = "Default";
		this.correo = "Default";
		this.documento = "10000";
		this.tipo = "Default";
		this.idEps = 0;
	}

	public Afiliado(String tipo, String nombre, String correo, String contrasenia, String documento, long idEps) 
	{
		this.contrasenia = contrasenia;
		this.nombre = nombre;
		this.correo = correo;
		this.documento = documento;
		this.tipo = tipo;
		this.idEps = idEps;
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

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public long getIdEps() {
		return idEps;
	}

	public void setIdEps(long idEps) {
		this.idEps = idEps;
	}

	/**
	 * @return Una cadena con la información básica 
	 */
	@Override
	public String toString() 
	{
		return "Bebida [id=" + ", nombre=" + nombre + ", idTipoBebida=" + documento + ", gradoAlcohol=" + correo + "]";
	}

}
