package uz.pdp.appspringsecuritypcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.appspringsecuritypcmarket.entity.Address;
import uz.pdp.appspringsecuritypcmarket.entity.PCMarket;
import uz.pdp.appspringsecuritypcmarket.projection.CustomPCMarket;

@RepositoryRestResource(path = "/pcmarket",excerptProjection = CustomPCMarket.class)
public interface PCMarketRepository extends JpaRepository<PCMarket,Integer> {
}
