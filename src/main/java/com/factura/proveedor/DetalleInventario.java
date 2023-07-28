package com.factura.proveedor;
 
import java.math.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.yourcompany.farmacia.model.*;

import lombok.*;
 
@Embeddable @Getter @Setter
public class DetalleInventario {
 
	@DefaultValueCalculator(Calculador1.class) // Fecha actual
    int cantidad;
 
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    CargaDeInventario producto;
    
    @Money
    @Depends("precioPorUnidad, cantidad") // precioPorUnidad en vez de producto.numero
    public BigDecimal getImporte() {
        if (precioPorUnidad == null) return BigDecimal.ZERO; // precioPorUnidad en vez de producto y producto.getPrecio()
        return new BigDecimal(cantidad).multiply(precioPorUnidad); // precioPorUnidad en vez de producto.getPrecio()
    }
    
    /*
    @DefaultValueCalculator(
    	    value=CalculadorPrecioPorUnidad.class, // Esta clase calcula el valor inicial
    	    properties=@PropertyValue(
    	        name="numeroProducto", // La propiedad numeroProducto del calculador...
    	        from="producto.numero") // ... se llena con el valor de producto.numero de la entidad
    	)
    */
    @Money
    BigDecimal precioPorUnidad; // Una propiedad persistente convencional

	@DefaultValueCalculator(Calculador0.class) // Fecha actual
    int cantidadRecibida;

    @Money
    @Depends("precioPorUnidad, cantidadRecibida") // precioPorUnidad en vez de producto.numero
    public BigDecimal getImporteTotalRecibido() {
        if (precioPorUnidad == null) return BigDecimal.ZERO; // precioPorUnidad en vez de producto y producto.getPrecio()
        return new BigDecimal(cantidadRecibida).multiply(precioPorUnidad); // precioPorUnidad en vez de producto.getPrecio()
    }
    
}