package vista;

import control.PuntoDeVenta;
import java.util.Date;
import java.util.List;
import java.util.Map;
import utilidades.Impresion;
import utilidades.Utilidades;

/**
 *
 * @author Kymera Systems SAS
 */
public class CierreCaja extends javax.swing.JDialog {


    private String contenido,cajero;
    private StringBuilder buferContenido = new StringBuilder();
    private List pagos, recogidas;


    public CierreCaja(java.awt.Frame parent, boolean modal, List caja, List pagos, List recogidas, double recogidoCajero) {
        super(parent, modal);
        initComponents();

     
        lblNIT.setText(MenuVista.Nit);
        lblDireccion.setText(MenuVista.direccion);
        lblRazonSocial.setText(MenuVista.razonSocial);
        lblUbicacion.setText(MenuVista.ciudad);
        lblHora.setText(Utilidades.getHoraActual());
        lblFecha.setText(Utilidades.getFechaActual());

        if(PuntoDeVenta.usuarioActual.getUsuario().equals((String)caja.get(1))){
            cajero = PuntoDeVenta.getInstancia().getNombreUsuarioActual();
        }else{
            cajero = (String) caja.get(1);
        }
        this.lblCajero.setText(cajero);
        this.lblFechAper.setText((String) caja.get(2));
        this.lblFechCierre.setText((String) caja.get(3));
        this.lblHorAper.setText((String) caja.get(4));
        this.lblHorCierre.setText((String) caja.get(5));
        this.lblSaldoIni.setText("" + (Double) caja.get(6));
        this.lblSaldoFin.setText("" + (Double) caja.get(7));
        this.lblFactIni.setText((String) caja.get(8));
        this.lblFactFin.setText((String) caja.get(9));
        this.lblEstado.setText((String) caja.get(10));


        this.lblCant.setText("" + (Integer) caja.get(14));
        
        this.lblBase.setText("" + Utilidades.reducirDecimales((Double) caja.get(12)) );
   
        this.lblIva.setText("" +Utilidades.reducirDecimales((Double) caja.get(13)));
        
        this.lblTotalVentas.setText("" + Utilidades.reducirDecimales((Double) caja.get(7)));
        
        this.lblDinRecogido.setText(""+Utilidades.reducirDecimales(recogidoCajero));
        double valor = recogidoCajero - (Double) caja.get(7); // cuadre caja
        this.lblCuadre.setText(""+ Utilidades.reducirDecimales(valor));
        this.pagos = pagos;
        this.recogidas = recogidas;
        this.crearCabecera();
        this.setContenido();
       
        this.setLocation(350, 70);
        this.setVisible(true);

    }

