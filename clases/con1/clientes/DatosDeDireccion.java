package com.clientes;
 
import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;
 
@Embeddable // Usamos @Embeddable en vez de @Entity
@Getter @Setter
@View(members= // Esta vista no tiene nombre, por tanto será la vista usada por defecto
"direccion1; direccion2; direccion3;"
)

public class DatosDeDireccion {
 
    @Column(length = 255) // Los miembros se anotan igual que en las entidades
    String direccion1;
 
    @Column(length = 255)
    String direccion2;
    
    @Column(length = 255)
    String direccion3;
    
}