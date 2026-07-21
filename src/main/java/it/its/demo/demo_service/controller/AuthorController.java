package it.its.demo.demo_service.controller;

import it.its.demo.demo_service.dto.author.ResAuthorDto;
import it.its.demo.demo_service.dto.author.ReqInsertAuthorDto;
import it.its.demo.demo_service.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/{id}/v1")
    @ResponseStatus(HttpStatus.OK)
    public ResAuthorDto findById(
            @PathVariable Integer id
    ) {
        return authorService.findById(id);
    }

    @PostMapping("/v1")
    @ResponseStatus(HttpStatus.CREATED)
    public ResAuthorDto insert(
            @Valid @RequestBody ReqInsertAuthorDto reqInsertAuthorDto
            ) {
        return authorService.insert(reqInsertAuthorDto);
    }

    @DeleteMapping("/{id}/v1")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable Integer id
    ) {
        authorService.delete(id);
    }


}
