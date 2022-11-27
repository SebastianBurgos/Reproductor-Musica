package tienda.controller;


import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import tienda.Aplicacion;

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
    void atrasAction(ActionEvent event) {
    	aplicacion.mostrarVentanaAdmin();
    }

    @FXML
    void registrarArtistaAction(ActionEvent event) {

		aplicacion.registrarArtista(txtNombre.getText(), txtNacionalidad.getText(), false);
		JOptionPane.showMessageDialog(null, "Artista creado con exito");
		txtNombre.clear();
		txtNacionalidad.clear();

    }

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

}
