package vista;

import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import utilidades.Utilidades;

/**
 *
 * @author Hector Sanchez G
 */
public class Recogidas extends javax.swing.JDialog implements IStandardFocos {

    public FachadaInterfaz fachada;

   
    public Recogidas() {
        initComponents();
        this.setModal(true);
        this.setLocationRelativeTo(null);
        this.fachada = FachadaInterfaz.getInstancia();
        cargarCombo();
    }


    private void cargarCombo(){
        this.cmbSuper.setModel(new ModeloCombo(fachada.getSupervisores()));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbSuper = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObs = new javax.swing.JTextArea();
        btnCancelar = new javax.swing.JButton();
        btnRecoger = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createTitledBorder("Recogidas Parciales")));

        jLabel1.setText("Cantidad");

        txtCantidad.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
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

        jLabel3.setText("Supervisor");

        cmbSuper.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sup1", "Sup2", "Sup3" }));

        txtObs.setColumns(20);
        txtObs.setRows(5);
        txtObs.setBorder(javax.swing.BorderFactory.createTitledBorder("Observaciones"));
        jScrollPane1.setViewportView(txtObs);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(49, 49, 49)
                        .addComponent(cmbSuper, 0, 185, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbSuper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnRecoger.setText("Recoger");
        btnRecoger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecogerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(btnRecoger, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRecoger)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRecogerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecogerActionPerformed
         try {
            double monto = Utilidades.quitarFormatoNumero(txtCantidad.getText());
       
            if (monto > 0) {
                fachada.pagoATerceros(monto, null, null,txtObs.getText(),"","RECOGIDA",this.cmbSuper.getSelectedItem().toString(),"EFECTIVO");
                this.dispose();
            } else {
                new DialogoError("Solo se permiten valores reales", null);
            }
        } catch (java.lang.NumberFormatException nfe) {
            new DialogoError("Debe Ingresar el Valor a Cancelar", nfe);
        }catch(java.lang.NullPointerException npe){
            new DialogoError("Debe Seleccionar un Supervisor", npe);
        }
    }//GEN-LAST:event_btnRecogerActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.cmbSuper.requestFocus(true);
        }
    }//GEN-LAST:event_txtCantidadKeyReleased
/*
    private void setFocoGanado(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_setFocoGanado
        // TODO add your handling code here:
    }//GEN-LAST:event_setFocoGanado

private void setFocoPerdido(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_setFocoPerdido
// TODO add your handling code here:
}//GEN-LAST:event_setFocoPerdido
*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRecoger;
    private javax.swing.JComboBox cmbSuper;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextArea txtObs;
    // End of variables declaration//GEN-END:variables

    public void establecerFoco() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setFocoGanado(FocusEvent evt) {
        txtCantidad.setBackground(FOCO_GANADO);
        txtCantidad.selectAll();
    }

    public void setFocoPerdido(FocusEvent evt) {
         String str = txtCantidad.getText();
        txtCantidad.setText(Utilidades.darFormatoEspecial(Integer.parseInt(Utilidades.contenidoCajaTexto(str))));
        txtCantidad.setBackground(FOCO_PERDIDO);
        this.cmbSuper.requestFocus(true);
    }

}
