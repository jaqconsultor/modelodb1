package com.clientes;
 
import java.time.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.sistema.*;

import lombok.*;
 
@Embeddable @Getter @Setter
public class DatosBasicos {
 
    //LocalDate fechaDeIngreso;

    @ManyToOne( // La referencia se almacena como una relaci�n en la base de datos
            fetch=FetchType.LAZY, // La referencia se carga bajo demanda
            optional=true) // La referencia puede estar sin valor
        @DescriptionsList // As� la referencia se visualiza usando un combo
        @Editor("ColorBotonesRadiales")
        Sexo sexo; // Una referencia Java convencional
    
	LocalDate fechaDeNacimiento;
	
	Integer edad;
	
    @ManyToOne( // La referencia se almacena como una relaci�n en la base de datos
            fetch=FetchType.LAZY, // La referencia se carga bajo demanda
            optional=true) // La referencia puede estar sin valor
        @DescriptionsList // As� la referencia se visualiza usando un combo
        @Editor("ColorBotonesRadiales")
        EstadoCivil estadoCivil; // Una referencia Java convencional
    
    @ManyToOne( // La referencia se almacena como una relaci�n en la base de datos
            fetch=FetchType.LAZY, // La referencia se carga bajo demanda
            optional=true) // La referencia puede estar sin valor
        @DescriptionsList // As� la referencia se visualiza usando un combo
        LugarDeNacimiento lugarDeNacimiento; // Una referencia Java convencional

    
}