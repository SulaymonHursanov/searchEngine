package com.skyforce.repositories.jpa;

import com.skyforce.models.Category;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * Created by Sulaymon on 10.03.2018.
 */

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByCategoryNameToLower(String category);

    @Query("select u from Category u  where u.categoryNameToLower like %:input%")
    List<Category> findAllByInput(@Param("input") String input, Pageable pageable);
}
