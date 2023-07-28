package com.factura.proveedor;

 
import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;
 
@Entity @Getter @Setter 

@View(members= // Esta vista no tiene nombre, por tanto será la vista usada por defecto
"numero, tipoDeDocumento; fechaDeCreacion, fechaDelDocumento; nomenclatura; numeroDocumento;" + // Separados por coma significa en la misma línea
"proveedor;" + // Punto y coma significa nueva línea
"detalles;" +
"importeTotalSolicitado; importeTotalRecibido; pedidoCerrado;"
/*"porcentajeCliente, montoCliente;"+
"porcentajeEmpresa, montoEmpresa;"*/
)

@Tab(baseCondition = "${pedidoCerrado} = false")
@Tab(name="OrdenesAbiertas",baseCondition = "${pedidoCerrado} = false")
@Tab(name="OrdenesCerradas",baseCondition = "${pedidoCerrado} = true")
public class OrdenDeCompraAlProveedor extends PedidoProveedorBase {

    @AddAction("CerrarOrden")
	
    @DefaultValueCalculator(CalculadorConsecutivoPedidoDeProveedor.class) // Fecha actual
    @ReadOnly
    Long numero;
	
    @DefaultValueCalculator(CalculadorTipoPedidoProveedor.class) // Fecha actual
    @ReadOnly
    @Column(length=10) // La longitud de columna se usa a nivel UI y a nivel DB
    String tipoDeDocumento;
	
    @Column(length=255) // La longitud de columna se usa a nivel UI y a nivel DB
    @ReadOnly
    @DefaultValueCalculator(CalcularNomenclaturaOC.class) // Fecha actual
    String nomenclatura;

    @Column(length=50) // La longitud de columna se usa a nivel UI y a nivel DB
    String numeroDocumento;
    
    @DefaultValueCalculator(CalculadorFalse.class) // Fecha actual
    @ReadOnly
    Boolean pedidoCerrado;
    
}

	
	
