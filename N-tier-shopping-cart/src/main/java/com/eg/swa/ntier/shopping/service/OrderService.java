package com.eg.swa.ntier.shopping.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.eg.swa.ntier.shopping.model.Customer;
import com.eg.swa.ntier.shopping.model.Order;
import com.eg.swa.ntier.shopping.model.OrderItem;
import com.eg.swa.ntier.shopping.model.OrderItemDto;
import com.eg.swa.ntier.shopping.model.OrderStatus;
import com.eg.swa.ntier.shopping.model.Product;
import com.eg.swa.ntier.shopping.repository.OrderRepository;
import com.eg.swa.ntier.shopping.repository.ProductRepository;

@Service
@Transactional
public class OrderService {

	private final OrderRepository orderRepository;
	private final ProductRepository productRepository;
	private final ProductService productService;

	public OrderService(OrderRepository orderRepository, ProductRepository productRepository,
			ProductService productService) {
		this.orderRepository = orderRepository;
		this.productRepository = productRepository;
		this.productService = productService;
	}

	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	public List<Order> getOrdersForCustomer(Customer customer) {
		return orderRepository.findByCustomer(customer);
	}

	public Order getOrderById(Long id) throws NotFoundException {
		return orderRepository.findById(id).orElseThrow(() -> new NotFoundException());
	}

	public Order createOrder(Long customerId, List<OrderItemDto> orderItems) throws Exception {

		// Need to refacator the following function
		Order order = new Order();

		Customer customer = new Customer();
		customer.setId(customerId);

		order.setCustomer(customer);
		order.setOrderDate(LocalDateTime.now());
		order.setOrderStatus(OrderStatus.CREATED);

		List<OrderItem> items = new ArrayList<>();
		for (OrderItemDto itemDto : orderItems) {

			Product product = productRepository.getReferenceById(itemDto.getProductId());

			// check if product is available in sufficient quantity
			if (product.getQuantity() < itemDto.getQuantity()) {
				throw new Exception("Insufficient Product Quantity");
			}

			// update product quantity
			product.setQuantity(product.getQuantity() - itemDto.getQuantity());
//			productService.updateProduct(product.getId(), product); need to add the update product

			// Create order item and add to items list
			OrderItem item = new OrderItem();
			item.setOrder(order);
			item.setProduct(product);
			item.setQuantity(itemDto.getQuantity());
			item.setPrice(itemDto.getPrice());
			items.add(item);
		}
		order.setOrderItems(items);
		return orderRepository.save(order);
	}

}
