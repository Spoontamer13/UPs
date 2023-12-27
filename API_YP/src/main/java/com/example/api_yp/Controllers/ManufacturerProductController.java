package com.example.api_yp.Controllers;

import com.example.api_yp.Models.ManufacturerProduct;
import com.example.api_yp.Repositories.ManufacturerProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ManufacturerProductController {
    @Autowired
    private ManufacturerProductRepository manufacturerProductRepository;

    @GetMapping("/manufacturerProduct")
    public ResponseEntity<List<ManufacturerProduct>> getManufacturerProduct() {
        List<ManufacturerProduct> manufacturerProducts = manufacturerProductRepository.findAll();

        return new ResponseEntity<>(manufacturerProducts, HttpStatus.OK);
    }

    @GetMapping("/manufacturerProduct/{idManufacturerProduct}")
    public ResponseEntity<ManufacturerProduct> oneManufacturerProduct(@PathVariable Long idManufacturerProduct) {
        Optional<ManufacturerProduct> optionalManufacturerProduct = manufacturerProductRepository.findById(idManufacturerProduct);

        if (optionalManufacturerProduct.isPresent()) {
            return new ResponseEntity<>(optionalManufacturerProduct.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/manufacturerProduct")
    public ResponseEntity<ManufacturerProduct> createManufacturerProduct(@Valid @RequestBody ManufacturerProduct manufacturerProductRequest) {

        ManufacturerProduct manufacturerProduct = manufacturerProductRepository.save(manufacturerProductRequest);

        return new ResponseEntity<>(manufacturerProduct, HttpStatus.CREATED);
    }

    @PutMapping("/manufacturerProduct/{idManufacturerProduct}")
    public ResponseEntity<ManufacturerProduct> updateManufacturerProduct(@PathVariable Long idManufacturerProduct,
                                                     @Valid @RequestBody ManufacturerProduct manufacturerProductRequest) {
        Optional<ManufacturerProduct> optionalManufacturerProduct = manufacturerProductRepository.findById(idManufacturerProduct);

        if (optionalManufacturerProduct.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        ManufacturerProduct manufacturerProduct = optionalManufacturerProduct.get();

        manufacturerProduct.setIdManufacturerProduct(manufacturerProductRequest.getIdManufacturerProduct());
        manufacturerProduct.setNameManufacturerProduct(manufacturerProductRequest.getNameManufacturerProduct());

        ManufacturerProduct manufacturerProductUpdate = manufacturerProductRepository.save(manufacturerProduct);

        return new ResponseEntity<>(manufacturerProductUpdate, HttpStatus.OK);
    }


    @DeleteMapping("/manufacturerProduct/{idManufacturerProduct}")
    public ResponseEntity<?> deleteManufacturerProduct(@PathVariable Long idManufacturerProduct) {
        Optional<ManufacturerProduct> optionalManufacturerProduct = manufacturerProductRepository.findById(idManufacturerProduct);

        if (optionalManufacturerProduct.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        ManufacturerProduct manufacturerProduct = optionalManufacturerProduct.get();

        manufacturerProductRepository.delete(manufacturerProduct);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
