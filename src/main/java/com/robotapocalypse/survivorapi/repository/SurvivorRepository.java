package com.robotapocalypse.survivorapi.repository;

import com.robotapocalypse.survivorapi.model.Survivor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurvivorRepository extends JpaRepository<Survivor, Long> {

    List<Survivor> findByInfected(boolean infected);
    Survivor findBySurvivorId(String survivorId);
    List<Survivor> findSurvivorByName(String name);

}

