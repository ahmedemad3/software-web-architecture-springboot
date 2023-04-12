CREATE TABLE shopping.product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    quantity INTEGER NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO shopping.product (name, price, quantity)
VALUES ('iPhone 13 Pro', 1299.00, 10),
       ('Samsung Galaxy S21', 799.99, 5),
       ('Sony PlayStation 5', 499.99, 20),
       ('Bose QuietComfort 35 II', 299.00, 15),
       ('Nintendo Switch', 299.99, 8);


CREATE TABLE shopping.customer (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    address VARCHAR(500) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


INSERT INTO shopping.customer (name, email, address)
VALUES ('John Doe', 'johndoe@example.com', '123 Main St, Anytown USA'),
       ('Jane Smith', 'janesmith@example.com', '456 Maple Ave, Somewhere USA'),
       ('Bob Johnson', 'bobjohnson@example.com', '789 Oak St, Nowhere USA'),
       ('Alice Lee', 'alicelee@example.com', '1010 Pine St, Anywhere USA'),
       ('David Brown', 'davidbrown@example.com', '1212 Elm St, Everywhere USA');



CREATE TABLE shopping.orders (
    id SERIAL PRIMARY KEY,
    customer_id INTEGER REFERENCES customer(id),
    order_status VARCHAR(50) NOT NULL,
    total DECIMAL(10,2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);



CREATE TABLE shopping.shopping_cart (
    id SERIAL PRIMARY KEY,
    customer_id INTEGER NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    FOREIGN KEY (customer_id) REFERENCES shopping.customer(id) ON DELETE CASCADE
);

CREATE TABLE shopping.cart_item (
    id SERIAL PRIMARY KEY,
    cart_id INTEGER NOT NULL,
    product_id INTEGER NOT NULL,
    quantity INTEGER NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    FOREIGN KEY (cart_id) REFERENCES shopping.shopping_cart(id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES shopping.product(id) ON DELETE CASCADE
);


CREATE TABLE shopping.order_item (
    id SERIAL PRIMARY KEY,
    order_id INTEGER REFERENCES order_table(id),
    product_id INTEGER REFERENCES product(id),
    quantity INTEGER NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);