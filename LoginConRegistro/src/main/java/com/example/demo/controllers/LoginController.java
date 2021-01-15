package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Usuario;
import com.example.demo.service.IUsuarioService;

@Controller
public class LoginController {

	@Autowired
	private IUsuarioService usuarioService;
	
	// Despliega el login
	@GetMapping("/auth/login")
	public String login(Model model) {
		model.addAttribute("usuario",new Usuario());
		return "login";
	}
	
	// Despliega el registro
	@GetMapping("/auth/registro")
	public String registroForm(Model model) {
		model.addAttribute("usuario",new Usuario());
		return "registro";
	}
	// Si el registro no es correcto te manda a registro y si esta bien a login
	@PostMapping("/auth/registro")
	public String registro(@Validated @ModelAttribute Usuario usuario, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "redirect:/auth/registro";
		}else {
			model.addAttribute("usuario",usuarioService.registrar(usuario));
		}
		return "redirect:/auth/login";
	}
	
}
