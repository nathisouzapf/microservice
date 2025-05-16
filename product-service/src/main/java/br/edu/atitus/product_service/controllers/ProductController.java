package br.edu.atitus.product_service.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.product_service.entities.ProductEntity;
import br.edu.atitus.product_service.repositories.ProductRepositories;

@RestController
@RequestMapping("/products")
public class ProductController {
	 private final ProductRepositories repository;

	    @Value("${server.port}")
	    private String port;

	    public OpenProductController(ProductRepository repository) {
	        this.repository = repository;
	    }
	    
	    @GetMapping("/{idProduct}/{targetCurrency}")
	    public Product getProduct(@PathVariable Long idProduct, @PathVariable String targetCurrency) {
	        Optional<Product> optionalProduct = repository.findById(idProduct);
	        if (optionalProduct.isEmpty()) {
	            throw new RuntimeException("Produto não encontrado");
	        }
	        
	        Product product = optionalProduct.get();
	        product.setEnvironment("Product-Service running on port: " + port);
	        product.setConvertedPrice(product.getPrice()); // Valor convertido fixo

	        return product;
	    }

}
