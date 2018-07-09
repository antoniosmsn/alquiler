/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import nuevoGestores.NuevoGestorContrato;
import nuevoGestores.NuevoGestorInquilino;
import nuevoGestores.NuevoGestorPropiedad;

/**
 *
 * @author Manuel
 */
public class Main {//Inicializa las variables de entrada y salida del stream

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static PrintStream out = System.out;

	public static void main(String[] args) throws java.io.IOException {
		boolean salir = false;
		do {
			mostrarMensajeDeOpcion(mostrarMenuPrincipal());
			salir = ejecutarAccion(leerOpcion());
		} while (!salir);
	}

	static String mostrarMenuPrincipal() {
		String textoMenu = "";
		textoMenu = "\n\n********* Menú *********\n"
				+ "1.  Registrar propiedades.\n"
				+ "2.  Listar propiedades.\n"
				+ "3.  Buscar propiedades (según el código).\n"
				+ "4.  Registrar inquilinos.\n"
				+ "5.  Listar inquilinos. \n"
				+ "6.  Buscar inquilino. (según la cédula)\n"
				+ "7.  Registrar contrato de alquiler.\n"
				+ "8.  Modificar contrato de alquiler.\n"
				+ "9.  Listar contrato de alquiler.\n"
				+ "10. Programar reparaciones\n"
				+ "11. Registrar reparaciones.\n"
				+ "12. Listar reparaciones.\n"
				+ "0.  Salir.\n\n"
				+ "Opción: ";
		return textoMenu;
	}

	/**
	 * Muestra en mensaje para el usuario con enter al final
	 *
	 * @param pmensaje
	 */
	static void mostrarMensaje(String pmensaje) {
		out.println(pmensaje);
	}

	/**
	 * Muestra en mensaje para el usuario para luego leer una opción
	 *
	 * @param pmensaje
	 */
	static void mostrarMensajeDeOpcion(String pmensaje) {
		out.print(pmensaje);
	}

	/**
	 * Lee del teclado la opcion digitada
	 *
	 * @return Opcion digitada por el usuario
	 * @throws java.io.IOException
	 */
	static String leerOpcion() throws java.io.IOException {
		return in.readLine();
	}

	static boolean ejecutarAccion(String popcion) throws IOException {
		boolean salir = false;
		switch (popcion) {
			case "1": //Registrar propiedade
				registrarPropiedades();
				break;
			case "2": //Listar propiedades
				listarPropiedades();
				break;
			case "3": //Buscar propiedades
				buscarPropiedades();
				break;
			case "4": //Registrar inquilinos
				registrarInquilinos();
				break;
			case "5": //Listar inquilinos
				listarInquilinos();
				break;
			case "6": //Buscar inquilino
				buscarInquilino();
				break;
			case "7": //Registrar contrato de alquiler
				registrarContratoAlquiler();
				break;
			case "8": //Modificar contrato de alquiler
				modificarContratoAlquiler();
				break;
			case "9": //Listar contrato de alquiler
				listarContratoAlquiler();
				break;
			case "10": //Programar reparaciones
				programarRreparaciones();
				break;
			case "11": //Registrar reparaciones
				registrarReparaciones();
				break;
			case "12": //Listar reparaciones
				listarReparaciones();
				break;
			case "0": //Salir
				salir = true;
				break;
			default:
				mostrarMensaje("Opción digitada invalida");
				break;
		}
		return salir;
	}

