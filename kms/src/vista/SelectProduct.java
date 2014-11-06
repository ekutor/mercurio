package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import persistenciaFWK.ManejadorArchivos;

/**
 *
 * @author Kymera Systems SAS
 */
public class SelectProduct extends javax.swing.JDialog {
    private FachadaInterfaz fachada;
    private int num;
    private String idProd;
    public ArrayList list;

    /** Creates new form SeleccionarProductos */
    public SelectProduct(java.awt.Frame parent, boolean modal, int num) {
        super(parent, modal);
        fachada =FachadaInterfaz.getInstancia();
        initComponents();
        list = new ArrayList();
        iniciarCombos();
        this.num = num;
        this.setResizable(false);
        habilitarSeleccion(num);

    }

    public void cargarComboProducto(JComboBox combo){
        combo.setModel(new ModeloCombo(fachada.getProductos()));
        combo.getModel().setSelectedItem("Seleccione Producto...");
        combo.updateUI();
    }

    public void iniciarCombos(){
        cargarComboProducto(this.cmbProd1);cargarComboProducto(this.cmbProd2);
        cargarComboProducto(this.cmbProd3);cargarComboProducto(this.cmbProd4);
        cargarComboProducto(this.cmbProd5);cargarComboProducto(this.cmbProd6);
        cargarComboProducto(this.cmbProd7);cargarComboProducto(this.cmbProd8);
        cargarComboProducto(this.cmbProd9);cargarComboProducto(this.cmbProd10);
        cargarComboProducto(this.cmbProd11);cargarComboProducto(this.cmbProd12);
    }

    public void cargarID(JComboBox combo){
        idProd = (String) ((ModeloCombo)combo.getModel()).getSelectedIndex();
        list.add(idProd);
    }

    public void cargarSeis(){
        cargarID(this.cmbProd1);cargarID(this.cmbProd2);
        cargarID(this.cmbProd3);cargarID(this.cmbProd4);
        cargarID(this.cmbProd5);cargarID(this.cmbProd6);
    }

    public void cargarNueve(){
        cargarSeis();
        cargarID(this.cmbProd7);cargarID(this.cmbProd8);
        cargarID(this.cmbProd9);
    }

    public void cargarTodos(){
        cargarSeis();
        cargarNueve();
        cargarID(this.cmbProd10);
        cargarID(this.cmbProd11);cargarID(this.cmbProd12);
    }

    public void cargarListID() {
        list = new ArrayList();
        switch(num){
            case 6:{
                cargarSeis();
                break;
            }
            case 9:{
                cargarNueve();
                break;
            }
            default:{
                cargarTodos();
                break;
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPpal = new javax.swing.JPanel();
        pnlNorte = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlCentro = new javax.swing.JPanel();
        pnlCombos = new javax.swing.JPanel();
        lblProducto1 = new javax.swing.JLabel();
        cmbProd1 = new javax.swing.JComboBox();
        lblProducto2 = new javax.swing.JLabel();
        cmbProd2 = new javax.swing.JComboBox();
        lblProducto3 = new javax.swing.JLabel();
        cmbProd3 = new javax.swing.JComboBox();
        lblProducto4 = new javax.swing.JLabel();
        cmbProd4 = new javax.swing.JComboBox();
        lblProducto5 = new javax.swing.JLabel();
        cmbProd5 = new javax.swing.JComboBox();
        lblProducto6 = new javax.swing.JLabel();
        cmbProd6 = new javax.swing.JComboBox();
        lblProducto7 = new javax.swing.JLabel();
        cmbProd7 = new javax.swing.JComboBox();
        lblProducto8 = new javax.swing.JLabel();
        cmbProd8 = new javax.swing.JComboBox();
        lblProducto9 = new javax.swing.JLabel();
        cmbProd9 = new javax.swing.JComboBox();
        lblProducto10 = new javax.swing.JLabel();
        cmbProd10 = new javax.swing.JComboBox();
        lblProducto11 = new javax.swing.JLabel();
        cmbProd11 = new javax.swing.JComboBox();
        lblProducto12 = new javax.swing.JLabel();
        cmbProd12 = new javax.swing.JComboBox();
        pnlBotones = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlPpal.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        pnlPpal.setLayout(new java.awt.BorderLayout(0, 15));

        pnlNorte.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Seleccione los Productos Para Configurar la Barra de Venta:");
        jLabel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, null, new java.awt.Color(153, 153, 153))));
        jLabel1.setPreferredSize(new java.awt.Dimension(397, 50));
        pnlNorte.add(jLabel1, java.awt.BorderLayout.CENTER);

