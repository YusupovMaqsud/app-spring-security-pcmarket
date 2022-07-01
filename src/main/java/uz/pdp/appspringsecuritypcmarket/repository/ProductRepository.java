package uz.pdp.appspringsecuritypcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appspringsecuritypcmarket.entity.Address;
import uz.pdp.appspringsecuritypcmarket.entity.Product;


public interface ProductRepository extends JpaRepository<Product,Integer> {
    boolean existsByNameAndCategory_Id(String name, Integer category_id);
}
