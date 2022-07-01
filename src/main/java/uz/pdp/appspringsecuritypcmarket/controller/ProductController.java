package uz.pdp.appspringsecuritypcmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appspringsecuritypcmarket.entity.Product;
import uz.pdp.appspringsecuritypcmarket.payload.ProductDto;
import uz.pdp.appspringsecuritypcmarket.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;


    @PreAuthorize(value = "hasAnyRole('SUPER_ADMEN','OPERATOR','MODERATOR')")
    @GetMapping("/getproduct")
    public HttpEntity<List<Product>> getProducts(){
        List<Product> productList = productService.getProducts();
        return ResponseEntity.ok(productList);
    }



    @PreAuthorize(value = "hasAnyRole('SUPER_ADMEN','OPERATOR','MODERATOR')")
    @GetMapping("/getproduct/{id}")
    public HttpEntity<?> getProduct(@PathVariable Integer id){
        Product product = productService.getProduct(id);
        return ResponseEntity.status(product!=null? HttpStatus.OK:HttpStatus.CONFLICT).body(product);

    }


    @PreAuthorize(value = "hasAnyRole('SUPER_ADMEN','MODERATOR')")
    @PostMapping("addproduct")
    public HttpEntity<?> addProduct(@RequestBody ProductDto productDto){
        String addProduct = productService.addProduct(productDto);
        return  ResponseEntity.status(HttpStatus.CREATED).body(addProduct);

    }



    @PreAuthorize(value = "hasRole('SUPER_ADMEN')")
    @DeleteMapping("/deleteproduct/{id}")
    public HttpEntity<?> deleteProduct(@PathVariable Integer id){
        boolean deleteProduct = productService.deleteProduct(id);
        return ResponseEntity.status(deleteProduct?HttpStatus.NO_CONTENT:HttpStatus.CONFLICT).body(deleteProduct);
    }



    @PreAuthorize(value = "hasAnyRole('SUPER_ADMEN','MODERATOR')")
    @PutMapping("/editproduct/{id}")
    public HttpEntity<?> editProduct(@RequestBody ProductDto productDto, Integer id){
        String editProduct = productService.editProduct(productDto, id);
        return ResponseEntity.status(editProduct!=null?HttpStatus.ACCEPTED:HttpStatus.CONFLICT).body(editProduct);

    }
}
