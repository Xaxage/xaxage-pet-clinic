package com.xaxage.xaxagepetclinic.services.springdatajpa;

import com.xaxage.xaxagepetclinic.model.PetType;
import com.xaxage.xaxagepetclinic.repositories.PetTypeRepository;
import com.xaxage.xaxagepetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PetTypeSDJpaService implements PetTypeService {
    private final PetTypeRepository petTypeRepository;

    public PetTypeSDJpaService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long id) {
        return petTypeRepository.findById(id).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteByID(Long id) {
        petTypeRepository.deleteById(id);
    }
}
