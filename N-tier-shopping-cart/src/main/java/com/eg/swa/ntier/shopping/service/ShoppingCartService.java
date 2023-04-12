package com.eg.swa.ntier.shopping.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.eg.swa.ntier.shopping.dto.ShoppingCartDto;
import com.eg.swa.ntier.shopping.dto.ShoppingCartMapper;
import com.eg.swa.ntier.shopping.model.CartItem;
import com.eg.swa.ntier.shopping.model.Customer;
import com.eg.swa.ntier.shopping.model.ShoppingCart;
import com.eg.swa.ntier.shopping.repository.CartItemRepository;
import com.eg.swa.ntier.shopping.repository.ShoppingCartRepository;

@Service
public class ShoppingCartService {

	private final ShoppingCartRepository shoppingCartRepository;
	private final CartItemRepository cartItemRepository;
	private final CustomerService customerService;
	private final ShoppingCartMapper shoppingCartMapper;

	public ShoppingCartService(ShoppingCartRepository shoppingCartRepository, CartItemRepository cartItemRepository,
			CustomerService customerService, ShoppingCartMapper shoppingCartMapper) {
		this.shoppingCartRepository = shoppingCartRepository;
		this.cartItemRepository = cartItemRepository;
		this.customerService = customerService;
		this.shoppingCartMapper = shoppingCartMapper;
	}

	public ShoppingCart getOrCreateCart(Long customerId) {
		Optional<ShoppingCart> optionalCart = shoppingCartRepository.findByCustomerId(customerId);
		if (optionalCart.isPresent()) {
			return optionalCart.get();
		} else {
			ShoppingCart cart = new ShoppingCart();
			cart.setCustomer(new Customer(customerId));
			return shoppingCartRepository.save(cart);
		}
	}

	// create addItemToCart(ShoppingCartDto shoppingCartDto)
	
	// create removeItemFromCart(Long customerId, Long cartItemId)
	
	

	public void clearCart(ShoppingCart cart) {
		cartItemRepository.deleteByCartId(cart.getId());
	}

	public void updateCartItem(ShoppingCartDto shoppingCartDto) throws Exception {

		Optional<Customer> optionalCustomer = customerService.getCustomerById(shoppingCartDto.getCustomerId());
		if (!optionalCustomer.isPresent()) {
			throw new Exception("Customer not found");
		}

		Customer customer = optionalCustomer.get();
		Optional<ShoppingCart> optionalCart = shoppingCartRepository.findByCustomerId(customer.getId());
		if (!optionalCart.isPresent()) {
			throw new Exception("Cart not found");
		}

		ShoppingCart cart = shoppingCartMapper.mapToEntity(shoppingCartDto);
		cart.setCustomer(customer);
		shoppingCartRepository.save(cart);
	}

}
