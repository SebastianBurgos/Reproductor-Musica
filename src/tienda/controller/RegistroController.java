package tienda.controller;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import tienda.Aplicacion;

/**
 * Clase controladora de la vista de Registro
 * @author Sebastian Burgos Puentes
 */
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

    /**
     * Metodo para registrar un usuario.
     *
     * @param event el evento del botón registrar
     */
    @FXML
    void registrarAction(ActionEvent event) {
    	if (aplicacion.registrar(txtUser.getText(), password.getText(), txtCorreo.getText()) == true) {
    		JOptionPane.showMessageDialog(null, "Usuario "+txtUser.getText()+" creado");
        	txtUser.clear();
        	password.clear();
        	txtCorreo.clear();
    	}else{
    		JOptionPane.showMessageDialog(null, "Usuario "+txtUser.getText()+" ya existe");
    	}
    }

    /**
     * Metodo para volver a la vista de login.
     *
     * @param event el evento del botón atras
     */
    @FXML
    void atrasAction(ActionEvent event) {
    	aplicacion.mostrarLogin();
    }

    /**
     * Metodo para asignar la aplicacion.
     *
     * @param aplicacion la aplicacion a asignar
     */
    public void setAplicacion(Aplicacion aplicacion) {
    	this.aplicacion = aplicacion;
    }

}
