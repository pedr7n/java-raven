package com.pedro.javaWithMichelli.repositories;

import com.pedro.javaWithMichelli.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository // já estamos utilizando o 'extends jparepository', então o spring já sabe que é um bean dele. Mas, por boas práticas, vamo colocar essa anotacão mesmo assim.
public interface ProductRepository extends JpaRepository<ProductModel, UUID> {
}
