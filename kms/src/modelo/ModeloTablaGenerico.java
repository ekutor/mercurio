package modelo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import vista.CompraVista;
import vista.VentaVista;

/**
 *
 * @author Kymera Systems SAS
 */
public class ModeloTablaGenerico extends AbstractTableModel {
    //array de arrays para mantener los datos de la tabla
    private List datos;
    private String[] nombres;
    private final int FILAS_INICIAL = 10;
    private int columnas;
    private VentaVista vista;
    private CompraVista vistaCompra;
    private NumberFormat formato = NumberFormat.getCurrencyInstance(Locale.US);
    public boolean esCategoria;
    public boolean tablaSeleccionada;

    public ModeloTablaGenerico() {
        datos = new ArrayList();
    }
    public ModeloTablaGenerico(List datos) {
        this.datos = datos;
    }

    public ModeloTablaGenerico(VentaVista vista) {

        datos = new ArrayList();
        this.vista = vista;
    }

    public ModeloTablaGenerico(List datos, VentaVista vista) {

        this.vista = vista;
        this.datos = datos;
    }

    public ModeloTablaGenerico(CompraVista vistaCompra) {

        datos = new ArrayList();
        this.vistaCompra = vistaCompra;
    }

    public ModeloTablaGenerico(List datos, CompraVista vistaCompra) {

        this.vistaCompra = vistaCompra;
        this.datos = datos;
    }

    public int getRowCount() {
        return (datos.size() > FILAS_INICIAL) ? datos.size() : FILAS_INICIAL;
    }

    public int getColumnCount() {
        return columnas;
    }

    @Override
    public String getColumnName(int column) {
        return nombres[column];
    }

    @Override
    public boolean isCellEditable(int fila, int columna) {
        return false;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    public Object getValueAt(int fila, int columna) {
        if (datos.size() > 0 && fila < datos.size()) {
            List l = (List) datos.get(fila);
            return l.get(columna);
        } else {
            return null;
        }

    }
    public void setTamanoColumnaTabla(javax.swing.JTable tabla, String nomColumna,int ancho) {
        TableColumn columna = tabla.getColumn(nomColumna);//Obtenemos la columna por medio del titulo
        columna.setPreferredWidth(ancho);//Le asignamos un valor al ancho de la columna
        columna.setMinWidth(ancho);//Un valor Minimo
        columna.setMaxWidth(ancho);//Un valor Maximo
    }
    public void setTamanoColumnaTablaVenta() {
        TableColumn columna0 = vista.tablaVentas.getColumn("TICKETE");//Obtenemos la columna por medio del titulo
        columna0.setPreferredWidth(80);//Le asignamos un valor al ancho de la columna
        columna0.setMinWidth(80);//Un valor Minimo
        columna0.setMaxWidth(80);//Un valor Maximo
        TableColumn columna1 = vista.tablaVentas.getColumn("CAJERO");
        columna1.setPreferredWidth(370);
        columna1.setMinWidth(370);//Un valor Minimo
        columna1.setMaxWidth(370);//Un valor Maximo
        TableColumn columna2 = vista.tablaVentas.getColumn("HORA");
        columna2.setPreferredWidth(70);
        TableColumn columna4 = vista.tablaVentas.getColumn("TOTAL");
        columna4.setPreferredWidth(60);

        vista.tablaVentas.setRowHeight(22);
        vista.tablaVentas.setFont(new Font("Tahoma", Font.PLAIN, 16));
        JTableHeader header = vista.tablaVentas.getTableHeader();
        header.setPreferredSize(new Dimension(20, 22));
        header.setFont(new Font("Tahoma", Font.BOLD, 16));
        header.setForeground(new Color(51, 102, 255));
    }

    public void setTamanoColumnaTablaCompra() {
        TableColumn columna0 = vistaCompra.tablaCompras.getColumn("No.ORDEN");//Obtenemos la columna por medio del titulo
        columna0.setPreferredWidth(120);//Le asignamos un valor al ancho de la columna
        columna0.setMinWidth(120);//Un valor Minimo
        columna0.setMaxWidth(120);//Un valor Maximo
        TableColumn columna1 = vistaCompra.tablaCompras.getColumn("ESTADO");
        columna1.setPreferredWidth(100);
        columna1.setMinWidth(100);//Un valor Minimo
        columna1.setMaxWidth(100);//Un valor Maximo
        TableColumn columna2 = vistaCompra.tablaCompras.getColumn("FECHA PEDIDO");
        columna2.setPreferredWidth(60);
        TableColumn columna3 = vistaCompra.tablaCompras.getColumn("FECHA ENTREGA");
        columna3.setPreferredWidth(60);
        TableColumn columna4 = vistaCompra.tablaCompras.getColumn("TOTAL");
        columna4.setPreferredWidth(60);

        vistaCompra.tablaCompras.setRowHeight(22);
        vistaCompra.tablaCompras.setFont(new Font("Tahoma", Font.PLAIN, 18));
        JTableHeader header = vistaCompra.tablaCompras.getTableHeader();
        header.setPreferredSize(new Dimension(20, 22));
        header.setFont(new Font("Tahoma", Font.BOLD, 18));
        header.setForeground(new Color(51, 102, 255));
    }

    public String[] getNombres() {
        return nombres;
    }

    public void setNombres(String[] nombres) {
        this.nombres = nombres;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public void establecerColumNom(String[] nombres) {
        setNombres(nombres);
        setColumnas(nombres.length);
    }

    @Override
    public void setValueAt(Object valor, int fila, int columna) {
        List arrayFilas = (List) datos.get(fila);
        arrayFilas.set(columna, valor);
    }

    public void setValueAtLast(List valor) {
        datos.add(valor);
    }
    /**
     * obtiene el Array de Arrays con los datos de la tabla
     * @return el array de datos
     */
    public List getDatos(){
        return datos;
    }

}
