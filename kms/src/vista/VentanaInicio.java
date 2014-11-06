package vista;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Kymera Systems SAS
 */
public class VentanaInicio extends JFrame {

    protected Color FOCO_GANADO = new Color(231, 251, 252);
    protected Color FOCO_PERDIDO = new Color(255, 255, 255);
    private FachadaInterfaz fachada;
    private boolean iniciaApliacion;
    private MenuVista menu;

    public VentanaInicio(boolean iniciaApliacion) {
        super("KYMERA MANAGER SYSTEM");
        this.iniciaApliacion = iniciaApliacion;
        this.fachada = FachadaInterfaz.getInstancia();
        initComponents();
        setIconImage(new Imagenes().getIcono());
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        menu = MenuVista.getInstancia();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JPasswordField();
        btnIniciarCaja = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(199, 195, 191));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ingreso al sistema KMS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("URW Gothic L", 1, 13))); // NOI18N

        jLabel1.setText("Usuario:");

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
                    .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
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
                .addGap(56, 56, 56))
        );

        btnIniciarCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cliente30.png"))); // NOI18N
        btnIniciarCaja.setText("Ingresar");
        btnIniciarCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarCajaActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/X2.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Logo100x100.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(btnIniciarCaja)
                        .addGap(29, 29, 29)
                        .addComponent(btnCancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIniciarCaja, 0, 0, Short.MAX_VALUE))
                .addContainerGap())
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
    this.dispose();
}//GEN-LAST:event_btnCancelarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnIniciarCaja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    public void establecerFoco() {
        txtUsuario.requestFocus(true);
    }

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
            JOptionPane.showMessageDialog(null, "Debe Llenar los todos los Campos", "Error al Ingresar a KMS", JOptionPane.ERROR_MESSAGE);

        } else if (fachada.validarUsuario(txtUsuario.getText(), txtContrasena.getText())) {

            if (iniciaApliacion) {            
                menu.cargarVista();
                menu.setVisible(true);         
            }
            menu.iniciarSistema();
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Error: Usuario o Contraseña No valido");
        }
    }

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
