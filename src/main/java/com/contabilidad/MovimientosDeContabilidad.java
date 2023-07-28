package com.contabilidad;
 


import java.time.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.extensiones.*;

import lombok.*;

@Entity @Getter @Setter
@View(name="Simple", // Esta vista solo se usará cuando se especifique “Simple”
members="descripcion" // Muestra únicamente numero y nombre en la misma línea
)
public class MovimientosDeContabilidad extends Incrementable2 {
	
	@Column(length=4)
    int anyoFiscal;
	
    String eventoQueLoGenera;
	
	Long numeroDeOperaccion;
 
	String numeroDeCuenta;
	
    LocalDate fechaDeOperacion;

    Double montoDebe;
    
    Double montoHaber;

    String conceptoDeLaOperacion;
	
}





