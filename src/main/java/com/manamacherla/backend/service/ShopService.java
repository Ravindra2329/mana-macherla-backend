package com.manamacherla.backend.service;

import com.manamacherla.backend.model.Shop;
import com.manamacherla.backend.repository.ShopRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {

    private final ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public Shop addShop(Shop shop) {
        return shopRepository.save(shop);
    }

    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }

    public List<Shop> getByCategory(String category) {
        return shopRepository.findByCategory(category);
    }

    public Shop getShopById(Long id) {
        return shopRepository.findById(id).orElse(null);
    }
}
