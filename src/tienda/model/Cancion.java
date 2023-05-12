package tienda.model;

import java.io.Serializable;

/**
 * Clase Cancion
 * @author Sebastian Burgos Puentes
 */
/**
 * La clase Cancion representa una canci�n que puede ser interpretada por uno o m�s artistas.
 */
public class Cancion implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String nombreArtista;
	private String nombre;
	private String genero;
	private String url;
	private String duracion;
	private String album;
	private String year;

	/**
	 * Crea una nueva instancia de la clase Cancion con los valores especificados.
	 *
	 * @param codigo el c�digo de la canci�n
	 * @param nombre el nombre de la canci�n
	 * @param album el nombre del �lbum al que pertenece la canci�n
	 * @param genero el g�nero musical de la canci�n
	 * @param year el a�o de lanzamiento de la canci�n
	 * @param duracion la duraci�n de la canci�n
	 * @param url la URL donde se puede escuchar la canci�n
	 * @param nombreArtista el nombre del artista o artistas que interpretan la canci�n
	 */
	public Cancion(int codigo, String nombre, String album, String genero,
			String year, String duracion, String url, String nombreArtista) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.genero = genero;
		this.url = url;
		this.album = album;
		this.duracion = duracion;
		this.year = year;
		this.nombreArtista = nombreArtista;
	}

	/**
	 * Crea una nueva instancia de la clase Cancion sin valores espec�ficos.
	 */
	public Cancion() {
		super();
	}

	/**
	 * Obtiene el c�digo de la canci�n.
	 *
	 * @return el c�digo de la canci�n
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Establece el c�digo de la canci�n.
	 *
	 * @param codigo el c�digo de la canci�n
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * Obtiene el nombre del artista o artistas que interpretan la canci�n.
	 *
	 * @return el nombre del artista o artistas que interpretan la canci�n
	 */
	public String getNombreArtista() {
		return nombreArtista;
	}

	/**
	 * Establece el nombre del artista o artistas que interpretan la canci�n.
	 *
	 * @param nombreArtista el nombre del artista o artistas que interpretan la canci�n
	 */
	public void setNombreArtista(String nombreArtista) {
		this.nombreArtista = nombreArtista;
	}

	/**
	 * Obtiene el nombre de la canci�n.
	 *
	 * @return el nombre de la canci�n
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre de la canci�n.
	 *
	 * @param nombre El nombre de la canci�n a establecer.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el g�nero de la canci�n.
	 *
	 * @return El g�nero de la canci�n.
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * Establece el g�nero de la canci�n.
	 *
	 * @param genero El g�nero de la canci�n a establecer.
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * Devuelve la URL de la canci�n.
	 * @return la URL de la canci�n
	 */
	public String getUrl() {
	    return url;
	}

	/**
	 * Establece la URL de la canci�n.
	 * @param url la URL de la canci�n a establecer
	 */
	public void setUrl(String url) {
	    this.url = url;
	}

	/**
	 * Devuelve la duraci�n de la canci�n.
	 * @return la duraci�n de la canci�n
	 */
	public String getDuracion() {
	    return duracion;
	}

	/**
	 * Establece la duraci�n de la canci�n.
	 * @param duracion la duraci�n de la canci�n a establecer
	 */
	public void setDuracion(String duracion) {
	    this.duracion = duracion;
	}

	/**
	 * Devuelve el �lbum de la canci�n.
	 * @return el �lbum de la canci�n
	 */
	public String getAlbum() {
	    return album;
	}

	/**
	 * Establece el �lbum de la canci�n.
	 * @param album el �lbum de la canci�n a establecer
	 */
	public void setAlbum(String album) {
	    this.album = album;
	}

	/**
	 * Devuelve el a�o de lanzamiento de la canci�n.
	 * @return el a�o de lanzamiento de la canci�n
	 */
	public String getYear() {
	    return year;
	}

	/**
	 * Establece el a�o de lanzamiento de la canci�n.
	 * @param year el a�o de lanzamiento de la canci�n a establecer
	 */
	public void setYear(String year) {
	    this.year = year;
	}

	/**
	 * Devuelve una representaci�n en cadena de la canci�n.
	 * @return una representaci�n en cadena de la canci�n
	 */
	@Override
	public String toString() {
	    return "Cancion [codigo=" + codigo + ", nombreArtista=" + nombreArtista + ", nombre=" + nombre + ", genero="
	            + genero + ", url=" + url + ", duracion=" + duracion + ", album=" + album + ", year=" + year + "]\n";
	}

}
