package com.example.services.map;

import com.example.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeMapService(), new PetServiceMap());
        ownerServiceMap.save(Owner.builder().lastname("Garg").id(1L).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(1L);
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void delete() {
        ownerServiceMap.delete((ownerServiceMap.findById(1L)));
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void saveNoId(){
        Owner savedOwner = ownerServiceMap.save(Owner.builder().build());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void saveExistingId() {
        Owner owner2 = Owner.builder().id(2L).build();
        Owner savedOwner = ownerServiceMap.save(owner2);
        assertEquals(2L, savedOwner.getId());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(1L);
        assertEquals(1L, owner.getId());
    }

    @Test
    void findByLastname() {
        Owner simran = ownerServiceMap.findByLastname("Garg");
        assertNotNull(simran);
        assertEquals("Garg", simran.getLastname());
        assertEquals(1L, simran.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Owner simran = ownerServiceMap.findByLastname("foo");
        assertNull(simran);
    }
}