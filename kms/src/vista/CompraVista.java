package vista;

import control.Caja;
import control.ControladorCompra;
import control.ObservadorEventos;
import control.PuntoDeVenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;

import java.util.*;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import java.util.Locale;
import java.text.NumberFormat;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.metal.MetalLookAndFeel;
import modelo.ModeloTabla;
import modelo.ModeloTablaGenerico;
import utilidades.Utilidades;

/**
 *
 * @author Kymera Systems SAS
 */
public class CompraVista extends VentanaInternaAbs implements ChangeListener, ActionListener, ObservadorEventos, ListSelectionListener {

    int dia, mes, año, cant;
    public String total, cadenaTot, id, subTotal, descTotal, baseGrabable, iva;
    public double tot;
    private String fecha, timestamp;
    public VentanaInternaAbs ventanaInterna;
    public MenuVista menu;
    public FachadaInterfaz fachada;
    public NumberFormat formato = NumberFormat.getCurrencyInstance(Locale.US);
    public ModeloTabla modelo;
    public ModeloTablaGenerico generico;
    public ControladorCompra compra;
    private OrdenVista orden;
    private String[] nomTablaCompra = {"No.ORDEN", "ESTADO", "FECHA PEDIDO", "FECHA ENTREGA", "TOTAL"};
    private String[] nomTablaC = {"Cant", "Codigo", "Descripcion", "Precio Costo", "Total"};
    private static List datos = new ArrayList();
    private PagoOrden p;
    public Map<Integer, Double> imp;
    private final int PROPIEDAD = Caja.COMPRA;

    public CompraVista() {
        initComponents();
        MenuVista.esCompra = true;
        MenuVista.esVenta = false;
        MenuVista.esProducto = false;
        MenuVista.esProd = false;

        this.btnPagarOrden.setVisible(false);
        generico = new ModeloTablaGenerico(this);
        generico.establecerColumNom(nomTablaCompra);

        iniciarTabla();
        tablaCompras.setModel(generico);
        generico.setTamanoColumnaTablaCompra();

        tabla.getSelectionModel().addListSelectionListener(this);
        tablaCompras.getSelectionModel().addListSelectionListener(this);
        this.fachada = FachadaInterfaz.getInstancia();

        iniciarCompra();
        fachada.setNumOrden();
        tbpVenta.addChangeListener(this);
        mitGenerar.addActionListener(this);
        mitBuscarProd.addActionListener(this);
        mitBuscarOrden.addActionListener(this);
        btnGernerarOrden.addActionListener(this);
        btnBuscarProd.addActionListener(this);
        lblFecha.setText(cargarFecha());
        this.setSize(874, 650);

    }

    /**Metodo para Cargar la Fecha Actual**/
    public String cargarFecha() {
        Date date = new Date();
        fecha = Utilidades.datetoString(date);
        return fecha;
    }

