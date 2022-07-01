package uz.pdp.appspringsecuritypcmarket.payload;

import lombok.Data;

@Data
public class ProductDto {
    private String name;
    private String code;
    private String price;
    private Integer categoryId;
    private Integer photoId;

}
