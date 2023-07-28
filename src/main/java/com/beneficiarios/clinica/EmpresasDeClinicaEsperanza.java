package com.beneficiarios.clinica;
 
import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.beneficiarios.base.*;

import lombok.*;

@Entity @Getter @Setter
@View(name="Simple", // Esta vista solo se usará cuando se especifique “Simple”
members="descripcion" // Muestra únicamente numero y nombre en la misma línea
)
/*
@View(members= 
" descripcion; " +
" Facturacion [ requiereFacturaDetallada  ];" 
)*/

public class EmpresasDeClinicaEsperanza extends EmpresasBase {

    @Column(length=10) // La longitud de columna se usa a nivel UI y a nivel DB
    @Hidden
    String tipoDeBeneficiario = "CI";
	
	@ListProperties("id, descripcion")
    @OneToMany(mappedBy="empresaClinicaAsociada")
    Collection<ContratosClinica> contratoDeLaClinica;	
}





