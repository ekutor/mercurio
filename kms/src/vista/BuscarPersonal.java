package vista;

import control.ObservadorEventos;
import control.PuntoDeVenta;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;
import modelo.ModeloTablaBusqueda;
import utilidades.InvalidException;

/**
 *
 * @author Kymera Systems SAS
 */
public class BuscarPersonal extends javax.swing.JDialog implements ObservadorEventos, ListSelectionListener {

    private ModeloTablaBusqueda mp;
    private String valor, nom;
    private String[] nombresTabla = {"CEDULA", "NOMBRE", "APELLIDO", "CEL"};

    /** Creates new form BuscarProdVista */
    public BuscarPersonal(MenuVista padre) {
        super(padre, true);
        cargarVista();
        crearTabla();
    }

    public void cargarVista() {
        initComponents();
        MenuVista.esPersonal = true;
        MenuVista.esProducto = false;
        MenuVista.esCliente = false;
        MenuVista.esProveedor = false;
        tablaPersonal.getSelectionModel().addListSelectionListener(this);
        FachadaInterfaz.getInstancia().getPtoVenta().addEscuchadorEventos(this);
    }

    public void crearTabla() {
        mp = new ModeloTablaBusqueda();
        mp.establecerColumNom(nombresTabla);
        tablaPersonal.setModel(mp);
        MenuVista.esProducto = false;
        MenuVista.esCliente = false;
        MenuVista.esProveedor = false;
        setLocation(350, 100);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPpal = new javax.swing.JPanel();
        pnlNorte = new javax.swing.JPanel();
        lblProducto = new javax.swing.JLabel();
        txtPersonal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPersonal = new javax.swing.JTable();
        pnlSur = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlPpal.setLayout(new java.awt.BorderLayout());

        pnlNorte.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        lblProducto.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblProducto.setText("Personal:");
        pnlNorte.add(lblProducto);

        txtPersonal.setPreferredSize(new java.awt.Dimension(150, 20));
        txtPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPersonalActionPerformed(evt);
            }
        });
        txtPersonal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPersonalKeyReleased(evt);
            }
        });
        pnlNorte.add(txtPersonal);

        pnlPpal.add(pnlNorte, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        tablaPersonal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        tablaPersonal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CEDULA", "NOMBRE", "APELLIDO", "CEL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableColumn columna0 = tablaPersonal.getColumn("CEDULA");//Obtenemos la columna por medio del titulo
        columna0.setPreferredWidth(65);//Le asignamos un valor al ancho de la columna
        columna0.setMinWidth(65);//Un valor Minimo
        columna0.setMaxWidth(65);//Un valor Maximo
        TableColumn columna1 = tablaPersonal.getColumn("NOMBRE");
        columna1.setPreferredWidth(200);
        TableColumn columna2 = tablaPersonal.getColumn("APELLIDO");
        columna2.setPreferredWidth(30);
        TableColumn columna3 = tablaPersonal.getColumn("CEL");
        columna3.setPreferredWidth(25);
        tablaPersonal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaPersonalKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPersonal);

        pnlPpal.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pnlSur.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        btnAceptar.setMnemonic('A');
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        pnlSur.add(btnAceptar);

        btnCancelar.setMnemonic('C');
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pnlSur.add(btnCancelar);

        pnlPpal.add(pnlSur, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPpal, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPpal, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        int fila = tablaPersonal.getSelectedRow();
        if (fila != -1) {
            cargarDatos(fila);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtPersonalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPersonalKeyReleased
        try {
            int fila = tablaPersonal.getSelectedRow();
            FachadaInterfaz.getInstancia().buscarPersonal(txtPersonal.getText().toUpperCase());
            tablaPersonal.requestFocus(true);
            txtPersonal.requestFocus(true);
            tablaPersonal.setRowSelectionInterval(0, 0);

            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                if (fila != -1) {
                    cargarDatos(fila);
                }
            }
        } catch (InvalidException ex) {
            //ex.printStackTrace();
        } catch (NullPointerException ex) {
        }
    }//GEN-LAST:event_txtPersonalKeyReleased

    private void tablaPersonalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaPersonalKeyPressed
        int fila = tablaPersonal.getSelectedRow();
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (fila != -1) {
                cargarDatos(fila);
            }
        }
    }//GEN-LAST:event_tablaPersonalKeyPressed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPersonalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPersonalActionPerformed
    /**
     * Se encarga de cargar los datos seleccionados en un list y publicar el
     * evento
     */
    public void cargarDatos(int fila) {
        String cedula, nombre,apellido,cel;
        List datos = new ArrayList();
        cedula = ((ModeloTablaBusqueda) tablaPersonal.getModel()).getValueAt(fila, 0).toString();
        nombre = ((ModeloTablaBusqueda) tablaPersonal.getModel()).getValueAt(fila, 1).toString();
        apellido = ((ModeloTablaBusqueda) tablaPersonal.getModel()).getValueAt(fila, 2).toString();
        cel = ((ModeloTablaBusqueda) tablaPersonal.getModel()).getValueAt(fila, 3).toString();
        datos.add(cedula);
        datos.add(nombre);
        datos.add(apellido);
        datos.add(cel);
        FachadaInterfaz.getInstancia().ptoVenta.publicarEvento(PuntoDeVenta.DATOS_PER_ENCON, datos);
        this.dispose();
    }

    private void cargarTabla(List al) {
        ModeloTablaBusqueda m = new ModeloTablaBusqueda(al);
        MenuVista.esCliente = false;
        MenuVista.esProveedor = false;
        MenuVista.esProducto = false;
        m.establecerColumNom(nombresTabla);
        tablaPersonal.setModel(m);
        tablaPersonal.updateUI();
    }

    public void escuchadorEvento(Object obj, String propiedad, Object valor) {
        if (propiedad.equals(PuntoDeVenta.BUSCAR_PERSONAL)) {
            cargarTabla((List) valor);
        }
    }

    public void valueChanged(ListSelectionEvent e) {
        ((ModeloTablaBusqueda) tablaPersonal.getModel()).tablaSeleccionada = true;
        valor = ((ModeloTablaBusqueda) tablaPersonal.getModel()).getValor();
        nom = ((ModeloTablaBusqueda) tablaPersonal.getModel()).getNom();
    }
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JPanel pnlNorte;
    private javax.swing.JPanel pnlPpal;
    private javax.swing.JPanel pnlSur;
    private javax.swing.JTable tablaPersonal;
    private javax.swing.JTextField txtPersonal;
    // End of variables declaration//GEN-END:variables
}
