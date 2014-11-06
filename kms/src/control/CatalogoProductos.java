package control;

import persistenciaFWK.adaptadores.IAdaptador;
import java.util.Map;
import modelo.Producto;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import utilidades.InvalidException;
import vista.MenuVista;

/**
 *
 * @author Kymera Systems SAS
 */
public class CatalogoProductos {

    private static IAdaptador adaptador;
    public static Map<String, Producto> productosEnCache;
    private int pos;

    public CatalogoProductos() {
    }

    public void ingresarProducto(Producto pr) {
        productosEnCache.put(pr.oid, pr);
    }

    public void eliminarProducto(String oid) {
        productosEnCache.remove(oid);
    }

    public Producto getProducto(String oid) {
        if (productosEnCache == null) {
            cargarMap(Producto.class);
        }
        return productosEnCache.get(oid);
    }

    public Producto traerProductos(int posicion) throws InvalidException {
        Producto pr = null;
        if (productosEnCache == null) {
            cargarMap(Producto.class);
        }
        List<Producto> listaProductos = new ArrayList(productosEnCache.values());
        int numElementos = listaProductos.size();
        if (!listaProductos.isEmpty()) {
            switch (posicion) {
                case CatalogosManager.PRIMERO: {
                    pos = 0;
                    break;
                }
                case CatalogosManager.SIGUIENTE: {
                    if (numElementos - 1 > pos) {
                        pos++;
                    } else {
                        pos = numElementos - 1;
                    }
                    break;
                }
                case CatalogosManager.ANTERIOR: {
                    if (0 < pos) {
                        pos--;
                    } else {
                        pos = 0;
                    }
                    break;
                }
                case CatalogosManager.ULTIMO: {
                    pos = numElementos - 1;
                    break;
                }
            }
            if (MenuVista.esProd) {
                pos = posicion;
            }
            pr = listaProductos.get(pos);
            return pr;
        } else {
            throw new InvalidException("No Se Encuentra Ningun Registro");
        }
    }

    public ArrayList buscarNomProducto(String nombre) throws InvalidException {
        ArrayList al = new ArrayList();
        if (productosEnCache == null) {
            cargarMap(Producto.class);
        }
        for (Producto pr : productosEnCache.values()) {
            if (pr.getDescripcion().contains(nombre)) {
                al.add(pr.toArray());
            }
        }
        if (al.isEmpty()) {
            throw new InvalidException("No Se Encuentra Ningun Registro con ese Nombre!!!");
        }
        return al;
    }

    public static ArrayList buscarStock(int stock) {
        ArrayList st = new ArrayList();
        if (productosEnCache == null) {
            cargarMap(Producto.class);
        }
        for (Producto pr : productosEnCache.values()) {
            if (pr.getValidaStock().equals("SI")) {
                if (pr.getStock() <= stock) {
                    if (pr.getPerecedero().equals("NO")) {
                        pr.setFechaVencimiento("No Perecedero");
                    }
                    st.add(pr.toArray());

                }

            }
        }
        return st;
    }

    public static ArrayList<Producto> buscarxCategoria(String categ) {
        ArrayList st = new ArrayList();
        if (productosEnCache == null) {
            cargarMap(Producto.class);
        }
        for (Producto pr : productosEnCache.values()) {
            if (pr.getCategoria().equals(categ)) {
                st.add(pr);
            }
        }
        return st;
    }

    public static ArrayList buscarFechaVencimiento(String fecha) {
        ArrayList fc = new ArrayList();
        cargarMap(Producto.class);
        for (Producto pr : productosEnCache.values()) {
            if (pr.getPerecedero().equals("SI")) {
                Date fec = utilidades.Utilidades.stringtoDate(pr.getFechaVencimiento());
                Date actual = utilidades.Utilidades.stringtoDate(fecha);
                if (fec.before(actual) || fec.equals(actual)) {
                    fc.add(pr.toArray());
                }
            }
        }
        return fc;
    }

    public Map getProductos() {
        Map pro = new HashMap();
        for (Producto pr : productosEnCache.values()) {
            pro.put(pr.getId(), pr.getDescripcion());
        }
        return pro;
    }

    public static Map cargarMap(Class modeloDatos) {
        adaptador = FactoriaServicios.getInstancia().getAdaptadorDeDatos(modeloDatos);
        return productosEnCache = adaptador.getRegistros();
    }

    public int obtenerPosProducto(String nom) {
        if (productosEnCache == null) {
            cargarMap(Producto.class);
        }
        int cont = 0, posi = 0;
        for (Producto pr : productosEnCache.values()) {
            if (pr.getDescripcion().contains(nom)) {
                posi = cont;
            }
            cont++;
        }
        return posi;
    }
}