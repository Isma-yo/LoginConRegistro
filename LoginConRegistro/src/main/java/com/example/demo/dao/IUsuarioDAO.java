package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Usuario;
@Repository
public interface IUsuarioDAO extends JpaRepository<Usuario, Long>{
	// Usamos el findBy + el nombre de la propiedad con la primera letra en mayúscula
	public Usuario findByUsername(String username);
	
}
