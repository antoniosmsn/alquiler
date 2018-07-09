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
public class ReparacionProgramada {

	private int codigoReparacionProgramada;
	private String descripcion;
	private LocalDate fechaProgramada;

	public ReparacionProgramada() {
	}

	public ReparacionProgramada(int codigo, String descripcion, LocalDate fechaProgramada) {
		this.codigoReparacionProgramada = codigo;
		this.descripcion = descripcion;
		this.fechaProgramada = fechaProgramada;
	}

	public int getCodigo() {
		return codigoReparacionProgramada;
	}

	public void setCodigo(int codigo) {
		this.codigoReparacionProgramada = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDate getFechaProgramada() {
		return fechaProgramada;
	}

	public void setFechaProgramada(LocalDate fechaProgramada) {
		this.fechaProgramada = fechaProgramada;
	}

		@Override
	public String toString() {
		return  "codigoReparacionProgramada=" + codigoReparacionProgramada + ", descripcion=" + descripcion + ", fechaProgramada=" + fechaProgramada + ',';
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
		ReparacionProgramada other = (ReparacionProgramada) otherObject;
		return (codigoReparacionProgramada == other.codigoReparacionProgramada);
	}
}
