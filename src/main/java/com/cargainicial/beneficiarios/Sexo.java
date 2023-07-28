package com.cargainicial.beneficiarios;
 
import javax.persistence.*;

import com.extensiones.*;

import lombok.*;

@Entity @Getter @Setter
public class Sexo extends Incrementable2 {
 

    @Column(length=100) // La longitud de columna se usa a nivel UI y a nivel DB
	String equivalencia;
}