        pnlPpal.add(pnlNorte, java.awt.BorderLayout.NORTH);

        pnlCentro.setLayout(new java.awt.BorderLayout(0, 15));

        pnlCombos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        pnlCombos.setMinimumSize(new java.awt.Dimension(586, 182));
        pnlCombos.setLayout(new java.awt.GridLayout(6, 4, 10, 10));

        lblProducto1.setText("Producto 1:");
        lblProducto1.setMaximumSize(null);
        pnlCombos.add(lblProducto1);

        cmbProd1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbProd1.setInheritsPopupMenu(true);
        cmbProd1.setMaximumSize(null);
        pnlCombos.add(cmbProd1);

        lblProducto2.setText("Producto 2:");
        pnlCombos.add(lblProducto2);

        cmbProd2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbProd2.setInheritsPopupMenu(true);
        pnlCombos.add(cmbProd2);

        lblProducto3.setText("Producto 3:");
        pnlCombos.add(lblProducto3);

        cmbProd3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbProd3.setInheritsPopupMenu(true);
        pnlCombos.add(cmbProd3);

        lblProducto4.setText("Producto 4:");
        pnlCombos.add(lblProducto4);

        cmbProd4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbProd4.setInheritsPopupMenu(true);
        pnlCombos.add(cmbProd4);

        lblProducto5.setText("Producto 5:");
        pnlCombos.add(lblProducto5);

        cmbProd5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbProd5.setInheritsPopupMenu(true);
        pnlCombos.add(cmbProd5);

        lblProducto6.setText("Producto 6:");
        pnlCombos.add(lblProducto6);

        cmbProd6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbProd6.setInheritsPopupMenu(true);
        pnlCombos.add(cmbProd6);

        lblProducto7.setText("Producto 7:");
        pnlCombos.add(lblProducto7);

        cmbProd7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbProd7.setInheritsPopupMenu(true);
        pnlCombos.add(cmbProd7);

        lblProducto8.setText("Producto 8:");
        pnlCombos.add(lblProducto8);

        cmbProd8.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbProd8.setInheritsPopupMenu(true);
        pnlCombos.add(cmbProd8);

        lblProducto9.setText("Producto 9:");
        pnlCombos.add(lblProducto9);

        cmbProd9.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbProd9.setInheritsPopupMenu(true);
        pnlCombos.add(cmbProd9);

        lblProducto10.setText("Producto 10:");
        pnlCombos.add(lblProducto10);

        cmbProd10.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbProd10.setInheritsPopupMenu(true);
        pnlCombos.add(cmbProd10);

        lblProducto11.setText("Producto 11:");
        pnlCombos.add(lblProducto11);

        cmbProd11.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbProd11.setInheritsPopupMenu(true);
        pnlCombos.add(cmbProd11);

        lblProducto12.setText("Producto 12:");
        pnlCombos.add(lblProducto12);

        cmbProd12.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbProd12.setInheritsPopupMenu(true);
        pnlCombos.add(cmbProd12);

        pnlCentro.add(pnlCombos, java.awt.BorderLayout.NORTH);

        pnlBotones.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        pnlBotones.add(btnAceptar);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pnlBotones.add(btnCancelar);

        pnlCentro.add(pnlBotones, java.awt.BorderLayout.CENTER);

