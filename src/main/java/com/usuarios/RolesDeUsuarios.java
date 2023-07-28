package com.usuarios;
 
import java.util.*;

import javax.persistence.*;

import com.extensiones.*;

import lombok.*;

@Entity @Getter @Setter
public class RolesDeUsuarios extends Incrementable2 {
 
	@ManyToMany
	@JoinTable(name="roles_usuarios",
	 joinColumns=@JoinColumn(name="usuarios_id"),
	 inverseJoinColumns=@JoinColumn(name="roles_id")
	)
	private Collection<Usuarios> usuarios;
	
}





