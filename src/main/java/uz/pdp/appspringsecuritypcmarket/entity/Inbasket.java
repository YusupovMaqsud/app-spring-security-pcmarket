package uz.pdp.appspringsecuritypcmarket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Inbasket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer amount;

    private double totalAmount;

    @OneToMany
    private List<Product> product;

    @OneToOne
    private Client client;

    @ManyToOne
    private Address address;
}
