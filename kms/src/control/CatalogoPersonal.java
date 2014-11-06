package control;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import modelo.Personal;
import persistenciaFWK.adaptadores.IAdaptador;
import utilidades.InvalidException;

/**
 *
 * @author Kymera Systems SAS
 */
public class CatalogoPersonal {

    public static Map<String, Personal> personalEnCache;
    private static IAdaptador adaptador;
    private int pos;

    public CatalogoPersonal() {

        adaptador = FactoriaServicios.getInstancia().getAdaptadorDeDatos(Personal.class);
        personalEnCache = adaptador.getRegistros();

    }

    public void adicionarPersonal(Personal pr) {
        personalEnCache.put(pr.getCedula(), pr);
    }

    public Personal getPersonalCache(String id) {
        return personalEnCache.get(id);
    }

    public void eliminarPersonalCache(String id) {
        personalEnCache.remove(id);
    }

    public Personal getPersonal(String id) {
          if (personalEnCache == null) {
            cargarMap();
        }
        return (Personal) personalEnCache.get(id);
    }

    public Personal traerPersonal(int posicion)throws InvalidException {
        Personal pr = null;
        List<Personal> listaPersonal = new ArrayList(personalEnCache.values());
        int numElementos = listaPersonal.size();
        if (!listaPersonal.isEmpty()) {
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
            pr = listaPersonal.get(pos);
            return pr;
        } else {
            throw new InvalidException("No Se ha creado ningun Personal \nen la Base de Datos");
        }
    }

    public static Map cargarMap() {
        adaptador = FactoriaServicios.getInstancia().getAdaptadorDeDatos(Personal.class);
        return personalEnCache = adaptador.getRegistros();
    }

    public ArrayList buscarNombrePersonal(String nombre) throws InvalidException {
        ArrayList l = new ArrayList();
        if (personalEnCache == null) {
            cargarMap();
        }
        for (Personal p : personalEnCache.values()) {
            if (p.getNombre().contains(nombre)) {
                l.add(p.toArray());
            } else if (p.getApellido().contains(nombre)) {
                l.add(p.toArray());
            } else if (p.getCedula().contains(nombre)) {
                l.add(p.toArray());
            } else if (p.getEmail().contains(nombre)) {
                l.add(p.toArray());
            } else if (p.getTelefono().contains(nombre)) {
                l.add(p.toArray());
            } else if (p.getCelular().contains(nombre)) {
                l.add(p.toArray());
            }
        }
        if (l.isEmpty()) {
            throw new InvalidException("No Se Encuentra Ningun Registro con ese Nombre!!!");
        }
        return l;

    }


}
