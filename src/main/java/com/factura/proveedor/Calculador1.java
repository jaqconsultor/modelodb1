package com.factura.proveedor;

 
import org.openxava.calculators.*; // Para usar 'ICalculator'
 
public class Calculador1 implements ICalculator {
 
    public Object calculate() throws Exception {
    	int numero;
            numero = 1;
        return numero;
    }
}