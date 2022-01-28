package guru.springfamework.api.v1.mapper;

import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.domain.Category;
import junit.framework.TestCase;

public class CategoryMapperTest extends TestCase {

    CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    public void testCategoryToCategoryDTO() {
        Category category = new Category();
        category.setName("Joe");
        category.setId(1L);

        CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);

        assertEquals(Long.valueOf(1L), categoryDTO.getId());
        assertEquals("Joe", categoryDTO.getName());
    }
}