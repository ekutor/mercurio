package modelo;

import control.Caja;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.NumberFormat;
import javax.swing.table.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import vista.CompraVista;
import vista.FachadaInterfaz;
import vista.VentaVista;

/**
 *
 * @author Kymera Systems SAS
 */
public class ModeloTabla extends AbstractTableModel {

    public List<ArrayList> mapa;
    private ArrayList arrayList;
    private String[] nombres;
    private final int FILAS_INICIAL = 10;
    private int columnas;
    public int contFilas;
    public boolean tablaSeleccionada = false, eliminar = false, tablaVenta = false;
    private NumberFormat formato = NumberFormat.getCurrencyInstance(Locale.US);
    private VentaVista vista;
    private CompraVista compra;
    private int propiedad;

    public ModeloTabla(VentaVista vista) {
        propiedad = Caja.VENTA;
        this.vista = vista;
        mapa = new ArrayList();
        arrayList = new ArrayList();
        for (int i = 0; i < 6; i++) {
            arrayList.add("");
        }
        for (int i = 0; i < FILAS_INICIAL; i++) {
            mapa.add(arrayList);
        }
    }

    public ModeloTabla(CompraVista compra) {
        propiedad = Caja.COMPRA;
        this.compra = compra;
        mapa = new ArrayList();
        arrayList = new ArrayList();
        for (int i = 0; i < 6; i++) {
            arrayList.add("");
        }
        for (int i = 0; i < FILAS_INICIAL; i++) {
            mapa.add(arrayList);
        }
    }

    public int getRowCount() {
        return (mapa.size() > FILAS_INICIAL) ? mapa.size() : FILAS_INICIAL;
    }

    public Object getValueAt(int fila, int columna) {
        try {
            if (mapa.size() > 0 && fila < mapa.size()) {
                arrayList = mapa.get(fila);
                return arrayList.get(columna);
            } else {
                return null;
            }
        } catch (ArrayIndexOutOfBoundsException aiobe) {
            return null;
        } catch (NullPointerException npe) {
            return null;
        }
    }

    @Override
    public void setValueAt(Object valor, int fila, int columna) {
        try {
            if (tablaSeleccionada && !eliminar) {
                if (columna == 0) {
                    obtenerFilaYAsignarValor(fila, columna, valor);
                    int cantMod = Integer.parseInt(valor.toString());
                    FachadaInterfaz.getInstancia().modificarCantidad(propiedad, fila, cantMod);
                    this.tablaSeleccionada = false;
                } else {
                    obtenerFilaYAsignarValor(fila, columna, valor);
                }
            } else if (!tablaSeleccionada) {
                arrayList = mapa.get(fila);
                if (columna == 5) {
                    arrayList.set(columna, formato.format(valor));
                } else {
                    arrayList.set(columna, valor);
                }
            } else if (tablaSeleccionada && eliminar) {
                arrayList = mapa.get(fila);
                arrayList.remove(fila);
                mapa.remove(arrayList);
            }
        } catch (NullPointerException ne) {
            System.out.println("Error setValue");
        }
    }

    public void obtenerFilaYAsignarValor(int fila, int columna, Object valor) {
        arrayList = mapa.get(fila);
        arrayList.set(columna, valor);
    }

    public void ingresarNuevaFila(Object valor) {
        if (valor.getClass().isInstance(arrayList)) {
            if (contFilas < FILAS_INICIAL) {
                ArrayList dat = (ArrayList) valor;
                mapa.set(contFilas, dat);
                contFilas++;
            } else {
                mapa.add(mapa.size(), (ArrayList) valor);
            }
        }
    }

