package vista;

import control.ObservadorEventos;

import control.PuntoDeVenta;
import control.RegistrosGenerales;
import java.awt.Cursor;
import utilidades.Utilidades;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import utilidades.InvalidException;

/**
 *
 * @author Kymera Systems SAS
 */
public class ProductoVista extends VentanaInternaAbs implements ObservadorEventos {

    public boolean fechaVen;
    private int calidad = 0;
    public static FachadaInterfaz fachada;

    public ProductoVista() {
        initComponents();
        fachada = FachadaInterfaz.getInstancia();
        fachada.ptoVenta.removeEscuchadorEventos(this);
        fachada.ptoVenta.addEscuchadorEventos(this);
        MenuVista.esCompra = false;
        MenuVista.esVenta = false;
        cargarCombos();
        opcionFechaVencimiento(2);
        habilitarCampos(false);
         txtStock.setEnabled(false);
        fachada.cargarProductos(fachada.PRIMERO);
        if (txtID.getText().equals("")) {
            this.btnGuardar.setText("Agregar");
        } else {
            this.btnGuardar.setText("Modificar");
        }
        escuchador();

    }

    public void ponerFoto(ImageIcon img) {
        if (img != null) {
            if (img.getIconWidth() > 90) {
                img = new ImageIcon(img.getImage().getScaledInstance(141, 143, Image.SCALE_DEFAULT));
            }
            this.lblFoto.setIcon(img);
        }
    }

    public ArrayList pasarDatos() throws InvalidException {
        ArrayList datos = new ArrayList();
        if (!txtID.getText().isEmpty()) {
            datos.add(txtID.getText());
        } else {
            throw new InvalidException("Debe Ingresar el Codigo del Producto");
        }
        if (!txtDescripcion.getText().isEmpty()) {
            datos.add(txtDescripcion.getText());
        } else {
            throw new InvalidException("Debe Ingresar el Nombre del Producto");
        }
        if(!txtPrecio.getText().isEmpty()){
             datos.add(Double.parseDouble(txtPrecio.getText()));
        }else{
            throw new InvalidException("Debe Ingresar el Precio del Producto");
        }
       
        if (jrFecha.isSelected()) {
//            Date f = jFechaVencimiento.getDate();
//            if (!f.before(new Date()) || f.equals(new Date())) {
            datos.add(Utilidades.datetoString(jFechaVencimiento.getDate()));
//            } else {
//                throw new InvalidException("Fecha de Vencimiento Incorrecta");
//            }
        } else {
            datos.add("2000-01-01");
        }
        datos.add(txtLote.getText());
        if (this.jrStockSi.isSelected()) {
            datos.add(Integer.parseInt(txtStock.getText()));
        } else {
            datos.add(0);
        }

        if (((ModeloCombo) jcbCategoria.getModel()).getSelectedIndex() != null) {
            datos.add(((ModeloCombo) jcbCategoria.getModel()).getSelectedIndex());
        } else {
            throw new InvalidException("Seleccione una Categoria");
        }
        if (jcheckActivo.isSelected()) {
            datos.add("ACTIVO");
        } else {
            datos.add("NO ACTIVO");
        }
        if (lblFoto.getIcon() == null) {
            datos.add(null);
        } else {
            Icon im = lblFoto.getIcon();
            datos.add(Utilidades.toByteArray(im, this));
        }
        if (!txtCosto.getText().isEmpty()) {
            datos.add(Double.parseDouble(txtCosto.getText()));
        } else {
            throw new InvalidException("Ingrese el Costo de Compra del Producto");
        }
        if (!txtIva.getText().isEmpty()) {
            datos.add(Integer.parseInt(txtIva.getText()));
        } else {
            datos.add(0);
        }
        if (this.jrFecha.isSelected()) {
            datos.add("SI");
        } else {
            datos.add("NO");
        }
        if (this.jrStockSi.isSelected()) {
            datos.add("SI");
        } else {
            datos.add("NO");
        }
        if (((ModeloCombo) this.jcbProveedor.getModel()).getSelectedIndex() != null) {
            datos.add(((ModeloCombo) this.jcbProveedor.getModel()).getSelectedIndex());
        } else {
            datos.add("");
        }
        if (((ModeloCombo) this.jcbMarca.getModel()).getSelectedIndex() != null) {
            datos.add(((ModeloCombo) this.jcbMarca.getModel()).getSelectedIndex());
        } else {
            datos.add("");
        }
        datos.add(calidad);
        if (((ModeloCombo) this.jcbUnidad.getModel()).getSelectedIndex() != null) {
            datos.add(((ModeloCombo) this.jcbUnidad.getModel()).getSelectedIndex());
        } else {
            throw new InvalidException("Debe Ingresar El Tipo de Unidad Que Maneja El Producto");
        }
        if (((ModeloCombo) this.jcbUbicacion.getModel()).getSelectedIndex() != null) {
            datos.add(((ModeloCombo) this.jcbUbicacion.getModel()).getSelectedIndex());
        } else {
            datos.add("");
        }
        if(!txtIvaCobrado.getText().isEmpty()){
            datos.add(Integer.parseInt(txtIvaCobrado.getText()));
        }else{
            datos.add(0);
        }
        



        return datos;
    }

