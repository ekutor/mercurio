 package vista;

import control.ObservadorEventos;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.*;
import javax.swing.plaf.metal.MetalLookAndFeel;

/**
 *
 * @author Kymera Systems SAS
 */
public class MenuVista extends JFrame implements ChangeListener, ActionListener, ObservadorEventos {

    private Image icono;
    public JTabbedPane tabbedPane;
    private JMenuBar barraMenu;
    private JMenu mnuArchivo, mnuConf, menuReport, menuCaja, menuCompras, menuAdm,mnuRegGen;
    private JMenuItem itmSalir,itmSuper, itmInformacion, itmGenerales, itmDiario,
            itmRecogida, itmCierre, itmPago, itmCompra, itmBase, itmConfigBarra,
            itmConfigCategoria, itmCargo, itmAdm,itmContr, itmUnidad, itmMarca, itmUbicacion;
    private JPanel pnlEstado;
    private JLabel usuario, estado;
    public Imagenes imagenes;
    public static Escritorio esc;
    public static MenuVista INSTANCIA;
    public static boolean esVenta, esProducto, esProveedor, esCliente, esProd,esCompra,esPersonal;
    public static boolean seleccionCero, IniciarSistema;
    public static String razonSocial, Nit, pathLogo, direccion, ciudad, sigla, stockMinimo,prefijo,ultimoTicket,utl_logo;
    public static int tpv;
    public static byte[] logo;
    private FachadaInterfaz fachada;
    private Object[] numProductos = {"Seis", "Nueve", "Doce"};
    private Object opc;
    private int num;
    public static String TIEMP1 = "tmp1";
    public static String TIEMP2 = "tmp2";
    public static String CANT1 = "cant1";
    public static String CANT2 = "cant2";
    public static boolean ACTIVO = false;
    public static boolean IMPRIMIR_TIQUETE = false;

    private MenuVista() {
        super("KMS - KYMERA MANAGER SYSTEM");

        Configuracion.cargarDatosSistema();
        
        imagenes = new Imagenes();
        pnlEstado = new JPanel();
        pnlEstado.setLayout(new BorderLayout());
        pnlEstado.setBorder(new BevelBorder(BevelBorder.LOWERED));
        pnlEstado.add(new JLabel("NUMERO TERMINAL: "+control.PuntoDeVenta.TPV)
                ,BorderLayout.WEST);
         usuario = new JLabel("   Usuario: No Ingresado     ");
        estado = new JLabel("                 Conexion: ");
        estado.setHorizontalTextPosition(JLabel.LEFT);
        setEstado(true);
        pnlEstado.add(usuario, BorderLayout.EAST);
        pnlEstado.add(estado, BorderLayout.CENTER);

        tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
        tabbedPane.setMaximumSize(new Dimension(70,600));
        barraMenu = new JMenuBar();
        mnuArchivo = new JMenu("Sistema");
        mnuArchivo.setMnemonic('S');
        itmSuper = new JMenuItem("Ingresar Usuario");
        itmSuper.setMnemonic('I');
        itmSalir = new JMenuItem("Salir");
        itmSalir.setMnemonic('S');

        mnuConf = new JMenu("Configuracion");
        mnuConf.setMnemonic('C');
        mnuRegGen = new JMenu("Registros Generales");
        mnuRegGen.setMnemonic('G');

        itmInformacion = new JMenuItem("Configurar Informacion del Sistema");
        itmInformacion.setMnemonic('E');
        itmInformacion.setEnabled(false);
        itmConfigBarra = new JMenuItem("Configurar Barra de Productos");
        itmConfigBarra.setMnemonic('B');
        itmConfigBarra.setEnabled(false);
        itmConfigCategoria = new JMenuItem("Administrar Categorias");
        itmConfigCategoria.setEnabled(false);
        itmCargo = new JMenuItem("Administrar Cargos");
        itmCargo.setEnabled(false);
         itmUnidad = new JMenuItem("Administrar Unidades");
//        itmUnidad.setEnabled(true);
        itmMarca = new JMenuItem("Administrar Marcas");
//        itmMarca.setEnabled(false);
        itmUbicacion = new JMenuItem("Administrar Ubicaciones");
//        itmUbicacion.setEnabled(false);
        menuCompras = new JMenu("Compras");
        menuCompras.setMnemonic('C');
        itmCompra = new JMenuItem("Realizar Compra");
        itmCompra.setMnemonic('o');
        itmCompra.setEnabled(false);

        menuAdm = new JMenu("Administracion");
        menuAdm.setMnemonic('M');
        itmGenerales = new JMenuItem("Reportes Generales");
        itmGenerales.setMnemonic('R');
        itmGenerales.setEnabled(false);
        itmAdm = new JMenuItem("Ver Ventas On-Line");
        itmAdm.addActionListener(this);


        menuReport = new JMenu("Reportes");
        menuReport.setMnemonic('R');

        itmDiario = new JMenuItem("Ultimo Cierre de Caja");
        itmDiario.setMnemonic('D');
        itmDiario.setEnabled(false);

        menuCaja = new JMenu("Caja");
        menuCaja.setMnemonic('J');
        itmRecogida = new JMenuItem("Recogida de Caja");
        itmRecogida.setMnemonic('R');

        itmCierre = new JMenuItem("Realizar Cierre de Caja");
        itmCierre.setMnemonic('C');

        itmPago = new JMenuItem("Realizar Pago");
        itmPago.setMnemonic('P');

        itmBase = new JMenuItem("Ingresar Base Inicial de Caja");
        itmBase.setMnemonic('I');
        itmBase.setEnabled(false);

        itmContr = new JMenuItem("Cambiar Contraseña");
        itmContr.setMnemonic('T');


        itmSalir.addActionListener(this);
        itmSuper.addActionListener(this);
        itmCompra.addActionListener(this);
        itmInformacion.addActionListener(this);
        itmConfigBarra.addActionListener(this);
        itmConfigCategoria.addActionListener(this);
        itmCargo.addActionListener(this);
        itmUnidad.addActionListener(this);
        itmMarca.addActionListener(this);
        itmUbicacion.addActionListener(this);
        itmDiario.addActionListener(this);
        itmGenerales.addActionListener(this);
        itmPago.addActionListener(this);
        itmCierre.addActionListener(this);
        itmRecogida.addActionListener(this);
        itmBase.addActionListener(this);
        itmContr.addActionListener(this);

        this.fachada = FachadaInterfaz.getInstancia();
        fachada.ptoVenta.addEscuchadorEventos(this);
        this.habilitarItems(false);


    }

