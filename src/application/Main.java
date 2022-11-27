package application;


import java.util.ArrayList;
import javax.swing.JOptionPane;

import archivos.Persistencia;
import controller.CancionVIewController;
import controller.CrearUserController;
import controller.LoginController;
import controller.mostrarCancionesArtistasController;
import controller.ventanaAdminController;
import controller.ventanaCrearArtista;
import controller.ventanaUsuarioController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Artista;
import model.Cancion;
import model.Reproductor;


public class Main extends Application {

	private Stage primaryStage;
	//private Reproductor rep = new Reproductor();
	private Reproductor rep = Persistencia.cargarRecursoXML();


	public static void main(String[] args) {
		launch(args);
	}


	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Sputafy");
		this.primaryStage.setResizable(false);

		// SOLO SE USO LA PRIMERA VEZ PARA GUARDAR LOS DATOS Y YA LUEGO SOLO SE GARDA DESDE EL RECURSO
		// XML
		//Persistencia.guardarRecursoXML(rep);
		//mostrarVentanaBienvenida();
		mostrarVentanaUsuario("pablito@qlo.lor");

	}

	public void mostrarVentanaBienvenida() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/LoginView.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			LoginController loginController = loader.getController();
			loginController.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void mostrarVentanaCrearUsuario(){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/CrearUserView.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			CrearUserController crearUserController = loader.getController();
			crearUserController.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	// OJO ACA EL METODO RECIBE EL CORREO DEL USUARIO QUE SE LOGUEO PARA LUEGO IDENTIFICAR LA
	// SESION Y AL INSTANCIAR EL CONTROLADOR MANDARLE ESE CORREO
	public void mostrarVentanaUsuario(String usuario){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/UsuarioView.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			ventanaUsuarioController ventanaUsuario = loader.getController();
//		    OJO ACA LE SETEO EL CORREO DEL USUARIO QUE INGRESA AL CONTROLADOR QUE ESTE USANDO ESA
			//    SESION EN ESE INSTANTE, CON ESTO LUEGO PODR� IDENTIFICAR CUAL USUARIO EST� USANDO LA SESION
			//    Y SE PODR� AGREGAR LAS CANCIONES A ESE USUARIO ESPECIFICO
			ventanaUsuario.setCorreoUserIngresado(usuario);

			ventanaUsuario.setAplicacion(this);




			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void mostrarVentanaAdmin(){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/adminisView.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			ventanaAdminController ventanaAdmin = loader.getController();
			ventanaAdmin.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void mostrarVentanaCrearArtista(){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/CrearArtistaView.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			ventanaCrearArtista ventanaCrearArt = loader.getController();
			ventanaCrearArt.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void mostrarVentanaCancion(){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/CancionView.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			 CancionVIewController ventanaCancion = loader.getController();
			ventanaCancion.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void mostrarVentanaCancionDeArtistas(){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/cancArtView.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			 mostrarCancionesArtistasController ventanaCancionArt = loader.getController();
			 ventanaCancionArt.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	public void crearUsuario(String nombre, String apellido, String clave, String correo) {

				boolean verify = rep.crearUser(nombre, apellido, clave, correo);


			if(verify){
				mostrarVentanaBienvenida();

			}else{
				JOptionPane.showMessageDialog(null, "el usuario no fue creado");
			}

	}

	public void ingresarUsuario(String usuario, String contrasena) {
		// TODO Auto-generated method stub
		boolean verify = rep.ingresarUser(usuario, contrasena);

		if(verify){
			//        OJO ACA LE MANDO EL CORREO DEL USUARIO QUE SE EST� LOGEANDO AL METODO
			//        DE ABRIR LA VENTANA DE USUARIO, ESE METODO ESTA EN EL MAIN Y RECIBE EL CORREO DEL USUARIO
			mostrarVentanaUsuario(usuario);
		}else{
			JOptionPane.showMessageDialog(null, "los datos no coinciden");
		}
	}

	public void ingresarAdmin(String usuario, String contrasena) {
		// TODO Auto-generated method stub
		boolean verify = rep.ingresarAdmin(usuario, contrasena);

		if(verify){
			mostrarVentanaAdmin();
		}else{
			JOptionPane.showMessageDialog(null, "los datos no coinciden");
		}

	}

	public void crearArt() {
		// TODO Auto-generated method stub
		mostrarVentanaCrearArtista();

	}

	public void crearArtistaFull(String nombre, String nacionalidad, String codigo, String genero, boolean duo) {
		// TODO Auto-generated method stub
		boolean verify = rep.crearArtista(nombre, nacionalidad, codigo, genero, duo);

		if(verify){
			mostrarVentanaAdmin();
		}else{
			JOptionPane.showMessageDialog(null, "los datos no coinciden");
		}
	}



	public void subirCancion() {
		mostrarVentanaCancion();
	}

	public void devolverInicio() {
		// TODO Auto-generated method stub
		mostrarVentanaAdmin();
	}

	public void devolverLogin() {
		// TODO Auto-generated method stub
		mostrarVentanaBienvenida();
	}

	public String generarCodigo() {
		// TODO Auto-generated method stub
		String codi = rep.generarCod();
		return codi;

	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void crearCancion(String duracion, String nombre, String album, String anio, String uRL, String artista,
			String codigo, String genero) {

		boolean verify = rep.crearCanc(duracion, nombre, album, anio, uRL, artista, codigo, genero);

		if(verify){
			mostrarVentanaAdmin();
		}else{
			JOptionPane.showMessageDialog(null, "los datos no son correctos");
		}

	}



	public ArrayList<Artista> obtenerArtista(){
		return rep.retornarArray();
	}


	public ArrayList<Cancion> obtenerCanciones() {
		// TODO Auto-generated method stub
		return rep.listaCancionesArray();
	}

	public ArrayList<Cancion> obtenerListaUser(String correoUserIngresado) {
		return rep.obtenerListaUser(correoUserIngresado);
	}

	public ArrayList<Cancion> buscarCanArt(String autor) {
		// TODO Auto-generated method stub
		ArrayList<Cancion>lista = new ArrayList<>();
		 lista = rep.buscarCArt(autor);
		 return lista;
	}

	public void mostrarVentanaCancArti() {
		// TODO Auto-generated method stub
		mostrarVentanaCancionDeArtistas();
	}

	public void agregarCancionListaUser(String correoUserIngresado, Cancion cancionSeleccionadaTodas) {
		rep.agregarCancionListaUser(correoUserIngresado, cancionSeleccionadaTodas);
	}

	public void eliminarCancionUser(String correoUserIngresado, Cancion cancionSeleccionadaMias) {
		rep.eliminarCancionListaUser(correoUserIngresado, cancionSeleccionadaMias);
	}


}
