package com.tidii.optimusapi.repositories;

import com.tidii.optimusapi.entities.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StreetRepository extends JpaRepository<Street, Long> {

    Optional<Street> findStreetByNameIgnoreCase(String name);
}
