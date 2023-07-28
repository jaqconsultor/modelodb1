package com.tuempresa.facturacion.modelo;

import java.math.*;
import java.time.*;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

import com.productos.*;
import com.tuempresa.facturacion.calculadores.*;

import lombok.*;

@Entity @Getter @Setter
/*@View(members=
"anyo, numero, fecha," + // Los miembros para la cabecera en una línea
"datos {" + // Una pestaña 'datos' para los datos principales del documento
    "cliente;" +
    "detalles;" +
    "observaciones" +
"}")
*/

abstract public class DocumentoComercial extends Eliminable{

	@Column(length=4)
    @DefaultValueCalculator(CurrentYearCalculator.class) // Año actual
	@SearchKey
	@ReadOnly
    int anyo;
 
    @Required
    @DefaultValueCalculator(CurrentLocalDateCalculator.class) // Fecha actual
    LocalDate fecha;

    @DefaultValueCalculator(CurrentLocalDateCalculator.class) // Fecha actual
    @ReadOnly
    @Hidden
    LocalDate fechaCreacion;
    
    @ElementCollection
    @ListProperties(
            "producto.codigoDelProducto, producto.descripcionDelProducto, cantidad, precioPorUnidad, cantidadSolicitada, cantidadRecibida," +
            "importe+[" +
            	"documentoComercial.porcentajeIVA," +
            	"documentoComercial.iva," +
            	"documentoComercial.importeTotal" +
            "]" 
        )	
    Collection<Detalle> detalles;
    
    @TextArea
    String observaciones;

    BigDecimal porcentajeDescuento;

    BigDecimal montoDescuento;

    BigDecimal porcentajeDeducible;

    BigDecimal montoDeducible;
    
    @Digits(integer=2, fraction=0) // Para indicar su tamaño
    @DefaultValueCalculator(CalculadorPorcentajeIVA.class)
    BigDecimal porcentajeIVA;
    
    @ReadOnly
    @Calculation("sum(detalles.importe) * porcentajeIVA / 100")
    BigDecimal iva;


    
    @ReadOnly
    @Calculation("sum(detalles.importe) + iva")    
    BigDecimal importeTotal;    

    /*
    @PrePersist // Ejecutado justo antes de grabar el objeto por primera vez
    private void calcularNumero() {
        Query query = XPersistence.getManager().createQuery(
            "select max(f.numero) from " +
            getClass().getSimpleName() + // De esta forma es válido para Factura y Pedido
            " f where f.anyo = :anyo");
        query.setParameter("anyo", anyo);
        Integer ultimoNumero = (Integer) query.getSingleResult();
        this.numero = ultimoNumero == null ? 1 : ultimoNumero + 1;
    }
    */
    
    @ManyToOne(fetch=FetchType.LAZY, optional=false) // El cliente es obligatorio
    //@ReferenceView("Simple") // La vista llamada 'Simple' se usará para visualizar esta referencia
    @DescriptionsList // Asï¿½ la referencia se visualiza usando un combo    
    EstatusDeDocumentos estadoDelDocumento;    
    
    
    public String toString() {
        return anyo + "/" ;
    }
    
    
}
