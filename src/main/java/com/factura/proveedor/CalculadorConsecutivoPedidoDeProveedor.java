package com.factura.proveedor;

 
import javax.persistence.*;

import org.openxava.calculators.*; // Para usar 'ICalculator'
import org.openxava.jpa.*;
 
public class CalculadorConsecutivoPedidoDeProveedor implements ICalculator {
 
    public Object calculate() throws Exception {
    	Long numero;
        Query query = XPersistence.getManager().createQuery(
                "select max(f.numero) from " +
                " OrdenDeCompraAlProveedor " + 
                " f ");
            Long ultimoNumero = (Long) query.getSingleResult();
            numero = ultimoNumero == null ? 1 : ultimoNumero + 1;
        return numero;
    }
}