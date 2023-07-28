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
public class ClienteExterno extends ClienteBase {

    @Column(length=10) // La longitud de columna se usa a nivel UI y a nivel DB
    @Hidden
    String tipoDeCliente = "CLI";
    
    @DefaultValueCalculator(CalcularDatoActivo.class) // Fecha actual
    @Hidden
	Boolean pacienteActivo;

	@Embedded
	DatosDeContacto datosDeContacto;

	@Embedded
	DatosDeDireccion datosDeDireccion;
	
	@Embedded
	DatosRedesSociales datosDeRedesSocuales;

}





