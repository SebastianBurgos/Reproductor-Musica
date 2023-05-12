package tienda.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * Clase Artista que representa a un artista musical.
 * Contiene información como el nombre, nacionalidad,
 * si es un grupo, el código del artista y una lista de
 * canciones del artista.
 *
 * @author Sebastian Burgos Puentes
 *
 */
public class Artista implements Comparable<Artista>, Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String nombre;
	private String nacionalidad;
	private boolean grupo;

	//Se usa una lista doble para almacenar las canciones
	public ListaDoble<Cancion> cancionesArtista = new ListaDoble<Cancion>();

	 /**
     * Crea un nuevo objeto Artista con los valores especificados.
     * @param codigo El código del artista.
     * @param nombre El nombre del artista.
     * @param nacionalidad La nacionalidad del artista.
     * @param grupo Indica si el artista es un grupo o no.
     */
    public Artista(int codigo, String nombre, String nacionalidad, boolean grupo) {
        super();
        this.nombre = nombre;
        this.codigo = codigo;
        this.nacionalidad = nacionalidad;
        this.grupo = grupo;
    }

    /**
     * Crea un nuevo objeto Artista sin valores por defecto.
     */
    public Artista() {
        super();
    }

	ArrayList<Cancion> listaCancionesView = new ArrayList<Cancion>();

    /**
     * Agrega una nueva canción a la lista de canciones del artista.
     * @param cancion La canción a agregar.
     */
    public void agregarCancion(Cancion cancion) {
        cancionesArtista.agregarFinal(cancion);
        listaCancionesView.add(cancion);
    }

    /**
     * Obtiene el nombre del artista.
     * @return El nombre del artista.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del artista.
     * @param nombre El nuevo nombre del artista.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la nacionalidad del artista.
     * @return La nacionalidad del artista.
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * Establece la nacionalidad del artista.
     * @param nacionalidad La nueva nacionalidad del artista.
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    /**
     * Indica si el artista es un grupo.
     * @return true si el artista es un grupo, false si es un artista individual.
     */
    public boolean isGrupo() {
        return grupo;
    }

    /**
     * Establece si el artista es un grupo o no.
     * @param grupo true si el artista es un grupo, false si es un artista individual.
     */
    public void setGrupo(boolean grupo) {
        this.grupo = grupo;
    }

    /**
     * Obtiene la lista de canciones del artista.
     * @return La lista de canciones del artista.
     */
    public ListaDoble<Cancion> getCancionesArtista() {
        return cancionesArtista;
    }

    /**
     * Establece la lista de canciones del artista.
     * @param cancionesArtista La nueva lista de canciones del artista.
     */
    public void setCancionesArtista(ListaDoble<Cancion> cancionesArtista) {
        this.cancionesArtista = cancionesArtista;
    }

    /**
     * Obtiene el código del artista.
     * @return El código del artista.
     */
    public int getCodigo() {
        return codigo;
    }

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public ArrayList<Cancion> getListaCancionesView() {
		return listaCancionesView;
	}

	public void setListaCancionesView(ArrayList<Cancion> listaCancionesView) {
		this.listaCancionesView = listaCancionesView;
	}

	/**
	 * Método para comparar dos artistas basándose en el hashcode de sus nombres.
	 * @param o Artista a comparar con el actual.
	 * @return Devuelve un valor entero positivo si el nombre del artista que se recibe como parámetro tiene un hashcode mayor que el actual, un valor entero negativo si es menor y cero si son iguales.
	 */
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

	/**
	 * Método que devuelve una cadena de caracteres que representa al objeto Artista.
	 * @return Cadena de caracteres que representa al objeto Artista.
	 */
	@Override
	public String toString() {
		return "Artista [codigo=" + codigo + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", grupo="
				+ grupo + ", cancionesArtista=" + cancionesArtista + ", listaCancionesView=" + listaCancionesView + "]";
	}
}
