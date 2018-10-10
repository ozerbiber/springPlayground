package com.ozer.deneme.Repository;

import com.ozer.deneme.model.Proficiency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProficiencyRepository extends JpaRepository<Proficiency,Long> {
}

