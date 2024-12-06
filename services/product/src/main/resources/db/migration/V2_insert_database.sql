INSERT INTO category (id, name)
VALUES
    (nextval('category_seq'), 'Electronics'),
    (nextval('category_seq'), 'Furniture'),
    (nextval('category_seq'), 'Clothing'),
    (nextval('category_seq'), 'Sports'),
    (nextval('category_seq'), 'Books'),
    (nextval('category_seq'), 'Home Appliances'),
    (nextval('category_seq'), 'Toys');

-- Electronics Products
INSERT INTO product (id, name, brand, price, inventory, description, category_id)
VALUES
    (nextval('product_seq'), 'Smartphone', 'BrandA', 699.99, 100, 'Latest model with high-end features', (SELECT id FROM category WHERE name = 'Electronics' LIMIT 1)),
    (nextval('product_seq'), 'Laptop', 'BrandB', 899.99, 75, 'Lightweight laptop with powerful performance', (SELECT id FROM category WHERE name = 'Electronics' LIMIT 1)),
    (nextval('product_seq'), 'Bluetooth Headphones', 'BrandC', 99.99, 150, 'Noise-canceling headphones with excellent sound', (SELECT id FROM category WHERE name = 'Electronics' LIMIT 1));

-- Furniture Products
INSERT INTO product (id, name, brand, price, inventory, description, category_id)
VALUES
    (nextval('product_seq'), 'Sofa', 'BrandD', 499.99, 50, 'Comfortable 3-seater sofa', (SELECT id FROM category WHERE name = 'Furniture' LIMIT 1)),
    (nextval('product_seq'), 'Dining Table', 'BrandE', 299.99, 30, 'Wooden dining table with 6 chairs', (SELECT id FROM category WHERE name = 'Furniture' LIMIT 1)),
    (nextval('product_seq'), 'Office Chair', 'BrandF', 120.00, 40, 'Ergonomic office chair', (SELECT id FROM category WHERE name = 'Furniture' LIMIT 1));

-- Clothing Products
INSERT INTO product (id, name, brand, price, inventory, description, category_id)
VALUES
    (nextval('product_seq'), 'T-Shirt', 'BrandG', 19.99, 200, 'Cotton T-shirt, various colors', (SELECT id FROM category WHERE name = 'Clothing' LIMIT 1)),
    (nextval('product_seq'), 'Jeans', 'BrandH', 49.99, 100, 'Comfortable denim jeans', (SELECT id FROM category WHERE name = 'Clothing' LIMIT 1)),
    (nextval('product_seq'), 'Sweater', 'BrandI', 39.99, 80, 'Warm sweater for winter', (SELECT id FROM category WHERE name = 'Clothing' LIMIT 1));

-- Sports Products
INSERT INTO product (id, name, brand, price, inventory, description, category_id)
VALUES
    (nextval('product_seq'), 'Soccer Ball', 'BrandJ', 25.99, 150, 'Durable soccer ball for outdoor play', (SELECT id FROM category WHERE name = 'Sports' LIMIT 1)),
    (nextval('product_seq'), 'Tennis Racket', 'BrandK', 89.99, 60, 'Lightweight and strong tennis racket', (SELECT id FROM category WHERE name = 'Sports' LIMIT 1)),
    (nextval('product_seq'), 'Yoga Mat', 'BrandL', 19.99, 120, 'Non-slip yoga mat for all exercises', (SELECT id FROM category WHERE name = 'Sports' LIMIT 1));

-- Books Products
INSERT INTO product (id, name, brand, price, inventory, description, category_id)
VALUES
    (nextval('product_seq'), 'Science Fiction Novel', 'AuthorA', 15.99, 200, 'A thrilling science fiction novel', (SELECT id FROM category WHERE name = 'Books' LIMIT 1)),
    (nextval('product_seq'), 'Cookbook', 'AuthorB', 25.99, 80, 'Delicious recipes for every occasion', (SELECT id FROM category WHERE name = 'Books' LIMIT 1)),
    (nextval('product_seq'), 'Travel Guide', 'AuthorC', 18.99, 60, 'A guide to the world best travel destinations', (SELECT id FROM category WHERE name = 'Books' LIMIT 1));

-- Home Appliances Products
INSERT INTO product (id, name, brand, price, inventory, description, category_id)
VALUES
    (nextval('product_seq'), 'Vacuum Cleaner', 'BrandM', 159.99, 100, 'Powerful vacuum cleaner for deep cleaning', (SELECT id FROM category WHERE name = 'Home Appliances' LIMIT 1)),
    (nextval('product_seq'), 'Air Conditioner', 'BrandN', 499.99, 30, 'Energy-efficient air conditioner', (SELECT id FROM category WHERE name = 'Home Appliances' LIMIT 1)),
    (nextval('product_seq'), 'Washing Machine', 'BrandO', 399.99, 25, 'High-efficiency washing machine', (SELECT id FROM category WHERE name = 'Home Appliances' LIMIT 1));

-- Toys Products
INSERT INTO product (id, name, brand, price, inventory, description, category_id)
VALUES
    (nextval('product_seq'), 'Action Figure', 'BrandP', 19.99, 150, 'Poseable action figure', (SELECT id FROM category WHERE name = 'Toys' LIMIT 1)),
    (nextval('product_seq'), 'Doll House', 'BrandQ', 59.99, 100, 'Detailed doll house with accessories', (SELECT id FROM category WHERE name = 'Toys' LIMIT 1)),
    (nextval('product_seq'), 'Lego Set', 'BrandR', 39.99, 200, 'Creative Lego building set', (SELECT id FROM category WHERE name = 'Toys' LIMIT 1));

