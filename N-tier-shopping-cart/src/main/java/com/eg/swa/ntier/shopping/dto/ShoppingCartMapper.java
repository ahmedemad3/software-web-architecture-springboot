package com.eg.swa.ntier.shopping.dto;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.eg.swa.ntier.shopping.model.CartItem;
import com.eg.swa.ntier.shopping.model.Customer;
import com.eg.swa.ntier.shopping.model.Product;
import com.eg.swa.ntier.shopping.model.ShoppingCart;

@Component
public class ShoppingCartMapper {

    public ShoppingCart mapToEntity(ShoppingCartDto dto) {
        ShoppingCart entity = new ShoppingCart();
        entity.setId(dto.getId());
        entity.setCustomer(new Customer(dto.getCustomerId()));
        entity.setCartItems(dto.getCartItems().stream()
                .map(this::mapToItem)
                .collect(Collectors.toList()));
        return entity;
    }

    public CartItem mapToItem(CartItemDto itemDto) {
        CartItem item = new CartItem();
        item.setId(itemDto.getId());
        item.setProduct(new Product(itemDto.getProductId()));
        item.setQuantity(itemDto.getQuantity());
        return item;
    }
}

