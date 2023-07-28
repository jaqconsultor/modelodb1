package com.factura.proveedor;

 
import org.openxava.calculators.*; // Para usar 'ICalculator'
 
public class CalculadorTipoFacturaProveedor implements ICalculator {
 
    public Object calculate() throws Exception {
    	String numero;
            numero = "FP";
        return numero;
    }
}