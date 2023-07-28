package com.factura.proveedor;

 
import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;
 
@Entity @Getter @Setter 

@View(members= // Esta vista no tiene nombre, por tanto será la vista usada por defecto
"numero, tipoDeDocumento, fechaDeCreacion, fechaDeLDocumento;" + // Separados por coma significa en la misma línea
"proveedor;" + // Punto y coma significa nueva línea
"detalles;" +
"porcentajeIVA, iva, importeTotal;"
/*"porcentajeCliente, montoCliente;"+
"porcentajeEmpresa, montoEmpresa;"*/
)

public class OrdenDeCompraAlProveedor extends PedidoProveedorBase {

    @DefaultValueCalculator(CalculadorConsecutivoPedidoDeProveedor.class) // Fecha actual
    @ReadOnly
    int numero;
	
    @DefaultValueCalculator(CalculadorTipoPedidoProveedor.class) // Fecha actual
    @ReadOnly
    @Column(length=10) // La longitud de columna se usa a nivel UI y a nivel DB
    String tipoDeDocumento;
	
}

	
	
