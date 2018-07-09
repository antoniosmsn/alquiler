/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import cl.CapaLogica;
import cl.Inquilino;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Manuel
 */
public class GestorInquilino {

	public boolean registrarInquilino(String nombre, String apellidos, String correoElectronico, String direccion, String telefono, String identificacion, char genero) throws IOException {
		boolean retorno = false;
		CapaLogica cl = new CapaLogica();
		Inquilino nuevoInquilino = new Inquilino(nombre, apellidos, correoElectronico, direccion, telefono, identificacion, genero);
		return cl.registrarInquilino(nuevoInquilino);
	}
	
	public ArrayList<String> listarInquilino() throws IOException {
		ArrayList<String> lista = new ArrayList<>();
		CapaLogica cl = new CapaLogica();
		lista = cl.listarInquilinoString();
		return lista;		
	}
}