        pnlPpal.add(pnlCentro, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPpal, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPpal, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        try {
            this.cargarListID();
            ManejadorArchivos ma = new ManejadorArchivos(Configuracion.ARCHIVO);
            ma.guardarDatoEncriptado(ManejadorArchivos.CANTIDAD_ITEMS, String.valueOf(num));
            for (int i = 0; i < num; i++) {
                ma.guardarDatoEncriptado(ManejadorArchivos.CANTIDAD_ITEMS + i,list.get(i).toString());
            }
            this.dispose();
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Debe Seleccionar Todos los Productos!!!");
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    public void habilitarSeleccion(int num) {
        switch (num) {
            case 6: {
                this.pnlCentro.remove(this.pnlCombos);
                pnlCombos.setLayout(new GridLayout(3,4,5,5));
                pnlCombos.remove(lblProducto7);
                pnlCombos.remove(cmbProd7);
                pnlCombos.remove(lblProducto8);
                pnlCombos.remove(cmbProd8);
                pnlCombos.remove(lblProducto9);
                pnlCombos.remove(cmbProd9);
                pnlCombos.remove(lblProducto10);
                pnlCombos.remove(cmbProd10);
                pnlCombos.remove(lblProducto11);
                pnlCombos.remove(cmbProd11);
                pnlCombos.remove(lblProducto12);
                pnlCombos.remove(cmbProd12);
                this.pnlCentro.add(this.pnlCombos,BorderLayout.NORTH);
                this.pnlPpal.add(this.pnlCentro);
                this.setSize(700,245);
                this.setLocation(250, 100);
                this.setVisible(true);
                break;
            }
            case 9: {
                this.pnlCentro.remove(this.pnlCombos);
                pnlCombos.setLayout(new GridLayout(5,4,5,5));
                pnlCombos.remove(lblProducto10);
                pnlCombos.remove(cmbProd10);
                pnlCombos.remove(lblProducto11);
                pnlCombos.remove(cmbProd11);
                pnlCombos.remove(lblProducto12);
                pnlCombos.remove(cmbProd12);
                this.pnlCentro.add(this.pnlCombos,BorderLayout.NORTH);
                this.pnlCentro.add(this.pnlBotones,BorderLayout.CENTER);
                this.pnlPpal.add(this.pnlCentro);
                this.setSize(700,295);
                this.setLocation(250, 100);
                this.setVisible(true);
                break;
            }
            default:{
                this.setSize(700,350);
                this.setLocation(250, 100);
                this.setVisible(true);
                break;
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox cmbProd1;
    private javax.swing.JComboBox cmbProd10;
    private javax.swing.JComboBox cmbProd11;
    private javax.swing.JComboBox cmbProd12;
    private javax.swing.JComboBox cmbProd2;
    private javax.swing.JComboBox cmbProd3;
    private javax.swing.JComboBox cmbProd4;
    private javax.swing.JComboBox cmbProd5;
    private javax.swing.JComboBox cmbProd6;
    private javax.swing.JComboBox cmbProd7;
    private javax.swing.JComboBox cmbProd8;
    private javax.swing.JComboBox cmbProd9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblProducto1;
    private javax.swing.JLabel lblProducto10;
    private javax.swing.JLabel lblProducto11;
    private javax.swing.JLabel lblProducto12;
    private javax.swing.JLabel lblProducto2;
    private javax.swing.JLabel lblProducto3;
    private javax.swing.JLabel lblProducto4;
    private javax.swing.JLabel lblProducto5;
    private javax.swing.JLabel lblProducto6;
    private javax.swing.JLabel lblProducto7;
    private javax.swing.JLabel lblProducto8;
    private javax.swing.JLabel lblProducto9;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlCentro;
    private javax.swing.JPanel pnlCombos;
    private javax.swing.JPanel pnlNorte;
    private javax.swing.JPanel pnlPpal;
    // End of variables declaration//GEN-END:variables
}
