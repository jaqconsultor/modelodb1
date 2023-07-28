package com.invenario;

 
import javax.persistence.*;

import org.openxava.annotations.*;

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
"numeroDeDocumento, tipoDeDocumento,fecha;" + // Separados por coma significa en la misma línea
 // Punto y coma significa nueva línea
"detalles;totalCantidad" 
)

public class DocumentoDeEntrada extends DocumentoInventarioBase {

    @DefaultValueCalculator(CalculadorConsecutivoDocEntrada.class) // Fecha actual
    @ReadOnly
    int numeroDeDocumento;
    
    @DefaultValueCalculator(CalculadorTipoDocEntrada.class) // Fecha actual
    @ReadOnly
    @Column(length=10) // La longitud de columna se usa a nivel UI y a nivel DB
    String tipoDeDocumento;    
	
}

	
	
