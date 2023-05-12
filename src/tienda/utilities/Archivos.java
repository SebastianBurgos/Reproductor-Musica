package tienda.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

import tienda.Aplicacion;

/**
 * Clase Archivos para agregar artistas y sus canciones desde archivos de texto plano
 * @author Sebastian Burgos Puentes
 */
public class Archivos {

	public static void agregarArtistasFromArchivo(Aplicacion aplicacion, String ruta) {
		try {
			// Creamos un lector de ficheros para leer el archivo especificado en la ruta
			BufferedReader br = new BufferedReader(new FileReader(ruta));
			String linea = "";
			boolean canciones = false;
			// Leemos la primera l�nea del archivo que debe ser "#Artistas"
			linea = br.readLine();
			while (linea != null) {
				// Leemos siguiente l�nea
				linea = br.readLine();
				if (linea != null) {
					if (linea.startsWith("#Canciones")) {
						canciones = true;
					}
					// Si estamos leyendo informaci�n de artistas
					if (canciones == false) {
						String[] datos = linea.split(";");
						String nombreArtista = datos[1];
						String nacionalidadArtista = datos[2];
						boolean grupoArtista = Boolean.parseBoolean(datos[3]);
						// Registramos el artista en la aplicaci�n
						aplicacion.registrarArtista(nombreArtista, nacionalidadArtista, grupoArtista);
					}
					// Si estamos leyendo informaci�n de canciones
					if (canciones == true) {
						// Si la l�nea no comienza con "#Canciones" o es "null", entonces es informaci�n de una canci�n
						if (!linea.startsWith("#Canciones") || linea.equals("null")) {
							String[] datos = linea.split(";");
							String nombreArtista = datos[0];
							String nombreCancion = datos[1];
							String album = datos[2];
							String anio = datos[3];
							String duracion = datos[4];
							String genero = datos[5];
							String url = datos[6];
							// Registramos la canci�n en la aplicaci�n
							aplicacion.registrarCancion(nombreCancion, nombreArtista, genero, anio, album, duracion, url);
						}
					}
				}
			}
			// Cerramos el lector de ficheros
			br.close();

		} catch (FileNotFoundException e) {
			// Mostramos un mensaje de error si no se encuentra el archivo
			JOptionPane.showMessageDialog(null, "No se encuentra el archivo");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// Mostramos un mensaje de error si no se puede convertir a entero alg�n dato
			JOptionPane.showMessageDialog(null, "No se pudo convertir a entero");
			e.printStackTrace();
		} catch (IOException e) {
			// Mostramos un mensaje de error si hay alg�n problema accediendo al archivo
			JOptionPane.showMessageDialog(null, "Error accediendo al archivo, porfavor use el formato correcto");
			e.printStackTrace();
		}
	}

}
