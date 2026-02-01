package com.manamacherla.backend.controller;

import com.manamacherla.backend.model.Shop;
import com.manamacherla.backend.service.ShopService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shops")
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    // ✅ ADD SHOP
    @PostMapping
    public Shop addShop(@RequestBody Shop shop) {
        return shopService.addShop(shop);
    }

    // ✅ GET ALL SHOPS
    @GetMapping
    public List<Shop> getAllShops() {
        return shopService.getAllShops();
    }

    // ✅ GET SHOP BY ID
    @GetMapping("/{id}")
    public Shop getShopById(@PathVariable Long id) {
        return shopService.getShopById(id);
    }

    // ✅ UPDATE SHOP
    @PutMapping("/{id}")
    public Shop updateShop(
            @PathVariable Long id,
            @RequestBody Shop shop
    ) {
        return shopService.updateShop(id, shop);
    }

    // ✅ DELETE SHOP
    @DeleteMapping("/{id}")
    public void deleteShop(@PathVariable Long id) {
        shopService.deleteShop(id);
    }
}
