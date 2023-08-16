package com.ceyloncab.offermgtservice.external.repository;

import com.ceyloncab.offermgtservice.domain.entity.ClaimedPromosEntity;
import com.ceyloncab.offermgtservice.domain.entity.PromosEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClaimedPromosRepository extends MongoRepository<ClaimedPromosEntity,String> {

    List<ClaimedPromosEntity> findByUserIdAndType(String userId,String type);
    List<ClaimedPromosEntity> findByUserIdAndTypeAndStatus(String userId,String type,String status);
    List<ClaimedPromosEntity> findByUserId(String userId);
    List<ClaimedPromosEntity> findByUserIdAndStatus(String userId,String status);
    Optional<ClaimedPromosEntity> findByIdAndAndUserId(String id, String userId);
}
