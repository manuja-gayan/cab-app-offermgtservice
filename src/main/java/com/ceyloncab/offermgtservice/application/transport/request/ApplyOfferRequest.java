package com.ceyloncab.offermgtservice.application.transport.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplyOfferRequest {
    @NotNull( message = "OfferId not found for operation. This action is not allowed" )
    @Valid
    private String offerId;
    @NotNull( message = "Type not found for operation. This action is not allowed" )
    @Valid
    private String type;
    @NotNull( message = "UserId  not found for operation. This action is not allowed" )
    @Valid
    private String userId;;
    @NotNull( message = "Apply Type not found for operation. This action is not allowed" )
    @Valid
    private String applyType;
    private String value;
}
