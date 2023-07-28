package com.beneficiarios.clinica;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.beneficiarios.base.*;
import com.clientes.*;

import lombok.*;
@Entity @Getter @Setter
@View(name="Simple", // Esta vista solo se usará cuando se especifique “Simple”
members="numeroDePersonaDependiente,nombrePrincipalDependiente,apellidoPrincipalDependiente" // Muestra únicamente numero y nombre en la misma línea
)
@View(name="SimpleE", // Esta vista solo se usará cuando se especifique “Simple”
members=
"numeroDePersonaDependiente; nombrePrincipalDependiente; apellidoPrincipalDependiente"
		)

@View(name="SimpleEmp", // Esta vista solo se usará cuando se especifique “Simple”
members=
"numeroDePersona, nombrePrincipal, apellidoPrincipal"
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
"];contratoDeLaClinica;empladoDeLaClinica; puedeAvalar, puedeAutorizar"
)
*/
/*
@View( // Esta vista solo se usará cuando se especifique “Simple”
name="SimpleEmpleado",
members=
" Principal [" +
" numeroDePersona;" +
" nombrePrincipal;" +
" apellidoPrincipal;" +
"];" +
" sexo;" +
" fechaDeNacimiento;" +
" empladoDeLaClinica; puedeAvalar, puedeAutorizar"
)
*/
@Tab(name = "Autorizados", baseCondition = "${puedeAutorizar} = true")
@Tab(name = "Avalados", baseCondition = "${puedeAvalar} = true")
@Tab(name = "Empleados", baseCondition = "${empladoDeLaClinica} = true")
public class BeneficiariosDeLaClinica extends BeneficiariosBase {
	
    @Column(length=10) // La longitud de columna se usa a nivel UI y a nivel DB
    @Hidden
    String tipoDeBeneficiario = "BC";
	
	@ManyToOne( // La referencia se almacena como una relaciÃ³n en la base de datos
			fetch = FetchType.LAZY, // La referencia se carga bajo demanda
			optional = true) // La referencia puede estar sin valor
	@DescriptionsList // AsÃ­ la referencia se visualiza usando un combo
	ContratosClinica contratoDeLaClinica; // Una referencia Java convencional
	
	@Embedded
	DatosBasicosEmpleado datosBasicos;

	boolean empladoDeLaClinica;
	
   boolean puedeAvalar;
	   
   boolean puedeAutorizar;
	
}
