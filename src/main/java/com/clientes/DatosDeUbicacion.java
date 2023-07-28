package com.clientes;
 
import javax.persistence.*;

import org.openxava.annotations.*;

import com.sistema.*;

import lombok.*;
 
@Embeddable // Usamos @Embeddable en vez de @Entity
@Getter @Setter
public class DatosDeUbicacion {
 
    @ManyToOne( // La referencia se almacena como una relación en la base de datos
            fetch=FetchType.LAZY, // La referencia se carga bajo demanda
            optional=true) // La referencia puede estar sin valor
        @DescriptionsList // Así la referencia se visualiza usando un combo
        Regiones region; // Una referencia Java convencional

    @ManyToOne( // La referencia se almacena como una relación en la base de datos
            fetch=FetchType.LAZY, // La referencia se carga bajo demanda
            optional=true) // La referencia puede estar sin valor
        @DescriptionsList // Así la referencia se visualiza usando un combo
        Provincias provincia; // Una referencia Java convencional
	
    @ManyToOne( // La referencia se almacena como una relación en la base de datos
            fetch=FetchType.LAZY, // La referencia se carga bajo demanda
            optional=true) // La referencia puede estar sin valor
        @DescriptionsList // Así la referencia se visualiza usando un combo
        Distritos distrito; // Una referencia Java convencional

    @ManyToOne( // La referencia se almacena como una relación en la base de datos
            fetch=FetchType.LAZY, // La referencia se carga bajo demanda
            optional=true) // La referencia puede estar sin valor
        @DescriptionsList // Así la referencia se visualiza usando un combo
        Barrios barrio; // Una referencia Java convencional
    
}