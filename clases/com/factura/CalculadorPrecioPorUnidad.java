package com.factura; // En el paquete calculadores
 
//Para usar getManager()
import static org.openxava.jpa.XPersistence.getManager;

import org.openxava.calculators.*;

import com.yourcompany.farmacia.model.*;

import lombok.*;
 
public class CalculadorPrecioPorUnidad implements ICalculator {
 
    @Getter @Setter
    int codigoDelProducto;
 
    @Override
    public Object calculate() throws Exception {
    	CargaDeInventario producto = getManager() // getManager() de XPersistence
            .find(CargaDeInventario.class, codigoDelProducto); // Busca el producto
        return producto.getPrecioDeVenta();    // Retorna su precio
    }
 
}