package com.example.demo.repositories;

import java.util.Optional;

import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Usuario;

@NamedStoredProcedureQuery(name = "OBTENER_ID", procedureName = "OBTENER_ID",
parameters = {
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "max",
				type = Integer.class)
})
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
	
	public Optional<Usuario> findByUsername(String username);
	
	@SuppressWarnings("unchecked")
	public Usuario save(Usuario user);
	
	@Procedure(name = "OBTENER_ID")
	public int getMaxID();
	
}
