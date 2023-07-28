package com.beneficiarios.base;
 
import java.math.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.extensiones.*;

import lombok.*;

@Entity @Getter @Setter
@View(name="Simple", // Esta vista solo se usará cuando se especifique “Simple”
members="descripcion" // Muestra únicamente numero y nombre en la misma línea
)
public class EmpresasBase extends Incrementable2 {

	
    Boolean requiereFacturaDetallada=false;
	
    Boolean laEmpresaEsPetrolera=true;    

    BigDecimal impuestoPetrolero; // Una propiedad persistente convencional
    
}





