/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelDetalleVenta.java
 *
 * Created on 16/01/2010, 09:44:31 AM
 */
package vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;

/**
 *
 * @author 
 */
public class PanelDetalleVenta extends javax.swing.JPanel {

    FachadaInterfaz fachada;

    public PanelDetalleVenta() {
        initComponents();
        fachada = FachadaInterfaz.getInstancia();
        cargarComboCategoria();
        cargarComboProducto();
        cargarComboCajero();
        ventaVisible(false);
        categoriaVisible(false);
        cajeroVisible(false);
        productoVisible(false);
        this.setSize(500, 30000);
        this.setVisible(false);
    }

    public JDateChooser getJdateFecha_desde() {
        return jdateFecha_desde;
    }

    public JDateChooser getJdateFecha_desdeC() {
        return jdateFecha_desdeC;
    }

    public JDateChooser getJdateFecha_desdeCa() {
        return jdateFecha_desdeCa;
    }

    public JDateChooser getJdateFecha_desdeP() {
        return jdateFecha_desdeP;
    }

    public JDateChooser getJdateFecha_hasta() {
        return jdateFecha_hasta;
    }

    public JDateChooser getJdateFecha_hastaC() {
        return jdateFecha_hastaC;
    }

    public JDateChooser getJdateFecha_hastaCa() {
        return jdateFecha_hastaCa;
    }

    public JDateChooser getJdateFecha_hastaP() {
        return jdateFecha_hastaP;
    }

    public JRadioButton getJrbCajero() {
        return jrbCajero;
    }

    public JRadioButton getJrbPorCategoria() {
        return jrbPorCategoria;
    }

    public JRadioButton getJrbPorVenta() {
        return jrbPorVenta;
    }