	private static void registrarPropiedades() throws IOException {
		int codigoPropiedad;
		String nombrePropiedad;
		double valorPropiedad;
		String direccionPropiedad;
		String residencial;
		int numeroCasa;
		boolean patio = false;
		boolean patioEncontrado = false;
		int numeroHabitaciones;

		mostrarMensaje("******* Registro de Propiedad *******");

		mostrarMensajeDeOpcion("Digite el código de la Propiedad: ");
		codigoPropiedad = Integer.parseInt(leerOpcion());

		mostrarMensajeDeOpcion("Digite el nombre de la Propiedad: ");
		nombrePropiedad = leerOpcion();

		mostrarMensajeDeOpcion("Digite el valor de la Propiedad: ");
		valorPropiedad = Double.parseDouble(leerOpcion());

		mostrarMensajeDeOpcion("Digite el direccion de la Propiedad: ");
		direccionPropiedad = leerOpcion();

		mostrarMensajeDeOpcion("Digite el residencial de la Propiedad: ");
		residencial = leerOpcion();

		mostrarMensajeDeOpcion("Digite el número Casa: ");
		numeroCasa = Integer.parseInt(leerOpcion());

		do {
			mostrarMensaje("******* Seleccione si tiene patio *******");
			mostrarMensaje("1. Sí");
			mostrarMensaje("2. No");
			String restringidoString = leerOpcion();
			switch (restringidoString) {
				case "1":
					patio = true;
					patioEncontrado = true;
					break;
				case "2":
					patio = false;
					patioEncontrado = true;
					break;
				default:
					mostrarMensaje("Opción digitada invalida");
					break;
			}
		} while (!patioEncontrado);

		mostrarMensajeDeOpcion("Digite el número de Habitaciones: ");
		numeroHabitaciones = Integer.parseInt(leerOpcion());

		NuevoGestorPropiedad gestor = new NuevoGestorPropiedad();
		out.println();
		if (gestor.registrarPropiedad(codigoPropiedad, nombrePropiedad, valorPropiedad, direccionPropiedad, residencial, numeroCasa, patio, numeroHabitaciones)) {
			mostrarMensaje("Propiedad registrada correctamente");
		} else {
			mostrarMensaje("Error: el código de la propiedad ya se encuentra registrado");
		}
	}

	private static void listarPropiedades() throws IOException {
		NuevoGestorPropiedad gestor = new NuevoGestorPropiedad();
		out.println();
		mostrarMensaje("******* Información de Propiedades *******");
		for (String propiedad : gestor.listarPropiedadesFull()) {
			mostrarMensaje(propiedad);
		}
	}

	private static void listarPropiedadesSinAlquiler() throws IOException {
		NuevoGestorPropiedad gestor = new NuevoGestorPropiedad();
		out.println();
		mostrarMensaje("******* Información de Propiedades disponibles *******");
		for (String propiedad : gestor.listarPropiedadesSinAlquilar()) {
			mostrarMensaje(propiedad);
		}
	}

	private static void buscarPropiedades() throws IOException {
		mostrarMensaje("******* Buscar Propiedad *******");

		out.print("Digite el código de la Propiedad: ");
		NuevoGestorPropiedad gestor = new NuevoGestorPropiedad();
		String propiedadEncontrada = gestor.buscarPropiedadPorCodigo(Integer.parseInt(leerOpcion()));
		if (!propiedadEncontrada.equals("")) {
			out.println();
			mostrarMensaje("******* Información Propiedad encontrada *******");
			mostrarMensaje(propiedadEncontrada);
		} else {
			mostrarMensaje("******* Propiedad no encontrada *******");
		}
	}

	private static void registrarInquilinos() throws IOException {
		String nombreinquilino;
		String apellidos;
		String correoElectronico;
		String direccionInquilino;
		String telefono;
		String cedula;
		char genero = 'M';
		boolean generoEncontrado = false;

		mostrarMensaje("******* Registro de Inquilino *******");

		mostrarMensajeDeOpcion("Digite el nombre: ");
		nombreinquilino = leerOpcion();

		mostrarMensajeDeOpcion("Digite los apellidos: ");
		apellidos = leerOpcion();

		mostrarMensajeDeOpcion("Digite el correo electrónico: ");
		correoElectronico = leerOpcion();

		mostrarMensajeDeOpcion("Digite la dirección: ");
		direccionInquilino = leerOpcion();

		mostrarMensajeDeOpcion("Digite el telefono: ");
		telefono = leerOpcion();

		mostrarMensajeDeOpcion("Digite la cédula: ");
		cedula = leerOpcion();

		do {
			mostrarMensaje("******* Seleccione el género *******");
			mostrarMensaje("1. Masculino");
			mostrarMensaje("2. Femenino");
			String generoString = leerOpcion();
			switch (generoString) {
				case "1":
					genero = 'M';
					generoEncontrado = true;
					break;
				case "2":
					genero = 'F';
					generoEncontrado = true;
					break;
				default:
					mostrarMensaje("Opción digitada invalida");
					break;
			}
		} while (!generoEncontrado);

		NuevoGestorInquilino gestor = new NuevoGestorInquilino();
		out.println();
		if (gestor.registrarInquilino(nombreinquilino, apellidos, correoElectronico, direccionInquilino, telefono, cedula, genero)) {
			mostrarMensaje("Inquilino registrado correctamente");
		} else {
			mostrarMensaje("Error: el inquilino ya se encuentra registrado");
		}
	}

