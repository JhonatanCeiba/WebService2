package com.sample;

public class Usuario {
	private String nombre;
	private Integer sueldo;
	private String mensaje;
	
	Usuario(String nombre, Integer sueldo)
	{
		this.setNombre(nombre);
		this.setSueldo(sueldo);
		this.setMensaje("");
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getSueldo() {
		return sueldo;
	}

	public void setSueldo(Integer sueldo) {
		this.sueldo = sueldo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
