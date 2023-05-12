package tienda.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import tienda.Aplicacion;

/**
 * Clase controladora de la vista de Reporte
 * @author Sebastian Burgos Puentes
 */
public class ReporteController {
	Aplicacion aplicacion;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblArtistaPopular;

    @FXML
    private Label lblGeneroPopular;

    /**
     * Metodo para asignar la aplicacion.
     *
     * @param aplicacion la aplicacion a asignar
     */
	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;

		lblGeneroPopular.setText(aplicacion.obtenerGeneroMasPopular());
		lblArtistaPopular.setText(aplicacion.obtenerArtistaMasPopular());
	}
}
