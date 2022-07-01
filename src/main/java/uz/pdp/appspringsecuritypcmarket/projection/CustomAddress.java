package uz.pdp.appspringsecuritypcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appspringsecuritypcmarket.entity.Address;

@Projection(types = Address.class)
public interface CustomAddress {
    Integer getId();

    String getCity();

    String getStreet();

    Integer getHouseNumber();
}
