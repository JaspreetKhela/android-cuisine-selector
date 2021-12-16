package com.ut.cuisineselector;

public class Dish {
    // Add variables for the dish's cuisine, name, and description to be used in instances of a Dish object
    private String cuisine;
    private String name;
    private String description;

    // Define the constructor method for creating instances of a Dish
    private Dish(String cuisine, String name, String description) {
        this.cuisine = cuisine;
        this.name = name;
        this.description = description;
    }

    // Define a method for retrieving the cuisine of an instance of a Dish object
    public String getCuisine() {
        return cuisine;
    }

    // Define a method for retrieving the name of an instance of a Dish object
    public String getName() {
        return name;
    }

    // Define a method for retrieving the description of an instance of a Dish object
    public String getDescription() {
        return description;
    }

    // Define a few instances of the a Dish object
    public static final Dish[] dishes = {
            new Dish("Indian" ,"Samosas", "A triangular savory pastry fried in ghee or oil, containing spiced vegetables or meat."),
            new Dish("Chinese" ,"Chow Mein", "A dish of fried noodles with shredded meat or seafood and vegetables."),
            new Dish("Italian" ,"Ravioli", "A dish that contains small pasta envelopes containing ground meat, cheese, or vegetables.")
    };
}