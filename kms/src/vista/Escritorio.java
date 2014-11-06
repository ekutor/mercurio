package vista;

/**
 *
 * @author Kymera Systems SAS
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class Escritorio extends JDesktopPane implements ActionListener {

    public VentanaInternaAbs ventanaInterna, barra;
    private Imagenes imagenes;
    public int val = 0;
    public int ancho;
    private JPopupMenu ppMenu;
    private JCheckBoxMenuItem cbiOcultar;
    public JMenuItem mnuSalir;

    public Escritorio() {
        super();
        ppMenu = new JPopupMenu();
        mnuSalir = new JMenuItem("Salir");
        cbiOcultar = new JCheckBoxMenuItem("Ver Barra de Opciones");
        cbiOcultar.addActionListener(this);
        cbiOcultar.setSelected(true);

        ppMenu.add(cbiOcultar);
        ppMenu.add(new JSeparator());
        ppMenu.add(mnuSalir);
        imagenes = new Imagenes();
        ventanaInterna = null;
        barra = null;
        //this.addMouseListener(mouseListener);
    }

    public JPopupMenu getPpMenu() {
        return ppMenu;
    }

    public void setPpMenu(JPopupMenu ppMenu) {
        this.ppMenu = ppMenu;
    }
    MouseListener mouseListener = new MouseAdapter() {

        private void showIfPopupTrigger(MouseEvent mouseEvent) {
            if (mouseEvent.isPopupTrigger()) {
                getPpMenu().show(mouseEvent.getComponent(),
                        mouseEvent.getX(),
                        mouseEvent.getY());
            }
        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            showIfPopupTrigger(mouseEvent);
        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {
            showIfPopupTrigger(mouseEvent);
        }
    };

    /**
     * Metodo que carga las vistas internas al seleccionar una pestaña del
     * TabbedPane
     * Recibe un entero con el indice del Tab seleccionado
     * @param indexTabbed
     */
    public void cargarInternal(int indexTabbed) {
        this.removeAll();
        if (indexTabbed == 0) {
            if (MenuVista.seleccionCero) {
                ventanaInterna = new CompraVista();
                MenuVista.seleccionCero = false;
            } else {
                ventanaInterna = null;
            }
        } else if (indexTabbed == 1) {
            ventanaInterna = new IniciarCaja();
        } else if (indexTabbed == 2) {
            ventanaInterna = new VentaVista();
            if (barra != null) {
                barra = new MenuProdPrincipales((VentaVista) ventanaInterna);
                this.cargarBarra();
            }
        } else if (indexTabbed == 3) {
            ventanaInterna = new DescuentoVista();
        } else if (indexTabbed == 4) {
            ventanaInterna = new ProductoVista();
        } else if (indexTabbed == 5) {
            ventanaInterna = new ProveedorVista();
        } else if (indexTabbed == 6) {
            ventanaInterna = new IngresoPersonal();
        } else if (indexTabbed == 7) {
            ventanaInterna = new ClienteVista();
        } else if (indexTabbed == 8) {
            ventanaInterna = new Usuarios();
        } else if (indexTabbed == 30) {
            barra = new MenuProdPrincipales((VentaVista) ventanaInterna);
            if (!MenuProdPrincipales.exito) {
                int num;
                Object opc;
                JOptionPane.showMessageDialog(null, "Debe Configurar El Menu En la Barra Principal - Configuracion!!!");
                opc = JOptionPane.showInputDialog(this, "Seleccione el Numero de Productos que desea Cargar!!!",
                        "Seleccion Productos Principales", JOptionPane.QUESTION_MESSAGE, null, 
                        MenuProdPrincipales.numProductos, MenuProdPrincipales.numProductos[0]);
                if (opc == MenuProdPrincipales.numProductos[0]) {
                    num = 6;
                } else if (opc == MenuProdPrincipales.numProductos[1]) {
                    num = 9;
                } else if (opc == MenuProdPrincipales.numProductos[2]) {
                    num = 12;
                } else {
                    num = 0;
                }
                if (num != 0) {
                    new SelectProduct(MenuVista.getInstancia(), true, num);
                }
                barra = new MenuProdPrincipales((VentaVista) ventanaInterna);
            }
            if ((800 + barra.getWidth() > MenuVista.esc.ancho)) {
                barra = new MenuProSeis((VentaVista) ventanaInterna);
            }
            if (barra != null) {
                cargarBarra();
            }
        } else if (indexTabbed == 33) {
            MenuVista.seleccionCero = true;
            if (MenuVista.getInstancia().tabbedPane.getSelectedIndex() == 0) {
                ventanaInterna = new CompraVista();
                MenuVista.seleccionCero = false;
            } else {
                MenuVista.getInstancia().tabbedPane.setSelectedIndex(0);
            }
            MenuVista.getInstancia().cambiarTextosEImagenTab(0,
                    "Pedidos", "Pedidos", MenuVista.getInstancia().imagenes.getImgPedidos());
        }
        if (ventanaInterna != null) {
            //Si la ventana no esta nula, adiciona la ventana interna al JDesktopPane
            this.add(ventanaInterna, JDesktopPane.DRAG_LAYER);
            ventanaInterna.esVisible();
            ventanaInterna.establecerFoco();
            if (MenuVista.getInstancia().tabbedPane.getSelectedIndex() != 0) {
                MenuVista.getInstancia().cambiarTextosEImagenTab(0,
                        "Escritorio", "Escritorio", MenuVista.getInstancia().imagenes.getImgEscritorio());
            }
        }
    }

    public void cargarBarra() {
        this.add(barra, JDesktopPane.DRAG_LAYER);
        barra.esVisible();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon img;
        /*int h = (int) imagenes.getImgDesktop().getImage().getHeight(null) / 2;
        int w = (int) (imagenes.getImgDesktop().getImage().getWidth(null) / 2);*/
        int h = (int) imagenes.getImgDesktop().getImage().getHeight(null);
        int w = (int) (imagenes.getImgDesktop().getImage().getWidth(null));
        img = new ImageIcon(imagenes.getImgDesktop().getImage().getScaledInstance(this.getWidth(),
                this.getHeight(), Image.SCALE_DEFAULT));
        ancho = this.getWidth();
        /*g.drawImage(img.getImage(), (int) getWidth() / 2 - w,
        (int) getHeight() / 2 - h, null);*/
        g.drawImage(img.getImage(), 0, 0, null);
    }

    public void actionPerformed(ActionEvent e) {
        if (!this.cbiOcultar.isSelected()) {
            MenuVista.getInstancia().getContentPane().remove(MenuVista.getInstancia().tabbedPane);
        }
    }
}
