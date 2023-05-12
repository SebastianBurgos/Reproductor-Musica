package tienda.controller;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import tienda.Aplicacion;
import tienda.model.Artista;

/**
 * Clase controladora de la vista para agregar canciones
 * @author Sebastian Burgos Puentes
 */
public class AgregarCancionController {
	Aplicacion aplicacion;
	Artista artistaSeleccionado;
	private ObservableList<Artista> listaArtistasData= FXCollections.observableArrayList();

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnGuardar;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtGenero;

    @FXML
    private TextField txtLink;

    @FXML
    private TextField txtDuracion;

    @FXML
    private TextField txtYear;

    @FXML
    private TextField txtAlbum;

    @FXML
    private TableView<Artista> tableArtistas;

    @FXML
    private TableColumn<Artista, Integer> colCodigoArtista;

    @FXML
    private TableColumn<Artista, String> colNombreArtista;

    @FXML
    private TableColumn<Artista, String> colNacionalidadArtista;

    /**
     * Metodo de evento de boton para volver a la ventana de admin
     * @param event
     */
    @FXML
    void atrasAction(ActionEvent event) {
    	aplicacion.mostrarVentanaAdmin();
    }

    /**
     * Metodo para registrar la cancion con los datos ingresados en los camposd e texto
     * @param event
     */
    @FXML
    void registrarCancionAction(ActionEvent event) {
    	if (artistaSeleccionado != null) {
    		if (datosValidos() == true) {
    			aplicacion.registrarCancion(txtNombre.getText(), artistaSeleccionado.getNombre(),
    					txtGenero.getText(),txtYear.getText(),txtAlbum.getText(),
    					txtDuracion.getText(), txtLink.getText());
    			JOptionPane.showMessageDialog(null, "Cancion agregada con exito");
    			txtNombre.clear();
        		txtGenero.clear();
        		txtLink.clear();
        		txtDuracion.clear();
        		txtYear.clear();
        		txtAlbum.clear();
			}else{
				JOptionPane.showMessageDialog(null, "Porfavor rellene todos los campos");
			}
		}else{
			JOptionPane.showMessageDialog(null, "Seleccione un artista al cual quiere agregarle la canción");
		}
    }

    /**
     * Metodo para verificar si los datos ingresados son validos y no estn vacios
     * @return true si son validos, false si alguno no es valido
     */
	private boolean datosValidos() {
		if (txtNombre.getText().isEmpty() || txtAlbum.getText().isEmpty() ||
				txtDuracion.getText().isEmpty() || txtGenero.getText().isEmpty() ||
				txtLink.getText().isEmpty() || txtYear.getText().isEmpty()) {
			return false;
		}
		return true;
	}

	/**
	 * Metodo que setea la aplicacion y las tablas
	 * @param aplicacion
	 */
	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;

		tableArtistas.getItems().clear();
		tableArtistas.setItems(getListaArtistas());
	}

	/**
	 * Metodo que trae la lista de artistas para las tablas
	 * @return
	 */
	private ObservableList<Artista> getListaArtistas() {
    	listaArtistasData.addAll(aplicacion.obtenerArtistas());
 		return listaArtistasData;
	}

	/**
	 * Metodo inicializador que inicializa las celdas de las tablas y el selection model
	 */
	@FXML
	void initialize(){
		this.colNombreArtista.setCellValueFactory(new PropertyValueFactory<>("nombre"));
 		this.colNacionalidadArtista.setCellValueFactory(new PropertyValueFactory<>("nacionalidad"));
 		this.colCodigoArtista.setCellValueFactory(new PropertyValueFactory<>("codigo"));

 		tableArtistas.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection) -> {
    		artistaSeleccionado = newSelection;
		});
	}

}
