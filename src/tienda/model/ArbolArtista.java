package tienda.model;

import java.io.Serializable;

import javax.swing.JOptionPane;

/**
 * Clase Arbol de Artistas que contiene los nodos de artistas
 * @author Sebastian Burgos Puentes
 *
 * @param <T>
 */
public class ArbolArtista<T extends Comparable<T>> implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private NodoArbol<T> raiz;
	private int peso;

	/**
	 * Verifica si un arbol esta vacio
	 * @return true si esta vacio
	 */
	public boolean estaVacio() {
		return raiz==null;
	}

	/**
	 * Agrega un nuevo elemento al arbol
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

	/**
	 * Imprime los nodos de un �rbol binario en forma horizontal.
	 *
	 * @param n Nodo ra�z del �rbol binario
	 * @param nivel Nivel del �rbol binario en el que se encuentra el nodo actual
	 */
	public void imprimirHorizontal(NodoArbol <T> n, int nivel) {
	    if (n != null) {
	        imprimirHorizontal(n.getDerecho(), nivel + 1);

	        for (int i = 0; i < nivel; i++) {
	            System.out.println("/t");
	        }

	        System.out.println(n.getElemento());

	        imprimirHorizontal(n.getIzquierdo(), nivel + 1);
	    }
	}

	/**
	 * Busca un artista por su nombre y devuelve una lista doble enlazada con sus canciones.
	 *
	 * @param nombre Nombre del artista a buscar
	 * @return Lista doble enlazada con las canciones del artista encontrado
	 */
	public ListaDoble<Cancion> obtenerArtistaPorNombre(String nombre) {
	    if (!estaVacio()) {
	        try {
	            @SuppressWarnings("unchecked")
	            NodoArbol<T> artistaEncontrado = buscarNodo((T) nombre);
	            if (artistaEncontrado != null) {
	                Artista artistaE = (Artista) artistaEncontrado.getElemento();
	                return artistaE.getCancionesArtista();
	            }
	        } catch (InterruptedException e) {
	            JOptionPane.showMessageDialog(null, "El artista no fue encontrado");
	        }
	    }
	    return null;
	}

	/**
	 * Busca el nodo del �rbol que contiene el valor especificado.
	 * @param valor El valor a buscar en el �rbol.
	 * @return El nodo que contiene el valor, o null si no se encontr�.
	 * @throws InterruptedException Si alguna de las b�squedas en hilos es interrumpida.
	 */
	public NodoArbol<T> buscarNodo(T valor) throws InterruptedException {
	    BusquedaIzquierda izquierda = new BusquedaIzquierda(valor);
	    BusquedaDerecha derecha = new BusquedaDerecha(valor);

	    izquierda.start();
	    derecha.start();

	    izquierda.join();
	    derecha.join();

	    if (izquierda.getResultado() != null) {
	        return izquierda.getResultado();
	    } else {
	        return derecha.getResultado();
	    }
	}

	/**
	 * Clase interna que implementa la b�squeda del valor en el sub�rbol izquierdo.
	 */
	private class BusquedaIzquierda extends Thread {
	    private T valor;
	    private NodoArbol<T> resultado;

	    public BusquedaIzquierda(T valor) {
	        this.valor = valor;
	    }

	    /**
	     * Inicia la b�squeda del valor en el sub�rbol izquierdo.
	     */
	    public void run() {
	        resultado = buscarNodoEnPreorden(raiz.getIzquierdo(), valor);
	    }

	    /**
	     * Obtiene el resultado de la b�squeda.
	     * @return El nodo que contiene el valor, o null si no se encontr�.
	     */
	    public NodoArbol<T> getResultado() {
	        return resultado;
	    }
	}

	/**
	 * Clase interna que implementa la b�squeda del valor en el sub�rbol derecho.
	 */
	private class BusquedaDerecha extends Thread {
	    private T valor;
	    private NodoArbol<T> resultado;

	    public BusquedaDerecha(T valor) {
	        this.valor = valor;
	    }

	    /**
	     * Inicia la b�squeda del valor en el sub�rbol derecho.
	     */
	    public void run() {
	        resultado = buscarNodoEnPreorden(raiz.getDerecho(), valor);
	    }

	    /**
	     * Obtiene el resultado de la b�squeda.
	     * @return El nodo que contiene el valor, o null si no se encontr�.
	     */
	    public NodoArbol<T> getResultado() {
	        return resultado;
	    }
	}

	/**
	 * Busca el nodo del �rbol que contiene el valor especificado en preorden.
	 * @param nodo El nodo actual de la b�squeda.
	 * @param valor El valor a buscar en el �rbol.
	 * @return El nodo que contiene el valor, o null si no se encontr�.
	 */
	private NodoArbol<T> buscarNodoEnPreorden(NodoArbol<T> nodo, T valor) {
        if (nodo == null) {
            return null; // El valor no se encuentra en el �rbol
        } else if (nodo.getElemento().compareTo(valor) == 0) {
            return nodo; // Se encontr� el nodo con el valor buscado
        } else {
            // Continuar la b�squeda en preorden por el sub�rbol izquierdo
            NodoArbol<T> nodoIzquierdo = buscarNodoEnPreorden(nodo.getIzquierdo(), valor);
            if (nodoIzquierdo != null) {
                return nodoIzquierdo; // El valor fue encontrado en el sub�rbol izquierdo
            }
            // El valor no se encuentra en este sub�rbol
            return null;
        }
    }
}
