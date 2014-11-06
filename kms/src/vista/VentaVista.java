package vista;

import control.Caja;
import control.ObservadorEventos;
import control.ControladorVenta;
import control.PuntoDeVenta;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;

import java.util.*;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionListener;
import modelo.ModeloTabla;
import modelo.ModeloTablaGenerico;
import utilidades.Utilidades;

/**
 *
 * @author Kymera Systems SAS
 */
public class VentaVista extends VentanaInternaAbs implements ChangeListener, ActionListener, 
        ObservadorEventos, ListSelectionListener {

    public int dia, mes, año, cant, cantTabla, num;
    public String total, cadenaTot, id, subTotal, descTotal, baseGrabable, iva, cliente,
            tiquete;
    public Map<Integer, Double> imp;
    public double tot,subT;
    private String fecha;
    public VentanaInternaAbs ventanaInterna;
    public MenuVista menu;
    public FachadaInterfaz fachada;
    public ModeloTabla modelo;
    public ModeloTablaGenerico generico;
    public ControladorVenta v;
    private String[] nomTablaVentas = {"TICKETE", "CAJERO", "HORA", "TOTAL"};
    private String[] nomTablaV = {"Cant", "Codigo", "Descripcion", "Precio", "Descto", "Total"};
    private static List datos = new ArrayList();
    private final int PROPIEDAD = Caja.VENTA;
    public boolean verTiquete;

    public VentaVista() {
        initComponents();
        
        MenuVista.esVenta = true;
        MenuVista.esProd = false;
        MenuVista.esCompra = false;
        
        modelo = new ModeloTabla(this);
        menu = MenuVista.getInstancia();

        generico = new ModeloTablaGenerico(this);
        generico.establecerColumNom(nomTablaVentas);
        modelo.establecerColumNom(nomTablaV);
        tabla.setModel(modelo);
        tablaVentas.setModel(generico);

        generico.setTamanoColumnaTablaVenta();
        modelo.setTamanoColumna();

        tabla.getSelectionModel().addListSelectionListener(this);
        this.fachada = FachadaInterfaz.getInstancia();
        lblCajero.setText(fachada.ptoVenta.getNombreUsuarioActual());
        v = fachada.nuevaVenta();
        /**Remover Escuchador**/
        fachada.getPtoVenta().removeEscuchadorEventos(this);
        /**Cambio de Escuchador**/
        fachada.getPtoVenta().addEscuchadorEventos(this);
        /************************************/
        fachada.setNumFactura();
        tbpVenta.addChangeListener(this);
        mitFacturar.addActionListener(this);
        mitBuscarProd.addActionListener(this);
        mitBarraProd.addActionListener(this);
        mitVerTiquete.addActionListener(this);
        btnFacturar.addActionListener(this);
        btnBuscarProd.addActionListener(this);
        lblFecha.setText(cargarFecha());
        ((ModeloTabla) tabla.getModel()).tablaVenta = true;
        //cambios para ajustar la pantalla
        int anchoPantalla = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        //int altoPantalla = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        //this.tabla.setSize(510, 200);
        if(anchoPantalla > 1280){
            this.tabla.setSize(dia, dia);
             this.setSize(874, 630);
             
        }else{
             this.setSize(750, 630);
        }
       System.out.println("ancho ppantall a"+anchoPantalla);
        if (!fachada.baseIniciada()) {
            new SaldoBase(MenuVista.getInstancia(), true);
        }

    }

    /**Metodo para Cargar la Fecha Actual
     * @return
     */
    public String cargarFecha() {
        Date date = new Date();
        fecha = Utilidades.datetoString(date);
        return fecha;
    }

    public void actionPerformed(ActionEvent e) {
        PagoVista pag;
        if (e.getSource().equals(btnFacturar)) {
            if (tot != 0) {
                fachada.introducirCliente(txtCliente.getText());
                pag = new PagoVista(menu, this);
            }else{
                JOptionPane.showMessageDialog(null, "Debe Ingresar Productos!!!");
            }
        } else if (e.getSource().equals(btnBuscarProd)) {
            new BuscarProdVista(menu);
        } else if (e.getSource().equals(mitFacturar)) {
            if (tot != 0) {
                fachada.introducirCliente(txtCliente.getText());
                pag = new PagoVista(menu, this);
            }else{
                JOptionPane.showMessageDialog(null, "Debe Ingresar Productos!!!");
            }
        } else if (e.getSource().equals(mitBuscarProd)) {
            new BuscarProdVista(menu);
        } else if (e.getSource().equals(this.mitBarraProd)) {
            fachada.introducirCliente(txtCliente.getText());
            MenuVista.setInternal(30);
        } else if (e.getSource().equals(this.mitVerTiquete)) {
            verTiquete = mitVerTiquete.isSelected();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbpVenta = new javax.swing.JTabbedPane();
        pnlPedido = new javax.swing.JPanel();
        pnlNorte = new javax.swing.JPanel();
        lblNumPedido = new javax.swing.JLabel();
        lblTicketeVenta = new javax.swing.JLabel();
        lblCaj = new javax.swing.JLabel();
        lblCajero = new javax.swing.JLabel();
        lblCajaN = new javax.swing.JLabel();
        lblNCaja = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblFec = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        pnlCentro = new javax.swing.JPanel();
        pnlCentroN = new javax.swing.JPanel();
        lblCliente = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        lblCodProducto = new javax.swing.JLabel();
        txtCodProducto = new javax.swing.JTextField();
        btnBuscarProd = new javax.swing.JButton();
        lblCantidad = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txtCantidad = new javax.swing.JTextField();
        pnlCentroS = new javax.swing.JPanel();
        pnlBtnVenta = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnFacturar = new javax.swing.JButton();
        pnlCentroC = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnEliminarRegistro = new javax.swing.JButton();
        pnlTotal = new javax.swing.JPanel();
        lblSubTotal = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JTextField();
        lblDescueto = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JTextField();
        lblIVA = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        lblBase = new javax.swing.JLabel();
        txtBase = new javax.swing.JTextField();
        txtIVA = new javax.swing.JTextField();
        pnlHistorial = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaVentas = new javax.swing.JTable();
        pnlDer = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        dtcDesde = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        dtcHasta = new com.toedter.calendar.JDateChooser();
        btnVerificar = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        menuBar = new javax.swing.JMenuBar();
        mnuArchivo = new javax.swing.JMenu();
        mitFacturar = new javax.swing.JMenuItem();
        mitBuscarProd = new javax.swing.JMenuItem();
        mnuHerramientas = new javax.swing.JMenu();
        mitBarraProd = new javax.swing.JMenuItem();
        mitVerTiquete = new javax.swing.JCheckBoxMenuItem();
        mnuAyuda = new javax.swing.JMenu();

        setIconifiable(true);

        pnlPedido.setLayout(new java.awt.BorderLayout());

        pnlNorte.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        pnlNorte.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 5));

        lblNumPedido.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblNumPedido.setText("Tiquete Venta No:");
        pnlNorte.add(lblNumPedido);

        lblTicketeVenta.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblTicketeVenta.setForeground(new java.awt.Color(51, 102, 255));
        lblTicketeVenta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTicketeVenta.setPreferredSize(new java.awt.Dimension(100, 20));
        pnlNorte.add(lblTicketeVenta);

        lblCaj.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblCaj.setText("Cajero:");
        pnlNorte.add(lblCaj);

        lblCajero.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblCajero.setForeground(new java.awt.Color(51, 102, 255));
        lblCajero.setText("Alejandro Sarmiento");
        lblCajero.setPreferredSize(new java.awt.Dimension(180, 20));
        pnlNorte.add(lblCajero);

        lblCajaN.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblCajaN.setText("Caja:");
        pnlNorte.add(lblCajaN);

        lblNCaja.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblNCaja.setForeground(new java.awt.Color(51, 102, 255));
        lblNCaja.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNCaja.setText("01");
        lblNCaja.setPreferredSize(new java.awt.Dimension(20, 20));
        pnlNorte.add(lblNCaja);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setPreferredSize(new java.awt.Dimension(10, 20));
        pnlNorte.add(jSeparator1);

        lblFec.setFont(new java.awt.Font("Tahoma", 1, 10));
        lblFec.setText("Fecha:");
        pnlNorte.add(lblFec);

        lblFecha.setFont(new java.awt.Font("Tahoma", 1, 10));
        lblFecha.setForeground(new java.awt.Color(51, 102, 255));
        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFecha.setPreferredSize(new java.awt.Dimension(90, 20));
        pnlNorte.add(lblFecha);

        pnlPedido.add(pnlNorte, java.awt.BorderLayout.PAGE_START);

        pnlCentro.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        lblCliente.setFont(new java.awt.Font("Tahoma", 0, 18));
        lblCliente.setText("Cliente:");
        pnlCentroN.add(lblCliente);

        txtCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCliente.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCliente.setText("0");
        txtCliente.setNextFocusableComponent(txtCodProducto);
        txtCliente.setPreferredSize(new java.awt.Dimension(100, 22));
        txtCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                setFocoGanado(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                setFocoPerdido(evt);
            }
        });
        txtCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtClienteKeyPressed(evt);
            }
        });
        pnlCentroN.add(txtCliente);

        btnBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar1.png"))); // NOI18N
        btnBuscarCliente.setToolTipText("Buscar Cliente");
        btnBuscarCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscarCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });
        pnlCentroN.add(btnBuscarCliente);

        lblCodProducto.setFont(new java.awt.Font("Tahoma", 0, 18));
        lblCodProducto.setText("Código:");
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

        lblCantidad.setFont(new java.awt.Font("Tahoma", 0, 18));
        lblCantidad.setText("Cantidad:");
        pnlCentroN.add(lblCantidad);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setPreferredSize(new java.awt.Dimension(10, 20));
        pnlCentroN.add(jSeparator2);

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

        pnlCentroS.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        pnlCentroS.setPreferredSize(new java.awt.Dimension(100, 120));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 18));
        btnCancelar.setMnemonic('C');
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnFacturar.setFont(new java.awt.Font("Tahoma", 0, 18));
        btnFacturar.setMnemonic('F');
        btnFacturar.setText("Facturar");
        btnFacturar.setToolTipText("Facturar");
        btnFacturar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnFacturarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout pnlCentroSLayout = new javax.swing.GroupLayout(pnlCentroS);
        pnlCentroS.setLayout(pnlCentroSLayout);
        pnlCentroSLayout.setHorizontalGroup(
            pnlCentroSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCentroSLayout.createSequentialGroup()
                .addComponent(pnlBtnVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCentroSLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(btnFacturar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(32, 32, 32))
        );
        pnlCentroSLayout.setVerticalGroup(
            pnlCentroSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCentroSLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(pnlBtnVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlCentroSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnFacturar))
                .addGap(75, 75, 75))
        );

        pnlCentroC.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlCentroC.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 240));

        tabla.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tabla.setFont(new java.awt.Font("Tahoma", 0, 24));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Cant", "Codigo", "Descripcion", "Precio Unitario", "Descuento", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false
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

        pnlTotal.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));

        lblSubTotal.setFont(new java.awt.Font("Verdana", 1, 18));
        lblSubTotal.setText("SUBTOTAL:");

        txtSubTotal.setEditable(false);
        txtSubTotal.setFont(new java.awt.Font("Verdana", 1, 18));
        txtSubTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSubTotal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtSubTotal.setPreferredSize(new java.awt.Dimension(100, 25));

        lblDescueto.setFont(new java.awt.Font("Verdana", 1, 18));
        lblDescueto.setText("DESCUENTO:");

        txtDescuento.setEditable(false);
        txtDescuento.setFont(new java.awt.Font("Verdana", 1, 18));
        txtDescuento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDescuento.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtDescuento.setPreferredSize(new java.awt.Dimension(100, 25));

        lblIVA.setFont(new java.awt.Font("Verdana", 1, 18));
        lblIVA.setText("IVA:");

        lblTotal.setFont(new java.awt.Font("Verdana", 1, 18));
        lblTotal.setForeground(new java.awt.Color(51, 102, 255));
        lblTotal.setText("TOTAL:");

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
                    .addComponent(lblTotal)
                    .addComponent(lblIVA)
                    .addComponent(lblSubTotal)
                    .addComponent(lblDescueto)
                    .addComponent(lblBase))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBase, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtTotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIVA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)))
                .addGap(329, 329, 329))
        );
        pnlTotalLayout.setVerticalGroup(
            pnlTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTotalLayout.createSequentialGroup()
                .addGroup(pnlTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTotalLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblSubTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDescueto))
                    .addGroup(pnlTotalLayout.createSequentialGroup()
                        .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBase))))
                .addGap(9, 9, 9)
                .addGroup(pnlTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIVA)
                    .addComponent(txtIVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotal)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlCentroLayout = new javax.swing.GroupLayout(pnlCentro);
        pnlCentro.setLayout(pnlCentroLayout);
        pnlCentroLayout.setHorizontalGroup(
            pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCentroLayout.createSequentialGroup()
                .addGroup(pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlCentroN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
                    .addComponent(pnlCentroC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
                    .addGroup(pnlCentroLayout.createSequentialGroup()
                        .addComponent(pnlCentroS, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(96, 96, 96))
        );
        pnlCentroLayout.setVerticalGroup(
            pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCentroLayout.createSequentialGroup()
                .addComponent(pnlCentroN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCentroC, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlCentroS, 0, 189, Short.MAX_VALUE)
                    .addComponent(pnlTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlPedido.add(pnlCentro, java.awt.BorderLayout.CENTER);

        tbpVenta.addTab("Pedido Venta", pnlPedido);

        pnlHistorial.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        pnlHistorial.setLayout(new java.awt.BorderLayout());

        tablaVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID_VENTA", "CAJERO", "HORA", "TOTAL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaVentas);

        pnlHistorial.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        pnlDer.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        pnlDer.setPreferredSize(new java.awt.Dimension(275, 534));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BUSCAR VENTAS:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

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
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dtcHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dtcDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
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

        javax.swing.GroupLayout pnlDerLayout = new javax.swing.GroupLayout(pnlDer);
        pnlDer.setLayout(pnlDerLayout);
        pnlDerLayout.setHorizontalGroup(
            pnlDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDerLayout.setVerticalGroup(
            pnlDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDerLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(336, Short.MAX_VALUE))
        );

        pnlHistorial.add(pnlDer, java.awt.BorderLayout.LINE_END);

        tbpVenta.addTab("Historial de Ventas", pnlHistorial);

        getContentPane().add(tbpVenta, java.awt.BorderLayout.CENTER);

        mnuArchivo.setMnemonic('A');
        mnuArchivo.setText("Archivo");

        mitFacturar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        mitFacturar.setText("Facturar");
        mnuArchivo.add(mitFacturar);

        mitBuscarProd.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        mitBuscarProd.setText("Buscar Producto");
        mnuArchivo.add(mitBuscarProd);

        menuBar.add(mnuArchivo);

        mnuHerramientas.setText("Herramientas");

        mitBarraProd.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mitBarraProd.setText("Ver Menu Productos");
        mnuHerramientas.add(mitBarraProd);

        mitVerTiquete.setText("Ver Tiquete");
        mnuHerramientas.add(mitVerTiquete);

        menuBar.add(mnuHerramientas);

        mnuAyuda.setMnemonic('y');
        mnuAyuda.setText("Ayuda");
        menuBar.add(mnuAyuda);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents
/*Establece un color a la caja de texto que gane foco*/

    public void setFocoGanado(FocusEvent evt) {
        if (evt.getSource().equals(txtCodProducto)) {
            txtCodProducto.setBackground(FOCO_GANADO);
        } else if (evt.getSource().equals(txtCantidad)) {
            txtCantidad.setBackground(FOCO_GANADO);
            txtCantidad.selectAll();
        } else if (evt.getSource().equals(txtCliente)) {
            txtCliente.setBackground(FOCO_GANADO);
            txtCliente.selectAll();
        }
    }

    @Override
    /*Establece un color a la caja de texto que pierda foco*/
    public void setFocoPerdido(FocusEvent evt) {
        if (evt.getSource().equals(txtCodProducto)) {
            txtCodProducto.setBackground(FOCO_PERDIDO);
        } else if (evt.getSource().equals(txtCantidad)) {
            txtCantidad.setBackground(FOCO_PERDIDO);
            txtCantidad.select(0, 0);
        } else if (evt.getSource().equals(txtCliente)) {
            txtCliente.setBackground(FOCO_PERDIDO);
            txtCliente.select(0, 0);
        }
    }

    @Override
    /*Metodo para establecer foco a los TextField*/
    public void establecerFoco() {
        txtCliente.requestFocus(true);
    }

    /*
    private void setFocoPerdido(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_setFocoPerdido

    }//GEN-LAST:event_setFocoPerdido

private void setFocoGanado(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_setFocoGanado
    // TODO add your handling code here:
}//GEN-LAST:event_setFocoGanado
     */
private void txtCodProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodProductoKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        txtCliente.requestFocus(false);
        txtCantidad.requestFocus(true);
    }
}//GEN-LAST:event_txtCodProductoKeyPressed

private void txtCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        ((ModeloTabla) tabla.getModel()).tablaSeleccionada = false;
        ((ModeloTabla) tabla.getModel()).tablaVenta = false;
        ((ModeloTabla) tabla.getModel()).eliminar = false;
        id = txtCodProducto.getText();
        cant = Integer.parseInt(txtCantidad.getText());
        cantTabla = cant;
        fachada.introducirCliente(txtCliente.getText());
        fachada.introducirArticulo(PROPIEDAD,id, cant);
        txtCodProducto.requestFocus(true);
        txtCodProducto.selectAll();
    }
}//GEN-LAST:event_txtCantidadKeyPressed

