package com.ceyloncab.offermgtservice.domain.service;

import com.ceyloncab.offermgtservice.application.aop.AopConstants;
import com.ceyloncab.offermgtservice.application.transport.request.*;
import com.ceyloncab.offermgtservice.domain.entity.AdminEntity;
import com.ceyloncab.offermgtservice.domain.entity.ClaimedPromosEntity;
import com.ceyloncab.offermgtservice.domain.entity.PromosEntity;
import com.ceyloncab.offermgtservice.domain.entity.dto.response.CommonResponse;
import com.ceyloncab.offermgtservice.domain.entity.dto.response.ResponseHeader;
import com.ceyloncab.offermgtservice.domain.entity.dto.response.promos.ApplyOfferDTO;
import com.ceyloncab.offermgtservice.domain.entity.dto.response.promos.ClaimedPromosResponseDTO;
import com.ceyloncab.offermgtservice.domain.entity.dto.response.promos.OfferResponseDTO;
import com.ceyloncab.offermgtservice.domain.exception.DomainException;
import com.ceyloncab.offermgtservice.domain.service.assembler.impl.*;
import com.ceyloncab.offermgtservice.domain.utils.Constants;
import com.ceyloncab.offermgtservice.external.repository.AdminRepository;
import com.ceyloncab.offermgtservice.external.repository.ClaimedPromosRepository;
import com.ceyloncab.offermgtservice.external.repository.OfferRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class OfferManagementService {
    @Autowired
    PromoResponseAssembler promoResponseAssembler;

    @Autowired
    OfferRepository offerRepository;

    @Autowired
    CreatePromoAssembler createPromoAssembler;

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    CreateUpdatePromoAssembler createUpdatePromoAssembler;

    @Autowired
    ClaimedPromosRepository claimedPromosRepository;

    @Autowired
    ApplyClaimedPromosResponseAssembler applyClaimedPromosResponseAssembler;

    @Autowired
    CreateClaimedPromsAssembler createClaimedPromsAssembler;

    @Autowired
    CreatePromosRequestAssembler createPromosRequestAssembler;


    @Autowired
    CreatePromosToClaimedPromoAssembler createPromosToClaimedPromoAssembler;


    public CommonResponse<OfferResponseDTO> createOfferEvent(PromoRequest promoRequest) {
        CommonResponse<OfferResponseDTO> response = new CommonResponse<>();
    AdminEntity adminEntity = adminRepository.findById(MDC.get(AopConstants.MDC_USERID))
                .orElseThrow(() -> {
                    log.error("Admin does not exist for given userId:{}", AopConstants.MDC_USERID);
                    return new DomainException(Constants.ResponseData.ADMIN_NOT_FOUND);
                });
         PromosEntity document;
        try {
         document = createPromoAssembler.fromDto(promoRequest);
           document =offerRepository.save(document);
        }catch (Exception ex) {
            log.error("Error occurred in createUpdateOffer.Error:{}",ex.getMessage());
            response.setResponseHeader(new ResponseHeader(Constants.ResponseData.COMMON_FAIL));
            return response;
        }
        response.setData(promoResponseAssembler.toDto(document));
        response.setResponseHeader(new ResponseHeader(Constants.ResponseData.CREATE_SUCCESS));
        return response;
    }

    public CommonResponse<ClaimedPromosResponseDTO> createPromos(PromoRequest promoRequest) {
        CommonResponse<ClaimedPromosResponseDTO> response = new CommonResponse<>();
        AdminEntity adminEntity = adminRepository.findById(MDC.get(AopConstants.MDC_USERID))
                .orElseThrow(() -> {
                    log.error("Admin does not exist for given userId:{}", AopConstants.MDC_USERID);
                    return new DomainException(Constants.ResponseData.ADMIN_NOT_FOUND);
                });
        ClaimedPromosEntity document;
        try {
            document = createPromosRequestAssembler.fromDto(promoRequest);
            document =claimedPromosRepository.save(document);
        }catch (Exception ex) {
            log.error("Error occurred in createUpdateOffer.Error:{}",ex.getMessage());
            response.setResponseHeader(new ResponseHeader(Constants.ResponseData.COMMON_FAIL));
            return response;
        }
        response.setData(createClaimedPromsAssembler.toDto(document));
        response.setResponseHeader(new ResponseHeader(Constants.ResponseData.CREATE_SUCCESS));
        return response;
    }

    public CommonResponse<OfferResponseDTO> updateOfferEvent(PromoUpdateRequest promoRequest) {
        CommonResponse<OfferResponseDTO> response = new CommonResponse<>();

     AdminEntity adminEntity = adminRepository.findById(MDC.get(AopConstants.MDC_USERID))
                .orElseThrow(() -> {
                    log.error("Admin does not exist for given userId:{}", AopConstants.MDC_USERID);
                    return new DomainException(Constants.ResponseData.ADMIN_NOT_FOUND);
                });
        try {
            Optional<PromosEntity> byId = offerRepository.findById(promoRequest.getOfferId());

            if (!byId.isPresent()){
                log.error("OfferId does not found for given OfferId:{}", promoRequest.getOfferId());
            }
            byId.get().setImageRef(promoRequest.getImageRef());
            byId.get().setTitle(promoRequest.getTitle());
            byId.get().setDescription(promoRequest.getDescription());
            byId.get().setPromoValue(promoRequest.getPromoValue());
            byId.get().setExpireDate(promoRequest.getExpireDate());
            offerRepository.save(byId.get());
            response.setData(promoResponseAssembler.toDto(byId.get()));

        }catch (Exception ex) {
            log.error("Error occurred in updateOffer.Error:{}",ex.getMessage());
            response.setResponseHeader(new ResponseHeader(Constants.ResponseData.COMMON_FAIL));
            return response;
        }
        response.setResponseHeader(new ResponseHeader(Constants.ResponseData.CREATE_SUCCESS));
        return response;
    }

    public CommonResponse<ClaimedPromosResponseDTO> updatePromo(PromoUpdateRequest promoRequest) {
        CommonResponse<ClaimedPromosResponseDTO> response = new CommonResponse<>();

        AdminEntity adminEntity = adminRepository.findById(MDC.get(AopConstants.MDC_USERID))
                .orElseThrow(() -> {
                    log.error("Admin does not exist for given userId:{}", AopConstants.MDC_USERID);
                    return new DomainException(Constants.ResponseData.ADMIN_NOT_FOUND);
                });
        try {
            Optional<ClaimedPromosEntity> byId = claimedPromosRepository.findById(promoRequest.getOfferId());

            if (!byId.isPresent()){
                log.error("PromoId does not found for given OfferId:{}", promoRequest.getOfferId());
            }
            byId.get().setImageRef(promoRequest.getImageRef());
            byId.get().setTitle(promoRequest.getTitle());
            byId.get().setDescription(promoRequest.getDescription());
            byId.get().setPromoValue(promoRequest.getPromoValue());
            byId.get().setExpireDate(promoRequest.getExpireDate());
            claimedPromosRepository.save(byId.get());
            response.setData(createClaimedPromsAssembler.toDto(byId.get()));

        }catch (Exception ex) {
            log.error("Error occurred in updateOffer.Error:{}",ex.getMessage());
            response.setResponseHeader(new ResponseHeader(Constants.ResponseData.COMMON_FAIL));
            return response;
        }
        response.setResponseHeader(new ResponseHeader(Constants.ResponseData.CREATE_SUCCESS));
        return response;
    }

    public CommonResponse deleteOffer(OfferIdRequest offerIdRequest){
        CommonResponse<Object> response = new CommonResponse<>();
           AdminEntity adminEntity = adminRepository.findById(MDC.get(AopConstants.MDC_USERID))
                .orElseThrow(() -> {
                    log.error("Admin does not exist for given userId:{}", AopConstants.MDC_USERID);
                    return new DomainException(Constants.ResponseData.ADMIN_NOT_FOUND);
                });
        try {

            if (offerIdRequest.getType().equals("PROMO")){
                Optional<ClaimedPromosEntity> byId = claimedPromosRepository.findById(offerIdRequest.getOfferId());
                if (!byId.isPresent()){
                    log.error("OfferId does not found for given OfferId:{}", offerIdRequest.getOfferId());
                }
                byId.get().setIsDeleted(true);
                claimedPromosRepository.save(byId.get());
                response.setResponseHeader(new ResponseHeader(Constants.ResponseData.CREATE_SUCCESS));
            }else {
                Optional<PromosEntity> byId = offerRepository.findById(offerIdRequest.getOfferId());

                if (!byId.isPresent()){
                    log.error("OfferId does not found for given OfferId:{}", offerIdRequest.getOfferId());
                }
                byId.get().setIsDeleted(true);
                offerRepository.save(byId.get());
                response.setResponseHeader(new ResponseHeader(Constants.ResponseData.CREATE_SUCCESS));
            }

        }catch (Exception ex) {
            log.error("Error occurred in deleteOffer.Error:{}",ex.getMessage());
            response.setResponseHeader(new ResponseHeader(Constants.ResponseData.COMMON_FAIL));
            return response;
        }
        response.setResponseHeader(new ResponseHeader(Constants.ResponseData.CREATE_SUCCESS));
        return response;

    }

    public CommonResponse<ApplyOfferDTO> createApplyOfferPromoEvent(ApplyOfferRequest applyOfferRequest) {
        CommonResponse<ApplyOfferDTO> response = new CommonResponse<>();

           AdminEntity adminEntity = adminRepository.findById(MDC.get(AopConstants.MDC_USERID))
                .orElseThrow(() -> {
                    log.error("Admin does not exist for given userId:{}", AopConstants.MDC_USERID);
                    return new DomainException(Constants.ResponseData.ADMIN_NOT_FOUND);
                });
        try {
            if (applyOfferRequest.getType().equals("PROMO")){
                Optional<ClaimedPromosEntity> byIdAndAndUserId = claimedPromosRepository.findByIdAndAndUserId(applyOfferRequest.getOfferId(), applyOfferRequest.getUserId());
                if(!byIdAndAndUserId.isPresent()){
                    log.error("Promo  does not found }");
                    response.setResponseHeader(new ResponseHeader(Constants.ResponseData.COMMON_FAIL));
                    return response;
                }

                if (applyOfferRequest.getApplyType().equals("BY_PROMO_CODE")){
                    byIdAndAndUserId.get().setCode(String.valueOf(getPromoCode()));
                    byIdAndAndUserId.get().setStatus("CLAIMED");
                    claimedPromosRepository.save(byIdAndAndUserId.get());
                    response.setData(applyClaimedPromosResponseAssembler.toDto(byIdAndAndUserId.get()));
                    response.setResponseHeader(new ResponseHeader(Constants.ResponseData.CREATE_SUCCESS));
                }else {
                    byIdAndAndUserId.get().setStatus("CLAIMED");

                    claimedPromosRepository.save(byIdAndAndUserId.get());
                    response.setData(applyClaimedPromosResponseAssembler.toDto(byIdAndAndUserId.get()));
                    response.setResponseHeader(new ResponseHeader(Constants.ResponseData.CREATE_SUCCESS));

                }

            }else {
                Optional<PromosEntity> byId = offerRepository.findById(applyOfferRequest.getOfferId());
                if (!byId.isPresent()){
                    log.error("OfferId does not found for given OfferId:{}", applyOfferRequest.getOfferId());
                }
                ClaimedPromosEntity claimedPromosEntity = new ClaimedPromosEntity();
                claimedPromosEntity.setType(byId.get().getType());
                claimedPromosEntity.setViewType(byId.get().getViewType());
                claimedPromosEntity.setImageRef(byId.get().getImageRef());
                claimedPromosEntity.setTitle(byId.get().getTitle());
                claimedPromosEntity.setDescription(byId.get().getDescription());
                claimedPromosEntity.setPromoType(byId.get().getPromoType());
                claimedPromosEntity.setUnit(byId.get().getUnit());
                claimedPromosEntity.setPromoValue(byId.get().getPromoValue());
                claimedPromosEntity.setExpireDate(byId.get().getExpireDate());
                claimedPromosEntity.setUserId(applyOfferRequest.getUserId());
                claimedPromosEntity.setApplicableVehicle(byId.get().getApplicableVehicle());
                claimedPromosEntity.setStatus("CLAIMED");

                claimedPromosRepository.save(claimedPromosEntity);
                response.setData(applyClaimedPromosResponseAssembler.toDto(claimedPromosEntity));
                response.setResponseHeader(new ResponseHeader(Constants.ResponseData.CREATE_SUCCESS));

            }

        }catch (Exception ex) {
        log.error("Error occurred in updateOffer.Error:{}",ex.getMessage());
        response.setResponseHeader(new ResponseHeader(Constants.ResponseData.COMMON_FAIL));
        return response;
    }

        response.setResponseHeader(new ResponseHeader(Constants.ResponseData.CREATE_SUCCESS));
        return response;

        }

   public CommonResponse<List<ClaimedPromosResponseDTO>> getOffers(GetOfferRequest getOfferRequest) {

       CommonResponse<List<ClaimedPromosResponseDTO>> response = new CommonResponse<>();
       List<ClaimedPromosResponseDTO> promoResponseDTOList = new ArrayList<>();

       AdminEntity adminEntity = adminRepository.findById(MDC.get(AopConstants.MDC_USERID))
               .orElseThrow(() -> {
                   log.error("Admin does not exist for given userId:{}", AopConstants.MDC_USERID);
                   return new DomainException(Constants.ResponseData.ADMIN_NOT_FOUND);
               });

       try {
           if (getOfferRequest.getStatus().equals("CLAIMED")) {

               String type = getOfferRequest.getType();
               switch (type) {
                   case "ALL":
                       List<ClaimedPromosEntity> byUserId = claimedPromosRepository.findByUserIdAndStatus(getOfferRequest.getUserId(), getOfferRequest.getStatus());
                       for (ClaimedPromosEntity claimedPromosEntity1 : byUserId) {
                           promoResponseDTOList.add(createClaimedPromsAssembler.toDto(claimedPromosEntity1));
                       }
                       response.setData(promoResponseDTOList);
                       response.setResponseHeader(new ResponseHeader(Constants.ResponseData.QUERY_SUCCESS));
                       break;
                   case "ADMIN_ALL":
                       List<ClaimedPromosEntity> byUserIds = claimedPromosRepository.findByUserIdAndStatus(getOfferRequest.getUserId(), getOfferRequest.getStatus());
                       for (ClaimedPromosEntity claimedPromosEntity1 : byUserIds) {
                           promoResponseDTOList.add(createClaimedPromsAssembler.toDto(claimedPromosEntity1));
                       }
                       response.setData(promoResponseDTOList);
                       response.setResponseHeader(new ResponseHeader(Constants.ResponseData.QUERY_SUCCESS));
                       break;

                   default:
                       List<ClaimedPromosEntity> byUserIdAndType = claimedPromosRepository.findByUserIdAndTypeAndStatus(getOfferRequest.getUserId(), getOfferRequest.getType(), getOfferRequest.getStatus());
                       for (ClaimedPromosEntity claimedPromosEntity1 : byUserIdAndType) {
                           promoResponseDTOList.add(createClaimedPromsAssembler.toDto(claimedPromosEntity1));
                       }
                       response.setData(promoResponseDTOList);
                       response.setResponseHeader(new ResponseHeader(Constants.ResponseData.QUERY_SUCCESS));
                       break;

               }

           } else if (getOfferRequest.getStatus().equals("ASSIGNED")) {

               List<ClaimedPromosEntity> byUserIdAndType = claimedPromosRepository.findByUserIdAndTypeAndStatus(getOfferRequest.getUserId(), getOfferRequest.getType(), getOfferRequest.getStatus());
               for (ClaimedPromosEntity claimedPromosEntity1 : byUserIdAndType) {
                   promoResponseDTOList.add(createClaimedPromsAssembler.toDto(claimedPromosEntity1));
               }
               response.setData(promoResponseDTOList);
               response.setResponseHeader(new ResponseHeader(Constants.ResponseData.QUERY_SUCCESS));

           } else {
               String type = getOfferRequest.getType();
               switch (type) {
                   case "ALL":
                       List<PromosEntity> all = offerRepository.findAll();
                       for (PromosEntity promosEntity : all) {
                           promoResponseDTOList.add(createPromosToClaimedPromoAssembler.toDto(promosEntity));
                       }
                       response.setData(promoResponseDTOList);
                       response.setResponseHeader(new ResponseHeader(Constants.ResponseData.QUERY_SUCCESS));
                       break;

                   case "ADMIN_ALL":
                       List<PromosEntity> alls = offerRepository.findAll();
                       for (PromosEntity promosEntity : alls) {
                           promoResponseDTOList.add(createPromosToClaimedPromoAssembler.toDto(promosEntity));
                       }
                       response.setData(promoResponseDTOList);
                       response.setResponseHeader(new ResponseHeader(Constants.ResponseData.QUERY_SUCCESS));
                       break;

                   default:
                       List<PromosEntity> byType = offerRepository.findByType(getOfferRequest.getType());

                       for (PromosEntity promosEntity : byType) {
                           promoResponseDTOList.add(createPromosToClaimedPromoAssembler.toDto(promosEntity));
                       }
                       response.setData(promoResponseDTOList);
                       response.setResponseHeader(new ResponseHeader(Constants.ResponseData.QUERY_SUCCESS));
                       break;
               }
           }

        }catch (Exception ex) {
            log.error("Error occurred in deleteOffer.Error:{}", ex.getMessage());
        }
        response.setResponseHeader(new ResponseHeader(Constants.ResponseData.QUERY_SUCCESS));
        return response;

    }


    public Long getPromoCode() {
        final Long LIMIT = 10000L;
        final Long deltaId = Long.parseLong(Long.toString(Long.parseLong((java.time.LocalDate.now()
                .format(DateTimeFormatter
                        .ofPattern("yyMMdd")))))
                .concat(Long.toString(System.currentTimeMillis() % LIMIT)));
        System.out.println("deltaId" + deltaId);
        return deltaId;

    }

}
