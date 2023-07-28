package com.invenario;

 
import java.time.*;
import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

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
/*@View(members= // Esta vista no tiene nombre, por tanto ser� la vista usada por defecto
"anyo, tipoDeDocumento, fecha;" + // Separados por coma significa en la misma l�nea
"cliente;" + // Punto y coma significa nueva l�nea
"detalles;" +
"observaciones"
)*/
//@Tab(baseCondition = "${eliminado} = false") // Tab sin nombre, es el de por defecto
//@Tab(name="Eliminado", baseCondition = "${eliminado} = true") // Tab con nombre

@View(members= // Esta vista no tiene nombre, por tanto ser� la vista usada por defecto
"fecha;" + // Separados por coma significa en la misma l�nea
 // Punto y coma significa nueva l�nea
"detalles;totalCantidad" 
)

public class DocumentoInventarioBase extends Incrementable4  {
	
    @Required
    @DefaultValueCalculator(CurrentLocalDateCalculator.class) // Fecha actual
    @ReadOnly
    LocalDate fecha;
	
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

	
	
