package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.inti.model.Voiture;
import com.inti.repository.IVoitureRepository;

@Controller
public class MainController {
	
	@Autowired
	IVoitureRepository ivr;
	
	@GetMapping("formVoiture")
	public String formVoiture()
	{
		return "formVoiture";
	}
	
	@PostMapping("saveVoiture")
	public String saveVoiture(@ModelAttribute("voiture") Voiture v)
	{
		ivr.save(v);
		
		return "redirect:/formVoiture";
	}
	
	@GetMapping("listeVoiture")
	public String listeVoiture(Model m)
	{
		m.addAttribute("listeV", ivr.findAll());
		
		return "listeVoiture";
	}

}
