package vista;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 *
 * @author Kymera Systems SAS
 */
public class Imagenes {

    private ImageIcon imgDesktop, imgEmpleado, imgClientes, imgSeguridad, imgPedidos,
            imgVenta, imgProductos, imgCaja, imgProovedores, imgDescuento, imgEscritorio,
            imgTrayIcon, imEstrellaIn, imEstrellaOut;

    public ImageIcon getImgPedidos() {
        try {
            imgPedidos = new ImageIcon(getClass().getResource("/imagenes/pedidos.png"));
        } catch (Exception e) {
            e.printStackTrace();
            imgPedidos = null;
        }
        return escalarIcono(imgPedidos);
    }

    public ImageIcon getImgEscritorio() {
        try {
            imgEscritorio = new ImageIcon(getClass().getResource("/imagenes/escritorioIcono.png"));
        } catch (Exception e) {
            e.printStackTrace();
            imgEscritorio = null;
        }
        return escalarIcono(imgEscritorio);
    }

    public ImageIcon getImgDescuento() {
        try {
            imgDescuento = new ImageIcon(getClass().getResource("/imagenes/descuento1.png"));

        } catch (Exception e) {
            e.printStackTrace();
            imgDescuento = null;
        }
        return escalarIcono(imgDescuento);
    }

    public ImageIcon getImgProovedores() {
        try {
            imgProovedores = new ImageIcon(getClass().getResource("/imagenes/proovedores.png"));
        } catch (Exception e) {
            e.printStackTrace();
            imgProovedores = null;
        }
        return escalarIcono(imgProovedores);
    }

    public ImageIcon getImgCaja() {
        try {
            imgCaja = new ImageIcon(getClass().getResource("/imagenes/caja.png"));
        } catch (Exception e) {
            e.printStackTrace();
            imgCaja = null;
        }
        return escalarIcono(imgCaja);
    }

    public ImageIcon getImgProductos() {
        try {
            imgProductos = new ImageIcon(getClass().getResource("/imagenes/productos.png"));
        } catch (Exception e) {
            e.printStackTrace();
            imgProductos = null;
        }
        return escalarIcono(imgProductos);
    }

    public ImageIcon getImgVenta() {
        try {
            imgVenta = new ImageIcon(getClass().getResource("/imagenes/venta.png"));
        } catch (Exception e) {
            e.printStackTrace();
            imgVenta = null;
        }
        return escalarIcono(imgVenta);
    }

    public ImageIcon getImgSeguridad() {
        try {
            imgSeguridad = new ImageIcon(getClass().getResource("/imagenes/seguridad.png"));
        } catch (Exception e) {
            e.printStackTrace();
            imgSeguridad = null;
        }
        return escalarIcono(imgSeguridad);
    }

    public ImageIcon getImgClientes() {
        try {
            imgClientes = new ImageIcon(getClass().getResource("/imagenes/cliente.png"));
        } catch (Exception e) {
            e.printStackTrace();
            imgClientes = null;
        }
        return escalarIcono(imgClientes);
    }

    public ImageIcon getImgEmpleado() {
        try {
            imgEmpleado = new ImageIcon(getClass().getResource("/imagenes/empleado.png"));
        } catch (Exception e) {
            e.printStackTrace();
            imgEmpleado = null;
        }
        return escalarIcono(imgEmpleado);
    }

    public ImageIcon getImgEstrellaIn() {
        try {
            imEstrellaIn = new ImageIcon(getClass().getResource("/imagenes/estrella.png"));
        } catch (Exception e) {
            e.printStackTrace();
            imEstrellaIn = null;
        }
        return imEstrellaIn;

    }

    public ImageIcon getImgEstrellaOut() {
        try {
            imEstrellaOut = new ImageIcon(getClass().getResource("/imagenes/estrellaOut.png"));
        } catch (Exception e) {
            e.printStackTrace();
            imEstrellaOut = null;
        }
        return imEstrellaOut;

    }

    public ImageIcon getImgEstado(boolean b) {
        String nImg;
        if (b) {
            nImg = "onLine.gif";
        } else {
            nImg = "offLine.gif";
        }
        try {
            imgEmpleado = new ImageIcon(getClass().getResource("/imagenes/" + nImg));

        } catch (Exception e) {
            e.printStackTrace();
            imgEmpleado = null;
        }
        return imgEmpleado;
    }

    public ImageIcon getImgDesktop() {
        try {
            imgDesktop = new ImageIcon(getClass().getResource("/imagenes/F.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
            imgDesktop = null;
        }
        return imgDesktop;
    }

    public ImageIcon getImgTrayIcon() {
        try {
            imgTrayIcon = new ImageIcon(getClass().getResource("/imagenes/logo100.png"));
            imgTrayIcon = this.escalarIcono(imgTrayIcon, 30);
        } catch (Exception e) {
            e.printStackTrace();
            imgTrayIcon = null;
        }
        return imgTrayIcon;
    }

    public Image getIcono() {
        return Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/logo100.png"));
    }

    private ImageIcon escalarIcono(ImageIcon icono) {
        ImageIcon img = new ImageIcon(icono.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        return img;
    }

    private ImageIcon escalarIcono(ImageIcon icono, int size) {
        ImageIcon img = new ImageIcon(icono.getImage().getScaledInstance(size, size, Image.SCALE_DEFAULT));
        return img;
    }
}
