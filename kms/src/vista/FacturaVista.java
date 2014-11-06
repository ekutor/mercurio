package vista;

import java.util.Date;
import java.util.List;
import utilidades.Impresion;
import utilidades.Utilidades;

/**
 *
 * @author Kymera Systems SAS
 */
public class FacturaVista extends javax.swing.JDialog {

    private String contPro, contCant, contPrecio, contSubt;
    private StringBuilder contenido = new StringBuilder();
    private String producto, cantidad, valor, subtotal, cajero;
    private Object[] tarifa;
    public boolean facturar;
    private PagoVista p;
    private int cont, tar;
    private int altoArea, altoAreaImp;
    private double base, iva, baseT, ivaT;

    /** Creates new form FacturaVista */
    public FacturaVista(java.awt.Frame parent, boolean modal, PagoVista p) {
        super(parent, modal);
        initComponents();
        this.p = p;
        tatProducto.setText("");
        tatCantidad.setText("");
        tatPrecio.setText("");
        tatSubTotal.setText("");

        tatTarifa.setText("");
        tatIva.setText("");
        tatBase.setText("");


        //Altura de Areas
        altoArea = tatProducto.getHeight();
        //Fin Altura Areas

        lblEmpresa.setText(MenuVista.sigla);
        lblNIT.setText(MenuVista.Nit);
        lblDireccion.setText(MenuVista.direccion);
        lblRazonSocial.setText(MenuVista.razonSocial);
        lblUbicacion.setText(MenuVista.ciudad);

        lblCajero.setText(FachadaInterfaz.getInstancia().ptoVenta.getNombreUsuarioActual());
        lblHora.setText(Utilidades.getHoraActual());
        lblFecha.setText(Utilidades.datetoString(new Date()));
        lblTiquete.setText(p.vista.tiquete);
        cajero = Utilidades.establecerCaracteres(FachadaInterfaz.getInstancia().ptoVenta.getNombreUsuarioActual(), 15);
        this.crearCabeceraTicket();

        this.setLocation(350, 70);

    }

    public void setContenido(List conten) {
        contPro = "";
        contCant = "";
        contPrecio = "";
        contSubt = "";
        for (int i = 0; i < conten.size(); i++) {
            producto = (String) conten.get(i);
            cantidad = (String) conten.get(++i);
            valor = (String) conten.get(++i);
            valor = valor.substring(0, valor.length() - 3);
            subtotal = (String) conten.get(++i);
            subtotal = subtotal.substring(0, subtotal.length() - 3);
            i++;


            contenido.append(Utilidades.establecerCaracteres(producto, 10) + "  " +
                    Utilidades.establecerCaracIzq(cantidad, 3) + "    " +
                    Utilidades.establecerCaracIzq(valor, 8) + "    " +
                    Utilidades.establecerCaracIzq(subtotal, 8) + "\n");
            altoArea += 30;
            contPro += producto + "\n";
            contCant += cantidad + "\n";
            contPrecio += valor + "\n";
            contSubt += subtotal + "\n";

        }
        subtotal = p.vista.subTotal.substring(0, p.vista.subTotal.length() - 3);
        String dscto = p.vista.descTotal.substring(0,p.vista.descTotal.length() -3);
        String tot = p.vista.total.substring(0,p.vista.total.length() - 3);
        String pgc = p.pagaCon.substring(0, p.pagaCon.length() -3 );
        String cmb = p.cambio.substring(0, p.cambio.length() -3);
        contenido.append("\nSubtotal sin Descuento:    " + Utilidades.establecerCaracIzq(subtotal, 8) + "\n" +
                "Descuento:                 " + Utilidades.establecerCaracIzq(dscto, 8) + "\n" +
                "                          ==========\n" +
                "Total a Pagar:             " + Utilidades.establecerCaracIzq(tot, 8) + "\n" +
                "Paga Con:                  " + Utilidades.establecerCaracIzq(pgc , 8) + "\n" +
                "                          ==========\n" +
                "Cambio:                    " + Utilidades.establecerCaracIzq(cmb, 8) + "\n" +
                "              IMPUESTOS\n" +
                "     TARIFA       BASE         IVA\n");
        tatProducto.append(contPro);
        tatCantidad.append(contCant);
        tatPrecio.append(contPrecio);
        tatSubTotal.append(contSubt);
        lblSinDes.setText(p.vista.subTotal);
        lblDescuento.setText(p.vista.descTotal);
        lblPagar.setText(p.vista.total);
        lblPaga.setText(p.pagaCon);
        lblCambio.setText(p.cambio);
        for (Double val : p.vista.imp.values()) {
            tarifa = p.vista.imp.keySet().toArray();
            tar = (Integer) tarifa[cont];

            base = Utilidades.getBaseGravable(val, tar);
            iva = Utilidades.getValorIva(val, tar);
            tatTarifa.append(+tar + "%\n");
            tatIva.append(Utilidades.darFormatoNumero(iva) + "\n");
            tatBase.append(Utilidades.darFormatoNumero(base) + "\n");

            contenido.append("     " + tar + "%         " + Utilidades.reducirDecimales(base) +
                    "       " + Utilidades.reducirDecimales(iva) + "\n");
            altoAreaImp += 30;

            baseT += base;
            ivaT += iva;
            cont++;
        }
        organizarObjetos(altoArea, altoAreaImp);
        lblTBase.setText(Utilidades.darFormatoNumero(baseT));
        lblTIva.setText(Utilidades.darFormatoNumero(ivaT));
        contenido.append("                 =======      =======\n" +
                "                 " + Utilidades.reducirDecimales(baseT) +
                "       " + Utilidades.reducirDecimales(ivaT) + "\n" +
                "GRACIAS POR SU COMPRA! LO ESPERAMOS PRONTO" + "\n" +
                "Software:Kymera Systems SAS" + "\n" +
                "www.kymerasystems.com" + "\n" +
                "\n" + " \n" + " \n" + "\n");
       contenido.append("\n\n\n");
       contenido.append("\n\n\n");
    }

