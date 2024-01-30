package com.softwarehouse.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@PostMapping
	public Client insert(@RequestBody Client client) {
		return clientService.insert(client);
	}

	@PutMapping(value = "/{id}")
	public Optional<Object> update(@PathVariable Long id, @RequestBody Client updatedClient) {
		Optional<Object> updated = Optional.ofNullable(clientService.update(id, updatedClient));
		return updated;
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Long id) {
		clientService.delete(id);
	}

}
