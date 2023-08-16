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
public class PromoRequest {
    @NotNull( message = "Type not found for operation. This action is not allowed" )
    @Valid
    private String type;
    private String imageRef;
    @NotNull( message = "Title not found for operation. This action is not allowed" )
    @Valid
    private String title;
    @NotNull( message = "Description  not found for operation. This action is not allowed" )
    @Valid
    private String description;
    private Double promoValue;
    private String applicableVehicle;
    @NotNull( message = "Expire Date not found for operation. This action is not allowed" )
    @Valid
    private Date expireDate;
    private String userId;

}
