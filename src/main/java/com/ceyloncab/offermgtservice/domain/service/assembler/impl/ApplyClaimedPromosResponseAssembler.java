package com.ceyloncab.offermgtservice.domain.service.assembler.impl;

import com.ceyloncab.offermgtservice.application.transport.request.PromoRequest;
import com.ceyloncab.offermgtservice.domain.entity.ClaimedPromosEntity;
import com.ceyloncab.offermgtservice.domain.entity.PromosEntity;
import com.ceyloncab.offermgtservice.domain.entity.dto.response.promos.ApplyOfferDTO;
import com.ceyloncab.offermgtservice.domain.service.assembler.Assembler;
import org.springframework.stereotype.Service;

@Service
public class ApplyClaimedPromosResponseAssembler  implements Assembler<ClaimedPromosEntity, ApplyOfferDTO> {
    @Override
    public ClaimedPromosEntity fromDto(ApplyOfferDTO dto) {
        return null;
    }

    @Override
    public ApplyOfferDTO toDto(ClaimedPromosEntity model) {
        return new ApplyOfferDTO(model.getPromoType(), model.getUnit(), model.getPromoValue(), model.getApplicableVehicle());
    }

    @Override
    public ApplyOfferDTO toDto(ClaimedPromosEntity model, Object object) {
        return null;
    }
}
