package tienda.controller;


import java.io.File;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import tienda.Aplicacion;
/**
 * Clase controladora de la vista para agregar artistas
 * @author Sebastian Burgos Puentes
 */
public class AgregarArtistaController {
	Aplicacion aplicacion;

    @FXML
    private Button btnAtras;

    @FXML
    private TextField txtNombre;

    @FXML
    private Button btnGuardar;

    @FXML
    private TextField txtNacionalidad;

    @FXML
    private Label lblNombreArchivo;

    /**
     * Metodo de evento de boton para volver a la ventana de admin
     * @param event
     */
    @FXML
    void atrasAction(ActionEvent event) {
    	aplicacion.mostrarVentanaAdmin();
    }

    /**
     * Metodo de evento de boton para registrar un artista
     * @param event
     */
    @FXML
    void registrarArtistaAction(ActionEvent event) {
		aplicacion.registrarArtista(txtNombre.getText(), txtNacionalidad.getText(), false);
		JOptionPane.showMessageDialog(null, "Artista creado con exito");
		txtNombre.clear();
		txtNacionalidad.clear();

    }

    /**
     * Metodo de evento para cargar un archivo de artistas
     * @param event
     */
    @FXML
    void cargarArchivoArtistas(ActionEvent event){
    	FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar Archivo");

        // Agregar filtros para facilitar la busqueda
        fileChooser.getExtensionFilters().addAll(
        		new FileChooser.ExtensionFilter("text", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*")
        );

        // Obtener el archivo seleccionado
        File file = fileChooser.showOpenDialog(aplicacion.getPrimaryStage());

        // Mostar el archivo subido
        if (file != null) {
        	lblNombreArchivo.setText(file.getName());
        	aplicacion.leerArchivoArtistas(file.getAbsolutePath());
        	JOptionPane.showMessageDialog(null, "Datos cargados desde archivo correctamente");
        }
    }

    /**
     * Metodo para setear la aplicacion enviada por parametro
     * @param aplicacion
     */
	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

}
