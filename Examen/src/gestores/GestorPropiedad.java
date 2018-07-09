/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import cl.CapaLogica;
import cl.Propiedad;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Manuel
 */
public class GestorPropiedad {

	public boolean registrarPropiedad(int codigo, String nombre, double valor, String direccion, String residencial, int numeroCasa, boolean patio, int numeroHabitaciones) throws IOException {
		boolean retorno = false;
		CapaLogica cl = new CapaLogica();
		Propiedad nuevaPropiedad = new Propiedad(codigo, nombre, valor, direccion, residencial, numeroCasa, patio, numeroHabitaciones);
		return cl.registrarPropiedad(nuevaPropiedad);
	}

	public ArrayList<String> listarPropiedades() throws IOException {
		CapaLogica cl = new CapaLogica();
		return cl.listarPropiedadesFull();
	}

	public String buscarPropiedadPorCodigo(int pCodigo) throws IOException {
		String retorno = "";
		CapaLogica cl = new CapaLogica();
		Propiedad propiedadEncontrada = cl.buscarPropiedadPorCodigo(pCodigo);
		if (propiedadEncontrada != null) {
			retorno = propiedadEncontrada.toString();
		}
		return retorno;
	}
}
