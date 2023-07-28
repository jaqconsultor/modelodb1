package com.clientes;
 
import javax.persistence.*;

import org.hibernate.validator.constraints.*;

import lombok.*;
 
@Embeddable @Getter @Setter
public class DatosRedesSociales {
 
    @Column(length = 255) // Los miembros se anotan igual que en las entidades
    @URL
    String paginaWeb;
	
    @SuppressWarnings("deprecation")
	@Column(length = 255)
    @Email
    String correoElectronico;

    @Column(length = 30) // Los miembros se anotan igual que en las entidades
    String whatsApp;
 
    @Column(length = 30) // Los miembros se anotan igual que en las entidades
    String telegram;
    
}