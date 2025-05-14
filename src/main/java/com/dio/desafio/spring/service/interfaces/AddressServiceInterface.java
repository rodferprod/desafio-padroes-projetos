package com.dio.desafio.spring.service.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dio.desafio.spring.model.AddressModel;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface AddressServiceInterface {

    @GetMapping("/{cep}/json")
    AddressModel searchCep(@PathVariable("cep") String cep);
}
