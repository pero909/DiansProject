package com.example.dians_demo.repository.jpa;

import com.example.dians_demo.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location,Long> {
   Optional<Location> findByName(String name);
}
