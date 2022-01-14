package com.xaxage.xaxagepetclinic.bootstrap;

import com.xaxage.xaxagepetclinic.model.Owner;
import com.xaxage.xaxagepetclinic.model.Vet;
import com.xaxage.xaxagepetclinic.services.OwnerService;
import com.xaxage.xaxagepetclinic.services.VetService;
import com.xaxage.xaxagepetclinic.services.map.OwnerServiceMap;
import com.xaxage.xaxagepetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//When Spring Context is ready, it's going to call run method here
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader() {
        this.ownerService = new OwnerServiceMap();
        this.vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Myers");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Shreki");

        ownerService.save(owner2);

        System.out.println("Owners loaded...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Winchester");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(1L);
        vet2.setFirstName("Jessie");
        vet2.setLastName("Pinkman");

        vetService.save(vet1);

        System.out.println("Vets loaded...");

    }
}

