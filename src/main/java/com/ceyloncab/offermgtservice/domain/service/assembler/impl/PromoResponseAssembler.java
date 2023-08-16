package com.ceyloncab.offermgtservice.domain.service.assembler.impl;

import com.ceyloncab.offermgtservice.domain.entity.PromosEntity;
import com.ceyloncab.offermgtservice.domain.entity.dto.response.promos.OfferResponseDTO;
import com.ceyloncab.offermgtservice.domain.service.assembler.Assembler;
import org.springframework.stereotype.Service;

@Service
public class PromoResponseAssembler implements Assembler<PromosEntity, OfferResponseDTO> {

    @Override
    public PromosEntity fromDto(OfferResponseDTO dto) {
        return null;
    }

    @Override
    public OfferResponseDTO toDto(PromosEntity model) {
        return  new OfferResponseDTO(model.getId(), model.getType(), model.getViewType(), model.getImageRef(), model.getTitle(),
                model.getDescription(),  model.getPromoType(), model.getUnit(),  model.getPromoValue(), model.getApplicableVehicle(),
                model.getExpireDate(),model.getIsDeleted());
    }

    @Override
    public OfferResponseDTO toDto(PromosEntity model, Object object) {
        return null;
    }
}
