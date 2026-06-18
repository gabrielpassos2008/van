package com.gabriel.van.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.van.model.Cliente;

//import jakarta.transaction.Transactional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
  Optional<Cliente> findByEmail(String email);

  // @Transactional
  // void deleteById1(Long id);

}