    public void ponerDatos(List valor) {
        txtID.setText((String) valor.get(0));
        txtDescripcion.setText((String) valor.get(1));
        txtPrecio.setText(Double.toString((Double) valor.get(2)));
        txtLote.setText((String) valor.get(4));
         txtStock.setText(valor.get(5).toString());
        if (valor.get(12).equals("SI")) {
            this.jrStockSi.setSelected(true);
           
        } else {
           
            this.jrStockNo.setSelected(true);
        }

        ((ModeloCombo) jcbCategoria.getModel()).setSelectedItemMap(valor.get(6));
        if (valor.get(7).equals("activo")) {
            jcheckActivo.setSelected(true);
        }
        if (valor.get(8) != null) {
            byte[] f = (byte[]) valor.get(8);
            ImageIcon img = new ImageIcon(f);
            ponerFoto(img);
        } else {
            ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/productoNotFound.png"));
            ponerFoto(icon);
        }
        txtCosto.setText(Double.toString((Double) valor.get(9)));
        txtIva.setText(valor.get(10).toString());
        if (valor.get(11).equals("SI")) {
            opcionFechaVencimiento(1);
            jFechaVencimiento.setDate(Utilidades.stringtoDate((String) valor.get(3)));
        } else {
            opcionFechaVencimiento(2);

        }
        if (!valor.get(12).equals("")) {
            ((ModeloCombo) jcbProveedor.getModel()).setSelectedItemMap(valor.get(13));
        } else {
            cargarComboProveedor();
        }
        ((ModeloCombo) jcbMarca.getModel()).setSelectedItemMap(valor.get(14));
        calidad((Integer) valor.get(15));
        ((ModeloCombo) jcbUnidad.getModel()).setSelectedItemMap(valor.get(16));
        ((ModeloCombo) jcbUbicacion.getModel()).setSelectedItemMap(valor.get(17));
        this.txtIvaCobrado.setText(valor.get(18).toString());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        util1 = new panel.Util();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel7 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jcbUnidad = new javax.swing.JComboBox();
        btnOtroUnidad = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jcbCategoria = new javax.swing.JComboBox();
        btnOtro = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jcbMarca = new javax.swing.JComboBox();
        btnOtroMarca = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtIva = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jcbUbicacion = new javax.swing.JComboBox();
        btnOtroUbicacion = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jcheckActivo = new javax.swing.JCheckBox();
        e1 = new javax.swing.JLabel();
        e2 = new javax.swing.JLabel();
        e3 = new javax.swing.JLabel();
        e4 = new javax.swing.JLabel();
        e5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblFoto = new javax.swing.JLabel();
        btnCargarFoto = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtLote = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtIvaCobrado = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jcbProveedor = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lblFechaVencimientoOpc = new javax.swing.JLabel();
        jrFecha = new javax.swing.JRadioButton();
        jFechaVencimiento = new com.toedter.calendar.JDateChooser();
        jrPerecedero = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jrStockSi = new javax.swing.JRadioButton();
        jrStockNo = new javax.swing.JRadioButton();
        jToolBar1 = new javax.swing.JToolBar();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        navegador1 = new panel.Navegador();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jPanel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Básicos"));

        jLabel1.setText("Código"); // NOI18N

        jLabel2.setText("Descripción"); // NOI18N

        txtDescripcion.setAutoscrolls(false);
        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });

        jLabel8.setText("Unidad");

        btnOtroUnidad.setText("Otro");
        btnOtroUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtroUnidadActionPerformed(evt);
            }
        });

        jLabel7.setText("Categoría"); // NOI18N

        btnOtro.setText("Otro");
        btnOtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtroActionPerformed(evt);
            }
        });

        jLabel14.setText("Marca");

        btnOtroMarca.setText("Otro");
        btnOtroMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtroMarcaActionPerformed(evt);
            }
        });

        jLabel3.setText("Precio de Venta"); // NOI18N

        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecioKeyReleased(evt);
            }
        });

        jLabel12.setText("IVA"); // NOI18N

        txtIva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIvaKeyReleased(evt);
            }
        });

        jLabel13.setText("Ubicación");

        btnOtroUbicacion.setText("Otro");
        btnOtroUbicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtroUbicacionActionPerformed(evt);
            }
        });

        jLabel10.setText("Estado"); // NOI18N

        jcheckActivo.setSelected(true);
        jcheckActivo.setText("Activo"); // NOI18N

        e1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/estrellaOut.png"))); // NOI18N
        e1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                e1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                e1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                e1MouseExited(evt);
            }
        });

        e2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/estrellaOut.png"))); // NOI18N
        e2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                e2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                e2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                e2MouseExited(evt);
            }
        });

        e3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/estrellaOut.png"))); // NOI18N
        e3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                e3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                e3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                e3MouseExited(evt);
            }
        });

        e4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/estrellaOut.png"))); // NOI18N
        e4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                e4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                e4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                e4MouseExited(evt);
            }
        });

        e5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/estrellaOut.png"))); // NOI18N
        e5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                e5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                e5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                e5MouseExited(evt);
            }
        });

        jLabel15.setText("Calidad");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        lblFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/productoNotFound.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
        );

        btnCargarFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cargar.png"))); // NOI18N
        btnCargarFoto.setBorderPainted(false);
        btnCargarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarFotoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCargarFoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCargarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel17.setForeground(new java.awt.Color(204, 0, 0));
        jLabel17.setText("*");

        jLabel18.setForeground(new java.awt.Color(204, 0, 0));
        jLabel18.setText("*");

        jLabel19.setForeground(new java.awt.Color(204, 0, 0));
        jLabel19.setText("*");

        jLabel20.setForeground(new java.awt.Color(204, 0, 0));
        jLabel20.setText("*");

        jLabel22.setForeground(new java.awt.Color(204, 0, 0));
        jLabel22.setText("*");

        jLabel9.setText("Cantidad"); // NOI18N

        txtStock.setForeground(new java.awt.Color(204, 0, 0));
        txtStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtStockKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel18)
                        .addComponent(jLabel20))
                    .addComponent(jLabel19)
                    .addComponent(jLabel22)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGap(22, 22, 22))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jcbUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnOtroUnidad))
                            .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jcbMarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jcbCategoria, 0, 108, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnOtro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnOtroMarca, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(txtDescripcion))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(jLabel15))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(e1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(e2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(e3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(e4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(e5))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(jcheckActivo))))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnOtroUbicacion)))
                .addGap(24, 24, 24))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel17))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel2)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(jcbUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(btnOtroUnidad))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jcbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOtro))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jcbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOtroMarca)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(e4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(e5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(e2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(e3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(e1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jcheckActivo))))
                .addGap(14, 14, 14)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel13)
                    .addComponent(jcbUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOtroUbicacion))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel8.setMaximumSize(new java.awt.Dimension(31767, 32767));
        jPanel8.setPreferredSize(new java.awt.Dimension(368, 207));

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Compra / Proveedor"));

        jLabel5.setText("Lote"); // NOI18N

        jLabel11.setText("Costo Compra"); // NOI18N

        txtCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoActionPerformed(evt);
            }
        });
        txtCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCostoKeyReleased(evt);
            }
        });

        jLabel16.setText("IVA Cobrado");

        jLabel6.setText("Proveedor");

        jLabel21.setForeground(new java.awt.Color(204, 0, 0));
        jLabel21.setText("*");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(txtIvaCobrado, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jcbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLote, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel21)
                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txtIvaCobrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jcbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.setPreferredSize(new java.awt.Dimension(368, 196));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Control Y Seguridad"));

        lblFechaVencimientoOpc.setForeground(new java.awt.Color(0, 51, 204));
        lblFechaVencimientoOpc.setText("Fecha Vencimiento ( Opcional )"); // NOI18N

        buttonGroup1.add(jrFecha);
        jrFecha.setText("Fecha");

        buttonGroup1.add(jrPerecedero);
        jrPerecedero.setText("No Perecedero");

        jLabel4.setText("Validar Stock");

        buttonGroup2.add(jrStockSi);
        jrStockSi.setText("SI");
        jrStockSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrStockSiActionPerformed(evt);
            }
        });

        buttonGroup2.add(jrStockNo);
        jrStockNo.setText("NO");
        jrStockNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrStockNoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrPerecedero)
                    .addComponent(lblFechaVencimientoOpc)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(6, 6, 6)
                                .addComponent(jrStockSi))
                            .addComponent(jrFecha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrStockNo)
                            .addComponent(jFechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFechaVencimientoOpc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jrFecha)
                    .addComponent(jFechaVencimiento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrPerecedero)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrStockSi)
                    .addComponent(jLabel4)
                    .addComponent(jrStockNo))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)))
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jPanel3, 0, 188, Short.MAX_VALUE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Datos B\u00e1sicos", jPanel2);

        jToolBar1.setRollover(true);

        btnAgregar.setText("Agregar"); // NOI18N
        btnAgregar.setFocusable(false);
        btnAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAgregar);

        btnEliminar.setText("Eliminar"); // NOI18N
        btnEliminar.setFocusable(false);
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEliminar);

        btnBuscar.setText("Buscar"); // NOI18N
        btnBuscar.setFocusable(false);
        btnBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnBuscar);

        btnGuardar.setText("Guardar"); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 1086, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1050, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(navegador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(301, 301, 301)
                        .addComponent(btnGuardar)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(navegador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarFotoActionPerformed
        JFileChooser fc = new JFileChooser();
        //AL JFILECHOOSER SE LE AGRAGA UN COMPONENTE QUE ES LA VISTA PREVIA DE LAS
        //IMAGENES SELECCIONADAS
        fc.setAccessory(new ImagenPrevia(fc));
        int returnValue = fc.showDialog(ProductoVista.this, "Abrir");
        //SI HACE CLIC EN ABRIR
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            //GUARDA LA RUTA DE LA IMAGEN
            ImageIcon img = new ImageIcon(file.getAbsolutePath());
            //AJUSTAMOS LA IMAGEN EN CASO DE QUE SEA MUY GRANDE A LA MEDIDA DEL PANEL
            ponerFoto(img);
        }
    }//GEN-LAST:event_btnCargarFotoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        limpiar();
        habilitarCampos(true);
        opcionFechaVencimiento(3);
        cargarCombos();
        this.jrPerecedero.setSelected(true);
        this.btnGuardar.setText("Guardar");
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (this.btnGuardar.getText().equals("Guardar")) {
            try {
                fachada.producto(pasarDatos(), FachadaInterfaz.INSERTAR);
                habilitarCampos(false);
                this.btnGuardar.setText("Modificar");
            } catch (InvalidException ex) {
            }
        } else if (this.btnGuardar.getText().equals("Modificar")) {
            habilitarCampos(true);
            opcionFechaVencimiento(3);
            txtID.setEnabled(false);
            this.btnGuardar.setText("Actualizar");
        } else if (this.btnGuardar.getText().equals("Actualizar")) {
            try {

                fachada.producto(pasarDatos(), FachadaInterfaz.MODIFICAR);
                this.btnGuardar.setText("Modificar");
                habilitarCampos(false);
            } catch (InvalidException ex) {
            }

        } else if (this.btnGuardar.getText().equals("Agregar")) {
            this.btnGuardar.setText("Guardar");
            cargarCombos();
            habilitarCampos(true);
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (!txtID.getText().equals("")) {
            int r = JOptionPane.showConfirmDialog(null, "Esta Seguro De Eliminar Este Registro?", "Eliminar Registro", JOptionPane.YES_NO_CANCEL_OPTION);
            if (r == 0) {
                fachada.producto(txtID.getText(), FachadaInterfaz.ELIMINAR);
                limpiar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe Seleccionar Un Producto");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        new BuscarProdVista(MenuVista.getInstancia());

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    private void txtPrecioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyReleased
        String precio = txtPrecio.getText();
        String validacion = Utilidades.contenidoCajaTexto(precio);
        txtPrecio.setText(validacion);
    }//GEN-LAST:event_txtPrecioKeyReleased

    private void txtCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyReleased
    }//GEN-LAST:event_txtCantidadKeyReleased

    private void txtStockKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockKeyReleased
        String stock = txtStock.getText();
        String validacion = Utilidades.contenidoCajaTexto(stock);
        txtStock.setText(validacion);
    }//GEN-LAST:event_txtStockKeyReleased

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void txtCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostoActionPerformed

    private void txtCostoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoKeyReleased
        String costo = txtCosto.getText();
        String validacion = Utilidades.contenidoCajaTexto(costo);
        txtCosto.setText(validacion);
    }//GEN-LAST:event_txtCostoKeyReleased

    private void txtIvaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIvaKeyReleased
        String iva = txtIva.getText();
        String validacion = Utilidades.contenidoCajaTexto(iva);
        txtIva.setText(validacion);
    }//GEN-LAST:event_txtIvaKeyReleased

    private void btnOtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtroActionPerformed
         new IngresoCategoria();
       IngresoCategoria.identificador(1);
    }//GEN-LAST:event_btnOtroActionPerformed

    private void jrStockSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrStockSiActionPerformed
      
    }//GEN-LAST:event_jrStockSiActionPerformed

    private void jrStockNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrStockNoActionPerformed
      
    }//GEN-LAST:event_jrStockNoActionPerformed

    private void e1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_e1MouseEntered
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

    }//GEN-LAST:event_e1MouseEntered

    private void e1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_e1MouseExited
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_e1MouseExited

    private void e2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_e2MouseEntered
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_e2MouseEntered

    private void e2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_e2MouseExited
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_e2MouseExited

    private void e3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_e3MouseEntered
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_e3MouseEntered

    private void e3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_e3MouseExited
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_e3MouseExited

    private void e4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_e4MouseEntered
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_e4MouseEntered

    private void e4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_e4MouseExited
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_e4MouseExited

    private void e5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_e5MouseEntered
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_e5MouseEntered

    private void e5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_e5MouseExited
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_e5MouseExited

    private void e1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_e1MouseClicked
        calidad(1);
        calidad = 1;
    }//GEN-LAST:event_e1MouseClicked

    private void e2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_e2MouseClicked
        calidad(2);
        calidad = 2;
    }//GEN-LAST:event_e2MouseClicked

    private void e3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_e3MouseClicked
        calidad(3);
        calidad = 3;
    }//GEN-LAST:event_e3MouseClicked

    private void e4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_e4MouseClicked
        calidad(4);
        calidad = 4;
    }//GEN-LAST:event_e4MouseClicked

    private void e5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_e5MouseClicked
        calidad(5);
        calidad = 5;
    }//GEN-LAST:event_e5MouseClicked

    private void btnOtroUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtroUnidadActionPerformed
       new IngresoCategoria();
       IngresoCategoria.identificador(7);
    }//GEN-LAST:event_btnOtroUnidadActionPerformed

    private void btnOtroMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtroMarcaActionPerformed
        new IngresoCategoria();
       IngresoCategoria.identificador(8);
    }//GEN-LAST:event_btnOtroMarcaActionPerformed

    private void btnOtroUbicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtroUbicacionActionPerformed
        new IngresoCategoria();
       IngresoCategoria.identificador(9);
    }//GEN-LAST:event_btnOtroUbicacionActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCargarFoto;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnOtro;
    private javax.swing.JButton btnOtroMarca;
    private javax.swing.JButton btnOtroUbicacion;
    private javax.swing.JButton btnOtroUnidad;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel e1;
    private javax.swing.JLabel e2;
    private javax.swing.JLabel e3;
    private javax.swing.JLabel e4;
    private javax.swing.JLabel e5;
    private com.toedter.calendar.JDateChooser jFechaVencimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private static javax.swing.JComboBox jcbCategoria;
    private static javax.swing.JComboBox jcbMarca;
    private javax.swing.JComboBox jcbProveedor;
    private static javax.swing.JComboBox jcbUbicacion;
    private static javax.swing.JComboBox jcbUnidad;
    private javax.swing.JCheckBox jcheckActivo;
    private javax.swing.JRadioButton jrFecha;
    private javax.swing.JRadioButton jrPerecedero;
    private javax.swing.JRadioButton jrStockNo;
    private javax.swing.JRadioButton jrStockSi;
    private javax.swing.JLabel lblFechaVencimientoOpc;
    private javax.swing.JLabel lblFoto;
    private panel.Navegador navegador1;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtIvaCobrado;
    private javax.swing.JTextField txtLote;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    private panel.Util util1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void establecerFoco() {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setFocoGanado(FocusEvent evt) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setFocoPerdido(FocusEvent evt) {
        // throw new UnsupportedOperationException("Not supported yet.");
    }

    public void escuchadorEvento(Object obj, String propiedad, Object vl) {
        List valor = null;
        if (propiedad.equals(RegistrosGenerales.CARGAR_PRODUCTO)) {
            valor = (List) vl;
            ponerDatos(valor);
        } else if (propiedad.equals(PuntoDeVenta.DATOS_PRO_ENCON)) {
            List data = (List) vl;
            int pos = ProductoVista.fachada.obtenerPosProducto(data.get(1).toString());

            ProductoVista.fachada.cargarProductos(pos);

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

    public void limpiar() {
        txtID.setText("");
        txtDescripcion.setText("");
        txtPrecio.setText("");
        lblFoto.setIcon(null);
        txtLote.setText("");
        jcheckActivo.setSelected(false);
        txtStock.setText("");
        jFechaVencimiento.setDate(new Date());
        txtCosto.setText("");
        txtIva.setText("");
    }

    public static void cargarComboCategoria() {
        jcbCategoria.setModel(new ModeloCombo(fachada.getCategoria()));
        jcbCategoria.getModel().setSelectedItem("");
        jcbCategoria.updateUI();
    }

    public static void cargarComboUnidadMedida() {
        jcbUnidad.setModel(new ModeloCombo(fachada.getUnidadMedida()));
        jcbUnidad.getModel().setSelectedItem("");
    }

    public static void cargarComboMarca() {
        jcbMarca.setModel(new ModeloCombo(fachada.getMarcas()));
        jcbMarca.getModel().setSelectedItem("");
    }

    public static void cargarComboUbicacion() {
        jcbUbicacion.setModel(new ModeloCombo(fachada.getUbicacion()));
        jcbUbicacion.getModel().setSelectedItem("");
    }

    public void cargarComboProveedor() {
        this.jcbProveedor.setModel(new ModeloCombo(fachada.getProveedores()));
        jcbProveedor.getModel().setSelectedItem("");

    }

    public void cargarCombos() {
        cargarComboCategoria();
        cargarComboProveedor();
        cargarComboUnidadMedida();
        cargarComboMarca();
        cargarComboUbicacion();
    }

    private void habilitarCampos(boolean b) {
        txtID.setEnabled(b);
        txtDescripcion.setEnabled(b);
        txtPrecio.setEnabled(b);
        jFechaVencimiento.setEnabled(b);
        jcbCategoria.setEnabled(b);
        btnCargarFoto.setEnabled(b);
        txtLote.setEnabled(b);
        txtStock.setEnabled(b);
        jcheckActivo.setEnabled(b);
        txtCosto.setEnabled(b);
        txtIva.setEnabled(b);
        this.btnOtro.setEnabled(b);
        this.lblFechaVencimientoOpc.setEnabled(b);
        this.jrFecha.setEnabled(b);
        this.jrPerecedero.setEnabled(b);
        this.jrStockNo.setEnabled(b);
        this.jrStockSi.setEnabled(b);
        this.jcbProveedor.setEnabled(b);
        this.jcbMarca.setEnabled(b);
        this.jcbUbicacion.setEnabled(b);
        this.jcbUnidad.setEnabled(b);
        this.txtIvaCobrado.setEnabled(b);
        this.btnOtroMarca.setEnabled(b);
        this.btnOtroUbicacion.setEnabled(b);
        this.btnOtroUnidad.setEnabled(b);

    }

    public void opcionFechaVencimiento(int tipo) {
        switch (tipo) {
            case 1: {
                this.jrFecha.setVisible(true);
                jFechaVencimiento.setVisible(true);
                this.jrPerecedero.setVisible(false);
                this.jrFecha.setSelected(true);
                break;
            }
            case 2: {
                this.jrFecha.setVisible(false);
                jFechaVencimiento.setVisible(false);
                this.jrPerecedero.setVisible(true);
                this.jrPerecedero.setSelected(true);
                break;
            }
            case 3: {
                this.jrFecha.setVisible(true);
                jFechaVencimiento.setVisible(true);
                this.jrPerecedero.setVisible(true);

            }
        }
    }

    public void calidad(int calidad) {
        Imagenes im = new Imagenes();
        switch (calidad) {
            case 1: {

                e1.setIcon(im.getImgEstrellaIn());
                e2.setIcon(im.getImgEstrellaOut());
                e3.setIcon(im.getImgEstrellaOut());
                e4.setIcon(im.getImgEstrellaOut());
                e5.setIcon(im.getImgEstrellaOut());
                break;
            }
            case 2: {

                e1.setIcon(im.getImgEstrellaIn());
                e2.setIcon(im.getImgEstrellaIn());
                e3.setIcon(im.getImgEstrellaOut());
                e4.setIcon(im.getImgEstrellaOut());
                e5.setIcon(im.getImgEstrellaOut());
                break;
            }
            case 3: {

                e1.setIcon(im.getImgEstrellaIn());
                e2.setIcon(im.getImgEstrellaIn());
                e3.setIcon(im.getImgEstrellaIn());
                e4.setIcon(im.getImgEstrellaOut());
                e5.setIcon(im.getImgEstrellaOut());
                break;
            }
            case 4: {

                e1.setIcon(im.getImgEstrellaIn());
                e2.setIcon(im.getImgEstrellaIn());
                e3.setIcon(im.getImgEstrellaIn());
                e4.setIcon(im.getImgEstrellaIn());
                e5.setIcon(im.getImgEstrellaOut());
                break;
            }
            case 5: {

                e1.setIcon(im.getImgEstrellaIn());
                e2.setIcon(im.getImgEstrellaIn());
                e3.setIcon(im.getImgEstrellaIn());
                e4.setIcon(im.getImgEstrellaIn());
                e5.setIcon(im.getImgEstrellaIn());
                break;
            }

        }
    }



    public void escuchador() {
        navegador1.lblPrimero.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fachada.cargarProductos(fachada.PRIMERO);
                habilitarCampos(false);
            }
        });

        navegador1.lblAnterior.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fachada.cargarProductos(fachada.ANTERIOR);
                habilitarCampos(false);
            }
        });
        navegador1.lblSiguiente.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fachada.cargarProductos(fachada.SIGUIENTE);
                habilitarCampos(false);
            }
        });
        navegador1.lblUltimo.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fachada.cargarProductos(fachada.ULTIMO);
                habilitarCampos(false);
            }
        });
    }
}
