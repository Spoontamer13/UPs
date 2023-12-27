package com.example.api_yp.Controllers;

import com.example.api_yp.Models.Product;
import com.example.api_yp.Repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getProduct() {
        List<Product> products = productRepository.findAll();

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/product/{idProduct}")
    public ResponseEntity<Product> oneProduct(@PathVariable Long idProduct) {
        Optional<Product> optionalProduct = productRepository.findById(idProduct);

        if (optionalProduct.isPresent()) {
            return new ResponseEntity<>(optionalProduct.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product productRequest) {
        Product product = productRepository.save(productRequest);

        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @PutMapping("/product/{idProduct}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long idProduct,
                                                                 @Valid @RequestBody Product productRequest) {
        Optional<Product> productOptional = productRepository.findById(idProduct);

        if (productOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Product product = productOptional.get();

        product.setIdProduct(productRequest.getIdProduct());
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setSpecifications(productRequest.getSpecifications());
        product.setManufacturerProduct(productRequest.getManufacturerProduct());
        product.setProductCategory(productRequest.getProductCategory());

        Product productUpdate = productRepository.save(product);

        return new ResponseEntity<>(productUpdate, HttpStatus.OK);
    }


    @DeleteMapping("/product/{idProduct}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long idProduct) {
        Optional<Product> productOptional = productRepository.findById(idProduct);

        if (productOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Product product = productOptional.get();

        productRepository.delete(product);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/product/{address}/{name}")
    public ResponseEntity<List<Product>> searchProduct(@PathVariable String address,@PathVariable String name) {
        List<Product> products = productRepository.findProductByNameAndAddress(address,name);

        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
