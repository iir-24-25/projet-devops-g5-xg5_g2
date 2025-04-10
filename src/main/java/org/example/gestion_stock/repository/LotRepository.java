package org.example.gestion_stock.repository;

import org.example.gestion_stock.model.Lot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LotRepository extends JpaRepository<Lot, Long> {
}