    public List cargarDatosDeTabla() {
        String codigo = null, producto = null, valor = null, subtotal = null, cantidad = null;
        List list = new ArrayList();
        for (int i = 0; i < ((ModeloTabla) tabla.getModel()).contFilas; i++) {
            for (int j = 0; j <= 4; j++) {
                cantidad = ((ModeloTabla) tabla.getModel()).getValueAt(i, j).toString();
                codigo = ((ModeloTabla) tabla.getModel()).getValueAt(i, ++j).toString();
                producto = ((ModeloTabla) tabla.getModel()).getValueAt(i, ++j).toString();
                valor = ((ModeloTabla) tabla.getModel()).getValueAt(i, ++j).toString();
                subtotal = ((ModeloTabla) tabla.getModel()).getValueAt(i, ++j).toString();
                list.add(producto);
                list.add(cantidad);
                list.add(valor);
                list.add(subtotal);
            }
        }
        return list;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnBuscarProd)) {
            new BuscarProdVista(menu);
        } else if (e.getSource().equals(mitGenerar)) {
            if (tot != 0) {
                List lst = cargarDatosDeTabla();
                fachada.introducirProveedor(txtProveedor.getText());
                fachada.establecerNoFactProv(txtNoFactura.getText());
                fachada.establecerEstado(cmbEstado.getSelectedItem().toString());
                fachada.establecerFechaEntrega(Utilidades.datetoStringLimpio(dtcFechaEntrega.getDate()));
                fachada.establecerFechaPedido(Utilidades.datetoStringLimpio(new Date()));
                try {
                    UIManager.setLookAndFeel(new MetalLookAndFeel());
                } catch (UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }
                fachada.establecerImpuesto(PROPIEDAD);
                orden = new OrdenVista(MenuVista.getInstancia(), true, this);
                orden.setContenido(lst);

            } else {
                JOptionPane.showMessageDialog(null, "Debe Registrar Productos en la Orden de Pedido");
                txtProveedor.requestFocus(true);
                txtProveedor.selectAll();
            }
        } else if (e.getSource().equals(mitBuscarProd)) {
            new BuscarProdVista(menu);
        } else if (e.getSource().equals(mitBuscarOrden)) {
            new BuscarOrdenVista(menu, this);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbpVenta = new javax.swing.JTabbedPane();
        pnlPedido = new javax.swing.JPanel();
        pnlNorte = new javax.swing.JPanel();
        lblNumPedido = new javax.swing.JLabel();
        lblOrdenCompra = new javax.swing.JLabel();
        lblCaj = new javax.swing.JLabel();
        txtNoFactura = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        lblFec = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        pnlCentro = new javax.swing.JPanel();
        pnlCentroN = new javax.swing.JPanel();
        lblCliente = new javax.swing.JLabel();
        txtProveedor = new javax.swing.JTextField();
        btnBuscarProv = new javax.swing.JButton();
        lblCodProducto = new javax.swing.JLabel();
        txtCodProducto = new javax.swing.JTextField();
        btnBuscarProd = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        lblCantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        lblFec1 = new javax.swing.JLabel();
        dtcFechaEntrega = new com.toedter.calendar.JDateChooser();
        jSeparator3 = new javax.swing.JSeparator();
        lblEstado = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox();
        pnlCentroS = new javax.swing.JPanel();
        pnlTotal = new javax.swing.JPanel();
        lblSubTotal = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JTextField();
        lblIVA = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        lblBase = new javax.swing.JLabel();
        txtBase = new javax.swing.JTextField();
        txtIVA = new javax.swing.JTextField();
        pnlBtnVenta = new javax.swing.JPanel();
        btnPagarOrden = new javax.swing.JButton();
        btnGernerarOrden = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        pnlCentroC = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnEliminarRegistro = new javax.swing.JButton();
        pnlHistorial = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaCompras = new javax.swing.JTable();
        pnlDer = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        dtcDesde = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        dtcHasta = new com.toedter.calendar.JDateChooser();
        btnVerificar = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        cmbBuscEsta = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        btnBuscEstado = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnRecibir = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        mnuArchivo = new javax.swing.JMenu();
        mitGenerar = new javax.swing.JMenuItem();
        mitBuscarOrden = new javax.swing.JMenuItem();
        mitBuscarProd = new javax.swing.JMenuItem();
        mnuAyuda = new javax.swing.JMenu();

        pnlPedido.setLayout(new java.awt.BorderLayout());

        pnlNorte.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        pnlNorte.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 5));

        lblNumPedido.setFont(new java.awt.Font("Tahoma", 1, 14));
        lblNumPedido.setText("Orden de Compra No:");
        pnlNorte.add(lblNumPedido);

        lblOrdenCompra.setFont(new java.awt.Font("Tahoma", 1, 14));
        lblOrdenCompra.setForeground(new java.awt.Color(51, 102, 255));
        lblOrdenCompra.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblOrdenCompra.setPreferredSize(new java.awt.Dimension(45, 20));
        pnlNorte.add(lblOrdenCompra);

        lblCaj.setFont(new java.awt.Font("Tahoma", 1, 14));
        lblCaj.setText("No. Factura Proveedor:");
        pnlNorte.add(lblCaj);

        txtNoFactura.setPreferredSize(new java.awt.Dimension(150, 20));
        txtNoFactura.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                setFocoGanado(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                setFocoPerdido(evt);
            }
        });
        txtNoFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNoFacturaKeyPressed(evt);
            }
        });
        pnlNorte.add(txtNoFactura);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setPreferredSize(new java.awt.Dimension(10, 20));
        pnlNorte.add(jSeparator1);

        lblFec.setFont(new java.awt.Font("Tahoma", 1, 14));
        lblFec.setText("Fecha:");
        pnlNorte.add(lblFec);

        lblFecha.setFont(new java.awt.Font("Tahoma", 1, 14));
        lblFecha.setForeground(new java.awt.Color(51, 102, 255));
        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFecha.setPreferredSize(new java.awt.Dimension(90, 20));
        pnlNorte.add(lblFecha);

        pnlPedido.add(pnlNorte, java.awt.BorderLayout.PAGE_START);

        pnlCentro.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        lblCliente.setFont(new java.awt.Font("Tahoma", 0, 18));
        lblCliente.setText("Proveedor:");
        pnlCentroN.add(lblCliente);

        txtProveedor.setFont(new java.awt.Font("Tahoma", 0, 18));
        txtProveedor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtProveedor.setText("0");
        txtProveedor.setNextFocusableComponent(txtCantidad);
        txtProveedor.setPreferredSize(new java.awt.Dimension(100, 22));
        txtProveedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                setFocoGanado(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                setFocoPerdido(evt);
            }
        });
        txtProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProveedorKeyPressed(evt);
            }
        });
        pnlCentroN.add(txtProveedor);

        btnBuscarProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar1.png"))); // NOI18N
        btnBuscarProv.setToolTipText("Buscar Proveedor");
        btnBuscarProv.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscarProv.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscarProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProvActionPerformed(evt);
            }
        });
        pnlCentroN.add(btnBuscarProv);

        lblCodProducto.setFont(new java.awt.Font("Tahoma", 0, 18));
        lblCodProducto.setText("Código Producto:");
        pnlCentroN.add(lblCodProducto);

        txtCodProducto.setFont(new java.awt.Font("Tahoma", 0, 18));
        txtCodProducto.setNextFocusableComponent(txtCantidad);
        txtCodProducto.setPreferredSize(new java.awt.Dimension(100, 22));
        txtCodProducto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                setFocoGanado(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                setFocoPerdido(evt);
            }
        });
        txtCodProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodProductoKeyPressed(evt);
            }
        });
        pnlCentroN.add(txtCodProducto);

        btnBuscarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar1.png"))); // NOI18N
        btnBuscarProd.setToolTipText("Buscar Producto");
        btnBuscarProd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscarProd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pnlCentroN.add(btnBuscarProd);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setPreferredSize(new java.awt.Dimension(10, 20));
        pnlCentroN.add(jSeparator2);

        lblCantidad.setFont(new java.awt.Font("Tahoma", 0, 18));
        lblCantidad.setText("Cantidad:");
        pnlCentroN.add(lblCantidad);

        txtCantidad.setFont(new java.awt.Font("Tahoma", 0, 18));
        txtCantidad.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCantidad.setText("1");
        txtCantidad.setPreferredSize(new java.awt.Dimension(45, 22));
        txtCantidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                setFocoGanado(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                setFocoPerdido(evt);
            }
        });
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadKeyPressed(evt);
            }
        });
        pnlCentroN.add(txtCantidad);

        jSeparator5.setPreferredSize(new java.awt.Dimension(1000, 8));
        pnlCentroN.add(jSeparator5);

        lblFec1.setFont(new java.awt.Font("Tahoma", 0, 18));
        lblFec1.setText("Fecha De Entrega:");
        pnlCentroN.add(lblFec1);
        pnlCentroN.add(dtcFechaEntrega);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator3.setPreferredSize(new java.awt.Dimension(10, 20));
        pnlCentroN.add(jSeparator3);

        lblEstado.setFont(new java.awt.Font("Tahoma", 0, 18));
        lblEstado.setText("Estado:");
        pnlCentroN.add(lblEstado);

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "En Espera", "Pagado", "Anulado" }));
        pnlCentroN.add(cmbEstado);

        pnlCentroS.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        pnlCentroS.setPreferredSize(new java.awt.Dimension(100, 120));

        pnlTotal.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));

        lblSubTotal.setFont(new java.awt.Font("Verdana", 1, 18));
        lblSubTotal.setText("SUBTOTAL:");

        txtSubTotal.setEditable(false);
        txtSubTotal.setFont(new java.awt.Font("Verdana", 1, 18));
        txtSubTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSubTotal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtSubTotal.setPreferredSize(new java.awt.Dimension(100, 25));

        lblIVA.setFont(new java.awt.Font("Verdana", 1, 18));
        lblIVA.setText("IVA:");

        lblTotal.setFont(new java.awt.Font("Verdana", 1, 18));
        lblTotal.setForeground(new java.awt.Color(51, 102, 255));
        lblTotal.setText("TOTAL COMPRA:");

        txtTotal.setBackground(new java.awt.Color(171, 233, 254));
        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Verdana", 1, 18));
        txtTotal.setForeground(new java.awt.Color(51, 51, 255));
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtTotal.setPreferredSize(new java.awt.Dimension(100, 25));

        lblBase.setFont(new java.awt.Font("Verdana", 1, 18));
        lblBase.setText("BASE GRABABLE:");

        txtBase.setEditable(false);
        txtBase.setFont(new java.awt.Font("Verdana", 1, 18));
        txtBase.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtBase.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtBase.setPreferredSize(new java.awt.Dimension(100, 25));

        txtIVA.setEditable(false);
        txtIVA.setFont(new java.awt.Font("Verdana", 1, 18));
        txtIVA.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtIVA.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtIVA.setPreferredSize(new java.awt.Dimension(100, 25));

        javax.swing.GroupLayout pnlTotalLayout = new javax.swing.GroupLayout(pnlTotal);
        pnlTotal.setLayout(pnlTotalLayout);
        pnlTotalLayout.setHorizontalGroup(
            pnlTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTotalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTotalLayout.createSequentialGroup()
                        .addComponent(lblSubTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                        .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlTotalLayout.createSequentialGroup()
                        .addGroup(pnlTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTotal)
                            .addComponent(lblIVA)
                            .addComponent(lblBase))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addGroup(pnlTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtIVA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(100, 100, 100))
        );
        pnlTotalLayout.setVerticalGroup(
            pnlTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTotalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSubTotal)
                    .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlTotalLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblBase)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIVA))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotal))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        btnPagarOrden.setFont(new java.awt.Font("Tahoma", 0, 18));
        btnPagarOrden.setMnemonic('P');
        btnPagarOrden.setText("Pagar Orden");
        btnPagarOrden.setToolTipText("Pagar Orden");
        btnPagarOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarOrdenActionPerformed(evt);
            }
        });
        pnlBtnVenta.add(btnPagarOrden);

        btnGernerarOrden.setFont(new java.awt.Font("Tahoma", 0, 18));
        btnGernerarOrden.setMnemonic('G');
        btnGernerarOrden.setText("Generar Orden");
        btnGernerarOrden.setToolTipText("Generar Orden");
        btnGernerarOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGernerarOrdenActionPerformed(evt);
            }
        });
        pnlBtnVenta.add(btnGernerarOrden);

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 18));
        btnCancelar.setMnemonic('C');
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pnlBtnVenta.add(btnCancelar);

        javax.swing.GroupLayout pnlCentroSLayout = new javax.swing.GroupLayout(pnlCentroS);
        pnlCentroS.setLayout(pnlCentroSLayout);
        pnlCentroSLayout.setHorizontalGroup(
            pnlCentroSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCentroSLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(pnlBtnVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlCentroSLayout.setVerticalGroup(
            pnlCentroSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCentroSLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(pnlBtnVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addComponent(pnlTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlCentroC.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlCentroC.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 240));

        tabla.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tabla.setFont(new java.awt.Font("Tahoma", 0, 24));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cant", "Codigo", "Descripcion", "Precio Costo", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablaMouseReleased(evt);
            }
        });
        tabla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        pnlCentroC.add(jScrollPane1, java.awt.BorderLayout.PAGE_START);

        btnEliminarRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminarRegistro.png"))); // NOI18N
        btnEliminarRegistro.setToolTipText("Eliminar Registro");
        btnEliminarRegistro.setPreferredSize(new java.awt.Dimension(65, 33));
        btnEliminarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarRegistroActionPerformed(evt);
            }
        });
        pnlCentroC.add(btnEliminarRegistro, java.awt.BorderLayout.LINE_START);

        javax.swing.GroupLayout pnlCentroLayout = new javax.swing.GroupLayout(pnlCentro);
        pnlCentro.setLayout(pnlCentroLayout);
        pnlCentroLayout.setHorizontalGroup(
            pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCentroLayout.createSequentialGroup()
                .addGroup(pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlCentroC, javax.swing.GroupLayout.PREFERRED_SIZE, 843, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlCentroS, javax.swing.GroupLayout.PREFERRED_SIZE, 843, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlCentroN, javax.swing.GroupLayout.PREFERRED_SIZE, 843, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCentroLayout.setVerticalGroup(
            pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCentroLayout.createSequentialGroup()
                .addComponent(pnlCentroN, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCentroC, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCentroS, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlPedido.add(pnlCentro, java.awt.BorderLayout.CENTER);

        tbpVenta.addTab("Orden de Pedido", pnlPedido);

        pnlHistorial.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        pnlHistorial.setLayout(new java.awt.BorderLayout());

        tablaCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No.ORDEN", "ESTADO", "FECHA PEDIDO", "FECHA ENTREGA", "TOTAL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaCompras);

        pnlHistorial.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        pnlDer.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        pnlDer.setPreferredSize(new java.awt.Dimension(275, 534));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BUSCAR PEDIDOS:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setText("DESDE:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setText("HASTA:");

        btnVerificar.setMnemonic('V');
        btnVerificar.setText("Verificar");
        btnVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnVerificar)
                        .addGap(83, 83, 83))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dtcHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                .addComponent(dtcDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtcDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtcHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(btnVerificar)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar Por Estado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        cmbBuscEsta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "En Espera", "Pagado", "Anulado" }));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel3.setText("ESTADO:");

        btnBuscEstado.setText("Buscar");
        btnBuscEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addComponent(cmbBuscEsta, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnBuscEstado)
                        .addGap(84, 84, 84))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbBuscEsta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(btnBuscEstado)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlDerLayout = new javax.swing.GroupLayout(pnlDer);
        pnlDer.setLayout(pnlDerLayout);
        pnlDerLayout.setHorizontalGroup(
            pnlDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlDerLayout.setVerticalGroup(
            pnlDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDerLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        pnlHistorial.add(pnlDer, java.awt.BorderLayout.LINE_END);

        jPanel3.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        btnRecibir.setText("Recibir Orden");
        btnRecibir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecibirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addComponent(btnRecibir)
                .addContainerGap(523, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRecibir)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pnlHistorial.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        tbpVenta.addTab("Historial de Compras", pnlHistorial);

        getContentPane().add(tbpVenta, java.awt.BorderLayout.CENTER);

        mnuArchivo.setMnemonic('A');
        mnuArchivo.setText("Archivo");

        mitGenerar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mitGenerar.setText("Generar Orden");
        mnuArchivo.add(mitGenerar);

        mitBuscarOrden.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        mitBuscarOrden.setText("Buscar Orden de Compraa");
        mnuArchivo.add(mitBuscarOrden);

        mitBuscarProd.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        mitBuscarProd.setText("Buscar Producto");
        mnuArchivo.add(mitBuscarProd);

        menuBar.add(mnuArchivo);

        mnuAyuda.setMnemonic('y');
        mnuAyuda.setText("Ayuda");
        menuBar.add(mnuAyuda);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents
/*Establece un color a la caja de texto que gane foco*/

    public void setFocoGanado(FocusEvent evt) {
        if (evt.getSource().equals(this.txtNoFactura)) {
            txtNoFactura.setBackground(FOCO_GANADO);
        } else if (evt.getSource().equals(this.txtProveedor)) {
            txtProveedor.setBackground(FOCO_GANADO);
            txtProveedor.selectAll();
        } else if (evt.getSource().equals(this.txtCodProducto)) {
            txtCodProducto.setBackground(FOCO_GANADO);
        } else if (evt.getSource().equals(this.txtCantidad)) {
            txtCantidad.setBackground(FOCO_GANADO);
            txtCantidad.selectAll();
        }
    }

    /*Establece un color a la caja de texto que pierda foco*/
    public void setFocoPerdido(FocusEvent evt) {
        if (evt.getSource().equals(this.txtNoFactura)) {
            txtNoFactura.setBackground(FOCO_PERDIDO);
        } else if (evt.getSource().equals(this.txtProveedor)) {
            txtProveedor.setBackground(FOCO_PERDIDO);
        } else if (evt.getSource().equals(this.txtCodProducto)) {
            txtCodProducto.setBackground(FOCO_PERDIDO);
        } else if (evt.getSource().equals(this.txtCantidad)) {
            txtCantidad.setBackground(FOCO_PERDIDO);
        }
    }

    @Override
    /*Metodo para establecer foco a los TextField*/
    public void establecerFoco() {
        this.txtNoFactura.requestFocus(true);
    }

    /*     */
private void tablaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaKeyPressed
    try {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int linea = tabla.getSelectedRow();
            cant = (Integer) (tabla.getValueAt(linea, 0));
            fachada.modificarCantidad(PROPIEDAD, linea, cant);
            this.establecerFoco();
        }
    } catch (NullPointerException np) {
    }
}//GEN-LAST:event_tablaKeyPressed

