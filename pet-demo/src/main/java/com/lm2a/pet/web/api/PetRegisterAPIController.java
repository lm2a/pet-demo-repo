package com.lm2a.pet.web.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lm2a.pet.data.PetRepository;
import com.lm2a.pet.model.Pet;

@RestController
@RequestMapping(path="/rest", produces="application/json")
@CrossOrigin("*")
public class PetRegisterAPIController {

	@Autowired
	PetRepository petRepo;
	
	@PostMapping(path="/pet", consumes="application/json")
	public Pet petPost(@RequestBody Pet pet) {
		Pet savedPet = petRepo.save(pet);
		return savedPet;
		
	}
	
	
//	@GetMapping("/pet/{id}")
//	public Pet findPet(@PathVariable("id") Long id) {
//		Optional<Pet> petOptional = petRepo.findById(id);
//		if(petOptional.isPresent()) {
//			return petOptional.get();
//		}
//		return null;
//	}
	
	@GetMapping("/pet/{id}")
	public ResponseEntity<Pet> findPet(@PathVariable("id") Long id) {
		Optional<Pet> petOptional = petRepo.findById(id);
		if(petOptional.isPresent()) {
			return new ResponseEntity<Pet>(petOptional.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/pet/all")
	public Iterable<Pet> findAll(){
		return petRepo.findAll();
	}
	
	
	@GetMapping("/pet/pages/{nro}")
	public Iterable<Pet> findAllUsingPages(@PathVariable("nro") int id){
		PageRequest paginable = PageRequest.of(id, 5, Sort.by("name").descending());
		return petRepo.findAll(paginable);
	}
}
