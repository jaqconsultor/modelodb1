package com.clientes;
 
import javax.persistence.*;

import org.openxava.annotations.*;

import com.extensiones.*;

import lombok.*;

@Entity @Getter @Setter
@View(name = "Simple", // Esta vista solo se usarÃ¡ cuando se especifique âSimpleâ
		members = "id, descripcion" // Muestra Ãºnicamente numero y nombre en la misma lÃ­nea
)
@View(name = "SimpleE", // Esta vista solo se usarÃ¡ cuando se especifique âSimpleâ
	members = "id, descripcion" // Muestra Ãºnicamente numero y nombre en la misma lÃ­nea
)
public class Paciente extends Incrementable2 {

	@Embedded
	DatosDeIdentificacion datosDeIdentificacion;
	
	@File // Una galer�a de fotos completa est� disponible
	@Column(length=32) // La cadena de 32 de longitud es para almacenar la clave de la galer�a
	String fotos;
	
	@Embedded
	DatosBasicos datosBasicos;
	
	@Embedded
	DatosDeProfesion datosDeProfesion;

	@Embedded
	DatosDeDireccion datosDeDireccion;
	
	@Embedded
	DatosDeUbicacion datosDeUbicacion;

	@Embedded
	DatosDeContacto datosDeContacto;
	
	@Embedded
	DatosRedesSociales datosDeRedesSocuales;
	
	@TextArea // Esto es para un texto grande, se usar� un �rea de texto o equivalente
	String observaciones;

	Boolean activo;
}





