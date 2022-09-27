CREATE TABLE IF NOT EXISTS street_address
(
    id INT auto_increment primary key,
    description VARCHAR(250) NOT NULL,
    postal_code VARCHAR(20) NOT NULL,
    district VARCHAR(20) NOT NULL,
    city VARCHAR(120) NOT NULL,
    state VARCHAR(120) NOT NULL,
    country VARCHAR(2) NOT NULL,
    submission_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO street_address
    (description, postal_code, district, city, state, country)
    VALUES ('Trafalgar Square', 'GB WC2N', 'Westminister', 'London', 'London', 'UK')