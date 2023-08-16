package com.ceyloncab.offermgtservice.application.controller;

import com.ceyloncab.offermgtservice.application.transport.request.*;
import com.ceyloncab.offermgtservice.domain.entity.dto.response.CommonResponse;
import com.ceyloncab.offermgtservice.domain.service.OfferManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("${base-url.context}/offer")
public class OfferController extends BaseController{
    @Autowired
    OfferManagementService offerManagementService;


    @PostMapping(value = "/create/Offer/Event", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createOfferEvent(@Validated @RequestBody(required = true)PromoRequest promoRequest, HttpServletRequest request) {
          CommonResponse response = offerManagementService.createOfferEvent(promoRequest);
        return getResponseEntity(response.getResponseHeader().getResponseCode(), response);
    }

    @PostMapping(value = "/create/promo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createPromos(@Validated @RequestBody(required = true)PromoRequest promoRequest, HttpServletRequest request) {
        CommonResponse response = offerManagementService.createPromos(promoRequest);
        return getResponseEntity(response.getResponseHeader().getResponseCode(), response);
    }


    @PostMapping(value = "/update/Offer/Event", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateOfferPromoEvent(@Validated @RequestBody(required = true)PromoUpdateRequest promoUpdateRequest, HttpServletRequest request) {
        CommonResponse response = offerManagementService.updateOfferEvent(promoUpdateRequest);
        return getResponseEntity(response.getResponseHeader().getResponseCode(), response);
    }

    @PostMapping(value = "/update/promo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updatePromo(@Validated @RequestBody(required = true)PromoUpdateRequest promoUpdateRequest, HttpServletRequest request) {
        CommonResponse response = offerManagementService.updatePromo(promoUpdateRequest);
        return getResponseEntity(response.getResponseHeader().getResponseCode(), response);
    }

    @PostMapping(value = "/delete/Offer/Promo/Event", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteOfferPromoEvent(@Validated @RequestBody(required = true) OfferIdRequest offerIdRequest, HttpServletRequest request) {
        CommonResponse response = offerManagementService.deleteOffer(offerIdRequest);
        return getResponseEntity(response.getResponseHeader().getResponseCode(), response);
    }

   @PostMapping(value = "/apply/Offer/Promo/Event", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createApplyOfferPromoEvent(@Validated @RequestBody(required = true) ApplyOfferRequest applyOfferRequest, HttpServletRequest request) {
        CommonResponse response = offerManagementService.createApplyOfferPromoEvent(applyOfferRequest);
        return getResponseEntity(response.getResponseHeader().getResponseCode(), response);
    }

 @PostMapping(value = "/get/Offer/Promo/Event", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getApplyOfferPromoEvent(@Validated @RequestBody(required = true) GetOfferRequest getOfferRequest, HttpServletRequest request) {
        CommonResponse response = offerManagementService.getOffers(getOfferRequest);
        return getResponseEntity(response.getResponseHeader().getResponseCode(), response);
    }



}
