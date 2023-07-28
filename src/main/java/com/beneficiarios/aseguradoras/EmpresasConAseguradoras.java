package com.beneficiarios.aseguradoras;
 
import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.beneficiarios.base.*;
import com.clientes.*;

import lombok.*;

@Entity @Getter @Setter
@View(name="Simple", // Esta vista solo se usará cuando se especifique “Simple”
members="descripcion" // Muestra únicamente numero y nombre en la misma línea
)

/*
@View(members= 
" descripcion; aseguradora;" +
" Facturacion [ requiereFacturaDetallada, laEmpresaEsPetrolera, impuestoPetrolero ];" 
)
*/
public class EmpresasConAseguradoras extends EmpresasBase {

    @Column(length=10) // La longitud de columna se usa a nivel UI y a nivel DB
    @Hidden
    String tipoDeBeneficiario = "EA";
    
    @Column(length=10) // La longitud de columna se usa a nivel UI y a nivel DB
    String nroIdentificacion;
    
	@Embedded
	DatosDeContacto datosDeContacto;

	@Embedded
	DatosDeDireccion datosDireccion;	
    
	@ManyToOne( // La referencia se almacena como una relaciÃ³n en la base de datos
			fetch = FetchType.LAZY, // La referencia se carga bajo demanda
			optional = true) // La referencia puede estar sin valor
	@DescriptionsList // AsÃ­ la referencia se visualiza usando un combo
	Aseguradoras aseguradora; // Una referencia Java convencional 
	
	@ListProperties("id, descripcion")
    @OneToMany(mappedBy="empresaAseguradora")
    Collection<Polizas> polizas;
	
}





