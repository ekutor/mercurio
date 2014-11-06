package utilidades;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JOptionPane;

/**
 *
 * @author Kymera Systems SAS
 */
//SINGLETON
public class Utilidades {

    private static Utilidades instancia;
    private static String fecActual;

    private Utilidades() {
    }

    public static Utilidades getInstancia() {
        if (instancia == null) {
            instancia = new Utilidades();
            getFechaActual();
        }
        return instancia;

    }

    public static String getFechaActual() {
        fecActual = Utilidades.datetoString(new Date());
        return fecActual;
    }

    public static Date stringtoDate(String sDate) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;
        try {

            fecha = formato.parse(sDate);

        } catch (ParseException ex) {

            ex.printStackTrace();

        }
        return fecha;
    }

    public static String datetoString(Date date) {
        /*DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,new Locale("es"));
        return df.format(date);*/
        int dia, mes, año;
        String fecha;
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        dia = c.get(Calendar.DATE);
        mes = c.get(Calendar.MONTH) + 1;
        año = c.get(Calendar.YEAR);
        fecha = año + "-" + mes + "-" + dia;
        return fecha;
    }

    public static String datetoStringLimpio(Date date) {
        int dia, mes, año;
        String fecha, d, m;
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        dia = c.get(Calendar.DATE);
        mes = c.get(Calendar.MONTH) + 1;
        año = c.get(Calendar.YEAR);
        if (dia < 10) {
            d = "0" + dia;
        } else {
            d = "" + dia;
        }
        if (mes < 10) {
            m = "0" + mes;
        } else {
            m = "" + mes;
        }
        fecha = año + "" + m + "" + d;
        return fecha;
    }

    /**
     * metodo para revisar que el string pasado solo contenga numeros
     * @param contenido
     * @return
     */
    public static String contenidoCajaTexto(String contenido) {
        String str = contenido;
        char[] fuente = str.toCharArray();
        char[] resultado = new char[fuente.length];
        int j = 0;
        boolean error = false;
        for (int i = 0; i < fuente.length; i++) {
            if (fuente[i] >= '0' && fuente[i] <= '9' || fuente[i] == '.' || fuente[i] == ',') {
                resultado[j++] = fuente[i];
            } else {
                error = true;
                
            }
        }

        if (error) {
            JOptionPane.showMessageDialog(null, "Error Valor Ingresado No Numerico");
            return new String("0");
        }
        return new String(resultado, 0, j);
    }

    public static String getHoraActual() {
        String hor = null, min = null, seg = null;
        Calendar hora = Calendar.getInstance();
        int h = hora.get(Calendar.HOUR_OF_DAY);
        int m = hora.get(Calendar.MINUTE);
        int s = hora.get(Calendar.SECOND);
        if (h < 10) {
            hor = "0" + h;
        } else {
            hor = "" + h;
        }
        if (m < 10) {
            min = "0" + m;
        } else {
            min = "" + m;
        }
        if (s < 10) {
            seg = "0" + s;
        } else {
            seg = "" + s;
        }
        String time = hor + ":" + min + ":" + seg;
        return time;
    }

    public static int getHoraActualInt() {
        return Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
    }

    public static int getMinActualInt() {
        return Calendar.getInstance().get(Calendar.MINUTE);
    }

    public static double reducirDecimales(double num) {
        return Math.rint(num);
    }

    public static String numeroFormateado(double num) {
        DecimalFormat formateador = new DecimalFormat("##########.##");
        return formateador.format(num);
    }

     public static String darFormatoEspecial(double num) {
        DecimalFormat formateador = new DecimalFormat("#,###.##");
        return formateador.format(num);
    }

    public static double quitarFormatoNumero(String num){
        StringBuilder res = new StringBuilder();
        for(int i=0; i<num.length();i++){
            if(num.charAt(i) != '.' && num.charAt(i) != ',' && (num.charAt(i)!='$')){
                res.append(num.charAt(i));
            }

        }
        return Double.parseDouble(res.toString());
    }

    public static boolean validarContraseña(String dato, String contr) {
        if (dato.equals(contr)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validarCaracteres(String valor, int numCaracteres) {
        int n = valor.length();
        if (n >= numCaracteres) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * devuelve el calculo de la base gravable de un valor total segun el iva
     * pasado como parametro
     * @param total
     * @param iva
     * @return
     */
    public static double getBaseGravable(double total, int iva) {
        return ((total * 100) / (100 + iva));
    }

    /**
     * 
     * Devuelve el calculo del valor en pessos del iva que tenga un total
     * @param total
     * @param iva
     * @return
     */
    public static double getValorIva(double total, int iva) {
        return ((total * iva) / (100 + iva));

    }

    public static String asignarCeros(int numero) {
        String resp = "";
        if (numero < 10) {
            resp = "000" + numero;
        } else if (numero < 100) {
            resp = "00" + numero;
        } else if (numero < 1000) {
            resp = "0" + numero;
        } else {
            resp = "" + numero;
        }
        return resp;

    }

    public static String darFormatoNumero(Number n) {
        NumberFormat formato = NumberFormat.getCurrencyInstance(Locale.US);
        String dato = formato.format(n);
        return dato;
    }

    public static byte[] toByteArray(Icon icono, java.awt.Component c) {
        BufferedImage originalImage = new BufferedImage(icono.getIconWidth(), icono.getIconHeight(), BufferedImage.TYPE_INT_RGB);
        icono.paintIcon(c, originalImage.createGraphics(), 0, 0);
        byte[] imageInByte = null;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(originalImage, "jpg", baos);
            baos.flush();
            imageInByte = baos.toByteArray();
            baos.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return imageInByte;
    }

    public static int getDiaActual() {
        if (fecActual == null) {
            getFechaActual();
        }
        String[] dia = fecActual.split("-");
        return Integer.parseInt(dia[2]);
    }

    public static int getAñoActual() {
        if (fecActual == null) {
            getFechaActual();
        }
        String[] dia = fecActual.split("-");
        return Integer.parseInt(dia[0]);
    }

    public static int getMesActual() {
        if (fecActual == null) {
            getFechaActual();
        }
        String[] mes = fecActual.split("-");
        return Integer.parseInt(mes[1]);
    }

    public static String getMes(int m) {
        String mes = "";
        switch (m) {
            case 1: {
                mes = "ENERO";
                break;
            }
            case 2: {
                mes = "FEBRERO";
                break;
            }
            case 3: {
                mes = "MARZO";
                break;
            }
            case 4: {
                mes = "ABRIL";
                break;
            }
            case 5: {
                mes = "MAYO";
                break;
            }
            case 6: {
                mes = "JUNIO";
                break;
            }
            case 7: {
                mes = "JULIO";
                break;
            }
            case 8: {
                mes = "AGOSTO";
                break;
            }
            case 9: {
                mes = "SEPTIEMPBRE";
                break;
            }
            case 10: {
                mes = "OCTUBRE";
                break;
            }
            case 11: {
                mes = "NOVIEMBRE";
                break;
            }
            case 12: {
                mes = "DICIEMBRE";
                break;
            }

        }
        return mes;
    }

    /**
     * Metodo para establecer una cadena segun el numero de caracteres dado,
     * si es menor que los caraceres dados agregara especios a la derecha,
     * sino reducira la cadena
     * @param cadena String con los datos totales
     * @param numCaracteres el numero de caraceres que quiere mantener de la cadena
     * @return la cadena reducida
     */
    public static String establecerCaracteres(String cadena, int numCaracteres) {
        String res;
        if (cadena.length() == numCaracteres) {
            res = cadena;
        } else if (cadena.length() > numCaracteres) {
            res = cadena.substring(0, numCaracteres);
        } else {
            res = cadena;
            for(int i=0;i<numCaracteres-cadena.length();i++){
                res+=" ";
            }
        }

        return res;
    }
    public static String establecerCaracIzq(String cadena, int numCaracteres) {
        String res;
        if (cadena.length() == numCaracteres) {
            res = cadena;
        } else if (cadena.length() > numCaracteres) {
            res = cadena.substring(0, numCaracteres);
        } else {
            res = "";
            for(int i=0;i<numCaracteres-cadena.length();i++){
                res+=" ";
            }
            res+=cadena;
        }

        return res;
    }

    public static String asignarEspacios(String cadena, int num){
        String res = "";
        int tamano = cadena.length()/2;
        for(int i =tamano;i <= num;i++){
            res += " ";
        }
        return res;
    }
    public static String centrarTexto(String texto, int cantCaracteres){
        String res = "";
        int tamano = cantCaracteres - texto.length();
        for(int i =0;i <= tamano/2;i++){
            res += " ";
        }
        res +=texto;
        return res;
    }

    public static void main(String args[] ){
        System.out.println("num "+Utilidades.darFormatoEspecial(1000000));
        Utilidades.quitarFormatoNumero(Utilidades.darFormatoEspecial(-10000));
    }
}
