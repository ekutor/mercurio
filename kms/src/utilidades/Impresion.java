package utilidades;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.FileWriter;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Chromaticity;
import javax.print.attribute.standard.MediaPrintableArea;
import javax.print.attribute.standard.OrientationRequested;
import javax.print.attribute.standard.PrintQuality;
import javax.swing.JPanel;

/**
 *
 * @author Kymera Systems SAS
 */
public class Impresion implements Printable, Runnable {

    private JPanel panel;
    private final double escala = 0.65;
    private final float margen_izq = 0.1f;
    private final float margen_der = 0.1f;
    private final byte[] secAbrirCajon = {(byte)27,(byte)112,(byte)0,(byte)150,(byte)150,(byte)0};

    public Impresion() {
    }

    public Impresion(JPanel panelAImprimir) {
        panel = panelAImprimir;
    }

    public void imprimir() {
        if (panel != null) {
            Thread hilo = new Thread(this);
            hilo.start();
        }
    }

    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) graphics;
        //verificar translate (0,0)
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
        g2d.setFont(new Font("Serif", Font.PLAIN, 8));
        //escalar la impresion
        g2d.scale(escala, escala);
        panel.printAll(graphics);

        return PAGE_EXISTS;
    }

    public void run() {
        try {

            PrinterJob job = PrinterJob.getPrinterJob();
            PrintRequestAttributeSet atributos = new HashPrintRequestAttributeSet();
            atributos.add(OrientationRequested.PORTRAIT);

            atributos.add(Chromaticity.COLOR);
            atributos.add(PrintQuality.NORMAL);

            atributos.add(new MediaPrintableArea(margen_izq, margen_der, Float.MAX_VALUE, Float.MAX_VALUE, MediaPrintableArea.MM));

            job.setPrintable(this);
            //job.printDialog();
            job.print(atributos);
        } catch (PrinterException ex) {
        }
    }

    public int pulgadasAPagina(double pulgadas) {
        return (int) (pulgadas * 72.0);
    }

    public void imprimir2(String datos) {
        //Cogemos el servicio de impresión por defecto (impresora por defecto)
        PrintService service = PrintServiceLookup.lookupDefaultPrintService();
//Le decimos el tipo de datos que vamos a enviar a la impresora
//Tipo: bytes Subtipo: autodetectado
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
//Creamos un trabajo de impresión
        DocPrintJob pj = service.createPrintJob();
        
        //abrir cajon monedero
        
                
//Nuestro trabajo de impresión envía una cadena de texto

       // byte[] bytes;
//Transformamos el texto a bytes que es lo que soporta la impresora

        byte[] bytes = new byte[this.secAbrirCajon.length + datos.getBytes().length];
//Transformamos el texto a bytes que es lo que soporta la impresora
        int j =0;
        for(int i =0 ;i< secAbrirCajon.length;i++){
            bytes[i] = secAbrirCajon[i];
            j = i;
        }j++;
        byte[] dt = datos.getBytes();
        for(int i =j ;i<dt.length;i++){
            bytes[i] = dt[i-j];
        }
        //bytes = datos.getBytes();
//Creamos un documento (Como si fuese una hoja de Word para imprimir)
        Doc doc = new SimpleDoc(bytes, flavor, null);
//Obligado coger la excepción PrintException
// Diálogo para elegir el formato de impresión


//prueba para mandar el mensaje de dialogo de impresion

        PrinterJob job = PrinterJob.getPrinterJob();


// Diálogo para confirmar impresion.
// Devuelve true si el usuario decide imprimir.
        PrintRequestAttributeSet atributos = new HashPrintRequestAttributeSet();
        atributos.add(OrientationRequested.PORTRAIT);

        atributos.add(Chromaticity.COLOR);
        atributos.add(PrintQuality.NORMAL);

        atributos.add(new MediaPrintableArea(margen_izq, margen_der, Float.MAX_VALUE, Float.MAX_VALUE, MediaPrintableArea.MM));



        try {
            //Mandamos a impremir el documento
            pj.print(doc, atributos);
        } catch (PrintException ex) {
            System.out.println("Error al imprimir: " + ex.getMessage());
        }

    }

    public static void main(String... args) {
        Impresion imp = new Impresion(null);
        String ss = "      LA MOLIENDA EXPRESS ";
        ss += "\n";
        ss += "    890890-1 ";
        ss += "\n";
        ss += "           Kammys-1 ";
        ss += "\n";
        ss += "    Villavicencio-1 ";
        ss += "\n";
        ss += "    Centro Comercial Unilago ";
        ss += "\n";
        ss += "Cajero: Alejandro Sarmiento  26/05/2010 ";
        ss += "\n";
        ss += "Cliente: Hector Sanchez				22:03";
        ss += "\n";
        ss += "PRODUCTO	CANT		PRECIO UNI		SUBTOTAL";
        ss += "\n";
        ss += "    890890-1 ";
        imp.imprimir2(ss);
    }

    public void abrirCajon(String puerto) {
        // Apertura del cajón portamonedas.ESC p m t1 t2
        try {
            FileWriter imp = new FileWriter(puerto);
            imp.write(27);
            imp.write(112);
            imp.write(0);
            imp.write(150);
            imp.write(150);
            imp.write(0);
            imp.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
