package com.reportes.cierre;

import java.util.*;

import javax.persistence.*;

import org.openxava.actions.*;
import org.openxava.jpa.*;
import org.openxava.model.*;

public class ProcesarCierre extends TabBaseAction {

	public void execute() throws Exception {

		EntityManagerFactory f = // Necesitas un EntityManagerFactory para crear un manager
		Persistence.createEntityManagerFactory("default");
		EntityManager manager = f.createEntityManager(); // Creas el manager
		manager.getTransaction().begin(); // Has de empezar una transacción

	    for (Map key: getTab().getAllKeys() ) { // (6)
	    	ReporteSaldosPendientes ben = (ReporteSaldosPendientes) MapFacade.findEntity("ReporteSaldosPendientes", key); // (7)
			XPersistence.getManager().remove(ben);
	    }

	    ReporteSaldosPendientes rsp = new ReporteSaldosPendientes();
	    rsp.setActivo(1);
	    rsp.setCodigo((long) 10);
	    rsp.setDescripcion("Empresa");
	    rsp.setSaldo((double) 10000);
		manager.persist(rsp);  // persist marca el objeto como persistente
	    
		manager.getTransaction().commit(); // Al confirmar la transacción los cambios se
		manager.close(); // Has de cerrar el manager
		
		addMessage("Cierre Procesado");
		
		return;
	}
	
	
}