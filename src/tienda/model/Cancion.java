package tienda.model;

public class Cancion {

	private int codigo;
	private String nombreArtista;
	private String nombre;
	private String genero;
	private String url;
	private String duracion;
	private String album;
	private String year;

	public Cancion(int codigo, String nombre,String album, String genero,
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

	public Cancion() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombreArtista() {
		return nombreArtista;
	}

	public void setNombreArtista(String nombreArtista) {
		this.nombreArtista = nombreArtista;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public void reproducir(){

	}

	@Override
	public String toString() {
		return "Cancion [codigo=" + codigo + ", nombreArtista=" + nombreArtista + ", nombre=" + nombre + ", genero="
				+ genero + ", url=" + url + ", duracion=" + duracion + ", album=" + album + ", year=" + year + "]";
	}
}
