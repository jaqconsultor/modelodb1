package com.configuracion;
 
import javax.persistence.*;

import org.openxava.annotations.*;

import com.productos.*;

import lombok.*;

@Entity @Getter @Setter
@View(members= // Esta vista no tiene nombre, por tanto será la vista usada por defecto
" descripcion" 
)
@Tab(name="TipoDeServicios",baseCondition = "${esServicio} = true")
public class Servicios extends TipoDeInventario {
	
}





