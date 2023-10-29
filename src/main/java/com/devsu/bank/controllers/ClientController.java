package com.devsu.bank.controllers;

import com.devsu.bank.generated.api.ClienteApi;
import com.devsu.bank.generated.api.models.Client;
import com.devsu.bank.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController implements ClienteApi {

    @Autowired
    private ClientService clientService;

    @Override
    public ResponseEntity<List<Client>> clienteGet() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @Override
    public ResponseEntity<Void> clienteIdDelete(Integer id) {
        clientService.deleteClient(Long.valueOf(id));
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Client> clienteIdGet(Integer id) {
        return ResponseEntity.ok(clientService.getClientById(Long.valueOf(id)));

    }

    @Override
    public ResponseEntity<Client> clienteIdPut(Integer id, Client client) {
        return ResponseEntity.ok(clientService.updateClient(Long.valueOf(id), client));
    }

    @Override
    public ResponseEntity<Client> clientePost(Client client) {
        return ResponseEntity.ok(clientService.createClient(client));
    }
}