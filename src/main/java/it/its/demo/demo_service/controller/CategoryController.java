package it.its.demo.demo_service.controller;

import it.its.demo.demo_service.dto.category.ResCategoryDto;
import it.its.demo.demo_service.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/v1")
    @ResponseStatus(HttpStatus.OK)
    public List<ResCategoryDto> findAll(){
        return categoryService.findAll();
    }
}
