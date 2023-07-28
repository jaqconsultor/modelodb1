package com.pedido;

 
import org.openxava.calculators.*; // Para usar 'ICalculator'
 
public class CalculadorTipoNotaDeEntrega implements ICalculator {
 
    public Object calculate() throws Exception {
    	String numero;
            numero = "NE";
        return numero;
    }
}