	private static void listarInquilinos() throws IOException {
		NuevoGestorInquilino gestor = new NuevoGestorInquilino();
		out.println();
		mostrarMensaje("******* Información de inquilinos *******");
		for (String inquilino : gestor.listarInquilino()) {
			mostrarMensaje(inquilino);
		}
	}

	private static void listarInquilinosSinContrato() throws IOException {
		NuevoGestorInquilino gestor = new NuevoGestorInquilino();
		out.println();
		mostrarMensaje("******* Información de inquilinos disponibles *******");
		for (String inquilino : gestor.listarInquilinosSinContrato()) {
			mostrarMensaje(inquilino);
		}
	}

	private static void buscarInquilino() throws IOException {
		mostrarMensaje("******* Buscar Inquilino *******");

		out.print("Digite la cédula del inquilino: ");
		NuevoGestorInquilino gestor = new NuevoGestorInquilino();
		String inquilinoEncontrado = gestor.buscarInquilinoPorCedula(leerOpcion());
		if (!inquilinoEncontrado.equals("")) {
			out.println();
			mostrarMensaje("******* Información inquilino encontrado *******");
			mostrarMensaje(inquilinoEncontrado);
		} else {
			mostrarMensaje("******* Inquilino no encontrado *******");
		}
	}

	private static void registrarContratoAlquiler() throws IOException {
		int codigoContrato;
		String cedulaInquilino;
		int codigoPropiedad;
		LocalDate fechaInicioVigencia;
		int duracionContrato;
		double montoAlquiler;
		double porcentajeAumentoAnual;
		String monedaPactada = "";
		boolean codigoPropiedadEncontrado = false;
		boolean cedulaEncontrada = false;
		boolean monedaEncontrada = false;
		boolean fechaEncontrada = false;
		boolean codigoContratoEncontrado = false;
		int anno, mes, dia;

		out.println();
		mostrarMensaje("******* Registro de contratos de alquiler *******");

		NuevoGestorInquilino gstrInquilino = new NuevoGestorInquilino();
		NuevoGestorPropiedad gstrPropiedad = new NuevoGestorPropiedad();
		NuevoGestorContrato gstrContrato = new NuevoGestorContrato();

		if (gstrInquilino.listarInquilinosSinContrato().size() > 0) {
			if (gstrPropiedad.listarPropiedadesSinAlquilar().size() > 0) {
				do {
					mostrarMensajeDeOpcion("Digite el Código contrato: ");
					codigoContrato = Integer.parseInt(leerOpcion());

					if ((gstrContrato.buscarContratoPorCodigo(codigoContrato)).equals("")) {
						codigoContratoEncontrado = true;
					} else {
						mostrarMensaje("Error: Código de contrato ya registrado");
					}
				} while (!codigoContratoEncontrado);

				do {
					listarPropiedadesSinAlquiler();
					mostrarMensajeDeOpcion("Digite el código de la Propiedad: ");

					codigoPropiedad = Integer.parseInt(leerOpcion());

					if (!gstrPropiedad.propiedadTieneContrato(codigoPropiedad)
							&& (!gstrPropiedad.buscarPropiedadPorCodigo(codigoPropiedad).equals(""))) {
						codigoPropiedadEncontrado = true;
					} else {
						mostrarMensajeDeOpcion("Código incorrecto");
					}
				} while (!codigoPropiedadEncontrado);

				do {
					listarInquilinosSinContrato();
					mostrarMensajeDeOpcion("Digite la cédula del inquilino: ");

					cedulaInquilino = leerOpcion();

					if (!gstrInquilino.inquilinoTieneContrato(cedulaInquilino)
							&& (!gstrInquilino.buscarInquilinoPorCedula(cedulaInquilino).equals(""))) {
						cedulaEncontrada = true;
					} else {
						mostrarMensaje("Cédula incorrecta");
					}
				} while (!cedulaEncontrada);

				do {
					mostrarMensaje("Seleccione la moneda del contrato");
					mostrarMensaje("1. Colones");
					mostrarMensaje("2. Dólares");
					String monedaLeida = leerOpcion();

					switch (monedaLeida) {
						case "1":
							monedaPactada = "Colones";
							monedaEncontrada = true;
							break;
						case "2":
							monedaPactada = "Dólares";
							monedaEncontrada = true;
							break;
						default:
							mostrarMensaje("Opción digitada invalida");
							break;
					}
				} while (!monedaEncontrada);

				mostrarMensajeDeOpcion("Digite la duración del contrato: ");
				duracionContrato = Integer.parseInt(leerOpcion());

				mostrarMensajeDeOpcion("Digite el monto del alquiler: ");
				montoAlquiler = Double.parseDouble(leerOpcion());

				mostrarMensajeDeOpcion("Digite el porcentaje de aumento anual: ");
				porcentajeAumentoAnual = Double.parseDouble(leerOpcion());

				do {
					mostrarMensaje("Fecha de inicio de vigencia del contrato");
					mostrarMensajeDeOpcion("Año: ");
					anno = Integer.parseInt(leerOpcion());
					mostrarMensajeDeOpcion("Mes: ");
					mes = Integer.parseInt(leerOpcion());
					mostrarMensajeDeOpcion("Día: ");
					dia = Integer.parseInt(leerOpcion());

					fechaInicioVigencia = LocalDate.of(anno, mes, dia);
					if (fechaInicioVigencia.isAfter(LocalDate.now())
							|| fechaInicioVigencia.isEqual(LocalDate.now())) {
						fechaEncontrada = true;
					} else {
						mostrarMensaje("Error: la fecha inicio vigencia no puede ser menor a hoy");
					}
				} while (!fechaEncontrada);

				out.println();
				if (gstrContrato.registrarContrato(codigoContrato, cedulaInquilino, codigoPropiedad, fechaInicioVigencia, duracionContrato, montoAlquiler, porcentajeAumentoAnual, monedaPactada)) {
					mostrarMensaje("Contrato registrado correctamente");
				} else {
					mostrarMensaje("Error: el código del contrato ya se encuentra registrado");
				}
			} else {
				mostrarMensaje("Error: no hay propiedades disponibles");
			}
		} else {
			mostrarMensaje("Error: no hay inquilinos disponibles");
		}
	}

