package com.clientes;
 
import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;
 
@Embeddable // Usamos @Embeddable en vez de @Entity
@Getter @Setter
public class DatosDeIdentificacion {
 
    @Column(length=25) // La longitud de columna se usa a nivel UI y a nivel DB
    @Required  // Se mostrará un error de validación si la propiedad nombre se deja en blanco
    @DefaultValueCalculator(CalculadorUltimoNumeroDeHistoria.class) // Fecha actual
    @ReadOnly
    Double numeroHistoriaClinica;
    
    @Column(length=40) // La longitud de columna se usa a nivel UI y a nivel DB
    String numeroDip;
    
    @Column(length=25) // La longitud de columna se usa a nivel UI y a nivel DB
    String numeroDeBatch;
    
    @Column(length=25) // La longitud de columna se usa a nivel UI y a nivel DB
    String numeroDeAsegurado;

    
}