package com.beneficiarios.empresas;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.beneficiarios.base.*;

import lombok.*;
@Entity @Getter @Setter
@View(name="Simple", // Esta vista solo se usará cuando se especifique “Simple”
members="numeroDePersonaDependiente,nombrePrincipalDependiente,apellidoPrincipalDependiente" // Muestra únicamente numero y nombre en la misma línea
)
@View(name="SimpleE", // Esta vista solo se usará cuando se especifique “Simple”
members=
"numeroDePersonaDependiente; nombrePrincipalDependiente; apellidoPrincipalDependiente"
		)
/*
@View( // Esta vista solo se usará cuando se especifique “Simple”
members=
" Principal [" +
" numeroGrupoFamiliar;" +
" numeroDePersona;" +
" nombrePrincipal;" +
" apellidoPrincipal;" +
"];" +
" Secundario [" +
" parentesco;" +
" numeroDePersonaDependiente;" +
" nombrePrincipalDependiente;" +
" apellidoPrincipalDependiente;" +
" sexo;" +
" fechaDeNacimiento;" +
"];contratoAsociado"
)

@Tab(
	    properties=" numeroGrupoFamiliar," +
	    		" numeroDePersona," +
	    		" nombrePrincipal," +
	    		" apellidoPrincipal," +
	    		" parentesco," +
	    		" numeroDePersonaDependiente," +
	    		" nombrePrincipalDependiente," +
	    		" apellidoPrincipalDependiente," +
	    		" sexo," +
	    		" fechaDeNacimiento,"+ 
	    		"contratoAsociado"
	)
*/
public class BeneficiariosConContratos extends BeneficiariosBase {

	
    @Column(length=10) // La longitud de columna se usa a nivel UI y a nivel DB
    @Hidden
    String tipoDeBeneficiario = "BC";

	
	@ManyToOne( // La referencia se almacena como una relaciÃ³n en la base de datos
			fetch = FetchType.LAZY, // La referencia se carga bajo demanda
			optional = true) // La referencia puede estar sin valor
	@DescriptionsList // AsÃ­ la referencia se visualiza usando un combo
	Contratos contratoAsociado; // Una referencia Java convencional
	
}
