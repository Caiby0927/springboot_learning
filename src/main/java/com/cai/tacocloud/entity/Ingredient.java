package com.cai.tacocloud.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
/*
  @Data tells Lombok to generate all of those missing methods as well as a constructor that accepts all final properties
  as arguments.
 */
@RequiredArgsConstructor
public class Ingredient {

    private final String id;

    private final String name;

    private final Type type;

    public static enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
