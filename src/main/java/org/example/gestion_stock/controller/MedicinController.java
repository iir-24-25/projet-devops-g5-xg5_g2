package org.example.gestion_stock.controller;

import org.example.gestion_stock.model.Medicin;
import org.example.gestion_stock.repository.MedicinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicins")
public class MedicinController {
    @Autowired
    private MedicinRepository medicinrepo;

    @PostMapping
    public Medicin createMedicin(@RequestBody Medicin newMedicin) {
        return medicinrepo.save(newMedicin);
    }

    @DeleteMapping("/{id}")
    public void deleteMedicin(@PathVariable Long id) {
        medicinrepo.deleteById(id);
    }

    @GetMapping
    public List<Medicin> getAllMedicins() {
        return medicinrepo.findAll();
    }

    @GetMapping("/{id}")
    public Medicin getMedicin(@PathVariable Long id) {
        return medicinrepo.findById(id).get();
    }
}
