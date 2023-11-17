package com.iti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iti.entity.MenuItem;
import com.iti.repo.MenuItemRepository;

@Service
public class MenuItemService {
    @Autowired
    private MenuItemRepository menuItemRepository;

    public List<MenuItem> getMenuItemsForRole(String role) {
        return menuItemRepository.findByRole(role);
    }
}

