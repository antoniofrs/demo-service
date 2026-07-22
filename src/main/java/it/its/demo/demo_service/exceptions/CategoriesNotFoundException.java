package it.its.demo.demo_service.exceptions;

import java.util.List;

public class CategoriesNotFoundException extends RuntimeException{

    public CategoriesNotFoundException() {
        super("Categorie non presenti in database");
    }

}
