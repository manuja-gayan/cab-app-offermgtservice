package com.ceyloncab.offermgtservice.domain.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "ClaimedPromos")
public class ClaimedPromosEntity {
    @Id
    private String id;
    private String type;
    private String viewType;
    private String imageRef;
    private String title;
    private String description;
    private String code;
    private String promoType;
    private String unit;
    private Double promoValue;
    private String applicableVehicle;
    private Date expireDate;
    private String userId;
    private String status;
    private Boolean isDeleted;
}
