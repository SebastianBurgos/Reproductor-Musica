package tienda.persistencia;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import tienda.model.Tienda;

public class Persistencia {

    public static final String RUTA_ARCHIVO_MODELO_tienda_XML = "src/tienda/persistencia/tienda.xml";


    public static Tienda cargarRecursoXML() {
    	Tienda tienda = null;
            try {
                tienda = (Tienda) cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_tienda_XML);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return tienda;
     }

    public static void guardarRecursoXML(Tienda tienda) {
            try {
                 salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_tienda_XML, tienda);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
     }

    public static Object cargarRecursoSerializadoXML(String rutaArchivo) throws IOException {

        XMLDecoder decodificadorXML;
        Object objetoXML;

        decodificadorXML = new XMLDecoder(new FileInputStream(rutaArchivo));
        objetoXML = decodificadorXML.readObject();
        decodificadorXML.close();
        return objetoXML;

    }

    public static void salvarRecursoSerializadoXML(String rutaArchivo, Object objeto) throws IOException {

        XMLEncoder codificadorXML;

        codificadorXML = new XMLEncoder(new FileOutputStream(rutaArchivo));
        codificadorXML.writeObject(objeto);
        codificadorXML.close();

    }
}