-- Electronics Images
INSERT INTO image (id, file_name, file_type, image, download_url, product_id)
VALUES
    (nextval('image_seq'), 'smartphone_image.jpg', 'image/jpeg', NULL, 'http://example.com/smartphone_image.jpg', (SELECT id FROM product WHERE name = 'Smartphone' LIMIT 1)),
    (nextval('image_seq'), 'laptop_image.jpg', 'image/jpeg', NULL, 'http://example.com/laptop_image.jpg', (SELECT id FROM product WHERE name = 'Laptop' LIMIT 1)),
    (nextval('image_seq'), 'headphones_image.jpg', 'image/jpeg', NULL, 'http://example.com/headphones_image.jpg', (SELECT id FROM product WHERE name = 'Bluetooth Headphones' LIMIT 1));

-- Furniture Images
INSERT INTO image (id, file_name, file_type, image, download_url, product_id)
VALUES
    (nextval('image_seq'), 'sofa_image.jpg', 'image/jpeg', NULL, 'http://example.com/sofa_image.jpg', (SELECT id FROM product WHERE name = 'Sofa' LIMIT 1)),
    (nextval('image_seq'), 'dining_table_image.jpg', 'image/jpeg', NULL, 'http://example.com/dining_table_image.jpg', (SELECT id FROM product WHERE name = 'Dining Table' LIMIT 1)),
    (nextval('image_seq'), 'office_chair_image.jpg', 'image/jpeg', NULL, 'http://example.com/office_chair_image.jpg', (SELECT id FROM product WHERE name = 'Office Chair' LIMIT 1));

-- Clothing Images
INSERT INTO image (id, file_name, file_type, image, download_url, product_id)
VALUES
    (nextval('image_seq'), 'tshirt_image.jpg', 'image/jpeg', NULL, 'http://example.com/tshirt_image.jpg', (SELECT id FROM product WHERE name = 'T-Shirt' LIMIT 1)),
    (nextval('image_seq'), 'jeans_image.jpg', 'image/jpeg', NULL, 'http://example.com/jeans_image.jpg', (SELECT id FROM product WHERE name = 'Jeans' LIMIT 1)),
    (nextval('image_seq'), 'sweater_image.jpg', 'image/jpeg', NULL, 'http://example.com/sweater_image.jpg', (SELECT id FROM product WHERE name = 'Sweater' LIMIT 1));

-- Sports Images
INSERT INTO image (id, file_name, file_type, image, download_url, product_id)
VALUES
    (nextval('image_seq'), 'soccer_ball_image.jpg', 'image/jpeg', NULL, 'http://example.com/soccer_ball_image.jpg', (SELECT id FROM product WHERE name = 'Soccer Ball' LIMIT 1)),
    (nextval('image_seq'), 'tennis_racket_image.jpg', 'image/jpeg', NULL, 'http://example.com/tennis_racket_image.jpg', (SELECT id FROM product WHERE name = 'Tennis Racket' LIMIT 1)),
    (nextval('image_seq'), 'yoga_mat_image.jpg', 'image/jpeg', NULL, 'http://example.com/yoga_mat_image.jpg', (SELECT id FROM product WHERE name = 'Yoga Mat' LIMIT 1));

-- Books Images
INSERT INTO image (id, file_name, file_type, image, download_url, product_id)
VALUES
    (nextval('image_seq'), 'book_image1.jpg', 'image/jpeg', NULL, 'http://example.com/book_image1.jpg', (SELECT id FROM product WHERE name = 'Science Fiction Novel' LIMIT 1)),
    (nextval('image_seq'), 'book_image2.jpg', 'image/jpeg', NULL, 'http://example.com/book_image2.jpg', (SELECT id FROM product WHERE name = 'Cookbook' LIMIT 1)),
    (nextval('image_seq'), 'book_image3.jpg', 'image/jpeg', NULL, 'http://example.com/book_image3.jpg', (SELECT id FROM product WHERE name = 'Travel Guide' LIMIT 1));

-- Home Appliances Images
INSERT INTO image (id, file_name, file_type, image, download_url, product_id)
VALUES
    (nextval('image_seq'), 'vacuum_cleaner_image.jpg', 'image/jpeg', NULL, 'http://example.com/vacuum_cleaner_image.jpg', (SELECT id FROM product WHERE name = 'Vacuum Cleaner' LIMIT 1)),
    (nextval('image_seq'), 'air_conditioner_image.jpg', 'image/jpeg', NULL, 'http://example.com/air_conditioner_image.jpg', (SELECT id FROM product WHERE name = 'Air Conditioner' LIMIT 1)),
    (nextval('image_seq'), 'washing_machine_image.jpg', 'image/jpeg', NULL, 'http://example.com/washing_machine_image.jpg', (SELECT id FROM product WHERE name = 'Washing Machine' LIMIT 1));

-- Toys Images
INSERT INTO image (id, file_name, file_type, image, download_url, product_id)
VALUES
    (nextval('image_seq'), 'action_figure_image.jpg', 'image/jpeg', NULL, 'http://example.com/action_figure_image.jpg', (SELECT id FROM product WHERE name = 'Action Figure' LIMIT 1)),
    (nextval('image_seq'), 'doll_house_image.jpg', 'image/jpeg', NULL, 'http://example.com/doll_house_image.jpg', (SELECT id FROM product WHERE name = 'Doll House' LIMIT 1)),
    (nextval('image_seq'), 'lego_set_image.jpg', 'image/jpeg', NULL, 'http://example.com/lego_set_image.jpg', (SELECT id FROM product WHERE name = 'Lego Set' LIMIT 1));

