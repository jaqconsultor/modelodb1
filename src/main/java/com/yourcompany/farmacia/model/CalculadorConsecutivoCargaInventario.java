package com.yourcompany.farmacia.model; // En el paquete 'calculadores'
 
import javax.persistence.*;

import org.openxava.calculators.*; // Para usar 'ICalculator'
import org.openxava.jpa.*;
 
public class CalculadorConsecutivoCargaInventario implements ICalculator {
 
    public Object calculate() throws Exception {
    	Double numero;
        Query query = XPersistence.getManager().createQuery(
                "select max(f.codigoDelProducto) from " +
                " CargaDeInventario " + 
                " f ");
            Double ultimoNumero = (Double) query.getSingleResult();
            numero = ultimoNumero == null ? 1 : ultimoNumero + 1;
        return numero;
    }
}