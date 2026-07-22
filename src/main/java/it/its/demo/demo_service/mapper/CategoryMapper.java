package it.its.demo.demo_service.mapper;

import it.its.demo.demo_service.dto.category.ResCategoryDto;
import it.its.demo.demo_service.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public ResCategoryDto toDto(Category category) {
        ResCategoryDto resCategoryDto = new ResCategoryDto();

        resCategoryDto.setId(category.getId());
        resCategoryDto.setName(category.getName());

        return resCategoryDto;
    }

    public Category toModel(ResCategoryDto categoryDto) {
        return new Category(categoryDto.getId(), categoryDto.getName(), null);
    }

}
