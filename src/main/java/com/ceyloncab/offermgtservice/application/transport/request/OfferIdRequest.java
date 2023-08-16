package com.ceyloncab.offermgtservice.application.transport.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferIdRequest {
    @NotNull( message = "OfferId not found for operation. This action is not allowed" )
    @Valid
    private String offerId;
    private String type;

}
