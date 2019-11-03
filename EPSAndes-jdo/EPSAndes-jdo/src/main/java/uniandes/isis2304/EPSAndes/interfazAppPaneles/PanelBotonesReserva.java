package uniandes.isis2304.EPSAndes.interfazAppPaneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class PanelBotonesReserva extends JPanel implements ActionListener
{
	 // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * El comando para crear un disco
     */
    private static final String RESERVAR = "Reservar";

    /**
     * El comando para cancelar la creación de un disco
     */
    private static final String CANCELAR = "Cancelar";
    


    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia al dialogo al que pertenece este panel
     */
    private DialogoCrearReserva ventana;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------
    private JButton botonAgregarCita;

    /**
     * Es el botón que sirve para cerrar el diálogo sin guardar los cambios
     */
    private JButton botonCancelar;
    

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel e inicializa sus componentes
     * @param dcc es una referencia al dialogo que contiene a este panel
     */
    public PanelBotonesReserva( DialogoCrearReserva dcc )
    {

        ventana = dcc;

        botonAgregarCita = new JButton( "Deshabilitar" );
        botonAgregarCita.setActionCommand( RESERVAR );
        botonAgregarCita.addActionListener( this );
        add( botonAgregarCita );

        botonCancelar = new JButton( "Cancelar" );
        botonCancelar.setActionCommand( CANCELAR );
        botonCancelar.addActionListener( this );
        add( botonCancelar );
        

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Ejecuta las acciones asociadas a los eventos
     * @param evento es el evento del click sobre un botón
     */
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );

        if( RESERVAR.equals( comando ) )
        {
            ventana.crearReserva( );
        }
        else if( CANCELAR.equals( comando ) )
        {
            ventana.dispose( );
        }

    }
}
