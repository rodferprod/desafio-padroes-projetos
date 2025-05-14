package com.dio.desafio.spring.service.interfaces;

import com.dio.desafio.spring.model.ClientModel;

public interface ClientServiceInterface {

    Iterable<ClientModel> getAll();

    ClientModel getById(Long id);

    void create(ClientModel client);

    void update(Long id, ClientModel client);

    void delete(Long id);
}
