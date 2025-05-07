package org.example.gestion_stock.controller;

import org.example.gestion_stock.model.Lot;
import org.example.gestion_stock.repository.LotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/lots")
public class LotController {

    @Autowired
    public LotRepository lotrepo;
    // 1. Créer un lot
    @PostMapping
    public Lot createLot(@RequestBody Lot lot) {
        return lotrepo.save(lot);
    }

    // 2. Récupérer tous les lots
    @GetMapping
    public List<Lot> getAllLots() {
        return lotrepo.findAll();
    }

    // 3. Récupérer un lot par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Lot> getLotById(@PathVariable Long id) {
        Optional<Lot> lot = lotrepo.findById(id);
        return lot.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 4. Mettre à jour un lot
    @PutMapping("/{id}")
    public ResponseEntity<Lot> updateLot(@PathVariable Long id, @RequestBody Lot lot) {
        if (!lotrepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        lot.setId(id); // Assurez-vous que le lot a le bon ID
        Lot updatedLot = lotrepo.save(lot);
        return ResponseEntity.ok(updatedLot);
    }

    // 5. Supprimer un lot
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLot(@PathVariable Long id) {
        if (!lotrepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        lotrepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
