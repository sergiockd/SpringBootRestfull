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
    public CommandLineRunner init(@Autowired ClientesRepository clienteRepository) {

        return args -> {

            System.out.println("Salvando Clientes");
            clienteRepository.salvar(new Cliente("Sergio Roberto Silva"));
            clienteRepository.salvar(new Cliente("Maria Rosilene"));

            List<Cliente> todosClientes = clienteRepository.obterTodos();
            todosClientes.forEach(System.out::println);

            System.out.println("Atualizando Clientes");
            todosClientes.forEach(c -> {
                c.setNome(c.getNome() + " atualizados.");
                clienteRepository.atualizar(c);
            });
            todosClientes = clienteRepository.obterTodos();
            todosClientes.forEach(System.out::println);

            System.out.println("Buscando Cliente por nome");
            clienteRepository.buscarPorNome("gio").forEach(System.out::println);

            System.out.println("Deletando Clientes");
            clienteRepository.obterTodos().forEach(c -> {
                clienteRepository.deletar(c);
            });

            System.out.println("Buscando por todos os clientes");
            todosClientes = clienteRepository.obterTodos();
            if (todosClientes.isEmpty()) {
                System.out.println("Nenhum Cliente encontrado");
            } else {

                todosClientes.forEach(System.out::println);
            }

        };
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SystemVendasApplication.class, args);
    }

}
