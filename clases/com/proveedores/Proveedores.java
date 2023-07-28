package com.proveedores;
 
import javax.persistence.*;

import org.openxava.annotations.*;

import com.clientes.*;
import com.extensiones.*;

import lombok.*;


@Entity @Getter @Setter
@View(name = "Simple", // Esta vista solo se usarÃ¡ cuando se especifique âSimpleâ
		members = "id, descripcion" // Muestra Ãºnicamente numero y nombre en la misma lÃ­nea
)
@View(name = "SimpleE", // Esta vista solo se usarÃ¡ cuando se especifique âSimpleâ
	members = "id, descripcion" // Muestra Ãºnicamente numero y nombre en la misma lÃ­nea
)
public class Proveedores extends Incrementable2 {

	@Embedded
	DatosDeContacto datosDeContacto;

	@Embedded
	DatosDeDireccion datosDeDireccion;
	
	@Embedded
	DatosDeUbicacion datosDeUbicacion;

	@Embedded
	DatosRedesSociales datosDeRedesSocuales;
	
	Boolean proveedorDeFarmacia;
	
	Boolean proveedorActivo;
	
}





