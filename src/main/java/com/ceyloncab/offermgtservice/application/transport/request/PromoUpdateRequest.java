package com.ceyloncab.offermgtservice.application.transport.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoUpdateRequest {
    @NotNull( message = "OfferId not found for operation. This action is not allowed" )
    @Valid
    private String offerId;
    private String type;
    private String imageRef;
    private String title;
    private String description;
    private Double promoValue;
    private Date expireDate;
}
