package com.dio.desafio.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.dio.desafio.spring.model.AddressModel;

@Repository
public interface AddressRepository extends CrudRepository<AddressModel, String> {
}
