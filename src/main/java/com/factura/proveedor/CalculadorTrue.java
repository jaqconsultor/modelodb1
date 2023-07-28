package com.factura.proveedor;

 
import org.openxava.calculators.*; // Para usar 'ICalculator'
 
public class CalculadorTrue implements ICalculator {
 
    public Object calculate() throws Exception {
    	boolean numero;
            numero = true;
        return numero;
    }
}