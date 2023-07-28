package com.productos;
 
import java.math.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;

import com.extensiones.*;

import lombok.*;
 

@Entity  // Esto marca la clase Cliente como una entidad
@Getter @Setter // Esto hace los campos a continuaci√≥n p√∫blicamente accesibles
@View(name="Simple", // Esta vista solo se usar√° cuando se especifique ‚ÄúSimple‚Äù
members="numero, descripciondelProducto" // Muestra √∫nicamente numero y nombre en la misma l√≠nea
)
public class Inventario  extends Incrementable4 {
 	
	@Column(length = 25)
	@DefaultValueCalculator(CalculadorConsecutivoProducto.class) // AÒo actual	//@ReadOnly // El usuario no puede modificar el valor
	@ReadOnly
	@SearchKey
	Double numero;
	
    @Column(length=255) // La longitud de columna se usa a nivel UI y a nivel DB
    @Required  // Se mostrar√° un error de validaci√≥n si la propiedad nombre se deja en blanco
    String descripciondelProducto;

    @Required
    @Min(0)
    BigDecimal precioDeVenta;    

    @ManyToOne( // La referencia se almacena como una relaciÛn en la base de datos
            fetch=FetchType.LAZY, // La referencia se carga bajo demanda
            optional=true) // La referencia puede estar sin valor
        @DescriptionsList // AsÌ la referencia se visualiza usando un combo
        TipoDeInventario tipoDeInventario; // Una referencia Java convencional
   
    @Column(length=255) // La longitud de columna se usa a nivel UI y a nivel DB
    String principioActivo;
	
    @Column(length=255) // La longitud de columna se usa a nivel UI y a nivel DB
    String nombreComercial;
    
    @Column(length=255) // La longitud de columna se usa a nivel UI y a nivel DB
    String codigoDeBarra;

    @Column(length=255) // La longitud de columna se usa a nivel UI y a nivel DB
    String producto;
    
	@Embedded
	DatosDeClasificacion clasificacionDelProducto;

	@Embedded
	DatosDePresentacion presentacionDelProducto;

	@Embedded
	DatosDeExistencia existenciaDelProducto;
	
	@TextArea // Esto es para un texto grande, se usar· un ·rea de texto o equivalente
	String observaciones;

	@File // Una galerÌa de fotos completa est· disponible
	@Column(length=32) // La cadena de 32 de longitud es para almacenar la clave de la galerÌa
	String fotoPrincipal;
	
}