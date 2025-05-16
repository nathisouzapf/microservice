CREATE TABLE tb_product (
    id serial NOT NULL,
    description varchar(100) NOT NULL,
    brand VARCHAR(255) NOT NULL,
    model VARCHAR(255) NOT NULL,
    currency VARCHAR(3) NOT NULL,
    price FLOAT(53) NOT NULL,
    stock INTEGER NOT NULL,
    PRIMARY KEY (id)
);