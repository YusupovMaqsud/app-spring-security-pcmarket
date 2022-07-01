package uz.pdp.appspringsecuritypcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appspringsecuritypcmarket.entity.Address;
import uz.pdp.appspringsecuritypcmarket.entity.Client;

@Projection(types = Client.class)
public interface CustomClient {
    Integer getId();

    String getFullName();

    String getPhoneNumber();

    Address getAddress();
}
