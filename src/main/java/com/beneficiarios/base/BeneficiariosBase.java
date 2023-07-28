package com.beneficiarios.base;
 
import java.time.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.cargainicial.beneficiarios.*;
import com.extensiones.*;

import lombok.*;
 
@Entity  // Esto marca la clase Cliente como una entidad
@Getter @Setter // Esto hace los campos a continuación públicamente accesibles

@View(name="Simple", // Esta vista solo se usará cuando se especifique “Simple”
members="descripcion" // Muestra únicamente numero y nombre en la misma línea
)

@View(name="SimpleE", // Esta vista solo se usará cuando se especifique “Simple”
members="descripcion" // Muestra únicamente numero y nombre en la misma línea
)

public class BeneficiariosBase extends Incrementable4 {
 
	/*
	 @ManyToOne( // La referencia se almacena como una relaci�n en la base de datos
	            fetch=FetchType.LAZY, // La referencia se carga bajo demanda
	            optional=true) // La referencia puede estar sin valor
	        @DescriptionsList // As� la referencia se visualiza usando un combo
	        TipoDeInventario tipoDeInventario; // Una referencia Java convencional
	 */

/*
MSH_FAMILY_ID
PersNo	
Last name Principal	
First name Principal
Member
PersNo (Dependent)
First name (Dependent)	
Last name (Dependent)	
Gender Key	
Birth date
	
MSH_FAMILY_ID
Num_Personne
*
*
RELATIONSHIP
MSH_MEMBER_ID
DEP LAST NAME	
DEP FIRST NAME	
DEP GENDER	
DEP DOB
*/	
	
    @Column(length=30) // La longitud de columna se usa a nivel UI y a nivel DB
	String numeroGrupoFamiliar;

    @Column(length=30) // La longitud de columna se usa a nivel UI y a nivel DB
	String numeroDeBatch;

    @Column(length=30) // La longitud de columna se usa a nivel UI y a nivel DB
	String numeroDeAsegurado;
    
    @Column(length=30) // La longitud de columna se usa a nivel UI y a nivel DB
	String numeroDeDip;
    
    @Column(length=30) // La longitud de columna se usa a nivel UI y a nivel DB
	String numeroDePersona;
	
    @Column(length=50) // La longitud de columna se usa a nivel UI y a nivel DB
	String nombrePrincipal;
    
    @Column(length=50) // La longitud de columna se usa a nivel UI y a nivel DB
	String apellidoPrincipal;

	@ManyToOne( // La referencia se almacena como una relaciÃ³n en la base de datos
			fetch = FetchType.LAZY, // La referencia se carga bajo demanda
			optional = true) // La referencia puede estar sin valor
	@DescriptionsList // AsÃ­ la referencia se visualiza usando un combo
	Parentesco parentesco; // Una referencia Java convencional 
    
    @Column(length=30) // La longitud de columna se usa a nivel UI y a nivel DB
	String numeroDeBatchDependiente;

    @Column(length=30) // La longitud de columna se usa a nivel UI y a nivel DB
	String numeroDeAseguradoDependiente;
    
    @Column(length=30) // La longitud de columna se usa a nivel UI y a nivel DB
	String numeroDeDipDependiente;
	
	@Column(length=30) // La longitud de columna se usa a nivel UI y a nivel DB
	String numeroDePersonaDependiente;

    @Column(length=50) // La longitud de columna se usa a nivel UI y a nivel DB
	String nombrePrincipalDependiente;
    
    @Column(length=50) // La longitud de columna se usa a nivel UI y a nivel DB
	String apellidoPrincipalDependiente;
    
	@ManyToOne( // La referencia se almacena como una relaciÃ³n en la base de datos
			fetch = FetchType.LAZY, // La referencia se carga bajo demanda
			optional = true) // La referencia puede estar sin valor
	@DescriptionsList // AsÃ­ la referencia se visualiza usando un combo
	Sexo sexo; // Una referencia Java convencional 
    
	LocalDate fechaDeNacimiento;

}