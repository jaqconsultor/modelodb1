package com.configuracion;

import org.openxava.annotations.*;

public class Nomenclatura {

	String numeroDeFactura;
	
	public String getNumeroDeFactura() {
		return numeroDeFactura;
	}

	public void setNumeroDeFactura(String tipoDeFactura, Integer numeroDeFactura, DateTime fechaDeLaFactura ) {
		this.numeroDeFactura = tipoDeFactura.toUpperCase() + numeroDeFactura.toString() + fechaDeLaFactura.toString() ;
	}
	
}
