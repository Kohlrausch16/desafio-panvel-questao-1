package com.desafiopanvel.questao_1.repository;

import com.desafiopanvel.questao_1.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GroceryListRepository extends JpaRepository<Product, UUID> {
}
