package com.iti.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iti.entity.MenuItem;


public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    List<MenuItem> findByRole(String role);
}

