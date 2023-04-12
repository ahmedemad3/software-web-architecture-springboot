CREATE TABLE WS.payment (
    payment_id SERIAL PRIMARY KEY,
    payment_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    card_number VARCHAR(16) NOT NULL,
    currency VARCHAR(3) NOT NULL,
    cvv VARCHAR(3) NOT NULL,
    expiry_month INTEGER NOT NULL,
    expiry_year INTEGER NOT NULL,
    amount DECIMAL(10,2) NOT NULL
);

CREATE TABLE WS.transaction (
  transaction_id SERIAL PRIMARY KEY,
  payment_id INTEGER ,
  transaction_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  transaction_status VARCHAR(50) NOT NULL,
  FOREIGN KEY (payment_id) REFERENCES WS.payment(payment_id)
  
);