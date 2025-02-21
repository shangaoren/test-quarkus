
    create sequence orders_SEQ start with 1 increment by 50;

    create sequence shops_SEQ start with 1 increment by 50;

    create sequence users_SEQ start with 1 increment by 50;

    create table orders (
        id bigint not null,
        shop_id bigint not null,
        primary key (id)
    );

    create table shops (
        id bigint not null,
        name varchar(255),
        vatId varchar(255),
        primary key (id)
    );

    create table users (
        id bigint not null,
        email varchar(255) not null unique,
        password varchar(255) not null,
        username varchar(255) not null unique,
        shop_id bigint,
        primary key (id)
    );

    alter table if exists orders 
       add constraint FK21gttsw5evi5bbsvleui69d7r 
       foreign key (shop_id) 
       references shops;

    alter table if exists users 
       add constraint FKbadc51v95q4hmcfflt8g3yfck 
       foreign key (shop_id) 
       references shops;
BEGIN;
INSERT INTO users( id, username, email, password) VALUES (1,'florian', 'florian@owlie.xyz', '$2a$10$qZiZtWlitaCFrbunpJ9caudJlrjAx5UrUzGdJf4H8BNsaTDwCO/be');
INSERT INTO users (id, username, email,password) VALUES (2, 'albert', 'florian+a.nonyme.xyz', '$2a$10$qZiZtWlitaCFrbunpJ9caudJlrjAx5UrUzGdJf4H8BNsaTDwCO/be');
ALTER SEQUENCE users_seq RESTART WITH 3;
COMMIT;
