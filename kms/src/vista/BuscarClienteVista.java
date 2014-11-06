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
public class BuscarClienteVista extends javax.swing.JDialog implements ObservadorEventos, ListSelectionListener {

    private ModeloTablaBusqueda mp;
    private String valor;
    private String[] nombresTabla = {"ID", "NOMBRE", "APELLIDOS", "TELEFONO"};

    /** Creates new form BuscarProdVista */
    public BuscarClienteVista(MenuVista padre) {
        super(padre, true);
        initComponents();
        
        MenuVista.esCliente = true;
        MenuVista.esProd = false;
        MenuVista.esProducto = false;
        MenuVista.esProveedor = false;
        MenuVista.esPersonal = false;
        tablaCliente.getSelectionModel().addListSelectionListener(this);
        mp = new ModeloTablaBusqueda();
        mp.establecerColumNom(nombresTabla);
        tablaCliente.setModel(mp);
        MenuVista.esProducto = false;
        MenuVista.esProveedor = false;
        FachadaInterfaz.getInstancia().getPtoVenta().removeEscuchadorEventos(this);
        FachadaInterfaz.getInstancia().getPtoVenta().addEscuchadorEventos(this);
        this.setLocation(350, 100);
        
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPpal = new javax.swing.JPanel();
        pnlNorte = new javax.swing.JPanel();
        lblCliente = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCliente = new javax.swing.JTable();
        pnlSur = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlPpal.setLayout(new java.awt.BorderLayout());

        pnlNorte.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        lblCliente.setFont(new java.awt.Font("Verdana", 1, 14));
        lblCliente.setText("Cliente:");
        pnlNorte.add(lblCliente);

        txtCliente.setPreferredSize(new java.awt.Dimension(150, 20));
        txtCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtClienteKeyReleased(evt);
            }
        });
        pnlNorte.add(txtCliente);

        pnlPpal.add(pnlNorte, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        tablaCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        tablaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Descripcion", "Precio Unitario", "Stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableColumn columna0 = tablaCliente.getColumn("Codigo");//Obtenemos la columna por medio del titulo
        columna0.setPreferredWidth(65);//Le asignamos un valor al ancho de la columna
        columna0.setMinWidth(65);//Un valor Minimo
        columna0.setMaxWidth(65);//Un valor Maximo
        TableColumn columna1 = tablaCliente.getColumn("Descripcion");
        columna1.setPreferredWidth(200);
        TableColumn columna2 = tablaCliente.getColumn("Precio Unitario");
        columna2.setPreferredWidth(30);
        TableColumn columna3 = tablaCliente.getColumn("Stock");
        columna3.setPreferredWidth(25);
        tablaCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaClienteKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaCliente);

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
        int fila = tablaCliente.getSelectedRow();
        if (fila != -1) {
            cargarDatos(fila);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClienteKeyReleased
        try {
            int fila = tablaCliente.getSelectedRow();
            FachadaInterfaz.getInstancia().buscarCliente(txtCliente.getText().toUpperCase());
            tablaCliente.requestFocus(true);
            txtCliente.requestFocus(true);
            tablaCliente.setRowSelectionInterval(0, 0);

            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                if (fila != -1) {
                    cargarDatos(fila);
                }
            }
        } catch (InvalidException ex) {
            //ex.printStackTrace();
        } catch (NullPointerException ex) {
        }
    }//GEN-LAST:event_txtClienteKeyReleased

    private void tablaClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaClienteKeyPressed
        int fila = tablaCliente.getSelectedRow();
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (fila != -1) {
                cargarDatos(fila);
            }
        }
    }//GEN-LAST:event_tablaClienteKeyPressed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed
    /**
     * Se encarga de cargar los datos seleccionados en un list y publicar el
     * evento
     */
    public void cargarDatos(int fila) {
        String id, nombre, apellido, telefono;
        List datos = new ArrayList();
        id = ((ModeloTablaBusqueda) tablaCliente.getModel()).getValueAt(fila, 0).toString();
        nombre = ((ModeloTablaBusqueda) tablaCliente.getModel()).getValueAt(fila, 1).toString();
        apellido = ((ModeloTablaBusqueda) tablaCliente.getModel()).getValueAt(fila, 2).toString();
        telefono = ((ModeloTablaBusqueda) tablaCliente.getModel()).getValueAt(fila, 3).toString();
        datos.add(id);
        datos.add(nombre);
        datos.add(apellido);
        datos.add(telefono);

        FachadaInterfaz.getInstancia().ptoVenta.publicarEvento(PuntoDeVenta.CLIENTE_VENTA, datos);
        MenuVista.esCliente = false;
        this.dispose();
    }

    private void cargarTabla(List al) {
        ModeloTablaBusqueda m = new ModeloTablaBusqueda(al);
        m.establecerColumNom(nombresTabla);
        tablaCliente.setModel(m);
        tablaCliente.updateUI();
    }

    public void escuchadorEvento(Object obj, String propiedad, Object valor) {
        if (propiedad.equals(PuntoDeVenta.BUSCAR_CLIENTE)) {
            cargarTabla((List) valor);
        }
    }

    public void valueChanged(ListSelectionEvent e) {
        ((ModeloTablaBusqueda) tablaCliente.getModel()).tablaSeleccionada = true;
        valor = ((ModeloTablaBusqueda) tablaCliente.getModel()).getValor();
    }
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JPanel pnlNorte;
    private javax.swing.JPanel pnlPpal;
    private javax.swing.JPanel pnlSur;
    private javax.swing.JTable tablaCliente;
    private javax.swing.JTextField txtCliente;
    // End of variables declaration//GEN-END:variables
}
