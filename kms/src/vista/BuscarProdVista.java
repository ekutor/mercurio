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
public class BuscarProdVista extends javax.swing.JDialog implements ObservadorEventos, ListSelectionListener {

    private ModeloTablaBusqueda mp;
    private String valor, nom;
    private String[] nombresTabla = {"CODIGO", "DESCRIPCION", "PRECIO UNITARIO", "STOCK"};

    /** Creates new form BuscarProdVista */
    public BuscarProdVista(MenuVista padre) {
        super(padre, true);
        cargarVista();
        crearTabla();
    }

    public void cargarVista() {
        initComponents();
        MenuVista.esProducto = true;
        MenuVista.esProd = true;
        tablaProducto.getSelectionModel().addListSelectionListener(this);
        FachadaInterfaz.getInstancia().getPtoVenta().removeEscuchadorEventos(this);
        FachadaInterfaz.getInstancia().getPtoVenta().addEscuchadorEventos(this);
    }

    public void crearTabla() {
        mp = new ModeloTablaBusqueda();
        mp.establecerColumNom(nombresTabla);
        tablaProducto.setModel(mp);
        MenuVista.esCliente = false;
        MenuVista.esProveedor = false;
        MenuVista.esPersonal = false;
        setLocation(350, 100);
        setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPpal = new javax.swing.JPanel();
        pnlNorte = new javax.swing.JPanel();
        lblProducto = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProducto = new javax.swing.JTable();
        pnlSur = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlPpal.setLayout(new java.awt.BorderLayout());

        pnlNorte.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        lblProducto.setFont(new java.awt.Font("Verdana", 1, 14));
        lblProducto.setText("Producto:");
        pnlNorte.add(lblProducto);

        txtProducto.setPreferredSize(new java.awt.Dimension(150, 20));
        txtProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProductoKeyReleased(evt);
            }
        });
        pnlNorte.add(txtProducto);

        pnlPpal.add(pnlNorte, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        tablaProducto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        tablaProducto.setModel(new javax.swing.table.DefaultTableModel(
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
        TableColumn columna0 = tablaProducto.getColumn("Codigo");//Obtenemos la columna por medio del titulo
        columna0.setPreferredWidth(65);//Le asignamos un valor al ancho de la columna
        columna0.setMinWidth(65);//Un valor Minimo
        columna0.setMaxWidth(65);//Un valor Maximo
        TableColumn columna1 = tablaProducto.getColumn("Descripcion");
        columna1.setPreferredWidth(200);
        TableColumn columna2 = tablaProducto.getColumn("Precio Unitario");
        columna2.setPreferredWidth(30);
        TableColumn columna3 = tablaProducto.getColumn("Stock");
        columna3.setPreferredWidth(25);
        tablaProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaProductoKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProducto);

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
        int fila = tablaProducto.getSelectedRow();
        if (fila != -1) {
            cargarDatos(fila);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductoKeyReleased
        try {
            int fila = tablaProducto.getSelectedRow();
            FachadaInterfaz.getInstancia().buscarProducto(txtProducto.getText().toUpperCase());
            tablaProducto.requestFocus(true);
            txtProducto.requestFocus(true);
            tablaProducto.setRowSelectionInterval(0, 0);

            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                if (fila != -1) {
                    cargarDatos(fila);
                }
            }
        } catch (InvalidException ex) {
            //ex.printStackTrace();
        } catch (NullPointerException ex) {
        }
    }//GEN-LAST:event_txtProductoKeyReleased

    private void tablaProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaProductoKeyPressed
        int fila = tablaProducto.getSelectedRow();
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (fila != -1) {
                cargarDatos(fila);
            }
        }
    }//GEN-LAST:event_tablaProductoKeyPressed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        MenuVista.esProd = false;
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed
    /**
     * Se encarga de cargar los datos seleccionados en un list y publicar el
     * evento
     */
    public void cargarDatos(int fila) {
        String codigo, descripcion, precio, stock;
        List datos = new ArrayList();
        codigo = ((ModeloTablaBusqueda) tablaProducto.getModel()).getValueAt(fila, 0).toString();
        descripcion = ((ModeloTablaBusqueda) tablaProducto.getModel()).getValueAt(fila, 1).toString();
        precio = ((ModeloTablaBusqueda) tablaProducto.getModel()).getValueAt(fila, 2).toString();
        stock = ((ModeloTablaBusqueda) tablaProducto.getModel()).getValueAt(fila, 3).toString();
        datos.add(codigo);
        datos.add(descripcion);
        datos.add(precio);
        datos.add(stock);
        if(MenuVista.esCompra){
            FachadaInterfaz.getInstancia().ptoVenta.publicarEvento(PuntoDeVenta.DATOS_PRODUCTO_COMPRA, datos);
        } else if(MenuVista.esVenta){
            FachadaInterfaz.getInstancia().ptoVenta.publicarEvento(PuntoDeVenta.DATOS_ENCONTRADOS, datos);
        } else{
            FachadaInterfaz.getInstancia().ptoVenta.publicarEvento(PuntoDeVenta.DATOS_PRO_ENCON, datos);
        }
        
        MenuVista.esProd = false;
        this.dispose();
    }

    private void cargarTabla(List al) {
        ModeloTablaBusqueda m = new ModeloTablaBusqueda(al);
        MenuVista.esCliente = false;
        MenuVista.esProveedor = false;
        m.establecerColumNom(nombresTabla);
        tablaProducto.setModel(m);
        tablaProducto.updateUI();
    }

    public void escuchadorEvento(Object obj, String propiedad, Object valor) {
        if (propiedad.equals(PuntoDeVenta.BUSCAR_PRODUCTO)) {
            cargarTabla((List) valor);
        }
    }

    public void valueChanged(ListSelectionEvent e) {
        ((ModeloTablaBusqueda) tablaProducto.getModel()).tablaSeleccionada = true;
        valor = ((ModeloTablaBusqueda) tablaProducto.getModel()).getValor();
        nom = ((ModeloTablaBusqueda) tablaProducto.getModel()).getNom();
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
    private javax.swing.JTable tablaProducto;
    private javax.swing.JTextField txtProducto;
    // End of variables declaration//GEN-END:variables
}
