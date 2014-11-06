package control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import modelo.Compra;
import persistenciaFWK.adaptadores.IAdaptador;

/**
 *
 * @author Kymera Systems SAS
 */
public class HistorialCompras {
    public Map<String,Compra> comprasEnCache;
    private Map<String,LineaCompra> lineasComprasEnCache;
    private IAdaptador adaptador;

    public HistorialCompras(){
        adaptador = FactoriaServicios.getInstancia().getAdaptadorDeDatos(Compra.class);
        comprasEnCache = new HashMap();
        lineasComprasEnCache = new HashMap();

    }
    public void ingresarCompra(String id, Compra co) {
        try {
            comprasEnCache.put(id, co);
            adaptador.putObject(co, IAdaptador.INSERTAR);
        } catch (Exception e) {
        }

    }
    public ArrayList traerDatos(){
        ArrayList al = new ArrayList();
        for(Compra com:comprasEnCache.values()){
            al.add(com.toArray());
        }
        return al;
    }

    public Map getComprasEnCache() {
        return comprasEnCache;
    }

    public void setComprasEnCache(String desde, String hasta) {
        String[] parametrosBusqueda = {desde,hasta};
        comprasEnCache = FactoriaServicios.getInstancia().getAdaptadorDeDatos(Compra.class).getRegistros(parametrosBusqueda);
    }
    public void actualizarCompra(String id,Compra compra){
        comprasEnCache.remove(id);
        comprasEnCache.put(id, compra);

    }
    public void eliminarCompra(String id){
        comprasEnCache.remove(id);
    }

    public ArrayList buscarComprasEstado(String estado) {
        ArrayList al = new ArrayList();
        for (Compra com : comprasEnCache.values()) {
            if (com.getEst().contains(estado)) {
                al.add(com.toArray());
            }
        }
        return al;
    }
    public List getLineaCompra(String numOrden){
        List al = new ArrayList();
        for (LineaCompra lin : lineasComprasEnCache.values()) {
            if (lin.getNumOrden().equals(numOrden)) {
                al.add(lin.toArray());
            }
        }
        return al;
    }

    public void setComprasEnCacheXEstado(String estado) {
        String parametrosBusqueda = estado;
        comprasEnCache = FactoriaServicios.getInstancia().getAdaptadorDeDatos(Compra.class).getRegistros(parametrosBusqueda);
    }

    public void setLineasComprasEnCache(String[] id) {
        String[] parametrosBusqueda = id;
        lineasComprasEnCache = FactoriaServicios.getInstancia().getAdaptadorDeDatos(Compra.class).getRegistros(parametrosBusqueda);
    }

    public void modificarCompra(String oid, Compra compra) {
        try {
            comprasEnCache.put(oid, compra);
            adaptador.putObject(compra, IAdaptador.MODIFICAR);
        } catch (Exception e) {
        }
    }

    public ArrayList buscarComprasFiltro(String filtro) {
        ArrayList al = new ArrayList();
        if(comprasEnCache.isEmpty()){
            comprasEnCache = cargarComprasEnCache(Compra.class);
        }
        for (Compra com : comprasEnCache.values()) {
            if (com.getProvID().contains(filtro) || com.oid.contains(filtro)) {
                al.add(com.toArray());
            }
        }
        return al;
    }

    public Map<String, Compra> cargarComprasEnCache(Class modeloDatos) {
        adaptador = FactoriaServicios.getInstancia().getAdaptadorDeDatos(modeloDatos);
        return comprasEnCache = adaptador.getRegistros();
    }

}
