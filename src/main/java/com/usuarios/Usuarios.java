package com.usuarios;
 
import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.extensiones.*;

import lombok.*;

@Entity @Getter @Setter
public class Usuarios extends Incrementable {

    @Column(length=20) // La longitud de columna se usa a nivel UI y a nivel DB
    @Required  // Se mostrar� un error de validaci�n si la propiedad nombre se deja en blanco
    String login;
	
    @Column(length=255) // La longitud de columna se usa a nivel UI y a nivel DB
    @Required  // Se mostrar� un error de validaci�n si la propiedad nombre se deja en blanco
    String descripcion;
    
    @Password
    @Column(length=40)
    String claveDeUsuario;

	@ManyToMany
	@JoinTable(name="roles_usuarios",
	 joinColumns=@JoinColumn(name="roles_id"),
	 inverseJoinColumns=@JoinColumn(name="usuarios_id"))
	private Collection<RolesDeUsuarios> roles;
	
	
    boolean usuarioActivo;
    
}





