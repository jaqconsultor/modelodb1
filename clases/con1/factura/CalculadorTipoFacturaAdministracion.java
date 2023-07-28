package com.factura;

 
import org.openxava.calculators.*; // Para usar 'ICalculator'
 
public class CalculadorTipoFacturaAdministracion implements ICalculator {
 
    public Object calculate() throws Exception {
    	String numero;
            numero = "AD";
        return numero;
    }
}