private void tablaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMousePressed
    try {
        ((modelo.ModeloTabla) tabla.getModel()).tablaSeleccionada = true;
        ((modelo.ModeloTabla) tabla.getModel()).tablaVenta = false;
    } catch (NullPointerException ne) {
    }


}//GEN-LAST:event_tablaMousePressed

private void btnEliminarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarRegistroActionPerformed
    int fil = tabla.getSelectedRow();
    if (fil != -1 && ((modelo.ModeloTabla) tabla.getModel()).getValueAt(fil, tabla.getSelectedColumn()) != "") {
        ((ModeloTabla) tabla.getModel()).tablaSeleccionada = true;
        ((modelo.ModeloTabla) tabla.getModel()).tablaVenta = false;
        ((ModeloTabla) tabla.getModel()).eliminar = true;
        int res = JOptionPane.showConfirmDialog(this,
                "Esta seguro de Eliminar el Registro de La Venta", "Eliminar Registro Venta",
                JOptionPane.YES_NO_CANCEL_OPTION);
        if (res == 0) {
            fachada.eliminarFila(PROPIEDAD, fil);
            fachada.establecerTotal(PROPIEDAD);
            ((ModeloTabla) tabla.getModel()).eliminar = false;
            ((ModeloTabla) tabla.getModel()).tablaSeleccionada = false;
        }
    } else {
        JOptionPane.showMessageDialog(null, "Debe Seleccionar Un Producto");
    }
    tabla.clearSelection();

}//GEN-LAST:event_btnEliminarRegistroActionPerformed

