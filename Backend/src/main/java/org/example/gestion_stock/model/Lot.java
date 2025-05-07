package org.example.gestion_stock.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Lot {
    @Id
    @GeneratedValue
    private long id;
    private String numeroLot;
    private LocalDate dateExpiration;
    private Integer quantite;
    private LocalDateTime dateEntree;
    @ManyToOne
    @JoinColumn(name = "medicin_id")
    private Medicin medicin;
    @OneToMany(mappedBy = "lot")
    private List<MouvementStock> mouvements;


    public Lot(){}
    public Lot(long id, String numeroLot, LocalDate dateExpiration, Integer quantite, LocalDateTime dateEntree, Medicin medicin, List<MouvementStock> mouvements, List<Alerte> alertes) {
        this.id = id;
        this.numeroLot = numeroLot;
        this.dateExpiration = dateExpiration;
        this.quantite = quantite;
        this.dateEntree = dateEntree;
        this.medicin = medicin;
        this.mouvements = mouvements;
        this.alertes = alertes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumeroLot() {
        return numeroLot;
    }

    public void setNumeroLot(String numeroLot) {
        this.numeroLot = numeroLot;
    }

    public LocalDate getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(LocalDate dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public LocalDateTime getDateEntree() {
        return dateEntree;
    }

    public void setDateEntree(LocalDateTime dateEntree) {
        this.dateEntree = dateEntree;
    }

    public Medicin getMedicin() {
        return medicin;
    }

    public void setMedicin(Medicin medicin) {
        this.medicin = medicin;
    }

    public List<MouvementStock> getMouvements() {
        return mouvements;
    }

    public void setMouvements(List<MouvementStock> mouvements) {
        this.mouvements = mouvements;
    }

    public List<Alerte> getAlertes() {
        return alertes;
    }

    public void setAlertes(List<Alerte> alertes) {
        this.alertes = alertes;
    }

    @OneToMany(mappedBy = "lot")
    private List<Alerte> alertes;
}