	private static void modificarContratoAlquiler() throws IOException {
		int codigoContrato;
		String cedulaInquilino;
		int codigoPropiedad;
		LocalDate fechaInicioVigencia;
		int duracionContrato;
		double montoAlquiler;
		double porcentajeAumentoAnual;
		String monedaPactada = "";
		boolean codigoPropiedadEncontrado = false;
		boolean cedulaEncontrada = false;
		boolean monedaEncontrada = false;
		boolean fechaEncontrada = false;
		boolean codigoContratoEncontrado = false;
		int anno, mes, dia;
		ArrayList<String> datosContratoSeleccionado;
		String opcionLeida = "";

		out.println();
		mostrarMensaje("******* Modificación de contratos de alquiler *******");

		NuevoGestorInquilino gstrInquilino = new NuevoGestorInquilino();
		NuevoGestorPropiedad gstrPropiedad = new NuevoGestorPropiedad();
		NuevoGestorContrato gstrContrato = new NuevoGestorContrato();

		if (gstrContrato.listarContratos().size() > 0) {
			do {
				listarContratosParaModificar();
				out.println();
				mostrarMensajeDeOpcion("Digite el Código contrato que desea moficar: ");
				codigoContrato = Integer.parseInt(leerOpcion());

				if (!(gstrContrato.buscarContratoPorCodigo(codigoContrato)).equals("")) {
					codigoContratoEncontrado = true;
				} else {
					mostrarMensaje("Error: Código de contrato no existe");
				}
			} while (!codigoContratoEncontrado);

			/*
			* 0-codigoContrato	 * 1-duracionContrato	* 2-fechaInicioVigencia
			* 3-monedaPactada	 * 4-montoAlquiler		* 5-porcentajeAumentoAnual
			* 6-Cedula inquilino * 7-codigo propiedad
			 */
			datosContratoSeleccionado = gstrContrato.buscarContratoParaModificar(codigoContrato);
			codigoContrato = Integer.parseInt(datosContratoSeleccionado.get(0));
			duracionContrato = Integer.parseInt(datosContratoSeleccionado.get(1));
			fechaInicioVigencia = LocalDate.parse(datosContratoSeleccionado.get(2));
			monedaPactada = datosContratoSeleccionado.get(3);
			montoAlquiler = Double.parseDouble(datosContratoSeleccionado.get(4));
			porcentajeAumentoAnual = Double.parseDouble(datosContratoSeleccionado.get(5));
			cedulaInquilino = datosContratoSeleccionado.get(6);
			codigoPropiedad = Integer.parseInt(datosContratoSeleccionado.get(7));

			if (gstrPropiedad.listarPropiedadesSinAlquilar().size() > 0) {
				do {
					listarPropiedadesSinAlquiler();
					out.println();
					mostrarMensajeDeOpcion("Propiedad actual: " + codigoPropiedad
							+ ", presione enter para conservar el valor o digite el código de propiedad disponible: ");
					opcionLeida = leerOpcion();
					if (!opcionLeida.equals("")) {
						if (!opcionLeida.equals(String.valueOf(codigoPropiedad))) {
							if (!gstrPropiedad.propiedadTieneContrato(Integer.parseInt(opcionLeida))
									&& (!gstrPropiedad.buscarPropiedadPorCodigo(Integer.parseInt(opcionLeida)).equals(""))) {
								codigoPropiedad = Integer.parseInt(opcionLeida);
								codigoPropiedadEncontrado = true;
							} else {
								mostrarMensajeDeOpcion("Código incorrecto");
							}
						} else {
							codigoPropiedadEncontrado = true;
						}
					} else {
						codigoPropiedadEncontrado = true;
					}

				} while (!codigoPropiedadEncontrado);
			}

			if (gstrInquilino.listarInquilinosSinContrato().size() > 0) {
				do {
					listarInquilinosSinContrato();
					out.println();
					mostrarMensajeDeOpcion("Inquilino actual: " + cedulaInquilino
							+ ", presione enter para conservar el valor o digite la cédula del inquilino disponible: ");
					opcionLeida = leerOpcion();
					if (!opcionLeida.equals("")) {
						if (!opcionLeida.equals(cedulaInquilino)) {
							if (!gstrInquilino.inquilinoTieneContrato(opcionLeida)
									&& (!gstrInquilino.buscarInquilinoPorCedula(opcionLeida).equals(""))) {
								cedulaEncontrada = true;
								cedulaInquilino = opcionLeida;
							} else {
								mostrarMensaje("Cédula incorrecta");
							}
						} else {
							cedulaEncontrada = true;
						}
					} else {
						cedulaEncontrada = true;
					}
				} while (!cedulaEncontrada);
			}

			do {
				mostrarMensaje("Seleccione la moneda del contrato");
				mostrarMensaje("1. Colones");
				mostrarMensaje("2. Dólares");

				mostrarMensajeDeOpcion("Moneda actual: " + monedaPactada
						+ ", presione enter para conservar el valor o digite la nueva moneda: ");
				opcionLeida = leerOpcion();
				if (!opcionLeida.equals("")) {

					String monedaLeida = opcionLeida;

					switch (monedaLeida) {
						case "1":
							monedaPactada = "Colones";
							monedaEncontrada = true;
							break;
						case "2":
							monedaPactada = "Dólares";
							monedaEncontrada = true;
							break;
						default:
							mostrarMensaje("Opción digitada invalida");
							break;
					}
				} else {
					monedaEncontrada = true;
				}
			} while (!monedaEncontrada);

			mostrarMensajeDeOpcion("Duración del contrato actual: " + String.valueOf(duracionContrato)
					+ ", presione enter para conservar el valor o digite la nueva duración: ");
			opcionLeida = leerOpcion();
			if (!opcionLeida.equals("")) {
				duracionContrato = Integer.parseInt(opcionLeida);
			}

			mostrarMensajeDeOpcion("Monto del alquiler actual: " + String.valueOf(montoAlquiler)
					+ ", presione enter para conservar el valor o digite la nuevo monto: ");
			opcionLeida = leerOpcion();
			if (!opcionLeida.equals("")) {
				montoAlquiler = Double.parseDouble(opcionLeida);
			}

			mostrarMensajeDeOpcion("Porcentaje de aumento anual actual: " + String.valueOf(porcentajeAumentoAnual)
					+ ", presione enter para conservar el valor o digite el nuevo porcentaje: ");
			opcionLeida = leerOpcion();
			if (!opcionLeida.equals("")) {
				porcentajeAumentoAnual = Double.parseDouble(opcionLeida);
			}

			do {
				mostrarMensajeDeOpcion("Fecha de inicio de vigencia del contrato actual: " + fechaInicioVigencia.toString()
						+ ", presione enter para conservar el valor o digite 1 para cambiar la fecha: ");
				opcionLeida = leerOpcion();
				if (!opcionLeida.equals("")) {
					mostrarMensajeDeOpcion("Año: ");
					anno = Integer.parseInt(leerOpcion());
					mostrarMensajeDeOpcion("Mes: ");
					mes = Integer.parseInt(leerOpcion());
					mostrarMensajeDeOpcion("Día: ");
					dia = Integer.parseInt(leerOpcion());

					fechaInicioVigencia = LocalDate.of(anno, mes, dia);
					if (fechaInicioVigencia.isAfter(LocalDate.now())
							|| fechaInicioVigencia.isEqual(LocalDate.now())) {
						fechaEncontrada = true;
					} else {
						mostrarMensaje("Error: la fecha inicio vigencia no puede ser menor a hoy");
					}
				} else {
					fechaEncontrada = true;
				}
			} while (!fechaEncontrada);

			out.println();
			gstrContrato.modificarContrato(codigoContrato, cedulaInquilino, codigoPropiedad, fechaInicioVigencia, duracionContrato, montoAlquiler, porcentajeAumentoAnual, monedaPactada);
			mostrarMensaje("Contrato modificado correctamente");

		} else {
			mostrarMensaje("Error: no contratos para modificar");
		}
	}

	private static void listarContratosParaModificar() throws IOException {
		NuevoGestorContrato gestor = new NuevoGestorContrato();
		out.println();
		mostrarMensaje("******* Información de contratos *******");
		for (String contrato : gestor.listarContratosParaModificar()) {
			mostrarMensaje(contrato);
		}
	}

	private static void listarContratoAlquiler() throws IOException {
		NuevoGestorContrato gestor = new NuevoGestorContrato();
		out.println();
		mostrarMensaje("******* Información de Contratos *******");
		for (String contrato : gestor.listarContratos()) {
			mostrarMensaje(contrato);
		}
	}

	private static void programarRreparaciones() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	private static void registrarReparaciones() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	private static void listarReparaciones() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
