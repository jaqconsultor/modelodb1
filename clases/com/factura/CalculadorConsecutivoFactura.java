package com.factura;

 
import javax.persistence.*;

import org.openxava.calculators.*; // Para usar 'ICalculator'
import org.openxava.jpa.*;
 
public class CalculadorConsecutivoFactura implements ICalculator {
 
    public Object calculate() throws Exception {
    	int numero;
        Query query = XPersistence.getManager().createQuery(
                "select max(f.numeroDeFactura) from " +
                " Factura " + 
                " f ");
            Integer ultimoNumero = (Integer) query.getSingleResult();
            numero = ultimoNumero == null ? 1 : ultimoNumero + 1;
        return numero;
    }
}