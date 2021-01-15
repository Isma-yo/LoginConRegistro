package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PortalCotroller {

	@RequestMapping("/portal")
	public String mostrarPortal() {
		return "portal";
	}
}
