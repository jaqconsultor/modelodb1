package com.factura;

 
import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;
 
@Entity @Getter @Setter 


@View(members= // Esta vista no tiene nombre, por tanto será la vista usada por defecto
"numeroDeFactura, tipoDeFactura, fechaDeCreacion, fechaDeLaFactura;" + // Separados por coma significa en la misma línea
"cliente;" + // Punto y coma significa nueva línea
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

	
	
