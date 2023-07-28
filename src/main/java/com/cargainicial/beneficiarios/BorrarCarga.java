package com.cargainicial.beneficiarios;

import java.util.*;

import javax.persistence.*;

import org.openxava.actions.*;
import org.openxava.jpa.*;
import org.openxava.model.*;

public class BorrarCarga extends TabBaseAction {

	public void execute() throws Exception {

		EntityManagerFactory f = // Necesitas un EntityManagerFactory para crear un manager
		Persistence.createEntityManagerFactory("default");
		EntityManager manager = f.createEntityManager(); // Creas el manager
		manager.getTransaction().begin(); // Has de empezar una transacción
		
		long son;
		son = (long) 0;
		
		// Cargar los Registros
	    Collection<CargaDeBeneficiarios> bens = new ArrayList<>();
	    for (Map key: getTab().getAllKeys() ) { // (6)
	    	CargaDeBeneficiarios ben = (CargaDeBeneficiarios) MapFacade.findEntity("CargaDeBeneficiarios", key); // (7)
			XPersistence.getManager().remove(ben);
			son++;
	    }
	    
		manager.getTransaction().commit(); // Al confirmar la transacción los cambios se
		manager.close(); // Has de cerrar el manager
		
		if ( son > 0 ) {
			addMessage("Registros Borrados");	
		} else {
			addMessage("No Existen Registro para Procesar");
		}
		
		return;
	}
	
	
}