private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
    this.dispose();
    MenuVista.getInstancia().cambiarTextosEImagenTab(0,
            "Escritorio", "Escritorio", MenuVista.getInstancia().imagenes.getImgEscritorio());
    MenuVista.setInternal(0);
}//GEN-LAST:event_btnCancelarActionPerformed

private void btnVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarActionPerformed
    String desde = Utilidades.datetoStringLimpio(dtcDesde.getDate());
    String hasta = Utilidades.datetoStringLimpio(dtcHasta.getDate());
    fachada.buscarDatos(PROPIEDAD, desde, hasta);
}//GEN-LAST:event_btnVerificarActionPerformed

private void tablaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseReleased
    try {
    } catch (NullPointerException pe) {
    }
}//GEN-LAST:event_tablaMouseReleased

private void txtCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        ((ModeloTabla) tabla.getModel()).tablaSeleccionada = false;
        ((ModeloTabla) tabla.getModel()).eliminar = false;
        id = txtCodProducto.getText();
        cant = Integer.parseInt(txtCantidad.getText());
        fachada.introducirArticulo(PROPIEDAD, id, cant);
        txtCodProducto.requestFocus(true);

        txtCodProducto.selectAll();
    }
}//GEN-LAST:event_txtCantidadKeyPressed
    /*
private void setFocoPerdido(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_setFocoPerdido

}//GEN-LAST:event_setFocoPerdido

private void setFocoGanado(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_setFocoGanado
    // TODO add your handling code here:
}//GEN-LAST:event_setFocoGanado
     */
