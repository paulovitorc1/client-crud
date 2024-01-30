package com.softwarehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softwarehouse.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
