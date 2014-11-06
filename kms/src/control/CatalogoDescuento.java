package control;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import modelo.Descuento;
import utilidades.InvalidException;
import utilidades.Utilidades;

/**
 *
 * @author Kymera Systems SAS
 */
public class CatalogoDescuento {

    public static Map<String, Descuento> descuentosEnCache;

    public CatalogoDescuento() {
    }

    public void ingresarDescuento(String id, Descuento descuento) {
        descuentosEnCache.put(id, descuento);

    }

    public void actualizarDescuento(String id, Descuento descuento) {
        descuentosEnCache.remove(id);
        descuentosEnCache.put(id, descuento);

    }

    public void eliminarDescuento(String id) {
        descuentosEnCache.remove(id);
    }

    /**
     * Calcula verifica y devuelve la suma de los descuentos de un Producto
     * dado segun su id
     * @param id
     * @return
     */
    public double getDescuentosActivos(String id, String idCliente) {
        double descuento = 0;
        persistenciaFWK.adaptadores.IAdaptador adaptador = FactoriaServicios.getInstancia().getAdaptadorDeDatos(Descuento.class);
        CatalogoDescuento.descuentosEnCache = adaptador.getRegistros();
        for (Descuento desc : descuentosEnCache.values()) {
            if (desc.getIdProd().equals(id)) {
                if (compararFechas(desc)) {
                    if (desc.getHoraFinal() >= Utilidades.getHoraActualInt()) {
                        if (desc.getIdCliente().equals(idCliente)) {
                            descuento += desc.getDescuento();
                        } else if (desc.getIdCliente().equals("0")) {
                            descuento += desc.getDescuento();
                        } else {
                        }
                    }
                }
            }
        }
        return descuento;
    }

    /**
     * retorna los descuentos activos del dia
     * @return
     */
    public List getDescuentosActivos() throws InvalidException {
        List l = new ArrayList();
        for (Descuento desc : descuentosEnCache.values()) {
            desc.setDescuento(this.getDescuentosActivos(desc.getIdProd(), "0"));
            l.add(desc.toArray());
        }
        if (l.isEmpty()) {
            throw new InvalidException("No Se Encuentra Ningun Registro");
        }
        return l;
    }

    /**
     * Compara la Fecha del Descuento con la fecha del sistema para validar que
     * descuentos van aplicar
     * @param desc
     * @return
     */
    public boolean compararFechas(Descuento desc) {
        if (desc.getAñoFinal() == Utilidades.getAñoActual()) {
            if (desc.getMesFinal() == Utilidades.getMesActual()) {
                if (desc.getDiaFinal() >= Utilidades.getDiaActual()) {
                    return true;
                } else {
                    return false;
                }
            } else if (desc.getMesFinal() > Utilidades.getMesActual()) {
                return true;
            } else {
                return false;
            }
        } else if (desc.getAñoFinal() > Utilidades.getAñoActual()) {
            return true;
        } else {
            return false;
        }
    }
}
