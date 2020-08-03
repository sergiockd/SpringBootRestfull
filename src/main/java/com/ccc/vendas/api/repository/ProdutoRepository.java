package com.ccc.vendas.api.repository;

import com.ccc.vendas.api.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {


}
