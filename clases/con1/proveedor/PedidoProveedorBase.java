package com.factura.proveedor;

 
import java.math.*;
import java.time.*;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

import com.extensiones.*;
import com.factura.*;
import com.proveedores.*;

import lombok.*;
 
@Entity @Getter @Setter 
/*@View( extendsView="super.DEFAULT", // La vista por defecto
members="pedidos { pedidos } "
)*/
/*
@View( name="SinClienteNiPedidos", // Una vista llamada SinClienteNiPedidos
members=                       // que no incluye cliente ni pedidos
    "anyo, fecha;" +   // Ideal para usarse desde Pedido
    "detalles;" +
    "observaciones"
)*/
/*@View(members= // Esta vista no tiene nombre, por tanto ser� la vista usada por defecto
"anyo, tipoDeDocumento, fecha;" + // Separados por coma significa en la misma l�nea
"cliente;" + // Punto y coma significa nueva l�nea
"detalles;" +
"observaciones"
)*/
//@Tab(baseCondition = "${eliminado} = false") // Tab sin nombre, es el de por defecto
//@Tab(name="Eliminado", baseCondition = "${eliminado} = true") // Tab con nombre

@View(members= // Esta vista no tiene nombre, por tanto ser� la vista usada por defecto
"fechaDeCreacion, fechaDeLDocumento;" + // Separados por coma significa en la misma l�nea
"proveedor;" + // Punto y coma significa nueva l�nea
"detalles;" +
"porcentajeIVA, iva, importeTotal;"
/*"porcentajeCliente, montoCliente;"+
"porcentajeEmpresa, montoEmpresa;"*/
)

public class PedidoProveedorBase extends Incrementable4 {

    @Required
    @DefaultValueCalculator(CurrentLocalDateCalculator.class) // Fecha actual
    @ReadOnly
    LocalDate fechaDeCreacion;
	
    @Required
    @DefaultValueCalculator(CurrentLocalDateCalculator.class) // Fecha actual
    LocalDate fechaDeLDocumento;

    @ManyToOne(fetch=FetchType.LAZY, optional=false) // El cliente es obligatorio
    @ReferenceView("Simple") // La vista llamada 'Simple' se usar� para visualizar esta referencia
    Proveedores proveedor;

    @ElementCollection
    @ListProperties(
            "producto.numero, producto.descripciondelProducto, cantidad, precioPorUnidad, producto.tipoDeInventario.descripcion"
            )	
    Collection<Detalle> detalles;
    
    @Digits(integer=2, fraction=0) // Para indicar su tama�o
    @DefaultValueCalculator(CalculadorPorcentajeIVA.class)
    BigDecimal porcentajeIVA;
    
    @ReadOnly
    @Calculation("sum(detalles.importe) * porcentajeIVA / 100")
    BigDecimal iva;
  
    
    @ReadOnly
    @Calculation("sum(detalles.importe) + iva")    
    BigDecimal importeTotal;

    
    public String toString() {
        return "/" ;
    }

	
}

	
	
