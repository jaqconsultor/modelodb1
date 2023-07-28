package com.extensiones;
 
import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;
 
@MappedSuperclass // Marcada como una superclase mapeada en vez de como una entidad
@Getter @Setter
public class Incrementable5 {
 
	@Id @ReadOnly 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
    @Column(length=255) // La longitud de columna se usa a nivel UI y a nivel DB
    String descripcion;

    @Hidden
    Integer activo = 1;
    
}