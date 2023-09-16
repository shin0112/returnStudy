package com.example.returnstudy.Repository;

import com.example.returnstudy.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
