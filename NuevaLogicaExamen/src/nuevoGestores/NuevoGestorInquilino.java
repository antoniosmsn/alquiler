/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevoGestores;

import cl.Inquilino;
import gestores.GestorInquilino;
import java.io.IOException;
import java.util.ArrayList;
import nuevaLogica.NuevaCapaLogica;

/**
 *
 * @author Manuel
 */
public class NuevoGestorInquilino extends GestorInquilino {
	
	@Override
	public ArrayList<String> listarInquilino() throws IOException {
		ArrayList<String> lista = new ArrayList<>();
		NuevaCapaLogica cl = new NuevaCapaLogica();
		lista = cl.listarInquilino();
		return lista;
	}
	
	public String buscarInquilinoPorCedula(String pCedula) throws IOException {
		String retorno = "";
		NuevaCapaLogica ncl = new NuevaCapaLogica();
		Inquilino inquilinoEncontrado = ncl.buscarInquilinoPorIdentificacion(pCedula);
		if (inquilinoEncontrado != null) {
			retorno = inquilinoEncontrado.toString();
		}
		return retorno;
	}
	
	public ArrayList<String> listarInquilinosSinContrato() throws IOException {
		nuevaLogica.NuevaCapaLogica ncl = new NuevaCapaLogica();
		return ncl.listarInquilinosSinContrato();
	}
	
	public boolean inquilinoTieneContrato(String pCedula) throws IOException {
		nuevaLogica.NuevaCapaLogica ncl = new NuevaCapaLogica();
		return ncl.inquilinoTieneContrato(pCedula);
	}
	
}