    public void setContenido() {
        contenido = "\n";
        String tercero, fact, hora, autoriza;
        double totPagos = 0, totReco = 0, monto;
        
        buferContenido.append(Utilidades.centrarTexto("PAGOS",40)+ "\n");
        
        if (pagos == null) {
            contenido = "NO SE REALIZO NINGUN PAGO";
        } else {
            buferContenido.append("PAGADO A       FACT    MONTO    AUTORIZ. X\n");
            for (int i = 0; i < pagos.size(); i++) {
                List conten = (List) pagos.get(i);
                monto = (Double) conten.get(3);
                tercero = (String) conten.get(5);
                fact = (String) conten.get(7);
                autoriza = (String) conten.get(9);
                if(autoriza.length() >11){
                    autoriza = autoriza.substring(0,11);
                }
                totPagos += monto;
                if (tercero.length() < 15) {
                    int dif = 15 - tercero.length();
                    for (int j = 0; j < dif; j++) {
                        tercero += " ";
                    }
                } else if (tercero.length() >= 15) {
                    tercero = tercero.substring(0, 15);
                }
                contenido += Utilidades.establecerCaracteres(tercero, 12) + "   " + fact + "     " +
                        monto + "      " + Utilidades.establecerCaracteres(tercero, 12) + "\n";
            }
            contenido += "\n\n                        ===========\n" +
                "Total Pagos Realizados:     " + totPagos;

        }
        this.txtPagos.setText(contenido);
        txtPagos.append("\n*****************************************\n");
        buferContenido.append(txtPagos.getText());

        contenido = "";
        buferContenido.append(Utilidades.centrarTexto("RECOGIDAS DE EFECTIVO",40)+"\n");
        if (recogidas == null) {
            contenido = "NO SE REALIZO NINGUNA RECOGIDA";
        } else {
            buferContenido.append("RECOGIDO X          MONTO         HORA\n");
            for (int i = 0; i < recogidas.size(); i++) {
                List conten = (List) recogidas.get(i);
                monto = (Double) conten.get(3);
                tercero = (String) conten.get(9);
                hora = (String) conten.get(10);
                totReco += monto;
                if (tercero.length() < 21) {
                    int dif = 21 - tercero.length();
                    for (int j = 0; j < dif; j++) {
                        tercero += " ";
                    }
                } else if (tercero.length() >= 21) {
                    tercero = tercero.substring(0, 21);
                }
                contenido += Utilidades.establecerCaracteres(tercero, 12) + "       " + monto + "       " +
                        hora + "\n";
            }
            contenido += "\n\n                        ===========\n" +
                "Total Recogidas Realizadas:    " + totReco;
        }
        this.txtRcogidas.setText(contenido);
        
        txtRcogidas.append("\n*****************************************\n");

        this.buferContenido.append(txtRcogidas.getText());
        this.buferContenido.append("\n\n\n");
        this.buferContenido.append("\n\n\n");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBotones = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlConten = new javax.swing.JPanel();
        lblRazonSocial = new javax.swing.JLabel();
        lblNIT = new javax.swing.JLabel();
        lblUbicacion = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        labelCajero = new javax.swing.JLabel();
        lblCajero = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        labelTitulo = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblFactIni = new javax.swing.JLabel();
        lblFactFin = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblCant = new javax.swing.JLabel();
        lblBase = new javax.swing.JLabel();
        lblIva = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblFechAper = new javax.swing.JLabel();
        lblHorAper = new javax.swing.JLabel();
        lblFechCierre = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblHorCierre = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblSaldoIni = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblSaldoFin = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtPagos = new javax.swing.JTextArea();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtRcogidas = new javax.swing.JTextArea();
        lblTotalVentas = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lblDinRecogido = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        lblCuadre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnlBotones.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        btnAceptar.setMnemonic('A');
        btnAceptar.setText("Imprimir");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setMnemonic('C');
        btnCancelar.setText("Cerrar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBotonesLayout = new javax.swing.GroupLayout(pnlBotones);
        pnlBotones.setLayout(pnlBotonesLayout);
        pnlBotonesLayout.setHorizontalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBotonesLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );
        pnlBotonesLayout.setVerticalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBotonesLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(379, 590));

        pnlConten.setBackground(new java.awt.Color(254, 254, 254));
        pnlConten.setPreferredSize(new java.awt.Dimension(380, 1000));

        lblRazonSocial.setFont(new java.awt.Font("Arial", 0, 11));
        lblRazonSocial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRazonSocial.setText("RAZON SOCIAL");

        lblNIT.setFont(new java.awt.Font("Arial", 0, 11));
        lblNIT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNIT.setText("NIT");

        lblUbicacion.setFont(new java.awt.Font("Arial", 0, 11));
        lblUbicacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUbicacion.setText("UBICACION");

        lblDireccion.setFont(new java.awt.Font("Arial", 0, 11));
        lblDireccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDireccion.setText("DIRECCION");

        labelCajero.setFont(new java.awt.Font("Arial", 0, 11));
        labelCajero.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelCajero.setText("Cajero:");

        lblCajero.setFont(new java.awt.Font("Arial", 0, 11));
        lblCajero.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCajero.setText("Juan Fernando Escobar");

        lblFecha.setFont(new java.awt.Font("Arial", 0, 11));
        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFecha.setText("FECHA");

        labelTitulo.setFont(new java.awt.Font("Arial", 0, 11));
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelTitulo.setText("INFORME DIARIO DE CAJA");

        lblHora.setFont(new java.awt.Font("Arial", 0, 11));
        lblHora.setText("HORA");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("VENTAS NETAS");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel3.setText("CANTIDAD");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel4.setText("FACT INICIAL");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel6.setText("FACT FINAL");

