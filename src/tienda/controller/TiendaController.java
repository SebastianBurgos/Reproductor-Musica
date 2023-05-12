package tienda.controller;
import java.net.URISyntaxException;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import tienda.Aplicacion;
import tienda.model.Cancion;

/**
 * Clase controladora de la vista principal de la tienda (Vista usuario)
 * @author Sebastian Burgos Puentes
 */
public class TiendaController {
	Aplicacion aplicacion;

	private ObservableList<Cancion>listaCancionesData = FXCollections.observableArrayList();
	private ObservableList<Cancion>listaFavoritasData = FXCollections.observableArrayList();

	Cancion cancionSeleccionada;
	Cancion cancionSeleccionadaFavoritas;

	Cancion ultimaCancionAgregada;
	Cancion ultimaCancionEliminada;
	int ultimaAccion = -1;

	FilteredList<Cancion> filteredCancionData;
	String usuarioIngresado;

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnReproducir;

    @FXML
    private Button btnEliminarCancion;

    @FXML
    private Button btnAgregarCancion;

    @FXML
    private TextField txtFiltroCancion;

    @FXML
    private TableView<Cancion> tableCanciones;

    @FXML
    private TableColumn<String, Cancion> colCancionGenero;

    @FXML
    private TableColumn<String, Cancion> colCancionDuracion;

    @FXML
    private TableColumn<String, Cancion> colCancionNombre;

    @FXML
    private TableColumn<String, Cancion> colCancionAlbum;

    @FXML
    private TableColumn<String, Cancion> colCancionArtista;

    @FXML
    private TableColumn<String, Cancion> colCancionYear;

    @FXML
    private TableView<Cancion> tableFavoritos;

    @FXML
    private TableColumn<String, Cancion> colFavArtista;

    @FXML
    private TableColumn<String, Cancion> colFavNombre;

    @FXML
    private TableColumn<String, Cancion> colFavDuracion;

    @FXML
    private TableColumn<String, Cancion> colFavGenero;

    @FXML
    private TableColumn<String, Cancion> colFavAlbum;

    @FXML
    private TableColumn<String, Cancion> colFavYear;

    @FXML
    private WebView web;

    private WebEngine engine;

    /**
     * Agrega una canción a la lista de favoritas del usuario ingresado.
     * @param event Evento de acción.
     */
    @FXML
    void agregarCancionAction(ActionEvent event) {
    	if (cancionSeleccionada!=null) {
    		if (!listaFavoritasData.contains(cancionSeleccionada)) {
    			ultimaCancionAgregada = cancionSeleccionada;
        		ultimaAccion = 1;
    			aplicacion.agregarCancionListaUser(cancionSeleccionada, usuarioIngresado);
        		actualizarTablaMiLista();
    		}else{
    			JOptionPane.showMessageDialog(null, "La canción ya esta agregada en favoritas");
    		}
    	}else{
    		JOptionPane.showMessageDialog(null, "Seleccione primero la cancion");
    	}
    }

    /**
     * Elimina una canción de la lista de favoritas del usuario ingresado.
     * @param event Evento de acción.
     */
    @FXML
    void EliminarCancionAction(ActionEvent event) {
    	if (cancionSeleccionadaFavoritas!=null) {
    		ultimaCancionEliminada = cancionSeleccionadaFavoritas;
    		ultimaAccion = 0;
    		aplicacion.eliminarCancionUser(cancionSeleccionadaFavoritas, usuarioIngresado);
    		actualizarTablaMiLista();
    	}else{
    		JOptionPane.showMessageDialog(null, "Seleccione primero la cancion");
    	}
    }