private void txtClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClienteKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        if (fachada.validarCliente(txtCliente.getText())) {
            txtCodProducto.requestFocus(true);
        } else {
            JOptionPane.showMessageDialog(null, "Error - Cliente No valido!!!");
            txtCliente.requestFocus(true);
            txtCliente.selectAll();
        }
        
    }else if (evt.getKeyCode() == KeyEvent.VK_TAB) {
        if (fachada.validarCliente(txtCliente.getText())) {
            txtCodProducto.requestFocus(true);
        } else {
            JOptionPane.showMessageDialog(null, "Error - Cliente No valido!!!");
            txtCliente.requestFocus(true);
            txtCliente.selectAll();
        }
    }
}//GEN-LAST:event_txtClienteKeyPressed

private void tablaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaKeyPressed
    try {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int linea = tabla.getSelectedRow();
            cant = (Integer) (tabla.getValueAt(linea, 0));
            fachada.modificarCantidad(PROPIEDAD,linea, cant);
            txtCodProducto.requestFocus(true);
            txtCodProducto.selectAll();
        }
    } catch (NullPointerException np) {
    }
}//GEN-LAST:event_tablaKeyPressed

private void tablaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMousePressed
    try {
        ((modelo.ModeloTabla) tabla.getModel()).tablaSeleccionada = true;
        ((modelo.ModeloTabla) tabla.getModel()).tablaVenta = true;
    } catch (NullPointerException ne) {
    }
}//GEN-LAST:event_tablaMousePressed

