package it.its.demo.demo_service.exceptions;

public class CustomException extends RuntimeException {
    public CustomException(){
        super("Questo è il messaggio dell'eccezione");
    }
}
