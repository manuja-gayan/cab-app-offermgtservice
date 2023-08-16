package com.ceyloncab.offermgtservice.domain.entity.dto.response.promos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplyOfferDTO {
    private String promoType;
    private String unit;
    private Double promoValue;
    private String applicableVehicle;
}
