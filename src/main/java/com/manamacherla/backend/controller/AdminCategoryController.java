package com.manamacherla.backend.controller;


import com.manamacherla.backend.entity.Category;
import com.manamacherla.backend.repository.CategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/categories")
@CrossOrigin
public class AdminCategoryController {

    private final CategoryRepository repo;

    public AdminCategoryController(CategoryRepository repo) {
        this.repo = repo;
    }

    // ✅ Add category
    @PostMapping
    public Category add(@RequestBody Category category) {
        return repo.save(category);
    }

    // ✅ View all categories (admin)
    @GetMapping
    public List<Category> all() {
        return repo.findAll();
    }

    // ✅ Delete category
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
