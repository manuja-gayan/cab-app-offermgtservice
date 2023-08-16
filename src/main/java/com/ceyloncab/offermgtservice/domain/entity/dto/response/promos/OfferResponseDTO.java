package com.ceyloncab.offermgtservice.domain.entity.dto.response.promos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferResponseDTO {
    private String id;
    private String type;
    private String viewType;
    private String imageRef;
    private String title;
    private String description;
    private String promoType;
    private String unit;
    private Double promoValue;
    private String applicableVehicle;
    private Date expireDate;
    private Boolean isDeleted;
}
