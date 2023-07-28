package com.pedido;

 
import java.time.*;
import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

import com.configuracion.*;
import com.extensiones.*;
import com.factura.*;

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
"fecha;" + // Separados por coma significa en la misma línea
"coordinacionResponsable;" + // Punto y coma significa nueva línea
"detalles;totalCantidad" 
)

public class PedidoBase extends Incrementable4  {
	
    @Required
    @DefaultValueCalculator(CurrentLocalDateCalculator.class) // Fecha actual
    @ReadOnly
    LocalDate fecha;
	
    @ManyToOne( // La referencia se almacena como una relación en la base de datos
            fetch=FetchType.LAZY, // La referencia se carga bajo demanda
            optional=true) // La referencia puede estar sin valor
        @DescriptionsList // Así la referencia se visualiza usando un combo
        Coordinaciones coordinacionResponsable; // Una referencia Java convencional

    @ElementCollection
    @ListProperties(
            "producto.numero, producto.descripciondelProducto, cantidad, precioPorUnidad, producto.tipoDeInventario.descripcion"
            )	
    Collection<Detalle> detalles;
    
    @ReadOnly
    @Calculation("sum(detalles.cantidad)")
    Integer totalCantidad;
    
    public String toString() {
        return "/" ;
    }

	
}

	
	
