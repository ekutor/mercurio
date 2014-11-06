package modelo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import vista.MenuVista;

/**
 *
 * @author Kymera Systems SAS
 */
public class ModeloTablaBusqueda extends AbstractTableModel {

    private List datos;
    private String[] nombres;
    private final int FILAS_INICIAL = 10;
    private int columnas;
    public boolean tablaSeleccionada = false, tablaProductos = false,
            tablaProveedores = false, tablaClientes = false, tablaPersonal = false,
            tablaCompras = false;
    private String val, nom;

    public ModeloTablaBusqueda() {
        datos = new ArrayList();

    }

    public ModeloTablaBusqueda(List datos) {
        this.datos = datos;
        if (MenuVista.esProducto) {
            tablaProductos = true;
            tablaProveedores = false;
            tablaClientes = false;
            tablaPersonal = false;
            tablaCompras = false;
        } else if (MenuVista.esProveedor) {
            tablaProveedores = true;
            tablaProductos = false;
            tablaClientes = false;
            tablaPersonal = false;
            tablaCompras = false;
        } else if (MenuVista.esCliente) {
            tablaClientes = true;
            tablaProveedores = false;
            tablaProductos = false;
            tablaPersonal = false;
            tablaCompras = false;
        } else if (MenuVista.esPersonal) {
            tablaPersonal = true;
            tablaClientes = false;
            tablaProveedores = false;
            tablaProductos = false;
            tablaCompras = false;
        } else if (MenuVista.esCompra) {
            tablaCompras = true;
            tablaPersonal = false;
            tablaClientes = false;
            tablaProveedores = false;
            tablaProductos = false;
        }
    }

    public int getRowCount() {
        return (datos.size() > FILAS_INICIAL) ? datos.size() : FILAS_INICIAL;
    }

    public int getColumnCount() {
        return columnas;
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
        if (tablaProductos) {
            if (datos.size() > 0 && fila < datos.size()) {
                return cargarTablaProducto(fila, columna);
            } else {
                return null;
            }
        } else if (tablaProveedores) {
            if (datos.size() > 0 && fila < datos.size()) {
                return cargarTablaProveedores(fila, columna);
            } else {
                return null;
            }
        } else if (tablaClientes) {
            if (datos.size() > 0 && fila < datos.size()) {
                return cargarTablaClientes(fila, columna);
            } else {
                return null;
            }
        } else if (tablaPersonal) {
            if (datos.size() > 0 && fila < datos.size()) {
                return cargarTablaPersonal(fila, columna);
            } else {
                return null;
            }
        } else if (tablaCompras) {
            if (datos.size() > 0 && fila < datos.size()) {
                return cargarTablaCompras(fila, columna);
            } else {
                return null;
            }
        }
        return null;
    }

    public void setValor(Object valor) {
        val = (String) valor;
    }

    public String getValor() {
        return val;
    }

    public void setNom(Object valor) {
        nom = (String) valor;
    }

    public String getNom() {
        return nom;
    }

    public void establecerColumNom(String[] nombres) {
        setNombres(nombres);
        setColumnas(nombres.length);
    }

    public Object cargarTablaProducto(int fila, int columna) {
        if (fila != -1) {
            List l = (List) datos.get(fila);
            if (tablaSeleccionada) {
                setValor(l.get(0));
                setNom(l.get(1));
            }
            if (columna == 2) {
                return utilidades.Utilidades.darFormatoNumero((Number) l.get(2));
            }
            if (columna == 3) {
                return l.get(5);
            }
            if (columna == 4) {
                return l.get(3);
            } else {
                return l.get(columna);
            }
        } else {
            return null;
        }
    }

    public Object cargarTablaProveedores(int fila, int columna) {
        if (fila != -1) {
            List l = (List) datos.get(fila);
            if (tablaSeleccionada) {
                setValor(l.get(0));
            }
            if (columna == 2) {
                return l.get(5);
            } else {
                return (columna == 3) ? l.get(2) : l.get(columna);
            }
        } else {
            return null;
        }
    }

    public Object cargarTablaClientes(int fila, int columna) {
        if (fila != -1) {
            List l = (List) datos.get(fila);
            if (tablaSeleccionada) {
                setValor(l.get(0));
            }
            return l.get(columna);
        } else {
            return null;
        }
    }

    public Object cargarTablaPersonal(int fila, int columna) {
        if (fila != -1) {
            List l = (List) datos.get(fila);
            if (tablaSeleccionada) {
                setValor(l.get(0));
            }
            if (columna == 2) {
                return l.get(2);
            } else {
                return (columna == 3) ? l.get(8) : l.get(columna);
            }
        } else {
            return null;
        }
    }

    private Object cargarTablaCompras(int fila, int columna) {
        if (fila != -1) {
            List l = (List) datos.get(fila);
            if (tablaSeleccionada) {
                setValor(l.get(0));
            }
            if (columna == 0) {
                return l.get(0);
            } else if (columna == 1) {
                return l.get(6);
            } else if (columna == 2) {
                return l.get(2);
            } else if (columna == 3) {
                return utilidades.Utilidades.darFormatoNumero((Number)l.get(4));
            }else {
                return (columna == 4) ? l.get(1) : l.get(columna);
            }
        } else {
            return null;
        }
    }
}
