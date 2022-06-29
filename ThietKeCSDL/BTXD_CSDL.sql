-- CREATE SCHEMA QuanLyBanHang;
USE QuanLyBanHang;
CREATE TABLE Customer(
cID 		INT	NOT NULL PRIMARY KEY,
cName		VARCHAR(30),
cAge		INT
);
CREATE TABLE `Order`(
oID			INT NOT NULL PRIMARY KEY,
cID 		INT NOT NULL,
oDate 		DATE,
oTotalPrice DOUBLE,
FOREIGN KEY (cID) REFERENCES Customer(cID)
);
CREATE TABLE Product(
pID 		INT NOT NULL PRIMARY KEY,
pName 		VARCHAR(30),
pPrice		DOUBLE
);
CREATE TABLE OrderDetail(
oID			INT NOT NULL,
pID			INT NOT NULL,
odQTY		INT,
FOREIGN KEY (oID) REFERENCES `Order`(oID),
FOREIGN KEY (pID) REFERENCES Product(pID)
);
INSERT INTO Product(pID, pName, pPrice)
VALUE (1, 'Tra de ngu', 55.5),
	  (2, 'Tra giam can', 35.1),
	  (3, 'Tra tang can', 35.5),
	  (4, 'Tra tinh tam', 999.9);
INSERT INTO Customer(cID, cName, cAge)
VALUE (1, 'Trung', 26),
	  (2, 'Ngoc', 19),
	  (3, 'Dat', 27);
INSERT INTO `Order`(oID, cID, oDate, oTotalPrice)
VALUE (1, 1, '2022-06-29', 55.5),
	  (2, 1, '2022-06-29', 71.2),
	  (3, 1, '2022-06-29', 35.5),
	  (4, 2, '2022-06-29', 999.9);
INSERT INTO OrderDetail(oID, pID, odQTY)
VALUES (1, 1, -1),
	  (1, 2, 2),
	  (4, 2, 55),
	  (1, 3, -123),
	  (2, 2, 23),
	  (2, 3, -5);
DELETE FROM quanlybanhang.orderdetail;
TRUNCATE quanlybanhang.orderdetail;