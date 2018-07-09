/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl;

import java.time.LocalDate;

/**
 *
 * @author Manuel
 */
public class Contrato {

	private int codigoContrato;
	private Inquilino arrendatario;
	private Propiedad inmueble;
	private LocalDate fechaInicioVigencia;
	private int duracionContrato;
	private double montoAlquiler;
	private double porcentajeAumentoAnual;
	private String monedaPactada;

	public Contrato() {
	}

	public Contrato(int codigo, Inquilino arrendatario, Propiedad inmueble, LocalDate fechaInicioVigencia, int duracionContrato, double montoAlquiler, double porcentajeAumentoAnual, String monedaPactada) {
		this.codigoContrato = codigo;
		this.arrendatario = arrendatario;
		this.inmueble = inmueble;
		this.fechaInicioVigencia = fechaInicioVigencia;
		this.duracionContrato = duracionContrato;
		this.montoAlquiler = montoAlquiler;
		this.porcentajeAumentoAnual = porcentajeAumentoAnual;
		this.monedaPactada = monedaPactada;
	}

	

	public int getCodigo() {
		return codigoContrato;
	}

	public void setCodigo(int codigo) {
		this.codigoContrato = codigo;
	}

	public Inquilino getArrendatario() {
		return arrendatario;
	}

	public void setArrendatario(Inquilino arrendatario) {
		this.arrendatario = arrendatario;
	}

	public Propiedad getInmueble() {
		return inmueble;
	}

	public void setInmueble(Propiedad inmueble) {
		this.inmueble = inmueble;
	}

	public LocalDate getFechaInicioVigencia() {
		return fechaInicioVigencia;
	}

	public void setFechaInicioVigencia(LocalDate fechaInicioVigencia) {
		this.fechaInicioVigencia = fechaInicioVigencia;
	}

	public int getDuracionContrato() {
		return duracionContrato;
	}

	public void setDuracionContrato(int duracionContrato) {
		this.duracionContrato = duracionContrato;
	}

	public double getMontoAlquiler() {
		return montoAlquiler;
	}

	public void setMontoAlquiler(double montoAlquiler) {
		this.montoAlquiler = montoAlquiler;
	}

	public double getPorcentajeAumentoAnual() {
		return porcentajeAumentoAnual;
	}

	public void setPorcentajeAumentoAnual(double porcentajeAumentoAnual) {
		this.porcentajeAumentoAnual = porcentajeAumentoAnual;
	}

	public String getMonedaPactada() {
		return monedaPactada;
	}

	public void setMonedaPactada(String monedaPactada) {
		this.monedaPactada = monedaPactada;
	}

	public LocalDate getfechaFinVigencia() {
		return LocalDate.now();
	}

	@Override
	public String toString() {
		return "codigoContrato=" + codigoContrato + ", arrendatario=" + arrendatario.toString() + ", inmueble=" + inmueble.toString() + ", fechaInicioVigencia=" + fechaInicioVigencia + ", duracionContrato=" + duracionContrato + ", montoAlquiler=" + montoAlquiler + ", porcentajeAumentoAnual=" + porcentajeAumentoAnual + ", monedaPactada=" + monedaPactada + ',';
	}
	
	@Override
	public boolean equals(Object otherObject) {
		if (this == otherObject) {
			return true;
		}
		if (otherObject == null) {
			return false;
		}

		if (otherObject.getClass() != this.getClass()) {
			return false;
		}
		Contrato other = (Contrato) otherObject;
		return (codigoContrato == other.codigoContrato);
	}
	
}
