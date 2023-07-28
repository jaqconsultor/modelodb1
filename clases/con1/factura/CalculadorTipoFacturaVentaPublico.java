package com.factura;

 
import org.openxava.calculators.*; // Para usar 'ICalculator'
 
public class CalculadorTipoFacturaVentaPublico implements ICalculator {
 
    public Object calculate() throws Exception {
    	String numero;
            numero = "FV";
        return numero;
    }
}