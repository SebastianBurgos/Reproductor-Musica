package tienda.persistencia;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import tienda.model.Tienda;

/**
 * Clase Persistencia para cargar recursos serializados y serializar todos los
 * objetos
 * @author Sebastian Burgos Puentes
 *
 */
public class Persistencia {

    public static final String RUTA_ARCHIVO_MODELO_tienda_XML = "src/tienda/persistencia/data.xml";


    /**
     * Carga el archivo XML que contiene los datos de la tienda.
     * @return Una instancia de Tienda con los datos cargados.
     */
    public static Tienda cargarRecursoXML() {
        Tienda tienda = null;
        try {
            tienda = (Tienda) cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_tienda_XML);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tienda;
    }

    /**
     * Guarda los datos de la tienda en un archivo XML.
     * @param tienda La instancia de Tienda a guardar.
     */
    public static void guardarRecursoXML(Tienda tienda) {
        try {
            salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_tienda_XML, tienda);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Carga un archivo serializado en formato XML y devuelve el objeto correspondiente.
     * @param rutaArchivo La ruta del archivo a cargar.
     * @return El objeto serializado cargado.
     * @throws IOException Si ocurre algún error al leer el archivo.
     */
    private static Object cargarRecursoSerializadoXML(String rutaArchivo) throws IOException {
        XMLDecoder decodificadorXML;
        Object objetoXML;
        decodificadorXML = new XMLDecoder(new FileInputStream(rutaArchivo));
        objetoXML = decodificadorXML.readObject();
        decodificadorXML.close();
        return objetoXML;
    }

    /**
     * Guarda un objeto en formato XML en un archivo.
     * @param rutaArchivo La ruta del archivo donde se va a guardar el objeto.
     * @param objeto El objeto a guardar.
     * @throws IOException Si ocurre algún error al escribir en el archivo.
     */
    private static void salvarRecursoSerializadoXML(String rutaArchivo, Object objeto) throws IOException {
        XMLEncoder codificadorXML;
        codificadorXML = new XMLEncoder(new FileOutputStream(rutaArchivo));
        codificadorXML.writeObject(objeto);
        codificadorXML.close();
    }

}
