package cl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * <span style="color:red;">Clase TexFileIO.</span> Se encarga de guardar, obtener, actualizar y eliminar datos en archivos de texto
 *
 * @author Manuel Alvarado
 */
public class TextFileIO {

	private String file;

	/**
	 * Constructor. Contruye un objeto de tipo TextFileIO dado un archivo de texto
	 *
	 * @param file String Archivo de texto al cual se desea accesar
	 */
	public TextFileIO(String file) {
		this.file = file;
	}

	/**
	 * setFile Asigna el nombre del archivo de texto
	 *
	 * @param file String Archivo de texto al cual se desea accesar
	 */
	public void setFile(String file) {
		this.file = file;
	}

	/**
	 * setData Guarda un String en el archivo de texto
	 *
	 * @param data String Dato que se guardar en el archivo de texto
	 * @throws java.io.IOException
	 */
	public void setData(String data) throws java.io.IOException {
		try {
			FileWriter writer = new FileWriter(this.file, true);
			BufferedWriter buffer = new BufferedWriter(writer);

			buffer.write(data);
			buffer.newLine();
			buffer.close();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * getData Obtiene un ArrayList<String> del contenido del archivo de texto
	 *
	 * @return ArrayList<String> Retorna el contenido del archivo de texto
	 * @throws java.io.IOException
	 */
	public ArrayList<String> getData() throws java.io.IOException {
		ArrayList<String> data = new ArrayList();
		try {
			File archivoTexto = new File(this.file);
			if (!archivoTexto.exists()) {
				return data;
			}
			FileReader reader = new FileReader(this.file);
			BufferedReader buffer = new BufferedReader(reader);
			String datos;
			while ((datos = buffer.readLine()) != null) {
				data.add(datos);
			}
			reader.close();
			return data;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 *
	 * @param datoActual
	 * @param datoNuevo
	 * @throws IOException
	 */
	public void updateData(String datoActual, String datoNuevo) throws IOException {
		File archivoTexto = new File(this.file);
		String info = "";
		BufferedReader reader = null;
		FileWriter writer = null;
		String line;
		try {
			reader = new BufferedReader(new FileReader(archivoTexto));

			while ((line = reader.readLine()) != null) {
				info += line + System.lineSeparator();
			}
			String newInfo = info.replaceAll(datoActual, datoNuevo);
			writer = new FileWriter(archivoTexto);
			writer.write(newInfo);
		} catch (Exception e) {
		} finally {
			reader.close();
			writer.close();
		}
	}

	/**
	 *
	 * @param datoEliminar
	 * @throws IOException
	 */
	public void deleteData(String datoEliminar) throws IOException {
		File archivoTexto = new File(this.file);
		String info = "";
		BufferedReader reader = null;
		FileWriter writer = null;
		String line;
		try {
			reader = new BufferedReader(new FileReader(archivoTexto));

			while ((line = reader.readLine()) != null) {
				if (!datoEliminar.equals(line)) {
					info += line + System.lineSeparator();
				}
			}
			writer = new FileWriter(archivoTexto);
			writer.write(info);
		} catch (Exception e) {
		} finally {
			reader.close();
			writer.close();
		}
	}
}
