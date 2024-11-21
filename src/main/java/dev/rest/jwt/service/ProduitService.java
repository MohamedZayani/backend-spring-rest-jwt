package dev.rest.jwt.service;

import dev.rest.jwt.model.Produit;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {
    private final List<Produit> produits = new ArrayList<>();

    public ProduitService() {
        produits.add(new Produit(1L, "Produit A", 100.0));
        produits.add(new Produit(2L, "Produit B", 200.0));
    }

    public List<Produit> findAll() {
        return produits;
    }

    public Optional<Produit> findById(Long id) {
        return produits.stream().filter(produit -> produit.getId().equals(id)).findFirst();
    }

    public Produit save(Produit produit) {
        produits.add(produit);
        return produit;
    }

    public boolean deleteById(Long id) {
        return produits.removeIf(produit -> produit.getId().equals(id));
    }
}
