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
public class BuscarOrdenVista extends javax.swing.JDialog implements ObservadorEventos, ListSelectionListener {

    private ModeloTablaBusqueda mp;
    private String valor;
    private String[] nombresTabla = {"No.ORDEN", "PROOVEDOR", "FECHA PEDIDO", "TOTAL","ESTADO"};
    private CompraVista vista;

    /** Creates new form BuscarProdVista */
    public BuscarOrdenVista(MenuVista padre, CompraVista vista) {
        super(padre, true);
        this.vista = vista;
        initComponents();
        
        MenuVista.esCompra = true;
        MenuVista.esCliente = false;
        MenuVista.esProd = false;
        MenuVista.esProducto = false;
        MenuVista.esProveedor = false;
        MenuVista.esPersonal = false;

        tablaOrden.getSelectionModel().addListSelectionListener(this);
        mp = new ModeloTablaBusqueda();
        mp.establecerColumNom(nombresTabla);
        tablaOrden.setModel(mp);
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
        lblFiltro = new javax.swing.JLabel();
        txtFiltro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaOrden = new javax.swing.JTable();
        pnlSur = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlPpal.setLayout(new java.awt.BorderLayout());

        pnlNorte.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        lblFiltro.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblFiltro.setText("Filtro de Busqueda:");
        pnlNorte.add(lblFiltro);

        txtFiltro.setPreferredSize(new java.awt.Dimension(150, 20));
        txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroKeyReleased(evt);
            }
        });
        pnlNorte.add(txtFiltro);

        pnlPpal.add(pnlNorte, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        tablaOrden.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        tablaOrden.setModel(new javax.swing.table.DefaultTableModel(
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
        TableColumn columna0 = tablaOrden.getColumn("Codigo");//Obtenemos la columna por medio del titulo
        columna0.setPreferredWidth(65);//Le asignamos un valor al ancho de la columna
        columna0.setMinWidth(65);//Un valor Minimo
        columna0.setMaxWidth(65);//Un valor Maximo
        TableColumn columna1 = tablaOrden.getColumn("Descripcion");
        columna1.setPreferredWidth(200);
        TableColumn columna2 = tablaOrden.getColumn("Precio Unitario");
        columna2.setPreferredWidth(30);
        TableColumn columna3 = tablaOrden.getColumn("Stock");
        columna3.setPreferredWidth(25);
        tablaOrden.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaOrdenKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaOrden);

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
        int fila = tablaOrden.getSelectedRow();
        if (fila != -1) {
            cargarDatos(fila);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyReleased
        try {
            int fila = tablaOrden.getSelectedRow();
            FachadaInterfaz.getInstancia().buscarCompras(txtFiltro.getText().toUpperCase());
            tablaOrden.requestFocus(true);
            txtFiltro.requestFocus(true);
            tablaOrden.setRowSelectionInterval(0, 0);

            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                if (fila != -1) {
                    cargarDatos(fila);
                }
            }
        } catch (InvalidException ex) {
            //ex.printStackTrace();
        } catch (NullPointerException ex) {
        }
    }//GEN-LAST:event_txtFiltroKeyReleased

    private void tablaOrdenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaOrdenKeyPressed
        int fila = tablaOrden.getSelectedRow();
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (fila != -1) {
                cargarDatos(fila);
            }
        }
    }//GEN-LAST:event_tablaOrdenKeyPressed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed
    /**
     * Se encarga de cargar los datos seleccionados en un list y publicar el
     * evento
     */
    public void cargarDatos(int fila) {
        String numOrden, proovesor, fechaPedido, total,estado;
        List datos = new ArrayList();
        numOrden = ((ModeloTablaBusqueda) tablaOrden.getModel()).getValueAt(fila, 0).toString();
        proovesor = ((ModeloTablaBusqueda) tablaOrden.getModel()).getValueAt(fila, 1).toString();
        fechaPedido = ((ModeloTablaBusqueda) tablaOrden.getModel()).getValueAt(fila, 2).toString();
        total = ((ModeloTablaBusqueda) tablaOrden.getModel()).getValueAt(fila, 3).toString();
        estado = ((ModeloTablaBusqueda) tablaOrden.getModel()).getValueAt(fila, 4).toString();
        datos.add(numOrden);
        datos.add(proovesor);
        datos.add(fechaPedido);
        datos.add(total);
        datos.add(estado);

        vista.EliminarTodosLosRegistros();
        FachadaInterfaz.getInstancia().cargarCompra(numOrden);
        vista.habilitarObjetos();
        MenuVista.esCompra = false;
        this.dispose();
    }

    private void cargarTabla(List al) {
        ModeloTablaBusqueda m = new ModeloTablaBusqueda(al);
        m.establecerColumNom(nombresTabla);
        tablaOrden.setModel(m);
        tablaOrden.updateUI();
    }

    public void escuchadorEvento(Object obj, String propiedad, Object valor) {
        if (propiedad.equals(PuntoDeVenta.BUSCAR_COMPRA)) {
            cargarTabla((List) valor);
        }
    }

    public void valueChanged(ListSelectionEvent e) {
        ((ModeloTablaBusqueda) tablaOrden.getModel()).tablaSeleccionada = true;
        valor = ((ModeloTablaBusqueda) tablaOrden.getModel()).getValor();
    }
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JPanel pnlNorte;
    private javax.swing.JPanel pnlPpal;
    private javax.swing.JPanel pnlSur;
    private javax.swing.JTable tablaOrden;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables
}
