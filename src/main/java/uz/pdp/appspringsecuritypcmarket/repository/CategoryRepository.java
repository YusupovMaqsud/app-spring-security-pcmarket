package uz.pdp.appspringsecuritypcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import uz.pdp.appspringsecuritypcmarket.entity.Address;
import uz.pdp.appspringsecuritypcmarket.entity.Category;
import uz.pdp.appspringsecuritypcmarket.projection.CustomCategory;

@RepositoryRestResource(path = "/category",excerptProjection = CustomCategory.class)
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
