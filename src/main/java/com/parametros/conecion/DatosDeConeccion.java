package com.parametros.conecion;


public class DatosDeConeccion {

	String servidor = "jdbc:postgresql://localhost:5432/modelodbdb";
	String usuario = "postgres";
	String password = "password2017";
	
	public String getServidor() {
		return servidor;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public String getPassword() {
		return password;
	}
	
}