    /**
     * Abre la URL de reproducción de la canción seleccionada.
     * @param event Evento de acción.
     */
    @FXML
    void btnReproducir(ActionEvent event) {
    	 try {
    		abrirURL();
    	} catch (URISyntaxException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }

    /**
     * Vuelve a la pantalla de inicio de sesión.
     * @param event Evento de acción.
     */
    @FXML
    void atrasAction(ActionEvent event) {
    	aplicacion.mostrarLogin();
    }

    /**
     * Método que permite deshacer la última acción realizada por el usuario.
     * Si la última acción fue eliminar una canción de la lista, entonces se
     * volverá a agregar la canción eliminada. Si la última acción fue agregar
     * una canción a la lista, entonces se eliminará la canción agregada.
     * Si no se ha realizado ninguna acción anteriormente, se mostrará un
     * mensaje de error.
     *
     * @param event El evento de acción que desencadena la llamada a este método.
     */
    @FXML
    void deshacer(ActionEvent event) {
        if (ultimaAccion != -1) {
            if (ultimaAccion == 0) { //elimino
                ultimaAccion = 1; //cambia ultima accion
                ultimaCancionAgregada = ultimaCancionEliminada;
                //Se vuelve a agregar la ultima cancion que fue eliminada
                aplicacion.agregarCancionListaUser(ultimaCancionEliminada, usuarioIngresado);
                actualizarTablaMiLista();
                JOptionPane.showMessageDialog(null, "Ha vuelto a agregar la cancion que elimino");
            } else {
                if (ultimaAccion == 1) { //agrego
                    ultimaAccion = 0; //cambia ultima accion
                    ultimaCancionEliminada = ultimaCancionAgregada;
                    //Se elimina la ultima cancion agregada
                    aplicacion.eliminarCancionUser(ultimaCancionAgregada, usuarioIngresado);
                    actualizarTablaMiLista();
                    JOptionPane.showMessageDialog(null, "Ha eliminado la cancion que agrego");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Aun no ha realizado ninguna acción");
        }
    }

    /**
     * Método que abre la ventana de búsqueda avanzada en la aplicación.
     *
     * @param event El evento de acción que desencadena la llamada a este método.
     */
    @FXML
    void busquedaAvanzada(ActionEvent event){
        aplicacion.abrirBusquedaAvanzada();
    }

    /**
     * Método que se ejecuta automáticamente al cargar la ventana,
     * se encarga de inicializar las columnas de la tabla de canciones,
     * agregar un listener para detectar cuando una canción es seleccionada,
     * inicializar el filtro de búsqueda de canciones, y
     * inicializar las columnas de la tabla de canciones favoritas y
     * agregar un listener para detectar cuando una canción favorita es seleccionada.
     */
    @FXML
    void initialize(){
        //Inicializar las columnas de la tabla de canciones
        this.colCancionGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        this.colCancionDuracion.setCellValueFactory(new PropertyValueFactory<>("duracion"));
        this.colCancionNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.colCancionArtista.setCellValueFactory(new PropertyValueFactory<>("nombreArtista"));
        this.colCancionAlbum.setCellValueFactory(new PropertyValueFactory<>("album"));
        this.colCancionYear.setCellValueFactory(new PropertyValueFactory<>("year"));

        //Agregar un listener para detectar cuando una canción es seleccionada
        tableCanciones.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection) -> {
            cancionSeleccionada = newSelection;
        });

        //Inicializar el filtro de búsqueda de canciones
        filteredCancionData = new FilteredList<>(listaCancionesData, p -> true);

        //Set the filter Predicate whenever the filter changes.
        txtFiltroCancion.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredCancionData.setPredicate(cancion-> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (cancion.getNombre().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches song name.
                } else if (cancion.getNombreArtista().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches artist name.
                } else if (cancion.getGenero().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches genre.
                }else if (lowerCaseFilter.contains(cancion.getNombre().toLowerCase()) ||
                        lowerCaseFilter.contains(cancion.getNombreArtista().toLowerCase())) {
                    return true; // Filter matches song or artist name.
                }
                return false; // Does not match.
            });
        });

        //Inicializar las columnas de la tabla de canciones favoritas
        this.colFavGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        this.colFavDuracion.setCellValueFactory(new PropertyValueFactory<>("duracion"));
        this.colFavNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.colFavArtista.setCellValueFactory(new PropertyValueFactory<>("nombreArtista"));
        this.colFavAlbum.setCellValueFactory(new PropertyValueFactory<>("album"));
        this.colFavYear.setCellValueFactory(new PropertyValueFactory<>("year"));

        //Agregar un listener para detectar cuando una canción favorita es seleccionada.
        tableFavoritos.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection) -> {
            cancionSeleccionadaFavoritas = newSelection;
        });
    }

    /**
     * Sets the application and user information and initializes the table views.
     *
     * @param aplicacion the application instance to use
     * @param user the user currently logged in
     */
    public void setAplicacion(Aplicacion aplicacion, String user) {
        this.aplicacion = aplicacion;
        this.usuarioIngresado = user;

        // Clear and initialize all songs in the table view for all songs
        tableCanciones.getItems().clear();
        tableCanciones.setItems(getListaCanciones());

        // Filter the songs according to the user's parameter
        SortedList<Cancion> sortedCancionData = new SortedList<>(filteredCancionData);
        sortedCancionData.comparatorProperty().bind(tableCanciones.comparatorProperty());
        tableCanciones.setItems(sortedCancionData);

        // Clear and initialize all songs in the table view for the user's favorite songs
        tableFavoritos.getItems().clear();
        tableFavoritos.setItems(getListaFavoritos(usuarioIngresado));
        this.aplicacion = aplicacion;
    }

    /**
     * Retrieves the list of favorite songs for the specified user.
     *
     * @param usuarioIngresado the user to retrieve the favorite songs for
     * @return an observable list of the user's favorite songs
     */
    private ObservableList<Cancion> getListaFavoritos(String usuarioIngresado) {
        listaFavoritasData.addAll(aplicacion.obtenerListaUser(usuarioIngresado));
        return listaFavoritasData;
    }

    /**
     * Retrieves the list of all songs.
     *
     * @return an observable list of all songs
     */
    private ObservableList<Cancion> getListaCanciones() {
        listaCancionesData.addAll(aplicacion.obtenerCanciones());
        return listaCancionesData;
    }

    /**
     * Updates the table view for the user's favorite songs.
     */
    private void actualizarTablaMiLista() {
        tableFavoritos.getItems().clear();
        tableFavoritos.setItems(getListaFavoritos(usuarioIngresado));
        tableCanciones.refresh();
    }

    /**
     * Opens the URL of the currently selected song in a web view.
     *
     * @throws URISyntaxException if the URL is not valid
     */
    private void abrirURL() throws URISyntaxException {
        web.setZoom(1.2);
        try {
            if (cancionSeleccionada != null) {
                engine = web.getEngine();
                engine.load(cancionSeleccionada.getUrl());
            }
            if (cancionSeleccionadaFavoritas != null) {
                engine = web.getEngine();
                engine.load(cancionSeleccionadaFavoritas.getUrl());
            }
            cancionSeleccionada = null;
            cancionSeleccionadaFavoritas = null;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo abrir el enlace, seleccione uno");
        }
    }


}
