package tienda.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Clase Tienda que es la clase principal que contiene todo el sistema central
 * @author Sebastian Burgos Puentes
 *
 */
public class Tienda implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	//Se usa la key:username (unica) y el valor: objetousuario
	private HashMap<String,Usuario> listaUsuarios=new HashMap<>();
	//Se usa un arbol binario para almacenar los artistas
	ArbolArtista<Artista> arbolArtista = new ArbolArtista<Artista>();

	/**
	 * Constructor de la clase Tienda, que hereda de la clase padre.
	 * Este método llama al método "quemarDatos", el cual carga datos predefinidos en la tienda.
	 */
	public Tienda(){
		super();
	}

	/**
	 * Método privado que llama a los métodos "quemarUsuarios" y "quemarArtistasCanciones".
	 * Este método se encarga de cargar los datos predefinidos de la tienda.
	 */
	public void quemarDatos() {
		quemarUsuarios();
		quemarArtistasCanciones();
	}

	/**
	 * Método privado que se encarga de cargar usuarios predefinidos en la tienda.
	 */
	private void quemarUsuarios() {
		Usuario usuario1 = new Usuario("4", "4","4");
		Usuario usuario2 = new Usuario("3", "3","3");
		Usuario usuario3 = new Usuario("2", "2" ,"2");
		Usuario usuario4 = new Usuario("1", "1" ,"1");
		listaUsuarios.put("4", usuario1);
		listaUsuarios.put("3", usuario2);
		listaUsuarios.put("2", usuario3);
		listaUsuarios.put("1", usuario4);
	}

	/**
	 * Método privado que se encarga de cargar artistas y canciones predefinidos en la tienda.
	 */
	private void quemarArtistasCanciones() {

		//Se crean los artistas
		Artista artista1 = new Artista(1,"Joe Arroyo", "Colombiano",  false);
		Artista artista2 = new Artista(2,"Shakira",  "Colombiana",  false);
		Artista artista3 = new Artista(3,"Rauw Alejandro", "Colombiano",  false);
		Artista artista4 = new Artista(4,"AC DC",  "Estado Unidense", true);
		Artista artista5 = new Artista(5,"Vicente Fernandez",  "Mexicano",  false);
		Artista artista6 = new Artista(6,"Eminem", "Estado Unidense", false);

		//Se crean las canciones
		Cancion cancion1 = new Cancion(1,"Pal Bailador", "Fruko y sus senos", "Salsa", "2002", "3:20", "https://www.youtube.com/watch?v=LsdSSj90fJI&ab_channel=DiscosFuentesEdimusica" , "Joe Arroyo");
		Cancion cancion2 = new Cancion(2,"Te felicito", "Apple", "Regaeton",  "2023", "3:20", "https://www.youtube.com/watch?v=4I25nV9hXGA&ab_channel=shakiraVEVO" , "Shakira");
		Cancion cancion3 = new Cancion(3,"Monotonia", "Caderona", "Regaeton",  "2018", "2:20", "https://www.youtube.com/watch?v=j5y6xLpRwx4&ab_channel=shakiraVEVO" , "Shakira");
		Cancion cancion4 = new Cancion(4,"Todo de ti", "La ultima", "Regaeton","2022", "3:20", "https://www.youtube.com/watch?v=CFPLIaMpGrY&ab_channel=RauwAlejandro" , "Rauw Alejandro");
		Cancion cancion5 = new Cancion(5,"Highway to hell", "Hellrock", "Metal", "1998", "4:20", "https://www.youtube.com/watch?v=gEPmA3USJdI&ab_channel=acdcVEVO" , "AC DC");
		Cancion cancion6 = new Cancion(6,"Thunderstruck", "Thunder", "Metal", "1997", "2:20", "https://www.youtube.com/watch?v=v2AC41dglnM&ab_channel=acdcVEVO" , "AC DC");
		Cancion cancion7 = new Cancion(7,"A mi manera", "Nospi", "Ranchera", "2000", "3:20", "https://www.youtube.com/watch?v=9F_BRjGi3L8&ab_channel=vicentefernandezVEVO" , "Vicente Fernandez");
		Cancion cancion8 = new Cancion(8,"Without me", "Rapgod", "Rap", "2002", "2:20", "https://www.youtube.com/watch?v=YVkUvmDQ3HY&ab_channel=EminemVEVO" , "Eminem");

		//Se asignan las canciones a los artistas
		artista1.agregarCancion(cancion1);
		artista2.agregarCancion(cancion2);
		artista2.agregarCancion(cancion3);
		artista3.agregarCancion(cancion4);
		artista4.agregarCancion(cancion5);
		artista4.agregarCancion(cancion6);
		artista5.agregarCancion(cancion7);
		artista6.agregarCancion(cancion8);

		//Se agregan los artistas al arbol
		arbolArtista.agregar(artista1);
		arbolArtista.agregar(artista2);
		arbolArtista.agregar(artista3);
		arbolArtista.agregar(artista4);
		arbolArtista.agregar(artista5);
		arbolArtista.agregar(artista6);

		//Se agregan los artistas al arraylist a mostrar en la tablas de la vista
		artistaView.add(artista1);
		artistaView.add(artista2);
		artistaView.add(artista3);
		artistaView.add(artista4);
		artistaView.add(artista5);
		artistaView.add(artista6);

		//Se agregan las canciones al arraylist a mostrar en las tablas de la vista
		cancionesView.add(cancion1);
		cancionesView.add(cancion2);
		cancionesView.add(cancion3);
		cancionesView.add(cancion4);
		cancionesView.add(cancion5);
		cancionesView.add(cancion6);
		cancionesView.add(cancion7);
		cancionesView.add(cancion8);

		//Se crea un arraylist que va a tener las canciones favoritas de un usuario de prueba
		ArrayList<Cancion> cancionesUsuario = new ArrayList<>();
		cancionesUsuario.add(cancion1);
		cancionesUsuario.add(cancion2);
		cancionesUsuario.add(cancion3);

		//Agregando canciones de prueba a la lista de reproduccion de un usuario de prueba (el user 1 contraseña 1)
		Usuario agregarCanciones = listaUsuarios.get("1");
		ListaDoble<Cancion> listaDobleCancionesUsuario = new ListaDoble<>();
		for (Cancion cancion : cancionesUsuario) {
			listaDobleCancionesUsuario.agregarFinal(cancion);
		}
		agregarCanciones.setListaCanciones(listaDobleCancionesUsuario);
		agregarCanciones.setListaCancionesView(cancionesUsuario);
	}

	//Se usan arraylist utilizados solo para mostrar en las tablas de las vistas
	ArrayList<Artista> artistaView = new ArrayList<>();
	ArrayList<Cancion> cancionesView = new ArrayList<>();

	/**
	 * Devuelve una lista de canciones.
	 * @return la lista de canciones.
	 */
	public ArrayList<Cancion> getListaCanciones() {
	    return cancionesView;
	}

	/**
	 * Devuelve un mapa de usuarios.
	 * @return el mapa de usuarios.
	 */
	public HashMap<String, Usuario> getListaUsuarios() {
	    return listaUsuarios;
	}

	/**
	 * Establece el mapa de usuarios.
	 * @param listaUsuarios el mapa de usuarios que se desea establecer.
	 */
	public void setListaUsuarios(HashMap<String, Usuario> listaUsuarios) {
	    this.listaUsuarios = listaUsuarios;
	}

	/**
	 * Devuelve una lista de artistas.
	 * @return la lista de artistas.
	 */
	public ArrayList<Artista> getArtistaView() {
	    return artistaView;
	}

	/**
	 * Establece la lista de artistas.
	 * @param artistaView la lista de artistas que se desea establecer.
	 */
	public void setArtistaView(ArrayList<Artista> artistaView) {
	    this.artistaView = artistaView;
	}

	/**
	 * Devuelve una lista de canciones.
	 * @return la lista de canciones.
	 */
	public ArrayList<Cancion> getCancionesView() {
	    return cancionesView;
	}

	/**
	 * Establece la lista de canciones.
	 * @param cancionesView la lista de canciones que se desea establecer.
	 */
	public void setCancionesView(ArrayList<Cancion> cancionesView) {
	    this.cancionesView = cancionesView;
	}

	/**
	 * Verifica si las credenciales de un usuario son válidas para el rol de administrador.
	 * @param user nombre de usuario
	 * @param pssw contraseña de usuario
	 * @return true si el usuario es administrador y las credenciales son válidas, false de lo contrario
	 */
	public boolean verificarAdmin(String user, String pssw) {
		if(user.equalsIgnoreCase("admin") && pssw.equalsIgnoreCase("admin1234")){
			return true;
		}
		return false;
	}

	/**
	 * Verifica si las credenciales de un usuario son válidas para el inicio de sesión.
	 * @param user nombre de usuario
	 * @param pssw contraseña de usuario
	 * @return true si las credenciales son válidas, false de lo contrario
	 */
	public boolean verificarUsuario(String user, String pssw) {
		if (listaUsuarios.containsKey(user)) {
		    if(listaUsuarios.get(user).password.equalsIgnoreCase(pssw)){
		    	return true;
		    }else{
		    	return false;
		    }
		}else{
			return false;
		}
	}

	/**
	 * Crea un nuevo usuario y lo agrega a la lista de usuarios.
	 * @param user nombre de usuario
	 * @param psw contraseña de usuario
	 * @param correo correo electrónico del usuario
	 */
	public boolean crearUsuario(String user, String psw, String correo) {
		if (!listaUsuarios.containsKey(user)) {
			Usuario usuario = new Usuario(user, psw, correo);
			listaUsuarios.put(user, usuario);
			return true;
		}else{
			return false;
		}
	}

	/**
	 * Agrega una canción a la lista de canciones de un usuario específico.
	 *
	 * @param cancionSeleccionada la canción a agregar.
	 * @param usuarioIngresado el nombre del usuario al cual se le agregará la canción.
	 */
	public void agregarCancionListaUser(Cancion cancionSeleccionada, String usuarioIngresado) {
	    for (Map.Entry<String, Usuario> usuario : listaUsuarios.entrySet()) {
	        if (usuario.getKey().equals(usuarioIngresado)){
	            usuario.getValue().getListaCancionesView().add(cancionSeleccionada);
	            usuario.getValue().getListaCanciones().agregarFinal(cancionSeleccionada);
	        }
	    }
	}

	/**
	 * Registra una canción en la tienda.
	 *
	 * @param nombre el nombre de la canción.
	 * @param artista el nombre del artista de la canción.
	 * @param genero el género de la canción.
	 * @param year el año de lanzamiento de la canción.
	 * @param album el álbum de la canción.
	 * @param duracion la duración de la canción en formato hh:mm:ss.
	 * @param url la URL del archivo de audio de la canción.
	 */
	public void registrarCancionTienda(String nombre, String artista, String genero, String year, String album, String duracion, String url) {
	    Random random = new Random();
	    int numeroAleatorio = 100000 + random.nextInt(999999 - 100000);

	    for (Artista artistaBuscar : artistaView) {
	        if (artistaBuscar.getNombre().equalsIgnoreCase(artista)) {
	            Cancion cancion = new Cancion(numeroAleatorio,nombre, album, genero, year, duracion, url, artista);
	            artistaBuscar.agregarCancion(cancion);
	            cancionesView.add(cancion);
	        }
	    }
	}

	/**
	 * Registra un artista en la tienda.
	 *
	 * @param nombre el nombre del artista.
	 * @param nacionalidad la nacionalidad del artista.
	 * @param esGrupo un booleano que indica si el artista es un grupo o no.
	 */
	public void registrarArtistaTienda(String nombre, String nacionalidad, boolean esGrupo) {
	    Random random = new Random();
	    int numeroAleatorio = 100000 + random.nextInt(999999 - 100000);
	    Artista nuevo = new Artista(numeroAleatorio,nombre, nacionalidad, esGrupo);
	    arbolArtista.agregar(nuevo);
	    artistaView.add(nuevo);
	}

	/**
	 * Obtiene la lista de canciones de un usuario.
	 * @param usuarioIngresado Nombre del usuario que se desea obtener la lista de canciones.
	 * @return Lista de canciones del usuario.
	 */
	public ArrayList<Cancion> getCancionesUser(String usuarioIngresado) {
	    for (Map.Entry<String, Usuario> usuario : listaUsuarios.entrySet()) {
	        if (usuario.getKey().equals(usuarioIngresado)){
	            return usuario.getValue().getListaCancionesView();
	        }
	    }
	    return null;
	}

	/**
	 * Elimina una canción de la lista de favoritos de un usuario.
	 * @param cancionSeleccionadaFavoritas Canción que se desea eliminar de la lista de favoritos del usuario.
	 * @param usuarioIngresado Nombre del usuario al que se le desea eliminar la canción de su lista de favoritos.
	 */
	public void eliminarCancionListaUser(Cancion cancionSeleccionadaFavoritas, String usuarioIngresado) {
	    for (Map.Entry<String, Usuario> usuario : listaUsuarios.entrySet()) {
	        if (usuario.getKey().equals(usuarioIngresado)){
	            usuario.getValue().getListaCancionesView().remove(cancionSeleccionadaFavoritas);
	            try {
	                usuario.getValue().getListaCanciones().eliminar(cancionSeleccionadaFavoritas);
	            } catch (Exception e) {
	            }
	        }
	    }
	}

	/**
	 * Busca canciones de un artista específico por su nombre.
	 * @param nombre Nombre del artista del cual se desea buscar las canciones.
	 * @return Lista de canciones del artista buscado.
	 */
	public ArrayList<Cancion> buscarCancionesPorNombreArtista(String nombre) {
	    for (Artista artista : artistaView) {
	        if (artista.getNombre().equals(nombre)) {
	        	return artista.getListaCancionesView();
	        }
	    }
	    return null;
	}

	/**
	 * Retorna el género más popular, es decir, el género con la mayor cantidad de canciones entre todos los usuarios.
	 * @return el género más popular.
	 */
	public String obtenerGeneroMasPopular() {
	    HashMap<String, Integer> generos = new HashMap<String, Integer>();
	    // Itera a través de todos los usuarios y sus canciones

        for (Cancion cancion : getListaCanciones()) {
            String genero = cancion.getGenero();
            if (generos.containsKey(genero)) {
                // Si el género ya existe en el HashMap de géneros, aumenta el contador
                generos.put(genero, generos.get(genero) + 1);
            } else {
                // Si el género no existe en el HashMap de géneros, agrega una nueva entrada
                generos.put(genero, 1);
            }
        }


	    // Encuentra el género con la mayor cantidad de canciones
	    String generoMasPopular = "";
	    int cantidadMasAlta = 0;
	    for (String genero : generos.keySet()) {
	        int cantidad = generos.get(genero);
	        if (cantidad > cantidadMasAlta) {
	            generoMasPopular = genero;
	            cantidadMasAlta = cantidad;
	        }
	    }

	    return generoMasPopular;
	}

	/**
	 * Retorna el artista más popular, es decir, el artista con la mayor cantidad de canciones entre todos los usuarios.
	 * @return el artista más popular.
	 */
	public String obtenerArtistaMasPopular() {
	    HashMap<String, Integer> artistas = new HashMap<String, Integer>();
	    // Itera a través de todos los usuarios y sus canciones
	    for (Usuario usuario : listaUsuarios.values()) {
	        for (Cancion cancion : usuario.getListaCancionesView()) {
	            String artista = cancion.getNombreArtista();
	            if (artistas.containsKey(artista)) {
	                // Si el artista ya existe en el HashMap de artistas, aumenta el contador
	                artistas.put(artista, artistas.get(artista) + 1);
	            } else {
	                // Si el artista no existe en el HashMap de artistas, agrega una nueva entrada
	                artistas.put(artista, 1);
	            }
	        }
	    }

	    // Encuentra el artista con la mayor cantidad de canciones
	    String artistaMasPopular = "";
	    int cantidadMasAlta = 0;
	    for (String artista : artistas.keySet()) {
	        int cantidad = artistas.get(artista);
	        if (cantidad > cantidadMasAlta) {
	            artistaMasPopular = artista;
	            cantidadMasAlta = cantidad;
	        }
	    }

	    return artistaMasPopular;
	}

	@Override
	public String toString() {
		return "Tienda [listaUsuarios=" + listaUsuarios + ", arbolArtista=" + arbolArtista + ", artistaView="
				+ artistaView + ", cancionesView=" + cancionesView + "]";
	}

}


