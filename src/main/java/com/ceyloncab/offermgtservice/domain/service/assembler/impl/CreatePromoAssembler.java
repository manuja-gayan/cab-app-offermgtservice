package com.ceyloncab.offermgtservice.domain.service.assembler.impl;

import com.ceyloncab.offermgtservice.application.transport.request.PromoRequest;
import com.ceyloncab.offermgtservice.domain.entity.PromosEntity;
import com.ceyloncab.offermgtservice.domain.service.assembler.Assembler;
import org.springframework.stereotype.Service;

@Service
public class CreatePromoAssembler implements Assembler<PromosEntity, PromoRequest> {
    @Override
    public PromosEntity fromDto(PromoRequest dto) {
        PromosEntity model = new PromosEntity();
        model.setType(dto.getType());
        model.setViewType("List");
        model.setImageRef(dto.getImageRef());
        model.setTitle(dto.getTitle());
        model.setDescription(dto.getDescription());
        model.setPromoType("CASH");
        model.setUnit("PERCENTAGE");
        model.setPromoValue(dto.getPromoValue());
        model.setApplicableVehicle(dto.getApplicableVehicle());
        model.setExpireDate(dto.getExpireDate());
        model.setIsDeleted(false);
        return model;
    }

    @Override
    public PromoRequest toDto(PromosEntity model) {
        return null;
    }

    @Override
    public PromoRequest toDto(PromosEntity model, Object object) {
        return null;
    }
}
