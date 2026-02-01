package com.manamacherla.backend.controller;

import com.manamacherla.backend.entity.Category;
import com.manamacherla.backend.entity.Shop;
import com.manamacherla.backend.repository.CategoryRepository;
import com.manamacherla.backend.repository.ShopRepository;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
public class PublicController {

    private final CategoryRepository categoryRepo;
    private final ShopRepository shopRepo;

    public PublicController(CategoryRepository c, ShopRepository s) {
        this.categoryRepo = c;
        this.shopRepo = s;
    }

    @GetMapping("/categories")
    public List<Category> categories() {
        return categoryRepo.findAll();
    }

    @GetMapping("/shops")
    public List<Shop> shops(@RequestParam Long categoryId) {
        return shopRepo.findByCategoryId(categoryId);
    }

    @GetMapping("/shops/{id}")
    public Shop shop(@PathVariable Long id) {
        return shopRepo.findById(id).orElse(null);
    }
}
