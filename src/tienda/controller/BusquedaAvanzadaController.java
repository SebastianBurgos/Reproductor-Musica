package tienda.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import tienda.Aplicacion;
import tienda.model.Cancion;

/**
 * Clase controladora de la vista para la busqueda avanzada
 * @author Sebastian Burgos Puentes
 */
public class BusquedaAvanzadaController {
	Aplicacion aplicacion;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNombreArtista;

    @FXML
    private TextField txtBuscarO;

    @FXML
    private TextField txtBuscarY;

    /**
     * Metodo para buscar canciones de la forma O
     * Dados los valores de dos o más atributos de una Canción, retorne una lista
	 * con las canciones con al menos un atributo que coincida.
     * @param event
     */
    @FXML
    void buscarO(ActionEvent event) {
    	String busquedaO = txtBuscarO.getText();
    	if (!busquedaO.isEmpty()) {
    		ArrayList<Cancion> canciones = aplicacion.buscarCancionesPorNombreArtista("AC DC");
    		if (canciones != null && canciones.size()>0) {
    			JOptionPane.showMessageDialog(null, canciones.toString());
			}else{
				JOptionPane.showMessageDialog(null, "No se encontraron canciones");
			}
		}else{
			JOptionPane.showMessageDialog(null, "Ingrese los atributos primero");
		}
    }

    /**
     * Metodo para buscar de la forma Y
     * Dados los valores de dos o más atributos de una Canción, retorne una lista
	 * con las canciones con todos los atributos que coincidan
     * @param event
     */
    @FXML
    void buscarY(ActionEvent event) {
    	String busquedaO = txtBuscarO.getText();
    	if (!busquedaO.isEmpty()) {
    		ArrayList<Cancion> canciones = aplicacion.buscarCancionesPorNombreArtista("Shakira");
    		if (canciones != null && canciones.size()>0) {
    			JOptionPane.showMessageDialog(null, canciones.toString());
			}else{
				JOptionPane.showMessageDialog(null, "No se encontraron canciones");
			}
		}else{
			JOptionPane.showMessageDialog(null, "Ingrese los atributos primero");
		}
    }

    /**
     * Metodo para buscar canciones por el nombre del artista
     * Debido a que los artistas se guardan en un árbol binario, su búsqueda
	 * es muy eficiente, por lo tanto, dado el nombre de un Artista debe retornar su lista de
	 * canciones
     * @param event
     */
    @FXML
    void buscarCancionesPorArtista(ActionEvent event) {
    	String nombre = txtNombreArtista.getText();
    	if (!nombre.isEmpty()) {
    		ArrayList<Cancion> canciones = aplicacion.buscarCancionesPorNombreArtista(nombre);
    		if (canciones != null && canciones.size()>0) {
    			JOptionPane.showMessageDialog(null, canciones.toString());
			}else{
				JOptionPane.showMessageDialog(null, "No se encontraron canciones");
			}
    	}else{
			JOptionPane.showMessageDialog(null, "Ingrese el nombre de un artista");
		}
    }

    /**
     * Metodo que setea la aplicacion
     * @param aplicacion
     */
	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

}

