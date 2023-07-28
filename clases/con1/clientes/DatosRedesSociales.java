package com.clientes;
 
import javax.persistence.*;

import org.hibernate.validator.constraints.*;

import lombok.*;
 
@Embeddable @Getter @Setter
public class DatosRedesSociales {
 
    @Column(length = 255) // Los miembros se anotan igual que en las entidades
    @URL
    String paginaWeb;
 
    @Column(length = 255)
    String correoElectronico;
    
    @Column(length = 255)
    String skype;

    @Column(length = 255) // Los miembros se anotan igual que en las entidades
    String whasapt;
 
    @Column(length = 255)
    String fabebook;
    
    @Column(length = 255)
    String instagram;

    @Column(length = 255)
    String twitter;

    
}