/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevoGestores;

import cl.Contrato;
import cl.Inquilino;
import cl.Propiedad;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import nuevaLogica.NuevaCapaLogica;

public class NuevoGestorContrato {
	
	public boolean registrarContrato(int codigoContrato, String cedulaInquilino, int codigoPropiedad, LocalDate fechaInicioVigencia, int duracionContrato, double montoAlquiler, double porcentajeAumentoAnual, String monedaPactada) throws IOException {
		NuevaCapaLogica ncl = new NuevaCapaLogica();
		
		Inquilino arrendatario = ncl.buscarInquilinoPorIdentificacion(cedulaInquilino);
		Propiedad propiedadAlquilar = ncl.buscarPropiedadPorCodigo(codigoPropiedad);
		
		Contrato nuevoContrato = new Contrato(codigoContrato, arrendatario, propiedadAlquilar, fechaInicioVigencia, duracionContrato, montoAlquiler, porcentajeAumentoAnual, monedaPactada);
		
		return ncl.registrarContrato(nuevoContrato);
	}
	
	public String buscarContratoPorCodigo(int pCodigo) throws IOException {
		String retorno = "";
		NuevaCapaLogica ncl = new NuevaCapaLogica();
		Contrato contratoEncontrado = ncl.buscarContratoPorCodigo(pCodigo);
		if (contratoEncontrado != null) {
			retorno = contratoEncontrado.toString();
		}
		return retorno;
	}
	
	public ArrayList<String> buscarContratoParaModificar(int pCodigo) throws IOException {
		NuevaCapaLogica ncl = new NuevaCapaLogica();
		return ncl.buscarContratoParaModificar(pCodigo);
	}
	
	public ArrayList<String> listarContratos() throws IOException {
		NuevaCapaLogica ncl = new NuevaCapaLogica();
		return ncl.listarContratos();
	}
	
	public ArrayList<String> listarContratosParaModificar() throws IOException {
		NuevaCapaLogica ncl = new NuevaCapaLogica();
		return ncl.listarContratosParaModificar();
	}
	
	public void modificarContrato(int codigoContrato, String cedulaInquilino, int codigoPropiedad, LocalDate fechaInicioVigencia, int duracionContrato, double montoAlquiler, double porcentajeAumentoAnual, String monedaPactada) throws IOException {
		NuevaCapaLogica ncl = new NuevaCapaLogica();
		
		Inquilino arrendatario = ncl.buscarInquilinoPorIdentificacion(cedulaInquilino);
		Propiedad propiedadAlquilar = ncl.buscarPropiedadPorCodigo(codigoPropiedad);
		
		Contrato contratoAModificar = new Contrato(codigoContrato, arrendatario, propiedadAlquilar, fechaInicioVigencia, duracionContrato, montoAlquiler, porcentajeAumentoAnual, monedaPactada);
		
		ncl.modificarContrato(contratoAModificar);
	}
}