private void txtCodProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodProductoKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        txtProveedor.requestFocus(false);
        txtCantidad.requestFocus(true);
    }
}//GEN-LAST:event_txtCodProductoKeyPressed

private void txtProveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProveedorKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        txtCodProducto.requestFocus(true);
    }
}//GEN-LAST:event_txtProveedorKeyPressed

private void btnGernerarOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGernerarOrdenActionPerformed
    if (tot != 0) {
        List lst = cargarDatosDeTabla();
        fachada.introducirProveedor(txtProveedor.getText());
        fachada.establecerNoFactProv(txtNoFactura.getText());
        fachada.establecerEstado(cmbEstado.getSelectedItem().toString());
        fachada.establecerFechaEntrega(Utilidades.datetoString(dtcFechaEntrega.getDate()));
        fachada.establecerFechaPedido(Utilidades.datetoString(new Date()));
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
            fachada.establecerImpuesto(PROPIEDAD);
            orden = new OrdenVista(MenuVista.getInstancia(), true, this);
            orden.setContenido(lst);
        } catch (Exception e) {
        }
    } else {
        JOptionPane.showMessageDialog(null, "Debe Registrar Productos en la Orden de Pedido");
        txtProveedor.requestFocus(true);
        txtProveedor.selectAll();
    }
}//GEN-LAST:event_btnGernerarOrdenActionPerformed

