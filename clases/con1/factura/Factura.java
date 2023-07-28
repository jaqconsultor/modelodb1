package com.factura;

 
import java.math.*;
import java.time.*;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

import com.clientes.*;
import com.extensiones.*;

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
/*@View(members= // Esta vista no tiene nombre, por tanto será la vista usada por defecto
"anyo, tipoDeDocumento, fecha;" + // Separados por coma significa en la misma línea
"cliente;" + // Punto y coma significa nueva línea
"detalles;" +
"observaciones"
)*/
//@Tab(baseCondition = "${eliminado} = false") // Tab sin nombre, es el de por defecto
//@Tab(name="Eliminado", baseCondition = "${eliminado} = true") // Tab con nombre

@View(members= // Esta vista no tiene nombre, por tanto será la vista usada por defecto
"fechaDeCreacion, fechaDeLaFactura;" + // Separados por coma significa en la misma línea
"cliente;" + // Punto y coma significa nueva línea
"detalles;" +
"cantidad, porcentajeIVA, iva, importeTotal;"
/*"porcentajeCliente, montoCliente;"+
"porcentajeEmpresa, montoEmpresa;"*/
)

public class Factura extends Incrementable4 {

    @Required
    @DefaultValueCalculator(CurrentLocalDateCalculator.class) // Fecha actual
    @ReadOnly
    LocalDate fechaDeCreacion;
	
    @Required
    @DefaultValueCalculator(CurrentLocalDateCalculator.class) // Fecha actual
    LocalDate fechaDeLaFactura;

    @ManyToOne(fetch=FetchType.LAZY, optional=false) // El cliente es obligatorio
    @ReferenceView("Simple") // La vista llamada 'Simple' se usará para visualizar esta referencia
    Paciente cliente;

    @ElementCollection
    @ListProperties(
            "producto.numero, producto.descripciondelProducto, cantidad, precioPorUnidad, producto.tipoDeInventario.descripcion," +
                    "importe+[" +
                	"factura.porcentajeIVA," +
                	"factura.iva," +
                	"factura.importeTotal" +
                "]" 
            )	
    Collection<Detalle> detalles;
    
    @ReadOnly
    @Calculation("sum(detalles.cantidad)")
    Integer cantidad;
    
    @Digits(integer=2, fraction=0) // Para indicar su tamaño
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

	
	
