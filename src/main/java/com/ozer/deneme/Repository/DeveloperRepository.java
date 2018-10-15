package com.ozer.deneme.Repository;

import com.ozer.deneme.model.Developer;
import com.ozer.deneme.model.DeveloperProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer,Long> {
    DeveloperProfile findProjectedById(Long id);
}

