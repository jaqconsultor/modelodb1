package com.cargainicial.beneficiarios;

import org.openxava.actions.*; // Necesario para usar OnChangePropertyAction,

public class MostrarCargarBeneficiarios
    extends OnChangePropertyBaseAction { // Necesario para las acciones @OnChange (1)

    public void execute() throws Exception {
    	addActions("Procesar.proceso");
   	}
    
}