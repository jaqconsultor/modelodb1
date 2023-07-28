package com.invenario;

 
import org.openxava.calculators.*; // Para usar 'ICalculator'
 
public class CalculadorTipoDocEntrada implements ICalculator {
 
    public Object calculate() throws Exception {
    	String numero;
            numero = "EN";
        return numero;
    }
}