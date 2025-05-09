package com.exemplo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exemplo.api.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}