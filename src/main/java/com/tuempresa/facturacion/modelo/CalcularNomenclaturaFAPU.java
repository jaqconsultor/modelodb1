package com.tuempresa.facturacion.modelo; // En el paquete 'calculadores'
 
import java.util.*;

import javax.persistence.*;

import org.openxava.calculators.*; // Para usar 'ICalculator'
import org.openxava.jpa.*;
 
public class CalcularNomenclaturaFAPU implements ICalculator {
 
    @SuppressWarnings("removal")
	public Object calculate() throws Exception {
    	String numero;
    	 Query query = XPersistence.getManager().createQuery(
                 "select max(f.numero) from " +
                 " FacturaVentaAlPublico " + 
                 " f ");
         Long ultimoNumero = (Long) query.getSingleResult();
         Long nNumero;
         nNumero = ultimoNumero == null ? 1 : ultimoNumero + 1;

        Calendar cal = Calendar.getInstance();
		cal.setTime(new java.util.Date());
        
        Integer year = new Integer(cal.get(Calendar.YEAR));
        Integer mes = new Integer(cal.get(Calendar.MONTH));
        Integer dia = new Integer(cal.get(Calendar.DAY_OF_MONTH));
        numero = "FAR/" + nNumero.toString() + "/" +  year.toString() + "/" + mes.toString() + "/" + dia.toString() ; 
        
        return numero;
    }
}