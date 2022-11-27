package tienda.model;


public class Artista implements Comparable<Artista>{

	private int codigo;
	private String nombre;
	private String nacionalidad;
	private boolean grupo;
	public ListaDoble<Cancion> cancionesArtista = new ListaDoble<Cancion>();

	public Artista(int codigo,String nombre,String nacionalidad, boolean grupo ) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.nacionalidad = nacionalidad;
		this.grupo = grupo;
	}
	public Artista() {
		super();
	}

	public void agregarCancion(Cancion cancion) {
		cancionesArtista.agregarFinal(cancion);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public boolean isGrupo() {
		return grupo;
	}

	public void setGrupo(boolean grupo) {
		this.grupo = grupo;
	}

	public ListaDoble<Cancion> getCancionesArtista() {
		return cancionesArtista;
	}

	public void setCancionesArtista(ListaDoble<Cancion> cancionesArtista) {
		this.cancionesArtista = cancionesArtista;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Override
	public int compareTo(Artista o) {
		if (o.getNombre().hashCode() > this.getNombre().hashCode()){
			return 1;
		}
		if (o.getNombre().hashCode() < this.getNombre().hashCode()){
			return -1;
		}
		return 0;
	}



}
