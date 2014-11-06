/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import modelo.Cargo;
import modelo.Categoria;
import modelo.Ciudad;
import modelo.Departamento;
import modelo.Marca;
import modelo.Ubicacion;
import modelo.UnidadMedida;
import persistenciaFWK.ObjetoPersistente;
import persistenciaFWK.adaptadores.IAdaptador;

/**
 *
 * @author JUAN
 */
public class CatalogosGenerales {

    private static IAdaptador adaptador, adapUnidad, adapCategoria, adapMarca, adapUbicacion;
    public static Map<String, Cargo> cargoEnCache;
    public static Map<String, Departamento> deptoEnCache;
    public static Map<String, Ciudad> ciudadEnCache;
    public static Map<String, UnidadMedida> unidadMEnCache;
    public static Map<String, Categoria> categoriaEnCache;
    public static Map<String, Marca> marcaEnCache;
    public static Map<String, Ubicacion> ubicacionEnCache;
    private int pos;

    public CatalogosGenerales() {

        adapUnidad = FactoriaServicios.getInstancia().getAdaptadorDeDatos(UnidadMedida.class);
        unidadMEnCache = adapUnidad.getRegistros();
        adapCategoria = FactoriaServicios.getInstancia().getAdaptadorDeDatos(Categoria.class);
        categoriaEnCache = adapCategoria.getRegistros();
        adapMarca = FactoriaServicios.getInstancia().getAdaptadorDeDatos(Marca.class);
        marcaEnCache = adapMarca.getRegistros();
        adapUbicacion = FactoriaServicios.getInstancia().getAdaptadorDeDatos(Ubicacion.class);
        ubicacionEnCache = adapUbicacion.getRegistros();

    }

    public void adicionarCache(Class modeloDatos, ObjetoPersistente obj) {
        if (modeloDatos.equals(Cargo.class)) {
            if (cargoEnCache == null) {
                cargarMap(Cargo.class);
            }
            cargoEnCache.put(obj.oid, (Cargo) obj);
        } else if (modeloDatos.equals(UnidadMedida.class)) {
            if (unidadMEnCache == null) {
                cargarMap(UnidadMedida.class);
            }
            unidadMEnCache.put(obj.oid, (UnidadMedida) obj);
        } else if (modeloDatos.equals(Categoria.class)) {
            if (categoriaEnCache == null) {
                cargarMap(Categoria.class);
            }
            categoriaEnCache.put(obj.oid, (Categoria) obj);
        } else if (modeloDatos.equals(Marca.class)) {
            if (marcaEnCache == null) {
                cargarMap(Marca.class);
            }
            marcaEnCache.put(obj.oid, (Marca) obj);
        } else if (modeloDatos.equals(Ubicacion.class)) {
            if (ubicacionEnCache == null) {
                cargarMap(Ubicacion.class);
            }
            ubicacionEnCache.put(obj.oid, (Ubicacion) obj);
        }
    }

    public ObjetoPersistente getCache(Class modeloDatos, String id) {
        cargarMap(modeloDatos);
        if (modeloDatos.equals(Cargo.class)) {
            return cargoEnCache.get(id);
        } else if (modeloDatos.equals(UnidadMedida.class)) {
            return unidadMEnCache.get(id);
        } else if (modeloDatos.equals(Categoria.class)) {
            return categoriaEnCache.get(id);
        } else if (modeloDatos.equals(Ubicacion.class)) {
            return ubicacionEnCache.get(id);
        } else if (modeloDatos.equals(Marca.class)) {
            return marcaEnCache.get(id);
        }else{
            return null;
        }
    }

    public void eliminarCache(Class modeloDatos, String id) {
        if (modeloDatos.equals(Cargo.class)) {
            cargoEnCache.remove(id);
        } else if (modeloDatos.equals(UnidadMedida.class)) {
            unidadMEnCache.remove(id);
        }else if (modeloDatos.equals(Ubicacion.class)) {
            ubicacionEnCache.remove(id);
        }else if (modeloDatos.equals(Marca.class)) {
            marcaEnCache.remove(id);
        } else {
            categoriaEnCache.remove(id);
        }
    }

    public static Map cargarMap(Class modeloDatos) {
        adaptador = FactoriaServicios.getInstancia().getAdaptadorDeDatos(modeloDatos);
        if (modeloDatos.equals(Cargo.class)) {
            return cargoEnCache = adaptador.getRegistros();
        } else if (modeloDatos.equals(Departamento.class)) {
            return deptoEnCache = adaptador.getRegistros();
        } else if (modeloDatos.equals(UnidadMedida.class)) {
            return unidadMEnCache = adaptador.getRegistros();
        } else if (modeloDatos.equals(Categoria.class)) {
            return categoriaEnCache = adaptador.getRegistros();
        } else if (modeloDatos.equals(Marca.class)) {
            return marcaEnCache = adaptador.getRegistros();
        } else if (modeloDatos.equals(Ubicacion.class)) {
            return ubicacionEnCache = adaptador.getRegistros();
        } else {
            return null;
        }
    }

    public static void cargarCiudad(int dptoID) {
        if (ciudadEnCache != null) {
            Iterator i = ciudadEnCache.keySet().iterator();
            int dptoCargado = Integer.parseInt(i.next().toString());
            if (dptoCargado != dptoID) {
                String param = String.valueOf(dptoID);
                adaptador = FactoriaServicios.getInstancia().getAdaptadorDeDatos(Ciudad.class);
                ciudadEnCache = adaptador.getRegistros(param);
            }
        } else {
            String param = String.valueOf(dptoID);
            adaptador = FactoriaServicios.getInstancia().getAdaptadorDeDatos(Ciudad.class);
            ciudadEnCache = adaptador.getRegistros(param);
        }

    }
 public ArrayList obtenerListDatos(Class modelo) {

        ArrayList al = new ArrayList();
        if (modelo.equals(Categoria.class)) {
            if (categoriaEnCache == null) {
                cargarMap(Categoria.class);
            }

            for (modelo.Categoria ct : categoriaEnCache.values()) {
                al.add(ct.toArray());

            }
            return al;
        }
        if (modelo.equals(Cargo.class)) {
            if (cargoEnCache == null) {
                cargarMap(Cargo.class);
            }

            for (modelo.Cargo ct : cargoEnCache.values()) {
                al.add(ct.toArray());

            }
            return al;
        }
        if (modelo.equals(UnidadMedida.class)) {
            if (unidadMEnCache == null) {
                cargarMap(UnidadMedida.class);
            }

            for (modelo.UnidadMedida ct : unidadMEnCache.values()) {
                al.add(ct.toArray());

            }
            return al;
        }
        if (modelo.equals(Marca.class)) {
            if (marcaEnCache == null) {
                cargarMap(Marca.class);
            }

            for (modelo.Marca ct : marcaEnCache.values()) {
                al.add(ct.toArray());

            }
            return al;
        }
        if (modelo.equals(Ubicacion.class)) {
            if (ubicacionEnCache == null) {
                cargarMap(Ubicacion.class);
            }

            for (modelo.Ubicacion ct : ubicacionEnCache.values()) {
                al.add(ct.toArray());

            }
            return al;
        }else{
            return null;
        }


    }

}