    public void crearCabeceraTicket() {
        
        contenido.append(Utilidades.centrarTexto(MenuVista.razonSocial, 40) + "\n");
        contenido.append(Utilidades.centrarTexto(MenuVista.Nit, 40) + "\n");
        contenido.append(Utilidades.centrarTexto(MenuVista.sigla, 40) + "\n");
        contenido.append(Utilidades.centrarTexto(MenuVista.ciudad, 40) + "\n");
        contenido.append(Utilidades.centrarTexto(MenuVista.direccion, 40) + "\n");

        contenido.append("Cajero: " + cajero + " Fecha: " + Utilidades.datetoString(new Date()) + "\n" +
                "Cliente: Generico" + "        Hora: " + Utilidades.getHoraActual() + "\n" +
                "Tiquete: " + p.vista.tiquete + "\n" +
                "PRODUCTO    CANT  PRECIO UNI  SUBTOTAL\n");
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        pnlConten = new javax.swing.JPanel();
        tatProducto = new javax.swing.JTextArea();
        lblRazonSocial = new javax.swing.JLabel();
        labelCajero = new javax.swing.JLabel();
        lblCajero = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblCajero2 = new javax.swing.JLabel();
        labelCliente = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tatTarifa = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tatCantidad = new javax.swing.JTextArea();
        tatPrecio = new javax.swing.JTextArea();
        tatSubTotal = new javax.swing.JTextArea();
        tatBase = new javax.swing.JTextArea();
        tatIva = new javax.swing.JTextArea();
        lblNIT = new javax.swing.JLabel();
        lblEmpresa = new javax.swing.JLabel();
        lblUbicacion = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        labelCliente1 = new javax.swing.JLabel();
        lblTiquete = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblTIva = new javax.swing.JLabel();
        lblTBase = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblSinDes = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lblDescuento = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lblPagar = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lblPaga = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblCambio = new javax.swing.JLabel();
        pnlBotones = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnlConten.setBackground(new java.awt.Color(255, 255, 255));

        tatProducto.setBackground(new java.awt.Color(254, 254, 254));
        tatProducto.setColumns(20);
        tatProducto.setEditable(false);
        tatProducto.setFont(new java.awt.Font("Arial", 0, 10));
        tatProducto.setRows(10);
        tatProducto.setText("Camisa");
        tatProducto.setBorder(null);
        tatProducto.setOpaque(false);

        lblRazonSocial.setFont(new java.awt.Font("Arial", 0, 10));
        lblRazonSocial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRazonSocial.setText("RAZON SOCIAL");

        labelCajero.setFont(new java.awt.Font("Arial", 0, 10));
        labelCajero.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelCajero.setText("Cajero:");

        lblCajero.setFont(new java.awt.Font("Arial", 0, 10));
        lblCajero.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCajero.setText("Juan Fernando Escobar");

        lblFecha.setFont(new java.awt.Font("Arial", 0, 10));
        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFecha.setText("FECHA");

        lblCajero2.setFont(new java.awt.Font("Arial", 0, 10));
        lblCajero2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCajero2.setText("HECTOR SANCHEZ");

        labelCliente.setFont(new java.awt.Font("Arial", 0, 10));
        labelCliente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelCliente.setText("Cliente:");

        lblHora.setFont(new java.awt.Font("Arial", 0, 10));
        lblHora.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblHora.setText("HORA");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 10));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PRODUCTO");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 10));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CANT");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 10));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("PRECIO UNI");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 10));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("SUBTOTAL");

        tatTarifa.setBackground(new java.awt.Color(254, 254, 254));
        tatTarifa.setColumns(20);
        tatTarifa.setEditable(false);
        tatTarifa.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        tatTarifa.setRows(5);
        tatTarifa.setText("123");
        tatTarifa.setAutoscrolls(false);
        tatTarifa.setBorder(null);
        tatTarifa.setHighlighter(null);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 10));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("IVA");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 10));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("TARIFA");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 10));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("BASE");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 10));
        jLabel10.setText("SOFTWARE: Kymera Systems SAS         ");

        tatCantidad.setBackground(new java.awt.Color(254, 254, 254));
        tatCantidad.setColumns(20);
        tatCantidad.setEditable(false);
        tatCantidad.setFont(new java.awt.Font("Arial", 0, 10));
        tatCantidad.setRows(5);
        tatCantidad.setText("1");
        tatCantidad.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tatPrecio.setBackground(new java.awt.Color(254, 254, 254));
        tatPrecio.setColumns(20);
        tatPrecio.setEditable(false);
        tatPrecio.setFont(new java.awt.Font("Arial", 0, 10));
        tatPrecio.setRows(5);
        tatPrecio.setText("23000");
        tatPrecio.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tatSubTotal.setBackground(new java.awt.Color(254, 254, 254));
        tatSubTotal.setColumns(20);
        tatSubTotal.setEditable(false);
        tatSubTotal.setFont(new java.awt.Font("Arial", 0, 10));
        tatSubTotal.setRows(5);
        tatSubTotal.setText("23000");
        tatSubTotal.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tatBase.setBackground(new java.awt.Color(254, 254, 254));
        tatBase.setColumns(20);
        tatBase.setEditable(false);
        tatBase.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        tatBase.setRows(5);
        tatBase.setText("123");
        tatBase.setAutoscrolls(false);
        tatBase.setBorder(null);

        tatIva.setBackground(new java.awt.Color(254, 254, 254));
        tatIva.setColumns(20);
        tatIva.setEditable(false);
        tatIva.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        tatIva.setRows(5);
        tatIva.setText("123");
        tatIva.setAutoscrolls(false);
        tatIva.setBorder(null);

        lblNIT.setFont(new java.awt.Font("Arial", 0, 10));
        lblNIT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNIT.setText("NIT");

        lblEmpresa.setFont(new java.awt.Font("Arial", 0, 10));
        lblEmpresa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEmpresa.setText("EMPRESA");

        lblUbicacion.setFont(new java.awt.Font("Arial", 0, 10));
        lblUbicacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUbicacion.setText("UBICACION");

        lblDireccion.setFont(new java.awt.Font("Arial", 0, 10));
        lblDireccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDireccion.setText("DIRECCION");

        jLabel11.setFont(new java.awt.Font("Arial", 0, 10));
        jLabel11.setText("WEB: www.kymeraSystems.com");

        labelCliente1.setFont(new java.awt.Font("Arial", 0, 10));
        labelCliente1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelCliente1.setText("Tiquete:");

        lblTiquete.setFont(new java.awt.Font("Arial", 0, 10));
        lblTiquete.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTiquete.setText("00020");

        jLabel15.setFont(new java.awt.Font("Arial", 0, 10));
        jLabel15.setText("Total a Pagar:");

        jLabel12.setFont(new java.awt.Font("Arial", 0, 10));
        jLabel12.setText("=======");

        jLabel14.setFont(new java.awt.Font("Arial", 0, 10));
        jLabel14.setText("=======");

        lblTIva.setFont(new java.awt.Font("Arial", 0, 10));
        lblTIva.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTIva.setText("$8900");

        lblTBase.setFont(new java.awt.Font("Arial", 0, 10));
        lblTBase.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTBase.setText("$7500");

        jLabel21.setFont(new java.awt.Font("Arial", 0, 10));
        jLabel21.setText("TOTAL");

        jLabel16.setFont(new java.awt.Font("Arial", 0, 10));
        jLabel16.setText("Subtotal sin Descuento:");

        lblSinDes.setFont(new java.awt.Font("Arial", 0, 10));
        lblSinDes.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblSinDes.setText("$23000");

        jLabel19.setFont(new java.awt.Font("Arial", 0, 10));
        jLabel19.setText("Descuento:");

        lblDescuento.setFont(new java.awt.Font("Arial", 0, 10));
        lblDescuento.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblDescuento.setText("$3000");

        jLabel22.setFont(new java.awt.Font("Arial", 0, 10));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel22.setText("=======");

        lblPagar.setFont(new java.awt.Font("Arial", 0, 10));
        lblPagar.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblPagar.setText("$20000");

        jLabel23.setFont(new java.awt.Font("Arial", 0, 10));
        jLabel23.setText("Paga Con:");

        lblPaga.setFont(new java.awt.Font("Arial", 0, 10));
        lblPaga.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblPaga.setText("$30000");

        jLabel24.setFont(new java.awt.Font("Arial", 0, 10));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel24.setText("=======");

        jLabel13.setFont(new java.awt.Font("Arial", 0, 10));
        jLabel13.setText("CAMBIO");

        lblCambio.setFont(new java.awt.Font("Arial", 0, 10));
        lblCambio.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblCambio.setText("$10000");

        javax.swing.GroupLayout pnlContenLayout = new javax.swing.GroupLayout(pnlConten);
        pnlConten.setLayout(pnlContenLayout);
        pnlContenLayout.setHorizontalGroup(
            pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenLayout.createSequentialGroup()
                .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContenLayout.createSequentialGroup()
                        .addComponent(labelCliente1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTiquete, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116))
                    .addGroup(pnlContenLayout.createSequentialGroup()
                        .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlContenLayout.createSequentialGroup()
                                .addComponent(labelCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                                .addGap(1, 1, 1)
                                .addComponent(lblCajero2, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                            .addGroup(pnlContenLayout.createSequentialGroup()
                                .addComponent(labelCajero)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCajero, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2))
                    .addGroup(pnlContenLayout.createSequentialGroup()
                        .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)
                            .addComponent(tatTarifa, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tatBase, 0, 0, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTBase))
                        .addGap(43, 43, 43)
                        .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tatIva, 0, 0, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                            .addGroup(pnlContenLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel12))
                            .addComponent(lblTIva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlContenLayout.createSequentialGroup()
                                .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblCambio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblPaga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblSinDes, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                    .addComponent(lblDescuento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(5, 5, 5))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblDireccion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblUbicacion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblEmpresa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblNIT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblRazonSocial, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlContenLayout.createSequentialGroup()
                            .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlContenLayout.createSequentialGroup()
                                    .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(tatProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(pnlContenLayout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(tatCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4)
                                        .addComponent(tatPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jLabel15))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(pnlContenLayout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(tatSubTotal, 0, 0, Short.MAX_VALUE))
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel20))
                .addContainerGap())
        );
        pnlContenLayout.setVerticalGroup(
            pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenLayout.createSequentialGroup()
                .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContenLayout.createSequentialGroup()
                        .addGap(285, 285, 285)
                        .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel17))
                        .addGap(26, 26, 26)
                        .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel20)))
                    .addGroup(pnlContenLayout.createSequentialGroup()
                        .addComponent(lblRazonSocial)
                        .addGap(1, 1, 1)
                        .addComponent(lblNIT)
                        .addGap(1, 1, 1)
                        .addComponent(lblEmpresa)
                        .addGap(1, 1, 1)
                        .addComponent(lblUbicacion)
                        .addGap(1, 1, 1)
                        .addComponent(lblDireccion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlContenLayout.createSequentialGroup()
                                .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelCajero)
                                    .addComponent(lblCajero))
                                .addGap(1, 1, 1)
                                .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelCliente)
                                    .addComponent(lblCajero2))
                                .addGap(1, 1, 1)
                                .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelCliente1)
                                    .addComponent(lblTiquete)))
                            .addGroup(pnlContenLayout.createSequentialGroup()
                                .addComponent(lblFecha)
                                .addGap(1, 1, 1)
                                .addComponent(lblHora)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlContenLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tatProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlContenLayout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tatSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnlContenLayout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tatPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tatCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(lblSinDes))
                        .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlContenLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addGroup(pnlContenLayout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(jLabel15)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel23)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel13))
                            .addGroup(pnlContenLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(lblDescuento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPagar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPaga)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCambio)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tatTarifa, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tatBase, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tatIva, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTBase)
                            .addComponent(jLabel21)
                            .addComponent(lblTIva))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(pnlConten);

        pnlBotones.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        btnAceptar.setMnemonic('A');
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setMnemonic('C');
        btnCancelar.setText("Cancelar");
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
                .addGap(76, 76, 76)
                .addComponent(btnAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addGap(64, 64, 64))
        );
        pnlBotonesLayout.setVerticalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnlBotones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        imprimir();
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
    public void organizarObjetos(int altoP, int altoI) {
        javax.swing.GroupLayout pnlContenLayout = new javax.swing.GroupLayout(pnlConten);
        pnlConten.setLayout(pnlContenLayout);
        pnlContenLayout.setHorizontalGroup(
                pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).
                addGroup(pnlContenLayout.createSequentialGroup().
                addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).
                addGroup(pnlContenLayout.createSequentialGroup().addComponent(labelCliente1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(lblTiquete, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(116, 116, 116)).addGroup(pnlContenLayout.createSequentialGroup().addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(pnlContenLayout.createSequentialGroup().addComponent(labelCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE).addGap(1, 1, 1).addComponent(lblCajero2, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)).addGroup(pnlContenLayout.createSequentialGroup().addComponent(labelCajero).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(lblCajero, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(2, 2, 2)).addGroup(pnlContenLayout.createSequentialGroup().addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel21).addComponent(tatTarifa, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(32, 32, 32).addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(tatBase, 0, 0, Short.MAX_VALUE).addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(lblTBase)).addGap(43, 43, 43).addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(tatIva, 0, 0, Short.MAX_VALUE).addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE).addGroup(pnlContenLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(jLabel12)).addComponent(lblTIva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))).addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(pnlContenLayout.createSequentialGroup().addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel23).addComponent(jLabel16).addComponent(jLabel19).addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(27, 27, 27).addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(lblCambio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(lblPaga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(lblPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE).addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(lblSinDes, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE).addComponent(lblDescuento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addGap(5, 5, 5)).addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addComponent(lblDireccion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(lblUbicacion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(lblEmpresa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(lblNIT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(lblRazonSocial, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))).addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlContenLayout.createSequentialGroup().addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(pnlContenLayout.createSequentialGroup().addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel2).addComponent(tatProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE).addGroup(pnlContenLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(tatCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jLabel4).addComponent(tatPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))).addComponent(jLabel15)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addGroup(pnlContenLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(tatSubTotal, 0, 0, Short.MAX_VALUE)).addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))).addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE).addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)).addGap(30, 30, 30).addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jLabel17).addComponent(jLabel20)).addContainerGap()));
        pnlContenLayout.setVerticalGroup(
                pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(pnlContenLayout.createSequentialGroup().addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(pnlContenLayout.createSequentialGroup().addGap(285, 285, 285).addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel17).addComponent(jLabel17)).addGap(26, 26, 26).addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel20).addComponent(jLabel20))).addGroup(pnlContenLayout.createSequentialGroup().addComponent(lblRazonSocial).addGap(1, 1, 1).addComponent(lblNIT).addGap(1, 1, 1).addComponent(lblEmpresa).addGap(1, 1, 1).addComponent(lblUbicacion).addGap(1, 1, 1).addComponent(lblDireccion).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(pnlContenLayout.createSequentialGroup().addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(labelCajero).addComponent(lblCajero)).addGap(1, 1, 1).addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(labelCliente).addComponent(lblCajero2)).addGap(1, 1, 1).addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(labelCliente1).addComponent(lblTiquete))).addGroup(pnlContenLayout.createSequentialGroup().addComponent(lblFecha).addGap(1, 1, 1).addComponent(lblHora))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(pnlContenLayout.createSequentialGroup().addComponent(jLabel2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(tatProducto, javax.swing.GroupLayout.PREFERRED_SIZE, altoP, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(pnlContenLayout.createSequentialGroup().addComponent(jLabel5).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(tatSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, altoP, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(pnlContenLayout.createSequentialGroup().addGap(20, 20, 20).addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(tatPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, altoP, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(tatCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, altoP, javax.swing.GroupLayout.PREFERRED_SIZE))).addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel3).addComponent(jLabel4)))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel16).addComponent(lblSinDes)).addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(pnlContenLayout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel19).addGroup(pnlContenLayout.createSequentialGroup().addGap(40, 40, 40).addComponent(jLabel15))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel23).addGap(26, 26, 26).addComponent(jLabel13)).addGroup(pnlContenLayout.createSequentialGroup().addGap(3, 3, 3).addComponent(lblDescuento).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel22).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(lblPagar).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(lblPaga).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel24).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(lblCambio))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel7).addComponent(jLabel6).addComponent(jLabel8)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(tatTarifa, javax.swing.GroupLayout.PREFERRED_SIZE, altoI, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(tatBase, javax.swing.GroupLayout.PREFERRED_SIZE, altoI, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(tatIva, javax.swing.GroupLayout.PREFERRED_SIZE, altoI, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel14).addComponent(jLabel12)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(pnlContenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(lblTBase).addComponent(jLabel21).addComponent(lblTIva)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel10))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel11).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
    }

    public void imprimir() {
        Impresion imp = new Impresion();
        imp.imprimir2(contenido.toString());
        try {
            javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
            p.guardarVenta();
            this.dispose();
        } catch (Exception e) {
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
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCajero;
    private javax.swing.JLabel labelCliente;
    private javax.swing.JLabel labelCliente1;
    private javax.swing.JLabel lblCajero;
    private javax.swing.JLabel lblCajero2;
    private javax.swing.JLabel lblCambio;
    private javax.swing.JLabel lblDescuento;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblEmpresa;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblNIT;
    private javax.swing.JLabel lblPaga;
    private javax.swing.JLabel lblPagar;
    private javax.swing.JLabel lblRazonSocial;
    private javax.swing.JLabel lblSinDes;
    private javax.swing.JLabel lblTBase;
    private javax.swing.JLabel lblTIva;
    private javax.swing.JLabel lblTiquete;
    private javax.swing.JLabel lblUbicacion;
    private javax.swing.JPanel pnlBotones;
    public javax.swing.JPanel pnlConten;
    private javax.swing.JTextArea tatBase;
    private javax.swing.JTextArea tatCantidad;
    private javax.swing.JTextArea tatIva;
    private javax.swing.JTextArea tatPrecio;
    private javax.swing.JTextArea tatProducto;
    private javax.swing.JTextArea tatSubTotal;
    private javax.swing.JTextArea tatTarifa;
    // End of variables declaration//GEN-END:variables
}
