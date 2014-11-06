package vista;

import control.ObservadorEventos;
import control.RegistrosGenerales;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import utilidades.InvalidException;

/**
 *
 * @author Kymera Systems SAS
 */
public class ProveedorVista extends VentanaInternaAbs implements ObservadorEventos {

    private FachadaInterfaz fachada;

    public ProveedorVista() {
        initComponents();
        fachada = FachadaInterfaz.getInstancia();
        fachada.getPtoVenta().addEscuchadorEventos(this);
        jcbCiudad.setModel(new ModeloCombo());
        cargarComboDptos();
        comboCargos();
        fachada.cargarProveedor(fachada.PRIMERO);
        if (txtID.getText().equals("")) {
            habilitarCampos(false);
            this.btnGuardar.setText("Agregar");
        } else {
            habilitarCampos(false);
            this.btnGuardar.setText("Modificar");
        }
        escuchador();

        if(control.PuntoDeVenta.usuarioActual.getPermisos() == control.PuntoDeVenta.CAJERO ){
            this.btnEliminar.setVisible(false);
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtRazonSocial = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jcbCiudad = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jcbCargoContacto = new javax.swing.JComboBox();
        txtContacto = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jcbDepartamento = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        navegador1 = new panel.Navegador();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Proveedor"));

        jLabel1.setText("NIT");

        jLabel2.setText("Razon Social");

        jLabel3.setText("Direccion");

        jLabel4.setText("Telefono");

        jLabel5.setText("Ciudad");

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        jLabel6.setText("Contacto");

        jLabel7.setText("Cargo Contacto");

        jLabel8.setText("Email");

        jcbDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbDepartamentoActionPerformed(evt);
            }
        });

        jLabel9.setText("Departamento");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(168, 168, 168)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(152, 152, 152))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtID, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                                .addGap(195, 195, 195))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                .addGap(189, 189, 189))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(132, 132, 132))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(152, 152, 152)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jcbCargoContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55))
                            .addComponent(txtContacto, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jcbCiudad, javax.swing.GroupLayout.Alignment.LEADING, 0, 117, Short.MAX_VALUE)
                                    .addComponent(jcbDepartamento, javax.swing.GroupLayout.Alignment.LEADING, 0, 117, Short.MAX_VALUE))
                                .addGap(54, 54, 54)))
                        .addGap(116, 116, 116)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE))
                    .addComponent(txtID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE))
                    .addComponent(txtRazonSocial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE))
                    .addComponent(txtDireccion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE))
                    .addComponent(txtTelefono))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE))
                    .addComponent(jcbDepartamento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE))
                    .addComponent(jcbCiudad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE))
                    .addComponent(txtContacto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE))
                    .addComponent(jcbCargoContacto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE))
                    .addComponent(txtEmail))
                .addGap(18, 18, 18))
        );

        jToolBar1.setRollover(true);

        btnAgregar.setText("Agregar");
        btnAgregar.setFocusable(false);
        btnAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAgregar);

        btnEliminar.setText("Eliminar");
        btnEliminar.setFocusable(false);
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEliminar);

        btnBuscar.setText("Buscar");
        btnBuscar.setFocusable(false);
        btnBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnBuscar);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(btnGuardar)
                .addContainerGap(203, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(navegador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(264, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(navegador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGuardar)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        limpiar();
        habilitarCampos(true);
        this.btnGuardar.setText("Guardar");
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            if (this.btnGuardar.getText().equals("Guardar")) {
                fachada.proveedor(pasarDatos(), FachadaInterfaz.INSERTAR);
                habilitarCampos(false);
            } else if (this.btnGuardar.getText().equals("Modificar")) {
                habilitarCampos(true);
                txtID.setEnabled(false);
                this.btnGuardar.setText("Actualizar");
            } else if (this.btnGuardar.getText().equals("Actualizar")) {
                fachada.proveedor(pasarDatos(), FachadaInterfaz.MODIFICAR);
                habilitarCampos(false);
            } else if (this.btnGuardar.getText().equals("Agregar")) {
                habilitarCampos(true);
                this.btnGuardar.setText("Guardar");
            }
        } catch (InvalidException ex) {
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (!txtID.getText().equals("")) {
            int r = JOptionPane.showConfirmDialog(null, "Esta Seguro De Eliminar Este Registro?", "Eliminar Registro", JOptionPane.YES_NO_CANCEL_OPTION);
            if (r == 0) {
                fachada.proveedor(txtID.getText(), FachadaInterfaz.ELIMINAR);
                limpiar();


            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        new BuscarProvVista(MenuVista.getInstancia());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jcbDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbDepartamentoActionPerformed
        int dpto = this.jcbDepartamento.getSelectedItem().hashCode();
        this.cargarComboCiudad(dpto);
    }//GEN-LAST:event_jcbDepartamentoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JComboBox jcbCargoContacto;
    private javax.swing.JComboBox jcbCiudad;
    private javax.swing.JComboBox jcbDepartamento;
    private panel.Navegador navegador1;
    private javax.swing.JTextField txtContacto;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtRazonSocial;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    private ArrayList pasarDatos() throws InvalidException {
        ArrayList datos = new ArrayList();
        if (!txtID.getText().isEmpty()) {
            datos.add(txtID.getText());
        } else {
            throw new InvalidException("Debe de Ingresar Un ID");
        }

        datos.add(txtRazonSocial.getText());
        datos.add(txtDireccion.getText());
        datos.add(txtTelefono.getText());
        if (((ModeloCombo) jcbCiudad.getModel()).getSelectedIndex() != null) {
            datos.add(((ModeloCombo) jcbCiudad.getModel()).getSelectedIndex());
        } else {
            throw new InvalidException("Seleccione una Ciudad");
        }

        datos.add(txtContacto.getText());
        datos.add(((ModeloCombo) jcbCargoContacto.getModel()).getSelectedIndex());
        datos.add(txtEmail.getText());
        return datos;
    }

    public void escuchadorEvento(Object obj, String propiedad, Object vl) {
        List valor;
        if (propiedad.equals(RegistrosGenerales.CARGAR_PROVEEDOR)) {
            valor = (List) vl;
            ponerDatos(valor);
        }else if(propiedad.equals(control.PuntoDeVenta.DATOS_PRV_ENCON)){
            valor = (List) vl;
            ponerDatos(valor);
            /*fachada.buscar(dato.get(0).toString(),control.CatalogosManager.PROVEEDOR);
            System.out.println(dato.get(0).toString());*/
        }
    }

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
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void comboCargos() {
        jcbCargoContacto.setModel(new ModeloCombo(fachada.getCargos()));
        jcbCargoContacto.updateUI();
    }

    private void limpiar() {
        txtID.setText("");
        txtRazonSocial.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtContacto.setText("");
        txtEmail.setText("");
    }

    public void ponerDatos(List vl) {
        txtID.setText((String) vl.get(0));
        txtRazonSocial.setText((String) vl.get(1));
        txtDireccion.setText((String) vl.get(2));
        txtTelefono.setText((String) vl.get(3));
        ((ModeloCombo) jcbCiudad.getModel()).setSelectedItem(fachada.getCiudad(vl.get(4).toString()));
        jcbCiudad.updateUI();
        txtContacto.setText((String) vl.get(5));
        ((ModeloCombo) jcbCargoContacto.getModel()).setSelectedItemMap(vl.get(6));
        txtEmail.setText((String) vl.get(7));
    }

    private void habilitarCampos(boolean b) {
        txtID.setEnabled(b);
        txtRazonSocial.setEnabled(b);
        txtDireccion.setEnabled(b);
        txtTelefono.setEnabled(b);
        txtContacto.setEnabled(b);
        txtEmail.setEnabled(b);
        jcbCiudad.setEnabled(b);
        jcbCargoContacto.setEnabled(b);
        this.jcbDepartamento.setEnabled(b);
    }

    public void cambiarEstados(boolean b) {
        habilitarCampos(b);
        this.btnGuardar.setText("Modificar");
    }

    public void cargarComboDptos() {
        this.jcbDepartamento.setModel(new ModeloCombo(fachada.getDpto()));

    }

    public void cargarComboCiudad(int dpto) {
        this.jcbCiudad.setModel(new ModeloCombo(fachada.getCiudad(dpto)));
        jcbCiudad.updateUI();
    }

    public void escuchador() {
        navegador1.lblPrimero.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fachada.cargarProveedor(fachada.PRIMERO);
                habilitarCampos(false);
            }
        });

        navegador1.lblAnterior.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fachada.cargarProveedor(fachada.ANTERIOR);
                habilitarCampos(false);
            }
        });
        navegador1.lblSiguiente.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fachada.cargarProveedor(fachada.SIGUIENTE);
                habilitarCampos(false);
            }
        });
        navegador1.lblUltimo.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fachada.cargarProveedor(fachada.ULTIMO);
                habilitarCampos(false);
            }
        });
    }
}
