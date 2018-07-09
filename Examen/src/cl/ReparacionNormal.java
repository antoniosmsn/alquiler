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
public class ReparacionNormal {
	private int codigoReparacionNormal;
	private String proveedor;
	private LocalDate fechaRealizacionTrabajo;
	private double costo;

	public ReparacionNormal() {
	}

	public ReparacionNormal(int codigo, String proveedor, LocalDate fechaRealizacionTrabajo, double costo) {
		this.codigoReparacionNormal = codigo;
		this.proveedor = proveedor;
		this.fechaRealizacionTrabajo = fechaRealizacionTrabajo;
		this.costo = costo;
	}

	public int getCodigo() {
		return codigoReparacionNormal;
	}

	public void setCodigo(int codigo) {
		this.codigoReparacionNormal = codigo;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public LocalDate getFechaRealizacionTrabajo() {
		return fechaRealizacionTrabajo;
	}

	public void setFechaRealizacionTrabajo(LocalDate fechaRealizacionTrabajo) {
		this.fechaRealizacionTrabajo = fechaRealizacionTrabajo;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	@Override
	public String toString() {
		return  "codigoReparacionNormal=" + codigoReparacionNormal + ", proveedor=" + proveedor + ", fechaRealizacionTrabajo=" + fechaRealizacionTrabajo + ", costo=" + costo + ',';
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
		ReparacionNormal other = (ReparacionNormal) otherObject;
		return (codigoReparacionNormal == other.codigoReparacionNormal);
	}
	
}