private void txtNoFacturaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoFacturaKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        txtNoFactura.requestFocus(false);
        txtProveedor.requestFocus(true);
    }
}//GEN-LAST:event_txtNoFacturaKeyPressed

private void btnBuscarProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProvActionPerformed
    new BuscarProvVista(menu);
}//GEN-LAST:event_btnBuscarProvActionPerformed

private void btnRecibirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecibirActionPerformed
    int fil = tablaCompras.getSelectedRow();
    if (fil != -1) {
        iniciarCompra();
        iniciarTabla();
        String idCompra = ((ModeloTablaGenerico) tablaCompras.getModel()).getValueAt(fil, 0).toString();
        fachada.cargarCompra(idCompra);
        habilitarObjetos();
    }
}//GEN-LAST:event_btnRecibirActionPerformed

private void btnBuscEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscEstadoActionPerformed
    String estado = this.cmbBuscEsta.getSelectedItem().toString();
    fachada.buscarComprasXEstado(estado);
}//GEN-LAST:event_btnBuscEstadoActionPerformed

private void btnPagarOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarOrdenActionPerformed
    if (tot != 0) {
        List ls = this.cargarDat();
        if (this.cmbEstado.getSelectedItem() != "Anulado") {
            p = new PagoOrden(menu, this);
        } else {
            this.modificarCompra();
        }
    } else {
        JOptionPane.showMessageDialog(null, "Debe Registrar Productos en la Compra");
        this.txtProveedor.requestFocus(true);
        txtProveedor.selectAll();
    }

}//GEN-LAST:event_btnPagarOrdenActionPerformed
    public void escuchadorEvento(Object obj, String propiedad, Object valor) {
        if (propiedad.equals(PuntoDeVenta.SUBTOTAL_COMPRA)) {
            subTotal = formato.format(Double.parseDouble(valor.toString()));
            txtSubTotal.setText(subTotal);
        } else if (propiedad.equals(PuntoDeVenta.TOTAL_COMPRA)) {
            tot = Double.parseDouble(valor.toString());
            total = formato.format(Double.parseDouble(valor.toString()));
            txtTotal.setText(total);
        } else if (propiedad.equals(PuntoDeVenta.BASE_G_COMPRA)) {
            baseGrabable = formato.format(Double.parseDouble(valor.toString()));
            txtBase.setText(baseGrabable);
        } else if (propiedad.equals(PuntoDeVenta.IVA_COMPRA)) {
            iva = formato.format(Double.parseDouble(valor.toString()));
            txtIVA.setText(iva);
        } else if (propiedad.equals(PuntoDeVenta.NUEVO_PRO_COMPRA)) {
            ModeloTabla modeloTabla = (ModeloTabla) tabla.getModel();
            modeloTabla.ingresarNuevaFila(valor);
            tabla.updateUI();
        } else if (propiedad.equals(PuntoDeVenta.NUM_ORDEN)) {
            lblOrdenCompra.setText(valor.toString());
        } else if (propiedad.equals(PuntoDeVenta.MODIFICAR_CANT_COMPRA)) {
            ArrayList val = (ArrayList) valor;
            tabla.setValueAt(val.get(4), tabla.getSelectedRow(), 4);
            tabla.updateUI();

        } else if (propiedad.equals(PuntoDeVenta.ESTABLECER_CANT_COMPRA)) {
            ArrayList modLinea = (ArrayList) valor;
            tabla.setValueAt(modLinea.get(1), (Integer) modLinea.get(0), 0);
            tabla.setValueAt(formato.format(modLinea.get(2)), (Integer) modLinea.get(0), 4);
            tabla.updateUI();
        } else if (propiedad.equals(PuntoDeVenta.ELIMINAR_LINEA_COMPRA)) {
            ModeloTabla modeloTabla = (ModeloTabla) tabla.getModel();
            modeloTabla.eliminarFila((Integer) valor);
            tabla.updateUI();
        } else if (propiedad.equals(PuntoDeVenta.CARGAR_TABLA_COMPRA)) {
            datos = (List) valor;
            cargarTablaHistorial();
        } else if (propiedad.equals(PuntoDeVenta.ESTABLECER_PROVEEDOR)) {
            String prov = valor.toString();
            this.txtProveedor.setText(prov);
            this.txtCodProducto.requestFocus(true);
        } else if (propiedad.equals(PuntoDeVenta.DATOS_COMPRA)) {
            ArrayList dat = (ArrayList) valor;
            compra.datosCompra.oid = dat.get(0).toString();
            this.lblOrdenCompra.setText(dat.get(0).toString());
            this.cmbEstado.setSelectedItem(dat.get(1).toString());
            this.lblFecha.setText(dat.get(2).toString());
            this.dtcFechaEntrega.setDate(Utilidades.stringtoDate(dat.get(3).toString()));
            this.txtTotal.setText(Utilidades.darFormatoNumero((Number) dat.get(4)));
            this.txtNoFactura.setText(dat.get(5).toString());
            this.txtProveedor.setText(dat.get(6).toString());
            timestamp = dat.get(7).toString();
            compra.datosCompra.setTimestamp(timestamp);
        } else if (propiedad.equals(PuntoDeVenta.DATOS_LINEACOMPRA)) {
            List dat = (List) valor;
            for (int i = 0; i < dat.size(); i++) {
                ArrayList data = (ArrayList) dat.get(i);
                for (int j = 0; j < 2; j++) {
                    cant = Integer.parseInt(data.get(j).toString());
                    id = data.get(++j).toString();
                    fachada.introducirArticulo(PROPIEDAD, id, cant);
                }
            }
            this.tbpVenta.setSelectedIndex(0);
            this.updateUI();
        } else if (propiedad.equals(PuntoDeVenta.IMPUESTOS_COMPRA)) {
            imp = (Map) valor;
        } else if (propiedad.equals(PuntoDeVenta.DATOS_PRV_ENCON)) {
            List data = (List) valor;
            fachada.introducirProveedor(data.get(0).toString());
        } else if (propiedad.equals(PuntoDeVenta.DATOS_PRODUCTO_COMPRA)) {
            List data = (List) valor;
            fachada.introducirArticulo(PROPIEDAD, data.get(0).toString(), 1);
        }
    }

    public void modificarCompra() {
        FachadaInterfaz.getInstancia().modificarCompra(cmbEstado.getSelectedItem().toString());
        dispose();
        MenuVista.setInternal(33);

    }

    public List cargarDatosLienaCompra() {
        String codigo = null, producto = null, valor = null, subtotal = null, cantidad = null;
        List list = new ArrayList();
        for (int i = 0; i < ((ModeloTabla) tabla.getModel()).contFilas; i++) {
            for (int j = 0; j <= 5; j++) {
                cantidad = ((ModeloTabla) tabla.getModel()).getValueAt(i, j).toString();
                codigo = ((ModeloTabla) tabla.getModel()).getValueAt(i, ++j).toString();
                producto = ((ModeloTabla) tabla.getModel()).getValueAt(i, ++j).toString();
                valor = ((ModeloTabla) tabla.getModel()).getValueAt(i, ++j).toString();
                subtotal = ((ModeloTabla) tabla.getModel()).getValueAt(i, ++j).toString();
                list.add(producto);
                list.add(cantidad);
                list.add(valor);
                list.add(subtotal);
            }
        }
        return list;
    }

    public void cargarTablaHistorial() {
        ModeloTablaGenerico generico1 = new ModeloTablaGenerico(datos, this);
        generico1.establecerColumNom(nomTablaCompra);
        tablaCompras.setModel(generico1);
        tablaCompras.updateUI();
        this.updateUI();
    }

    public void valueChanged(ListSelectionEvent e) {
        try {
            int fila = tabla.getSelectedRow();
            if (fila != -1) {
                int ct = (Integer) modelo.getValueAt(fila, 0);
                if (ct != 1) {
                    fachada.modificarCantidad(PROPIEDAD, fila, ct);
                }
            }
        } catch (NullPointerException npe) {
            System.out.println("Excepcion valeChanged VentaVista");
        } catch (java.lang.ClassCastException cce) {
        }
    }

    public void stateChanged(ChangeEvent e) {
        if (tbpVenta.getSelectedIndex() == 1) {
            cargarTablaHistorial();
        }
    }

    public void iniciarTabla() {
        modelo = new ModeloTabla(this);
        modelo.establecerColumNom(nomTablaC);
        tabla.setModel(modelo);
        modelo.setTamanoColumnaCompra();
    }

    private void iniciarCompra() {
        compra = fachada.nuevaCompra();
        fachada.getPtoVenta().removeEscuchadorEventos(this);
        fachada.getPtoVenta().addEscuchadorEventos(this);
    }

    public void habilitarObjetos() {
        this.txtNoFactura.setEditable(false);
        this.txtProveedor.setEditable(false);
        this.btnBuscarProv.setEnabled(false);
        this.btnGernerarOrden.setVisible(false);
        this.btnPagarOrden.setVisible(true);
    }

    public List cargarDat() {
        List lst = cargarDatosDeTabla();
        fachada.introducirProveedor(txtProveedor.getText());
        fachada.establecerNoFactProv(txtNoFactura.getText());
        fachada.establecerEstado(cmbEstado.getSelectedItem().toString());
        fachada.establecerFechaEntrega(Utilidades.datetoStringLimpio(dtcFechaEntrega.getDate()));
        fachada.establecerFechaPedido(Utilidades.datetoStringLimpio(new Date()));
        return lst;
    }

    public void EliminarTodosLosRegistros() {
        for (int i = 0; i < ((ModeloTabla)tabla.getModel()).contFilas; i++) {
            fachada.eliminarTodasFilas(PROPIEDAD);
            fachada.establecerTotal(PROPIEDAD);
            ((ModeloTabla)tabla.getModel()).eliminarTodasFilas();
            ((ModeloTabla) tabla.getModel()).eliminar = false;
            ((ModeloTabla) tabla.getModel()).tablaSeleccionada = false;
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscEstado;
    private javax.swing.JButton btnBuscarProd;
    private javax.swing.JButton btnBuscarProv;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminarRegistro;
    private javax.swing.JButton btnGernerarOrden;
    private javax.swing.JButton btnPagarOrden;
    private javax.swing.JButton btnRecibir;
    private javax.swing.JButton btnVerificar;
    private javax.swing.JComboBox cmbBuscEsta;
    private javax.swing.JComboBox cmbEstado;
    private com.toedter.calendar.JDateChooser dtcDesde;
    private com.toedter.calendar.JDateChooser dtcFechaEntrega;
    private com.toedter.calendar.JDateChooser dtcHasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lblBase;
    private javax.swing.JLabel lblCaj;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblCodProducto;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFec;
    private javax.swing.JLabel lblFec1;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblIVA;
    private javax.swing.JLabel lblNumPedido;
    private javax.swing.JLabel lblOrdenCompra;
    private javax.swing.JLabel lblSubTotal;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem mitBuscarOrden;
    private javax.swing.JMenuItem mitBuscarProd;
    private javax.swing.JMenuItem mitGenerar;
    private javax.swing.JMenu mnuArchivo;
    private javax.swing.JMenu mnuAyuda;
    private javax.swing.JPanel pnlBtnVenta;
    private javax.swing.JPanel pnlCentro;
    private javax.swing.JPanel pnlCentroC;
    private javax.swing.JPanel pnlCentroN;
    private javax.swing.JPanel pnlCentroS;
    private javax.swing.JPanel pnlDer;
    private javax.swing.JPanel pnlHistorial;
    private javax.swing.JPanel pnlNorte;
    private javax.swing.JPanel pnlPedido;
    private javax.swing.JPanel pnlTotal;
    public javax.swing.JTable tabla;
    public javax.swing.JTable tablaCompras;
    private javax.swing.JTabbedPane tbpVenta;
    private javax.swing.JTextField txtBase;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodProducto;
    private javax.swing.JTextField txtIVA;
    private javax.swing.JTextField txtNoFactura;
    private javax.swing.JTextField txtProveedor;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
