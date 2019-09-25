package com.mproduits.services;

import com.mproduits.dao.ProductDao;
import com.mproduits.model.Product;
import com.mproduits.exceptions.ProductNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    final private ProductDao productDao;
    final private static Logger logger = LoggerFactory.getLogger(ProductService.class);

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> listeDesProduits() {

        List<Product> products = productDao.findAll();

        logger.info("*********** Cote service ==> recuperation des produits ***********");
        if (products.isEmpty())
            throw new ProductNotFoundException("Aucun produit n'est disponible à la vente");
        return products;

    }

    //Récuperer un produit par son id
    public Optional<Product> recupererUnProduit(int id) {

        Optional<Product> product = productDao.findById(id);
        logger.info("*********** Cote service ==> recuperation du produit id = " + id + " ***********");
        if (product == null)
            throw new ProductNotFoundException("Le produit correspondant à l'id " + id + " n'existe pas");
        return product;
    }

    public Product ajouterProduit(Product product) {
        try {
            productDao.save(product);
            return product;
        } catch (Exception e) {
            logger.info("*********** erreur cote service, insertion n'a pas reussi ***********" + e.getMessage());
        }
        return null;
    }
}
