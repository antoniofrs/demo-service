package it.its.demo.demo_service.exceptions;

import it.its.demo.demo_service.dto.InsertBook;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(CustomException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleException(CustomException e){
        return e.getMessage();
    }

//    @ExceptionHandler(BookNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public String bookNotFound(BookNotFoundException e){
//        return e.getMessage();
//    }

    @ExceptionHandler(AuthorNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleAuthorNotFoundException(AuthorNotFoundException e){
        return e.getMessage();
    }


    @ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, Object> bookNotFound(BookNotFoundException e){
        Map <String, Object> result= new HashMap<>();

        result.put("timpestamp: ", LocalDateTime.now());
        result.put("Status: ", HttpStatus.NOT_FOUND);
        result.put("Message: ", e.getMessage());
        return result;
    }

    @ExceptionHandler(BooksNotAvailable.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String bookNotFound(BooksNotAvailable e){
        return e.getMessage();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String badInput(MethodArgumentNotValidException ex){
        return ex.getBindingResult().getFieldErrors().stream()
                .map(err -> err.getField() + ": " + err.getDefaultMessage())
                .collect(Collectors.joining(", "));
    }


}
