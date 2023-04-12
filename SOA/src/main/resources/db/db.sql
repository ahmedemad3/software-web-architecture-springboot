CREATE TABLE bookstore.book (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    stock INTEGER NOT NULL
);



INSERT INTO bookstore.book (title, author, price, stock)
VALUES
    ('The Great Gatsby', 'F. Scott Fitzgerald', 9.99, 100),
    ('To Kill a Mockingbird', 'Harper Lee', 8.99, 150),
    ('1984', 'George Orwell', 7.99, 200),
    ('Brave New World', 'Aldous Huxley', 6.99, 250),
    ('Animal Farm', 'George Orwell', 5.99, 300);

