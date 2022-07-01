package uz.pdp.appspringsecuritypcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.appspringsecuritypcmarket.entity.Address;
import uz.pdp.appspringsecuritypcmarket.entity.Inbasket;
import uz.pdp.appspringsecuritypcmarket.projection.CustomInbasket;

@RepositoryRestResource(path = "/inbasket",excerptProjection = CustomInbasket.class)
public interface InbasketRepository extends JpaRepository<Inbasket,Integer> {
}
