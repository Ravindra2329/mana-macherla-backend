package com.manamacherla.backend.service;

import com.manamacherla.backend.entity.Shop;
import com.manamacherla.backend.repository.ShopRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {

    private final ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    // ADD
    public Shop addShop(Shop shop) {
        return shopRepository.save(shop);
    }

    // GET ALL
    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }

    // GET BY ID
    public Shop getShopById(Long id) {
        return shopRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shop not found"));
    }

    // UPDATE
    public Shop updateShop(Long id, Shop updatedShop) {
        Shop shop = shopRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shop not found"));

        shop.setShopName(updatedShop.getShopName());
        shop.setCategory(updatedShop.getCategory());
        shop.setAddress(updatedShop.getAddress());
        shop.setPhone(updatedShop.getPhone());
        shop.setWhatsapp(updatedShop.getWhatsapp());

        return shopRepository.save(shop);
    }

    // DELETE
    public void deleteShop(Long id) {
        shopRepository.deleteById(id);
    }

    // CATEGORY
    public List<Shop> getByCategory(String category) {
        return shopRepository.findByCategory(category);
    }
}
