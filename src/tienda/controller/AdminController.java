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

public class AdminController {
	Aplicacion aplicacion;
	private ObservableList<Artista> listaArtistasData= FXCollections.observableArrayList();
	private ObservableList<Cancion> listaCancionesData= FXCollections.observableArrayList();

	FilteredList<Cancion> filteredCancionData;
	FilteredList<Artista> filteredArtistaData;

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

    private ObservableList<Artista> getListaArtistas() {
    	listaArtistasData.addAll(aplicacion.obtenerArtistas());
 		return listaArtistasData;
	}

	private ObservableList<Cancion> getListaCanciones() {
		listaCancionesData.addAll(aplicacion.obtenerCanciones());
		return listaCancionesData;
	}

    @FXML
    void agregarArtistaAction(ActionEvent event) {
    	aplicacion.mostrarAgregarArtista();
    }

    @FXML
    void agregarCancionAction(ActionEvent event) {
    	aplicacion.mostrarAgregarCancion();
    }

    @FXML
    void atrasAction(ActionEvent event) {
    	aplicacion.mostrarVentanaPrincipal();
    }

}
