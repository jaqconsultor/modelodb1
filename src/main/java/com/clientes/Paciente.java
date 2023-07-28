package com.clientes;
 
import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;


@Entity @Getter @Setter
@View(name = "Simple", // Esta vista solo se usarÃ¡ cuando se especifique âSimpleâ
		members = "id, descripcion" // Muestra Ãºnicamente numero y nombre en la misma lÃ­nea
)
@View(name = "SimpleE", // Esta vista solo se usarÃ¡ cuando se especifique âSimpleâ
	members = "id, descripcion" // Muestra Ãºnicamente numero y nombre en la misma lÃ­nea
)
/*
@View( // Esta vista solo se usarÃ¡ cuando se especifique âSimpleâ
members = "descripcion, pacienteActivo, Datos Basicos { datosBasicos } De Identificacion { datosDeIdentificacion } De Contacto { datosDeContacto } De Profesion { datosDeProfesion } De Ubicacion { datosDeUbicacion } De Correo{ datosRedesSociales } " // Muestra Ãºnicamente numero y nombre en la misma lÃ­nea
)
*/
/*
@Tab(
		baseCondition = "${pacienteActivo} = true",
		properties="descripcion, datosDeIdentificacion.numeroHistoriaClinica,datosDeIdentificacion.numeroDePersona,datosBasicos.fechaDeIngreso,datosBasicos.sexo,datosBasicos.fechaDeNacimiento,datosBasicos.edad,datosBasicos.estadoCivil,datosBasicos.lugarDeNacimiento"
)*/

@Tab(name = "Inactivos", baseCondition = "${pacienteActivo} = false")
@Tab(name = "Activos", baseCondition = "${pacienteActivo} = true")
public class Paciente extends ClienteBase {

/*	@ManyToOne( // La referencia se almacena como una relaciÃ³n en la base de datos
			fetch = FetchType.LAZY, // La referencia se carga bajo demanda
			optional = true) // La referencia puede estar sin valor
	@DescriptionsList // AsÃ­ la referencia se visualiza usando un combo
	Empresa empresa; // Una referencia Java convencional
*/
	
    @Column(length=10) // La longitud de columna se usa a nivel UI y a nivel DB
    @Hidden
    String tipoDeCliente = "PAC";	
	
	@Embedded
	DatosBasicos datosBasicos;
	
	@Embedded
	DatosDeIdentificacion datosDeIdentificacion;

	@Embedded
	DatosDeContacto datosDeContacto;

	@Embedded
	DatosDeProfesion datosDeProfesion;

	@Embedded
	DatosDeDireccion datosDireccion;
	
	@Embedded
	DatosDeUbicacion datosDeUbicacion;
	
	@Embedded
	DatosRedesSociales datosRedesSociales;
	
    @DefaultValueCalculator(CalcularDatoActivo.class) // Fecha actual
	Boolean pacienteActivo;

}