        lblFactIni.setFont(new java.awt.Font("Arial", 0, 11));
        lblFactIni.setText("000000001");

        lblFactFin.setFont(new java.awt.Font("Arial", 0, 11));
        lblFactFin.setText("100000000");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel7.setText("BASE GRAVABLE");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel8.setText("IVA");

        lblCant.setFont(new java.awt.Font("Arial", 0, 11));
        lblCant.setText("100");

        lblBase.setFont(new java.awt.Font("Arial", 0, 11));
        lblBase.setText("356.000");

        lblIva.setFont(new java.awt.Font("Arial", 0, 11));
        lblIva.setText("12.500");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("MOVIMIENTOS CAJA");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel10.setText("FECHA APERTURA");

        jLabel11.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel11.setText("FECHA CIERRE");

        jLabel12.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel12.setText("HORA APERTURA");

        jLabel13.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("ESTADO FINAL CAJA");

        lblFechAper.setFont(new java.awt.Font("Arial", 0, 11));
        lblFechAper.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblFechAper.setText("100");

        lblHorAper.setFont(new java.awt.Font("Arial", 0, 11));
        lblHorAper.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblHorAper.setText("356.000");

        lblFechCierre.setFont(new java.awt.Font("Arial", 0, 11));
        lblFechCierre.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblFechCierre.setText("12.500");

        jLabel14.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel14.setText("HORA CIERRE");

        lblHorCierre.setFont(new java.awt.Font("Arial", 0, 11));
        lblHorCierre.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblHorCierre.setText("12.500");

        lblEstado.setFont(new java.awt.Font("Arial", 0, 11));
        lblEstado.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblEstado.setText("CERRADA");

        jLabel15.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel15.setText("SALDO INICIAL");

        lblSaldoIni.setFont(new java.awt.Font("Arial", 0, 11));
        lblSaldoIni.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblSaldoIni.setText("100.000");

        jLabel16.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel16.setText("SALDO FINAL");

        lblSaldoFin.setFont(new java.awt.Font("Arial", 0, 11));
        lblSaldoFin.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblSaldoFin.setText("200.000");

        jLabel19.setFont(new java.awt.Font("Arial", 0, 10));
        jLabel19.setText("MONTO");

        jLabel18.setFont(new java.awt.Font("Arial", 0, 10));
        jLabel18.setText("FACTURA");

        jLabel17.setFont(new java.awt.Font("Arial", 0, 10));
        jLabel17.setText("PAGADO A");

        txtPagos.setBackground(new java.awt.Color(254, 254, 254));
        txtPagos.setColumns(20);
        txtPagos.setEditable(false);
        txtPagos.setFont(new java.awt.Font("Arial", 0, 9));
        txtPagos.setRows(5);
        txtPagos.setText("SMVS,\nSADFKLSADF\nDSJLSDF\n");
        txtPagos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel21.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("PAGOS");

        jLabel22.setFont(new java.awt.Font("Arial", 0, 12));
        jLabel22.setText("RECOGIDAS");

        jLabel23.setFont(new java.awt.Font("Arial", 0, 10));
        jLabel23.setText("RECOGIDO X");

        jLabel24.setFont(new java.awt.Font("Arial", 0, 10));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel24.setText("MONTO");

        jLabel26.setFont(new java.awt.Font("Arial", 0, 10));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("HORA");

        txtRcogidas.setBackground(new java.awt.Color(254, 254, 254));
        txtRcogidas.setColumns(20);
        txtRcogidas.setEditable(false);
        txtRcogidas.setFont(new java.awt.Font("Arial", 0, 9));
        txtRcogidas.setRows(5);
        txtRcogidas.setText("SMVS,\nSADFKLSADF\nDSJLSDF\n");
        txtRcogidas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lblTotalVentas.setFont(new java.awt.Font("Arial", 0, 11));
        lblTotalVentas.setText("256.000");

        jLabel25.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel25.setText("   TOTAL");

        jLabel20.setFont(new java.awt.Font("Arial", 0, 10));
        jLabel20.setText("AUTORIZA");

        jLabel27.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel27.setText("DINERO RECOGIDO");

        lblDinRecogido.setFont(new java.awt.Font("Arial", 0, 11));
        lblDinRecogido.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblDinRecogido.setText("200.000");

