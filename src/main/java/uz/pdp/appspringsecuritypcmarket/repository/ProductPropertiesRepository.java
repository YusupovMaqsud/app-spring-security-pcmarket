package uz.pdp.appspringsecuritypcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.appspringsecuritypcmarket.entity.Address;
import uz.pdp.appspringsecuritypcmarket.projection.CustomAddress;
import uz.pdp.appspringsecuritypcmarket.projection.CustomProductRepository;

@RepositoryRestResource(path = "/productproperties",excerptProjection = CustomProductRepository.class)
public interface ProductPropertiesRepository extends JpaRepository<ProductRepository,Integer> {
}
