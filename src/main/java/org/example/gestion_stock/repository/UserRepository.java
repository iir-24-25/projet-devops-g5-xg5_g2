package org.example.gestion_stock.repository;

import org.example.gestion_stock.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
