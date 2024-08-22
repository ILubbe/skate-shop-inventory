package com.example.demo.controllers;

import com.example.demo.domain.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Optional;

@Controller
public class BuyProductController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/buyProduct")
    public String buyProduct(@RequestParam("productID") long id, Model model) {
        Optional<Product> productBeingBought = productRepository.findById(id);
        if (productBeingBought.isPresent()) { // is item in productRepository?
            if (productBeingBought.get().getInv() > 0) { // is item in stock?
                productBeingBought.get().setInv(productBeingBought.get().getInv() - 1); // update inventory count
                productRepository.save(productBeingBought.get());
                return "/buySuccess";
            }
        }
        return "/buyFail";
    }
}
