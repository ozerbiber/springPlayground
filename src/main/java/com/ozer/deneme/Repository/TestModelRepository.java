package com.ozer.deneme.Repository;

import com.ozer.deneme.model.TestModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestModelRepository extends JpaRepository<TestModel,Long> {

}
