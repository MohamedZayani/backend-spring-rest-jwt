package dev.rest.jwt.controller;

import dev.rest.jwt.model.Produit;
import dev.rest.jwt.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    // Lecture : accessible par tous les rôles
    @GetMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public List<Produit> getAllProduits() {
        return produitService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<Produit> getProduitById(@PathVariable Long id) {
        return produitService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Création : accessible uniquement par ADMIN
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Produit createProduit(@RequestBody Produit produit) {
        return produitService.save(produit);
    }

    // Mise à jour : accessible uniquement par ADMIN
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Produit> updateProduit(@PathVariable Long id, @RequestBody Produit updatedProduit) {
        return produitService.findById(id)
                .map(produit -> {
                    produit.setNom(updatedProduit.getNom());
                    produit.setPrix(updatedProduit.getPrix());
                    return ResponseEntity.ok(produit);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Suppression : accessible uniquement par ADMIN
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteProduit(@PathVariable Long id) {
        boolean deleted = produitService.deleteById(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
