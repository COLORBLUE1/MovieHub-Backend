package com.error404squad.MOVIEHUB.service;

import com.error404squad.MOVIEHUB.model.Cliente;
import com.error404squad.MOVIEHUB.respository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente findByEmail(String email) {
        return clienteRepository.findByEmail(email);
    }

    public Optional<Cliente> getClienteById(Long id) {
        return clienteRepository.findById(id);
    }

    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
