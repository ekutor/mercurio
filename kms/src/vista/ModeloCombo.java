package vista;

import java.util.*;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Kymera Systems SAS
 */
public class ModeloCombo extends AbstractListModel implements ComboBoxModel {

    private Map datos;
    private Object itemSeleccionado, indexSeleccionado;
    private List lista;

    public ModeloCombo() {
        this.datos = new HashMap();
        lista = new ArrayList(datos.values());
    }

    public ModeloCombo(Map data) {
        if (data != null) {
            this.ordenarDatosxValor(data);
            lista = new ArrayList(datos.values());
        } else {
            this.datos = new HashMap();
            lista = new ArrayList(datos.values());
        }
    }

    @Override
    public int getSize() {
        return this.datos.size();
    }

    public Object getElementAt(int index) {
        return lista.get(index);
    }

    public void setSelectedItem(Object anItem) {
        itemSeleccionado = anItem;
        List l = new ArrayList(datos.keySet());
        int cont = 0;
        boolean encontrado = false;
        for (Object o : datos.values()) {
            if (o.equals(itemSeleccionado)) {
                encontrado = true;
                break;
            }
            cont++;
        }
        if (encontrado) {
            indexSeleccionado = l.get(cont);
        }

    }

    public Object getSelectedItem() {
        return this.itemSeleccionado;
    }

    public void setSelectedItemMap(Object index) {
        indexSeleccionado = index;
        this.itemSeleccionado = datos.get(index);
    }

    public Object getSelectedIndex() {
        return indexSeleccionado;
    }

    public void limpiarSeleccion() {
        indexSeleccionado = null;
        itemSeleccionado = null;
    }

    public Object getElementoxID(String id) {
        List l = new ArrayList(datos.keySet());
        int cont = 0;
        boolean encontrado = false;
        for (Object o : l) {
            if (o.toString().equals(id)) {
                encontrado = true;
                break;
            }
            cont++;
        }
        if (encontrado) {
            return datos.get(l.get(cont));
        } else {
            return null;
        }


    }

    public void setElementoxID(String id) {

        List l = new ArrayList(datos.keySet());
        int cont = 0;
        boolean encontrado = false;
        for (Object o : l) {
            if (o.toString().equals(id)) {
                encontrado = true;
                break;
            }
            cont++;
        }
        if (encontrado) {
            indexSeleccionado = l.get(cont);
            itemSeleccionado = datos.get(indexSeleccionado);
            setSelectedItem(itemSeleccionado);
        }
    }

    private void ordenarDatosxLlave() {
        Map mapOrdenado = new TreeMap(datos);
        Set ref = mapOrdenado.keySet();
        Iterator it = ref.iterator();
        while (it.hasNext()) {
            System.out.println((String) it.next());
        }
    }

    private void ordenarDatosxValor(Map dat) {
        datos = new LinkedHashMap();
        List mapKeys = new ArrayList(dat.keySet());
        List mapValues = new ArrayList(dat.values());
        TreeSet conjuntoOrdenado = new TreeSet(mapValues);
        Object[] arrayOrdenado = conjuntoOrdenado.toArray();
        int size = arrayOrdenado.length;
        for (int i = 0; i < size; i++) {
            datos.put(mapKeys.get(mapValues.indexOf(
                    arrayOrdenado[i])), arrayOrdenado[i]);
        }

        /*
        Iterator it1 = mapResultado.values().iterator();
        while (it1.hasNext()) {
        System.out.println( it1.next().toString());
        }*/
    }
}
