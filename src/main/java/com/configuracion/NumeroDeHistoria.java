package com.configuracion;
 
import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;

import com.extensiones.*;

import lombok.*;

@Entity @Getter @Setter
public class NumeroDeHistoria extends Incrementable4 {
 
    @Required
    @Min(0)
    Double ultimoNumeroDeHistoria;    
	
}





