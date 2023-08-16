package com.ceyloncab.offermgtservice.external.repository;

import com.ceyloncab.offermgtservice.domain.entity.AdminEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends MongoRepository<AdminEntity,String> {
}
