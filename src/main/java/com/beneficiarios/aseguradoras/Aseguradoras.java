package com.beneficiarios.aseguradoras;
 
import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.clientes.*;
import com.extensiones.*;

import lombok.*;

@Entity @Getter @Setter
@View(name="Simple", // Esta vista solo se usará cuando se especifique “Simple”
members="descripcion" // Muestra únicamente numero y nombre en la misma línea
)


public class Aseguradoras extends Incrementable2 {
	
    @Column(length=10) // La longitud de columna se usa a nivel UI y a nivel DB
    String nroIdentificacion;
	
	@Embedded
	DatosDeContacto datosDeContacto;

	@Embedded
	DatosDeDireccion datosDireccion;	
	
    @ListProperties("id, descripcion")
    @OneToMany(mappedBy="aseguradora")
    Collection<EmpresasConAseguradoras> empresasConAseguradoras;
   
}





