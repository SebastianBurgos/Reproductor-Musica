package tienda.model;

import java.io.Serializable;

/**
 * Clase Cancion
 * @author Sebastian Burgos Puentes
 */
/**
 * La clase Cancion representa una canción que puede ser interpretada por uno o más artistas.
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
	 * @param codigo el código de la canción
	 * @param nombre el nombre de la canción
	 * @param album el nombre del álbum al que pertenece la canción
	 * @param genero el género musical de la canción
	 * @param year el año de lanzamiento de la canción
	 * @param duracion la duración de la canción
	 * @param url la URL donde se puede escuchar la canción
	 * @param nombreArtista el nombre del artista o artistas que interpretan la canción
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
	 * Crea una nueva instancia de la clase Cancion sin valores específicos.
	 */
	public Cancion() {
		super();
	}

	/**
	 * Obtiene el código de la canción.
	 *
	 * @return el código de la canción
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Establece el código de la canción.
	 *
	 * @param codigo el código de la canción
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * Obtiene el nombre del artista o artistas que interpretan la canción.
	 *
	 * @return el nombre del artista o artistas que interpretan la canción
	 */
	public String getNombreArtista() {
		return nombreArtista;
	}

	/**
	 * Establece el nombre del artista o artistas que interpretan la canción.
	 *
	 * @param nombreArtista el nombre del artista o artistas que interpretan la canción
	 */
	public void setNombreArtista(String nombreArtista) {
		this.nombreArtista = nombreArtista;
	}

	/**
	 * Obtiene el nombre de la canción.
	 *
	 * @return el nombre de la canción
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre de la canción.
	 *
	 * @param nombre El nombre de la canción a establecer.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el género de la canción.
	 *
	 * @return El género de la canción.
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * Establece el género de la canción.
	 *
	 * @param genero El género de la canción a establecer.
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * Devuelve la URL de la canción.
	 * @return la URL de la canción
	 */
	public String getUrl() {
	    return url;
	}

	/**
	 * Establece la URL de la canción.
	 * @param url la URL de la canción a establecer
	 */
	public void setUrl(String url) {
	    this.url = url;
	}

	/**
	 * Devuelve la duración de la canción.
	 * @return la duración de la canción
	 */
	public String getDuracion() {
	    return duracion;
	}

	/**
	 * Establece la duración de la canción.
	 * @param duracion la duración de la canción a establecer
	 */
	public void setDuracion(String duracion) {
	    this.duracion = duracion;
	}

	/**
	 * Devuelve el álbum de la canción.
	 * @return el álbum de la canción
	 */
	public String getAlbum() {
	    return album;
	}

	/**
	 * Establece el álbum de la canción.
	 * @param album el álbum de la canción a establecer
	 */
	public void setAlbum(String album) {
	    this.album = album;
	}

	/**
	 * Devuelve el año de lanzamiento de la canción.
	 * @return el año de lanzamiento de la canción
	 */
	public String getYear() {
	    return year;
	}

	/**
	 * Establece el año de lanzamiento de la canción.
	 * @param year el año de lanzamiento de la canción a establecer
	 */
	public void setYear(String year) {
	    this.year = year;
	}

	/**
	 * Devuelve una representación en cadena de la canción.
	 * @return una representación en cadena de la canción
	 */
	@Override
	public String toString() {
	    return "Cancion [codigo=" + codigo + ", nombreArtista=" + nombreArtista + ", nombre=" + nombre + ", genero="
	            + genero + ", url=" + url + ", duracion=" + duracion + ", album=" + album + ", year=" + year + "]\n";
	}

}