    public JRadioButton getJrbProducto() {
        return jrbProducto;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlVenta = new javax.swing.JPanel();
        pnlFecha = new javax.swing.JPanel();
        lblFecha_desde = new javax.swing.JLabel();
        jdateFecha_desde = new com.toedter.calendar.JDateChooser();
        lblFecha_hasta = new javax.swing.JLabel();
        jdateFecha_hasta = new com.toedter.calendar.JDateChooser();
        pnlCategoria = new javax.swing.JPanel();
        jcbCategoria = new javax.swing.JComboBox();
        pnlFecha1 = new javax.swing.JPanel();
        lblFecha_desde1 = new javax.swing.JLabel();
        jdateFecha_desdeC = new com.toedter.calendar.JDateChooser();
        lblFecha_hasta1 = new javax.swing.JLabel();
        jdateFecha_hastaC = new com.toedter.calendar.JDateChooser();
        pnlCajero = new javax.swing.JPanel();
        jcbCajero = new javax.swing.JComboBox();
        pnlFecha3 = new javax.swing.JPanel();
        lblFecha_desde3 = new javax.swing.JLabel();
        jdateFecha_desdeCa = new com.toedter.calendar.JDateChooser();
        lblFecha_hasta3 = new javax.swing.JLabel();
        jdateFecha_hastaCa = new com.toedter.calendar.JDateChooser();
        pnlProducto = new javax.swing.JPanel();
        jcbProducto = new javax.swing.JComboBox();
        pnlFecha2 = new javax.swing.JPanel();
        lblFecha_desde2 = new javax.swing.JLabel();
        jdateFecha_desdeP = new com.toedter.calendar.JDateChooser();
        lblFecha_hasta2 = new javax.swing.JLabel();
        jdateFecha_hastaP = new com.toedter.calendar.JDateChooser();
        jrbPorVenta = new javax.swing.JRadioButton();
        jrbPorCategoria = new javax.swing.JRadioButton();
        jrbProducto = new javax.swing.JRadioButton();
        jrbCajero = new javax.swing.JRadioButton();

        pnlVenta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlVenta.setPreferredSize(new java.awt.Dimension(273, 100));

        lblFecha_desde.setText("Fecha Desde");

        lblFecha_hasta.setText("Fecha Hasta");

        javax.swing.GroupLayout pnlFechaLayout = new javax.swing.GroupLayout(pnlFecha);
        pnlFecha.setLayout(pnlFechaLayout);
        pnlFechaLayout.setHorizontalGroup(
            pnlFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFechaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFechaLayout.createSequentialGroup()
                        .addComponent(lblFecha_desde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(pnlFechaLayout.createSequentialGroup()
                        .addComponent(lblFecha_hasta, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                        .addGap(20, 20, 20)))
                .addGap(11, 11, 11)
                .addGroup(pnlFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdateFecha_hasta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jdateFecha_desde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlFechaLayout.setVerticalGroup(
            pnlFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFechaLayout.createSequentialGroup()
                .addGroup(pnlFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jdateFecha_desde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlFechaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblFecha_desde, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jdateFecha_hasta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlFechaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblFecha_hasta, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout pnlVentaLayout = new javax.swing.GroupLayout(pnlVenta);
        pnlVenta.setLayout(pnlVentaLayout);
        pnlVentaLayout.setHorizontalGroup(
            pnlVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVentaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlVentaLayout.setVerticalGroup(
            pnlVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVentaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlCategoria.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jcbCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Categoria" }));

        lblFecha_desde1.setText("Fecha Desde");

        lblFecha_hasta1.setText("Fecha Hasta");

        javax.swing.GroupLayout pnlFecha1Layout = new javax.swing.GroupLayout(pnlFecha1);
        pnlFecha1.setLayout(pnlFecha1Layout);
        pnlFecha1Layout.setHorizontalGroup(
            pnlFecha1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFecha1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFecha1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFecha1Layout.createSequentialGroup()
                        .addComponent(lblFecha_desde1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(pnlFecha1Layout.createSequentialGroup()
                        .addComponent(lblFecha_hasta1, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                        .addGap(20, 20, 20)))
                .addGap(11, 11, 11)
                .addGroup(pnlFecha1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdateFecha_hastaC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jdateFecha_desdeC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlFecha1Layout.setVerticalGroup(
            pnlFecha1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFecha1Layout.createSequentialGroup()
                .addGroup(pnlFecha1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jdateFecha_desdeC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlFecha1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblFecha_desde1, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFecha1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jdateFecha_hastaC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlFecha1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblFecha_hasta1, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout pnlCategoriaLayout = new javax.swing.GroupLayout(pnlCategoria);
        pnlCategoria.setLayout(pnlCategoriaLayout);
        pnlCategoriaLayout.setHorizontalGroup(
            pnlCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCategoriaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jcbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );
        pnlCategoriaLayout.setVerticalGroup(
            pnlCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCategoriaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlCajero.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlCajero.setPreferredSize(new java.awt.Dimension(273, 100));

        jcbCajero.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Cajero" }));

        lblFecha_desde3.setText("Fecha Desde");

        lblFecha_hasta3.setText("Fecha Hasta");

        javax.swing.GroupLayout pnlFecha3Layout = new javax.swing.GroupLayout(pnlFecha3);
        pnlFecha3.setLayout(pnlFecha3Layout);
        pnlFecha3Layout.setHorizontalGroup(
            pnlFecha3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFecha3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFecha3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFecha3Layout.createSequentialGroup()
                        .addComponent(lblFecha_desde3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(pnlFecha3Layout.createSequentialGroup()
                        .addComponent(lblFecha_hasta3, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                        .addGap(20, 20, 20)))
                .addGap(11, 11, 11)
                .addGroup(pnlFecha3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdateFecha_hastaCa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jdateFecha_desdeCa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlFecha3Layout.setVerticalGroup(
            pnlFecha3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFecha3Layout.createSequentialGroup()
                .addGroup(pnlFecha3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jdateFecha_desdeCa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlFecha3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblFecha_desde3, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFecha3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jdateFecha_hastaCa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlFecha3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblFecha_hasta3, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout pnlCajeroLayout = new javax.swing.GroupLayout(pnlCajero);
        pnlCajero.setLayout(pnlCajeroLayout);
        pnlCajeroLayout.setHorizontalGroup(
            pnlCajeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCajeroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCajeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbCajero, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlFecha3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(2, Short.MAX_VALUE))
        );
        pnlCajeroLayout.setVerticalGroup(
            pnlCajeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCajeroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcbCajero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlFecha3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlProducto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlProducto.setPreferredSize(new java.awt.Dimension(273, 100));

        jcbProducto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Producto" }));

        lblFecha_desde2.setText("Fecha Desde");

        lblFecha_hasta2.setText("Fecha Hasta");

        javax.swing.GroupLayout pnlFecha2Layout = new javax.swing.GroupLayout(pnlFecha2);
        pnlFecha2.setLayout(pnlFecha2Layout);
        pnlFecha2Layout.setHorizontalGroup(
            pnlFecha2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFecha2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFecha2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFecha2Layout.createSequentialGroup()
                        .addComponent(lblFecha_desde2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(pnlFecha2Layout.createSequentialGroup()
                        .addComponent(lblFecha_hasta2, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                        .addGap(20, 20, 20)))
                .addGap(11, 11, 11)
                .addGroup(pnlFecha2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdateFecha_hastaP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jdateFecha_desdeP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlFecha2Layout.setVerticalGroup(
            pnlFecha2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFecha2Layout.createSequentialGroup()
                .addGroup(pnlFecha2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jdateFecha_desdeP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlFecha2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblFecha_desde2, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFecha2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jdateFecha_hastaP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlFecha2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblFecha_hasta2, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout pnlProductoLayout = new javax.swing.GroupLayout(pnlProducto);
        pnlProducto.setLayout(pnlProductoLayout);
        pnlProductoLayout.setHorizontalGroup(
            pnlProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductoLayout.createSequentialGroup()
                .addGroup(pnlProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlProductoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlFecha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlProductoLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jcbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlProductoLayout.setVerticalGroup(
            pnlProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFecha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonGroup1.add(jrbPorVenta);
        jrbPorVenta.setText("Por Venta");
        jrbPorVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbPorVentaActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrbPorCategoria);
        jrbPorCategoria.setText("Por Categoria");
        jrbPorCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbPorCategoriaActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrbProducto);
        jrbProducto.setText("Por Producto");
        jrbProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbProductoActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrbCajero);
        jrbCajero.setText("Por Cajero");
        jrbCajero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbCajeroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jrbCajero, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                                .addGap(86, 86, 86))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(pnlCajero, javax.swing.GroupLayout.Alignment.LEADING, 0, 307, Short.MAX_VALUE)
                                .addComponent(jrbProducto, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jrbPorCategoria, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pnlProducto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                                .addComponent(pnlCategoria, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jrbPorVenta)
                        .addGap(253, 253, 253))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jrbPorVenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jrbPorCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jrbProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jrbCajero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCajero, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jrbPorVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbPorVentaActionPerformed
        ventaVisible(true);
        categoriaVisible(false);
        cajeroVisible(false);
        productoVisible(false);
    }//GEN-LAST:event_jrbPorVentaActionPerformed

    private void jrbPorCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbPorCategoriaActionPerformed
        ventaVisible(false);
        categoriaVisible(true);
        cajeroVisible(false);
        productoVisible(false);
    }//GEN-LAST:event_jrbPorCategoriaActionPerformed

    private void jrbProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbProductoActionPerformed
        ventaVisible(false);
        categoriaVisible(false);
        cajeroVisible(false);
        productoVisible(true);
    }//GEN-LAST:event_jrbProductoActionPerformed

    private void jrbCajeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbCajeroActionPerformed
        ventaVisible(false);
        categoriaVisible(false);
        cajeroVisible(true);
        productoVisible(false);
    }//GEN-LAST:event_jrbCajeroActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox jcbCajero;
    private javax.swing.JComboBox jcbCategoria;
    private javax.swing.JComboBox jcbProducto;
    private com.toedter.calendar.JDateChooser jdateFecha_desde;
    private com.toedter.calendar.JDateChooser jdateFecha_desdeC;
    private com.toedter.calendar.JDateChooser jdateFecha_desdeCa;
    private com.toedter.calendar.JDateChooser jdateFecha_desdeP;
    private com.toedter.calendar.JDateChooser jdateFecha_hasta;
    private com.toedter.calendar.JDateChooser jdateFecha_hastaC;
    private com.toedter.calendar.JDateChooser jdateFecha_hastaCa;
    private com.toedter.calendar.JDateChooser jdateFecha_hastaP;
    private javax.swing.JRadioButton jrbCajero;
    private javax.swing.JRadioButton jrbPorCategoria;
    private javax.swing.JRadioButton jrbPorVenta;
    private javax.swing.JRadioButton jrbProducto;
    private javax.swing.JLabel lblFecha_desde;
    private javax.swing.JLabel lblFecha_desde1;
    private javax.swing.JLabel lblFecha_desde2;
    private javax.swing.JLabel lblFecha_desde3;
    private javax.swing.JLabel lblFecha_hasta;
    private javax.swing.JLabel lblFecha_hasta1;
    private javax.swing.JLabel lblFecha_hasta2;
    private javax.swing.JLabel lblFecha_hasta3;
    private javax.swing.JPanel pnlCajero;
    private javax.swing.JPanel pnlCategoria;
    private javax.swing.JPanel pnlFecha;
    private javax.swing.JPanel pnlFecha1;
    private javax.swing.JPanel pnlFecha2;
    private javax.swing.JPanel pnlFecha3;
    private javax.swing.JPanel pnlProducto;
    private javax.swing.JPanel pnlVenta;
    // End of variables declaration//GEN-END:variables

    private void categoriaVisible(boolean b) {
        pnlCategoria.setVisible(b);
    }

    private void cajeroVisible(boolean b) {
        pnlCajero.setVisible(b);
    }

    private void productoVisible(boolean b) {
        pnlProducto.setVisible(b);
    }

    private void ventaVisible(boolean b) {
        pnlVenta.setVisible(b);
    }

    public void cargarComboCategoria() {
        jcbCategoria.setModel(new ModeloCombo(fachada.getCategoria()));
        jcbCategoria.getModel().setSelectedItem("Seleccione Una Categoria");
    }

    public void cargarComboProducto() {
        jcbProducto.setModel(new ModeloCombo(fachada.getProductos()));
        jcbProducto.getModel().setSelectedItem("Seleccione Un Producto");
    }

    public void cargarComboCajero() {
        jcbCajero.setModel(new ModeloCombo(fachada.getEmpleados()));
        jcbCajero.getModel().setSelectedItem("Seleccione Un Cajero");
    }

    public String getCodigo(String modulo) {
        if (modulo.equalsIgnoreCase("cajero")) {
            
            return (String) ((ModeloCombo) jcbCajero.getModel()).getSelectedIndex();
        } else if (modulo.equalsIgnoreCase("categoria")) {
             
            return (String) ((ModeloCombo) jcbCategoria.getModel()).getSelectedIndex();
        } else {
             
            return (String) ((ModeloCombo) jcbProducto.getModel()).getSelectedIndex();
        }
    }
}
