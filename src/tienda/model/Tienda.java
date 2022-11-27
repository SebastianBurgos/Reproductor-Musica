package tienda.model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Tienda {

	ListaDoble<Cancion> listaCanciones = new ListaDoble<Cancion>();
	private HashMap<String,Usuario> listaUsuarios=new HashMap<>();
	ArbolArtista<Artista> arbolArtista = new ArbolArtista<Artista>();

	ArrayList<Artista> artistaView = new ArrayList<>();
	ArrayList<Cancion> cancionesView = new ArrayList<>();

	public Tienda(){
		super();
		quemarDatos();
	}


	private void quemarDatos() {
		Usuario usr1 = new Usuario("juan", "juan01","alambrito@qlo.lor");
		Usuario usr2 = new Usuario("majo", "majo02","alejandrito@qlo.lor");
		Usuario usr3 = new Usuario("sebas", "sebas03" ,"pablito@qlo.lor");
		Usuario usr4 = new Usuario("1", "1" ,"1");
		listaUsuarios.put("juan", usr1);
		listaUsuarios.put("majo", usr2);
		listaUsuarios.put("sebas", usr3);
		listaUsuarios.put("1", usr4);

		Artista a1 = new Artista(1,"Jose Jose", "Colombiana",  false);
		Artista a2 = new Artista(2,"Jeanette",  "Colombiana",  false);
		Artista a3 = new Artista(3,"Calamaro", "Argentino",  false);
		Artista a4 = new Artista(4,"Daft Punk",  "Estado Unidense", false);
		Artista a5 = new Artista(5,"Gnarls",  "Estado Unidense",  false);
		Artista a6 = new Artista(6,"Nolan", "Estado Unidense", false);
		arbolArtista.agregar(a1);
		arbolArtista.agregar(a2);
		arbolArtista.agregar(a3);
		arbolArtista.agregar(a4);
		arbolArtista.agregar(a5);
		arbolArtista.agregar(a6);

		artistaView.add(a1);
		artistaView.add(a2);
		artistaView.add(a3);
		artistaView.add(a4);
		artistaView.add(a5);
		artistaView.add(a6);


		Cancion c1 = new Cancion(1,"El triste", "lostristes", "balada", "2002", "2:20", "https://www.youtube.com/watch?v=E20G25SCAEg&ab_channel=Jos%C3%A9Jos%C3%A9Oficial" , "Jose Jose");
		Cancion c2 = new Cancion(2,"Amar y querer", "lostristes", "balada",  "2020", "3:20", "https://www.youtube.com/watch?v=a3xjfTEXFWg&ab_channel=Jos%C3%A9Jos%C3%A9-Topic" , "Jose Jose");
		Cancion c3 = new Cancion(3,"Por que te vas", "porktevas", "balada",  "2018", "2:20", "https://www.youtube.com/watch?v=TjUhXbGdLYo&ab_channel=Jeanette" , "Jeanette");
		Cancion c4 = new Cancion(4,"Flaca", "losflacos", "rock","2002", "6:20", "https://www.youtube.com/watch?v=uEV4RqqnlSE&ab_channel=Andr%C3%A9sCalamaro-Topic" , "Calamaro");
		Cancion c5 = new Cancion(5,"Instant Crush", "instant", "pop", "2002", "4:20", "https://www.youtube.com/watch?v=a5uQMwRMHcs&ab_channel=DaftPunkVEVO" , "Daft Punk");
		Cancion c6 = new Cancion(6,"Something About Us", "instant", "pop", "2002", "2:20", "https://www.youtube.com/watch?v=E20G25SCAEg&ab_channel=Jos%C3%A9Jos%C3%A9Oficial" , "Daft Punk");
		Cancion c7 = new Cancion(7,"Crazy", "loscreisis", "alternativo", "2002", "3:20", "https://www.youtube.com/watch?v=-N4jf6rtyuw&ab_channel=GnarlsBarkleyOfficial" , "Gnarls");
		Cancion c8 = new Cancion(8,"Interestellar", "teamonolan", "alternativo", "2002", "2:20", "https://www.youtube.com/watch?v=UDVtMYqUAyw&ab_channel=Cin%C3%A9mavore" , "Nolan");
		listaCanciones.agregarFinal(c1);
		listaCanciones.agregarFinal(c2);
		listaCanciones.agregarFinal(c3);
		listaCanciones.agregarFinal(c4);
		listaCanciones.agregarFinal(c5);
		listaCanciones.agregarFinal(c6);
		listaCanciones.agregarFinal(c7);
		listaCanciones.agregarFinal(c8);
		cancionesView.add(c1);
		cancionesView.add(c2);
		cancionesView.add(c3);
		cancionesView.add(c4);
		cancionesView.add(c5);
		cancionesView.add(c6);
		cancionesView.add(c7);
		cancionesView.add(c8);

		ArrayList<Cancion> usrCanciones = new ArrayList<>();
		usrCanciones.add(c1);
		usrCanciones.add(c2);
		usrCanciones.add(c3);
		usr3.setListaCancionesView(usrCanciones);
		ListaDoble<Cancion> usrCan = new ListaDoble<>();
		for (Cancion cancion : usrCanciones) {
			usrCan.agregarFinal(cancion);
		}
		usr3.setListaCanciones(usrCan);
	}

	public ArrayList<Cancion> getListaCanciones() {
		return cancionesView;
	}


	public void setListaCanciones(ListaDoble<Cancion> listaCanciones) {
		this.listaCanciones = listaCanciones;
	}


	public HashMap<String, Usuario> getListaUsuarios() {
		return listaUsuarios;
	}


	public void setListaUsuarios(HashMap<String, Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}


	public ArrayList<Artista> getArtistaView() {
		return artistaView;
	}


	public void setArtistaView(ArrayList<Artista> artistaView) {
		this.artistaView = artistaView;
	}

	public ArrayList<Cancion> getCancionesView() {
		return cancionesView;
	}


	public void setCancionesView(ArrayList<Cancion> cancionesView) {
		this.cancionesView = cancionesView;
	}


	public static boolean verificarAdmin(String user, String pssw) {

		if(user.equalsIgnoreCase("admin") && pssw.equalsIgnoreCase("admin1234")){
			return true;
		}
		return false;
	}



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

	public void crearUsuario(String user, String psw, String correo) {
		Usuario usuario = new Usuario(user, psw, correo);
		listaUsuarios.put(user, usuario);
	}

	public void agregarCancionListaUser(Cancion cancionSeleccionada, String usuarioIngresado) {
		for (Map.Entry<String, Usuario> usuario : listaUsuarios.entrySet()) {
			if (usuario.getKey().equals(usuarioIngresado)){
				usuario.getValue().getListaCancionesView().add(cancionSeleccionada);
				usuario.getValue().getListaCanciones().agregarFinal(cancionSeleccionada);
			}
		}
	}

	public void registrarCancionTienda(String nombre, String artista, String genero, String year, String album, String duracion, String url) {
		Random random = new Random();
		int numeroAleatorio = 100000 + random.nextInt(999999 - 100000);

		Cancion cancion = new Cancion(numeroAleatorio,nombre, artista, genero, year, album, duracion, url);
		listaCanciones.agregarFinal(cancion);
		cancionesView.add(cancion);
	}


	public void registrarArtistaTienda(String nombre, String nacionalidad, boolean b) {
		Random random = new Random();
		int numeroAleatorio = 100000 + random.nextInt(999999 - 100000);
		Artista nuevo = new Artista(numeroAleatorio,nombre, nacionalidad, b);
		arbolArtista.agregar(nuevo);
		artistaView.add(nuevo);
	}


	public ArrayList<Cancion> getCancionesUser(String usuarioIngresado) {
		for (Map.Entry<String, Usuario> usuario : listaUsuarios.entrySet()) {
			if (usuario.getKey().equals(usuarioIngresado)){
				return usuario.getValue().getListaCancionesView();
			}
		}
		return null;
	}


	public void eliminarCancionListaUser(Cancion cancionSeleccionadaFavoritas, String usuarioIngresado) {
		for (Map.Entry<String, Usuario> usuario : listaUsuarios.entrySet()) {
			if (usuario.getKey().equals(usuarioIngresado)){
				usuario.getValue().getListaCancionesView().remove(cancionSeleccionadaFavoritas);
				usuario.getValue().getListaCanciones().eliminar(cancionSeleccionadaFavoritas);
			}
		}
	}

}


