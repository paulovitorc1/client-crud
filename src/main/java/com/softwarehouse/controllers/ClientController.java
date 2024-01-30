package com.softwarehouse.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softwarehouse.entities.Client;
import com.softwarehouse.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

	@Autowired
	private ClientService clientService;
	
    @GetMapping(value = "/{id}")
    public Optional<Client> findById(@PathVariable Long id) {
        Optional<Client> client = clientService.findById(id);
        return client;
    }
    
    @GetMapping
    public List<Client> findAll(Pageable pageable) {
        List<Client> clients = clientService.findAll(pageable);
        return clients;
    }
	
}