package com.ccc.vendas.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ccc.vendas.api.domain.entity.Cliente;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ClientesRepository extends JpaRepository<Cliente, Integer> {

    @Query (value = "select c from Cliente c where c.nome like :nome ")
    List<Cliente> encontrarPorNome(@Param("nome") String nome);

    @Query(value = "delete from Cliente c where c.nome =:nome")
    @Modifying //pra informação que a tabela será atualizada. Serve tanto pra update quanto pra delete

    void deleteByNome(String nome);

    boolean existsByNome (String nome);

    @Query("select c from Cliente c left join fetch c.pedidos where c.id =:id ") //LeftJoin. Eu posso ter ou não pedidos(Sem o left ele só tras o cliente se exisistir pedidos)
    Cliente findClienteFetchPedidos(@Param("id") Integer id);

 

}
