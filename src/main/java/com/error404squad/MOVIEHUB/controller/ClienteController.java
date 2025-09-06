package com.error404squad.MOVIEHUB.controller;

import com.error404squad.MOVIEHUB.model.Cliente;
import com.error404squad.MOVIEHUB.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> getAll() {
        return clienteService.getClientes();
    }

    @PostMapping
    public Cliente create(@RequestBody Cliente cliente) {
        return clienteService.saveCliente(cliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.getClienteById(id);
        return cliente.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente updatedCliente) {
        Optional<Cliente> existing = clienteService.getClienteById(id);
        if (existing.isPresent()) {
            Cliente cliente = existing.get();
            cliente.setNombre(updatedCliente.getNombre());
            cliente.setEmail(updatedCliente.getEmail());
            cliente.setPassword(updatedCliente.getPassword());
            Cliente saved = clienteService.saveCliente(cliente);
            return ResponseEntity.ok(saved);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Cliente> existing = clienteService.getClienteById(id);
        if (existing.isPresent()) {
            clienteService.deleteCliente(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
