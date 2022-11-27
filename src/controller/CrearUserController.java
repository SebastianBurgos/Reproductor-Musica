package controller;

import javax.swing.JOptionPane;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CrearUserController {


	Main aplicacion;


	@FXML
    private TextField txtConfirClaveCrear;

    @FXML
    private TextField txtApellCrear;

    @FXML
    private TextField txtClaveCrear;

    @FXML
    private TextField txtNomCrear;

    @FXML
    private TextField txtEmailCrear;

	    public void setAplicacion(Main aplicacion) {
			this.aplicacion = aplicacion;
		}


	    @FXML
	    void CrearUsuario(ActionEvent event) {

	    	String nombre=txtNomCrear.getText();
	    	String apellido=txtApellCrear.getText();
	    	String clave=txtClaveCrear.getText();
	    	String claveConf=txtConfirClaveCrear.getText();
	    	String correo = txtEmailCrear.getText();
	    	if(clave.equals(claveConf)){
	    	aplicacion.crearUsuario(nombre, apellido, clave, correo);
	    	}else{
	    		JOptionPane.showMessageDialog(null, "las claves no coinciden");
	    	}
	    }

	    @FXML
	    void Atras(ActionEvent event) {

	    	aplicacion.devolverLogin();

	    }




}
