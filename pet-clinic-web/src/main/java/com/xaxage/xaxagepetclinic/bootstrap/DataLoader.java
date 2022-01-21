package com.xaxage.xaxagepetclinic.bootstrap;

import com.xaxage.xaxagepetclinic.model.Owner;
import com.xaxage.xaxagepetclinic.model.Pet;
import com.xaxage.xaxagepetclinic.model.PetType;
import com.xaxage.xaxagepetclinic.model.Vet;
import com.xaxage.xaxagepetclinic.services.OwnerService;
import com.xaxage.xaxagepetclinic.services.PetTypeService;
import com.xaxage.xaxagepetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

//When Spring Context is ready, it's going to call run method here
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;


    @Autowired//Kinda like it being here
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Myers");
        owner1.setAddress("Nightmares street 78");
        owner1.setCity("CharlesTown");
        owner1.setTelephone("+721384028934");

        Pet michaelPet = new Pet();
        michaelPet.setPetType(savedDogPetType);
        michaelPet.setOwner(owner1);
        michaelPet.setBirthday(LocalDate.now());
        michaelPet.setName("Roland");

        owner1.getPets().add(michaelPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Shreki");
        owner2.setAddress("Amstenyans 1");
        owner2.setCity("Exvard");
        owner2.setTelephone("+421384028934");

        Pet fionaPet = new Pet();
        fionaPet.setPetType(savedCatPetType);
        fionaPet.setOwner(owner2);
        fionaPet.setBirthday(LocalDate.now());
        fionaPet.setName("Roland");

        owner2.getPets().add(fionaPet);

        ownerService.save(owner2);

        System.out.println("Owners loaded...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Winchester");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Pinkman");

        vetService.save(vet2);

        System.out.println("Vets loaded...");
    }
}

