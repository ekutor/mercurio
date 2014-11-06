
package reportes;

import java.awt.Desktop;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistenciaFWK.ConexionBD;
import java.io.*;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import vista.Configuracion;
import vista.MenuVista;

/**
 *
 * @author JUAN
 */
public class Reporte {

    HashMap parametros;
    String opc[] = {"Si, Buscar Imagen", "No"};
    private String pathLogo;
    private String nombSubReport = "SubReport.jasper";
    private persistenciaFWK.ManejadorArchivos adm;
    private int im = 0;

    public Reporte() {
        parametros = new HashMap();
        
    }

    public void verReporteVenta() {
        this.obtenerReporte("venta");
    }

    public void verReporteVentaCajero() {
        this.obtenerReporte("ventaCajero");
    }

    public void verReporteDetalleVenta() {
        this.obtenerReporte("detalleVenta");
    }

    public void verReporteDetalleVentaCajero() {
        this.obtenerReporte("detalleVentaCajero");
    }

    public void verReporteDetalleVentaCategoria() {
        this.obtenerReporte("detalleVentaCategoria");
    }

    public void verReporteDetalleVentaProducto() {
        this.obtenerReporte("detalleVentaProducto");
    }

    public void verReportePersonal() {
        this.obtenerReporte("personal");
    }

    public void verReportePersonalParametro() {
        this.obtenerReporte("personalP");
    }

    public void verReporteProducto() {
        this.obtenerReporte("producto");
    }

    public void verReporteProductoParametro() {
        this.obtenerReporte("productoP");
    }

    public void verReporteComprasProducto() {
        this.obtenerReporte("comprasProducto");
    }

    public void verReporteCliente() {
        this.obtenerReporte("Cliente");
    }

    public void verReporteClienteParametro() {
        this.obtenerReporte("ClienteP");
    }

    public void verReporteProveedor() {
        this.obtenerReporte("proveedor");
    }

    public void verReporteProveedorParametro() {
        this.obtenerReporte("proveedorP");
    }

    public void verReporteComprasCategoria() {
        this.obtenerReporte("comprasCategoria");
    }

    public void verReporteInventarioProducto() {
        this.obtenerReporte("inventarioProducto");
    }

    public void verReporteAgotados() {
        this.obtenerReporte("AgotadosProducto");
    }

    public void verReporteAgotadosFamilia() {
        this.obtenerReporte("AgotadosProductoFamilia");
    }

    public void verReporteGraficaDiaria() {
        this.obtenerReporte("GraficaDiaria");
    }

    public void verReporteGraficaMensual() {
        this.obtenerReporte("GraficaMensual");
    }

    public void verReporteGraficaAños() {
        this.obtenerReporte("GraficaAño");
    }

    public void verReporteVentaProductoMes() {
        this.obtenerReporte("ventaProductoMes");
    }

    public void verReporteVentaProductoDiario() {
        this.obtenerReporte("ventaProductoDiaria");
    }

    public void verReporteVentaProductoMesDetallado() {
        this.obtenerReporte("ventaProductoMesDetallado");
    }

    public void verReporteProductoCategoria() {
        this.obtenerReporte("productoPCategoria");
    }

    public void verReporteMovimientoCaja() {
        this.obtenerReporte("MovimientoCaja");
    }

    public void verReporteMovimientoCaja_Cajero() {
        this.obtenerReporte("MovimientoCaja_Cajero");
    }

    public void verReporteMovimientoCajaDetallado() {
        this.obtenerReporte("MovimientoCaja_Detallado");
    }
       public void verReporteMovimientoCajaDetallado_Cierre() {
        this.obtenerReporte("MovimientoCaja_Detallado_Cierre");
    }

    public void obtenerReporte(String nombre) {

        InputStream fis;
        try {
            Configuracion.cargarDatosSistema();
            fis = getClass().getResourceAsStream("/reportes/" + nombre + ".jasper");
            JasperReport reporte = (JasperReport) JRLoader.loadObject(fis);
            parametros.put("nombreEmpresa", MenuVista.razonSocial);
            if(MenuVista.utl_logo.equals("0")){
                parametros.put("path", MenuVista.pathLogo);
            }else{
                parametros.put("path", MenuVista.logo);
            }
            JasperPrint jasperImpreso = JasperFillManager.fillReport(reporte, parametros, ConexionBD.getInstancia().getConection());

            JRExporter exporter = new JRPdfExporter();

            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperImpreso);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new File("reporte.pdf"));
            try {
                exporter.exportReport();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Un Documento PDF Se Encuentra Abierto, \n Porfavor Cierrelo Para Poder Ver Este Reporte");
            }


            if (!jasperImpreso.getPages().isEmpty()) {
                File path = new File("reporte.pdf");
                Desktop.getDesktop().open(path);
                //JasperViewer.viewReport(jasperImpreso, false);
            } else {
                JOptionPane.showMessageDialog(null, "El documento no tiene paginas");
            }
        } catch (JRException e) {
           System.out.println("Error al cargar reporte");
           e.printStackTrace();
        }catch(IOException e){
            System.out.println("Error reptrte no encontrado");
        }catch(java.sql.SQLException e){
            System.out.println("Error al llenar datos del reporte con la BD");
        }
    }

    public void agregarParametro(String key, String parametro) {
        parametros.put(key, parametro);
    }

    public void busquedaImagen() {
        int op = JOptionPane.showOptionDialog(null, "No Se Encuentra El Logo Para Los Reportes \n Desea Configurar la imagen?",
                "Imagen No Encontrada", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opc, opc[0]);
        if (op == 0) {
           new Configuracion(MenuVista.getInstancia(),true);
                   
        }


    }

    public void crearSubReporte(String nombre) {
        FileOutputStream archivoDestino = null;
        try {
            InputStream is = getClass().getResourceAsStream("/reportes/" + nombre + ".jasper");
            archivoDestino = new FileOutputStream(new File(nombSubReport));
            byte[] buffer = new byte[1024];
            int nbLectura;
            while ((nbLectura = is.read(buffer)) != -1) {
                archivoDestino.write(buffer, 0, nbLectura);
            }
            is.close();
            archivoDestino.close();
        } catch (IOException ex) {
            Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
        }  finally {
            try {
                archivoDestino.close();
            } catch (IOException ex) {
                Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
     public String getPathSubRep(String reporte){
        String r = System.getProperty("user.dir")+"\\data\\"+reporte+".jasper";
       System.out.println("reporte "+r);
        return r;
    }
     public void elimnarSubReport(){

        File f = new File(nombSubReport);
        f.delete();

     }
}
