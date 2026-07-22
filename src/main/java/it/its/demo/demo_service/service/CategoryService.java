package it.its.demo.demo_service.service;

import it.its.demo.demo_service.dto.category.ResCategoryDto;
import it.its.demo.demo_service.exceptions.CategoriesNotFoundException;
import it.its.demo.demo_service.mapper.CategoryMapper;
import it.its.demo.demo_service.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository  categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    public List<ResCategoryDto> findAllByIds(List<Integer> ids) {
        List<ResCategoryDto> categoriesDto = new ArrayList<>();

        categoriesDto = categoryRepository.findAllById(ids).stream()
                .map(category -> categoryMapper.toDto(category)).collect(Collectors.toList());

        if (categoriesDto.isEmpty())
            throw new CategoriesNotFoundException();

        return categoriesDto;
    }

    public List<ResCategoryDto> findAll() {
        return categoryRepository.findAll().stream()
                .map(category -> categoryMapper.toDto(category)).toList();
    }


}
