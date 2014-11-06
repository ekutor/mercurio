package persistenciaFWK;

/**
 *
 * @author Kymera Systems SAS
 */

public class OID implements java.io.Serializable {
    private final String id;

    public OID(String id){
        this.id = id;
    }
    public String getID(){
        return id;
    }
    
    @Override
    public String toString(){
        return id;
    }

}