    public static MenuVista getInstancia() {
        if (INSTANCIA == null) {
            INSTANCIA = new MenuVista();
        }
        return INSTANCIA;
    }

    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }

    public void setUsuario(String usuario) {
        this.usuario.setText("   Usuario: " + usuario + "     ");
    }

    public void cargarVista() {
        
        this.addWindowListener(new GlobosEmergentes(this));
        icono = imagenes.getIcono();
        setIconImage(icono);
        tabbedPane.setOpaque(false);
        tabbedPane.setForeground(Color.BLACK);

        mnuArchivo.add(itmSuper);
        mnuArchivo.add(itmContr);
        mnuArchivo.add(new JSeparator());
        mnuArchivo.add(itmSalir);

        mnuRegGen.add(itmConfigCategoria);
        mnuRegGen.add(itmCargo);
        mnuRegGen.add(itmUnidad);
        mnuRegGen.add(itmMarca);
        mnuRegGen.add(itmUbicacion);

        mnuConf.add(itmInformacion);
        mnuConf.add(itmConfigBarra);
        mnuConf.add(new JSeparator());
        mnuConf.add(mnuRegGen);
//        mnuConf.add(itmConfigCategoria);
//        mnuConf.add(itmCargo);

        menuCompras.add(itmCompra);


        menuReport.add(itmDiario);
        menuCaja.add(itmRecogida);
        menuCaja.add(itmPago);
        menuCaja.add(itmCierre);
        menuCaja.add(itmBase);

        menuAdm.add(itmAdm);
        menuAdm.add(itmGenerales);

        barraMenu.add(mnuArchivo);
        barraMenu.add(menuCompras);
        barraMenu.add(mnuConf);
        barraMenu.add(menuCaja);
        barraMenu.add(menuReport);
        barraMenu.add(menuAdm);


        setJMenuBar(barraMenu);

        llenarTabbed();
        cambiarEstadoTab(2, false);
        this.getContentPane().add(tabbedPane);
        this.getContentPane().add(pnlEstado, BorderLayout.SOUTH);
        pack();
        tabbedPane.updateUI();
        tabbedPane.addChangeListener(this);
        //setResizable(false);

        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLocationRelativeTo(null);

        //com.sun.awt.AWTUtilities.setWindowOpacity(this, 0.95f);
        esc = (Escritorio) tabbedPane.getSelectedComponent();
        this.habilitarTabbed(false);
        MenuVista.getInstancia().cambiarEstadoTab(0, true);
        MenuVista.getInstancia().cambiarEstadoTab(1, true);
        dimension();
       
    }

    public void cambiarEstadoTab(int index, boolean estado) {
        tabbedPane.setEnabledAt(index, estado);
    }

    public void cambiarTextosEImagenTab(int index, String titulo, String toolTip, ImageIcon icono) {
        tabbedPane.setIconAt(index, icono);
        tabbedPane.setTitleAt(index, titulo);
        tabbedPane.setToolTipTextAt(index, toolTip);
    }

    public void llenarTabbed() {
        tabbedPane.addTab("Escritorio", imagenes.getImgEscritorio(),
                new Escritorio(), "Escritorio");
        tabbedPane.addTab("Caja", imagenes.getImgCaja(),
                new Escritorio(), "Caja");
        tabbedPane.addTab("Venta", imagenes.getImgVenta(),
                new Escritorio(), "Venta");
        tabbedPane.addTab("Descuentos", imagenes.getImgDescuento(),
                new Escritorio(), "Descuentos");
        tabbedPane.addTab("Productos", imagenes.getImgProductos(),
                new Escritorio(), "Productos");
        tabbedPane.addTab("Proveedor", imagenes.getImgProovedores(),
                new Escritorio(), "Proveedor");
        tabbedPane.addTab("Personal", imagenes.getImgEmpleado(),
                new Escritorio(), "Personal");
        tabbedPane.addTab("Clientes", imagenes.getImgClientes(),
                new Escritorio(), "Clientes");
        tabbedPane.addTab("Seguridad", imagenes.getImgSeguridad(),
                new Escritorio(), "Seguridad");

    }

    public void stateChanged(ChangeEvent e) {
        esc = (Escritorio) tabbedPane.getSelectedComponent();
        if (tabbedPane.getSelectedIndex() == -1) {
            tabbedPane.setSelectedIndex(0);
        }
        esc.cargarInternal(tabbedPane.getSelectedIndex());
    }

    public static void setInternal(int numVentana) {
        esc.cargarInternal(numVentana);
        esc.updateUI();
    }

    public JFrame getFrame() {
        return getInstancia();
    }
    /**
     * metodo escuchador para la barra de Herramientas
     * Recibe el objeto que genera el evento
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(itmSalir)) {
            int res = JOptionPane.showConfirmDialog(null, "Realmente Desea Salir del Sistema?",
                    "Salida Segura",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(res == 0){
                System.exit(0);
            }
        } else if (e.getSource().equals(itmSuper)) {
           new VentanaInicio(false);

        } else if (e.getSource().equals(itmGenerales)) {
            new ReporteVista(this).setVisible(true);

        } else if (e.getSource().equals(itmDiario)) {
            IniciarSistema = false;
            fachada.mostrarUltCierre();

        } else if (e.getSource().equals(itmInformacion)) {
            new Configuracion(this, true);
            
        } else if (e.getSource().equals(itmRecogida)) {

            new Recogidas().setVisible(true);
        } else if (e.getSource().equals(itmCierre)) {
            new CierresCaja(this,true);
        } else if (e.getSource().equals(itmPago)) {
            new Autorizacion(this, true, "P");
        } else if (e.getSource().equals(itmBase)) {
            new SaldoBase(this, true);
        } else if (e.getSource().equals(itmCompra)) {
            esc.cargarInternal(33);
        } else if (e.getSource().equals(itmConfigBarra)) {
            opc = JOptionPane.showInputDialog(this, "Seleccione el Numero de Productos que desea Cargar!!!",
                    "Seleccion Productos Principales", JOptionPane.QUESTION_MESSAGE, null, numProductos, numProductos[0]);
            if (opc == numProductos[0]) {
                num = 6;
            } else if (opc == numProductos[1]) {
                num = 9;
            } else if (opc == numProductos[2]) {
                num = 12;
            } else {
                num = 0;
            }
            if (num != 0) {
                new SelectProduct(this, true, num);
            }
        } else if (e.getSource().equals(itmConfigCategoria)) {
            fachada.cargarCategoria();
        } else if (e.getSource().equals(itmCargo)) {
            fachada.cargarCargos();
        } else if (e.getSource().equals(itmAdm)) {
            new Administracion(this, true);
        } else if(e.getSource().equals(itmContr)){
            esc.cargarInternal(8);
        }else if (e.getSource().equals(itmUnidad)) {
            fachada.cargarUnidades();
        } else if (e.getSource().equals(itmMarca)) {
            fachada.cargarMarcas();
        } else if (e.getSource().equals(itmUbicacion)) {
            fachada.cargarUbicaciones();
        }
    }

    public void dimension() {
        Toolkit tk = getToolkit();
        Dimension dimension = tk.getScreenSize();
        setSize(dimension.width - 20, dimension.height - 30);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    public void iniciarSistema() {
        this.habilitarItems(false);
        this.itmCompra.setEnabled(false);
        this.habilitarTabbed(false);
        MenuVista.getInstancia().cambiarEstadoTab(1, true);
        setInternal(0);
        this.tabbedPane.setSelectedIndex(0);
        if(control.PuntoDeVenta.usuarioActual!=null){
            this.escuchadorEvento(null, control.PuntoDeVenta.PERMISOS, control.PuntoDeVenta.usuarioActual.getPermisos());
        }
    }

    private void habilitarItems(boolean b) {
        itmRecogida.setEnabled(b);
        itmCierre.setEnabled(b);
        itmPago.setEnabled(b);
    }

    public void habilitarTabbed(boolean b) {
        for (int i = 1; i <= 8; i++) {
            MenuVista.getInstancia().cambiarEstadoTab(i, b);
        }
    }

    public void escuchadorEvento(Object obj, String propiedad, Object valor) {

        if (propiedad.equals(control.PuntoDeVenta.PERMISOS)) {
            int permisos = (Integer) valor;
            String user = control.PuntoDeVenta.usuarioActual.getEmpleado();
            setUsuario(user);
            switch (permisos) {
                case control.PuntoDeVenta.ADMINISTRADOR: {
                    this.habilitarTabbed(true);
                    itmGenerales.setEnabled(true);
                    this.itmInformacion.setEnabled(true);
                    itmConfigCategoria.setEnabled(true);
                    itmCargo.setEnabled(true);
                    itmDiario.setEnabled(true);
                    itmConfigBarra.setEnabled(true);
                    itmAdm.setEnabled(true);
                    itmGenerales.setEnabled(true);
                    mnuRegGen.setEnabled(true);
//                    MenuVista.getInstancia().cambiarEstadoTab(1, false);
//                    MenuVista.getInstancia().cambiarEstadoTab(2, false);
                    break;
                }
                case control.PuntoDeVenta.CAJERO: {
                    this.habilitarTabbed(false);
                    MenuVista.getInstancia().cambiarEstadoTab(0, true);
                    MenuVista.getInstancia().cambiarEstadoTab(2, true);
                    MenuVista.getInstancia().cambiarEstadoTab(3, true);
                    MenuVista.getInstancia().cambiarEstadoTab(5, true);
                    MenuVista.getInstancia().cambiarEstadoTab(7, true);

                    itmInformacion.setEnabled(false);
                    itmConfigCategoria.setEnabled(false);
                    itmCargo.setEnabled(false);
                    itmDiario.setEnabled(false);
                    itmConfigBarra.setEnabled(true);
                    itmAdm.setEnabled(false);
                    itmGenerales.setEnabled(false);
                    mnuRegGen.setEnabled(false);
                    if(!fachada.validarCierre()){
                     fachada.iniciarCaja();
                    }
                    break;
                }
                case control.PuntoDeVenta.SUPERVISOR: {
                    this.habilitarTabbed(true);
                    itmInformacion.setEnabled(false);
                    itmConfigCategoria.setEnabled(false);
                    itmCargo.setEnabled(false);
                    itmDiario.setEnabled(true);
                    itmConfigBarra.setEnabled(true);
                    itmAdm.setEnabled(false);
                    itmGenerales.setEnabled(false);
                    mnuRegGen.setEnabled(true);
                    MenuVista.getInstancia().cambiarEstadoTab(6, false);
                    MenuVista.getInstancia().cambiarEstadoTab(8, false);
                    break;
                }
                case control.PuntoDeVenta.TECNICO: {
                    this.habilitarTabbed(true);
                    itmInformacion.setEnabled(false);
                    itmConfigCategoria.setEnabled(false);
                    itmCargo.setEnabled(false);
                    itmDiario.setEnabled(true);
                    itmConfigBarra.setEnabled(true);
                    itmAdm.setEnabled(false);
                    itmGenerales.setEnabled(false);
                    mnuRegGen.setEnabled(false);
                }
                break;
            }
             JOptionPane.showMessageDialog(null, "El Usuario: " + user + " Ingreso al Sistema");
             setInternal(0);
        } else if (propiedad.equals(control.PuntoDeVenta.ESTABLECER_BASE)) {
            this.itmCompra.setEnabled(true);
            if ((Boolean) valor) {
                this.itmBase.setEnabled(true);
                this.habilitarItems(false);
            } else {
                this.itmBase.setEnabled(false);
                this.habilitarItems(true);
            }
        } else if (propiedad.equals(control.PuntoDeVenta.LANZAR_MENSAJE)) {
            JOptionPane.showMessageDialog(this, valor, "Informacion del Sistema", JOptionPane.INFORMATION_MESSAGE);

        } else if (propiedad.equals(control.PuntoDeVenta.CIERRE_CAJA)) {
            verCierre((List) valor);
            if (MenuVista.IniciarSistema) {
                control.PuntoDeVenta.usuarioActual = null;
                this.iniciarSistema();
            }


        } else if (propiedad.equals(control.PuntoDeVenta.CAJA_ABIERTA)) {

            List datos = (List) valor;
            JOptionPane.showMessageDialog(null, "El Cajero " + datos.get(1) + " No ha realizado el cierre de Caja" +
                    "\n desde el dia " + datos.get(2) + " a las " + datos.get(4) + " \n con un saldo final de $" + datos.get(7));
            cambiarEstadoTab(1, false);
            cambiarEstadoTab(2, true);


        } else if (propiedad.equals(control.PuntoDeVenta.CARGAR_CATEGORIA)) {
            List datos = (List) valor;
            TablaCategoria tbCategoria = new TablaCategoria(datos);
            TablaCategoria.esCategoria = true;
            TablaCategoria.esCargo = false;
        } else if (propiedad.equals(control.PuntoDeVenta.CARGAR_CARGOS)) {
            List datos = (List) valor;
            TablaCategoria tbCategoria = new TablaCategoria(datos);
            TablaCategoria.esCargo = true;
            TablaCategoria.esCategoria = false;
        } else if (propiedad.equals(control.PuntoDeVenta.ACTUALIZAR_TABLA)) {
            List datos = (List) valor;
            TablaCategoria.cargarTabla(datos);
        } else if (propiedad.equals(control.PuntoDeVenta.ONLINE)) {
            setEstado((Boolean) valor);
        }else if (propiedad.equals(control.PuntoDeVenta.CARGAR_UNIDADES)) {
            List datos = (List) valor;
            TablaCategoria tbCategoria = new TablaCategoria(datos);
            TablaCategoria.esUnidad(true);
        } else if (propiedad.equals(control.PuntoDeVenta.CARGAR_MARCAS)) {
            List datos = (List) valor;
            TablaCategoria tbCategoria = new TablaCategoria(datos);
            TablaCategoria.esMarca(true);
        } else if (propiedad.equals(control.PuntoDeVenta.CARGAR_UBICACION)) {
            List datos = (List) valor;
            TablaCategoria tbCategoria = new TablaCategoria(datos);
            TablaCategoria.esUbicacion(true);
        }
    }

    private void verCierre(List datos) {
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
            new CierreCaja(this, true, (List) datos.get(0), (List) datos.get(1), (List) datos.get(2), (Double) datos.get(3));
        } catch (UnsupportedLookAndFeelException ex) {
        }
    }
     private void setEstado(boolean b) {
        estado.setIcon(imagenes.getImgEstado(b));
        estado.updateUI();
    }
}
