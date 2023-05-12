package tienda.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * Clase Usuario
 * @author Sebastian Burgos Puentes
 *
 */
public class Usuario implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public String user;
	public String password;
	public String correo;

	public ListaDoble<Cancion> listaCanciones = new ListaDoble<Cancion>();

	/**
	 * Constructor vac�o de la clase Usuario.
	 */
	public Usuario(){
	    super();
	}

	/**
	 * Constructor de la clase Usuario.
	 * @param user nombre de usuario.
	 * @param pssw contrase�a del usuario.
	 * @param correo correo electr�nico del usuario.
	 */
	public Usuario(String user, String pssw, String correo) {
	    super();
	    this.user = user;
	    this.password= pssw;
	    this.correo = correo;
	}

	ArrayList<Cancion> listaCancionesView = new ArrayList<Cancion>();

	/**
	 * M�todo que devuelve la llave del usuario.
	 * @return llave del usuario.
	 */
	public String getKey() {
	    return user;
	}

	/**
	 * M�todo que devuelve el valor del usuario.
	 * @return valor del usuario.
	 */
	public String getValor() {
	    return password;
	}

	/**
	 * M�todo que devuelve el correo electr�nico del usuario.
	 * @return correo electr�nico del usuario.
	 */
	public String getCorreo() {
	    return correo;
	}

	/**
	 * M�todo que devuelve la lista doblemente enlazada de canciones del usuario.
	 * @return lista de canciones del usuario.
	 */
	public ListaDoble<Cancion> getListaCanciones(){
	    return listaCanciones;
	}

	/**
	 * Devuelve la lista de canciones como un ArrayList.
	 * @return la lista de canciones como un ArrayList
	 */
	public ArrayList<Cancion> getListaArray(){
	    return listaCanciones.getContent();
	}

	/**
	 * Establece la lista de canciones como una ListaDoble de canciones.
	 * @param listaCanciones la lista de canciones a establecer
	 */
	public void setListaCanciones(ListaDoble<Cancion> listaCanciones){
	    this.listaCanciones = listaCanciones;
	}

	/**
	 * Devuelve la lista de canciones como un ArrayList de canciones.
	 * @return la lista de canciones como un ArrayList de canciones
	 */
	public ArrayList<Cancion> getListaCancionesView() {
	    return listaCancionesView;
	}

	/**
	 * Establece la lista de canciones como un ArrayList de canciones.
	 * @param listaCanciones la lista de canciones a establecer
	 */
	public void setListaCancionesView(ArrayList<Cancion> listaCanciones) {
	    this.listaCancionesView = listaCanciones;
	}

	/**
	 * Agrega una canci�n a la lista de canciones del usuario.
	 * Si la canci�n ya existe, no se agrega y se muestra un mensaje.
	 * @param cancion la canci�n a agregar
	 */
	public void agregarCancion(Cancion cancion){
	    boolean existe = false;
	    for (Cancion c : listaCancionesView) {
	        if (c.getNombre().equalsIgnoreCase(cancion.getNombre())) {
	            existe = true;
	            JOptionPane.showMessageDialog(null, "La cancion no fue agregada porque ya est� agregada");
	        }
	    }
	    if (!existe) {
	        listaCanciones.agregarFinal(cancion);
	        listaCancionesView.add(cancion);
	        JOptionPane.showMessageDialog(null, "La cancion  fue agregada exitosamente a tu lista");
	    };
	}

	/**
	 * Elimina una canci�n de la lista de canciones del usuario.
	 * @param cancionSeleccionada la canci�n a eliminar
	 */
	public void eliminarCancionMiLista(Cancion cancionSeleccionada) {
	    listaCanciones.eliminar(cancionSeleccionada);
	    listaCancionesView.remove(cancionSeleccionada);
	    JOptionPane.showMessageDialog(null, "La cancion ha sido eliminada");
	}

	/**
	 * Metodo toString de la clase Usuario
	 */
	@Override
	public String toString() {
		return "Usuario [user=" + user + ", password=" + password + ", correo=" + correo + ", listaCanciones="
				+ listaCanciones + ", listaCancionesView=" + listaCancionesView + "]";
	}

}
