package com.carlosgr.ecommerce.repositories;

import com.carlosgr.ecommerce.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(value = "select * from categories where name like %?1%",
            countQuery = "select count(*) from categories where name like %?1%",
            nativeQuery = true)
    Page<Category> findAll(String search, Pageable pageable);
}
