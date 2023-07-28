package com.clientes;
 
import javax.persistence.*;

import org.openxava.annotations.*;

import com.sistema.*;

import lombok.*;
 
@Embeddable // Usamos @Embeddable en vez de @Entity
@Getter @Setter
public class DatosDeProfesion {
 
    @ManyToOne( // La referencia se almacena como una relaci�n en la base de datos
            fetch=FetchType.LAZY, // La referencia se carga bajo demanda
            optional=true) // La referencia puede estar sin valor
        @DescriptionsList // As� la referencia se visualiza usando un combo
        Ocupaciones ocupacion; // Una referencia Java convencional

    @ManyToOne( // La referencia se almacena como una relaci�n en la base de datos
            fetch=FetchType.LAZY, // La referencia se carga bajo demanda
            optional=true) // La referencia puede estar sin valor
        @DescriptionsList // As� la referencia se visualiza usando un combo
        Profesiones profesion; // Una referencia Java convencional

    
}