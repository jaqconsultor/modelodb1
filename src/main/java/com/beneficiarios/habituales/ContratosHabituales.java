package com.beneficiarios.habituales;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.beneficiarios.base.*;

import lombok.*;

@Entity @Getter @Setter
@View(name="Simple", // Esta vista solo se usará cuando se especifique “Simple”
members="descripcion" // Muestra únicamente numero y nombre en la misma línea
)
public class ContratosHabituales extends Convenio {

//    @DefaultValueCalculator(CalculadorConsecutivoFacturaAdministracion.class) // Fecha actual
    @ReadOnly
    @Hidden
    int numero;
	
//    @DefaultValueCalculator(CalculadorTipoFacturaAdministracion.class) // Fecha actual
    @ReadOnly
    @Hidden
    @Column(length=10) // La longitud de columna se usa a nivel UI y a nivel DB
    String tipo = "HAB";
    
	@ListProperties("id, descripcion")
    @OneToMany(mappedBy="contratoHabitualAsociado")
    Collection<BeneficiariosHabituales> beneficiariosHabituales;    
    
}
