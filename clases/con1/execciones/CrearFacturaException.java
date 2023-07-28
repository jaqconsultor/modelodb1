package com.execciones;


import org.openxava.util.*;

public class CrearFacturaException extends Exception { // No RuntimeException

    public CrearFacturaException(String mensaje) {
        // El XavaResources es para traducir el mensaje desde el id en i18n
        super(XavaResources.getString(mensaje));
    }
	
}