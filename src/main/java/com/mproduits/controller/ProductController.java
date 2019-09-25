package com.mproduits.controller;

import com.mproduits.model.Product;
import com.mproduits.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("products")
public class ProductController {


    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    final private static Logger logger = LoggerFactory.getLogger(ProductController.class);

    // Affiche la liste de tous les produits disponibles
    @GetMapping
    public List<Product> listeDesProduits() {

        logger.info("*********** Cote controlleur ==> recuperation des produits ***********");
        List<Product> products = productService.listeDesProduits();
        return products;

    }

    //Récuperer un produit par son id
    @GetMapping(value = "{id}")
    public Optional<Product> recupererUnProduit(@PathVariable int id) {

        logger.info("*********** cote controlleur ==> Recuperation d'un produit id = " + id + " ***********");
        Optional<Product> product = productService.recupererUnProduit(id);
        return product;
    }

    @PostMapping
    public Product ajouterProduit(@RequestBody Product product) {
        try {
            productService.ajouterProduit(product);
            return product;
        } catch (Exception e) {
            logger.info("*********** erreur cote controlleur insertion n'a pas reussi ***********" + e.getMessage());
        }
        return null;
    }

    @GetMapping("/test")
    void testProxyProduct() {
        logger.info("product proxy success");
    }
}

