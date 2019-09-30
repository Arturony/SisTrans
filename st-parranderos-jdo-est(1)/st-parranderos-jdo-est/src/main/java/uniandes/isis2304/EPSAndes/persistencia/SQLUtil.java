

package uniandes.isis2304.EPSAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

class SQLUtil
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos
	 * Se renombra acá para facilitar la escritura de las sentencias
	 */
	private final static String SQL = PersistenciaEPSAndes.SQL;

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia general de la aplicación
	 */
	private PersistenciaEPSAndes pp;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/

	/**
	 * Constructor
	 * @param pp - El Manejador de persistencia de la aplicación
	 */
	public SQLUtil (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para obtener un nuevo número de secuencia
	 * @param pm - El manejador de persistencia
	 * @return El número de secuencia generado
	 */
	public long nextval (PersistenceManager pm)
	{
        Query q = pm.newQuery(SQL, "SELECT "+ pp.darSeqEPSAndes () + ".nextval FROM DUAL");
        q.setResultClass(Long.class);
        long resp = (long) q.executeUnique();
        return resp;
	}

	/**
	 * Crea y ejecuta las sentencias SQL para cada tabla de la base de datos - EL ORDEN ES IMPORTANTE 
	 * @param pm - El manejador de persistencia
	 * @return Un arreglo con 7 números que indican el número de tuplas borradas en las tablas GUSTAN, SIRVEN, VISITAN, BEBIDA,
	 * TIPOBEBIDA, BEBEDOR y BAR, respectivamente
	 */
	public long [] limpiarEPSAndes (PersistenceManager pm)
	{
		
        Query qAdmin = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaAdmin ());          
        Query qAfiliado = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaAfiliado ());
        Query qCitas = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCitas());
        Query qEps = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaEps());
        Query qGerente = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaGerente());
        Query qIps = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaIPS());
        Query qMedicos = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaMedico());
        Query qOrdenes = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaOrdenes());
        Query qPrestaciones = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPrestaciones());
        Query qRecep = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaRecepcionista());
        Query qServ = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicio());
        Query qTrabajan = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaTrabajan());

        long gustanEliminados = (long) qAdmin.executeUnique ();
        long sirvenEliminados = (long) qAfiliado.executeUnique ();
        long visitanEliminadas = (long) qCitas.executeUnique ();
        long bebidasEliminadas = (long) qEps.executeUnique ();
        long tiposBebidaEliminados = (long) qGerente.executeUnique ();
        long bebedoresEliminados = (long) qIps.executeUnique ();
        long baresEliminados = (long) qMedicos.executeUnique ();
        long ordenesEliminados = (long) qOrdenes.executeUnique ();
        long presEliminados = (long) qPrestaciones.executeUnique ();
        long recepEliminados = (long) qRecep.executeUnique ();
        long servEliminados = (long) qServ.executeUnique ();
        long trabEliminados = (long) qTrabajan.executeUnique ();
        return new long[] {gustanEliminados, sirvenEliminados, visitanEliminadas, bebidasEliminadas, 
        		tiposBebidaEliminados, bebedoresEliminados, baresEliminados, ordenesEliminados, presEliminados,
        		recepEliminados, servEliminados, trabEliminados};

	}

}
