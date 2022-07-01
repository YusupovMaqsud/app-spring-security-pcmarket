package uz.pdp.appspringsecuritypcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appspringsecuritypcmarket.entity.Product;
import uz.pdp.appspringsecuritypcmarket.entity.ProductProperties;

@Projection(types = ProductProperties.class)
public interface CustomProductRepository {
    Integer grtId();

    String getKey();

    String getValue();

    Product getProduct();
}
