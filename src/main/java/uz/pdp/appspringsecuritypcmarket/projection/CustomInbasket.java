package uz.pdp.appspringsecuritypcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appspringsecuritypcmarket.entity.Address;
import uz.pdp.appspringsecuritypcmarket.entity.Client;
import uz.pdp.appspringsecuritypcmarket.entity.Inbasket;

@Projection(types = Inbasket.class)
public interface CustomInbasket {
    Integer getId();

    Integer getAmount();

    double getTotalAmount();

    Client getClient();

    Address getAddress();
}
