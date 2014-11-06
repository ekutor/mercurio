package vista;

import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import persistenciaFWK.ManejadorArchivos;
import utilidades.Encriptacion;
import utilidades.Utilidades;

public class Configuracion extends javax.swing.JDialog {

    public static final String ARCHIVO = "config/etpi.cfg";
    private byte[] logo;
    private String pathLogo;
    private persistenciaFWK.ManejadorArchivos adm;

    public Configuracion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(parent);
        try {
            adm = new persistenciaFWK.ManejadorArchivos(ARCHIVO);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        this.cmbCiu.setModel(new ModeloCombo());
        cargarComboDptos();
        cargarDatos();
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoTiquete = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlInfo = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        lblRazonSocial = new javax.swing.JLabel();
        lbl5 = new javax.swing.JLabel();
        lblNit = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtDir = new javax.swing.JTextField();
        lbl6 = new javax.swing.JLabel();
        lblNombreC = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnLogo = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        cmbDep = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        cmbCiu = new javax.swing.JComboBox();
        btnAplicarInfo = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        txtPrefijo = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        lblTpv = new javax.swing.JLabel();
        jCheckImg = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jcb1 = new javax.swing.JComboBox();
        txtCant1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtCant2 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jcb2 = new javax.swing.JComboBox();
        jCheck = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        btnAplicarMensajes = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        rdbSi = new javax.swing.JRadioButton();
        rdbNo = new javax.swing.JRadioButton();
        btnCambioStock = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlInfo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel11.setText("Razon Social");

        lblRazonSocial.setFont(new java.awt.Font("Verdana", 1, 13));
        lblRazonSocial.setText("Heladeria Kamys");

        lbl5.setText("Nit");

        lblNit.setFont(new java.awt.Font("Verdana", 1, 13));
        lblNit.setText("900.333.511");

        jLabel12.setText("Direccion");

        lbl6.setText("Sigla");

        lblNombreC.setFont(new java.awt.Font("Verdana", 1, 13));
        lblNombreC.setText("Kamys");

        jLabel13.setText("Logo");

        btnLogo.setText("Cambiar Logo");
        btnLogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoActionPerformed(evt);
            }
        });

        lblLogo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Ubicacion empresa"));

        jLabel14.setText("Departamento");

        cmbDep.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDepActionPerformed(evt);
            }
        });

        jLabel15.setText("Ciudad");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbDep, 0, 194, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbCiu, 0, 241, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(cmbDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(cmbCiu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        btnAplicarInfo.setText("Guardar Cambios");
        btnAplicarInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarInfoActionPerformed(evt);
            }
        });

        jLabel25.setText("Prefijo Tiquete");

        jLabel26.setText("Numero Terminal");

        lblTpv.setFont(new java.awt.Font("Verdana", 1, 13));
        lblTpv.setText("001");

        jCheckImg.setText("Utilizar Imagen en los Reportes");

        javax.swing.GroupLayout pnlInfoLayout = new javax.swing.GroupLayout(pnlInfo);
        pnlInfo.setLayout(pnlInfoLayout);
        pnlInfoLayout.setHorizontalGroup(
            pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInfoLayout.createSequentialGroup()
                        .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(lbl5)
                            .addComponent(lbl6))
                        .addGap(40, 40, 40)
                        .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlInfoLayout.createSequentialGroup()
                                .addComponent(lblNombreC, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                                .addGap(94, 94, 94))
                            .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblNit)
                                .addComponent(lblRazonSocial, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))))
                    .addGroup(pnlInfoLayout.createSequentialGroup()
                        .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlInfoLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(85, 85, 85)
                                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckImg)
                                    .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLogo)
                            .addComponent(btnAplicarInfo)))
                    .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlInfoLayout.createSequentialGroup()
                            .addComponent(jLabel26)
                            .addGap(18, 18, 18)
                            .addComponent(lblTpv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlInfoLayout.createSequentialGroup()
                            .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12)
                                .addComponent(jLabel25))
                            .addGap(35, 35, 35)
                            .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPrefijo, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDir, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        pnlInfoLayout.setVerticalGroup(
            pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnlInfoLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(8, 8, 8)
                        .addComponent(lbl5)
                        .addGap(8, 8, 8)
                        .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl6)
                            .addComponent(lblNombreC)))
                    .addGroup(pnlInfoLayout.createSequentialGroup()
                        .addComponent(lblRazonSocial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNit)
                        .addGap(22, 22, 22)))
                .addGap(8, 8, 8)
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(lblTpv))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtPrefijo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInfoLayout.createSequentialGroup()
                        .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlInfoLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(100, 100, 100))
                            .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckImg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlInfoLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(btnLogo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                        .addComponent(btnAplicarInfo)))
                .addGap(16, 16, 16))
        );

        jTabbedPane1.addTab("Informacion Empresa", pnlInfo);

        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel16.setFont(new java.awt.Font("URW Gothic L", 1, 13));
        jLabel16.setText("Configuracion de los Mensajes Emergentes del Sistema");

        jLabel17.setText("Recordar Cada:");

        jcb1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Tiempo", "Minutos", "Horas" }));

        txtCant1.setText("10");

        jLabel18.setText("-");

        jLabel19.setText("Si existe mas de un mensaje emergente, el tiempo entre cada ");

        jLabel20.setText("mensaje sera de:");

        jLabel21.setText("Tiempo entre Mensajes:");

        txtCant2.setText("10");

        jLabel22.setText("-");

        jcb2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Tiempo", "Segundos", "Minutos" }));

        jCheck.setFont(new java.awt.Font("URW Gothic L", 1, 13));
        jCheck.setText("No Mostrar Mensajes Emergentes");
        jCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckActionPerformed(evt);
            }
        });

        btnAplicarMensajes.setText("Aplicar");
        btnAplicarMensajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarMensajesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addComponent(jLabel17)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCant1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel18)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jcb1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(81, 81, 81))
                                .addComponent(jLabel19)
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addComponent(jLabel20)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addComponent(jLabel21)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCant2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jcb2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addComponent(jCheck)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                            .addComponent(jLabel16)
                            .addGap(33, 33, 33))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                            .addContainerGap()))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(btnAplicarMensajes)
                        .addContainerGap())))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel16)
                .addGap(52, 52, 52)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jcb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCant1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(33, 33, 33)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtCant2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(jcb2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(btnAplicarMensajes)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Mensajes Emergentes", jPanel6);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel24.setFont(new java.awt.Font("URW Gothic L", 1, 13));
        jLabel24.setText("Defina el Stock Minimo de Productos");

        jLabel1.setText("Stock Minimo");

        txtStock.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtStock.setText("10");

        jLabel2.setText("Uniddes");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addComponent(jLabel24))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jLabel23.setFont(new java.awt.Font("URW Gothic L", 1, 13));
        jLabel23.setText("Parametros Generales del Sistema KMS");

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Configurar Impresion de Tiquete", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel3.setText("Imprimir Tiquete al Finalizar Venta:");

        grupoTiquete.add(rdbSi);
        rdbSi.setSelected(true);
        rdbSi.setText("SI");

        grupoTiquete.add(rdbNo);
        rdbNo.setText("NO");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(64, 64, 64)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdbSi)
                    .addComponent(rdbNo))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rdbSi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdbNo)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCambioStock.setText("Aplicar Cambio");
        btnCambioStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambioStockActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel23))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(2, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(380, Short.MAX_VALUE)
                .addComponent(btnCambioStock)
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addComponent(btnCambioStock)
                .addGap(24, 24, 24))
        );

        jTabbedPane1.addTab("General", jPanel1);

        btnGuardar.setText("Aceptar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(160, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setAccessory(new ImagenPrevia(fc));
        int r = fc.showDialog(this, "Abrir");
        if (r == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            pathLogo = file.getAbsolutePath();
            ImageIcon img = new ImageIcon(file.getAbsolutePath());
            ponerFoto(img);

        }
}//GEN-LAST:event_btnLogoActionPerformed

    private void cmbDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDepActionPerformed
        int dpto = this.cmbDep.getSelectedItem().hashCode();
        this.cargarComboCiudad(dpto);
}//GEN-LAST:event_cmbDepActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        this.dispose();
}//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
}//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAplicarInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarInfoActionPerformed
        adm.guardarDatoEncriptado(ManejadorArchivos.DIRECCION, this.txtDir.getText());
        adm.guardarDatoEncriptado(ManejadorArchivos.LOGO, pathLogo);
        adm.guardarDatoEncriptado(ManejadorArchivos.BYTES_LOGO, Encriptacion.getInstacncia().bytestoString(logo));
        adm.guardarDatoEncriptado(ManejadorArchivos.CIUDAD, this.cmbCiu.getSelectedItem().toString());
        adm.guardarDatoEncriptado(ManejadorArchivos.PREFIJO, this.txtPrefijo.getText());
        if (this.jCheckImg.isSelected()) {
            adm.guardarDatoEncriptado(ManejadorArchivos.UTL_LOGO, "0");
        } else {
            adm.guardarDatoEncriptado(ManejadorArchivos.UTL_LOGO, "1");
        }
        cargarDatosSistema();
    }//GEN-LAST:event_btnAplicarInfoActionPerformed

    private void btnAplicarMensajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarMensajesActionPerformed
        adm.guardarDatoEncriptado(ManejadorArchivos.CANT1, txtCant1.getText());
        adm.guardarDatoEncriptado(ManejadorArchivos.TMP1, jcb1.getSelectedItem().toString());
        adm.guardarDatoEncriptado(ManejadorArchivos.CANT2, txtCant2.getText());
        adm.guardarDatoEncriptado(ManejadorArchivos.TMP2, jcb2.getSelectedItem().toString());
        if (jCheck.isSelected()) {
            adm.guardarDatoEncriptado(ManejadorArchivos.ACTIVO, "1");
            // System.out.println("ESTOY DESACTIVADO GUARDE:" + 1);
        } else {
            adm.guardarDatoEncriptado(ManejadorArchivos.ACTIVO, "0");
            //System.out.println("ESTOY ACTIVADO GUARDE:" + 0);
        }
        cargarDatosSistema();
    }//GEN-LAST:event_btnAplicarMensajesActionPerformed

    private void jCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckActionPerformed
        if (this.jCheck.isSelected()) {
            txtCant1.setEnabled(false);
            txtCant2.setEnabled(false);
            jcb1.setEnabled(false);
            jcb2.setEnabled(false);
        } else {
            txtCant1.setEnabled(true);
            txtCant2.setEnabled(true);
            jcb1.setEnabled(true);
            jcb2.setEnabled(true);
        }

    }//GEN-LAST:event_jCheckActionPerformed

    private void btnCambioStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambioStockActionPerformed
        adm.guardarDatoEncriptado(ManejadorArchivos.STM, txtStock.getText());
        String imprimirTiquete;
        if (rdbSi.isSelected()) {
            imprimirTiquete = "0";
        } else {
            imprimirTiquete = "1";
        }
        adm.guardarDatoEncriptado(ManejadorArchivos.ITV, imprimirTiquete);
        cargarDatosSistema();
    }//GEN-LAST:event_btnCambioStockActionPerformed

    private void ponerFoto(ImageIcon img) {
        if (img != null) {
            if (img.getIconWidth() > 90) {
                img = new ImageIcon(img.getImage().getScaledInstance(141, 143, Image.SCALE_DEFAULT));
            }
            this.lblLogo.setIcon(img);
            logo = Utilidades.toByteArray(img, this);
        }
    }

    private void ponerFoto(String path) {
        ImageIcon img = new ImageIcon(path);
        if (img != null) {
            if (img.getIconWidth() > 90) {
                img = new ImageIcon(img.getImage().getScaledInstance(141, 143, Image.SCALE_DEFAULT));
            }
            this.lblLogo.setIcon(img);
        }
    }

    private void cargarDatos() {
        try {
            persistenciaFWK.ManejadorArchivos m = new persistenciaFWK.ManejadorArchivos(ARCHIVO);
            this.lblRazonSocial.setText(m.cargarDatoDesencriptado(ManejadorArchivos.RAZON_SOCIAL));
            this.lblNit.setText(m.cargarDatoDesencriptado(ManejadorArchivos.NIT));
            this.lblNombreC.setText(m.cargarDatoDesencriptado(ManejadorArchivos.NOMBRE));
            this.txtDir.setText(m.cargarDatoDesencriptado(ManejadorArchivos.DIRECCION));
            this.txtPrefijo.setText(m.cargarDatoDesencriptado(ManejadorArchivos.PREFIJO));
            this.lblTpv.setText(m.cargarDatoDesencriptado(ManejadorArchivos.TPV));
            ((ModeloCombo) this.cmbCiu.getModel()).setSelectedItem(m.cargarDatoDesencriptado(ManejadorArchivos.CIUDAD));
            pathLogo = m.cargarDatoDesencriptado(ManejadorArchivos.LOGO);
            String l = m.cargarDatoDesencriptado(ManejadorArchivos.BYTES_LOGO);
            if (!l.equals("0") && l != null) {
                logo = Encriptacion.getInstacncia().stringtoBytes(l);

                ponerFoto(new ImageIcon(logo));
            }
            txtCant1.setText(m.cargarDatoDesencriptado(ManejadorArchivos.CANT1));
            jcb1.setSelectedItem(m.cargarDatoDesencriptado(ManejadorArchivos.TMP1));
            txtCant2.setText(m.cargarDatoDesencriptado(ManejadorArchivos.CANT2));
            jcb2.setSelectedItem(m.cargarDatoDesencriptado(ManejadorArchivos.TMP2));
            if (m.cargarDatoDesencriptado(ManejadorArchivos.ACTIVO).equals("0")) {
                jCheck.setSelected(false);
                inhabilitarCamposTiempo(true);
            } else {
                jCheck.setSelected(true);
                inhabilitarCamposTiempo(false);
            }
            if (m.cargarDatoDesencriptado(ManejadorArchivos.ITV).equals("0")) {
                rdbSi.setSelected(true);
            } else {
                rdbNo.setSelected(true);
            }
            txtStock.setText(m.cargarDatoDesencriptado(ManejadorArchivos.STM));
            if (m.cargarDatoDesencriptado(ManejadorArchivos.UTL_LOGO).equals("0")) {
                this.jCheckImg.setSelected(true);
            } else {
                this.jCheckImg.setSelected(false);
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void cargarDatosSistema() {
        try {
            persistenciaFWK.ManejadorArchivos adm = new persistenciaFWK.ManejadorArchivos(ARCHIVO);
            MenuVista.razonSocial = adm.cargarDatoDesencriptado(ManejadorArchivos.RAZON_SOCIAL);
            MenuVista.Nit = adm.cargarDatoDesencriptado(ManejadorArchivos.NIT);
            MenuVista.sigla = adm.cargarDatoDesencriptado(ManejadorArchivos.NOMBRE);
            MenuVista.direccion = adm.cargarDatoDesencriptado(ManejadorArchivos.DIRECCION);
            MenuVista.ciudad = adm.cargarDatoDesencriptado(ManejadorArchivos.CIUDAD);
            MenuVista.pathLogo = adm.cargarDatoDesencriptado(ManejadorArchivos.LOGO);
            MenuVista.prefijo = adm.cargarDatoDesencriptado(ManejadorArchivos.PREFIJO);
            MenuVista.CANT1 = adm.cargarDatoDesencriptado(ManejadorArchivos.CANT1);
            MenuVista.TIEMP1 = adm.cargarDatoDesencriptado(ManejadorArchivos.TMP1);
            MenuVista.CANT2 = adm.cargarDatoDesencriptado(ManejadorArchivos.CANT2);
            MenuVista.TIEMP2 = adm.cargarDatoDesencriptado(ManejadorArchivos.TMP2);
            MenuVista.tpv = Integer.parseInt(adm.cargarDatoDesencriptado(ManejadorArchivos.TPV));
            MenuVista.ultimoTicket = adm.cargarDatoDesencriptado(ManejadorArchivos.UTV);
            control.PuntoDeVenta.TPV = MenuVista.tpv;
            MenuVista.stockMinimo = adm.cargarDatoDesencriptado(ManejadorArchivos.STM);
            if (adm.cargarDatoDesencriptado(ManejadorArchivos.ACTIVO).equals("0")) {
                MenuVista.ACTIVO = true;
            } else {
                MenuVista.ACTIVO = false;
            }
            if (adm.cargarDatoDesencriptado(ManejadorArchivos.ITV).equals("0")) {
                MenuVista.IMPRIMIR_TIQUETE = true;
            } else {
                MenuVista.IMPRIMIR_TIQUETE = false;
            }
            MenuVista.utl_logo = adm.cargarDatoDesencriptado(ManejadorArchivos.UTL_LOGO);


        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void cargarComboDptos() {
        this.cmbDep.setModel(new ModeloCombo(FachadaInterfaz.getInstancia().getDpto()));
    }

    public void cargarComboCiudad(int dpto) {
        this.cmbCiu.setModel(new ModeloCombo(FachadaInterfaz.getInstancia().getCiudad(dpto)));
        cmbCiu.updateUI();
    }

    public void inhabilitarCamposTiempo(boolean b) {
        txtCant1.setEnabled(b);
        txtCant2.setEnabled(b);
        jcb1.setEnabled(b);
        jcb2.setEnabled(b);
    }

    public static int tiempoMensajes(String tmp, String cant) {
        int tiempo;
        if (tmp.equalsIgnoreCase("horas")) {
            return tiempo = (Integer.parseInt(cant) * 3600000);
        } else if (tmp.equalsIgnoreCase("minutos")) {
            return tiempo = (Integer.parseInt(cant) * 60000);
        } else {
            return tiempo = (Integer.parseInt(cant) * 1000);
        }
    }
    public void guardarTodo(){
         adm.guardarDatoEncriptado(ManejadorArchivos.DIRECCION, this.txtDir.getText());
        adm.guardarDatoEncriptado(ManejadorArchivos.LOGO, pathLogo);
        adm.guardarDatoEncriptado(ManejadorArchivos.BYTES_LOGO, Encriptacion.getInstacncia().bytestoString(logo));
        adm.guardarDatoEncriptado(ManejadorArchivos.CIUDAD, this.cmbCiu.getSelectedItem().toString());
        adm.guardarDatoEncriptado(ManejadorArchivos.PREFIJO, this.txtPrefijo.getText());
        if (this.jCheckImg.isSelected()) {
            adm.guardarDatoEncriptado(ManejadorArchivos.UTL_LOGO, "0");
        } else {
            adm.guardarDatoEncriptado(ManejadorArchivos.UTL_LOGO, "1");
        }
         adm.guardarDatoEncriptado(ManejadorArchivos.CANT1, txtCant1.getText());
        adm.guardarDatoEncriptado(ManejadorArchivos.TMP1, jcb1.getSelectedItem().toString());
        adm.guardarDatoEncriptado(ManejadorArchivos.CANT2, txtCant2.getText());
        adm.guardarDatoEncriptado(ManejadorArchivos.TMP2, jcb2.getSelectedItem().toString());
        if (jCheck.isSelected()) {
            adm.guardarDatoEncriptado(ManejadorArchivos.ACTIVO, "1");
            // System.out.println("ESTOY DESACTIVADO GUARDE:" + 1);
        } else {
            adm.guardarDatoEncriptado(ManejadorArchivos.ACTIVO, "0");
            //System.out.println("ESTOY ACTIVADO GUARDE:" + 0);
        }
         adm.guardarDatoEncriptado(ManejadorArchivos.STM, txtStock.getText());
        String imprimirTiquete;
        if (rdbSi.isSelected()) {
            imprimirTiquete = "0";
        } else {
            imprimirTiquete = "1";
        }
        adm.guardarDatoEncriptado(ManejadorArchivos.ITV, imprimirTiquete);
        cargarDatosSistema();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAplicarInfo;
    private javax.swing.JButton btnAplicarMensajes;
    private javax.swing.JButton btnCambioStock;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLogo;
    private javax.swing.JComboBox cmbCiu;
    private javax.swing.JComboBox cmbDep;
    private javax.swing.ButtonGroup grupoTiquete;
    private javax.swing.JCheckBox jCheck;
    private javax.swing.JCheckBox jCheckImg;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox jcb1;
    private javax.swing.JComboBox jcb2;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lbl6;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNit;
    private javax.swing.JLabel lblNombreC;
    private javax.swing.JLabel lblRazonSocial;
    private javax.swing.JLabel lblTpv;
    private javax.swing.JPanel pnlInfo;
    private javax.swing.JRadioButton rdbNo;
    private javax.swing.JRadioButton rdbSi;
    private javax.swing.JTextField txtCant1;
    private javax.swing.JTextField txtCant2;
    private javax.swing.JTextField txtDir;
    private javax.swing.JTextField txtPrefijo;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
