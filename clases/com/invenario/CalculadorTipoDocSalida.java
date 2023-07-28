package com.invenario;

 
import org.openxava.calculators.*; // Para usar 'ICalculator'
 
public class CalculadorTipoDocSalida implements ICalculator {
 
    public Object calculate() throws Exception {
    	String numero;
            numero = "SA";
        return numero;
    }
}