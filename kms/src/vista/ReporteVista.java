package vista;

import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.awt.Cursor;
import java.io.File;
import javax.swing.ImageIcon;
import reportes.Reporte;
import utilidades.Utilidades;

/**
 *
 * @author JUAN
 */
public class ReporteVista extends javax.swing.JDialog {

    Reporte reporte;
    String generar;
    PanelVenta v;
    PanelBusqueda busqueda;
    PanelDetalleVenta detalle;
    PanelInventario inventario;
    PanelGraficas graficas;
    PanelCaja caja;

    public ReporteVista(Component c) {
        initComponents();
        reporte = new Reporte();
        v = new PanelVenta();
        busqueda = new PanelBusqueda();
        detalle = new PanelDetalleVenta();
        inventario = new PanelInventario();
        graficas = new PanelGraficas();
        caja = new PanelCaja();
        this.setModal(true);
        this.setLocationRelativeTo(c);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnGenerarReporte = new javax.swing.JButton();
        jcbModulo = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        pnlContenedor = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnGenerarReporte.setText("Generar Reporte");
        btnGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteActionPerformed(evt);
            }
        });

        jcbModulo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione un Modulo", "Venta", "Detalle de Venta", "Inventario", "Producto", "Proveedor", "Personal", "Cliente", "Graficas Mes/Año", "Caja" }));
        jcbModulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbModuloActionPerformed(evt);
            }
        });

        jLabel1.setText("Modulos");

        pnlContenedor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout pnlContenedorLayout = new javax.swing.GroupLayout(pnlContenedor);
        pnlContenedor.setLayout(pnlContenedorLayout);
        pnlContenedorLayout.setHorizontalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 409, Short.MAX_VALUE)
        );
        pnlContenedorLayout.setVerticalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 294, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlContenedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGenerarReporte)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(60, 60, 60)
                        .addComponent(jcbModulo, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbModulo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGenerarReporte)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbModuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbModuloActionPerformed

        switch (jcbModulo.getSelectedIndex()) {
            case 0:
                ventaVisible(false);
                adicionarPanelDetalleVenta(false);
                adicionarPanelInventario(false);
                adicionarPanelBusqueda(false, PanelBusqueda.PRODUCTO);
                adicionarPanelBusqueda(false, PanelBusqueda.PROVEEDOR);
                adicionarPanelBusqueda(false, PanelBusqueda.PERSONAL);
                adicionarPanelBusqueda(false, PanelBusqueda.CLIENTE);
                adicionarPanelGraficas(false);

                break;
            case 1:
                generar = "venta";
                ventaVisible(true);
                this.pnlContenedor.add(v);
                this.pack();

                break;
            case 2:
                generar = "detalle_venta";
                adicionarPanelDetalleVenta(true);
                break;
            case 3:
                generar = "inventario";
                adicionarPanelInventario(true);
                break;
            case 4:
                generar = "producto";
                adicionarPanelBusqueda(true, PanelBusqueda.PRODUCTO);
                limpiar();
                break;
            case 5:
                generar = "proveedor";
                adicionarPanelBusqueda(true, PanelBusqueda.PROVEEDOR);
                limpiar();
                break;
            case 6:
                generar = "personal";
                adicionarPanelBusqueda(true, PanelBusqueda.PERSONAL);
                limpiar();
                break;
            case 7:
                generar = "cliente";
                adicionarPanelBusqueda(true, PanelBusqueda.CLIENTE);
                limpiar();
                break;
            case 8:
                generar = "graficas";
                adicionarPanelGraficas(true);
                break;
            case 9:
                generar = "caja";
                adicionarPanelCaja(true);
                break;

        }
    }//GEN-LAST:event_jcbModuloActionPerformed

    private void btnGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteActionPerformed
        try {
            this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            generarReporte();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

    }//GEN-LAST:event_btnGenerarReporteActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarReporte;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox jcbModulo;
    private javax.swing.JPanel pnlContenedor;
    // End of variables declaration//GEN-END:variables

    public void ventaVisible(boolean b) {
        v.setVisible(b);
        busqueda.setVisible(false);
        detalle.setVisible(false);
        inventario.setVisible(false);
        graficas.setVisible(false);
        caja.setVisible(false);
    }

    public void pasarParametros(String key, String d) {
        reporte.agregarParametro(key, d);
    }

    public void adicionarPanelBusqueda(boolean b, int tipo) {
        busqueda.cargar(tipo);
        v.setVisible(false);
        detalle.setVisible(false);
        inventario.setVisible(false);
        graficas.setVisible(false);
        caja.setVisible(false);
        busqueda.setVisible(b);
        this.pnlContenedor.add(busqueda);
        this.pack();



    }

    public void adicionarPanelStock(boolean b) {
        v.setVisible(false);
        busqueda.setVisible(false);
        inventario.setVisible(false);
        graficas.setVisible(false);
        caja.setVisible(false);
        detalle.setVisible(false);
        this.pack();

    }

    public void adicionarPanelDetalleVenta(boolean b) {
        v.setVisible(false);
        busqueda.setVisible(false);
        inventario.setVisible(false);
        graficas.setVisible(false);
        caja.setVisible(false);
        detalle.setVisible(b);
        this.pnlContenedor.add(detalle);
        this.pack();


    }

    public void adicionarPanelInventario(boolean b) {
        v.setVisible(false);
        busqueda.setVisible(false);
        inventario.setVisible(b);
        detalle.setVisible(false);
        graficas.setVisible(false);
        caja.setVisible(false);
        this.pnlContenedor.add(inventario);
        this.pack();

    }

    public void adicionarPanelGraficas(boolean b) {
        v.setVisible(false);
        busqueda.setVisible(false);
        inventario.setVisible(false);
        detalle.setVisible(false);
        caja.setVisible(false);
        graficas.setVisible(b);
        this.pnlContenedor.add(graficas);
        this.pack();

    }

    public void adicionarPanelCaja(boolean b) {
        v.setVisible(false);
        busqueda.setVisible(false);
        inventario.setVisible(false);
        detalle.setVisible(false);
        graficas.setVisible(false);
        caja.setVisible(b);
        this.pnlContenedor.add(caja);
        this.pack();
    }

    public void fechaDesdeHasta(JDateChooser d, JDateChooser h) {
        String desde, hasta;
        desde = Utilidades.datetoString(d.getDate());
        hasta = Utilidades.datetoString(h.getDate());
        reporte.agregarParametro("fecha_desde", desde);
        reporte.agregarParametro("fecha_hasta", hasta);
    }

    public void generarReporte() {
        if (generar.equals("venta")) {
            if (v.getJbFecha().isSelected()) {
                fechaDesdeHasta(v.getJdateDesde(), v.getJdateHasta());
                reporte.verReporteVenta();
            } else if (v.getJbCajero().isSelected()) {
                fechaDesdeHasta(v.getJdateDesdeC(), v.getJdateHastaC());
                reporte.agregarParametro("cajero", v.getCodigo(1));
                reporte.verReporteVentaCajero();
            } else if (v.getJbProducto().isSelected()) {
                String mes = String.valueOf(v.getJcbMes().getMonth() + 1);
                String año = String.valueOf(v.getjAño().getYear());
                reporte.agregarParametro("fecha", mes);
                reporte.agregarParametro("producto", v.getCodigo(2));
                reporte.agregarParametro("año", año);
                if (v.getjCheckDetallado().isSelected()) {
                    reporte.verReporteVentaProductoMesDetallado();
                } else {
                    reporte.verReporteVentaProductoMes();
                }
            } else if (v.getJbProductoDiario().isSelected()) {
                reporte.agregarParametro("producto", v.getCodigo(3));
                String fech = utilidades.Utilidades.datetoString(v.getjDateFechaDiario().getDate());
                System.out.println(fech);
                reporte.agregarParametro("fecha", fech);
                reporte.verReporteVentaProductoDiario();
            }
        } else if (generar.equals("producto")) {

            if (busqueda.getJrTodos().isSelected()) {
                reporte.verReporteProducto();
            } else if (busqueda.getJrEspecificar().isSelected()) {
                pasarParametros("producto", busqueda.obtenerID());
                reporte.verReporteProductoParametro();
            } else if (busqueda.getJrCategoria().isSelected()) {
                pasarParametros("categoria", busqueda.obtenerIDcategoria());
                reporte.verReporteProductoCategoria();
            }
        } else if (generar.equals("proveedor")) {
            if (busqueda.getJrTodos().isSelected()) {
                reporte.verReporteProveedor();
            } else {
                
                pasarParametros("id_proveedor", busqueda.obtenerID());
                reporte.agregarParametro("dir",reporte.getPathSubRep("subReportProveedor"));
                reporte.verReporteProveedorParametro();
            }
        } else if (generar.equals("cliente")) {
            if (busqueda.getJrTodos().isSelected()) {
                reporte.verReporteCliente();
            } else {
                pasarParametros("id_cliente", busqueda.obtenerID());
                reporte.verReporteClienteParametro();
            }
        } else if (generar.equals("personal")) {
            if (busqueda.getJrTodos().isSelected()) {
                reporte.verReportePersonal();
            } else {
                pasarParametros("id_personal", busqueda.obtenerID());
                reporte.verReportePersonalParametro();
            }
        } else if (generar.equals("detalle_venta")) {
            if (detalle.getJrbPorVenta().isSelected()) {
                fechaDesdeHasta(detalle.getJdateFecha_desde(), detalle.getJdateFecha_hasta());
                reporte.verReporteDetalleVenta();
            } else if (detalle.getJrbCajero().isSelected()) {
                reporte.agregarParametro("cajero", detalle.getCodigo("cajero"));
                fechaDesdeHasta(detalle.getJdateFecha_desdeCa(), detalle.getJdateFecha_hastaCa());
                reporte.verReporteDetalleVentaCajero();
            } else if (detalle.getJrbPorCategoria().isSelected()) {
                reporte.agregarParametro("categoria", detalle.getCodigo("categoria"));
                fechaDesdeHasta(detalle.getJdateFecha_desdeC(), detalle.getJdateFecha_hastaC());
                reporte.verReporteDetalleVentaCategoria();
            } else if (detalle.getJrbProducto().isSelected()) {
                reporte.agregarParametro("productoID", detalle.getCodigo("producto"));
                fechaDesdeHasta(detalle.getJdateFecha_desdeP(), detalle.getJdateFecha_hastaP());
                reporte.verReporteDetalleVentaProducto();
            }
        } else if (generar.equals("inventario")) {
            if (inventario.jrbAgotado.isSelected()) {
                reporte.agregarParametro("stockMinimo", MenuVista.stockMinimo);
                reporte.verReporteAgotados();
            } else if (inventario.jrFamilia.isSelected()) {
                reporte.agregarParametro("stockMinimo", generar);
                reporte.agregarParametro("familia", inventario.getCodigo(3));
                reporte.verReporteAgotadosFamilia();
            } else if (inventario.jrCompraProducto.isSelected()) {
                if (inventario.jrEspera.isSelected()) {
                    reporte.agregarParametro("productoID", inventario.getCodigo(5));
                    reporte.agregarParametro("estado", "En Espera");
                    reporte.verReporteComprasProducto();
                } else {
                    reporte.agregarParametro("productoID", inventario.getCodigo(5));
                    reporte.agregarParametro("estado", "Pago");
                    reporte.verReporteComprasProducto();
                }
            } else if (inventario.jrCompraCategoria.isSelected()) {

                if (inventario.jrEspera.isSelected()) {
                    reporte.agregarParametro("categoriaID", inventario.getCodigo(4));
                    reporte.agregarParametro("estado", "En Espera");
                    reporte.verReporteComprasCategoria();
                } else {
                    reporte.agregarParametro("categoriaID", inventario.getCodigo(4));
                    reporte.agregarParametro("estado", "Pago");
                    reporte.verReporteComprasCategoria();
                }
            }
        } else if (generar.equals("graficas")) {
            if (graficas.getJrDiaria().isSelected()) {
                reporte.agregarParametro("mes", graficas.obtenerMes());
                reporte.verReporteGraficaDiaria();
            } else if (graficas.getJrMensual().isSelected()) {
                reporte.agregarParametro("año", graficas.obtenerAño());
                reporte.verReporteGraficaMensual();
            } else {
                reporte.agregarParametro("añoDesde", graficas.getJcbAñoDesde().getSelectedItem().toString());
                reporte.agregarParametro("añoHasta", graficas.getJcbAñoHasta().getSelectedItem().toString());
                reporte.verReporteGraficaAños();

            }
        } else if (generar.equals("caja")) {
            if (caja.getJrTodos().isSelected()) {
                fechaDesdeHasta(caja.getjFechaDesde(), caja.getjFechaHasta());
                reporte.verReporteMovimientoCaja();
            } else if (caja.getJrCajero().isSelected()) {
                fechaDesdeHasta(caja.getDia(), caja.getDia());
                reporte.agregarParametro("cajero", caja.getCodigoCajero());
                if (caja.getJrMovimientos().isSelected()) {                    
                    reporte.verReporteMovimientoCajaDetallado();
                   // reporte.elimnarSubReport();
                } else {
                    
                    reporte.verReporteMovimientoCajaDetallado_Cierre();
                   // reporte.elimnarSubReport();
                }

            }
        }
    }

    public void limpiar() {
        busqueda.lblCodigo.setText("");
        busqueda.lblNombre.setText("");
        busqueda.getJrTodos().setSelected(true);
    }
}
