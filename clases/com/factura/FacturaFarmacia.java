package com.factura;

 
import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;
 
@Entity @Getter @Setter 


@View(members= // Esta vista no tiene nombre, por tanto ser� la vista usada por defecto
"numeroDeFactura, tipoDeFactura, fechaDeCreacion, fechaDeLaFactura;" + // Separados por coma significa en la misma l�nea
"cliente;" + // Punto y coma significa nueva l�nea
"detalles;" +
"porcentajeIVA, iva, importeTotal;"
/*"porcentajeCliente, montoCliente;"+
"porcentajeEmpresa, montoEmpresa;"*/
)
public class FacturaFarmacia extends Factura {

    @DefaultValueCalculator(CalculadorConsecutivoFacturaFarmacia.class) // Fecha actual
    @ReadOnly
    int numeroDeFactura;
	
    @DefaultValueCalculator(CalculadorTipoFacturaFarmacia.class) // Fecha actual
    @ReadOnly
    @Column(length=10) // La longitud de columna se usa a nivel UI y a nivel DB
    String tipoDeFactura;
	
}

	
	
