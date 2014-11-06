package control;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import modelo.Venta;
import persistenciaFWK.adaptadores.IAdaptador;

/**
 *
 * @author Kymera Systems SAS
 */
public class HistorialVentas {
    public Map<String,modelo.Venta> ventasEnCache;
    private IAdaptador adaptador;

    public HistorialVentas(){
        adaptador = FactoriaServicios.getInstancia().getAdaptadorDeDatos(ControladorVenta.class);
        ventasEnCache = new HashMap();

    }
    public void ingresarVenta(String id, modelo.Venta ve) {
        try {
            ventasEnCache.put(id, ve);
            adaptador.putObject(ve, IAdaptador.INSERTAR);
        } catch (Exception e) {
        }

    }
    public ArrayList traerDatos(){
        ArrayList al = new ArrayList();
        for(modelo.Venta ven:ventasEnCache.values()){
            al.add(ven.toArray());
        }
        return al;
    }

    public Map getVentasEnCache() {
        return ventasEnCache;
    }

    public void setVentasEnCache(String desde, String hasta) {
        String[] parametrosBusqueda = {desde,hasta};
        ventasEnCache = FactoriaServicios.getInstancia().getAdaptadorDeDatos(Venta.class).getRegistros(parametrosBusqueda);
    }


    private void organizarDatos(){
        //ordenamiento Burbuja
//        public static int[] OrdenarBurbuja(int[] n){
//        int temp;
//        int t = n.length;
//        for (int i = 1; i < t; i++) {
//            for (int k = t- 1; k >= i; k--) {
//                if(n[k] < n[k-1]){
//                    temp = n[k];
//                    n[k] = n[k-1];
//                    n[k-1]=  temp;
//                }//fin if
//            }// fin 2 for
//        }//fin 1 for
//        return n;
//    }//fin
//        ArrayList al = new ArrayList();
//        modelo.Venta vtaAux = new modelo.Venta();
//        vtaAux.setOID("-10");
//
//        ArrayList data = new ArrayList(ventasEnCache.values());
//        int total = data.size();
//
//        for(int i=1; i<total;i++){
//            for(int k= total -1;k>=i;k--){
//                if(data.get(k)){
//
//                }
//            }
//
//            al.add(ven.toArray());
//        }
    }
}
