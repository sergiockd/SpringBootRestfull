package com.ccc.vendas.api.repository;

import com.ccc.vendas.api.domain.entity.Cliente;
import com.ccc.vendas.api.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    List<Pedido> findByCliente(Cliente cliente);
}
