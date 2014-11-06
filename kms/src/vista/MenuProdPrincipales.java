package vista;

import control.Caja;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import modelo.Producto;
import persistenciaFWK.ManejadorArchivos;

/**
 *
 * @author Kymera Systems SAS
 */
public class MenuProdPrincipales extends VentanaInternaAbs implements KeyListener {

    private Border bordePresionado, bordeNoPresionado;
    private Cursor cursorMano;
    private FachadaInterfaz fachada;
    private Producto pr;
    private List prodID;
    private int numItems;
    public static Object[] numProductos = {"Seis", "Nueve", "Doce"};
    private Object opc;
    private final int propiedad = Caja.VENTA;
    public static boolean exito = true;
    private VentaVista venta;

    /** Creates new form MenuProdPrincipales */
    public MenuProdPrincipales(VentaVista venta) {
        initComponents();
        this.venta = venta;
        this.btnOcultar.addKeyListener(this);

        prodID = new ArrayList();
        fachada = FachadaInterfaz.getInstancia();
        bordePresionado = BorderFactory.createCompoundBorder(new SoftBevelBorder(BevelBorder.RAISED), new SoftBevelBorder(BevelBorder.LOWERED));
        bordeNoPresionado = BorderFactory.createCompoundBorder(new SoftBevelBorder(BevelBorder.RAISED), new SoftBevelBorder(BevelBorder.RAISED));
        cursorMano = new Cursor(Cursor.HAND_CURSOR);
        try {
            ManejadorArchivos ma = new ManejadorArchivos(Configuracion.ARCHIVO);
            numItems = Integer.parseInt(ma.cargarDatoDesencriptado(ManejadorArchivos.CANTIDAD_ITEMS));
            for (int i = 0; i < numItems; i++) {
                String id = ma.cargarDatoDesencriptado(ManejadorArchivos.CANTIDAD_ITEMS + i);
                prodID.add(id);
                pr = (Producto) fachada.buscarProductoXID(id);
                JLabel label = validarLabel(i);
                if (pr.getFoto() == null) {
                    ImageIcon icon = new ImageIcon("src/imagenes/productoNotFound.png");
                    cargarImagen(icon, label, pr.getDescripcion());
                } else {
                    cargarImagen(pr.getFoto(), label, pr.getDescripcion());
                }
            }
            if (numItems == 0) {
                exito = false;
                numItems = 0;
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (NullPointerException ex) {
            cargarSelectProd();
        }
        this.habilitarBotones(numItems);
        int anchoPantalla = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        if(anchoPantalla > 1280){

             this.setLocation(874, 0);

        }else{
             this.setLocation(740, 0);
        }
        this.setSize(140, 535);

    }

    public void cargarSelectProd() {
        int num;
        JOptionPane.showMessageDialog(null, "Debe Configurar El Menu En la Barra Principal - Configuracion!!!");
        opc = JOptionPane.showInputDialog(this, "Seleccione el Numero de Productos que desea Cargar!!!",
                "Seleccion Productos Principales", JOptionPane.QUESTION_MESSAGE, null, numProductos, numProductos[0]);
        if (opc == numProductos[0]) {
            num = 6;
        } else if (opc == numProductos[1]) {
            num = 9;
        } else if (opc == numProductos[2]) {
            num = 12;
        } else {
            num = 0;
        }
        if (num != 0) {
            new SelectProduct(MenuVista.getInstancia(), true, num);
        }
        this.dispose();
    }

    public JLabel validarLabel(int i) {
        JLabel label = null;
        switch (i) {
            case 0: {
                label = lblPro1;
                break;
            }
            case 1: {
                label = lblPro2;
                break;
            }
            case 2: {
                label = lblPro3;
                break;
            }
            case 3: {
                label = lblPro4;
                break;
            }
            case 4: {
                label = lblPro5;
                break;
            }
            case 5: {
                label = lblPro6;
                break;
            }
            case 6: {
                label = lblPro7;
                break;
            }
            case 7: {
                label = lblPro8;
                break;
            }
            case 8: {
                label = lblPro9;
                break;
            }
            case 9: {
                label = lblPro10;
                break;
            }
            case 10: {
                label = lblPro11;
                break;
            }
            case 11: {
                label = lblPro12;
                break;
            }
        }
        return label;
    }

    public void cargarImagen(byte[] imag, JLabel label, String descripcion) {
        if (imag != null) {
            ImageIcon img = new ImageIcon(imag);
            escalarImagen(img, label);
            label.setToolTipText(descripcion);
        } else {
            label.setIcon(null);
            label.setToolTipText(descripcion);
        }
    }

    public void cargarImagen(ImageIcon imag, JLabel label, String descripcion) {
        if (imag != null) {
            ImageIcon img = imag;
            escalarImagen(img, label);
            label.setToolTipText(descripcion);
        } else {
            label.setIcon(null);
            label.setToolTipText(descripcion);
        }
    }

    public void escalarImagen(ImageIcon img, JLabel label) {
        if (img != null) {
            if (img.getIconWidth() > 90) {
                img = new ImageIcon(img.getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
            }
            label.setIcon(img);
        }
    }

    public void habilitarBotones(int num) {
        switch (num) {
            case 0:{
                break;
            }
            case 6: {
                pnlCentro.remove(lblPro7);
                pnlCentro.remove(lblPro8);
                pnlCentro.remove(lblPro9);
                pnlCentro.remove(lblPro10);
                pnlCentro.remove(lblPro11);
                pnlCentro.remove(lblPro12);
                pnlCentro.setPreferredSize(new Dimension(284, 200));
                this.setSize(314, 300);
                this.setVisible(true);
                break;
            }
            case 9: {
                pnlCentro.remove(lblPro10);
                pnlCentro.remove(lblPro11);
                pnlCentro.remove(lblPro12);
                pnlCentro.setPreferredSize(new Dimension(284, 286));
                this.setSize(314, 390);
                this.setVisible(true);
                break;
            }
            default: {
                this.setSize(314, 460);
                this.setLocation(250, 100);
                this.setVisible(true);
                break;
            }
        }
    }

    public boolean creadaExitosamente(boolean exito){
        return exito;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCentro = new javax.swing.JPanel();
        lblPro1 = new javax.swing.JLabel();
        lblPro2 = new javax.swing.JLabel();
        lblPro3 = new javax.swing.JLabel();
        lblPro4 = new javax.swing.JLabel();
        lblPro5 = new javax.swing.JLabel();
        lblPro6 = new javax.swing.JLabel();
        lblPro7 = new javax.swing.JLabel();
        lblPro8 = new javax.swing.JLabel();
        lblPro9 = new javax.swing.JLabel();
        lblPro10 = new javax.swing.JLabel();
        lblPro11 = new javax.swing.JLabel();
        lblPro12 = new javax.swing.JLabel();
        pnlBotones = new javax.swing.JPanel();
        btnOcultar = new javax.swing.JButton();

        pnlCentro.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        lblPro1.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        lblPro1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPro1MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblPro1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblPro1MouseReleased(evt);
            }
        });

        lblPro2.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        lblPro2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPro2MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblPro2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblPro2MouseReleased(evt);
            }
        });

        lblPro3.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        lblPro3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPro3MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblPro3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblPro3MouseReleased(evt);
            }
        });

        lblPro4.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        lblPro4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPro4MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblPro4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblPro4MouseReleased(evt);
            }
        });

        lblPro5.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        lblPro5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPro5MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblPro5MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblPro5MouseReleased(evt);
            }
        });

        lblPro6.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        lblPro6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPro6MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblPro6MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblPro6MouseReleased(evt);
            }
        });

        lblPro7.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        lblPro7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPro7MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblPro7MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblPro7MouseReleased(evt);
            }
        });

        lblPro8.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        lblPro8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPro8MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblPro8MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblPro8MouseReleased(evt);
            }
        });

        lblPro9.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        lblPro9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPro9MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblPro9MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblPro9MouseReleased(evt);
            }
        });

        lblPro10.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        lblPro10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPro10MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblPro10MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblPro10MouseReleased(evt);
            }
        });

        lblPro11.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        lblPro11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPro11MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblPro11MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblPro11MouseReleased(evt);
            }
        });

        lblPro12.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        lblPro12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPro12MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblPro12MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblPro12MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout pnlCentroLayout = new javax.swing.GroupLayout(pnlCentro);
        pnlCentro.setLayout(pnlCentroLayout);
        pnlCentroLayout.setHorizontalGroup(
            pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addGroup(pnlCentroLayout.createSequentialGroup()
                    .addComponent(lblPro1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lblPro2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlCentroLayout.createSequentialGroup()
                    .addComponent(lblPro3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lblPro4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlCentroLayout.createSequentialGroup()
                    .addComponent(lblPro5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lblPro6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlCentroLayout.createSequentialGroup()
                    .addComponent(lblPro7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lblPro8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlCentroLayout.createSequentialGroup()
                    .addComponent(lblPro9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lblPro10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlCentroLayout.createSequentialGroup()
                    .addComponent(lblPro11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lblPro12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        pnlCentroLayout.setVerticalGroup(
            pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCentroLayout.createSequentialGroup()
                .addGroup(pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPro1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPro2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPro4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPro3, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPro5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPro6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPro7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPro8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPro10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPro9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPro11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPro12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlBotones.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnOcultar.setMnemonic('O');
        btnOcultar.setText("Ocultar");
        btnOcultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOcultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBotonesLayout = new javax.swing.GroupLayout(pnlBotones);
        pnlBotones.setLayout(pnlBotonesLayout);
        pnlBotonesLayout.setHorizontalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBotonesLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(btnOcultar)
                .addGap(40, 40, 40))
        );
        pnlBotonesLayout.setVerticalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnOcultar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlCentro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCentro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblPro6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPro6MouseReleased
        lblPro6.setBorder(bordeNoPresionado);
}//GEN-LAST:event_lblPro6MouseReleased

    private void lblPro6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPro6MousePressed
        lblPro6.setBorder(bordePresionado);
        fachada.introducirArticulo(propiedad, prodID.get(5).toString(), 1);
}//GEN-LAST:event_lblPro6MousePressed

    private void lblPro6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPro6MouseEntered
        lblPro6.setCursor(cursorMano);
}//GEN-LAST:event_lblPro6MouseEntered

    private void lblPro5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPro5MouseReleased
        lblPro5.setBorder(bordeNoPresionado);
}//GEN-LAST:event_lblPro5MouseReleased

    private void lblPro5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPro5MousePressed
        lblPro5.setBorder(bordePresionado);
        fachada.introducirArticulo(propiedad, prodID.get(4).toString(), 1);
}//GEN-LAST:event_lblPro5MousePressed

    private void lblPro5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPro5MouseEntered
        lblPro5.setCursor(cursorMano);
}//GEN-LAST:event_lblPro5MouseEntered

    private void lblPro4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPro4MouseReleased
        lblPro4.setBorder(bordeNoPresionado);
}//GEN-LAST:event_lblPro4MouseReleased

    private void lblPro4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPro4MousePressed
        lblPro4.setBorder(bordePresionado);
        fachada.introducirArticulo(propiedad, prodID.get(3).toString(), 1);
}//GEN-LAST:event_lblPro4MousePressed

    private void lblPro4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPro4MouseEntered
        lblPro4.setCursor(cursorMano);
}//GEN-LAST:event_lblPro4MouseEntered

    private void lblPro3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPro3MouseReleased
        lblPro3.setBorder(bordeNoPresionado);
}//GEN-LAST:event_lblPro3MouseReleased

    private void lblPro3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPro3MousePressed
        lblPro3.setBorder(bordePresionado);
        fachada.introducirArticulo(propiedad, prodID.get(2).toString(), 1);
}//GEN-LAST:event_lblPro3MousePressed

    private void lblPro3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPro3MouseEntered
        lblPro3.setCursor(cursorMano);
}//GEN-LAST:event_lblPro3MouseEntered

    private void lblPro2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPro2MouseReleased
        lblPro2.setBorder(bordeNoPresionado);
}//GEN-LAST:event_lblPro2MouseReleased

    private void lblPro2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPro2MousePressed
        lblPro2.setBorder(bordePresionado);
        fachada.introducirArticulo(propiedad, prodID.get(1).toString(), 1);
}//GEN-LAST:event_lblPro2MousePressed

    private void lblPro2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPro2MouseEntered
        lblPro2.setCursor(cursorMano);
}//GEN-LAST:event_lblPro2MouseEntered

    private void lblPro1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPro1MouseReleased
        lblPro1.setBorder(bordeNoPresionado);
}//GEN-LAST:event_lblPro1MouseReleased

    private void lblPro1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPro1MousePressed
        lblPro1.setBorder(bordePresionado);
        fachada.introducirArticulo(propiedad, prodID.get(0).toString(), 1);
}//GEN-LAST:event_lblPro1MousePressed

    private void lblPro1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPro1MouseEntered
        lblPro1.setCursor(cursorMano);
}//GEN-LAST:event_lblPro1MouseEntered

    private void lblPro9MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPro9MouseReleased
        lblPro9.setBorder(bordeNoPresionado);
}//GEN-LAST:event_lblPro9MouseReleased

    private void lblPro9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPro9MousePressed
        lblPro9.setBorder(bordePresionado);
        fachada.introducirArticulo(propiedad, prodID.get(8).toString(), 1);
}//GEN-LAST:event_lblPro9MousePressed

    private void lblPro9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPro9MouseEntered
        lblPro9.setCursor(cursorMano);
}//GEN-LAST:event_lblPro9MouseEntered

    private void lblPro8MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPro8MouseReleased
        lblPro8.setBorder(bordeNoPresionado);
}//GEN-LAST:event_lblPro8MouseReleased

    private void lblPro8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPro8MousePressed
        lblPro8.setBorder(bordePresionado);
        fachada.introducirArticulo(propiedad, prodID.get(7).toString(), 1);
}//GEN-LAST:event_lblPro8MousePressed

    private void lblPro8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPro8MouseEntered
        lblPro8.setCursor(cursorMano);
}//GEN-LAST:event_lblPro8MouseEntered

    private void lblPro7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPro7MouseReleased
        lblPro7.setBorder(bordeNoPresionado);
}//GEN-LAST:event_lblPro7MouseReleased

    private void lblPro7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPro7MousePressed
        lblPro7.setBorder(bordePresionado);
        fachada.introducirArticulo(propiedad, prodID.get(6).toString(), 1);
}//GEN-LAST:event_lblPro7MousePressed

    private void lblPro7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPro7MouseEntered
        lblPro7.setCursor(cursorMano);
}//GEN-LAST:event_lblPro7MouseEntered

    private void lblPro12MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPro12MouseReleased
        lblPro12.setBorder(bordeNoPresionado);
}//GEN-LAST:event_lblPro12MouseReleased

    private void lblPro12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPro12MousePressed
        lblPro12.setBorder(bordePresionado);
        fachada.introducirArticulo(propiedad, prodID.get(11).toString(), 1);
}//GEN-LAST:event_lblPro12MousePressed

    private void lblPro12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPro12MouseEntered
        lblPro12.setCursor(cursorMano);
}//GEN-LAST:event_lblPro12MouseEntered

    private void lblPro11MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPro11MouseReleased
        lblPro11.setBorder(bordeNoPresionado);
}//GEN-LAST:event_lblPro11MouseReleased

    private void lblPro11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPro11MousePressed
        lblPro11.setBorder(bordePresionado);
        fachada.introducirArticulo(propiedad, prodID.get(10).toString(), 1);
}//GEN-LAST:event_lblPro11MousePressed

    private void lblPro11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPro11MouseEntered
        lblPro11.setCursor(cursorMano);
}//GEN-LAST:event_lblPro11MouseEntered

    private void lblPro10MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPro10MouseReleased
        lblPro10.setBorder(bordeNoPresionado);
}//GEN-LAST:event_lblPro10MouseReleased

    private void lblPro10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPro10MousePressed
        lblPro10.setBorder(bordePresionado);
        fachada.introducirArticulo(propiedad, prodID.get(9).toString(), 1);
}//GEN-LAST:event_lblPro10MousePressed

    private void lblPro10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPro10MouseEntered
        lblPro10.setCursor(cursorMano);
}//GEN-LAST:event_lblPro10MouseEntered

    @Override
    public void establecerFoco() {
    }

    @Override
    public void setFocoGanado(FocusEvent evt) {
    }

    @Override
    public void setFocoPerdido(FocusEvent evt) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_F1){
            if (venta.tot != 0) {
                PagoVista pag = new PagoVista(MenuVista.getInstancia(), venta);
            }else{
                JOptionPane.showMessageDialog(null, "Debe Ingresar Productos!!!");
            }
        }
    }

    public void keyReleased(KeyEvent e) {
    }
    
    private void btnOcultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOcultarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnOcultarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOcultar;
    private javax.swing.JLabel lblPro1;
    private javax.swing.JLabel lblPro10;
    private javax.swing.JLabel lblPro11;
    private javax.swing.JLabel lblPro12;
    private javax.swing.JLabel lblPro2;
    private javax.swing.JLabel lblPro3;
    private javax.swing.JLabel lblPro4;
    private javax.swing.JLabel lblPro5;
    private javax.swing.JLabel lblPro6;
    private javax.swing.JLabel lblPro7;
    private javax.swing.JLabel lblPro8;
    private javax.swing.JLabel lblPro9;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlCentro;
    // End of variables declaration//GEN-END:variables

    
}
