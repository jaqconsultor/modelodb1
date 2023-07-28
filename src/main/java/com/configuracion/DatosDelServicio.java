package com.configuracion;
 
import java.math.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.productos.*;

import lombok.*;
 
@Embeddable // Usamos @Embeddable en vez de @Entity
@Getter @Setter
public class DatosDelServicio {

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    TipoDeInventario servicioAsociado;
    
    
    @Min(0)
	@Max(100)
    BigDecimal deducibleAplicar;    

    @Min(0)
	@Max(100)
    BigDecimal descuentoAplicar;    
    
}