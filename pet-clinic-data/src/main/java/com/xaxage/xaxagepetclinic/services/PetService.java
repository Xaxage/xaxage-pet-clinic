package com.xaxage.xaxagepetclinic.services;

import com.xaxage.xaxagepetclinic.model.Owner;
import com.xaxage.xaxagepetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save (Pet pet);

    Set<Pet> findAll();
}
