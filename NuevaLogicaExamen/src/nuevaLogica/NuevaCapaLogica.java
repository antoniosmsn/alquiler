/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevaLogica;

import cl.Contrato;
import cl.Inquilino;
import cl.Propiedad;
import cl.ReparacionProgramada;
import cl.TextFileIO;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Manuel
 */
public class NuevaCapaLogica extends cl.CapaLogica {

	public ArrayList<String> listarInquilino() throws IOException {
		ArrayList<String> lista = new ArrayList<>();
		for (Inquilino inquilinodActual : listarInquilinosObjetos()) {
			String infoInquilino = "";
			String nombreCompleto = inquilinodActual.getNombre() + " " + inquilinodActual.getApellidos();
			String cedula = inquilinodActual.getIdentificacion();
			String telefono = inquilinodActual.getTelefono();
			String correo = inquilinodActual.getCorreoElectronico();

			infoInquilino = "Nombre: " + nombreCompleto + ", cédula: " + cedula + ", teléfono: " + telefono + ", correo: " + correo;
			lista.add(infoInquilino);
		}
		return lista;
	}

	public ArrayList<String> listarInquilinosSinContrato() throws IOException {
		ArrayList<String> lista = new ArrayList<>();
		for (Inquilino inquilinoActual : listarInquilinosObjetos()) {
			String infoInquilino = "";

			Contrato contratoEncontrado = null;
			contratoEncontrado = buscarContratoPorInquilino(inquilinoActual);

			if (contratoEncontrado == null) {

				String nombreCompleto = inquilinoActual.getNombre() + " " + inquilinoActual.getApellidos();
				String cedula = inquilinoActual.getIdentificacion();
				String telefono = inquilinoActual.getTelefono();
				String correo = inquilinoActual.getCorreoElectronico();

				infoInquilino = "Nombre: " + nombreCompleto + ", cédula: " + cedula + ", teléfono: " + telefono + ", correo: " + correo;
				lista.add(infoInquilino);
			}
		}
		return lista;
	}

	public boolean inquilinoTieneContrato(String pCedula) throws IOException {
		boolean retorno = false;
		Inquilino inquilinoEncontrado = buscarInquilinoPorIdentificacion(pCedula);

		if (inquilinoEncontrado != null) {
			Contrato contratoEncontrado = buscarContratoPorInquilino(inquilinoEncontrado);
			if (contratoEncontrado != null) {
				retorno = true;
			}
		}
		return retorno;
	}

	public ArrayList<String> listarPropiedadesSinAlquilar() throws IOException {
		ArrayList<String> lista = new ArrayList<>();
		for (Propiedad propiedadActual : listarPropiedadesObjetos()) {
			String infoDePropiedad = "";
			Contrato contratoEncontrado = null;

			contratoEncontrado = buscarContratoPorPropiedad(propiedadActual);

			if (contratoEncontrado == null) {
				String codigoPropiedad = String.valueOf(propiedadActual.getCodigo());
				String nombrePropiedad = propiedadActual.getNombre();
				String ubicacion = propiedadActual.getDireccion();
				String costo = String.valueOf(propiedadActual.getValor());

				infoDePropiedad = "Código: " + codigoPropiedad + ", Nombre: " + nombrePropiedad + ", ubicacion: " + ubicacion + ", costo: " + costo;
				lista.add(infoDePropiedad);
			}

		}
		return lista;
	}

	public boolean propiedadTieneContrato(int pCodigo) throws IOException {
		boolean retorno = false;
		Propiedad propiedadEncontrada = buscarPropiedadPorCodigo(pCodigo);

		if (propiedadEncontrada != null) {
			Contrato contratoEncontrado = buscarContratoPorPropiedad(propiedadEncontrada);
			if (contratoEncontrado != null) {
				retorno = true;
			}
		}
		return retorno;
	}

	//Debe mostrar la fecha de creación, el nombre de la propiedad y el nombre del inquilino
	public ArrayList<String> listarContratos() throws IOException {
		ArrayList<String> lista = new ArrayList<>();
		for (Contrato contratoActual : listarContratosObjetos()) {
			String infoDeContrato = "";
			infoDeContrato = "Fecha creación: " + contratoActual.getFechaInicioVigencia().toString()
					+ ", Nombre propiedad: " + contratoActual.getInmueble().getNombre()
					+ ", Inquilino: " + contratoActual.getArrendatario().getNombre()
					+ " " + contratoActual.getArrendatario().getApellidos();
			lista.add(infoDeContrato);

		}
		return lista;
	}

	public ArrayList<String> listarContratosParaModificar() throws IOException {
		ArrayList<String> lista = new ArrayList<>();
		for (Contrato contratoActual : listarContratosObjetos()) {
			String infoDeContrato = "";
			infoDeContrato = "Código contrato: " + String.valueOf(contratoActual.getCodigo())
					+ ", Fecha creación: " + contratoActual.getFechaInicioVigencia().toString()
					+ ", Nombre propiedad: " + contratoActual.getInmueble().getNombre()
					+ ", Inquilino: " + contratoActual.getArrendatario().getNombre()
					+ " " + contratoActual.getArrendatario().getApellidos();
			lista.add(infoDeContrato);
		}
		return lista;
	}

	/**
	 * Busca un contrato por código de contrato y retorna sus atributos en un ArrayList<String>
	 *
	 * @param pCodigo String Código del contrato a buscar
	 * @return ArrayList<String>
	 * <ul>
	 * <li>0-codigoContrato</li>
	 * <li>1-duracionContrato</li>
	 * <li>2-fechaInicioVigencia</li>
	 * <li>3-monedaPactada</li>
	 * <li>4-montoAlquiler</li>
	 * <li>5-porcentajeAumentoAnual</li>
	 * <li>6-Cedula inquilino</li>
	 * <li>7-codigo propiedad</li>
	 * </ul>
	 * @throws IOException
	 */
	public ArrayList<String> buscarContratoParaModificar(int pCodigo) throws IOException {
		ArrayList<String> listaAtributos = new ArrayList<>();

		Contrato contratoObtenido = buscarContratoPorCodigo(pCodigo);
		if (contratoObtenido != null) {
			listaAtributos.add(String.valueOf(contratoObtenido.getCodigo())); //codigoContrato
			listaAtributos.add(String.valueOf(contratoObtenido.getDuracionContrato())); //duracionContrato
			listaAtributos.add(contratoObtenido.getFechaInicioVigencia().toString()); //fechaInicioVigencia
			listaAtributos.add(contratoObtenido.getMonedaPactada()); //monedaPactada
			listaAtributos.add(String.valueOf(contratoObtenido.getMontoAlquiler())); //montoAlquiler
			listaAtributos.add(String.valueOf(contratoObtenido.getPorcentajeAumentoAnual())); //porcentajeAumentoAnual
			listaAtributos.add(contratoObtenido.getArrendatario().getIdentificacion()); //Cedula inquilino
			listaAtributos.add(String.valueOf(contratoObtenido.getInmueble().getCodigo())); //codigo propiedad
		}
		return listaAtributos;
	}

	public void modificarContrato(Contrato pContrato) throws IOException {
		Contrato contratoAntiguo = buscarContratoPorCodigo(pContrato.getCodigo());
		TextFileIO file = new TextFileIO("contratos.txt");
		file.updateData(contratoAntiguo.toString(), pContrato.toString());
	}

}
