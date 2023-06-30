package com.ogutcenali.repository;

import com.ogutcenali.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository  extends JpaRepository<Category,Long> {
}
