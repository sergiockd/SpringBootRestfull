package com.ccc.vendas.api.rest.controller;


import com.ccc.vendas.api.domain.entity.Cliente;
import com.ccc.vendas.api.repository.ClientesRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ClienteController {


    private ClientesRepository clientesRepository;


    public ClienteController(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }

    @GetMapping("/api/clientes/{id}")
    @ResponseBody
    public ResponseEntity<Cliente> getClienteById(@PathVariable Integer id) {
        Optional<Cliente> cliente = clientesRepository.findById(id);

        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/api/clientes")
    @ResponseBody
    public ResponseEntity saveCliente(@RequestBody Cliente cliente) {
        Cliente clienteSalvo = clientesRepository.save(cliente);
        return ResponseEntity.ok(clienteSalvo);
    }

    @DeleteMapping("/api/clientes/{id}")
    @ResponseBody
    public ResponseEntity<Cliente> deleteCliente(@PathVariable Integer id) {
        Optional<Cliente> cliente = clientesRepository.findById(id);

        if (cliente.isPresent()) {
            clientesRepository.deleteById(id);
            return  ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();

    }

}