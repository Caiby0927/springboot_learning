package com.cai.tacocloud.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
/*
  @Data tells Lombok to generate all of those missing methods as well as a constructor that accepts all final properties
  as arguments.
 */
@RequiredArgsConstructor
@Table
public class Ingredient {

    @Id
    private final String id;

    private final String name;

    private final Type type;

    public static enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
