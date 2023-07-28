package com.nomina.biometrico;
 
import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;
 
@Entity  // Esto marca la clase Cliente como una entidad
@Getter @Setter // Esto hace los campos a continuación públicamente accesibles
@View(name="Simple", // Esta vista solo se usará cuando se especifique “Simple”
members="nombre" // Muestra únicamente numero y nombre en la misma línea
)
public class CargaDelBiometrico {
 
	@ReadOnly
	@Id 
	@Hidden
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
    @Column(length=25) // La longitud de columna se usa a nivel UI y a nivel DB
    String acNumero;

    @Column(length=25) // La longitud de columna se usa a nivel UI y a nivel DB
    String numero;
    
    @Column(length=150) // La longitud de columna se usa a nivel UI y a nivel DB
    String descripcion;
    
    @Column(length=100) // La longitud de columna se usa a nivel UI y a nivel DB
    String estado;

    @Column(length=100) // La longitud de columna se usa a nivel UI y a nivel DB
    String newEstado;
    
    @Column(length=100) // La longitud de columna se usa a nivel UI y a nivel DB
    String execption;

    @Column(length=50) // La longitud de columna se usa a nivel UI y a nivel DB
    String operacion;

}