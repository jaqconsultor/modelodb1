package com.pedido;

 
import org.openxava.calculators.*; // Para usar 'ICalculator'
 
public class CalculadorTipoPedido implements ICalculator {
 
    public Object calculate() throws Exception {
    	String numero;
            numero = "PE";
        return numero;
    }
}