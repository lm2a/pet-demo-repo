package com.lm2a.pet.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lm2a.pet.data.PetRepository;
import com.lm2a.pet.model.Pet;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/pet")
public class PetController {
	
	@Autowired
	PetRepository petRepo;

	@GetMapping
	public String showPetForm(Model model) {
		model.addAttribute("pet", new Pet());
		return "registerForm";
	}
	
	@PostMapping
	public String processRegister(Pet pet) {
		Pet savedPet = petRepo.save(pet);
		log.info("Entro la mascota: "+savedPet);
		return "redirect:/";
	}
	
	@GetMapping("/all")
	public String showAll(Model model) {
		List<Pet> pets = new ArrayList<>();
		petRepo.findAll().forEach(i->pets.add(i));
		model.addAttribute("pets", pets);
		return "all-pets";
		
		
	}
}
