package vista;

import java.awt.event.FocusEvent;
import utilidades.Utilidades;

/**
 *
 * @author Kymera Systems SAS
 */
public class Pagos extends javax.swing.JDialog implements IStandardFocos{

    private String Supervisor;

    /** Creates new form Recogidas */
    public Pagos() {
        initComponents();
        this.setModal(true);
        this.setLocationRelativeTo(null);
        this.cargarCombo(1);
    }

    public void setSupervisor(String Supervisor) {
        this.Supervisor = Supervisor;
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        lblProv = new javax.swing.JLabel();
        cmbProveedor = new javax.swing.JComboBox();
        lblFac = new javax.swing.JLabel();
        txtFac = new javax.swing.JTextField();
        rbtProv = new javax.swing.JRadioButton();
        rbtEmp = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObs = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        btnPagar = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createTitledBorder("Pagos Especiales")));

        jLabel1.setText("Monto");

        txtCantidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                setFocoGanado(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                setFocoPerdido(evt);
            }
        });
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadKeyReleased(evt);
            }
        });

        lblProv.setText("Proveedor");

        cmbProveedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PROVEEDOR 1", "PROVEEDOR 1", "PROVEEDOR 1", "PROVEEDOR 1" }));

        lblFac.setText("Factura No.");

        txtFac.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                setFocoGanado(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                setFocoPerdido(evt);
            }
        });

        buttonGroup1.add(rbtProv);
        rbtProv.setSelected(true);
        rbtProv.setText("a Proveedor");
        rbtProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtProvActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtEmp);
        rbtEmp.setText("a Empleado");
        rbtEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtEmpActionPerformed(evt);
            }
        });

        txtObs.setColumns(20);
        txtObs.setRows(5);
        txtObs.setBorder(javax.swing.BorderFactory.createTitledBorder("Observaciones"));
        txtObs.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                setFocoGanado(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                setFocoPerdido(evt);
            }
        });
        jScrollPane1.setViewportView(txtObs);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rbtProv)
                        .addGap(50, 50, 50)
                        .addComponent(rbtEmp)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblFac)
                                .addGap(46, 46, 46)
                                .addComponent(txtFac, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(lblProv))
                                .addGap(57, 57, 57)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbProveedor, 0, 191, Short.MAX_VALUE)
                                    .addComponent(txtCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE))
                        .addGap(23, 23, 23))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtEmp)
                    .addComponent(rbtProv))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProv))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFac))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnPagar.setText("Pagar");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnPagar))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbtEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtEmpActionPerformed
        this.lblProv.setText("Personal");
        this.txtFac.setVisible(false);
        this.lblFac.setVisible(false);
        this.cargarCombo(2);

    }//GEN-LAST:event_rbtEmpActionPerformed

    private void rbtProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtProvActionPerformed
        this.lblProv.setText("Proveedor");
        this.txtFac.setVisible(true);
        this.lblFac.setVisible(true);
        this.cargarCombo(1);
    }//GEN-LAST:event_rbtProvActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        try {
            double monto = Utilidades.quitarFormatoNumero(txtCantidad.getText());

            String tercero = this.getTercero();
            if (monto > 0) {
                FachadaInterfaz.getInstancia().pagoATerceros(monto, tercero, txtFac.getText(),txtObs.getText(),this.cmbProveedor.getSelectedItem().toString(),"PAGO",Supervisor,"EFECTIVO");
                this.dispose();
            } else {
                new DialogoError("Solo se permiten valores reales", null);
            }
        } catch (java.lang.NumberFormatException nfe) {
            new DialogoError("Debe Ingresar el Valor a Cancelar", nfe);
        } catch (java.lang.NullPointerException nfe) {
            new DialogoError("Debe Seleccionar la Persona que recibe el pago", nfe);
        }
    }//GEN-LAST:event_btnPagarActionPerformed
/*
    private void setFocoGanado(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_setFocoGanado
        // TODO add your handling code here:
    }//GEN-LAST:event_setFocoGanado

private void setFocoPerdido(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_setFocoPerdido
// TODO add your handling code here:
}//GEN-LAST:event_setFocoPerdido
*/
private void txtCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyReleased
    if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){
        this.cmbProveedor.requestFocus(true);
    }
}//GEN-LAST:event_txtCantidadKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPagar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cmbProveedor;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFac;
    private javax.swing.JLabel lblProv;
    private javax.swing.JRadioButton rbtEmp;
    private javax.swing.JRadioButton rbtProv;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtFac;
    private javax.swing.JTextArea txtObs;
    // End of variables declaration//GEN-END:variables

    private String getTercero() {
        if (this.rbtEmp.isSelected()) {
            return "EMPLEADO";
        } else {
            return "PROVEEDOR";
        }
    }

    private void cargarCombo(int dato) {
        switch(dato){
            case 1:{
                this.cmbProveedor.setModel(new ModeloCombo(FachadaInterfaz.getInstancia().getProveedores()));
                break;
            }
            case 2:{
                this.cmbProveedor.setModel(new ModeloCombo(FachadaInterfaz.getInstancia().getEmpleados()));
                break;
            }
        }
    }

    public void establecerFoco() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setFocoPerdido(FocusEvent evt) {
        evt.getComponent().setBackground(FOCO_PERDIDO);
        if(evt.getSource().equals(this.txtCantidad)){
            String str = txtCantidad.getText();
            txtCantidad.setText(Utilidades.darFormatoEspecial(Integer.parseInt(Utilidades.contenidoCajaTexto(str))));
            this.cmbProveedor.requestFocus(true);
        }
    }

    public void setFocoGanado(FocusEvent evt) {
        evt.getComponent().setBackground(FOCO_GANADO);
    }
}
