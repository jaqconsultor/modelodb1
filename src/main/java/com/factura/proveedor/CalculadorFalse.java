package com.factura.proveedor;

 
import org.openxava.calculators.*; // Para usar 'ICalculator'
 
public class CalculadorFalse implements ICalculator {
 
    public Object calculate() throws Exception {
    	boolean numero;
            numero = false;
        return numero;
    }
}