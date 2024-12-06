create table if not exists category
(
    id bigint not null primary key,
    name varchar(225)
);

create table if not exists product
(
    id bigint not null primary key,
    name varchar(225),
    brand varchar(225),
    price numeric(38,2),
    inventory int not null ,
    description varchar(225),
    category_id bigint constraint fk_Product_Category references category
);

create table if not exists image
(
    id bigint not null primary key,
    file_name varchar(225),
    file_type varchar(225),
    image oid,
    download_url varchar(225),
    product_id bigint constraint fk_Image_Product references product
);
create sequence if not exists category_seq increment by 50;
create sequence if not exists product_seq increment by 50;
create sequence if not exists image_seq increment by 50;
