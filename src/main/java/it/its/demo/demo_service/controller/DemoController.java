/*
Ricevere una richiesta POST che compone questa frase chiedendo in input:

- Un path parameter "a"
- Un query param "q"
- Un header "My-Custom-Header"
- Un body "body"

"Ho ricevuto il Path parameter: " + a
+ ", Il query param q: " + q
+ ", l'header My-Custom-Header: " + myCustomHeader
+ ",Il body: " + body;

 */

package it.its.demo.demo_service.controller;


import it.its.demo.demo_service.exceptions.CustomException;
import it.its.demo.demo_service.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo")
public class DemoController {

    @PostMapping("/{a}/v1")
    public String mirror(
            @PathVariable String a,
            @RequestParam String q,
            @RequestHeader("My-Custom-Header") String header,
            @RequestBody String body
    ){
        return "Ho ricevuto il Path parameter: " + a
                + ", Il query param q: " + q
                + ", L'header è: " + header
                + "Body: " + body;
    }

    @GetMapping("/v1")
    @ResponseStatus(HttpStatus.OK)
    public Book simulate() {
        throw new CustomException();
    }


}
