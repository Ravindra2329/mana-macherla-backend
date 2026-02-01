package com.manamacherla.backend.controller;


import com.manamacherla.backend.entity.Shop;
import com.manamacherla.backend.repository.ShopRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final ShopRepository repo;

    public AdminController(ShopRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/shop")
    public Shop add(@RequestBody Shop shop) {
        return repo.save(shop);
    }

    @PutMapping("/shop/{id}")
    public Shop update(@PathVariable Long id, @RequestBody Shop shop) {
        shop.setId(id);
        return repo.save(shop);
    }

    @DeleteMapping("/shop/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }

    @GetMapping("/shops")
    public List<Shop> all() {
        return repo.findAll();
    }
}
