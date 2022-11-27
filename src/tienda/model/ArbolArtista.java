package tienda.model;



public class ArbolArtista<T extends Comparable<T>> {

	private NodoArbol<T> raiz;
	private int peso;

	/**
	 * Verifica si un �rbol est� vac�o
	 * @return true si est� vac�o
	 */
	public boolean estaVacio() {
		return raiz==null;
	}

	/**
	 * Agrega un nuevo elemento al �rbol
	 * @param elemento Nuevo dato
	 * @return true si lo pudo guardar
	 */
	public void agregar(T elemento){
		if(estaVacio()) {
			raiz = new NodoArbol<>(elemento);
			peso++;
		}else if(raiz.agregar(elemento)) {
			peso++;
		}
	}




	public void agregarArtista(T elemento) {
		//TODO debe aumentar el peso cada que se agregue un nuevo elemento
		if(estaVacio()) {
			raiz = new NodoArbol<>(elemento);
			peso++;
		}else if(raiz.agregar(elemento)) {
			peso++;
		}
	}

	/**
	 * Vetifica si un elemento existe en el �rbol binario
	 * @param raiz2 NodoArbol ra�z
	 * @param n Elemento a buscar
	 * @return true si lo encuentra
	 */
	public boolean existe(NodoArbol<Integer> raiz2, int n) {
		if(raiz2!=null) {
			if( n==raiz2.getElemento()) {
				return true;
			}else if( n<raiz2.getElemento() ) {
				return existe(raiz2.getIzquierdo(), n);
			}else if( n>raiz2.getElemento() ) {
				return existe(raiz2.getDerecho(), n);
			}
		}
		return false;
	}

	/**
	 * Cuenta todos los elementos que hay en el �rbol
	 * @param n NodoArbol ra�z
	 * @return Peso del �rbol
	 */
	public int obtenerPeso(NodoArbol<T> n) {

		if(n!=null) {
			return 1+obtenerPeso(n.getIzquierdo())+obtenerPeso(n.getDerecho());
		}

		return 0;
	}

	/**
	 * Devuelve la altura del �rbol
	 * @param n NodoArbol ra�z
	 * @return Altura del arbol
	 */
	public int obtenerAltura(NodoArbol<T> n, int prof) {
		if(n!=null) {
			int profIzq= obtenerAltura(n.getIzquierdo(),prof +1 );
			int profDer= obtenerAltura(n.getDerecho(),prof +1 );
		if (profIzq>=profDer)	{

			return profIzq;
		}else {

			return profDer;
		}


		}

		return prof;
	}

	/**
	 * Obtiene el nivel de un nodo
	 * @param nodo NodoArbol ra�z
	 * @param elemento, elemento a buscar
	 * @param nivel nivel del nodo
	 * @return nivel del nodo
	 */

public int obtenerNivel(NodoArbol <T> nodo, T elemento, int nivel) {

	if (nodo!=null) {
		if(elemento.compareTo(nodo.getElemento())==0) {
			return nivel;
		} else if (elemento.compareTo(nodo.getIzquierdo().getElemento())<0) {
			return obtenerNivel(nodo.getIzquierdo(), elemento, nivel+1);
		}
		else if (elemento.compareTo(nodo.getDerecho().getElemento())>0) {
			return obtenerNivel(nodo.getDerecho(), elemento, nivel+1);

		   }
		}
	return -1;
	}

public void imprimirHorizontal(NodoArbol <T> n, int nivel) {
	if (n!=null) {
		 imprimirHorizontal(n.getDerecho(), nivel+1);

		 for (int i = 0; i < nivel; i++) {
			 System.out.println("/t");

		}

		 System.out.println(n.getElemento());

		 imprimirHorizontal(n.getIzquierdo(), nivel+1);

	}


}




}
