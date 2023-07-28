package com.reportes.cierre;
 
import javax.persistence.*;

import org.openxava.annotations.*;

import com.extensiones.*;

import lombok.*;

@Entity @Getter @Setter
@View(name="Simple", // Esta vista solo se usará cuando se especifique “Simple”
members="descripcion" // Muestra únicamente numero y nombre en la misma línea
)
public class ReporteSaldosPendientes extends Incrementable2 {
	
	Long codigo;
	
    Double saldo;
	
}





