package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("deleteVoiture/{id}")
	public String deleteVoiture(@PathVariable("id") int id)
	{
		ivr.deleteById(id);
		
		return "redirect:/listeVoiture";
	}
	
	@GetMapping("modifVoiture/{id}")
	public String modifVoiture(@PathVariable("id") int id, Model m)
	{
		m.addAttribute("voiture", ivr.getReferenceById(id));
		
		return "modifVoiture";
	}
	
	@PostMapping("updateVoiture")
	public String updateVoiture(@ModelAttribute("voit") Voiture v)
	{
		// comme saveOrUpdate
		ivr.save(v);
		
		return "redirect:/listeVoiture";
	}

}
