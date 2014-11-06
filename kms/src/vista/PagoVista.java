package vista;

import control.Caja;
import control.ObservadorEventos;
import utilidades.Utilidades;
import control.PuntoDeVenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import modelo.ModeloTabla;

/**
 *
 * @author Kymera Systems SAS
 */
public class PagoVista extends JDialog implements ActionListener, ObservadorEventos {

    private double paga;
    public VentaVista vista;
    public String cambio, pagaCon;
    private FacturaVista f;
    private boolean concatenar;
    private String cadena;
    MenuVista menu;

    public PagoVista(MenuVista padre, VentaVista vista) {
        super(padre, true);
        menu = padre;
        initComponents();
        this.vista = vista;
        txtPagaCon.setText("" + vista.tot);
        
        lblTotal.setText(vista.total);
        vista.fachada.getPtoVenta().addEscuchadorEventos(this);
        lblCambio.setText("" + Utilidades.darFormatoNumero(0));
        btnCancelar.addActionListener(this);
        txtPagaCon.requestFocus(true);
        txtPagaCon.selectAll();
        this.setLocation(350, 100);
        this.setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        pnlCentro = new javax.swing.JPanel();
        pnlTotal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        pnlPagaCon = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtPagaCon = new JTextField();
        lblPagaCon = new javax.swing.JLabel();
        pnlCambio = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblCambio = new javax.swing.JLabel();
        pnlNumeros = new javax.swing.JPanel();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btnEnter = new javax.swing.JButton();
        btn0 = new javax.swing.JButton();
        pnlBotones = new javax.swing.JPanel();
        btnImprimir = new javax.swing.JButton();
        btnTerminarVenta = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        pnlPrincipal.setLayout(new java.awt.BorderLayout());

        pnlCentro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Facturar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 11))); // NOI18N

        pnlTotal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        pnlTotal.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20, 5));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18));
        jLabel1.setForeground(new java.awt.Color(72, 76, 247));
        jLabel1.setText("Total a Pagar:");
        pnlTotal.add(jLabel1);

        lblTotal.setFont(new java.awt.Font("Verdana", 1, 18));
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setPreferredSize(new java.awt.Dimension(150, 23));
        pnlTotal.add(lblTotal);

        pnlPagaCon.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        pnlPagaCon.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20, 5));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 18));
        jLabel3.setForeground(new java.awt.Color(72, 76, 247));
        jLabel3.setText("Paga Con:");
        pnlPagaCon.add(jLabel3);

        txtPagaCon.setFont(new java.awt.Font("Verdana", 1, 18));
        txtPagaCon.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtPagaCon.setText("0");
        txtPagaCon.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtPagaCon.setPreferredSize(new java.awt.Dimension(190, 23));
        txtPagaCon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPagaConKeyReleased(evt);
            }
        });
        pnlPagaCon.add(txtPagaCon);

        lblPagaCon.setFont(new java.awt.Font("Verdana", 1, 18));
        lblPagaCon.setText("$70.000");
        lblPagaCon.setPreferredSize(new java.awt.Dimension(140, 23));
        pnlPagaCon.add(lblPagaCon);

        pnlCambio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        pnlCambio.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20, 5));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18));
        jLabel2.setForeground(new java.awt.Color(72, 76, 247));
        jLabel2.setText("Cambio:");
        pnlCambio.add(jLabel2);

        lblCambio.setFont(new java.awt.Font("Verdana", 1, 18));
        lblCambio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCambio.setPreferredSize(new java.awt.Dimension(210, 23));
        pnlCambio.add(lblCambio);

        pnlNumeros.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        pnlNumeros.setLayout(new java.awt.GridLayout(4, 4));

        btn1.setFont(new java.awt.Font("Verdana", 1, 14));
        btn1.setText("1");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        pnlNumeros.add(btn1);

        btn2.setFont(new java.awt.Font("Verdana", 1, 14));
        btn2.setText("2");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        pnlNumeros.add(btn2);

        btn3.setFont(new java.awt.Font("Verdana", 1, 14));
        btn3.setText("3");
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        pnlNumeros.add(btn3);

        btnAtras.setFont(new java.awt.Font("Verdana", 1, 14));
        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borra1.png"))); // NOI18N
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        pnlNumeros.add(btnAtras);

        btn4.setFont(new java.awt.Font("Verdana", 1, 14));
        btn4.setText("4");
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        pnlNumeros.add(btn4);

        btn5.setFont(new java.awt.Font("Verdana", 1, 14));
        btn5.setText("5");
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });
        pnlNumeros.add(btn5);

        btn6.setFont(new java.awt.Font("Verdana", 1, 14));
        btn6.setText("6");
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });
        pnlNumeros.add(btn6);

        btnBorrar.setFont(new java.awt.Font("Verdana", 1, 14));
        btnBorrar.setText("C");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        pnlNumeros.add(btnBorrar);

        btn7.setFont(new java.awt.Font("Verdana", 1, 14));
        btn7.setText("7");
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });
        pnlNumeros.add(btn7);

        btn8.setFont(new java.awt.Font("Verdana", 1, 14));
        btn8.setText("8");
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });
        pnlNumeros.add(btn8);

        btn9.setFont(new java.awt.Font("Verdana", 1, 14));
        btn9.setText("9");
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });
        pnlNumeros.add(btn9);

        btnEnter.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnEnter.setText("Cambio");
        btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterActionPerformed(evt);
            }
        });
        pnlNumeros.add(btnEnter);

        btn0.setFont(new java.awt.Font("Verdana", 1, 14));
        btn0.setText("0");
        btn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0ActionPerformed(evt);
            }
        });
        pnlNumeros.add(btn0);

        pnlBotones.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        btnImprimir.setMnemonic('V');
        btnImprimir.setText("Ver Tiquete");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        pnlBotones.add(btnImprimir);

        btnTerminarVenta.setMnemonic('T');
        btnTerminarVenta.setText("Terminar Venta");
        btnTerminarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarVentaActionPerformed(evt);
            }
        });
        pnlBotones.add(btnTerminarVenta);

        btnCancelar.setMnemonic('C');
        btnCancelar.setText("Cancelar");
        pnlBotones.add(btnCancelar);

        javax.swing.GroupLayout pnlCentroLayout = new javax.swing.GroupLayout(pnlCentro);
        pnlCentro.setLayout(pnlCentroLayout);
        pnlCentroLayout.setHorizontalGroup(
            pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCentroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlCambio, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                    .addComponent(pnlPagaCon, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                    .addComponent(pnlTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                    .addGroup(pnlCentroLayout.createSequentialGroup()
                        .addComponent(pnlBotones, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(pnlNumeros, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)))
        );
        pnlCentroLayout.setVerticalGroup(
            pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCentroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPagaCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlNumeros, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlCentro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                        .addGap(347, 347, 347))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCentro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 4, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTerminarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarVentaActionPerformed
        paga = Double.parseDouble(txtPagaCon.getText());
        FachadaInterfaz.getInstancia().deducirCambio(paga);
        List lst = cargarDatosDeTabla();
        paga = Double.parseDouble(txtPagaCon.getText());
        pagaCon = Utilidades.darFormatoNumero(paga);
        vista.fachada.establecerImpuesto(Caja.VENTA);
        f = new FacturaVista(vista.menu, true, this);
        f.setContenido(lst);
        if (vista.verTiquete) {
            try {
                UIManager.setLookAndFeel(new MetalLookAndFeel());
                f.setVisible(true);
            } catch (Exception e) {
            }
        } else {
            if (MenuVista.IMPRIMIR_TIQUETE) {
                f.imprimir();
            }else{
                this.guardarVenta();
            }
        }
        this.dispose();

    }//GEN-LAST:event_btnTerminarVentaActionPerformed

    public void guardarVenta() {
        if (!lblCambio.getText().equals("")) {
            FachadaInterfaz.getInstancia().terminarVenta();
            dispose();
            MenuVista.setInternal(2);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnCancelar)) {
            this.dispose();
        } 
    }

    public void escuchadorEvento(Object obj, String propiedad, Object valor) {
        if (propiedad.equals(PuntoDeVenta.CAMBIO_VENTA)) {
            try {
                double cam = Double.parseDouble(valor.toString());
                if (cam >= 0) {
                    cambio = "" + Utilidades.darFormatoNumero(cam);
                    lblCambio.setText(cambio);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Debe Ingresar con Cuanto va a Pagar!!!");
            } finally {
                txtPagaCon.requestFocus(true);
                txtPagaCon.selectAll();
            }
        }
    }
    private void txtPagaConKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagaConKeyReleased
        txtPagaCon.selectAll();
        String str = txtPagaCon.getText();
        String texto = Utilidades.contenidoCajaTexto(str);
        txtPagaCon.setText(texto);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                paga = Double.parseDouble(txtPagaCon.getText());
                FachadaInterfaz.getInstancia().deducirCambio(paga);

            } catch (NumberFormatException ce) {
                JOptionPane.showMessageDialog(null, "Se esperaba dato numerico");
            } finally {
                txtPagaCon.selectAll();
                getRootPane().setDefaultButton(btnTerminarVenta);
            }
        }
    }//GEN-LAST:event_txtPagaConKeyReleased
    public List cargarDatosDeTabla() {
        String producto = null, valor = null, subtotal = null, cantidad = null, codigo = null;
        String descuento = null;
        List list = new ArrayList();
        for (int i = 0; i < ((ModeloTabla) vista.tabla.getModel()).contFilas; i++) {
            for (int j = 0; j <= 5; j++) {
                cantidad = ((ModeloTabla) vista.tabla.getModel()).getValueAt(i, j).toString();
                codigo = ((ModeloTabla) vista.tabla.getModel()).getValueAt(i, ++j).toString();
                producto = ((ModeloTabla) vista.tabla.getModel()).getValueAt(i, ++j).toString();
                valor = ((ModeloTabla) vista.tabla.getModel()).getValueAt(i, ++j).toString();
                descuento = ((ModeloTabla) vista.tabla.getModel()).getValueAt(i, ++j).toString();
                subtotal = ((ModeloTabla) vista.tabla.getModel()).getValueAt(i, ++j).toString();
                list.add(producto);
                list.add(cantidad);
                list.add(valor);
                list.add(subtotal);
                list.add(descuento);
            }
        }
        return list;
    }

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        List lst = cargarDatosDeTabla();
        paga = Double.parseDouble(txtPagaCon.getText());
        pagaCon = Utilidades.darFormatoNumero(paga);
        deducirCambio();
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
            vista.fachada.establecerImpuesto(Caja.VENTA);
            f = new FacturaVista(vista.menu, true, this);
            f.setContenido(lst);
            f.setVisible(true);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        insertarNumero("1");
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        insertarNumero("2");
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        insertarNumero("3");
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        insertarNumero("4");
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        insertarNumero("5");
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        insertarNumero("6");
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        insertarNumero("7");
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        insertarNumero("8");
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        insertarNumero("9");
    }//GEN-LAST:event_btn9ActionPerformed

    private void btn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0ActionPerformed
        insertarNumero("0");
    }//GEN-LAST:event_btn0ActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        cadena = txtPagaCon.getText();
        if (!cadena.equals("") && cadena != null) {
            cadena = cadena.substring(0, cadena.length() - 1);
            if (cadena.equals("")) {
                cadena = "0";
                concatenar = false;
            }
            txtPagaCon.setText(cadena);
        }
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        concatenar = false;
        txtPagaCon.setText("0");
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterActionPerformed
        deducirCambio();
    }//GEN-LAST:event_btnEnterActionPerformed

    public void deducirCambio() {
        try {
            paga = Double.parseDouble(txtPagaCon.getText());
            FachadaInterfaz.getInstancia().deducirCambio(paga);

        } catch (NumberFormatException ce) {
            JOptionPane.showMessageDialog(null, "Se esperaba dato numerico");
        } finally {
            txtPagaCon.requestFocus(true);
            txtPagaCon.selectAll();
        }
    }

    private void insertarNumero(String numero) {
        if (concatenar) {
            cadena = txtPagaCon.getText() + numero;

        } else {
            cadena = numero;
            concatenar = true;
        }
        txtPagaCon.setText(cadena);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEnter;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnTerminarVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblCambio;
    private javax.swing.JLabel lblPagaCon;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlCambio;
    private javax.swing.JPanel pnlCentro;
    private javax.swing.JPanel pnlNumeros;
    private javax.swing.JPanel pnlPagaCon;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPanel pnlTotal;
    private javax.swing.JTextField txtPagaCon;
    // End of variables declaration//GEN-END:variables
}
