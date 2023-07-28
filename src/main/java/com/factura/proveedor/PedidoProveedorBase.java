package com.factura.proveedor;

 
import java.math.*;
import java.time.*;
import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

import com.extensiones.*;
import com.proveedor.*;

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

/*
@View(members= // Esta vista no tiene nombre, por tanto será la vista usada por defecto
"fechaDeCreacion, fechaDeLDocumento;" + // Separados por coma significa en la misma línea
"proveedor;" + // Punto y coma significa nueva línea
"detalles;" +
"porcentajeIVA, iva, importeTotal;"
/*"porcentajeCliente, montoCliente;"+
"porcentajeEmpresa, montoEmpresa;"*/
/*)*/

public class PedidoProveedorBase extends Incrementable4 {

    @Required
    @DefaultValueCalculator(CurrentLocalDateCalculator.class) // Fecha actual
    @ReadOnly
    LocalDate fechaDeCreacion;
	
    @Required
    @DefaultValueCalculator(CurrentLocalDateCalculator.class) // Fecha actual
    LocalDate fechaDelDocumento;

    @ManyToOne(fetch=FetchType.LAZY, optional=false) // El cliente es obligatorio
    @ReferenceView("Simple") // La vista llamada 'Simple' se usará para visualizar esta referencia
    Proveedores proveedor;
    
    @ElementCollection
    /*@ListProperties(
            "producto.codigoDelProducto, producto.descripciondelProducto, cantidad, precioPorUnidad, cantidadRecibida "
            )	*/
    /*
    @ListProperties(
            "producto.codigoDelProducto, producto.descripcionDelProducto, cantidad, precioPorUnidad, importe, cantidadRecibida, importeTotalRecibido" +
            " + "
            + "[" +
            	"pedidoProveedorBase.importeTotalSolicitado," +
            	"pedidoProveedorBase.importeTotalRecibido" +
            "]" 
        )	
    */
    Collection<DetalleInventario> detalles;
    
    /*
    @Digits(integer=2, fraction=0) // Para indicar su tamaño
    @DefaultValueCalculator(CalculadorPorcentajeIVA.class)
    BigDecimal porcentajeIVA;
    
    @ReadOnly
    @Calculation("sum(detalles.importe) * porcentajeIVA / 100")
    BigDecimal iva;
    */
    
    @ReadOnly
    @Calculation("sum(detalles.importe)")    
    BigDecimal importeTotalSolicitado;

    @ReadOnly
    @Calculation("sum(detalles.importeTotalRecibido)")    
    BigDecimal importeTotalRecibido;
    
    public String toString() {
        return "/" ;
    }

	
}

	
	
