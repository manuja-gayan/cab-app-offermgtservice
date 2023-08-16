package com.ceyloncab.offermgtservice.domain.service.assembler.impl;

import com.ceyloncab.offermgtservice.application.transport.request.CustomerRequest;
import com.ceyloncab.offermgtservice.domain.entity.CustomerEntity;
import com.ceyloncab.offermgtservice.domain.service.assembler.Assembler;
import org.springframework.stereotype.Service;


@Service
public class CreateCustomerAssembler implements Assembler<CustomerEntity, CustomerRequest> {

    @Override
    public CustomerEntity fromDto(CustomerRequest dto) {
        CustomerEntity model = new CustomerEntity();
        model.setFirstName(dto.getFirstName());
        model.setLastName(dto.getLastName());
        model.setMsisdn(dto.getMsisdn());
        model.setLocation(dto.getLocation());
        return model;
    }

    @Override
    public CustomerRequest toDto(CustomerEntity model) {
        return new CustomerRequest(model.getUserId(),model.getMsisdn(),model.getFirstName(),
                model.getLastName(),model.getLocation());
    }

    @Override
    public CustomerRequest toDto(CustomerEntity model, Object object) {
        return null;
    }
}
