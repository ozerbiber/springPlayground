package com.ozer.deneme.Repository;

import com.ozer.deneme.model.DeveloperBase;
import com.ozer.deneme.model.QDeveloperBase;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperBaseRepository extends JpaRepository<DeveloperBase,Long>,QuerydslPredicateExecutor<DeveloperBase>,QuerydslBinderCustomizer<QDeveloperBase>{
    @Override
    default public void customize(QuerydslBindings bindings, QDeveloperBase root) {
        bindings.bind(String.class).first(
                (StringPath path, String value) -> path.equalsIgnoreCase(value));
    }
}
