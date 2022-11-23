create table products
(
  id bigserial primary key,
  title      varchar(255),
  price      int,
  created_at timestamp default current_timestamp,
  updated_at timestamp default current_timestamp
);


insert into products(title, price)
values('Молоко', 2),('Хлеб', 2),('Конфеты', 15),
('Яблоко', 5),('Кофе', 20),('Чай', 3),('Помидор', 2),
('Огурец', 1),('Колбаса', 20),('Кефир', 2),('Яйцо', 3),
('Крупа манная', 3),('Крупа гречневая', 4),('Фарш', 5),
('Масло', 7),('Банан', 4),('Апельсин', 4),('Виноград', 7),
('Перец', 3),('Маргарин', 2),('Соль', 1),('Сахар', 3);

create table users
(
  id         bigserial primary key,
  username   varchar(36) not null,
  password   varchar(80) not null,
  email      varchar(50) unique,
  created_at timestamp default current_timestamp,
  updated_at timestamp default current_timestamp
);

create table roles
(
  id         bigserial primary key,
  name       varchar(50) not null,
  created_at timestamp default current_timestamp,
  updated_at timestamp default current_timestamp
);

create table users_roles
(
  user_id    bigint not null references users (id),
role_id    bigint not null references roles (id),
created_at timestamp default current_timestamp,
updated_at timestamp default current_timestamp,
primary key (user_id, role_id)
);

insert into roles (name)
values ('ROLE_USER'),
('ROLE_ADMIN');

insert into users (username, password, email)
values ('user', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'user@gmail.com'),
('admin', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'admin@gmail.com');

insert into users_roles (user_id, role_id)
values (1, 1),
(2, 2);

create table orders
(
  id          bigserial primary key,
  user_id     bigint not null references users (id),
total_price int    not null,
address     varchar(255),
phone       varchar(255),
created_at  timestamp default current_timestamp,
updated_at  timestamp default current_timestamp
);

create table order_items
(
  id                bigserial primary key,
  product_id        bigint not null references products (id),
order_id          bigint not null references orders (id),
quantity          int    not null,
price_per_product int    not null,
price             int    not null,
created_at        timestamp default current_timestamp,
updated_at        timestamp default current_timestamp
);





