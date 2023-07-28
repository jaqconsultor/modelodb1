package com.clientes;
 
import javax.persistence.*;

import lombok.*;
 
@Embeddable // Usamos @Embeddable en vez de @Entity
@Getter @Setter


public class DatosDeDireccion {
 
    @Column(length = 255) // Los miembros se anotan igual que en las entidades
    String direccion1;
 
    @Column(length = 255)
    String direccion2;
    
    @Column(length = 255)
    String direccion3;
    
}