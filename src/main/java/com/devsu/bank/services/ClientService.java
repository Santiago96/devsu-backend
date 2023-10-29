package com.devsu.bank.services;

import com.devsu.bank.converters.ClientConverter;
import com.devsu.bank.generated.api.models.Client;
import com.devsu.bank.repositories.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client getClientById(long id) {
        return ClientConverter.convertToExpose(clientRepository.findById(id).get());
    }

    public Client createClient(Client client) {
        com.devsu.bank.model.Client clientEntity = ClientConverter.convertToEntity(client);
        return ClientConverter.convertToExpose(clientRepository.save(clientEntity));
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    public Client updateClient(Long id, Client client) {
        com.devsu.bank.model.Client clientEntity = ClientConverter.convertToEntity(client);
        clientEntity.setId(id);
        return ClientConverter.convertToExpose(clientRepository.save(clientEntity));
    }

    public List<Client> getAllClients() {
        List<com.devsu.bank.model.Client> clientList = clientRepository.findAll();
        return clientList.stream().map(client -> ClientConverter.convertToExpose(client)).collect(Collectors.toList());
    }
}
