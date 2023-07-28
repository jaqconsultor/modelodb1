package com.tuempresa.facturacion.modelo;
 
import javax.persistence.*;

import com.extensiones.*;

import lombok.*;
 
@Entity @Getter @Setter
public class Categoria extends Identificable {

    @Column(length=50)
    String descripcion;
 
}