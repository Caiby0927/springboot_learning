package com.cai.tacocloud.data;

import com.cai.tacocloud.entity.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

//    Iterable<Ingredient> findAll();
//
//    Optional<Ingredient> findById(String id);
//
//    Ingredient save(Ingredient ingredient);
}
