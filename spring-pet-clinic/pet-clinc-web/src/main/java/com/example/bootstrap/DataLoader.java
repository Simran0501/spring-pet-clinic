package com.example.bootstrap;

import com.example.model.*;
import com.example.repositories.VisitRepository;
import com.example.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if(count == 0)
            loadData();
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstname("Simran");
        owner1.setLastname("Garg");
        owner1.setAddress("Moti Bagh");
        owner1.setCity("Bulandshahr");
        owner1.setTelephone("9560762037");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstname("Sangam");
        owner2.setLastname("Raja");
        owner2.setAddress("Palmau");
        owner2.setCity("Ranchi");
        owner2.setTelephone("7488561521");
        ownerService.save(owner2);

        System.out.println("LOADED OWNERS!!");

        Pet simranPet = new Pet();
        simranPet.setPetType(savedDogPetType);
        simranPet.setOwner(owner1);
        simranPet.setBirthDate(LocalDate.now());
        simranPet.setName("Pixel");
        owner1.getPets().add(simranPet);
        ownerService.save(owner1);

        Pet sangamPet = new Pet();
        sangamPet.setPetType(savedCatPetType);
        sangamPet.setOwner(owner2);
        sangamPet.setBirthDate(LocalDate.now());
        sangamPet.setName("Carys");
        owner2.getPets().add(sangamPet);
        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(sangamPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Carys is visiting ");

        visitService.save(catVisit);
        System.out.println("LOADED VISITS! ");


        Vet vet1 = new Vet();
        vet1.setFirstname("Alex");
        vet1.setLastname("George");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstname("Monica");
        vet2.setLastname("Russel");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);
        System.out.println("LOADED VETS!!");
    }
}
