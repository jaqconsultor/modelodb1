package com.yourcompany.farmacia.model; // En el paquete 'acciones'

import org.openxava.actions.*;

public class ImprimirInventario
    extends TabBaseAction { // Para usar getView()

    public void execute() throws Exception {
        /*if (getView().getValue("id") == null) { 
            // Si el oid es nulo el pedido actual no se ha grabado todav�a (1)
            addError("imposible_crear_factura_pedido_no_existe");
            return;
        }
        */
        /*
        Pedido pedido = XPersistence.getManager().find( // Usamos JPA para obtener la
            Pedido.class, // entidad Pedido visualizada en la vista
            getView().getValue("oid"));
        pedido.crearFactura(); // El trabajo de verdad lo delegamos en la entidad
        getView().refresh(); // Para ver la factura creada en la pesta�a FACTURA
        addMessage("factura_creada_desde_pedido", // Mensaje de confirmaci�n
            pedido.getFactura());
        removeActions("Pedido.crearFactura");
        */
    	return;
    }
}