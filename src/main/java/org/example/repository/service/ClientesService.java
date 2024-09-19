package org.example.repository.service;

import org.example.repository.ClientesRepository;
import org.example.repository.service.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientesService {

    private ClientesRepository repository;

    @Autowired
    public ClientesService( ClientesRepository repository) {
        this.repository = repository;
    }

    public void salvarCliente(Cliente cliente) {
        validarCliente(cliente);
        this.repository.persistir(cliente);
        System.out.println("Salvando cliente: " + cliente.getNome());
    }

    public void validarCliente(Cliente cliente) {
        System.out.println("Validando cliente: " + cliente.getNome());
    }
}
