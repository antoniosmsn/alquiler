package cl;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class CapaLogica {

	/*Inicia propiedad*/
	public boolean registrarPropiedad(Propiedad pNuevaPropiedad) throws IOException {
		boolean registrado = false;
		if (buscarPropiedadPorCodigo(pNuevaPropiedad.getCodigo()) == null) {
			TextFileIO file = new TextFileIO("propiedades.txt");
			file.setData(pNuevaPropiedad.toString());
			registrado = true;
		}
		return registrado;
	}

	public ArrayList<String> listarPropiedadesString() throws IOException {
		TextFileIO file = new TextFileIO("propiedades.txt");
		return file.getData();
	}

	public Propiedad getPropiedadDesdeTxt(String pPropiedadTxt) {
		Propiedad retorno = null;
		int codigoPropiedad;
		String nombrePropiedad;
		double valorPropiedad;
		String direccionPropiedad;
		String residencial;
		int numeroCasa;
		boolean patio;
		int numeroHabitaciones;

		if (!pPropiedadTxt.equals("")) {

			String codigoString = pPropiedadTxt.substring(pPropiedadTxt.indexOf("codigo"));
			codigoPropiedad = Integer.parseInt(codigoString.substring(codigoString.indexOf("=") + 1, codigoString.indexOf(",")));

			nombrePropiedad = pPropiedadTxt.substring(pPropiedadTxt.indexOf("nombrePropiedad"));
			nombrePropiedad = nombrePropiedad.substring(nombrePropiedad.indexOf("=") + 1, nombrePropiedad.indexOf(","));

			String valorString = pPropiedadTxt.substring(pPropiedadTxt.indexOf("valorPropiedad"));
			valorPropiedad = Double.parseDouble(valorString.substring(valorString.indexOf("=") + 1, valorString.indexOf(",")));

			direccionPropiedad = pPropiedadTxt.substring(pPropiedadTxt.indexOf("direccionPropiedad"));
			direccionPropiedad = direccionPropiedad.substring(direccionPropiedad.indexOf("=") + 1, direccionPropiedad.indexOf(","));

			residencial = pPropiedadTxt.substring(pPropiedadTxt.indexOf("residencial"));
			residencial = residencial.substring(residencial.indexOf("=") + 1, residencial.indexOf(","));

			String numeroCasaString = pPropiedadTxt.substring(pPropiedadTxt.indexOf("numeroCasa"));
			numeroCasa = Integer.parseInt(numeroCasaString.substring(numeroCasaString.indexOf("=") + 1, numeroCasaString.indexOf(",")));

			String patioString = pPropiedadTxt.substring(pPropiedadTxt.indexOf("patio"));
			patio = Boolean.parseBoolean(patioString.substring(patioString.indexOf("=") + 1, patioString.indexOf(",")));

			String numeroHabitacionesString = pPropiedadTxt.substring(pPropiedadTxt.indexOf("numeroHabitaciones"));
			numeroHabitaciones = Integer.parseInt(numeroHabitacionesString.substring(numeroHabitacionesString.indexOf("=") + 1, numeroHabitacionesString.indexOf(",")));

			retorno = new Propiedad(codigoPropiedad, nombrePropiedad, valorPropiedad, direccionPropiedad, residencial, numeroCasa, patio, numeroHabitaciones);
		}
		return retorno;
	}

	public ArrayList<Propiedad> listarPropiedadesObjetos() throws IOException {
		ArrayList<Propiedad> lista = new ArrayList<>();
		for (String item : listarPropiedadesString()) {
			lista.add(getPropiedadDesdeTxt(item));
		}
		return lista;
	}

	public ArrayList<String> listarPropiedadesFull() throws IOException {
		ArrayList<String> lista = new ArrayList<>();
		for (Propiedad propiedadActual : listarPropiedadesObjetos()) {
			String infoDePropiedad = "";
			String nombrePropiedad = propiedadActual.getNombre();
			String ubicacion = propiedadActual.getDireccion();
			String costo = String.valueOf(propiedadActual.getValor());
			String alquilada = "No";
			Contrato contratoEncontrado = null;
			Inquilino inquilinoEncontrado = null;
			contratoEncontrado = buscarContratoPorPropiedad(propiedadActual);

			infoDePropiedad = "Nombre: " + nombrePropiedad + ", ubicacion: " + ubicacion + ", costo: " + costo;
			if (contratoEncontrado != null) {
				alquilada = "Si";
				infoDePropiedad += ", alquilada: " + alquilada;
				infoDePropiedad += ", inquilino: " + contratoEncontrado.getArrendatario().getNombre() + " " + contratoEncontrado.getArrendatario().getApellidos();
			}
			lista.add(infoDePropiedad);
		}
		return lista;
	}

	public Propiedad buscarPropiedadPorCodigo(int pCodigo) throws IOException {
		Propiedad retorno = null;
		for (Propiedad item : listarPropiedadesObjetos()) {
			if (pCodigo == item.getCodigo()) {
				retorno = item;
				break;
			}
		}
		return retorno;
	}

	/*Finaliza Propiedad*/
 /*Inicia inquilino*/
	public boolean registrarInquilino(Inquilino pNuevoInquilino) throws IOException {
		boolean registrado = false;
		if (buscarInquilinoPorIdentificacion(pNuevoInquilino.getIdentificacion()) == null) {
			TextFileIO file = new TextFileIO("inquilinos.txt");
			file.setData(pNuevoInquilino.toString());
			registrado = true;
		}
		return registrado;
	}

	public ArrayList<String> listarInquilinoString() throws IOException {
		TextFileIO file = new TextFileIO("inquilinos.txt");
		return file.getData();
	}

	public Inquilino getInquilinoDesdeTxt(String pInquilinoTxt) {
		Inquilino retorno = null;
		String nombreinquilino;
		String apellidos;
		String correoElectronico;
		String direccionInquilino;
		String telefono;
		String cedula;
		char genero;

		if (!pInquilinoTxt.equals("")) {

			nombreinquilino = pInquilinoTxt.substring(pInquilinoTxt.indexOf("nombreinquilino"));
			nombreinquilino = nombreinquilino.substring(nombreinquilino.indexOf("=") + 1, nombreinquilino.indexOf(","));

			apellidos = pInquilinoTxt.substring(pInquilinoTxt.indexOf("apellidos"));
			apellidos = apellidos.substring(apellidos.indexOf("=") + 1, apellidos.indexOf(","));

			correoElectronico = pInquilinoTxt.substring(pInquilinoTxt.indexOf("correoElectronico"));
			correoElectronico = correoElectronico.substring(correoElectronico.indexOf("=") + 1, correoElectronico.indexOf(","));

			direccionInquilino = pInquilinoTxt.substring(pInquilinoTxt.indexOf("direccionInquilino"));
			direccionInquilino = direccionInquilino.substring(direccionInquilino.indexOf("=") + 1, direccionInquilino.indexOf(","));

			telefono = pInquilinoTxt.substring(pInquilinoTxt.indexOf("telefono"));
			telefono = telefono.substring(telefono.indexOf("=") + 1, telefono.indexOf(","));

			cedula = pInquilinoTxt.substring(pInquilinoTxt.indexOf("cedula"));
			cedula = cedula.substring(cedula.indexOf("=") + 1, cedula.indexOf(","));

			String generoString = pInquilinoTxt.substring(pInquilinoTxt.indexOf("genero"));
			genero = generoString.substring(generoString.indexOf("=") + 1, generoString.indexOf(",")).charAt(0);

			retorno = new Inquilino(nombreinquilino, apellidos, correoElectronico, direccionInquilino, telefono, cedula, genero);
		}
		return retorno;
	}

	public ArrayList<Inquilino> listarInquilinosObjetos() throws IOException {
		ArrayList<Inquilino> lista = new ArrayList<>();
		for (String item : listarInquilinoString()) {
			lista.add(getInquilinoDesdeTxt(item));
		}
		return lista;
	}

	public Inquilino buscarInquilinoPorIdentificacion(String pIdentificacion) throws IOException {
		Inquilino retorno = null;
		for (Inquilino item : listarInquilinosObjetos()) {
			if (pIdentificacion.equals(item.getIdentificacion())) {
				retorno = item;
				break;
			}
		}
		return retorno;
	}

	/*Finaliza inquilino*/
 /*Inicia contrato*/
	public boolean registrarContrato(Contrato pNuevoContrato) throws IOException {
		boolean registrado = false;
		if (buscarContratoPorCodigo(pNuevoContrato.getCodigo()) == null) {
			TextFileIO file = new TextFileIO("contratos.txt");
			file.setData(pNuevoContrato.toString());
			registrado = true;
		}
		return registrado;
	}

	public ArrayList<String> listarContratoString() throws IOException {
		TextFileIO file = new TextFileIO("contratos.txt");
		return file.getData();
	}

	public Contrato getContratoDesdeTxt(String pContratoTxt) {
		Contrato retorno = null;
		int codigo;
		Inquilino arrendatario;
		Propiedad inmueble;
		LocalDate fechaInicioVigencia;
		int duracionContrato;
		double montoAlquiler;
		double porcentajeAumentoAnual;
		String monedaPactada;

		if (!pContratoTxt.equals("")) {

			String codigoString = pContratoTxt.substring(pContratoTxt.indexOf("codigo"));
			codigo = Integer.parseInt(codigoString.substring(codigoString.indexOf("=") + 1, codigoString.indexOf(",")));

			arrendatario = getInquilinoDesdeTxt(pContratoTxt);

			inmueble = getPropiedadDesdeTxt(pContratoTxt);

			String fechaInicioVigenciaString = pContratoTxt.substring(pContratoTxt.indexOf("fechaInicioVigencia"));
			fechaInicioVigencia = LocalDate.parse(fechaInicioVigenciaString.substring(fechaInicioVigenciaString.indexOf("=") + 1, fechaInicioVigenciaString.indexOf(",")));

			String duracionContratoString = pContratoTxt.substring(pContratoTxt.indexOf("duracionContrato"));
			duracionContrato = Integer.parseInt(duracionContratoString.substring(duracionContratoString.indexOf("=") + 1, duracionContratoString.indexOf(",")));

			String montoAlquilerString = pContratoTxt.substring(pContratoTxt.indexOf("montoAlquiler"));
			montoAlquiler = Double.parseDouble(montoAlquilerString.substring(montoAlquilerString.indexOf("=") + 1, montoAlquilerString.indexOf(",")));

			String porcentajeAumentoAnualString = pContratoTxt.substring(pContratoTxt.indexOf("porcentajeAumentoAnual"));
			porcentajeAumentoAnual = Double.parseDouble(porcentajeAumentoAnualString.substring(porcentajeAumentoAnualString.indexOf("=") + 1, porcentajeAumentoAnualString.indexOf(",")));

			String monedaPactadaString = pContratoTxt.substring(pContratoTxt.indexOf("monedaPactada"));
			monedaPactada = monedaPactadaString.substring(monedaPactadaString.indexOf("=") + 1, monedaPactadaString.indexOf(","));

			retorno = new Contrato(codigo, arrendatario, inmueble, fechaInicioVigencia, duracionContrato, montoAlquiler, porcentajeAumentoAnual, monedaPactada);
		}
		return retorno;
	}

	public ArrayList<Contrato> listarContratosObjetos() throws IOException {
		ArrayList<Contrato> lista = new ArrayList<>();
		for (String item : listarContratoString()) {
			lista.add(getContratoDesdeTxt(item));
		}
		return lista;
	}

	public Contrato buscarContratoPorCodigo(int pCodigo) throws IOException {
		Contrato retorno = null;
		for (Contrato item : listarContratosObjetos()) {
			if (pCodigo == item.getCodigo()) {
				retorno = item;
				break;
			}
		}
		return retorno;
	}

	public Contrato buscarContratoPorPropiedad(Propiedad pPropiedad) throws IOException {
		Contrato retorno = null;
		for (Contrato item : listarContratosObjetos()) {
			if (pPropiedad.equals(item.getInmueble())) {
				retorno = item;
				break;
			}
		}
		return retorno;
	}

	public Contrato buscarContratoPorInquilino(Inquilino pInquilino) throws IOException {
		Contrato retorno = null;
		for (Contrato item : listarContratosObjetos()) {
			if (pInquilino.equals(item.getArrendatario())) {
				retorno = item;
				break;
			}
		}
		return retorno;
	}

	/*Finaliza contrato*/
 /*Inicia reparacionNormal*/
	public boolean registrarReparacionNormal(ReparacionNormal pNuevoReparacionNormal) throws IOException {
		boolean registrado = false;
		if (buscarReparacionNormalPorCodigo(pNuevoReparacionNormal.getCodigo()) == null) {
			TextFileIO file = new TextFileIO("reparacionNormales.txt");
			file.setData(pNuevoReparacionNormal.toString());
			registrado = true;
		}
		return registrado;
	}

	public ArrayList<String> listarReparacionNormalString() throws IOException {
		TextFileIO file = new TextFileIO("reparacionNormales.txt");
		return file.getData();
	}

	public ReparacionNormal getReparacionNormalDesdeTxt(String pReparacionNormalTxt) {
		ReparacionNormal retorno = null;
		int codigoReparacionNormal;
		String proveedor;
		LocalDate fechaRealizacionTrabajo;
		double costo;

		if (!pReparacionNormalTxt.equals("")) {

			String codigoString = pReparacionNormalTxt.substring(pReparacionNormalTxt.indexOf("codigoReparacionNormal"));
			codigoReparacionNormal = Integer.parseInt(codigoString.substring(codigoString.indexOf("=") + 1, codigoString.indexOf(",")));

			String fechaRealizacionTrabajoString = pReparacionNormalTxt.substring(pReparacionNormalTxt.indexOf("fechaRealizacionTrabajo"));
			fechaRealizacionTrabajo = LocalDate.parse(fechaRealizacionTrabajoString.substring(fechaRealizacionTrabajoString.indexOf("=") + 1, fechaRealizacionTrabajoString.indexOf(",")));

			proveedor = pReparacionNormalTxt.substring(pReparacionNormalTxt.indexOf("proveedor"));
			proveedor = proveedor.substring(proveedor.indexOf("=") + 1, proveedor.indexOf(","));

			String costoString = pReparacionNormalTxt.substring(pReparacionNormalTxt.indexOf("costo"));
			costo = Double.parseDouble(costoString.substring(costoString.indexOf("=") + 1, costoString.indexOf(",")));

			retorno = new ReparacionNormal(codigoReparacionNormal, proveedor, fechaRealizacionTrabajo, costo);
		}
		return retorno;
	}

	public ArrayList<ReparacionNormal> listarReparacionNormalsObjetos() throws IOException {
		ArrayList<ReparacionNormal> lista = new ArrayList<>();
		for (String item : listarReparacionNormalString()) {
			lista.add(getReparacionNormalDesdeTxt(item));
		}
		return lista;
	}

	public ReparacionNormal buscarReparacionNormalPorCodigo(int pCodigo) throws IOException {
		ReparacionNormal retorno = null;
		for (ReparacionNormal item : listarReparacionNormalsObjetos()) {
			if (pCodigo == item.getCodigo()) {
				retorno = item;
				break;
			}
		}
		return retorno;
	}

	/*Finaliza reparacionNormal*/
 /*Inicia reparacionProgramada*/
	public boolean registrarReparacionProgramada(ReparacionProgramada pNuevoReparacionProgramada) throws IOException {
		boolean registrado = false;
		if (buscarReparacionProgramadaPorCodigo(pNuevoReparacionProgramada.getCodigo()) == null) {
			TextFileIO file = new TextFileIO("reparacionProgramadaes.txt");
			file.setData(pNuevoReparacionProgramada.toString());
			registrado = true;
		}
		return registrado;
	}

	public ArrayList<String> listarReparacionProgramadaString() throws IOException {
		TextFileIO file = new TextFileIO("reparacionProgramadaes.txt");
		return file.getData();
	}

	public ReparacionProgramada getReparacionProgramadaDesdeTxt(String pReparacionProgramadaTxt) {
		ReparacionProgramada retorno = null;
		int codigoReparacionProgramada;
		String descripcion;
		LocalDate fechaProgramada;

		if (!pReparacionProgramadaTxt.equals("")) {

			String codigoString = pReparacionProgramadaTxt.substring(pReparacionProgramadaTxt.indexOf("codigoReparacionProgramada"));
			codigoReparacionProgramada = Integer.parseInt(codigoString.substring(codigoString.indexOf("=") + 1, codigoString.indexOf(",")));

			String fechaProgramadaString = pReparacionProgramadaTxt.substring(pReparacionProgramadaTxt.indexOf("fechaProgramada"));
			fechaProgramada = LocalDate.parse(fechaProgramadaString.substring(fechaProgramadaString.indexOf("=") + 1, fechaProgramadaString.indexOf(",")));

			descripcion = pReparacionProgramadaTxt.substring(pReparacionProgramadaTxt.indexOf("descripcion"));
			descripcion = descripcion.substring(descripcion.indexOf("=") + 1, descripcion.indexOf(","));

			retorno = new ReparacionProgramada(codigoReparacionProgramada, descripcion, fechaProgramada);
		}
		return retorno;
	}

	public ArrayList<ReparacionProgramada> listarReparacionProgramadasObjetos() throws IOException {
		ArrayList<ReparacionProgramada> lista = new ArrayList<>();
		for (String item : listarReparacionProgramadaString()) {
			lista.add(getReparacionProgramadaDesdeTxt(item));
		}
		return lista;
	}

	public ReparacionProgramada buscarReparacionProgramadaPorCodigo(int pCodigo) throws IOException {
		ReparacionProgramada retorno = null;
		for (ReparacionProgramada item : listarReparacionProgramadasObjetos()) {
			if (pCodigo == item.getCodigo()) {
				retorno = item;
				break;
			}
		}
		return retorno;
	}

	/*Finaliza reparacionProgramada*/
}
