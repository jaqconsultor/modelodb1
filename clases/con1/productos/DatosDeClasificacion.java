package com.productos;
 
import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;
 
@Embeddable @Getter @Setter
public class DatosDeClasificacion {
 
    @ManyToOne( // La referencia se almacena como una relaci�n en la base de datos
            fetch=FetchType.LAZY, // La referencia se carga bajo demanda
            optional=true) // La referencia puede estar sin valor
        @DescriptionsList // As� la referencia se visualiza usando un combo
        Laboratorios elaboradoPorElLaboratorio; // Una referencia Java convencional
	
    @ManyToOne( // La referencia se almacena como una relación en la base de datos
            fetch=FetchType.LAZY, // La referencia se carga bajo demanda
            optional=true) // La referencia puede estar sin valor
        @DescriptionsList // Así la referencia se visualiza usando un combo
        ClasificacionPrincipal clasificacionPrincipal; // Una referencia Java convencional
    
    @ManyToOne( // La referencia se almacena como una relación en la base de datos
            fetch=FetchType.LAZY, // La referencia se carga bajo demanda
            optional=true) // La referencia puede estar sin valor
        @DescriptionsList // Así la referencia se visualiza usando un combo
        ClasificacionSecundaria clasificacionSecundaria; // Una referencia Java convencional
    
}