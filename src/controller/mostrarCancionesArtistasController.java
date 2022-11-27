package controller;

import java.util.ArrayList;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Cancion;

public class mostrarCancionesArtistasController {

	Main aplicacion;
	ObservableList<Cancion> listaCancionesData=FXCollections.observableArrayList();

	String autor;
	ArrayList<Cancion> lista = new ArrayList<>();


	@FXML
    private TableView<Cancion> tablaCanciones;

    @FXML
    private TextField txtArtistaBuscar;

    @FXML
    private TableColumn<String, Cancion> columnNomCancion;

    @FXML
    private TableColumn<String, Cancion> columnAlbum;


    public void setAplicacion(Main aplicacion) {
		this.aplicacion = aplicacion;
		tablaCanciones.getItems().clear();
		tablaCanciones.setItems(getListaArtistas());

	}

    private ObservableList<Cancion> getListaArtistas() {
		// TODO Auto-generated method stub
    	listaCancionesData.addAll(lista);
		return listaCancionesData;
	}

    @FXML
    void initialize(){
    	this.columnAlbum.setCellValueFactory(new PropertyValueFactory<>("album"));
    	this.columnNomCancion.setCellValueFactory(new PropertyValueFactory<>("nombre"));

    	}

	@FXML
    void buscar(ActionEvent event) {

		autor = txtArtistaBuscar.getText();
		lista= aplicacion.buscarCanArt(autor);
		System.out.println(""+lista);
		tablaCanciones.getItems().clear();
		listaCancionesData.addAll(lista);
		tablaCanciones.setItems(listaCancionesData);
		tablaCanciones.refresh();
    }


}
