package tienda.controller;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import tienda.Aplicacion;
import tienda.model.Tienda;


public class LoginController {
	Aplicacion aplicacion;

	@FXML
	private ComboBox<String> comboBoxRol=new ComboBox<String>();

	ObservableList<String> roles = FXCollections.observableArrayList();

    @FXML
    private PasswordField password;

    @FXML
    private TextField user;

    @FXML
    private Button btnIngresar;

    @FXML
    private Button btnRegistrar;


    public void initialize() {
    	roles.add("Administrador");
    	roles.add("Usuario");
    	comboBoxRol.setItems(roles);

    }

    @FXML
    void registrarAction(ActionEvent event) {
    	aplicacion.abrirRegistro();
    }

    @FXML
    void ingresarAction(ActionEvent event) {

			if (comboBoxRol.getSelectionModel().getSelectedItem().equals("Administrador") && Tienda.verificarAdmin(user.getText(), password.getText())) {
        		JOptionPane.showMessageDialog(null, "BIENVENIDO ADMINISTRADOR");
        		aplicacion.mostrarVentanaAdmin();

    		}else{
			if (comboBoxRol.getSelectionModel().getSelectedItem().equals("Usuario") && aplicacion.verificarUsuario(user.getText(), password.getText())) {
				JOptionPane.showMessageDialog(null, "BIENVENIDO USUARIO");
				aplicacion.abrirTienda(user.getText());
    			}else{
    				user.clear();
    				password.clear();
    				JOptionPane.showMessageDialog(null, "Usuario no encontrado o contraseña incorrecta", "Error", 0);
    			}
    		}
    }

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

}
