package com.beneficiarios.aseguradoras;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.beneficiarios.base.*;

import lombok.*;

@Entity @Getter @Setter
@View(name="Simple", // Esta vista solo se usará cuando se especifique “Simple”
members="descripcion" // Muestra únicamente numero y nombre en la misma línea
)

public class Polizas extends Convenio {

//    @DefaultValueCalculator(CalculadorConsecutivoFacturaAdministracion.class) // Fecha actual
    @ReadOnly
    @Hidden
    int numero;
	
//    @DefaultValueCalculator(CalculadorTipoFacturaAdministracion.class) // Fecha actual
    @ReadOnly
    @Hidden
    @Column(length=10) // La longitud de columna se usa a nivel UI y a nivel DB
    String tipo = "POL";
	

	@ManyToOne( // La referencia se almacena como una relaciÃ³n en la base de datos
			fetch = FetchType.LAZY, // La referencia se carga bajo demanda
			optional = true) // La referencia puede estar sin valor
	@DescriptionsList // AsÃ­ la referencia se visualiza usando un combo
	EmpresasConAseguradoras empresaAseguradora; // Una referencia Java convencional    
	
	@ListProperties("id, descripcion")
    @OneToMany(mappedBy="polizaAsociada")
    Collection<BeneficiariosConPolizas> beneficiariosConPoliza;    

}
