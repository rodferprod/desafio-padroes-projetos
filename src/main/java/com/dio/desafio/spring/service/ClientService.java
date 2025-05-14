package com.dio.desafio.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.desafio.spring.model.AddressModel;
import com.dio.desafio.spring.model.ClientModel;
import com.dio.desafio.spring.repository.AddressRepository;
import com.dio.desafio.spring.repository.ClientRepository;
import com.dio.desafio.spring.service.interfaces.ClientServiceInterface;
import com.dio.desafio.spring.service.interfaces.AddressServiceInterface;

/**
 * Singleton: Injeção dos componentes com @Autowired
 * Strategy: Implementar métodos definidos na interface
 * Facade: Promover uma interface simples integrando subsistemas
 */

@Service
public class ClientService implements ClientServiceInterface {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private AddressServiceInterface addressService;

    @Override
    public Iterable<ClientModel> getAll() {
        // Buscar todos os clientes
        return clientRepository.findAll();
    }

    @Override
    public ClientModel getById(Long id) {
        // Buscar cliente pelo id
        Optional<ClientModel> client = clientRepository.findById(id);
        return client.get();
    }

    @Override
    public void create(ClientModel client) {
        checkAndSaveClientAndAddress(client);
    }

    @Override
    public void update(Long id, ClientModel client) {

        // Localizar o cliente pelo id;
        Optional<ClientModel> clientExists = clientRepository.findById(id);

        if (clientExists.isPresent()) {
            checkAndSaveClientAndAddress(client);
        }
    }

    @Override
    public void delete(Long id) {
        // Excluir cliente pelo id
        clientRepository.deleteById(id);
    }

    private void checkAndSaveClientAndAddress(ClientModel client) {
        // Pegando o CEP do cliente
        String cep = client.getAddress().getCep();

        // Verificar se o CEP do cliente já existe
        AddressModel address = addressRepository.findById(cep).orElseGet(() -> {
            // Caso não encontre consultar endereço na API
            AddressModel newAddress = addressService.searchCep(cep);
            // Salvar novo endereço
            addressRepository.save(newAddress);
            return newAddress;
        });

        // Vincular endereço ao cliente
        client.setAddress(address);

        // Salvar o cliente
        clientRepository.save(client);
    }

}
