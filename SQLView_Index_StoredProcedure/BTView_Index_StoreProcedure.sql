-- B1: Tao CSDL demo
create database demo;

-- B2: Tao bang Products
create table Products(
id 					int not null auto_increment primary key,
productCode			varchar(10) not null,
productName			varchar(30) not null,
productPrice 		int,
productAmount		int,
productDescription	varchar(50),
productStatus		varchar(30)
-- check (productPrice > 1000 and productAmount >= 0)
);
-- Chen mot so du lieu
insert into Products(productCode, 
productName, 
productPrice, 
productAmount, 
productDescription, 
productStatus)
values ('IP 6', 'Iphone 6', 5800000, 25, 'May cu 99%', 'Con hang'),
('NK L5', 'Nokia Lumia 5', 2900000, 10, 'May moi', 'Con hang'),
('OP R6', 'Oppo Reno 6', 10390000, 5, 'May moi', 'Con hang'),
('SS GS22', 'Samsung Galaxy S22', 27990000, 2, 'May cu 99%', 'Con hang'),
('XM R9c', 'Xiaomi Redmi 9C', 3490000, 0, 'May moi', 'Het hang'),
('IP 11P', 'Iphone 11 Pro Max', 15000000, 3, 'May moi', 'Con hang'),
('IP 13P', 'Iphone 13 Pro Max', 29290000, 12, 'May moi', 'Con hang'),
('SS GM53', 'Samsung Galaxy M53', 11490000, 0, 'May moi', 'Het hang');

-- B3: 
-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
create unique index ind_pCode on Products(productCode);
-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
CREATE UNIQUE INDEX ind_pName_pPrice ON products(productName, productPrice);
ALTER TABLE products ADD INDEX indPNamePPrice(productName, productPrice);
-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
EXPLAIN SELECT * FROM products WHERE productName = 'Iphone' OR productPrice = 3490000;
-- Xoa Index
ALTER TABLE products DROP INDEX ind_pName_pPrice;

-- B4: 
-- Tạo view lấy về các thông tin: 
-- productCode, productName, productPrice, productStatus từ bảng products.
CREATE VIEW product_view AS
	SELECT productCode, productName, productPrice, productStatus
    FROM products;
SELECT * FROM product_view;
-- Tiến hành sửa đổi view
CREATE OR REPLACE VIEW product_view AS
	SELECT productCode, productName, productPrice, productStatus
    FROM products
    WHERE productStatus = 'Con hang';
SELECT * FROM product_view;

-- B5:
-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
DELIMITER //
CREATE PROCEDURE findAllProduct()
	BEGIN
		SELECT * FROM Products;
	END //
DELIMITER ;
CALL findAllProduct();
-- Tạo store procedure thêm một sản phẩm mới
DELIMITER //
CREATE PROCEDURE addProduct(pCode varchar(10),
							pName varchar(30), 
							pPrice INT, 
                            pAmount INT, 
                            pDescription varchar(50), 
                            pStatus varchar(30))
	BEGIN
		INSERT INTO Products(productCode, productName, productPrice, productAmount, productDescription, productStatus)
        VALUES (pCode, pName, pPrice, pAmount, pDescription, pStatus);
        CALL findAllProduct();
	END //
DELIMITER ;
CALL addProduct('NK G21', 'Nokia G21', 4290000, 17, 'May moi', 'Con hang');
-- Tạo store procedure sửa thông tin sản phẩm (gia san pham) theo id
DELIMITER // 
-- --  DROP PROCEDURE IF EXISTS `updateProduct` //
CREATE PROCEDURE updateProduct(pId INT,
							   pPrice INT)
	BEGIN
		UPDATE Products SET productPrice = pPrice WHERE id = pId;
        CALL findAllProduct();
	END //
DELIMITER ;
CALL updateProduct(1, 5800000);
-- Tạo store procedure xoá sản phẩm theo id
DELIMITER // 
CREATE PROCEDURE removeProduct(pId INT)
	BEGIN
		DELETE FROM Products WHERE id = pId;
        CALL findAllProduct();
	END //
DELIMITER ;
CALL removeProduct(2);
