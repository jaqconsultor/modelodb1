package com.tuempresa.facturacion.modelo; // En el paquete 'calculadores'
 
import javax.persistence.*;

import org.openxava.calculators.*; // Para usar 'ICalculator'
import org.openxava.jpa.*;
 
public class CalcularFAC implements ICalculator {
 
    public Object calculate() throws Exception {
    	Long numero;
        Query query = XPersistence.getManager().createQuery(
                "select max(f.numero) from " +
                " Factura " + 
                " f ");
        Long ultimoNumero = (Long) query.getSingleResult();
            numero = ultimoNumero == null ? 1 : ultimoNumero + 1;
        return numero;
    }
}