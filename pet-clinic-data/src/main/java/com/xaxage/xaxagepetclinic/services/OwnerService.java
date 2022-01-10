package com.xaxage.xaxagepetclinic.services;

import com.xaxage.xaxagepetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
