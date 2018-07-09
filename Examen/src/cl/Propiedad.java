/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl;

/**
 *
 * @author Manuel
 */
public class Propiedad {

	private int codigoPropiedad;
	private String nombrePropiedad;
	private double valorPropiedad;
	private String direccionPropiedad;
	private String residencial;
	private int numeroCasa;
	private boolean patio;
	private int numeroHabitaciones;

	public Propiedad() {
	}

	public Propiedad(int codigo, String nombre, double valor, String direccion, String residencial, int numeroCasa, boolean patio, int numeroHabitaciones) {
		this.codigoPropiedad = codigo;
		this.nombrePropiedad = nombre;
		this.valorPropiedad = valor;
		this.direccionPropiedad = direccion;
		this.residencial = residencial;
		this.numeroCasa = numeroCasa;
		this.patio = patio;
		this.numeroHabitaciones = numeroHabitaciones;
	}

	public int getCodigo() {
		return codigoPropiedad;
	}

	public void setCodigo(int codigo) {
		this.codigoPropiedad = codigo;
	}

	public String getNombre() {
		return nombrePropiedad;
	}

	public void setNombre(String nombre) {
		this.nombrePropiedad = nombre;
	}

	public double getValor() {
		return valorPropiedad;
	}

	public void setValor(double valor) {
		this.valorPropiedad = valor;
	}

	public String getDireccion() {
		return direccionPropiedad;
	}

	public void setDireccion(String direccion) {
		this.direccionPropiedad = direccion;
	}

	public String getResidencial() {
		return residencial;
	}

	public void setResidencial(String residencial) {
		this.residencial = residencial;
	}

	public int getNumeroCasa() {
		return numeroCasa;
	}

	public void setNumeroCasa(int numeroCasa) {
		this.numeroCasa = numeroCasa;
	}

	public boolean isPatio() {
		return patio;
	}

	public void setPatio(boolean patio) {
		this.patio = patio;
	}

	public int getNumeroHabitaciones() {
		return numeroHabitaciones;
	}

	public void setNumeroHabitaciones(int numeroHabitaciones) {
		this.numeroHabitaciones = numeroHabitaciones;
	}

	@Override
	public String toString() {
		return "codigoPropiedad=" + codigoPropiedad + ", nombrePropiedad=" + nombrePropiedad + ", valorPropiedad=" + valorPropiedad + ", direccionPropiedad=" + direccionPropiedad + ", residencial=" + residencial + ", numeroCasa=" + numeroCasa + ", patio=" + patio + ", numeroHabitaciones=" + numeroHabitaciones + ',';
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
		Propiedad other = (Propiedad) otherObject;
		return (codigoPropiedad == other.codigoPropiedad);
	}

}
