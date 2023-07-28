package com.clientes;
 
import java.time.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.nomina.*;

import lombok.*;
 
@Embeddable // Usamos @Embeddable en vez de @Entity
@Getter @Setter
public class DatosDeEmpleado {
 
   LocalDate fechaDeIngresoAlaEmpresa;
   
   LocalDate fechaDelPrimerContrato;
   
   Boolean esEmpleado;

   @Column(length=25) // La longitud de columna se usa a nivel UI y a nivel DB
   String numeroDelBiometrico;

   @Column(length=40) // La longitud de columna se usa a nivel UI y a nivel DB
   String numeroDeCuenta;
   
   @Column(length=40) // La longitud de columna se usa a nivel UI y a nivel DB
   String clave;

   @ManyToOne( // La referencia se almacena como una relaci�n en la base de datos
           fetch=FetchType.LAZY, // La referencia se carga bajo demanda
           optional=true) // La referencia puede estar sin valor
       @DescriptionsList // As� la referencia se visualiza usando un combo
       TipoDePersona tipoDePersona; // Una referencia Java convencional

   @ManyToOne( // La referencia se almacena como una relaci�n en la base de datos
           fetch=FetchType.LAZY, // La referencia se carga bajo demanda
           optional=true) // La referencia puede estar sin valor
       @DescriptionsList // As� la referencia se visualiza usando un combo
       Departamentos departamento; // Una referencia Java convencional
   
   @ManyToOne( // La referencia se almacena como una relaci�n en la base de datos
           fetch=FetchType.LAZY, // La referencia se carga bajo demanda
           optional=true) // La referencia puede estar sin valor
       @DescriptionsList // As� la referencia se visualiza usando un combo
       Cargos cargo; // Una referencia Java convencional
   
   @ManyToOne( // La referencia se almacena como una relaci�n en la base de datos
           fetch=FetchType.LAZY, // La referencia se carga bajo demanda
           optional=true) // La referencia puede estar sin valor
       @DescriptionsList // As� la referencia se visualiza usando un combo
       TipoDePersonal tipoDePersonal; // Una referencia Java convencional
   
}