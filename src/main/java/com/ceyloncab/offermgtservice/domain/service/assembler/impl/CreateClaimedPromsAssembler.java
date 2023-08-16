package com.ceyloncab.offermgtservice.domain.service.assembler.impl;

import com.ceyloncab.offermgtservice.domain.entity.ClaimedPromosEntity;
import com.ceyloncab.offermgtservice.domain.entity.dto.response.promos.ClaimedPromosResponseDTO;
import com.ceyloncab.offermgtservice.domain.service.assembler.Assembler;
import org.springframework.stereotype.Service;

@Service
public class CreateClaimedPromsAssembler implements Assembler<ClaimedPromosEntity, ClaimedPromosResponseDTO> {
    @Override
    public ClaimedPromosEntity fromDto(ClaimedPromosResponseDTO dto) {
        return null;
    }

    @Override
    public ClaimedPromosResponseDTO toDto(ClaimedPromosEntity model) {
        return new ClaimedPromosResponseDTO(model.getId(), model.getType(), model.getViewType(), model.getImageRef(), model.getTitle(),
                model.getDescription(), model.getCode(), model.getPromoType(), model.getUnit(), model.getPromoValue(), model.getApplicableVehicle(),
                model.getExpireDate(), model.getUserId());
    }

    @Override
    public ClaimedPromosResponseDTO toDto(ClaimedPromosEntity model, Object object) {
        return null;
    }
}
