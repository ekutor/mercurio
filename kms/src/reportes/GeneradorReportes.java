

package reportes;

import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;



public class GeneradorReportes {
 private Connection conexion;

    public GeneradorReportes() {
        try {
            conectar();
        } catch (SQLException ex) {
            System.out.println("Error de Conexion a la Base de Datos");
            ex.printStackTrace();
        }
    }
     public void conectar() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");// poner la clase del driver se sql server
           // Class.forName("net.sourceforge.jtds.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        conexion = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=basededatos;", "nombreusuario","password");
        
    }


    public void obtenerReporte(String nombre) {

        InputStream fis;
        try {

            //obtener reporte del jar
            fis = getClass().getResourceAsStream("/carpeta/" + nombre + ".jasper");
             //crear reporte
            JasperReport reporte = (JasperReport) JRLoader.loadObject(fis);

            JasperPrint jasperImpreso = JasperFillManager.fillReport(reporte, null, this.conexion);

            JRExporter exporter = new JRPdfExporter();

            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperImpreso);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new File("reporte.pdf"));
            try {
                exporter.exportReport();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Un Documento PDF Se Encuentra Abierto, \n Porfavor Cierrelo Para Poder Ver Este");
            }


            if (!jasperImpreso.getPages().isEmpty()) {
                File path = new File("reporte.pdf");
               
            } else {
                JOptionPane.showMessageDialog(null, "El documento no tiene paginas");
            }
        } catch (Exception e) {
           
        }
    }
}
