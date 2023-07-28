package com.cargainicial.inventario;

import java.math.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;

import com.extensiones.*;
import com.productos.*;

import lombok.*;
 
@Entity  // Esto marca la clase Cliente como una entidad
@Getter @Setter // Esto hace los campos a continuación públicamente accesibles
public class CargaDeInventario extends Incrementable4 {

	
	@Column(length = 25)
	@DefaultValueCalculator(CalculadorConsecutivoCargaInventario.class) // A�o actual	//@ReadOnly // El usuario no puede modificar el valor
	@ReadOnly
	@SearchKey
	Double codigoDelProducto;	

    @Column(length=255) // La longitud de columna se usa a nivel UI y a nivel DB
    String principioActivo;
	
    @Column(length=255) // La longitud de columna se usa a nivel UI y a nivel DB
    String nombreComercial;
	
    @Column(length=255) // La longitud de columna se usa a nivel UI y a nivel DB
    String descripcionDelProducto;

    @Column(length=255) // La longitud de columna se usa a nivel UI y a nivel DB
    String codigoDeBarra;
    
    @Column(length=50) // La longitud de columna se usa a nivel UI y a nivel DB
    String presentacion;
    
    @Column(length=50) // La longitud de columna se usa a nivel UI y a nivel DB
    String dosificacion;
    
    @Column(length=255) // La longitud de columna se usa a nivel UI y a nivel DB
    String producto;
    
    @Column(length = 6) // The members are annotated as in entity case
    @Min(0)
    int minima;
 
    @Column(length = 6) // The members are annotated as in entity case
    @Min(0)
    int maxima;

    @Column(length = 6)
    @Min(0)
    int existencia;

    @Required
    @Min(0)
    BigDecimal precioDeVenta;    

    @ManyToOne( // La referencia se almacena como una relación en la base de datos
            fetch=FetchType.LAZY, // La referencia se carga bajo demanda
            optional=true) // La referencia puede estar sin valor
        @DescriptionsList // Así la referencia se visualiza usando un combo
       TipoDeInventario tipo; // Una referencia Java convencional
        
}