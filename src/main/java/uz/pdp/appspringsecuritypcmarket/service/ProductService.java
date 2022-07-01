package uz.pdp.appspringsecuritypcmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import uz.pdp.appspringsecuritypcmarket.entity.Attachment;
import uz.pdp.appspringsecuritypcmarket.entity.Category;
import uz.pdp.appspringsecuritypcmarket.entity.Product;
import uz.pdp.appspringsecuritypcmarket.payload.ProductDto;
import uz.pdp.appspringsecuritypcmarket.repository.AttachmentRepository;
import uz.pdp.appspringsecuritypcmarket.repository.CategoryRepository;
import uz.pdp.appspringsecuritypcmarket.repository.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    AttachmentRepository attachmentRepository;


    public String addProduct(ProductDto productDto) {
        boolean existsByNameAndCategoryId = productRepository.existsByNameAndCategory_Id(productDto.getName(), productDto.getCategoryId());
        if (existsByNameAndCategoryId)
            return "Bunday mahsulot ushbu categoryda mavjud";


        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
        if (!optionalCategory.isPresent())
            return "Bunday categorya mavjud emas";


        Optional<Attachment> optionalAttachment = attachmentRepository.findById(productDto.getPhotoId());
        if (!optionalCategory.isPresent())
            return "Bunday photo mavjud emas";


        Product product = new Product();
        product.setName(productDto.getName());
        product.setCode(UUID.randomUUID().toString());
        product.setPrice(productDto.getPrice());
        product.setCategory(optionalCategory.get());
        product.setPhoto(optionalAttachment.get());
        productRepository.save(product);
        return "Mahsulot saqlandi";
    }


    public List<Product> getProducts() {
        List<Product> productList = productRepository.findAll();
        return productList;
    }


    public Product getProduct(@PathVariable Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()){
        return  optionalProduct.get();
        }
        return null;
    }




    public boolean deleteProduct( Integer id){
        try {
        productRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }

    }


    public String editProduct(ProductDto productDto, Integer id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(!optionalProduct.isPresent())
            return "Bunday product mavjud emas";

        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
        if (!optionalCategory.isPresent())
            return "Bunday categorya mavjud emas";


        Optional<Attachment> optionalAttachment = attachmentRepository.findById(productDto.getPhotoId());
        if (!optionalCategory.isPresent())
            return "Bunday photo mavjud emas";

        Product product = optionalProduct.get();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setCode(UUID.randomUUID().toString());
        product.setCategory(optionalCategory.get());
        product.setPhoto(optionalAttachment.get());
        productRepository.save(product);
        return "Product edited";

    }
}
