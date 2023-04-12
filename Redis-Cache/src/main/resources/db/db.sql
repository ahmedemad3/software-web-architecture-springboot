CREATE TABLE redis.book (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    price NUMERIC(10,2) NOT NULL
);


INSERT INTO redis.book (id, title, author, price) 
VALUES (1, 'To Kill a Mockingbird', 'Harper Lee', 10.99),
       (2, 'The Great Gatsby', 'F. Scott Fitzgerald', 12.50),
       (3, '1984', 'George Orwell', 8.99),
       (4, 'The Catcher in the Rye', 'J.D. Salinger', 9.75),
       (5, 'One Hundred Years of Solitude', 'Gabriel Garcia Marquez', 11.25);

