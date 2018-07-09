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
public class Inquilino {

	private String nombreinquilino;
	private String apellidos;
	private String correoElectronico;
	private String direccionInquilino;
	private String telefono;
	private String cedula;
	private char genero;

	public Inquilino() {
	}

	public Inquilino(String nombre, String apellidos, String correoElectronico, String direccion, String telefono, String identificacion, char genero) {
		this.nombreinquilino = nombre;
		this.apellidos = apellidos;
		this.correoElectronico = correoElectronico;
		this.direccionInquilino = direccion;
		this.telefono = telefono;
		this.cedula = identificacion;
		this.genero = genero;
	}

	public String getNombre() {
		return nombreinquilino;
	}

	public void setNombre(String nombre) {
		this.nombreinquilino = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getDireccion() {
		return direccionInquilino;
	}

	public void setDireccion(String direccion) {
		this.direccionInquilino = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getIdentificacion() {
		return cedula;
	}

	public void setIdentificacion(String identificacion) {
		this.cedula = identificacion;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "nombreinquilino=" + nombreinquilino + ", apellidos=" + apellidos + ", correoElectronico=" + correoElectronico + ", direccionInquilino=" + direccionInquilino + ", telefono=" + telefono + ", cedula=" + cedula + ", genero=" + genero + ',';
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
		Inquilino other = (Inquilino) otherObject;
		return cedula.equals(other.cedula);
	}

}
