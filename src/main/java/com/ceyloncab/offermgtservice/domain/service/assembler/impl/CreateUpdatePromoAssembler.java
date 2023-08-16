package com.ceyloncab.offermgtservice.domain.service.assembler.impl;

import com.ceyloncab.offermgtservice.application.transport.request.PromoRequest;
import com.ceyloncab.offermgtservice.application.transport.request.PromoUpdateRequest;
import com.ceyloncab.offermgtservice.domain.entity.PromosEntity;
import com.ceyloncab.offermgtservice.domain.service.assembler.Assembler;
import org.springframework.stereotype.Service;


@Service
public class CreateUpdatePromoAssembler implements Assembler<PromosEntity, PromoUpdateRequest> {
    @Override
    public PromosEntity fromDto(PromoUpdateRequest dto) {
        PromosEntity model = new PromosEntity();
        model.setImageRef(dto.getImageRef());
        model.setTitle(dto.getTitle());
        model.setDescription(dto.getDescription());
        model.setPromoValue(dto.getPromoValue());
        model.setExpireDate(dto.getExpireDate());
        return model;
    }

    @Override
    public PromoUpdateRequest toDto(PromosEntity model) {
        return null;
    }

    @Override
    public PromoUpdateRequest toDto(PromosEntity model, Object object) {
        return null;
    }
}
