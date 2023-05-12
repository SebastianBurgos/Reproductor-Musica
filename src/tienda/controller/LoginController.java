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
/**
 * Clase controladora de la vista de Login
 * @author Sebastian Burgos Puentes
 */
public class LoginController {
	Aplicacion aplicacion;

	@FXML
	private ComboBox<String> comboBoxRol = new ComboBox<String>();

	ObservableList<String> roles = FXCollections.observableArrayList();

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUsername;

    @FXML
    private Button btnIngresar;

    @FXML
    private Button btnRegistrar;

    /**
     * Inicializa los valores de la vista de login.
     * Agrega los roles "Administrador" y "Usuario" a la lista de roles y la establece en el ComboBox.
     */
    public void initialize() {
        roles.add("Administrador");
        roles.add("Usuario");
        comboBoxRol.setItems(roles);
    }

    /**
     * Acci�n que se ejecuta cuando se hace clic en el bot�n "Registrar".
     * Abre la ventana de registro de la aplicaci�n.
     *
     * @param event Evento que activa esta acci�n.
     */
    @FXML
    void registrarAction(ActionEvent event) {
        aplicacion.abrirRegistro();
    }

    /**
     * Acci�n que se ejecuta cuando se hace clic en el bot�n "Ingresar".
     * Verifica si los campos del usuario son v�lidos y los valida.
     * Si el usuario es administrador, se muestra la ventana de administrador.
     * Si el usuario es usuario, se muestra la ventana de la tienda.
     * Si el usuario no existe o la contrase�a es incorrecta, se muestra un mensaje de error.
     *
     * @param event Evento que activa esta acci�n.
     */
    @FXML
    void ingresarAction(ActionEvent event) {
        if (camposValidos()) {
            //Si selecciona la opcion de administrador se abrira la vista de administrador
            if (comboBoxRol.getSelectionModel().getSelectedItem().equals("Administrador") &&
                    aplicacion.verificarAdmin(txtUsername.getText(), txtPassword.getText())) {
                JOptionPane.showMessageDialog(null, "Bienvenido Admin");
                aplicacion.mostrarVentanaAdmin();

            } else {
                //Si selecciona la opcion de usuario, se abrira la vista de usuario
                if (comboBoxRol.getSelectionModel().getSelectedItem().equals("Usuario") &&
                        aplicacion.verificarUsuario(txtUsername.getText(), txtPassword.getText())) {
                    JOptionPane.showMessageDialog(null, "Bienvenido Usuario");
                    aplicacion.abrirTienda(txtUsername.getText());
                } else {
                    txtUsername.clear();
                    txtPassword.clear();
                    JOptionPane.showMessageDialog(null, "Usuario no encontrado o "
                            + "contrase�a incorrecta", "Error", 0);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Porfavor rellene los campos", "Error", 0);
        }
    }

    /**
     * Verifica si los campos del usuario son v�lidos.
     *
     * @return Verdadero si los campos del usuario son v�lidos, falso si no.
     */
    private boolean camposValidos() {
        if (txtUsername.getText() == null) {
            return false;
        }
        if (txtPassword.getText() == null) {
            return false;
        }
        if (comboBoxRol.getValue() == null) {
            return false;
        }
        return true;
    }

    /**
     * Establece la aplicaci�n en la vista de login.
     *
     * @param aplicacion La aplicaci�n a establecer.
     */
    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }

}
