package control;

import persistenciaFWK.adaptadores.DatosLocales;
import persistenciaFWK.adaptadores.AdaptadorBD;
import persistenciaFWK.adaptadores.IAdaptador;

/**
 * Singleton patron creador crea los servicios de la aplicacion(adaptadores, servicios externos , serv contabilidad etc)
 * @author Kymera Systems SAS
 */

public class FactoriaServicios {

   private static FactoriaServicios INSTANCIA;

   private FactoriaServicios(){

    }

    public static FactoriaServicios getInstancia(){
        if(INSTANCIA ==null){
            INSTANCIA = new FactoriaServicios();
        }
        return INSTANCIA;
    }

    public IAdaptador  getAdaptadorDeDatos(Class clasePersistente){
        IAdaptador servicioExterno = new AdaptadorBD(clasePersistente);
        return new DatosLocales(servicioExterno);
    }
  
}
