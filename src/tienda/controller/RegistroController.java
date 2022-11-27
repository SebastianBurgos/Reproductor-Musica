package tienda.controller;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import tienda.Aplicacion;

public class RegistroController {
	Aplicacion aplicacion;

    @FXML
    private PasswordField password;

    @FXML
    private TextField txtUser;

    @FXML
    private Button btnRegistrar;

    @FXML
    private TextField txtCorreo;

    @FXML
    private Button btnAtras;

    @FXML
    void registrarAction(ActionEvent event) {

		aplicacion.registrar(txtUser.getText(), password.getText(), txtCorreo.getText());
		JOptionPane.showMessageDialog(null, "Usuario "+txtUser.getText()+" creado");
    	txtUser.clear();
    	password.clear();
    	txtCorreo.clear();

    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	aplicacion.mostrarVentanaPrincipal();
    }

    @FXML
    void atrasAction(ActionEvent event) {
    	aplicacion.mostrarVentanaPrincipal();
    }

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}
}
