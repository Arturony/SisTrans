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
	
	private String correo;
	
	private long idAfiliado;
	
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
		this.nombre = "Default";
		this.correo = "Default";
		this.idAfiliado = 0;
		this.tipo = "Default";
		this.idEps = 0;
	}

	public Afiliado(String tipo, String nombre, String correo, long documento, long idEps) 
	{
		this.nombre = nombre;
		this.correo = correo;
		this.idAfiliado = documento;
		this.tipo = tipo;
		this.idEps = idEps;
	}


	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public long getIdAfiliado() {
		return idAfiliado;
	}

	public void setIdAfiliado(long documento) {
		this.idAfiliado = documento;
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
		return "Afiliado [idAfiliado="+ idAfiliado + ", nombre=" + nombre + ", correo=" + 
	", idEps=" + idEps + ", TipoDocumento="+ tipo +"]";
	}

}
