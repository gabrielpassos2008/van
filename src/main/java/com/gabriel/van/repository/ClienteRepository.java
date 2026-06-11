package com.gabriel.van.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.van.model.Cliente;
import java.util.List;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByEmail(String email);
}