private void btnEliminarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarRegistroActionPerformed
    int fil = tabla.getSelectedRow();
    if (fil != -1 && ((modelo.ModeloTabla) tabla.getModel()).getValueAt(fil, tabla.getSelectedColumn()) != "") {
        ((ModeloTabla) tabla.getModel()).tablaSeleccionada = true;
        ((modelo.ModeloTabla) tabla.getModel()).tablaVenta = true;
        ((ModeloTabla) tabla.getModel()).eliminar = true;
        int res = JOptionPane.showConfirmDialog(this,
                "Esta seguro de Eliminar el Registro de La ControladorVenta", "Eliminar Registro de Venta",
                JOptionPane.YES_NO_CANCEL_OPTION);
        if (res == 0) {
            fachada.eliminarFila(PROPIEDAD,fil);
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
    MenuVista.setInternal(2);
}//GEN-LAST:event_btnCancelarActionPerformed

private void btnVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarActionPerformed
    String desde = Utilidades.datetoStringLimpio(dtcDesde.getDate());
    String hasta = Utilidades.datetoStringLimpio(dtcHasta.getDate());
    fachada.buscarDatos(PROPIEDAD,desde, hasta);
}//GEN-LAST:event_btnVerificarActionPerformed

private void tablaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseReleased
    try {
    } catch (NullPointerException pe) {
    }
}//GEN-LAST:event_tablaMouseReleased

