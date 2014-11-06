package persistenciaFWK;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kymera Systems SAS
 */
public class Executor implements Runnable {

    private List<ICommand> comandos;
    private Thread hilo;
    private boolean ejecutar;
    private static int numHilo;
    private static Executor INSTANCIA;

    public Executor() {
        numHilo++;
        comandos = new ArrayList();
        hilo = new Thread(this, "hilo "+numHilo);
        ejecutar = true;
    }
    
    public static Executor getInstancia(){
        if(INSTANCIA ==null){
            INSTANCIA = new Executor();
        }
        return INSTANCIA;
    }

    public void run() {
        while (ejecutar) {
            try {
                System.out.println("NOMBR DE HILO:"+hilo.getName());
                ejecutarTransacciones();
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                System.out.println("error al ejecutar el hilo");
                ex.printStackTrace();
                ejecutar = false;
            }
        }
    }

    public void ejecutarTransacciones() {
        //ordenar();
        try {
            for (ICommand comando : comandos) {

                if (comando.estaEjecutado()) {
                    comandos.remove(comando);
                } else {
                    System.out.println("ejecutando "+comando.toString()+" Estado "+ comando.estaEjecutado());
                    comando.ejecutar();
                }
            }
        } catch (java.util.ConcurrentModificationException cm) {
            //System.out.println("comandos finalizados");
            this.ejecutar = false;
            comandos.clear();
        }

    }

    private  void ordenar() {
        //metodo de ordenacion para organizar las transacciones en la BD
    }

    public void execute(ICommand comando) {

        comandos.add(comando);
        hilo.start();
        
    }
}
