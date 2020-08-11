package com.ccc.vendas.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
