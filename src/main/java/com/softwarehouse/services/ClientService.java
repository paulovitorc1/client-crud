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

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Transactional(readOnly = true)
	public Optional<Client> findById(Long id) {
		Optional<Client> client = clientRepository.findById(id);
		return client;
	}
	
    @Transactional(readOnly = true)
    public List<Client> findAll(Pageable pageable) {
    	Page<Client> clients = clientRepository.findAll(pageable);
        return clients.toList();
    }

}
