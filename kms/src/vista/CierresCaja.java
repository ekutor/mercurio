package vista;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import modelo.ModeloTablaGenerico;

/**
 *
 * @author ekutor
 */
public class CierresCaja extends javax.swing.JDialog {

    private ModeloTablaGenerico modTabla;
    public static Map<Integer, Integer> saldos;

    public CierresCaja(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        String[] nombres = {"Tipo Moneda", "Cantidad"};
        initComponents();
        modTabla = new ModeloTablaGenerico();
        modTabla.establecerColumNom(nombres);
        tabla.setModel(modTabla);
//        modTabla.setTamanoColumnaTabla(tabla, nombres[0], 180);
//        modTabla.setTamanoColumnaTabla(tabla, nombres[1], 180);
        this.setLocationRelativeTo(parent);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnRecoger = new javax.swing.JButton();
        cmbMoneda = new javax.swing.JComboBox();
        txtCant = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnRealizarCierre = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tipo Moneda", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cierre de Caja", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(24, 14, 201))); // NOI18N

        btnRecoger.setText("Agregar Recogida");
        btnRecoger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecogerActionPerformed(evt);
            }
        });

        cmbMoneda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "50000", "20000", "10000", "5000", "2000", "1000", "500", "200", "100", "50", "20" }));
        cmbMoneda.setToolTipText("Debe seleccionar la moneda a recoger");
        cmbMoneda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbMonedaMouseClicked(evt);
            }
        });
        cmbMoneda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbMonedaKeyPressed(evt);
            }
        });

        txtCant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantKeyPressed(evt);
            }
        });

        jLabel1.setText("Moneda");

        jLabel2.setText("Cantidad");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(cmbMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRecoger)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtCant, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txtCant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(btnRecoger)
                .addContainerGap())
        );

        btnRealizarCierre.setText("Realizar Cierre");
        btnRealizarCierre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarCierreActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnRealizarCierre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRealizarCierre)
                    .addComponent(jButton2))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRealizarCierreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarCierreActionPerformed
        int opcion = JOptionPane.showConfirmDialog(this,
                "Esta seguro de realizar el Cierre de Caja", "Cierre de Caja Diario",
                JOptionPane.YES_NO_CANCEL_OPTION);
        if (opcion == 0) {
            MenuVista.IniciarSistema = true;
            saldos = new HashMap();
            List<List> datos = modTabla.getDatos();
            for (List l : datos) {
                int key = Integer.parseInt(l.get(0).toString());
                int value = Integer.parseInt(l.get(1).toString());
                if (saldos.containsKey(key)) {
                    value += saldos.get(key);
                }
                saldos.put(key, value);
            }
            this.dispose();
            FachadaInterfaz.getInstancia().realizarCierre(saldos);
        }else if(opcion == 2){
            CierresCaja.saldos = null;
            this.dispose();
        }
    }//GEN-LAST:event_btnRealizarCierreActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnRecogerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecogerActionPerformed
        try {
            List l = new ArrayList();
            l.add(cmbMoneda.getSelectedItem());
            l.add(Integer.parseInt(txtCant.getText()));
            modTabla.setValueAtLast(l);
            tabla.updateUI();
        } catch (java.lang.NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Debe Ingresar un valor numerico", "Ingrese el monto correcto", JOptionPane.WARNING_MESSAGE);
        } finally {
            this.txtCant.setText("");
            this.cmbMoneda.requestFocus(true);
        }
    }//GEN-LAST:event_btnRecogerActionPerformed

    private void cmbMonedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbMonedaKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.txtCant.setText("");
            this.txtCant.requestFocus(true);
        }
    }//GEN-LAST:event_cmbMonedaKeyPressed

    private void cmbMonedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbMonedaMouseClicked

        this.txtCant.setText("");
        this.txtCant.requestFocus(true);

    }//GEN-LAST:event_cmbMonedaMouseClicked

    private void txtCantKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.btnRecoger.requestFocus(true);
        }
    }//GEN-LAST:event_txtCantKeyPressed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRealizarCierre;
    private javax.swing.JButton btnRecoger;
    private javax.swing.JComboBox cmbMoneda;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtCant;
    // End of variables declaration//GEN-END:variables
}
