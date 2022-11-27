package tienda.model;

import java.util.ArrayList;

import javax.swing.JOptionPane;




public class Usuario {

	public String user;
	public String password;
	public String correo;

	public ListaDoble<Cancion> listaCanciones = new ListaDoble<Cancion>();
	ArrayList<Cancion> listaCancionesView = new ArrayList<Cancion>();

	public Usuario(){
		super();
	}

	public Usuario(String user, String pssw, String correo) {
		super();
		this.user = user;
		this.password= pssw;
		this.correo = correo;
	}

	public String getKey() {
		return user;
	}

	public String getValor() {
		return password;
	}

	public String getCorreo() {
		return correo;
	}

	public ListaDoble<Cancion> getListaCanciones(){
		return listaCanciones;
	}

	public ArrayList<Cancion> getListaArray(){
		return listaCanciones.getContent();
	}

	public void setListaCanciones(ListaDoble<Cancion> listaCanciones){
		this.listaCanciones = listaCanciones;
	}

	public ArrayList<Cancion> getListaCancionesView() {
		return listaCancionesView;
	}

	public void setListaCancionesView(ArrayList<Cancion> listaCanciones) {
		this.listaCancionesView = listaCanciones;
	}

	public void agregarCancion(Cancion cancion){
		boolean existe = false;
		for (Cancion c : listaCancionesView) {
			if (c.getNombre().equalsIgnoreCase(cancion.getNombre())) {
				existe = true;
				JOptionPane.showMessageDialog(null, "La cancion no fue agregada porque ya está agregada");
			}
		}
		if (existe == false) {
			listaCanciones.agregarFinal(cancion);
			listaCancionesView.add(cancion);
			JOptionPane.showMessageDialog(null, "La cancion  fue agregada exitosamente a tu lista");
		};
	}

//	public void mostrarListaCanciones(){
//		String lista="";
//		for(int i=0; i<listaCanciones.getTamano();i++){
//			lista=lista+"\n"+listaCanciones.obtener(i).getNombre()+" - "+listaCanciones.obtener(i).getArtista().getNombre();
//
//		}
//		System.out.println(lista);
//	}

	public void eliminarCancionMiLista(Cancion cancionSeleccionada) {
		listaCanciones.eliminar(cancionSeleccionada);
		listaCancionesView.remove(cancionSeleccionada);
		JOptionPane.showMessageDialog(null, "La cancion ha sido eliminada");
	}

}
