CREATE TABLE tb_user_login
(
    id       UUID DEFAULT RANDOM_UUID() PRIMARY KEY,
    name     VARCHAR(100) NOT NULL,
    email    VARCHAR(100) NOT NULL,
    telefone VARCHAR(11)  NOT NULL
);
CREATE TABLE dados
(
    id    UUID DEFAULT RANDOM_UUID() primary key,
    name  VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);
