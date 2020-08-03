package com.ccc.vendas.api.rest.controller;


import com.ccc.vendas.api.domain.entity.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/clientes")
public class ClienteController {

    @RequestMapping(
            value = "/hello/{nome}",
            method = RequestMethod.POST,
            consumes = {"application/json","application/xml"},//a forma que vamos receber
            produces = {"application/json","application/xml"}// a forma como vamos retornar o nosso objeto
            )

    @ResponseBody
    public String helloCliente(@PathVariable ("nome") String nomeCliente, @RequestBody Cliente cliente){
        return String.format("Hello %s", nomeCliente);
    }
}
