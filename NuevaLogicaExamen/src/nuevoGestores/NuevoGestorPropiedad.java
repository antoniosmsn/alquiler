/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevoGestores;

import gestores.GestorPropiedad;
import java.io.IOException;
import java.util.ArrayList;
import nuevaLogica.NuevaCapaLogica;

/**
 *
 * @author Manuel
 */
public class NuevoGestorPropiedad extends GestorPropiedad {

	public ArrayList<String> listarPropiedadesFull() throws IOException {
		nuevaLogica.NuevaCapaLogica ncl = new NuevaCapaLogica();
		return ncl.listarPropiedadesFull();
	}

	public ArrayList<String> listarPropiedadesSinAlquilar() throws IOException {
		nuevaLogica.NuevaCapaLogica ncl = new NuevaCapaLogica();
		return ncl.listarPropiedadesSinAlquilar();
	}

	public boolean propiedadTieneContrato(int pCodigo) throws IOException {
		nuevaLogica.NuevaCapaLogica ncl = new NuevaCapaLogica();
		return ncl.propiedadTieneContrato(pCodigo);
	}
}
