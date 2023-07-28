package com.tuempresa.facturacion.modelo;
 
import javax.persistence.*;

import org.openxava.annotations.*;

import com.proveedor.*;

import lombok.*;
 
@Entity @Getter @Setter
/*
@View( extendsView="super.DEFAULT", // La vista por defecto
members="pedidos { pedidos } "
)
@View( name="SinClienteNiPedidos", // Una vista llamada SinClienteNiPedidos
members=                       // que no incluye cliente ni pedidos
    "anyo, numero, fecha;" +   // Ideal para usarse desde Pedido
	"nomenclatura, tipoDocumento; proveedor;" +
    "detalles;" +
    "observaciones"
)
*/
@View( // Una vista llamada SinClienteNiPedidos
members=   
	// que no incluye cliente ni pedidos
"anyo; numero, nomenclatura; fecha; estadoDelDocumento;" +   // Ideal para usarse desde Pedido
	"proveedor;" +
    "detalles;" +
    "observaciones" 
)


@Tab(baseCondition = "${eliminado} = false") // Tab sin nombre, es el de por defecto
@Tab(name="Eliminado", baseCondition = "${eliminado} = true") // Tab con nombre
public class OrdenDeCompra extends DocumentoComercial{
	
	@Column(length = 25)
	@DefaultValueCalculator(CalcularOC.class) // AÃ±o actual	//@ReadOnly // El usuario no puede modificar el valor
	@ReadOnly
	@SearchKey
	Long numero;
    
    @Column(length=255) // La longitud de columna se usa a nivel UI y a nivel DB
    @ReadOnly
    @DefaultValueCalculator(CalcularNomenclaturaIOC.class) // Fecha actual
    String nomenclatura;
	
    @Column(length=10) // La longitud de columna se usa a nivel UI y a nivel DB
    @Hidden
    String tipoDocumento = "ODC";	
	
    @ManyToOne(fetch=FetchType.LAZY, optional=true) // El cliente es obligatorio
    @ReferenceView("Simple") // La vista llamada 'Simple' se usará para visualizar esta referencia
    Proveedores proveedor;
    
    /*
    @OneToMany(mappedBy="factura")
    @CollectionView("SinClienteNiFactura") // Esta vista se usa para visualizar pedidos
    @AddAction("Factura.anyadirPedidos")
    Collection<Pedido> pedidos; // Colección de entidades Pedido añadida
	
    
    public static FacturaAdministracion crearDesdePedidos(Collection<Pedido> pedidos)
            throws CrearFacturaException
        {
            FacturaAdministracion factura = null;
            for (Pedido pedido: pedidos) {
                if (factura == null) { // El primero pedido
                    pedido.crearFactura(); // Reutilizamos la lógica para crear una
                                           // factura desde un pedido
                    factura = pedido.getFactura(); // y usamos la factura creada
                }
                else { // Para el resto de los pedidos la factura ya está creada
                    pedido.setFactura(factura); // Asigna la factura
                    pedido.copiarDetallesAFactura(); // Un método de Pedido para copiar las lineas
                } 
            } 
            if (factura == null) { // Si no hay pedidos
                throw new CrearFacturaException("pedidos_no_especificados");
            }
            return factura;
        }
        */
}