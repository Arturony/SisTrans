package uniandes.isis2304.EPSAndes.interfazAppPaneles;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import uniandes.isis2304.EPSAndes.interfazApp.InterfazEPSAndesApu;
import uniandes.isis2304.EPSAndes.negocio.Servicios;


public class DialogoCrearCampana extends JDialog
{
	// -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia a la clase principal de la interfaz
     */
    private InterfazEPSAndesApu principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Es el panel con los datos para crear el nuevo disco
     */
    private PanelCrearCampana panelDatos;

    /**
     * Es el panel con los botones para guardar el disco
     */
    private PanelBotonesCampana panelBotones;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el diálogo
     * @param id es una referencia a la clase principal de la interfaz
     */
    public DialogoCrearCampana( InterfazEPSAndesApu id )
    {
        super( id, true );
        principal = id;

        panelDatos = new PanelCrearCampana(this);
        panelBotones = new PanelBotonesCampana( this );

        getContentPane( ).add( panelDatos, BorderLayout.CENTER );
        getContentPane( ).add( panelBotones, BorderLayout.SOUTH );

        setTitle( "Crear Disco" );
        pack( );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Guarda el disco
     */
    public void crearCampana( )
    {
        boolean parametersOk = true;
        String horario = panelDatos.darHorario();
        String nombre = panelDatos.darNombre();
        int capa = panelDatos.darCapacidad();
        String id = panelDatos.darID();
        try 
        {
			int idCampana = Integer.parseInt(id);
			if(capa < 0 && idCampana < 0 )
				JOptionPane.showMessageDialog( this, "Ingrese datos positivos" );
			if( ( horario.equals( "" ) || nombre.equals( "" ) ) ||  id.equals( "" ) ) 
			{
				parametersOk = false;
				JOptionPane.showMessageDialog( this, "Todos los campos deben ser llenados para crear el disco" );
			}
			if( parametersOk )
			{
				try
				{
					ArrayList<Servicios> s = panelDatos.getServiciosTrue();
					ArrayList<Integer> c = panelDatos.getCapacidades();
					ArrayList<String> s1 = panelDatos.getServicios();
					
					principal.adicionarCampana(nombre, idCampana, horario, capa, 1);
					
					for(int i = 0; i < c.size(); i++)
					{
						int k = c.get(i);
						if(planB(s1.get(i), s, c.get(i)))
						{
							for(int j = 0; j < s.size(); j++)
							{
								if(s1.get(i).equals(s.get(j).getNombre()) && k > 0)
								{							
									if(k > s.get(j).getMedicosDisponibles()-1)
									{
										k = c.get(i) - s.get(j).getMedicosDisponibles()-1;
										principal.reducirCapacidad(s.get(j).getServicioSaludID(), (s.get(j).getMedicosDisponibles()-1));
										principal.adicionarReservas(s.get(j).getServicioSaludID(), idCampana, (s.get(j).getMedicosDisponibles()-1));
									}
									else
									{
										principal.reducirCapacidad(s.get(j).getServicioSaludID(), (k));
										principal.adicionarReservas(s.get(j).getServicioSaludID(), idCampana, k);
										k = 0;
									}
									
									
								}
								
							}
						}
						else 
						{
							throw new Exception("No hay cupo en algun servicio seleccionado");
						}
							
							
					}
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog( this, "No se puede agregar campaña debido a: \n" + e.getMessage() );
					
				}
				finally {
					dispose();
				}

				
			}
		} 
        catch (Exception e) 
        {
        	JOptionPane.showMessageDialog( this, "Ingrese datos numericos para Documento y Registro Medico" );
		}
    }
    
    public void buscarServicios()
    {
    	List<Servicios> serv = new ArrayList<Servicios>();
    	for(String s: panelDatos.getServicios())
    	{
    		serv.addAll(principal.consultarServiciosNombre(s));
    	}
    	panelDatos.setList(serv);
    	
    }
    
    public boolean planB(String nombre, ArrayList<Servicios> s, int cap)
    {
    	int capa = 0;
    	
    	int num = 0;
    	
    	for(int j = 0; j < s.size(); j++)
		{
			if(nombre.equals(s.get(j).getNombre()))
			{
				capa += s.get(j).getMedicosDisponibles();
				num++;
			}
		}
    	
    	if(capa > (cap-num))
    		return true;
    	else 
    		return false;
    	
    }
}
