package tienda.controller;


import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import tienda.Aplicacion;

public class AgregarCancionController {
	Aplicacion aplicacion;

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnGuardar;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtGenero;

    @FXML
    private TextField txtArtista;

    @FXML
    private TextField txtLink;

    @FXML
    private TextField txtDuracion;

    @FXML
    private TextField txtYear;

    @FXML
    private TextField txtAlbum;

    @FXML
    void atrasAction(ActionEvent event) {
    	aplicacion.mostrarVentanaAdmin();
    }

    @FXML
    void registrarCancionAction(ActionEvent event) {

		aplicacion.registrarCancion(txtNombre.getText(), txtGenero.getText(), txtArtista.getText(),txtYear.getText(),txtAlbum.getText(), txtDuracion.getText(), txtLink.getText());
		JOptionPane.showMessageDialog(null, "Usuario agregada con exito");
		txtNombre.clear();
		txtGenero.clear();
		txtArtista.clear();
		txtLink.clear();
		txtDuracion.clear();
		txtYear.clear();
		txtAlbum.clear();

    }

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

}
