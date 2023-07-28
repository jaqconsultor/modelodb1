package com.factura; // En el paquete 'calculadores'
 
import org.openxava.calculators.*; // Para usar 'ICalculator'
 
public class CalculadorPorcentajeIVA implements ICalculator {
 
    public Object calculate() throws Exception {
        //return PreferenciasFacturacion.getPorcentajeIVADefecto();
        return 6;
    }
}