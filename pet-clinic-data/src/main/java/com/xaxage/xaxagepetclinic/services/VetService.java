package com.xaxage.xaxagepetclinic.services;

import com.xaxage.xaxagepetclinic.model.Vet;
import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save (Vet vet);

    Set<Vet> findAll();
}
