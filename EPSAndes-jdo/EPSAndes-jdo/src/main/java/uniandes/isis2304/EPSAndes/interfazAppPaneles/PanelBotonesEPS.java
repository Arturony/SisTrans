package uniandes.isis2304.EPSAndes.interfazAppPaneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class PanelBotonesEPS extends JPanel implements ActionListener
{
	 // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * El comando para crear un disco
     */
    private static final String CREAR_EPS = "CrearEPS";

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
    private DialogoCrearEPS ventana;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------
    private JButton botonAgregarAdmin;

    /**
     * Es el botón que sirve para cerrar el diálogo sin guardar los cambios
     */
    private JButton botonCancelar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel e inicializa sus componentes
     * @param dca es una referencia al dialogo que contiene a este panel
     */
    public PanelBotonesEPS( DialogoCrearEPS dca )
    {

        ventana = dca;

        botonAgregarAdmin = new JButton( "Crear" );
        botonAgregarAdmin.setActionCommand( CREAR_EPS );
        botonAgregarAdmin.addActionListener( this );
        add( botonAgregarAdmin );

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

        if( CREAR_EPS.equals( comando ) )
        {
            ventana.crearEPS( );
        }
        else if( CANCELAR.equals( comando ) )
        {
            ventana.dispose( );
        }

    }
}