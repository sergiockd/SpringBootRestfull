package com.ccc.vendas.api;

import com.ccc.vendas.api.domain.entity.Cliente;
import com.ccc.vendas.api.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SystemVendasApplication {

  /*  @Bean
    public CommandLineRunner commandLineRunner (@Autowired ClientesRepository clientes){
        return args -> {
            Cliente c = new Cliente(null, "fulano");
            clientes.save(c);
        };
    }*/

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SystemVendasApplication.class, args);
    }

}
