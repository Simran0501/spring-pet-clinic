package com.example.bootstrap;

import com.example.model.Owner;
import com.example.model.PetType;
import com.example.model.Vet;
import com.example.services.OwnerService;
import com.example.services.PetTypeService;
import com.example.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;


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
        owner1.setFirstname("Simran");
        owner1.setLastname("Garg");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstname("Sangam");
        owner2.setLastname("Raja");

        ownerService.save(owner2);
        System.out.println("LOADED OWNERS!!");

        Vet vet1 = new Vet();
        vet1.setFirstname("Alex");
        vet1.setLastname("George");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstname("Monica");
        vet2.setLastname("Russel");

        vetService.save(vet2);
        System.out.println("LOADED VETS!!");


    }
}