    public void eliminarFila(int valor) {
        try {
            if (mapa.size() > 0) {
                arrayList.remove(valor);
                mapa.remove(valor);
                eliminar = true;
                tablaSeleccionada = false;
                contFilas--;
            } else {
                System.out.println("NADA");
            }
        } catch (NullPointerException npe) {
        }
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
        if (columna == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
            return Integer.class;
        } else {
            return String.class;
        }
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public String[] getNombres() {
        return nombres;
    }

    public void setNombres(String[] nombres) {
        this.nombres = nombres;
    }

    public void setTamanoColumna() {
        TableColumn columna0 = vista.tabla.getColumn("Cant");//Obtenemos la columna por medio del titulo
        columna0.setPreferredWidth(70);//Le asignamos un valor al ancho de la columna
        columna0.setMinWidth(70);//Un valor Minimo
        columna0.setMaxWidth(70);//Un valor Maximo
        TableColumn columna1 = vista.tabla.getColumn("Codigo");
        columna1.setPreferredWidth(100);
        columna1.setMaxWidth(100);
        TableColumn columna2 = vista.tabla.getColumn("Descripcion");
        columna2.setPreferredWidth(250);
        columna2.setMaxWidth(250);
        TableColumn columna3 = vista.tabla.getColumn("Descto");
        columna3.setPreferredWidth(70);
        columna3.setMaxWidth(70);
        TableColumn columna4 = vista.tabla.getColumn("Precio");
        columna4.setPreferredWidth(120);
        columna4.setMaxWidth(120);
        TableColumn columna5 = vista.tabla.getColumn("Total");
        columna5.setPreferredWidth(130);
        columna5.setMaxWidth(130);

        vista.tabla.setRowHeight(22);
        vista.tabla.setFont(new Font("Tahoma", Font.PLAIN, 15));
        JTableHeader header = vista.tabla.getTableHeader();
        header.setPreferredSize(new Dimension(20, 22));
        header.setFont(new Font("Tahoma", Font.BOLD, 16));
        header.setForeground(new Color(51, 102, 255));
    }

//    public void setTamanoColumna() {
//        TableColumn columna0 = vista.tabla.getColumn("Cant");//Obtenemos la columna por medio del titulo
//        columna0.setPreferredWidth(80);//Le asignamos un valor al ancho de la columna
//        columna0.setMinWidth(80);//Un valor Minimo
//        columna0.setMaxWidth(80);//Un valor Maximo
//        TableColumn columna1 = vista.tabla.getColumn("Codigo");
//        columna1.setPreferredWidth(90);
//        TableColumn columna2 = vista.tabla.getColumn("Descripcion");
//        columna2.setPreferredWidth(200);
//        TableColumn columna3 = vista.tabla.getColumn("Descuento");
//        columna3.setPreferredWidth(80);
//        TableColumn columna4 = vista.tabla.getColumn("Precio Unitario");
//        columna4.setPreferredWidth(120);
//        TableColumn columna5 = vista.tabla.getColumn("Total");
//        columna5.setPreferredWidth(80);
//
//        vista.tabla.setRowHeight(22);
//        vista.tabla.setFont(new Font("Tahoma", Font.PLAIN, 18));
//        JTableHeader header = vista.tabla.getTableHeader();
//        header.setPreferredSize(new Dimension(20, 22));
//        header.setFont(new Font("Tahoma", Font.BOLD, 18));
//        header.setForeground(new Color(51, 102, 255));
//    }

    public void setTamanoColumnaCompra() {
        TableColumn columna0 = compra.tabla.getColumn("Cant");//Obtenemos la columna por medio del titulo
        columna0.setPreferredWidth(80);//Le asignamos un valor al ancho de la columna
        columna0.setMinWidth(80);//Un valor Minimo
        columna0.setMaxWidth(80);//Un valor Maximo
        TableColumn columna1 = compra.tabla.getColumn("Codigo");
        columna1.setPreferredWidth(90);
        TableColumn columna2 = compra.tabla.getColumn("Descripcion");
        columna2.setPreferredWidth(200);
        TableColumn columna3 = compra.tabla.getColumn("Precio Costo");
        columna3.setPreferredWidth(120);
        TableColumn columna4 = compra.tabla.getColumn("Total");
        columna4.setPreferredWidth(80);

        compra.tabla.setRowHeight(22);
        compra.tabla.setFont(new Font("Tahoma", Font.PLAIN, 18));
        JTableHeader header = compra.tabla.getTableHeader();
        header.setPreferredSize(new Dimension(20, 22));
        header.setFont(new Font("Tahoma", Font.BOLD, 18));
        header.setForeground(new Color(51, 102, 255));
    }

    public void establecerColumNom(String[] nombres) {
        setNombres(nombres);
        setColumnas(nombres.length);
    }

    public void eliminarTodasFilas() {
        try {
            if (mapa.size() > 0) {
                arrayList = new ArrayList();
                mapa = new ArrayList();
                for (int i = 0; i < 6; i++) {
                    arrayList.add("");
                }
                for (int i = 0; i < FILAS_INICIAL; i++) {
                    mapa.add(arrayList);
                }
                eliminar = true;
                tablaSeleccionada = false;
                contFilas = 0;
            } else {
                System.out.println("NADA");
            }
        } catch (NullPointerException npe) {
        }
    }
}
