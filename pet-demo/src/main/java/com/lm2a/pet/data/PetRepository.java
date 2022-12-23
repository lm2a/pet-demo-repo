package com.lm2a.pet.data;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.lm2a.pet.model.Pet;

public interface PetRepository extends PagingAndSortingRepository<Pet, Long> {

}
