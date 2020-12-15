package com.reinmind.repository;

import com.reinmind.entities.RedisObject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisObjectRepository extends CrudRepository<RedisObject,String> {

}
