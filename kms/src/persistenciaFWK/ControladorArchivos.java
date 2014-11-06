package persistenciaFWK;

import java.io.*;
import java.util.Map;



/**
 * singleton
 * @author Kymera Systems SAS
 */
public class ControladorArchivos {
    private String nombreArchivo;
    private RandomAccessFile archivo;
    private String ELIMINADO = "00";
    public ControladorArchivos(Class clasePersistente) {
        this.nombreArchivo = "data/"+clasePersistente.getName();
        try {
            archivo = new RandomAccessFile(this.nombreArchivo, "rw");
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo: "+nombreArchivo + " no existe");
        }
    }

    public void escribirObjeto(Object obj, String index)  {
      try {
       System.out.println("Archivo="+nombreArchivo);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            //se posiciona al final del archivo
            archivo.seek(archivo.length());
            //guarda el indice del objeto

            archivo.writeUTF(index);
            oos.writeObject(obj);

            byte[] buffer = bos.toByteArray();
            //guarda el tamaño en bytes del objeto
            archivo.writeInt(buffer.length);
            //guarda el objeto
            archivo.write(buffer);

            oos.close();
            bos.close();
        } catch(FileNotFoundException fne){

        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Object leerObjeto(String index) {
        Object aux = null;
        String indice = null;
        int tam = 0;
        try {
            archivo.seek(0);
 
            while (archivo.getFilePointer()!= archivo.length()) {
                indice = archivo.readUTF();
                tam = archivo.readInt();
                if (indice.equals(index)){
            
                    byte[] buffer = new byte[tam];
                    archivo.readFully(buffer);
                    ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(buffer));
                    aux = ois.readObject();
                    ois.close();
                    break;
                }else{
                    archivo.skipBytes(tam);
                }
            }
            
        }catch(java.io.StreamCorruptedException sce){
            sce.printStackTrace();
            aux = null;
        }catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            aux = null;
        } catch (IOException ex) {
            ex.printStackTrace();
            aux = null;
        }
        return aux;
    }


    public void reemplazarObjeto(String index, Object obj) {
        String indice = null;
        int tam = 0;
        try {
            archivo.seek(0);

            while (archivo.getFilePointer()!= archivo.length()) {
                indice = archivo.readUTF();

                tam = archivo.readInt();

                if (indice.equals(index)){
            
                    //4 bytes para el entero y 2 bytes por cada char del string
                    // mas 2 bytes que guarda de mas
                    int cantBytes = (indice.getBytes().length +2) + 4 ;
                    archivo.seek(archivo.getFilePointer() - cantBytes );
                    
                    //reemplazamos el id
                    archivo.writeUTF(ELIMINADO);
                    escribirObjeto(obj,index);
                    break;
                }else{
                    archivo.skipBytes(tam);
                }

            }

        }catch(java.io.StreamCorruptedException sce){
            sce.printStackTrace();

        }catch (IOException ex) {
            ex.printStackTrace();

        }

    }

    public java.util.Map getObjetos() {
        java.util.Map mapa = null;
        String indice;
        Object aux;
        int tam;
        try {
            archivo.seek(0);
            while (archivo.getFilePointer()!= archivo.length()) {
  
                indice = archivo.readUTF();

                
                tam = archivo.readInt();

                if(mapa==null){
                    mapa = new java.util.HashMap();
                }
                if (!indice.equals(ELIMINADO)){
 
                    byte[] buffer = new byte[tam];
                    archivo.readFully(buffer);
                    ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(buffer));
                    aux = ois.readObject();

                    mapa.put(indice, aux);

                    ois.close();
                }else{
                    archivo.skipBytes(tam);
                }

            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Archivo = "+nombreArchivo);
            ex.printStackTrace();
            mapa = null;

        } catch (IOException ex) {
            //entra cuando no lee ois
            System.out.println("Archivo = "+nombreArchivo);
           ex.printStackTrace();
        }
        return mapa;
    }

     public void setObjetos(Map mp) {
        java.util.Iterator i = mp.keySet().iterator();
        while(i.hasNext()){
            Object id = i.next();
            this.escribirObjeto(mp.get(id), id.toString());
        }
    }

    public void eliminarObjeto(String index) {
        String indice = null;
        int tam = 0;
        try {
            archivo.seek(0);
            while (archivo.getFilePointer()!= archivo.length()) {
                indice = archivo.readUTF();
                tam = archivo.readInt();

                if (indice.equals(index)){
                    System.out.println("Encontrado");
                    //4 bytes para el entero y sbytes por cada char del string
                    int cantBytes = (indice.getBytes().length +2) + 4 ;
                    archivo.seek(archivo.getFilePointer() - cantBytes );
                    //reemplazamos el id
                    archivo.writeUTF(ELIMINADO);

                    break;
                }else{
                    archivo.skipBytes(tam);
                }

            }

        }catch(java.io.StreamCorruptedException sce){
            sce.printStackTrace();

        }catch (IOException ex) {
            ex.printStackTrace();

        }

    }
    private void compactar(){
        //hacerla
    }

    
}
