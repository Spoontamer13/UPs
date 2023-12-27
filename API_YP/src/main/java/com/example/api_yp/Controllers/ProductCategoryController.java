package com.example.api_yp.Controllers;

import com.example.api_yp.Models.ProductCategory;
import com.example.api_yp.Repositories.ProductCategoryRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductCategoryController {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @GetMapping("/productCategory")
    public ResponseEntity<List<ProductCategory>> getProductCategory() {
        List<ProductCategory> productCategories = productCategoryRepository.findAll();

        return new ResponseEntity<>(productCategories, HttpStatus.OK);
    }

    @GetMapping("/productCategory/{idProductCategory}")
    public ResponseEntity<ProductCategory> oneProductCategory(@PathVariable Long idProductCategory) {
        Optional<ProductCategory> optionalProductCategory = productCategoryRepository.findById(idProductCategory);

        if (optionalProductCategory.isPresent()) {
            return new ResponseEntity<>(optionalProductCategory.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/productCategory")
    public ResponseEntity<ProductCategory> createProductCategory(@Valid @RequestBody ProductCategory productCategoryRequest) {
        ProductCategory productCategory = productCategoryRepository.save(productCategoryRequest);

        return new ResponseEntity<>(productCategory, HttpStatus.CREATED);
    }

    @PutMapping("/productCategory/{idProductCategory}")
    public ResponseEntity<ProductCategory> updateProductCategory(@PathVariable Long idProductCategory,
                                                     @Valid @RequestBody ProductCategory productCategoryRequest) {
        Optional<ProductCategory> productCategoryOptional = productCategoryRepository.findById(idProductCategory);

        if (productCategoryOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        ProductCategory productCategory = productCategoryOptional.get();

        productCategory.setIdProductCategory(productCategoryRequest.getIdProductCategory());
        productCategory.setNameProductCategory(productCategoryRequest.getNameProductCategory());

        ProductCategory productCategoryUpdate = productCategoryRepository.save(productCategory);

        return new ResponseEntity<>(productCategoryUpdate, HttpStatus.OK);
    }


    @DeleteMapping("/productCategory/{idProductCategory}")
    public ResponseEntity<?> deleteProductCategory(@PathVariable Long idProductCategory) {
        Optional<ProductCategory> productCategoryOptional = productCategoryRepository.findById(idProductCategory);

        if (productCategoryOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        ProductCategory productCategory = productCategoryOptional.get();

        productCategoryRepository.delete(productCategory);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
