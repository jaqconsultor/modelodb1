package com.configuracion;
 
import javax.persistence.*;

import org.openxava.annotations.*;

import com.extensiones.*;

import lombok.*;

@Entity @Getter @Setter
@View(name="Simple", // Esta vista solo se usará cuando se especifique “Simple”
members="descripcion" // Muestra únicamente numero y nombre en la misma línea
)
public class UnidadesPorCoordinacion extends Incrementable2 {
 

    @ManyToOne( // La referencia se almacena como una relaci�n en la base de datos
            fetch=FetchType.LAZY, // La referencia se carga bajo demanda
            optional=true) // La referencia puede estar sin valor
        @DescriptionsList // As� la referencia se visualiza usando un combo
        Coordinaciones coordinacionAsociada; // Una referencia Java convencional

	
}





