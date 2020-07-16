package com.ccc.vendas.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccc.vendas.api.model.Cliente;
import com.ccc.vendas.api.repository.ClientesRepository;

@Service
public class ClientesService {

	// pequeno exemplo de injeção de dependencia, criando um construtor e não
	// instanciando a classe Repository diretamente (é delegado a outra classe a
	// responsabilidade de criar a instancia e injetar)

	@Autowired
	private ClientesRepository repository;

//	public ClientesService(ClientesRepository repository) {
//		this.repository = repository;
//
//	}

	public void salvarCliente(Cliente cliente) { 
		validarCliente(cliente);

		this.repository.persistir(cliente);

	}

	public void validarCliente(Cliente cliente) {
		// Aplica validações
	}

}
