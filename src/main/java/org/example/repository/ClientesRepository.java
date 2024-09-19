package org.example.repository;

import org.example.repository.service.model.Cliente;
import org.springframework.stereotype.Repository;

@Repository
public class ClientesRepository {
    public void persistir(Cliente cliente) {
        System.out.println("Persistindo cliente: " + cliente.getNome());
    }
}
