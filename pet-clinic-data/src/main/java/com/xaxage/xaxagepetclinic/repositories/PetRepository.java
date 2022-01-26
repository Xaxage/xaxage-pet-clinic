package com.xaxage.xaxagepetclinic.repositories;

import com.xaxage.xaxagepetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
