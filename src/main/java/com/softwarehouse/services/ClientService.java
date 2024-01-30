package com.softwarehouse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softwarehouse.entities.Client;
import com.softwarehouse.repositories.ClientRepository;
import com.softwarehouse.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Transactional(readOnly = true)
	public Optional<Client> findById(Long id) {
		Optional<Client> client = Optional.ofNullable(clientRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Recurso não encontrado.")));
		return client;
	}

	@Transactional(readOnly = true)
	public List<Client> findAll(Pageable pageable) {
		Page<Client> clients = clientRepository.findAll(pageable);
		return clients.toList();
	}

	@Transactional
	public Client insert(Client client) {
		return clientRepository.save(client);
	}

	@Transactional
	public Optional<Object> update(Long id, Client updatedClient) {
		return clientRepository.findById(id).map(client -> {
			client.setName(updatedClient.getName());
			client.setCpf(updatedClient.getCpf());
			client.setIncome(updatedClient.getIncome());
			client.setBirthDate(updatedClient.getBirthDate());
			client.setChildren(updatedClient.getChildren());
			return clientRepository.save(client);
		});
	}

	@Transactional
	public void delete(Long id) {
		clientRepository.deleteById(id);
	}

}
