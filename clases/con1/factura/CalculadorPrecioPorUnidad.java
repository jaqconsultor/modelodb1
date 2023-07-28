package com.factura; // En el paquete calculadores
 
//Para usar getManager()
import static org.openxava.jpa.XPersistence.getManager;

import org.openxava.calculators.*;

import com.productos.*;

import lombok.*;
 
public class CalculadorPrecioPorUnidad implements ICalculator {
 
    @Getter @Setter
    int numeroProducto;
 
    @Override
    public Object calculate() throws Exception {
        Inventario producto = getManager() // getManager() de XPersistence
            .find(Inventario.class, numeroProducto); // Busca el producto
        return producto.getPrecioDeVenta();    // Retorna su precio
    }
 
}