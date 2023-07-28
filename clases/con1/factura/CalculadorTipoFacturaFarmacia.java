package com.factura;

 
import org.openxava.calculators.*; // Para usar 'ICalculator'
 
public class CalculadorTipoFacturaFarmacia implements ICalculator {
 
    public Object calculate() throws Exception {
    	String numero;
            numero = "FA";
        return numero;
    }
}