package com.desafiopanvel.questao_1.repository;

import com.desafiopanvel.questao_1.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ListaComprasRepository extends JpaRepository<Produto, UUID> {

    @Query("SELECT SUM(p.quantidade) FROM Produto p")
    Integer getContagemProdutos();


    Optional<Produto> findByNomeIgnoreCase(String nome);
}
