package com.ozer.deneme.Repository;

import com.ozer.deneme.model.Availability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvailabilityRepository extends JpaRepository<Availability,Long> {
}

