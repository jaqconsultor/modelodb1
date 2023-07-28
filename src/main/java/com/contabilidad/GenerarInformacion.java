package com.contabilidad;

import java.util.*;

import javax.persistence.*;

import org.openxava.actions.*;
import org.openxava.jpa.*;
import org.openxava.model.*;

public class GenerarInformacion extends TabBaseAction {

	public void execute() throws Exception {

		EntityManagerFactory f = // Necesitas un EntityManagerFactory para crear un manager
		Persistence.createEntityManagerFactory("default");
		EntityManager manager = f.createEntityManager(); // Creas el manager
		manager.getTransaction().begin(); // Has de empezar una transacción

	    for (Map key: getTab().getAllKeys() ) { // (6)
	    	MovimientosDeContabilidad ben = (MovimientosDeContabilidad) MapFacade.findEntity("MovimientosDeContabilidad", key); // (7)
			XPersistence.getManager().remove(ben);
	    }

	    MovimientosDeContabilidad rsp = new MovimientosDeContabilidad();
	    rsp.setActivo(1);
	    rsp.setAnyoFiscal(2023);
	    rsp.setEventoQueLoGenera("Facturacion");
	    rsp.setNumeroDeOperaccion((long) 1112);
	    rsp.setNumeroDeCuenta("01010120");
	    rsp.setMontoDebe((double) 10000);
	    rsp.setMontoHaber((double) 10000);
	    rsp.setConceptoDeLaOperacion("Factura Aprobada de Ejemplo");
		manager.persist(rsp);  // persist marca el objeto como persistente

		rsp = new MovimientosDeContabilidad();
	    rsp.setActivo(1);
	    rsp.setAnyoFiscal(2023);
	    rsp.setEventoQueLoGenera("Facturacion");
	    rsp.setNumeroDeOperaccion((long) 1112);
	    rsp.setNumeroDeCuenta("01010120");
	    rsp.setMontoDebe((double) 10000);
	    rsp.setMontoHaber((double) 10000);
	    rsp.setConceptoDeLaOperacion("Factura Aprobada de Ejemplo");
		manager.persist(rsp);  // persist marca el objeto como persistente

		rsp = new MovimientosDeContabilidad();
	    rsp.setActivo(1);
	    rsp.setAnyoFiscal(2023);
	    rsp.setEventoQueLoGenera("Compras");
	    rsp.setNumeroDeOperaccion((long) 1112);
	    rsp.setNumeroDeCuenta("01010120");
	    rsp.setMontoDebe((double) 10000);
	    rsp.setMontoHaber((double) 10000);
	    rsp.setConceptoDeLaOperacion("Compra Aprobada de Ejemplo");
		manager.persist(rsp);  // persist marca el objeto como persistente

		rsp = new MovimientosDeContabilidad();
	    rsp.setActivo(1);
	    rsp.setAnyoFiscal(2023);
	    rsp.setEventoQueLoGenera("Compra");
	    rsp.setNumeroDeOperaccion((long) 1112);
	    rsp.setNumeroDeCuenta("01010120");
	    rsp.setMontoDebe((double) 10000);
	    rsp.setMontoHaber((double) 10000);
	    rsp.setConceptoDeLaOperacion("Compra Aprobada de Ejemplo");
		manager.persist(rsp);  // persist marca el objeto como persistente
		
		manager.getTransaction().commit(); // Al confirmar la transacción los cambios se
		manager.close(); // Has de cerrar el manager
		
		addMessage("Informacion Generada");
		
		return;
	}
	
	
}