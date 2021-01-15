package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IUsuarioDAO;
import com.example.demo.entity.Usuario;
import com.example.demo.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
	
	// Hay que inyectar el passwordEncoder para poder encriptar la contraseña
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private IUsuarioDAO usuarioDao;

	public Usuario findByUsername(String username) {
		// TODO Auto-generated method stub
		return usuarioDao.findByUsername(username);
	}

	@Override
	public Usuario registrar(Usuario u) {
		u.setPassword(passwordEncoder.encode(u.getPassword()));
		return usuarioDao.save(u);
	}
	

	

}
