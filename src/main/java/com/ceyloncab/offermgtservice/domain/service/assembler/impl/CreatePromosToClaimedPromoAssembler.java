package com.ceyloncab.offermgtservice.domain.service.assembler.impl;

import com.ceyloncab.offermgtservice.domain.entity.PromosEntity;
import com.ceyloncab.offermgtservice.domain.entity.dto.response.promos.ClaimedPromosResponseDTO;
import com.ceyloncab.offermgtservice.domain.service.assembler.Assembler;
import org.springframework.stereotype.Service;


@Service
public class CreatePromosToClaimedPromoAssembler implements Assembler<PromosEntity, ClaimedPromosResponseDTO> {
    @Override
    public PromosEntity fromDto(ClaimedPromosResponseDTO dto) {
        return null;
    }

    @Override
    public ClaimedPromosResponseDTO toDto(PromosEntity model) {
        return new ClaimedPromosResponseDTO(model.getId(), model.getType(), model.getViewType(), model.getImageRef(), model.getTitle(), model.getDescription(),
                model.getCode(), model.getPromoType(), model.getUnit(), model.getPromoValue(), model.getApplicableVehicle(), model.getExpireDate(),
                model.getUserId() );
    }

    @Override
    public ClaimedPromosResponseDTO toDto(PromosEntity model, Object object) {
        return null;
    }
}
