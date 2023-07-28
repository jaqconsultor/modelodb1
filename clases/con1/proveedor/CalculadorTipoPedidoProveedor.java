package com.factura.proveedor;

 
import org.openxava.calculators.*; // Para usar 'ICalculator'
 
public class CalculadorTipoPedidoProveedor implements ICalculator {
 
    public Object calculate() throws Exception {
    	String numero;
            numero = "OC";
        return numero;
    }
}