private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
    new BuscarClienteVista(menu);
}//GEN-LAST:event_btnBuscarClienteActionPerformed

private void btnFacturarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnFacturarKeyReleased
    System.out.println("KeyCode boton"+evt.getKeyChar());
}//GEN-LAST:event_btnFacturarKeyReleased
    public void escuchadorEvento(Object obj, String propiedad, Object valor) {
        if (propiedad.equals(PuntoDeVenta.SUBTOTAL_VENTA)) {
            String sub = valor.toString();
            subT = Double.parseDouble(sub);
            subTotal = Utilidades.darFormatoNumero(subT);
            txtSubTotal.setText(subTotal);
        } else if (propiedad.equals(PuntoDeVenta.DESC_VENTA)) {
            descTotal = Utilidades.darFormatoNumero(Double.parseDouble(valor.toString()));
            txtDescuento.setText(descTotal);
        } else if (propiedad.equals(PuntoDeVenta.TOTAL_VENTA)) {
            tot = Double.parseDouble(valor.toString());
            total = Utilidades.darFormatoNumero(Double.parseDouble(valor.toString()));
            txtTotal.setText(total);
        } else if (propiedad.equals(PuntoDeVenta.BASE_GRABABLE)) {
            baseGrabable = Utilidades.darFormatoNumero(Double.parseDouble(valor.toString()));
            txtBase.setText(baseGrabable);
        } else if (propiedad.equals(PuntoDeVenta.IVA_VENTA)) {
            iva = Utilidades.darFormatoNumero(Double.parseDouble(valor.toString()));
            txtIVA.setText(iva);
        } else if (propiedad.equals(PuntoDeVenta.NUEVO_PRODUCTO)) {
            ModeloTabla modeloTabla = (ModeloTabla) tabla.getModel();
            modeloTabla.ingresarNuevaFila(valor);
            tabla.updateUI();
            this.txtCodProducto.requestFocus(true);
        } else if (propiedad.equals(PuntoDeVenta.NUM_TICKETE)) {
            lblTicketeVenta.setText(MenuVista.prefijo + "-" + valor.toString());
            tiquete = MenuVista.prefijo + "-" + valor.toString();
        } else if (propiedad.equals(PuntoDeVenta.MODIFICAR_CANTIDAD)) {
            ArrayList val = (ArrayList) valor;
            tabla.setValueAt(val.get(4), tabla.getSelectedRow(), 4);
            tabla.setValueAt(val.get(5), tabla.getSelectedRow(), 5);
            tabla.updateUI();

        } else if (propiedad.equals(PuntoDeVenta.ESTABLECER_CANTIDAD)) {
            ArrayList modLinea = (ArrayList) valor;
            cantTabla = (Integer) modLinea.get(1);
            tabla.setValueAt(modLinea.get(1), (Integer) modLinea.get(0), 0);
            tabla.setValueAt(Utilidades.darFormatoNumero((Number) modLinea.get(2)), (Integer) modLinea.get(0), 4);
            tabla.setValueAt(modLinea.get(3), (Integer) modLinea.get(0), 5);
            tabla.updateUI();
        } else if (propiedad.equals(PuntoDeVenta.ELIMINAR_LINEA)) {
            ModeloTabla modeloTabla = (ModeloTabla) tabla.getModel();
            modeloTabla.eliminarFila((Integer) valor);
            tabla.updateUI();
        } else if (propiedad.equals(PuntoDeVenta.CARGAR_TABLA)) {
            datos = (List) valor;
            cargarTablaHistorial();
        } else if (propiedad.equals(PuntoDeVenta.ESTABLECER_CLIENTE)) {
            String cli = valor.toString();
            this.txtCliente.setText(cli);
            this.txtCodProducto.requestFocus(true);
        } else if (propiedad.equals(PuntoDeVenta.IMPUESTOS)) {
            imp = (Map) valor;
        } else if (propiedad.equals(PuntoDeVenta.ERROR_NO_DATOS)) {
            JOptionPane.showMessageDialog(null, valor, "Error", JOptionPane.ERROR_MESSAGE);
        }else if (propiedad.equals(PuntoDeVenta.DATOS_ENCONTRADOS)) {
            List data = (List) valor;
            //fachada.introducirArticulo(PROPIEDAD,data.get(0).toString(), 1);
            this.txtCodProducto.setText((String) data.get(0));
            txtCliente.requestFocus(false);
            txtCantidad.requestFocus(true);
            txtCantidad.select(0, 0);
        }else if (propiedad.equals(PuntoDeVenta.CLIENTE_VENTA)) {
            List data = (List) valor;
            fachada.introducirCliente(data.get(0).toString());
        }

    }

    public void cargarTablaHistorial() {
        ModeloTablaGenerico generico1 = new ModeloTablaGenerico(datos, this);
        generico1.establecerColumNom(nomTablaVentas);
        tablaVentas.setModel(generico1);
        tablaVentas.updateUI();
        this.updateUI();
    }

    public void valueChanged(ListSelectionEvent e) {
        try {
            int fila = tabla.getSelectedRow();
            if (fila != -1) {
                int ct = (Integer) modelo.getValueAt(fila, 0);
                if (ct != 1 && ct != cantTabla) {
                    fachada.modificarCantidad(PROPIEDAD,fila, ct);
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnBuscarProd;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminarRegistro;
    private javax.swing.JButton btnFacturar;
    private javax.swing.JButton btnVerificar;
    private com.toedter.calendar.JDateChooser dtcDesde;
    private com.toedter.calendar.JDateChooser dtcHasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblBase;
    private javax.swing.JLabel lblCaj;
    private javax.swing.JLabel lblCajaN;
    private javax.swing.JLabel lblCajero;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblCodProducto;
    private javax.swing.JLabel lblDescueto;
    private javax.swing.JLabel lblFec;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblIVA;
    private javax.swing.JLabel lblNCaja;
    private javax.swing.JLabel lblNumPedido;
    private javax.swing.JLabel lblSubTotal;
    private javax.swing.JLabel lblTicketeVenta;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem mitBarraProd;
    private javax.swing.JMenuItem mitBuscarProd;
    private javax.swing.JMenuItem mitFacturar;
    private javax.swing.JCheckBoxMenuItem mitVerTiquete;
    private javax.swing.JMenu mnuArchivo;
    private javax.swing.JMenu mnuAyuda;
    private javax.swing.JMenu mnuHerramientas;
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
    public javax.swing.JTable tablaVentas;
    private javax.swing.JTabbedPane tbpVenta;
    private javax.swing.JTextField txtBase;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtCodProducto;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtIVA;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

}
