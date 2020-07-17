package com.ccc.vendas.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ccc.vendas.api.domain.entity.Cliente;
import com.ccc.vendas.api.repository.ClientesRepository;

@SpringBootApplication
public class SystemVendasApplication {
	
	@Bean
	public CommandLineRunner init (@Autowired ClientesRepository clienteRepository) {
		
		return args ->{
		
			clienteRepository.salvar(new Cliente ("Sergio Roberto Silva"));
			clienteRepository.salvar(new Cliente ("Maria Rosilene"));
			
			List<Cliente> todosClientes = clienteRepository.obterTodos();
			todosClientes.forEach(System.out::println);
			
			todosClientes.forEach(c->{
				c.setNome(c.getNome() + "atulizado.");
			});
		};
	}
	
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SystemVendasApplication.class, args);
	}

}
