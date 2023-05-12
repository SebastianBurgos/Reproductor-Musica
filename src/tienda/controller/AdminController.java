package tienda.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import tienda.Aplicacion;
import tienda.model.Artista;
import tienda.model.Cancion;
/**
 * Clase controladora de la vista de administrador
 * @author Sebastian Burgos Puentes
 */
public class AdminController {
	//Se declara la aplicacion
	Aplicacion aplicacion;

	//Se instancian las listas observables para las tablas
	private ObservableList<Artista> listaArtistasData= FXCollections.observableArrayList();
	private ObservableList<Cancion> listaCancionesData= FXCollections.observableArrayList();

	//Se instancian los filtros de busqueda
	FilteredList<Cancion> filteredCancionData;
	FilteredList<Artista> filteredArtistaData;

	//Se declaran los elementos de JavaFX
	@FXML
    private TableColumn<Cancion, String> colAlbum;

    @FXML
    private TableColumn<Cancion, String> colGenero;

    @FXML
    private TableColumn<Cancion, String> colArtista;

    @FXML
    private TableView<Cancion> tableCanciones;

    @FXML
    private TableColumn<Cancion, String> colNombre;

    @FXML
    private TableColumn<Cancion, String> colCodigo;

    @FXML
    private TableColumn<Artista, Integer> colCodigoArtista;

    @FXML
    private TableColumn<Artista, String> colNacionalidadArtista;

    @FXML
    private TableView<Artista> tableArtistas;

    @FXML
    private TableColumn<Artista, String> colNombreArtista;

    @FXML
    private TextField txtBusquedaCanciones;

    @FXML
    private TextField txtBusquedaArtistas;

    /**
     * Metodo inicializador
     * Se declaran los tipos de celdas y nombres de atributos que tendran cada una
     * Se encuentra tambien el filtro de busqueda con lambdas
     *
     */
	@FXML
    void initialize(){
    	this.colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
 		this.colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
 		this.colGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
 		this.colAlbum.setCellValueFactory(new PropertyValueFactory<>("album"));
 		this.colArtista.setCellValueFactory(new PropertyValueFactory<>("nombreArtista"));

 		// 1. Wrap the ObservableList in a FilteredList (initially display all data).
    	filteredCancionData = new FilteredList<>(listaCancionesData, p -> true);

    	// 2. Set the filter Predicate whenever the filter changes.
    	txtBusquedaCanciones.textProperty().addListener((observable, oldValue, newValue) -> {
    		filteredCancionData.setPredicate(cancion-> {
				// If filter text is empty, display all persons.
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();

				if (cancion.getNombre().toLowerCase().contains(lowerCaseFilter)) {
					return true; // Filter matches first name.
				} else if (cancion.getNombreArtista().toLowerCase().contains(lowerCaseFilter)) {
					return true; // Filter matches last name.
				} else if (cancion.getGenero().toLowerCase().contains(lowerCaseFilter)) {
					return true; // Filter matches last name.
				} else if (String.valueOf(cancion.getCodigo()).contains(lowerCaseFilter)) {
					return true; // Filter matches last name.
				}
				return false; // Does not match.
			});
		});


 		this.colNombreArtista.setCellValueFactory(new PropertyValueFactory<>("nombre"));
 		this.colNacionalidadArtista.setCellValueFactory(new PropertyValueFactory<>("nacionalidad"));
 		this.colCodigoArtista.setCellValueFactory(new PropertyValueFactory<>("codigo"));

 	// 1. Wrap the ObservableList in a FilteredList (initially display all data).
    	filteredArtistaData = new FilteredList<>(listaArtistasData, p -> true);

    	// 2. Set the filter Predicate whenever the filter changes.
    	txtBusquedaArtistas.textProperty().addListener((observable, oldValue, newValue) -> {
    		filteredArtistaData.setPredicate(artista-> {
				// If filter text is empty, display all persons.
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();

				if (artista.getNombre().toLowerCase().contains(lowerCaseFilter)) {
					return true; // Filter matches first name.
				} else if (artista.getNacionalidad().toLowerCase().contains(lowerCaseFilter)) {
					return true; // Filter matches last name.
				} else if (String.valueOf(artista.getCodigo()).contains(lowerCaseFilter)) {
					return true; // Filter matches last name.
				}
				return false; // Does not match.
			});
		});
    }

	/**
	 * Metodo de evento de boton Agregar artista
	 * @param event
	 */
    @FXML
    void agregarArtistaAction(ActionEvent event) {
    	aplicacion.mostrarAgregarArtista();
    }

    /**
     * Metodo de evento de boton Agregar cancion
     * @param event
     */
    @FXML
    void agregarCancionAction(ActionEvent event) {
    	aplicacion.mostrarAgregarCancion();
    }

    /**
     * Metodo de evento para salir al login
     * @param event
     */
    @FXML
    void atrasAction(ActionEvent event) {
    	aplicacion.mostrarLogin();
    }

    /**
     * Metood de evento para abrir interfaz de reporte
     * @param event
     */
    @FXML
    void generarReporte(ActionEvent event){
    	aplicacion.mostrarReporte();
    }

	/**
	 * Metodo que setea la aplicacion mandada por parametro en el controlador
	 * Se encuentran las preparaciones de tablas tambien y los filtros de
	 * busqueda segun parametros
	 * @param aplicacion
	 */
    public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;

		tableCanciones.getItems().clear();
		tableCanciones.setItems(getListaCanciones());

		//Para filtrar las canciones segun el parametro
		SortedList<Cancion> sortedCancionData = new SortedList<>(filteredCancionData);
		sortedCancionData.comparatorProperty().bind(tableCanciones.comparatorProperty());
		tableCanciones.setItems(sortedCancionData);

		tableArtistas.getItems().clear();
		tableArtistas.setItems(getListaArtistas());

		//Para filtrar los artistas segun el parametro
		SortedList<Artista> sortedArtistaData = new SortedList<>(filteredArtistaData);
		sortedArtistaData.comparatorProperty().bind(tableArtistas.comparatorProperty());
		tableArtistas.setItems(sortedArtistaData);
	}

    /**
     * Metodo para obtener la lista de artistas
     * @return lista observable de artistas
     */
    private ObservableList<Artista> getListaArtistas() {
    	listaArtistasData.addAll(aplicacion.obtenerArtistas());
 		return listaArtistasData;
	}

    /**
     * Metodo para obtener la lista de canciones
     * @return lista observable de canciones
     */
	private ObservableList<Cancion> getListaCanciones() {
		listaCancionesData.addAll(aplicacion.obtenerCanciones());
		return listaCancionesData;
	}

}
