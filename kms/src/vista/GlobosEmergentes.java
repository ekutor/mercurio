package vista;

import control.ObservadorEventos;

import control.RegistrosGenerales;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import utilidades.Utilidades;

/**
 *
 * @author KYMERA SYSTEMS
 */
public class GlobosEmergentes implements WindowListener, ActionListener, ObservadorEventos, Runnable {

    public FachadaInterfaz fachada;
    private MenuVista vista;
    private TrayIcon iconoTray;
    private PopupMenu menu;
    private MenuItem restaurar;
    private MenuItem salir;
    public static Thread hilo;

    public GlobosEmergentes(MenuVista vista) {
        this.vista = vista;

        fachada = FachadaInterfaz.getInstancia();
        //fachada.rgenerales.addEscuchadorEventos(this);
        fachada.getPtoVenta().addEscuchadorEventos(this);
        if (!SystemTray.isSupported()) {
            System.out.println("SYSTEM TRAY NO SOPORTADO!!!");
            return;
        } else {
            menu = new PopupMenu();
            restaurar = new MenuItem("Restaurar");
            restaurar.addActionListener(this);
            salir = new MenuItem("Salir");
            salir.addActionListener(this);
            menu.add(salir);
            menu.add(restaurar);
            iconoTray = new TrayIcon(new Imagenes().getImgTrayIcon().getImage(), "Kymera Manager System", menu);
            iconoTray.setImageAutoSize(true);
            iconoTray.addActionListener(this);
            try {
                SystemTray.getSystemTray().add(iconoTray);

            } catch (Exception e) {
                Logger.getLogger(GlobosEmergentes.class.getName()).log(Level.SEVERE, null, e);
            }
        }

    }

    public void windowOpened(WindowEvent arg0) {

        iconoTray.displayMessage("KMS", "Verificando El Stock de Productos", TrayIcon.MessageType.INFO);
        //fachada.validarCierre();
        hilo = new Thread(this);
        hilo.start();

    }

    public void windowClosing(WindowEvent arg0) {
        vista.getFrame().setVisible(false);
        iconoTray.displayMessage("KMS", "Kymera Manager System se esta ejecutando", TrayIcon.MessageType.INFO);
    }

    public void windowClosed(WindowEvent arg0) {
    }

    public void windowIconified(WindowEvent arg0) {

        iconoTray.displayMessage("KMS", "Kymera Manager System se esta ejecutando", TrayIcon.MessageType.INFO);
        vista.getFrame().setVisible(false);
    }

    public void windowDeiconified(WindowEvent arg0) {
    }

    public void windowActivated(WindowEvent arg0) {
    }

    public void windowDeactivated(WindowEvent arg0) {
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(iconoTray)) {
            vista.getFrame().setVisible(true);
            vista.toFront();
            vista.getFrame().setExtendedState(JFrame.MAXIMIZED_BOTH);
            //vista.dimension();

            vista.getFrame().toFront();
        } else if (e.getSource().equals(salir)) {
            System.exit(0);
        } else if (e.getSource().equals(restaurar)) {
            vista.getFrame().setExtendedState(JFrame.MAXIMIZED_BOTH);
            vista.dimension();
            vista.getFrame().setVisible(true);
            vista.getFrame().toFront();
        }
    }

    public void escuchadorEvento(Object obj, String propiedad, Object valor) {
        List vl;
        if (propiedad.equals(RegistrosGenerales.STOCK_MINIMO)) {
            vl = (List) valor;
            AvisoStock aviso = new AvisoStock(vl, "           Con Un Stock Minimo", "src/imagenes/vb.gif");
            aviso.getjButton2().setName("stock");

        } else 
            if (propiedad.equals(RegistrosGenerales.FECHA_VENCIMIENTO)) {
            vl = (List) valor;
            AvisoStock aviso = new AvisoStock(vl, "En Su Fecha Limite De Vencimiento", "src/imagenes/admiracion.gif");
            aviso.getjButton2().setName("vencimiento");
        }
    }

    public void run() {
        while (true) {
            if (MenuVista.ACTIVO) {
                try {
                    fachada.stockMinimo(Integer.parseInt(MenuVista.stockMinimo));
                    Thread.sleep(Configuracion.tiempoMensajes(MenuVista.TIEMP2, MenuVista.CANT2));
                    String fecha = Utilidades.datetoString(new Date());
                    fachada.fechaVencimiento(fecha);
                    Thread.sleep(Configuracion.tiempoMensajes(MenuVista.TIEMP1, MenuVista.CANT1));
                } catch (InterruptedException ex) {
                    Logger.getLogger(GlobosEmergentes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{

            }

        }
    }
}
