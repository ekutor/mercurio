package vista;

import control.ObservadorEventos;
import control.PuntoDeVenta;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Kymera Systems SAS
 */
public class IniciarCaja extends VentanaInternaAbs{

    private FachadaInterfaz fachada;

    public IniciarCaja() {
        this.fachada = FachadaInterfaz.getInstancia();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnIniciarCaja = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JPasswordField();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Inicio Caja"));

        jLabel1.setText("Id Cajero:");

        btnIniciarCaja.setText("Iniciar Caja");
        btnIniciarCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarCajaActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                setFocoGanado(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                setFocoPerdido(evt);
            }
        });
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyPressed(evt);
            }
        });

        jLabel2.setText("Contraseña:");

        txtContrasena.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                setFocoGanado(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                setFocoPerdido(evt);
            }
        });
        txtContrasena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContrasenaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnIniciarCaja)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addGap(8, 8, 8)))
                .addGap(38, 38, 38))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel2)
                .addGap(8, 8, 8)
                .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIniciarCaja)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/*
    private void setFocoGanado(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_setFocoGanado
    // TODO add your handling code here:
    }//GEN-LAST:event_setFocoGanado

private void setFocoPerdido(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_setFocoPerdido
    // TODO add your handling code here:
}//GEN-LAST:event_setFocoPerdido
     */
private void btnIniciarCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarCajaActionPerformed
    validarUsuario();
}//GEN-LAST:event_btnIniciarCajaActionPerformed

private void txtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        txtContrasena.requestFocus(true);
    }
}//GEN-LAST:event_txtUsuarioKeyPressed

private void txtContrasenaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContrasenaKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        validarUsuario();
    
    }
}//GEN-LAST:event_txtContrasenaKeyPressed

private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
    MenuVista.getInstancia().tabbedPane.setSelectedIndex(0);
}//GEN-LAST:event_btnCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnIniciarCaja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    @Override
    public void establecerFoco() {
        txtUsuario.requestFocus(true);
    }

    @Override
    public void setFocoGanado(FocusEvent evt) {
        if (evt.getSource().equals(txtUsuario)) {
            txtUsuario.setBackground(FOCO_GANADO);
        } else if (evt.getSource().equals(txtContrasena)) {
            txtContrasena.setBackground(FOCO_GANADO);
            txtContrasena.selectAll();
        }
    }

    public void validarUsuario() {
        if (txtUsuario.getText().equals("") || txtContrasena.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Error: Debe Llenar los todos los Campos");

        } else {
            if (fachada.validarCajero(txtUsuario.getText(), txtContrasena.getText())){
                fachada.habilitarItemBaseInicial(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Error: Usuario o Contraseña No valido");
            }
        }
    }

    @Override
    public void setFocoPerdido(FocusEvent evt) {
        if (evt.getSource().equals(txtUsuario)) {
            txtUsuario.setBackground(FOCO_PERDIDO);
        } else if (evt.getSource().equals(txtContrasena)) {
            txtContrasena.setBackground(FOCO_PERDIDO);
        }
    }
    public void botonSeleccionado(JButton boton) {
        this.getRootPane().setDefaultButton(boton);
    }
}
