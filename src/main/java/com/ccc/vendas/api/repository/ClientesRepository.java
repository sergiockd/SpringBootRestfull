package com.ccc.vendas.api.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ccc.vendas.api.domain.entity.Cliente;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Repository
public class ClientesRepository {


    @Autowired
    private EntityManager entityManager;

    @Transactional
    //a anotação Transactional serve para informar que o o metodo vai gerar uma transação na base de dados.
    public Cliente salvar(Cliente cliente) {
        entityManager.persist(cliente);
        return cliente;
    }

    //Buscar todos os clientes
    @Transactional(readOnly = true)
    public List<Cliente> obterTodos() {
        return entityManager.
                createQuery("from Cliente", Cliente.class).
                getResultList();
    }

    //Busca cliente por nome
    @Transactional(readOnly = true) //Informa que Transação é apenas de leitura
    public List<Cliente> buscarPorNome(String nome) {
        String jpql = "select c from Cliente c where c.nome like :nome ";  //fazendo a query jpql
        TypedQuery<Cliente> query = entityManager.createQuery(jpql, Cliente.class); //chamando o EM e passando a query e a entidade q deve ser criada
        query.setParameter("nome", "%" + nome + "%"); //setando os parametros da consulta
        return query.getResultList(); // retornando a consulta
    }

    //atualiza o cliente na base
    @Transactional
    public Cliente atualizar (Cliente cliente) {
        //metodo no entityManager que é utilizado para atualizar uma entidade.
        entityManager.merge(cliente);
        return cliente;
    }

    //Deletar cliente por nome
    @Transactional
    public void deletar(Cliente cliente) {
        if (!entityManager.contains(cliente)){
            cliente = entityManager.merge(cliente); // caso a Entidade Cliente não esteja sync com o EM realizmos um merge pra syncar, em caso de erro DETACHED DELETE
        }
        entityManager.remove(cliente);
    }

    //Deletar cliente por ID
    @Transactional
    public void deletar(Integer id) {
        Cliente cliente = entityManager.find(Cliente.class, id);

        deletar(cliente);
    }

}
