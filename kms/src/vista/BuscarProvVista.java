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
public class BuscarProvVista extends javax.swing.JDialog implements ObservadorEventos, ListSelectionListener {

    private ModeloTablaBusqueda mp;
    private String valor;
    private String[] nombresTabla = {"ID", "Razon Social", "Contacto", "Direccion"};
    private ArrayList datos;

    /** Creates new form BuscarProdVista */
    public BuscarProvVista(MenuVista padre) {
        super(padre, true);
        initComponents();
        datos = new ArrayList();
        MenuVista.esProveedor = true;
        MenuVista.esProducto = false;
        MenuVista.esCliente = false;
        MenuVista.esPersonal = false;
        MenuVista.esProd = false;
        tablaProveedor.getSelectionModel().addListSelectionListener(this);
        mp = new ModeloTablaBusqueda();
        mp.establecerColumNom(nombresTabla);
        tablaProveedor.setModel(mp);
        this.setLocation(350, 100);
        FachadaInterfaz.getInstancia().getPtoVenta().removeEscuchadorEventos(this);
        FachadaInterfaz.getInstancia().getPtoVenta().addEscuchadorEventos(this);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPpal = new javax.swing.JPanel();
        pnlNorte = new javax.swing.JPanel();
        lblProveedor = new javax.swing.JLabel();
        txtProveedor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProveedor = new javax.swing.JTable();
        pnlSur = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlPpal.setLayout(new java.awt.BorderLayout());

        pnlNorte.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        lblProveedor.setFont(new java.awt.Font("Verdana", 1, 14));
        lblProveedor.setText("Proveedor:");
        pnlNorte.add(lblProveedor);

        txtProveedor.setPreferredSize(new java.awt.Dimension(150, 20));
        txtProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProveedorKeyReleased(evt);
            }
        });
        pnlNorte.add(txtProveedor);

        pnlPpal.add(pnlNorte, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        tablaProveedor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        tablaProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Razon Social", "Contacto", "Direccion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableColumn columna0 = tablaProveedor.getColumn("ID");//Obtenemos la columna por medio del titulo
        columna0.setPreferredWidth(65);//Le asignamos un valor al ancho de la columna
        columna0.setMinWidth(65);//Un valor Minimo
        columna0.setMaxWidth(65);//Un valor Maximo
        TableColumn columna1 = tablaProveedor.getColumn("Razon Social");
        columna1.setPreferredWidth(200);
        TableColumn columna2 = tablaProveedor.getColumn("Contacto");
        columna2.setPreferredWidth(30);
        TableColumn columna3 = tablaProveedor.getColumn("Direccion");
        columna3.setPreferredWidth(25);
        tablaProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaProveedorKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProveedor);

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
        int fila = tablaProveedor.getSelectedRow();
        if (fila != -1) {
            cargarDatos(fila);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtProveedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProveedorKeyReleased
        try {
            int fila = tablaProveedor.getSelectedRow();
            FachadaInterfaz.getInstancia().buscarProveedor(txtProveedor.getText().toUpperCase());
            tablaProveedor.requestFocus(true);
            txtProveedor.requestFocus(true);
            tablaProveedor.setRowSelectionInterval(0, 0);
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                if (fila != -1) {
                    cargarDatos(fila);
                }
            }
        } catch (InvalidException ex) {
            //ex.printStackTrace();
        } catch (NullPointerException ex) {
        }
    }//GEN-LAST:event_txtProveedorKeyReleased

    private void tablaProveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaProveedorKeyPressed
        int fila = tablaProveedor.getSelectedRow();
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (fila != -1) {
                cargarDatos(fila);
            }
        }
    }//GEN-LAST:event_tablaProveedorKeyPressed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed
    private void cargarTabla(List al) {
        ModeloTablaBusqueda m = new ModeloTablaBusqueda(al);
        m.establecerColumNom(nombresTabla);
        tablaProveedor.setModel(m);
        tablaProveedor.updateUI();
    }

    public void escuchadorEvento(Object obj, String propiedad, Object valor) {
        if (propiedad.equals(PuntoDeVenta.BUSCAR_PROVEEDOR)) {
            datos = (ArrayList)valor;
            cargarTabla(datos);
        }
    }

    public void valueChanged(ListSelectionEvent e) {
        ((ModeloTablaBusqueda) tablaProveedor.getModel()).tablaSeleccionada = true;
        valor = ((ModeloTablaBusqueda) tablaProveedor.getModel()).getValor();
    }

    /**
     * Se encarga de cargar los datos seleccionados en un list y publicar el
     * evento
     */
    public void cargarDatos(int fila) {
        String id;
        id = ((ModeloTablaBusqueda) tablaProveedor.getModel()).getValueAt(fila, 0).toString();
        List data = null;
        for(int i =0; i < datos.size();i++){
            if(datos.get(i).toString().contains(id)){
                data = (List) datos.get(i);
            }
        }
        if(MenuVista.esCompra){
            FachadaInterfaz.getInstancia().ptoVenta.publicarEvento(PuntoDeVenta.DATOS_PRV_ENCON, data);
        } else{
            FachadaInterfaz.getInstancia().ptoVenta.publicarEvento(PuntoDeVenta.DATOS_PRV_ENCON,data);
        }
        
        MenuVista.esProd = false;
        this.dispose();
    }
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblProveedor;
    private javax.swing.JPanel pnlNorte;
    private javax.swing.JPanel pnlPpal;
    private javax.swing.JPanel pnlSur;
    private javax.swing.JTable tablaProveedor;
    private javax.swing.JTextField txtProveedor;
    // End of variables declaration//GEN-END:variables
}
