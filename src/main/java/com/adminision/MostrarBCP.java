package com.adminision; // En el paquete 'acciones'

import org.openxava.actions.*; // Necesario para usar OnChangePropertyAction,

public class MostrarBCP
    extends OnChangePropertyBaseAction { // Necesario para las acciones @OnChange (1)

    public void execute() throws Exception {

    	Boolean verBCP = (Boolean) getView().getValue("buscarBeneficiariosConPolizas");
    	Boolean verBCC = (Boolean) getView().getValue("buscarBeneficiariosConContrato");
    	Boolean verBH = (Boolean) getView().getValue("buscarBeneficiarioHabitual");
    	Boolean verBC = (Boolean) getView().getValue("buscarBeneficiarioDeLaClinica");

    	if ( verBCP == null ) verBCP = false;
    	if ( verBCC == null ) verBCC = false;
    	if ( verBH == null ) verBH = false;
    	if ( verBC == null ) verBC = false;
    	
    	if ( verBCP ) {
    		verBCC = false;
    		verBH = false;
    		verBC = false;
    		
//    		  getView().setEditable(false);
    		
        	getView().setValue("buscarBeneficiariosConContrato", false);
        	getView().setValue("buscarBeneficiarioHabitual", false);
        	getView().setValue("buscarBeneficiarioDeLaClinica", false);

        	getView().setValue("beneficiarioConContrato", null);
        	getView().setValue("beneficiarioHabitual", null);
        	getView().setValue("beneficiarioDeLaClinica", null);
        	
        	
    	}
    	if ( verBCC ) {
    		verBCP = false;
    		verBH = false;
    		verBC = false;
    		
        	getView().setValue("buscarBeneficiariosConPolizas", false);
        	getView().setValue("buscarBeneficiarioHabitual", false);
        	getView().setValue("buscarBeneficiarioDeLaClinica", false);
        	
        	getView().setValue("beneficiarioConPoliza", null);
        	getView().setValue("beneficiarioHabitual", null);
        	getView().setValue("beneficiarioDeLaClinica", null);
    		
    	}
    	if ( verBH ) {
    		verBCP = false;
    		verBCC = false;
    		verBC = false;
    		
        	getView().setValue("buscarBeneficiariosConPolizas", false);
        	getView().setValue("buscarBeneficiariosConContrato", false);
        	getView().setValue("buscarBeneficiarioDeLaClinica", false);

        	getView().setValue("beneficiarioConPoliza", null);
        	getView().setValue("beneficiarioConContrato", null);
        	getView().setValue("beneficiarioDeLaClinica", null);
        	
    	}
    	if ( verBC ) {
    		verBCP = false;
    		verBCC = false;
    		verBH = false;
    		
        	getView().setValue("buscarBeneficiariosConPolizas", false);
        	getView().setValue("buscarBeneficiariosConContrato", false);
        	getView().setValue("buscarBeneficiarioHabitual", false);

        	getView().setValue("beneficiarioConPoliza", null);
        	getView().setValue("beneficiarioConContrato", null);
        	getView().setValue("beneficiarioHabitual", null);
        	        	
    	}

    	
    	
    	
    	
    	/*
        if (estaPedidoCreado() && estaEntregado() && !tieneFactura()) { // (2)
            addActions("Pedido.crearFactura");
        }
        else {
            removeActions("Pedido.crearFactura");
        }
        */
    }
	
    /*
    private boolean estaPedidoCreado() {
        return getView().getValue("oid") != null; // Leemos el valor de la vista
    }
	
    private boolean estaEntregado() {
        Boolean entregado = (Boolean)
            getView().getValue("entregado"); // Leemos el valor de la vista
        return entregado == null?false:entregado;
    }

    private boolean tieneFactura() {
        return getView().getValue("factura.oid") != null; // Leemos el valor de la vista
    }
    */
}