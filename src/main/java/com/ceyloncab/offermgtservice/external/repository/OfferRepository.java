package com.ceyloncab.offermgtservice.external.repository;

import com.ceyloncab.offermgtservice.domain.entity.PromosEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OfferRepository extends MongoRepository<PromosEntity,String> {
    Optional<PromosEntity>findByIdAndAndUserId(String id,String userId);
    List<PromosEntity>findByType(String type);
}
