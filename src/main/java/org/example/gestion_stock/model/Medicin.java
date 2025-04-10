package org.example.gestion_stock.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Medicin {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;
    private String codeBarres;
    private String categorie;
    private String fabriquant;
    private Integer seuilAlerte;
    @OneToMany(mappedBy = "medicin")
    private List<Lot> lots;

    public Medicin() {}
    public Medicin(int id, String name, String description, String codeBarres, String categorie, String fabriquant, Integer seuilAlerte, List<Lot> lots) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.codeBarres = codeBarres;
        this.categorie = categorie;
        this.fabriquant = fabriquant;
        this.seuilAlerte = seuilAlerte;
        this.lots = lots;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCodeBarres() {
        return codeBarres;
    }

    public void setCodeBarres(String codeBarres) {
        this.codeBarres = codeBarres;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getFabriquant() {
        return fabriquant;
    }

    public void setFabriquant(String fabriquant) {
        this.fabriquant = fabriquant;
    }

    public Integer getSeuilAlerte() {
        return seuilAlerte;
    }

    public void setSeuilAlerte(Integer seuilAlerte) {
        this.seuilAlerte = seuilAlerte;
    }

    public List<Lot> getLots() {
        return lots;
    }

    public void setLots(List<Lot> lots) {
        this.lots = lots;
    }
}
