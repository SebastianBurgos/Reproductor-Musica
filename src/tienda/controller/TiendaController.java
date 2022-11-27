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

public class TiendaController {
	Aplicacion aplicacion;

	private ObservableList<Cancion>listaCancionesData = FXCollections.observableArrayList();
	private ObservableList<Cancion>listaFavoritasData = FXCollections.observableArrayList();

	Cancion cancionSeleccionada;
	Cancion cancionSeleccionadaFavoritas;

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

    @FXML
    void agregarCancionAction(ActionEvent event) {
    	if (cancionSeleccionada!=null) {
    		aplicacion.agregarCancionListaUser(cancionSeleccionada, usuarioIngresado);
    		actualizarTablaMiLista();
		}else{
			JOptionPane.showMessageDialog(null, "Seleccione primero la cancion");
		}
    }


	@FXML
    void btnReproducir(ActionEvent event) {
		 try {
			abrirURL();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void atrasAction(ActionEvent event) {
    	aplicacion.mostrarVentanaPrincipal();
    }

    @FXML
    void EliminarCancionAction(ActionEvent event) {
		if (cancionSeleccionadaFavoritas!=null) {
    		aplicacion.eliminarCancionUser(cancionSeleccionadaFavoritas, usuarioIngresado);
    		actualizarTablaMiLista();
		}else{
			JOptionPane.showMessageDialog(null, "Seleccione primero la cancion imbecil");
		}
    }

    @FXML
    void initialize(){
    	this.colCancionGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
    	this.colCancionDuracion.setCellValueFactory(new PropertyValueFactory<>("duracion"));
    	this.colCancionNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    	this.colCancionArtista.setCellValueFactory(new PropertyValueFactory<>("nombreArtista"));
    	this.colCancionAlbum.setCellValueFactory(new PropertyValueFactory<>("album"));
    	this.colCancionYear.setCellValueFactory(new PropertyValueFactory<>("year"));

    	tableCanciones.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection) -> {
    		cancionSeleccionada = newSelection;
		});

    	// 1. Wrap the ObservableList in a FilteredList (initially display all data).
    	filteredCancionData = new FilteredList<>(listaCancionesData, p -> true);

    	// 2. Set the filter Predicate whenever the filter changes.
    	txtFiltroCancion.textProperty().addListener((observable, oldValue, newValue) -> {
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
				}
				return false; // Does not match.
			});
		});

    	this.colFavGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
    	this.colFavDuracion.setCellValueFactory(new PropertyValueFactory<>("duracion"));
    	this.colFavNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    	this.colFavArtista.setCellValueFactory(new PropertyValueFactory<>("nombreArtista"));
    	this.colFavAlbum.setCellValueFactory(new PropertyValueFactory<>("album"));
    	this.colFavYear.setCellValueFactory(new PropertyValueFactory<>("year"));

    	tableFavoritos.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection) -> {
    		cancionSeleccionadaFavoritas = newSelection;
		});
    }

	public void setAplicacion(Aplicacion aplicacion, String user) {
		this.aplicacion = aplicacion;
		this.usuarioIngresado = user;

		//Se limpia y se inicializan todas las canciones en la tabla de todas las canciones
		tableCanciones.getItems().clear();
		tableCanciones.setItems(getListaCanciones());

		//Para filtrar las canciones segun el parametro
		SortedList<Cancion> sortedCancionData = new SortedList<>(filteredCancionData);
		sortedCancionData.comparatorProperty().bind(tableCanciones.comparatorProperty());
		tableCanciones.setItems(sortedCancionData);

		//Se limpia y se inicializan todas las canciones pero en la tabla de MIS CANCIONES
		tableFavoritos.getItems().clear();
		tableFavoritos.setItems(getListaFavoritos(usuarioIngresado));
		this.aplicacion = aplicacion;
	}

    private ObservableList<Cancion> getListaFavoritos(String usuarioIngresado) {
    	listaFavoritasData.addAll(aplicacion.obtenerListaUser(usuarioIngresado));
		return listaFavoritasData;
	}

	private ObservableList<Cancion> getListaCanciones() {
		listaCancionesData.addAll(aplicacion.obtenerCanciones());
		return listaCancionesData;
	}

    private void actualizarTablaMiLista() {
    	tableFavoritos.getItems().clear();
		tableFavoritos.setItems(getListaFavoritos(usuarioIngresado));
		tableCanciones.refresh();
	}

	private void abrirURL() throws URISyntaxException {
		web.setZoom(0.7);
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
