package tienda.test;

import org.junit.Test;

import junit.framework.TestCase;
import tienda.model.Tienda;
import tienda.persistencia.Persistencia;

/**
 * Clase TestTienda para realizar pruebas unitarias con JUnit4
 * @author Sebastian Burgos Puentes
 *
 */
public class TestTienda extends TestCase{

	private Tienda tienda;

	/**
	 * Metodo apra incializar datos de prueba
	 */
	public void inicializar(){
		tienda = Persistencia.cargarRecursoXML();
	}

	/**
	 * Prueba unitaria 1: Metodo verificar acceso de Administrador
	 */
	@Test
	public void testVerificarAdmin() {
		inicializar();
		//Acceso de credenciales correctas
		assert(tienda.verificarAdmin("admin", "admin1234") == true);
		//Acceso de credenciales incorrectas
		assert(tienda.verificarAdmin("admin", "contraseñaIncorrecta") == false);
		assert(tienda.verificarAdmin("usuarioIncorrecto", "admin1234") == false);
		assert(tienda.verificarAdmin("ADMIN", "ADMIN1234") == true);
		assert(tienda.verificarAdmin("", "") == false);
	}

	/**
	 * Prueba unitaria 2: Metodo verificar acceso de Usuario
	 */
	@Test
	public void testVerificarUsuario() {
		inicializar();
		//Acceso de credenciales correctas
		assert(tienda.verificarUsuario("1", "1") == true);
		assert(tienda.verificarUsuario("2", "2") == true);
		assert(tienda.verificarUsuario("3", "3") == true);
		assert(tienda.verificarUsuario("4", "4") == true);
		//Acceso de credenciales incorrectas
		assert(tienda.verificarUsuario("cerdo", "nose") == false);
		assert(tienda.verificarUsuario("xdxd", "robinybatman") == false);
		assert(tienda.verificarUsuario("nomk", null) == false);
		assert(tienda.verificarUsuario("", "") == false);
	}

	/**
	 * Prueba unitaria 3: Metodo crear usuario
	 */
	@Test
	public void testCrearUsuario() {
		inicializar();
		//Usuarios ya creados con el username unico
		assert(tienda.crearUsuario("1", "1", "1") == false);
		assert(tienda.crearUsuario("2", "2", "2") == false);
		assert(tienda.crearUsuario("3", "3", "3") == false);
		assert(tienda.crearUsuario("4", "4", "4") == false);
		//Usuarios aun no creados con el username unico
		assert(tienda.crearUsuario("olamaigos", "asd", "1asd") == true);
		assert(tienda.crearUsuario("canaima", "soyese", "2fdg") == true);
		assert(tienda.crearUsuario("maria", "asdad", "3dfg") == true);
		assert(tienda.crearUsuario("sebas", "4asd", "4dsg") == true);
	}

	/**
	 * Prueba unitaria 4: Metodo obtener el genero mas popular
	 */
	@Test
	public void testGeneroMasPopular() {
		inicializar();
		//Metodo nunca va a devolver null
		assertNotNull(tienda.obtenerGeneroMasPopular());
		//Ni numeros, ni booleanos, ni char
		assertNotSame(tienda.obtenerGeneroMasPopular(), 2);
		assertNotSame(tienda.obtenerGeneroMasPopular(), false);
		assertNotSame(tienda.obtenerGeneroMasPopular(), 'a');
	}

	/**
	 * Prueba unitaria 5: Metodo obtener el artista mas popular
	 */
	@Test
	public void testArtistaMasPopular() {
		inicializar();
		//Metodo nunca va a devolver null
		assertNotNull(tienda.obtenerArtistaMasPopular());
		//Ni numeros, ni booleanos, ni char
		assertNotSame(tienda.obtenerArtistaMasPopular(), 2);
		assertNotSame(tienda.obtenerArtistaMasPopular(), false);
		assertNotSame(tienda.obtenerArtistaMasPopular(), 'a');
	}

	/**
	 * Prueba unitaria 6: Metodo obtener las canciones de un usuario
	 */
	@Test
	public void testBuscarCancionesPorUsername() {
		inicializar();
		//Cuando se ingresa un usuario que no esta registrado
		assertNull(tienda.getCancionesUser("noestoyregistrado"));
		//Cuando busca canciones un usuario sin canciones favoritas
		//no debera devolver null sino una lista vacia
		assertNotNull(tienda.getCancionesUser("2"));
	}

	/**
	 * Prueba unitaria 7: Metodo obtener las canciones de un usuario
	 */
	@Test
	public void testBuscarCancionesPorNombreArtista() {
		inicializar();
		//Un artista que no existe o no tinee canciones
		assertNull(tienda.buscarCancionesPorNombreArtista("Noexisteesteartista"));
		//Cuando busca canciones un artista con canciones
		assertNotNull(tienda.buscarCancionesPorNombreArtista("Shakira"));
	}

}
