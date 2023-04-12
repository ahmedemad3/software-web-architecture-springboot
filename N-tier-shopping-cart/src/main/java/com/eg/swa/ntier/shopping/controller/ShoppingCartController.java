package com.eg.swa.ntier.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eg.swa.ntier.shopping.dto.ShoppingCartDto;
import com.eg.swa.ntier.shopping.model.ShoppingCart;
import com.eg.swa.ntier.shopping.service.ShoppingCartService;

@RestController
@RequestMapping("/api/shopping-cart")
public class ShoppingCartController {
    
    @Autowired
    private ShoppingCartService shoppingCartService;
    
    
    @PostMapping("/getOrCreateCart/{customerId}")
    public ShoppingCart getOrCreateCart(@PathVariable("customerId") Long customerId){
    	return shoppingCartService.getOrCreateCart(customerId);
    }
    
    
    // add a function to addItemToCart have the following signature addItemsToCart(@PathVariable("customerId") Long customerId, @RequestBody ShoppingCartDto shoppingCartDto) 
    

    // add a function to removeItemFromCart have the following signature removeItemFromCart(@PathVariable("customerId") Long customerId, @PathVariable("cartItemId") Long cartItemId) 
    
    
    @PutMapping("/updateCartItem/{customerId}/{cartItemId}")
    public ResponseEntity<String> updateCartItem(@PathVariable("customerId") Long customerId, @PathVariable("cartItemId") Long cartItemId, 
                                                  @RequestBody ShoppingCartDto shoppingCartDto) throws Exception {
        shoppingCartDto.setId(cartItemId);
        shoppingCartDto.setCustomerId(customerId);
        shoppingCartService.updateCartItem(shoppingCartDto);
        return ResponseEntity.ok().body("Cart item updated.");
    }
    
}

