package tienda;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import tienda.controller.AdminController;
import tienda.controller.AgregarArtistaController;
import tienda.controller.AgregarCancionController;
import tienda.controller.BusquedaAvanzadaController;
import tienda.controller.LoginController;
import tienda.controller.RegistroController;
import tienda.controller.ReporteController;
import tienda.controller.TiendaController;
import tienda.model.Artista;
import tienda.model.Cancion;
import tienda.model.Tienda;
import tienda.persistencia.Persistencia;
import tienda.utilities.Archivos;

/**
 * Clase principal Aplicacion que va a comunicar todo el sistema de model con el sistema controller
 * y abrir las ventanas
 * @author Sebastian Burgos Puentes
 */
public class Aplicacion extends Application{
	private Stage primaryStage;

	Tienda tienda = Persistencia.cargarRecursoXML();
//	Tienda tienda = new Tienda();

	@Override
	public void start(Stage primaryStage) throws IOException {

//		tienda.quemarDatos();
//		Persistencia.guardarRecursoXML(tienda);

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Tienda de musica");
		this.primaryStage.getIcons().add(new Image("file:images/icon.png"));
		mostrarLogin();
	}

	/**
	 * Lee el archivo de artistas y lo agrega a la aplicación.
	 *
	 * @param ruta la ruta del archivo a leer.
	 */
	public void leerArchivoArtistas(String ruta) {
	    Archivos.agregarArtistasFromArchivo(this, ruta);
	}

	/**
	 * Método principal del programa que lanza la aplicación.
	 *
	 * @param args los argumentos de línea de comandos.
	 */
	public static void main(String[] args) {
	    launch(args);
	}

