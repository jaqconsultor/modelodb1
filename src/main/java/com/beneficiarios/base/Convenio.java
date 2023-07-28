package com.beneficiarios.base;
 
import java.math.*;
import java.time.*;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;

import com.configuracion.*;
import com.extensiones.*;

import lombok.*;

@Entity @Getter @Setter
@View(name="Simple", // Esta vista solo se usará cuando se especifique “Simple”
members="descripcion" // Muestra únicamente numero y nombre en la misma línea
)
public class Convenio extends Incrementable5 {

	LocalDate fechaDeInicio;
	
	LocalDate fechaDeFinalizacion;

	Boolean ordenDeCompra;
	
	Boolean cartaRRHH;
	
	Boolean conTarjeta;
	
	Boolean garantiaDePago;

    @Min(0)
	@Max(100)
    BigDecimal deducibleUnico;    

    @Min(0)
	@Max(100)
    BigDecimal minimoDeducible;    
	
    @Min(0)
	@Max(100)
    BigDecimal maximoDeducible;    

    @Min(0)
    BigDecimal cantidadDias;    
    
    @Min(0)
    @Max(100)
    BigDecimal montoDeDescuento;    

    @ElementCollection
    @ListProperties(
     " servicioAsociado.id, servicioAsociado.descripcion, deducibleAplicar, descuentoAplicar "		  
        )	
    Collection<DatosDelServicio> datosDelServicio;
    
}





