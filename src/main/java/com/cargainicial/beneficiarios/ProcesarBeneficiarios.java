package com.cargainicial.beneficiarios;

import java.util.*;

import javax.persistence.*;

import org.openxava.actions.*;
import org.openxava.jpa.*;
import org.openxava.model.*;

import com.beneficiarios.aseguradoras.*;
import com.beneficiarios.empresas.*;

public class ProcesarBeneficiarios extends TabBaseAction {

	public void execute() throws Exception {
		
		// TODO Agregar un Registro en OPenxava
		// Como Agregar Un en Openxava
		Parentesco parentesco = new Parentesco();
		parentesco.setDescripcion("Esposo");
		parentesco.setActivo(1);
		XPersistence.getManager().persist(parentesco);
		
		// Modificar
		Parentesco parentesco1 = XPersistence.getManager().find(Parentesco.class, 1);
		parentesco1.setDescripcion("Esposo");

		// Borrar
		XPersistence.getManager().remove(parentesco1);
		
		// Leer Una Entidad
		Parentesco parentesco2 = (Parentesco) XPersistence.getManager().createQuery("from Parentesco p where p.id = 1 ").getSingleResult();
		
		// Leer Varias Entidades
		Parentesco parentesco3 = (Parentesco) XPersistence.getManager().createQuery("from Parentesco").getResultList();
	
		
		
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

    		Parentesco par = new Parentesco();
    		par.setId(1);
    		
    		Sexo sex = new Sexo();
    		sex.setId(1);

    		Contratos con = new Contratos();
    		con.setId(1);

    		Polizas pol = new Polizas();
    		pol.setId(1);
    		
	    	// buscar lo de la poliza
	    	if ( ( ben.getPolizaAsociada() != null ) ) {
	    		son++;
	    		BeneficiariosConPolizas bcp = new BeneficiariosConPolizas();
	    		bcp.setActivo(1);
	    		bcp.setDescripcion( ben.getDescripcion() );
	    		bcp.setApellidoPrincipal( ben.getApellidoPrincipal() );
	    		bcp.setApellidoPrincipalDependiente( ben.getApellidoPrincipalDependiente() );
	    		bcp.setFechaDeNacimiento( ben.getFechaDeNacimiento() );
	    		bcp.setNombrePrincipal( ben.getNombrePrincipal() );
	    		bcp.setNombrePrincipalDependiente( ben.getNombrePrincipalDependiente() );
	    		bcp.setNumeroDePersona( ben.getNumeroDePersona() );
	    		bcp.setNumeroDePersonaDependiente( ben.getNumeroDePersonaDependiente() );
	    		bcp.setNumeroGrupoFamiliar( ben.getNumeroGrupoFamiliar() );
	    		bcp.setParentesco(par);
	    		bcp.setPolizaAsociada(pol); 
	    		bcp.setSexo(sex);
	    		manager.persist(bcp);  // persist marca el objeto como persistente
	    	} else {

		    	// buscar lo del contrato
		    	if ( ( ben.getContratoAsociado() != null ) ) {
		    		son++;
		    		BeneficiariosConContratos bcc = new BeneficiariosConContratos();
		    		bcc.setActivo(1);
		    		bcc.setDescripcion( ben.getDescripcion() );
		    		bcc.setApellidoPrincipal( ben.getApellidoPrincipal() );
		    		bcc.setApellidoPrincipalDependiente( ben.getApellidoPrincipalDependiente() );
		    		bcc.setFechaDeNacimiento( ben.getFechaDeNacimiento() );
		    		bcc.setNombrePrincipal( ben.getNombrePrincipal() );
		    		bcc.setNombrePrincipalDependiente( ben.getNombrePrincipalDependiente() );
		    		bcc.setNumeroDePersona( ben.getNumeroDePersona() );
		    		bcc.setNumeroDePersonaDependiente( ben.getNumeroDePersonaDependiente() );
		    		bcc.setNumeroGrupoFamiliar( ben.getNumeroGrupoFamiliar() );
		    		bcc.setParentesco(par);
		    		bcc.setContratoAsociado(con); 
		    		bcc.setSexo(sex);
		    		manager.persist(bcc);  // persist marca el objeto como persistente
		    	}
	    		
	    	}
	    	
	    	
			XPersistence.getManager().remove(ben);
	    }
	    
		manager.getTransaction().commit(); // Al confirmar la transacción los cambios se
		manager.close(); // Has de cerrar el manager
		
		if ( son > 0 ) {
			addMessage("Proceso Culminado");	
		} else {
			addMessage("No Existen Registro para Procesar");
		}
		
		return;
	}
	
	
}