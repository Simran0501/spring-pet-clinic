package com.example.services;

import com.example.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastname(String lastName);

}
