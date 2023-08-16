package com.ceyloncab.offermgtservice.domain.service.assembler.impl;

import com.ceyloncab.offermgtservice.application.transport.request.PromoRequest;
import com.ceyloncab.offermgtservice.domain.entity.ClaimedPromosEntity;
import com.ceyloncab.offermgtservice.domain.entity.dto.response.promos.ClaimedPromosResponseDTO;
import com.ceyloncab.offermgtservice.domain.service.assembler.Assembler;
import org.springframework.stereotype.Service;

@Service
public class CreatePromosRequestAssembler implements Assembler<ClaimedPromosEntity, PromoRequest> {
    @Override
    public ClaimedPromosEntity fromDto(PromoRequest dto) {
        ClaimedPromosEntity model = new ClaimedPromosEntity();
        model.setType(dto.getType());
        model.setViewType("LIST");
        model.setImageRef(dto.getImageRef());
        model.setTitle(dto.getTitle());
        model.setDescription(dto.getDescription());
        model.setCode("");
        model.setPromoType("CASH");
        model.setUnit("PERCENTAGE");
        model.setPromoValue(dto.getPromoValue());
        model.setApplicableVehicle(dto.getApplicableVehicle());
        model.setExpireDate(dto.getExpireDate());
        model.setUserId(dto.getUserId());
        model.setStatus("ASSIGNED");
        model.setIsDeleted(false);
        return model;
    }

    @Override
    public PromoRequest toDto(ClaimedPromosEntity model) {
        return null;
    }

    @Override
    public PromoRequest toDto(ClaimedPromosEntity model, Object object) {
        return null;
    }
}
