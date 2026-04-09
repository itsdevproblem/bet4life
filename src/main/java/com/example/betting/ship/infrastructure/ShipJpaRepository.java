package com.example.betting.ship.infrastructure;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.betting.ship.infrastructure.entity.ShipEntity;

@Repository
public interface ShipJpaRepository extends JpaRepository<ShipEntity, Long> {

    Optional<ShipEntity> findByUsrIdAndDelYn(String usrId, String delYn);
    
}
