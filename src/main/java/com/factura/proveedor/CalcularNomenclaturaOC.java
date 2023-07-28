package com.factura.proveedor; // En el paquete 'calculadores'
 
import java.util.*;

import javax.persistence.*;

import org.openxava.calculators.*; // Para usar 'ICalculator'
import org.openxava.jpa.*;
 
public class CalcularNomenclaturaOC implements ICalculator {
 
    @SuppressWarnings("removal")
	public Object calculate() throws Exception {
    	String numero;
        Query query = XPersistence.getManager().createQuery(
                "select max(f.numero) from " +
                " OrdenDeCompraAlProveedor " + 
                " f ");
         Long ultimoNumero = (Long) query.getSingleResult();
         Long nNumero;
         nNumero = ultimoNumero == null ? 1 : ultimoNumero + 1;

        Calendar cal = Calendar.getInstance();
		cal.setTime(new java.util.Date());
        
        Long year = new Long(cal.get(Calendar.YEAR));
        Long mes = new Long(cal.get(Calendar.MONTH));
        Long dia = new Long(cal.get(Calendar.DAY_OF_MONTH));
        numero = "OC/" + nNumero.toString() + "/" +  year.toString() + "/" + mes.toString() + "/" + dia.toString() ; 
        
        return numero;
    }
}