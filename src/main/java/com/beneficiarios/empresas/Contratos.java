package com.beneficiarios.empresas;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.beneficiarios.base.*;

import lombok.*;

@Entity @Getter @Setter
@View(name="Simple", // Esta vista solo se usará cuando se especifique “Simple”
members="descripcion" // Muestra únicamente numero y nombre en la misma línea
)
/*
@View( // Esta vista solo se usará cuando se especifique “Simple”
members=" Informacion [ id, descripcion, fechaDeInicio, fechaDeFinalizacion, tipo, empresaAsociada ]; " + 
		" Documento [ ordenDeCompra, cartaRRHH, conTarjeta, garantiaDePago ]; " +
		" Deducibles [ deducibleUnico, minimoDeducible, maximoDeducible ]; " +    
		" Periodo [ cantidadDias ]; " +
		" Descuento [ montoDeDescuento ]; " +    
		" Otro [ incluyeTodosLosServicios ]; "
)

@Tab(
	    properties=" id, descripcion, fechaDeInicio, fechaDeFinalizacion, tipo, empresaAsociada, " + 
	    		" ordenDeCompra, cartaRRHH, conTarjeta, garantiaDePago, " +
	    		" deducibleUnico, minimoDeducible, maximoDeducible,  " +    
	    		" cantidadDias, " +
	    		" montoDeDescuento, " +    
	    		" incluyeTodosLosServicios "
	    		)
*/
public class Contratos extends Convenio {

//    @DefaultValueCalculator(CalculadorConsecutivoFacturaAdministracion.class) // Fecha actual
    @ReadOnly
    @Hidden
    int numero;
	
//    @DefaultValueCalculator(CalculadorTipoFacturaAdministracion.class) // Fecha actual
    @ReadOnly
    @Hidden
    @Column(length=10) // La longitud de columna se usa a nivel UI y a nivel DB
    String tipo = "CON";
	
	@ManyToOne( // La referencia se almacena como una relaciÃ³n en la base de datos
			fetch = FetchType.LAZY, // La referencia se carga bajo demanda
			optional = true) // La referencia puede estar sin valor
	@DescriptionsList // AsÃ­ la referencia se visualiza usando un combo
	EmpresasSinAseguradoras empresaAsociada; // Una referencia Java convencional       

	@ListProperties("id, descripcion")
    @OneToMany(mappedBy="contratoAsociado")
    Collection<BeneficiariosConContratos> beneficiariosConContratos;    

}
