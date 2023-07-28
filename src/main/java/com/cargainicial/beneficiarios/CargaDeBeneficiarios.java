package com.cargainicial.beneficiarios;
 
import java.time.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.extensiones.*;

import lombok.*;
 
@Entity  // Esto marca la clase Cliente como una entidad
@Getter @Setter // Esto hace los campos a continuación públicamente accesibles
@View(name="Simple", // Esta vista solo se usará cuando se especifique “Simple”
members="descripcion" // Muestra únicamente numero y nombre en la misma línea
)
@Tab(baseCondition = "${activo} = 1")
@Tab(name = "Procesados", baseCondition = "${activo} = 2")
public class CargaDeBeneficiarios extends Incrementable4 {

	@OnChange(MostrarCargarBeneficiarios.class) // A�ade esto
	
    @Column(length=30) // La longitud de columna se usa a nivel UI y a nivel DB
	String numeroGrupoFamiliar;
    
    @Column(length=30) // La longitud de columna se usa a nivel UI y a nivel DB
	String numeroDePersona;
	
    @Column(length=50) // La longitud de columna se usa a nivel UI y a nivel DB
	String nombrePrincipal;
    
    @Column(length=50) // La longitud de columna se usa a nivel UI y a nivel DB
	String apellidoPrincipal;

    @Column(length=50) // La longitud de columna se usa a nivel UI y a nivel DB
	String parentesco;

    @Column(length=30) // La longitud de columna se usa a nivel UI y a nivel DB
	String numeroDePersonaDependiente;

    @Column(length=50) // La longitud de columna se usa a nivel UI y a nivel DB
	String nombrePrincipalDependiente;
    
    @Column(length=50) // La longitud de columna se usa a nivel UI y a nivel DB
	String apellidoPrincipalDependiente;
    
    @Column(length=20) // La longitud de columna se usa a nivel UI y a nivel DB
	String sexo;

	LocalDate fechaDeNacimiento;

	Integer polizaAsociada;
	
	Integer contratoAsociado;
	
}