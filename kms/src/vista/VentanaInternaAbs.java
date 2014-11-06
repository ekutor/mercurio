package vista;

import java.awt.Color;

/**
 *
 * @author Kymera Systems SAS
 */
public abstract class VentanaInternaAbs extends javax.swing.JInternalFrame {
    protected Color FOCO_GANADO = new Color(231,251,252);
    protected Color FOCO_PERDIDO = new Color(255,255,255);
    public VentanaInternaAbs(){
        super("",true,false,false,true);

    }
    /*Metodo para poner visibles todas las Vistas Internas*/
    public void esVisible(){
        setVisible(true);
    }
    /*Metodo para establecer Foco a los JTextFiled*/
    public abstract void establecerFoco();

    public abstract void setFocoGanado(java.awt.event.FocusEvent evt);

    public abstract void setFocoPerdido(java.awt.event.FocusEvent evt);

}
