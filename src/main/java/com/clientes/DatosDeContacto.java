package com.clientes;
 
import javax.persistence.*;

import lombok.*;
 
@Embeddable // Usamos @Embeddable en vez de @Entity
@Getter @Setter

public class DatosDeContacto {
 
    @Column(length = 150) // Los miembros se anotan igual que en las entidades
    String contacto1;
 
    @Column(length = 50)
    String telefono1;
    
    @Column(length = 50)
    String celular1;

    @Column(length = 150) // Los miembros se anotan igual que en las entidades
    String contacto2;
 
    @Column(length = 50)
    String telefono2;
    
    @Column(length = 50)
    String celular2;
    
}