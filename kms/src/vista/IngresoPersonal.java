package vista;

import control.ObservadorEventos;

import control.RegistrosGenerales;
import utilidades.Utilidades;
import java.awt.Image;
import java.awt.event.FocusEvent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import utilidades.InvalidException;

/**
 *
 * @author MindSoft
 */
public class IngresoPersonal extends VentanaInternaAbs implements ObservadorEventos {

    private JFileChooser fc;
    public String ruta;
    private static FachadaInterfaz fachada;
    private File files;

    public IngresoPersonal() {

        initComponents();
        habilitarCampos(false);
        fachada = FachadaInterfaz.getInstancia();
        fachada.ptoVenta.removeEscuchadorEventos(this);
        fachada.ptoVenta.addEscuchadorEventos(this);
        cargarComboCargos();
        this.jcbCiudad.setModel(new ModeloCombo());
        this.jcbCiudadNacimiento.setModel(new ModeloCombo());
        this.cargarComboDptos();
        fachada.cargarPersonal(fachada.PRIMERO);
        if (txtCedula.getText().equals("")) {
            this.btnGuardar.setText("Agregar");
        } else {
            this.btnGuardar.setText("Modificar");
        }
        escuchador();
        this.setVisible(true);


    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        M = new javax.swing.JRadioButton();
        F = new javax.swing.JRadioButton();
        fechaNacimiento = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        txtLibretaMilitar = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jcbEstadoCivil = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jcbDptoN = new javax.swing.JComboBox();
        jLabel22 = new javax.swing.JLabel();
        jcbDpto = new javax.swing.JComboBox();
        jcbCiudadNacimiento = new javax.swing.JComboBox();
        jLabel23 = new javax.swing.JLabel();
        jcbCiudad = new javax.swing.JComboBox();
        jLabel24 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblfoto = new javax.swing.JLabel();
        btnCargarFoto = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        txtTelefono = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        fecha_ingreso = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        tipo_contratacion = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        SI = new javax.swing.JRadioButton();
        NO = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        activo = new javax.swing.JCheckBox();
        jLabel17 = new javax.swing.JLabel();
        jcbCargo = new javax.swing.JComboBox();
        fecha_salida = new com.toedter.calendar.JDateChooser();
        lblFechaSalida = new javax.swing.JLabel();
        btnOtro = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jAreaObs = new javax.swing.JTextArea();
        btnGuardar = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        btnAgregar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        navegador1 = new panel.Navegador();

        jLabel1.setText("Cedula"); // NOI18N

        jLabel2.setText("Nombres"); // NOI18N

        jLabel3.setText("Apellidos"); // NOI18N

        jLabel4.setText("Genero"); // NOI18N

        jLabel5.setText("Fecha Nacimiento"); // NOI18N

        buttonGroup2.add(M);
        M.setSelected(true);
        M.setText("M"); // NOI18N

        buttonGroup2.add(F);
        F.setText("F"); // NOI18N

        jLabel6.setText("Libreta Militar"); // NOI18N

        jLabel11.setText("Estado Civil"); // NOI18N

        jcbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Soltero", "Casado", "Union Libre", "Divorciado", "Viudo" }));

        jLabel7.setText("Direccion"); // NOI18N

        jLabel21.setText("Departamento Nacimiento");

        jcbDptoN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbDptoNActionPerformed(evt);
            }
        });

        jLabel22.setText("Departamento");

        jcbDpto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbDptoActionPerformed(evt);
            }
        });

        jLabel23.setText("Ciudad Nacimiento");

        jLabel24.setText("Ciudad");

        jPanel5.setBackground(new java.awt.Color(218, 220, 233));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        lblfoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/NoPicture.JPG"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblfoto, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblfoto, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
        );

        btnCargarFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cargar.png"))); // NOI18N
        btnCargarFoto.setText("Cargar Foto"); // NOI18N
        btnCargarFoto.setBorderPainted(false);
        btnCargarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarFotoActionPerformed(evt);
            }
        });

        jLabel9.setText("Celular"); // NOI18N

        jLabel8.setText("Telefono"); // NOI18N

        jLabel12.setText("Email"); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12))
                .addGap(65, 65, 65)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtCelular, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel21)
                    .addComponent(jLabel23)
                    .addComponent(jLabel6)
                    .addComponent(jLabel11)
                    .addComponent(jLabel7)
                    .addComponent(jLabel24)
                    .addComponent(jLabel22))
                .addGap(49, 49, 49)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jcbCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtApellidos)
                                    .addComponent(txtCedula, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombres, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(M)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(F))
                                .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                .addComponent(jcbDptoN, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(fechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                .addComponent(jcbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtLibretaMilitar, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcbCiudadNacimiento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(33, 33, 33)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnCargarFoto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jcbDpto, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap()))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCargarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
                                .addGap(17, 17, 17)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
                                .addGap(17, 17, 17)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
                                .addGap(17, 17, 17)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
                                .addGap(17, 17, 17)
                                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombres, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                                .addGap(8, 8, 8)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(M, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(F, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcbDptoN, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbCiudadNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtLibretaMilitar, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbEstadoCivil, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbDpto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Datos Basicos", jPanel1);

        jLabel10.setText("Fecha Ingreso"); // NOI18N

        jLabel13.setText("Tipo Contratacion"); // NOI18N

        tipo_contratacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Contrato a Término Fijo", "Contrato a Término Indefinido", "Contrato por Prestacion de Servicios" }));

        jLabel14.setText("Certificado Manipulacion"); // NOI18N

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("De Alimentos"); // NOI18N

        buttonGroup1.add(SI);
        SI.setSelected(true);
        SI.setText("SI"); // NOI18N

        buttonGroup1.add(NO);
        NO.setText("NO"); // NOI18N

        jLabel16.setText("Estado"); // NOI18N

        activo.setSelected(true);
        activo.setText("Activo"); // NOI18N
        activo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activoActionPerformed(evt);
            }
        });

        jLabel17.setText("Cargo"); // NOI18N

        jcbCargo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblFechaSalida.setText("Fecha Salida"); // NOI18N

        btnOtro.setText("Otro");
        btnOtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel13)
                            .addComponent(lblFechaSalida)
                            .addComponent(jLabel16)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel10))
                        .addGap(112, 112, 112)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SI)
                            .addComponent(NO)
                            .addComponent(activo)
                            .addComponent(fecha_salida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tipo_contratacion, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                                    .addComponent(jcbCargo, javax.swing.GroupLayout.Alignment.LEADING, 0, 166, Short.MAX_VALUE)
                                    .addComponent(fecha_ingreso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnOtro)))
                        .addGap(170, 170, 170))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                        .addGap(5, 5, 5)
                        .addComponent(lblFechaSalida, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jcbCargo, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                            .addComponent(btnOtro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fecha_ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(tipo_contratacion, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SI, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NO, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(activo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(5, 5, 5)
                        .addComponent(fecha_salida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Observacion"));

        jAreaObs.setColumns(20);
        jAreaObs.setRows(5);
        jScrollPane1.setViewportView(jAreaObs);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Datos Laborales", jPanel2);

        btnGuardar.setText("Guardar"); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

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

        jButton1.setText("Eliminar"); // NOI18N
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(266, 266, 266)
                .addComponent(btnGuardar)
                .addContainerGap(356, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(navegador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(489, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(navegador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarFotoActionPerformed
        fc = new JFileChooser();
        //AL JFILECHOOSER SE LE AGRAGA UN COMPONENTE QUE ES LA VISTA PREVIA DE LAS
        //IMAGENES SELECCIONADAS
        fc.setAccessory(new ImagenPrevia(fc));
        int returnValue = fc.showDialog(IngresoPersonal.this, "Abrir");
        //SI HACE CLIC EN ABRIR
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            //GUARDA LA RUTA DE LA IMAGEN
            ruta = file.getAbsolutePath();
            System.out.println(ruta);
            files = new File(ruta);
            ImageIcon img = new ImageIcon(file.getAbsolutePath());
            //AJUSTAMOS LA IMAGEN EN CASO DE QUE SEA MUY GRANDE A LA MEDIDA DEL PANEL

            ponerFoto(img);

        }
}//GEN-LAST:event_btnCargarFotoActionPerformed
    public void ponerFoto(ImageIcon img) {
        if (img != null) {
            if (img.getIconWidth() > 90) {
                img = new ImageIcon(img.getImage().getScaledInstance(141, 143, Image.SCALE_DEFAULT));
            }
            this.lblfoto.setIcon(img);
        }
    }
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if (this.btnGuardar.getText().equals("Guardar")) {
            try {
                fachada.personal(pasarDatos(), FachadaInterfaz.INSERTAR);
                habilitarCampos(false);
                this.btnGuardar.setText("Modificar");
            } catch (InvalidException ex) {
            }
        } else if (this.btnGuardar.getText().equals("Modificar")) {
            habilitarCampos(true);
            txtCedula.setEnabled(false);
            this.btnGuardar.setText("Actualizar");

        } else if (this.btnGuardar.getText().equals("Actualizar")) {
            try {
                fachada.personal(pasarDatos(), FachadaInterfaz.MODIFICAR);
                if(activo.isSelected()){
                    fachada.usuarios(this.txtCedula.getText(), FachadaInterfaz.ELIMINAR);
                }
                habilitarCampos(false);
                this.btnGuardar.setText("Modificar");
            } catch (InvalidException ex) {
            }

        } else if (this.btnGuardar.getText().equals("Agregar")) {
            habilitarCampos(true);
            this.btnGuardar.setText("Guardar");
        }



    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        new BuscarPersonal(MenuVista.getInstancia());

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        limpiar();
        habilitarCampos(true);
        this.btnGuardar.setText("Guardar");
        this.btnGuardar.setVisible(true);
        cargarComboCargos();
        this.jcbCiudad.setSelectedItem(null);
        this.jcbCiudadNacimiento.setSelectedItem(null);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!txtCedula.getText().equals("")) {
            int r = JOptionPane.showConfirmDialog(null, "Esta Seguro De Eliminar Este Registro?", "Eliminar Este Registro", JOptionPane.YES_NO_CANCEL_OPTION);
            if (r == 0) {
                String eliminar = txtCedula.getText();
                fachada.personal(eliminar, FachadaInterfaz.ELIMINAR);
                limpiar();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debe Seleccionar Personal");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void activoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activoActionPerformed
        if (activo.isSelected()) {
            this.lblFechaSalida.setVisible(false);
            this.fecha_salida.setVisible(false);
        } else if (!activo.isSelected()) {
            this.lblFechaSalida.setVisible(true);
            this.fecha_salida.setVisible(true);
        }
    }//GEN-LAST:event_activoActionPerformed

    private void jcbDptoNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbDptoNActionPerformed
        int dpto = this.jcbDptoN.getSelectedItem().hashCode();
        this.cargarComboCiudadN(dpto);
    }//GEN-LAST:event_jcbDptoNActionPerformed

    private void jcbDptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbDptoActionPerformed
        int dpto = this.jcbDpto.getSelectedItem().hashCode();
        this.cargarComboCiudad(dpto);
    }//GEN-LAST:event_jcbDptoActionPerformed

    private void btnOtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtroActionPerformed
        IngresoCategoria ingCargo = new IngresoCategoria();
        IngresoCategoria.identificador(3);
    }//GEN-LAST:event_btnOtroActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton F;
    private javax.swing.JRadioButton M;
    private javax.swing.JRadioButton NO;
    private javax.swing.JRadioButton SI;
    private javax.swing.JCheckBox activo;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCargarFoto;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnOtro;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private com.toedter.calendar.JDateChooser fechaNacimiento;
    private com.toedter.calendar.JDateChooser fecha_ingreso;
    private com.toedter.calendar.JDateChooser fecha_salida;
    private javax.swing.JTextArea jAreaObs;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private static javax.swing.JComboBox jcbCargo;
    private javax.swing.JComboBox jcbCiudad;
    private javax.swing.JComboBox jcbCiudadNacimiento;
    private javax.swing.JComboBox jcbDpto;
    private javax.swing.JComboBox jcbDptoN;
    private javax.swing.JComboBox jcbEstadoCivil;
    private javax.swing.JLabel lblFechaSalida;
    private javax.swing.JLabel lblfoto;
    private panel.Navegador navegador1;
    private javax.swing.JComboBox tipo_contratacion;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLibretaMilitar;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    public void escuchadorEvento(Object obj, String propiedad, Object vl) {
        List valor = null;
        if (propiedad.equals(RegistrosGenerales.CARGAR_PERSONAL)) {
            valor = (List) vl;
            try {
                ponerDatos(valor);
            } catch (IOException ex) {
                Logger.getLogger(IngresoPersonal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (propiedad.equals(control.PuntoDeVenta.DATOS_PER_ENCON)) {
            List dato = (List) vl;
            fachada.buscar(dato.get(0).toString(), control.CatalogosManager.PERSONAL);
        }
    }

    @Override
    public void establecerFoco() {
    }

    @Override
    public void setFocoGanado(FocusEvent evt) {
    }

    @Override
    public void setFocoPerdido(FocusEvent evt) {
    }

    public ArrayList pasarDatos() throws InvalidException {

        ArrayList datos = new ArrayList();
        if (!txtCedula.getText().isEmpty()) {
            datos.add(txtCedula.getText());
        } else {
            throw new InvalidException("Debe de Ingresar La Cedula");
        }
        if (!txtNombres.getText().isEmpty()) {
            datos.add(txtNombres.getText());
        } else {
            throw new InvalidException("Debe de Ingresar Un Nombre");
        }

        datos.add(txtApellidos.getText());
        if (F.isSelected()) {
            datos.add("F");
        } else if (M.isSelected()) {
            datos.add("M");
        }
        datos.add(fechaNacimiento.getDate());
        if (((ModeloCombo) this.jcbCiudadNacimiento.getModel()).getSelectedIndex() != null) {
            datos.add(((ModeloCombo) this.jcbCiudadNacimiento.getModel()).getSelectedIndex());
        } else {
            throw new InvalidException("Seleccione Una Ciudad de Nacimiento");
        }
        datos.add(txtLibretaMilitar.getText());
        datos.add(txtDireccion.getText());
        datos.add(txtTelefono.getText());
        datos.add(txtCelular.getText());
        if (((ModeloCombo) this.jcbCiudad.getModel()).getSelectedIndex() != null) {
            datos.add(((ModeloCombo) this.jcbCiudad.getModel()).getSelectedIndex());
        } else {
            throw new InvalidException("Seleccione la Ciudad Actual");
        }
        datos.add(txtEmail.getText());
        if (((ModeloCombo) this.jcbCargo.getModel()).getSelectedIndex() != null) {
            datos.add(((ModeloCombo) jcbCargo.getModel()).getSelectedIndex());
        } else {
            throw new InvalidException("Seleccione Un Cargo");
        }
        datos.add(fecha_ingreso.getDate());
        datos.add(fecha_salida.getDate());
        datos.add((String) tipo_contratacion.getSelectedItem());
        if (SI.isSelected()) {
            datos.add("SI");
        } else if (NO.isSelected()) {
            datos.add("NO");
        }
        if (activo.isSelected()) {
            datos.add("ACTIVO");

        } else if (!activo.isSelected()) {
            datos.add("NO ACTIVO");
        }
        datos.add(jAreaObs.getText());
        if (lblfoto.getIcon() == null) {
            datos.add(null);
        } else {
            Icon im = lblfoto.getIcon();
            datos.add(utilidades.Utilidades.toByteArray(im, this));
        }
        datos.add((String) jcbEstadoCivil.getSelectedItem());
        return datos;

    }

    public void ponerDatos(List valor) throws IOException {

        txtCedula.setText((String) valor.get(0));
        txtNombres.setText((String) valor.get(1));
        txtApellidos.setText((String) valor.get(2));
        if (((String) valor.get(3)).equals("F")) {
            F.setSelected(true);
        } else {
            M.setSelected(true);
        }
        fechaNacimiento.setDate(Utilidades.stringtoDate((String) valor.get(4)));
        ((ModeloCombo) this.jcbCiudadNacimiento.getModel()).setSelectedItem(fachada.getCiudad(valor.get(5).toString()));
        txtLibretaMilitar.setText((String) valor.get(6));
        txtDireccion.setText((String) valor.get(7));
        txtTelefono.setText((String) valor.get(8));
        txtCelular.setText((String) valor.get(9));
        ((ModeloCombo) this.jcbCiudad.getModel()).setSelectedItem(fachada.getCiudad(valor.get(10).toString()));
        txtEmail.setText((String) valor.get(11));
        ((ModeloCombo) jcbCargo.getModel()).setSelectedItemMap(valor.get(12));
        fecha_ingreso.setDate(Utilidades.stringtoDate((String) valor.get(13)));
        fecha_salida.setDate(Utilidades.stringtoDate((String) valor.get(14)));
        tipo_contratacion.setSelectedItem(valor.get(15));
        if (valor.get(16).toString().equals("NO")) {
            NO.setSelected(true);
        } else {
            SI.setSelected(true);
        }
        if (valor.get(17).toString().equals("ACTIVO")) {
            activo.setSelected(true);
            fecha_salida.setVisible(false);
        } else {
            activo.setSelected(false);
            fecha_salida.setVisible(true);
        }
        jAreaObs.setText((String) valor.get(18));
        if (valor.get(19) == null) {
            ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/NoPicture.JPG"));
            ponerFoto(icon);
        } else {
            byte[] u = (byte[]) valor.get(19);
            ImageIcon img = new ImageIcon(u);
            ponerFoto(img);
        }
        jcbEstadoCivil.setSelectedItem(valor.get(20));
    }

    public static void cargarComboCargos() {
        jcbCargo.setModel(new ModeloCombo(fachada.getCargos()));
        jcbCargo.updateUI();
    }

    public void cargarComboCiudadN(int dpto) {
        this.jcbCiudadNacimiento.setModel(new ModeloCombo(fachada.getCiudad(dpto)));
        jcbCiudadNacimiento.updateUI();
    }

    public void cargarComboCiudad(int dpto) {
        this.jcbCiudad.setModel(new ModeloCombo(fachada.getCiudad(dpto)));
        jcbCiudad.updateUI();
    }

    public void cargarComboDptos() {
        this.jcbDptoN.setModel(new ModeloCombo(fachada.getDpto()));
        this.jcbDpto.setModel(new ModeloCombo(fachada.getDpto()));

    }

    public void habilitarCampos(boolean b) {
        txtCedula.setEnabled(b);
        txtNombres.setEnabled(b);
        txtApellidos.setEnabled(b);
        txtDireccion.setEnabled(b);
        M.setEnabled(b);
        F.setEnabled(b);
        fechaNacimiento.setEnabled(b);
        txtLibretaMilitar.setEnabled(b);
        jcbEstadoCivil.setEnabled(b);
        btnCargarFoto.setEnabled(b);
        txtTelefono.setEnabled(b);
        txtCelular.setEnabled(b);
        txtEmail.setEnabled(b);
        jcbCargo.setEnabled(b);
        fecha_ingreso.setEnabled(b);
        tipo_contratacion.setEnabled(b);
        SI.setEnabled(b);
        NO.setEnabled(b);
        activo.setEnabled(b);
        fecha_salida.setEnabled(b);
        jcbDpto.setEnabled(b);
        jcbDptoN.setEnabled(b);
        jcbCiudadNacimiento.setEnabled(b);
        jcbCiudad.setEnabled(b);

    }

    public void cambiarEstados(boolean b) {
        habilitarCampos(b);
        this.btnGuardar.setText("Modificar");
    }

    public void limpiar() {
        F.setSelected(true);
        NO.setSelected(true);
        jAreaObs.setText("");
        txtCedula.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtCelular.setText("");
        txtLibretaMilitar.setText("");
        lblfoto.setIcon(null);
        txtEmail.setText("");
        activo.setSelected(true);
        NO.setSelected(true);
        this.fecha_salida.setVisible(true);
    }

    public void escuchador() {
        navegador1.lblPrimero.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fachada.cargarPersonal(fachada.PRIMERO);
                habilitarCampos(false);
                cambiarEstados(false);
            }
        });

        navegador1.lblAnterior.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fachada.cargarPersonal(fachada.ANTERIOR);
                habilitarCampos(false);
                cambiarEstados(false);
            }
        });
        navegador1.lblSiguiente.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fachada.cargarPersonal(fachada.SIGUIENTE);
                habilitarCampos(false);
                cambiarEstados(false);
            }
        });
        navegador1.lblUltimo.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fachada.cargarPersonal(fachada.ULTIMO);
                habilitarCampos(false);
                cambiarEstados(false);
            }
        });
    }
}
