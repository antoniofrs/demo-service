package it.its.demo.demo_service.exceptions;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(String id){
        super("Book not found. Id: " + id);
    }

}
