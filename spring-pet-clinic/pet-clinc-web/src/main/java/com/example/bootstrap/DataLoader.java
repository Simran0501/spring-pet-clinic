package com.example.bootstrap;

import com.example.model.Owner;
import com.example.model.Vet;
import com.example.services.OwnerService;
import com.example.services.VetService;
import com.example.services.map.OwnerServiceMap;
import com.example.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstname("Simran");
        owner1.setLastname("Garg");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstname("Sangam");
        owner2.setLastname("Raja");

        ownerService.save(owner2);
        System.out.println("LOADED OWNERS!!");

        Vet vet1 = new Vet();
        vet1.setId(7L);
        vet1.setFirstname("Alex");
        vet1.setLastname("George");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(4L);
        vet2.setFirstname("Monica");
        vet2.setLastname("Russel");

        vetService.save(vet2);
        System.out.println("LOADED VETS!!");


    }
}
