package uz.pdp.appspringsecuritypcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appspringsecuritypcmarket.entity.Address;
import uz.pdp.appspringsecuritypcmarket.entity.PCMarket;

@Projection(types = PCMarket.class)
public interface CustomPCMarket {
    Integer getId();

    String getName();

    Address getAddress();
}
