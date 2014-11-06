package vista;

import control.ObservadorEventos;
import java.util.List;

/**
 *
 * @author ekutor
 */
public class Administracion extends javax.swing.JDialog implements ObservadorEventos{
    public FachadaInterfaz fachada  = FachadaInterfaz.getInstancia();
    
    public Administracion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(parent);
        cargarCabeceras();
        fachada.ptoVenta.addEscuchadorEventos(this);
        this.setVisible(true);
        
    }

    public void cargarCabeceras(){
        txtDatos.append("\n");
        txtDatos.append("*****************************************************************************************************************************************************************************\n");
        txtDatos.append("***                                                            TERMINALES DE PUNTO DE VENTA ABIERTAS                                                                               ***\n");
        txtDatos.append("*****************************************************************************************************************************************************************************\n");
        txtDatos.append("CAJERO\t\tAPERTURA\t\tBASE INICIAL\tCANT V\t SALDO ACTUAL\t TERMINAL PV\n");
        txtDatos.append("\n");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDatos = new javax.swing.JTextArea();
        btnActualizar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("URW Gothic L", 1, 18));
        jLabel1.setForeground(new java.awt.Color(22, 18, 231));
        jLabel1.setText("TRANSACCIONES EN LINEA DE");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        txtDatos.setBackground(new java.awt.Color(1, 1, 1));
        txtDatos.setColumns(20);
        txtDatos.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtDatos.setForeground(new java.awt.Color(73, 255, 0));
        txtDatos.setRows(5);
        jScrollPane1.setViewportView(txtDatos);

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cargar.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/X.png"))); // NOI18N
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("URW Gothic L", 1, 18));
        jLabel2.setForeground(new java.awt.Color(3, 0, 140));
        jLabel2.setText("Kymera Manager System");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnActualizar)
                                .addGap(18, 18, 18)
                                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel2))
                            .addComponent(jLabel1))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnCerrar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
    
        this.txtDatos.setText(null);
        cargarCabeceras();
        txtDatos.updateUI();
        fachada.actualizarDatosAdminCajas();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtDatos;
    // End of variables declaration//GEN-END:variables

    public void escuchadorEvento(Object obj, String propiedad, Object valor) {
      
        if(propiedad.equals(control.PuntoDeVenta.ADMINISTRAR_CAJAS)){
            List<String> datos = (List<String>) valor;
            for(String linea:datos){
                txtDatos.append(linea);
            }
            txtDatos.updateUI();
        }
    }

}
