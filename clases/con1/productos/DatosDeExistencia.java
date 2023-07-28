package com.productos;
 
import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.*;
 
@Embeddable @Getter @Setter
public class DatosDeExistencia {

	@Min(0)
	Integer cantidadMinima;
	
	@Min(0)
	Integer cantidadMaxima;
		
	@Min(0)
	Integer existenciaActual;
	
}