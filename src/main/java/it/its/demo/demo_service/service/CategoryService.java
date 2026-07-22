package it.its.demo.demo_service.service;

import it.its.demo.demo_service.model.Category;
import it.its.demo.demo_service.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> findAllById(List<Integer> categoryIds) {
        return categoryRepository.findAllById(categoryIds);
    }

}
