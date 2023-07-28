package com.productos;
 
import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;
 
@Embeddable @Getter @Setter
public class DatosDePresentacion {
 
    	    @ManyToOne( // La referencia se almacena como una relación en la base de datos
    	            fetch=FetchType.LAZY, // La referencia se carga bajo demanda
    	            optional=true) // La referencia puede estar sin valor
    	        @DescriptionsList // Así la referencia se visualiza usando un combo
    	        Presentacion presentacion; // Una referencia Java convencional
    	    
    	    @ManyToOne( // La referencia se almacena como una relación en la base de datos
    	            fetch=FetchType.LAZY, // La referencia se carga bajo demanda
    	            optional=true) // La referencia puede estar sin valor
    	        @DescriptionsList // Así la referencia se visualiza usando un combo
    	        Dosificacion dosificacion; // Una referencia Java convencional

    	    @ManyToOne( // La referencia se almacena como una relación en la base de datos
    	            fetch=FetchType.LAZY, // La referencia se carga bajo demanda
    	            optional=true) // La referencia puede estar sin valor
    	        @DescriptionsList // Así la referencia se visualiza usando un combo
    	        Envases tipoDeEnvase; // Una referencia Java convencional

    	    @ManyToOne( // La referencia se almacena como una relación en la base de datos
    	            fetch=FetchType.LAZY, // La referencia se carga bajo demanda
    	            optional=true) // La referencia puede estar sin valor
    	        @DescriptionsList // Así la referencia se visualiza usando un combo
    	        Forma tipoDeForma; // Una referencia Java convencional
    
}