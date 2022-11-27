package tienda;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tienda.controller.AdminController;
import tienda.controller.AgregarArtistaController;
import tienda.controller.AgregarCancionController;
import tienda.controller.LoginController;
import tienda.controller.RegistroController;
import tienda.controller.TiendaController;
import tienda.model.Artista;
import tienda.model.Cancion;
import tienda.model.Tienda;

public class Aplicacion extends Application{
	private Stage primaryStage;

	Tienda tienda = new Tienda();

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Tienda de musica");
		mostrarVentanaPrincipal();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void mostrarVentanaPrincipal() {

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("view/VentanaLogin.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			LoginController loginController = loader.getController();
			loginController.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void abrirTienda(String user) {

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("view/Tienda.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			TiendaController tiendaController = loader.getController();
			tiendaController.setAplicacion(this, user);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void abrirRegistro() {

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("view/Registro.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			RegistroController registroController = loader.getController();
			registroController.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void mostrarVentanaAdmin() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("view/Admin.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			AdminController adminController = loader.getController();
			adminController.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void registrar(String user, String psw, String correo) {
		tienda.crearUsuario(user, psw, correo);
	}

	public boolean verificarUsuario(String user, String pssw) {
		if (tienda.verificarUsuario(user, pssw)){
			return true;
		}
		return false;
	}

	public void mostrarAgregarCancion() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("view/AgregarCancion.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			AgregarCancionController agregarCancionController = loader.getController();
			agregarCancionController.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public void mostrarAgregarArtista() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("view/AgregarArtista.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			AgregarArtistaController agregarArtistaController = loader.getController();
			agregarArtistaController.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Cancion> obtenerListaUser(String usuarioIngresado) {
		return tienda.getCancionesUser(usuarioIngresado);
	}

	public ArrayList<Cancion> obtenerCanciones() {
		return tienda.getListaCanciones();
	}

	public ArrayList<Artista> obtenerArtistas() {
		return tienda.getArtistaView();
	}

	public void agregarCancionListaUser(Cancion cancionSeleccionada, String usuarioIngresado) {
		tienda.agregarCancionListaUser(cancionSeleccionada, usuarioIngresado);

	}

	public void eliminarCancionUser(Cancion cancionSeleccionadaFavoritas, String usuarioIngresado) {
		tienda.eliminarCancionListaUser(cancionSeleccionadaFavoritas, usuarioIngresado);
	}

	public void registrarCancion(String nombre, String artista, String genero, String year, String album, String duracion, String url) {
		tienda.registrarCancionTienda(nombre, artista, genero, year, album, duracion, url);
	}

	public void registrarArtista(String nombre, String nacionalidad, boolean b) {
		tienda.registrarArtistaTienda(nombre, nacionalidad, b);
	}

}
