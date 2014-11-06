package vista;
/**
 *
 * @author Kymera Systems SAS
 */


public class Principal {
    public static void main(String args[]){
        try{
            javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        }
        catch(Exception e){
           e.printStackTrace();
        }
    
        new VentanaInicio(true);
   }

}