        jLabel28.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel28.setForeground(new java.awt.Color(246, 13, 13));
        jLabel28.setText("CUADRE CAJA");

        lblCuadre.setFont(new java.awt.Font("Arial", 0, 11));
        lblCuadre.setForeground(new java.awt.Color(231, 32, 32));
        lblCuadre.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblCuadre.setText("200.000");

        javax.swing.GroupLayout pnlContenLayout = new javax.swing.GroupLayout(pnlConten);
        pnlConten.setLayout(pnlContenLayout);
        pnlContenLayout.setHorizontalGroup(
            pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContenLayout.createSequentialGroup()
                        .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlContenLayout.createSequentialGroup()
                                .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblNIT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblRazonSocial, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE))
                            .addGroup(pnlContenLayout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                                .addGap(52, 52, 52))
                            .addGroup(pnlContenLayout.createSequentialGroup()
                                .addComponent(labelCajero, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblCajero, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55))
                            .addGroup(pnlContenLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFactIni, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                .addGap(155, 155, 155))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContenLayout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblFactFin, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                .addGap(156, 156, 156))
                            .addGroup(pnlContenLayout.createSequentialGroup()
                                .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlContenLayout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(pnlContenLayout.createSequentialGroup()
                                                .addComponent(lblCant)
                                                .addGap(20, 20, 20))
                                            .addGroup(pnlContenLayout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(18, 18, 18)))
                                        .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addGroup(pnlContenLayout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(lblBase)))
                                        .addGap(16, 16, 16)
                                        .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblIva)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblTotalVentas))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContenLayout.createSequentialGroup()
                                .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                                    .addGroup(pnlContenLayout.createSequentialGroup()
                                        .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel16))
                                        .addGap(10, 10, 10)
                                        .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblHorCierre, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                                            .addComponent(lblFechAper, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                                            .addComponent(lblHorAper, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                                            .addComponent(lblFechCierre, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                                            .addComponent(lblSaldoIni, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                                            .addComponent(lblEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                                            .addComponent(lblSaldoFin, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))))
                                .addGap(34, 34, 34))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContenLayout.createSequentialGroup()
                                .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                                .addGap(82, 82, 82)
                                .addComponent(lblHora, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                .addGap(33, 33, 33)))
                        .addContainerGap())
                    .addGroup(pnlContenLayout.createSequentialGroup()
                        .addComponent(lblUbicacion, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                        .addGap(33, 33, 33))
                    .addGroup(pnlContenLayout.createSequentialGroup()
                        .addComponent(lblDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                        .addGap(33, 33, 33))
                    .addGroup(pnlContenLayout.createSequentialGroup()
                        .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPagos, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                            .addGroup(pnlContenLayout.createSequentialGroup()
                                .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlContenLayout.createSequentialGroup()
                                        .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnlContenLayout.createSequentialGroup()
                                                .addComponent(jLabel23)
                                                .addGap(85, 85, 85)
                                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtRcogidas, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(37, 37, 37)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContenLayout.createSequentialGroup()
                                .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                                    .addGroup(pnlContenLayout.createSequentialGroup()
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel20)))
                                .addGap(45, 45, 45)))
                        .addContainerGap())
                    .addGroup(pnlContenLayout.createSequentialGroup()
                        .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlContenLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblDinRecogido, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))
                            .addGroup(pnlContenLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCuadre, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)))
                        .addGap(34, 34, 34))))
        );
        pnlContenLayout.setVerticalGroup(
            pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNIT, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUbicacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDireccion)
                .addGap(26, 26, 26)
                .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCajero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCajero, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFactIni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContenLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                    .addComponent(lblFactFin, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContenLayout.createSequentialGroup()
                        .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE))
                        .addGap(49, 49, 49))
                    .addGroup(pnlContenLayout.createSequentialGroup()
                        .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblIva, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotalVentas))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlContenLayout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE))
                    .addGroup(pnlContenLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(lblFechAper, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblHorAper, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFechCierre, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblHorCierre, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContenLayout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                    .addGroup(pnlContenLayout.createSequentialGroup()
                        .addComponent(lblSaldoIni, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSaldoFin, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(lblDinRecogido, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(lblCuadre, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPagos, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRcogidas, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(pnlConten);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111)
                .addComponent(pnlBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

        Impresion imp = new Impresion();
        imp.imprimir2(this.buferContenido.toString());
        try {
            javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
            this.dispose();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        try {
            javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
            this.dispose();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
            this.dispose();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_formWindowClosing

    public void crearCabecera() {

        this.buferContenido.append(Utilidades.centrarTexto(MenuVista.razonSocial, 40) + "\n");
        this.buferContenido.append(Utilidades.centrarTexto(MenuVista.Nit, 40) + "\n");
        this.buferContenido.append(Utilidades.centrarTexto(MenuVista.sigla, 40) + "\n");
        this.buferContenido.append(Utilidades.centrarTexto(MenuVista.ciudad, 40) + "\n");
        this.buferContenido.append(Utilidades.centrarTexto(MenuVista.direccion, 40) + "\n");

        this.buferContenido.append("     Fecha:"+ Utilidades.datetoString(new Date()) +
                "       Hora: " + Utilidades.getHoraActual() + "\n\n");
        this.buferContenido.append(Utilidades.centrarTexto("INFORME DE CAJA", 40)+"\n");
        this.buferContenido.append("CAJERO: " + cajero + "\n");
        this.buferContenido.append("FACTURA INICIAL:       " + this.lblFactIni.getText() + "\n");
        this.buferContenido.append("FACTURA FINAL:         " + this.lblFactFin.getText() + "\n");
        this.buferContenido.append(Utilidades.centrarTexto("VENTAS NETAS", 40)+"\n");
        this.buferContenido.append("CANT   BASE       IVA         TOTAL "+ "\n");
        this.buferContenido.append(this.lblCant.getText()+"     " +
                         this.lblBase.getText()+ "   " +
                         this.lblIva.getText()+"    " +
                         this.lblTotalVentas.getText()+ "    " +
                         "\n");
        this.buferContenido.append(Utilidades.centrarTexto("MOVIMIENTOS DE CAJA", 40)+"\n");
        this.buferContenido.append("FECHA APERTURA       " + this.lblFechAper.getText() + "\n");
        this.buferContenido.append("HORA APERTURA        " + this.lblHorAper.getText() + "\n");
        this.buferContenido.append("FECHA CIERRE         " + this.lblFechAper.getText() + "\n");
        this.buferContenido.append("HORA CIERRE          " + this.lblHorCierre.getText() + "\n");
        this.buferContenido.append("SALDO INICIAL        " + this.lblSaldoIni.getText() + "\n");
        this.buferContenido.append("SALDO FINAL          " + this.lblSaldoFin.getText() + "\n\n");

        this.buferContenido.append("SALDO NETO EN CAJA:"+"\n");
        if(CierresCaja.saldos !=null){
            this.buferContenido.append("VALOR MONEDA         CANTIDAD" + "\n");
            int total = 0;
            for(Map.Entry me : CierresCaja.saldos.entrySet()){
                this.buferContenido.append(me.getKey() + "                 "+me.getValue()+"\n");
                total += (Integer) me.getValue() * (Integer) me.getKey();
            }
            this.buferContenido.append("TOTAL DINERO EN CAJA:    " + total + "\n");
        }

    }
    
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCajero;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel lblBase;
    private javax.swing.JLabel lblCajero;
    private javax.swing.JLabel lblCant;
    private javax.swing.JLabel lblCuadre;
    private javax.swing.JLabel lblDinRecogido;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFactFin;
    private javax.swing.JLabel lblFactIni;
    private javax.swing.JLabel lblFechAper;
    private javax.swing.JLabel lblFechCierre;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHorAper;
    private javax.swing.JLabel lblHorCierre;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblIva;
    private javax.swing.JLabel lblNIT;
    private javax.swing.JLabel lblRazonSocial;
    private javax.swing.JLabel lblSaldoFin;
    private javax.swing.JLabel lblSaldoIni;
    private javax.swing.JLabel lblTotalVentas;
    private javax.swing.JLabel lblUbicacion;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlConten;
    private javax.swing.JTextArea txtPagos;
    private javax.swing.JTextArea txtRcogidas;
    // End of variables declaration//GEN-END:variables
}