	/**
	 * Muestra la ventana de inicio de sesión.
	 */
	public void mostrarLogin() {
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
	        e.printStackTrace();
	    }
	}

	/**
	 * Abre la tienda para el usuario especificado.
	 *
	 * @param user el usuario que abre la tienda.
	 */
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
	        e.printStackTrace();
	    }
	}

	/**
	 * Abre la ventana de registro.
	 */
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
			e.printStackTrace();
		}
	}

	/**
	 * Muestra la ventana de administrador.
	 */
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
			e.printStackTrace();
		}
	}

	/**
	 * Registra un nuevo usuario en la tienda.
	 * @param user el nombre de usuario.
	 * @param psw la contraseña.
	 * @param correo el correo electrónico del usuario.
	 */
	public boolean registrar(String user, String psw, String correo) {
		return tienda.crearUsuario(user, psw, correo);
	}

	/**
	 * Verifica si un usuario existe y si la contraseña es correcta.
	 * @param user el nombre de usuario.
	 * @param pssw la contraseña.
	 * @return true si el usuario existe y la contraseña es correcta, false en caso contrario.
	 */
	public boolean verificarUsuario(String user, String pssw) {
		if (tienda.verificarUsuario(user, pssw)){
			return true;
		}
		return false;
	}

	/**
	 * Muestra la vista para agregar una canción.
	 */
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

	/**
	 * Muestra la vista para agregar un artista.
	 */
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

	/**
	 * Muestra el reporte de populares de la aplicación en una ventana modal.
	 */
	public void mostrarReporte() {
		try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("view/Reporte.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Reporte");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            ReporteController reporteController = loader.getController();
            reporteController.setAplicacion(this);

            // Set the dialog icon.
            dialogStage.getIcons().add(new Image("file:images/icon.png"));

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	/**
	 * Muestra la vista de busqeuda avanzada
	 */
	public void abrirBusquedaAvanzada() {
		try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("view/BusquedaAvanzada.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Busqueda Avanzada");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            BusquedaAvanzadaController busquedaController = loader.getController();
            busquedaController.setAplicacion(this);

            // Set the dialog icon.
            dialogStage.getIcons().add(new Image("file:images/icon.png"));

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	/**
	 * Metodo que verifica el acceso de un admin a la tienda
	 * @param user
	 * @param pssw
	 * @return
	 */
	public boolean verificarAdmin(String user, String pssw) {
		return tienda.verificarAdmin(user, pssw);
	}

	/**
	 * Obtiene la lista de canciones de un usuario específico.
	 * @param usuarioIngresado Nombre de usuario del usuario cuya lista de canciones se desea obtener.
	 * @return Lista de canciones del usuario.
	 */
	public ArrayList<Cancion> obtenerListaUser(String usuarioIngresado) {
	    return tienda.getCancionesUser(usuarioIngresado);
	}

	/**
	 * Obtiene la lista completa de canciones de la tienda.
	 * @return Lista de todas las canciones en la tienda.
	 */
	public ArrayList<Cancion> obtenerCanciones() {
	    return tienda.getListaCanciones();
	}

	/**
	 * Obtiene la lista de artistas de la tienda.
	 * @return Lista de todos los artistas en la tienda.
	 */
	public ArrayList<Artista> obtenerArtistas() {
	    return tienda.getArtistaView();
	}

	/**
	 * Agrega una canción a la lista de canciones de un usuario específico.
	 * @param cancionSeleccionada Canción a agregar a la lista del usuario.
	 * @param usuarioIngresado Nombre de usuario del usuario que agregará la canción.
	 */
	public void agregarCancionListaUser(Cancion cancionSeleccionada, String usuarioIngresado) {
	    tienda.agregarCancionListaUser(cancionSeleccionada, usuarioIngresado);
	}

	/**
	 * Elimina una canción de la lista de canciones de un usuario específico.
	 * @param cancionSeleccionadaFavoritas Canción a eliminar de la lista del usuario.
	 * @param usuarioIngresado Nombre de usuario del usuario que eliminará la canción.
	 */
	public void eliminarCancionUser(Cancion cancionSeleccionadaFavoritas, String usuarioIngresado) {
	    tienda.eliminarCancionListaUser(cancionSeleccionadaFavoritas, usuarioIngresado);
	}

	/**
	 * Registra una nueva canción en la tienda.
	 * @param nombre Nombre de la nueva canción.
	 * @param artista Nombre del artista de la nueva canción.
	 * @param genero Género de la nueva canción.
	 * @param year Año de lanzamiento de la nueva canción.
	 * @param album Nombre del álbum de la nueva canción.
	 * @param duracion Duración de la nueva canción en formato mm:ss.
	 * @param url URL del archivo de audio de la nueva canción.
	 */
	public void registrarCancion(String nombre, String artista, String genero, String year, String album, String duracion, String url) {
	    tienda.registrarCancionTienda(nombre, artista, genero, year, album, duracion, url);
	}

	/**
	 * Registra un nuevo artista en la tienda.
	 * @param nombre Nombre del nuevo artista.
	 * @param nacionalidad Nacionalidad del nuevo artista.
	 * @param vivo Booleano que indica si el artista está vivo o no.
	 */
	public void registrarArtista(String nombre, String nacionalidad, boolean vivo) {
	    tienda.registrarArtistaTienda(nombre, nacionalidad, vivo);
	}

	/**
	 * Obtiene el género más popular en la tienda.
	 * @return Nombre del género más popular.
	 */
	public String obtenerGeneroMasPopular() {
	    return tienda.obtenerGeneroMasPopular();
	}

	/**
	 * Obtiene el artista más popular en la tienda.
	 * @return Nombre del artista más popular.
	 */
	public String obtenerArtistaMasPopular() {
	    return tienda.obtenerArtistaMasPopular();
	}

	/**
	 * Busca canciones en la tienda que coincidan con el nombre del artista
	 */
	public ArrayList<Cancion> buscarCancionesPorNombreArtista(String nombre) {
		return tienda.buscarCancionesPorNombreArtista(nombre);
	}

	/**
	 * Retorna el primaryStage corriendo de la aplicacion
	 * @return
	 */
	public Window getPrimaryStage() {
		return primaryStage;
	}

}
