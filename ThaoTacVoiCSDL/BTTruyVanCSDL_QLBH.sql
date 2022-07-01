USE quanlybanhang;
-- Them du lieu vao bang Customer
insert into Customer
values (1, 'Minh Quan', 10),
(2, 'Ngoc Oanh', 20),
(3, 'Hong Ha', 50)
;
-- Them du lieu vao Order
insert into `Order`(oID, cID, oDate)
values (1, 1, '2006-03-21'),
(2, 2, '2006-03-23'),
(3, 1, '2006-03-16');
-- Them du lieu vao Product
insert into product
values (1, 'May Giat', 3),
(2, 'Tu Lanh', 5),
(3, 'Dieu Hoa', 7),
(4, 'Quat', 1),
(5, 'Bep Dien', 2);
-- Them du lieu vao OrderDetail
insert into OrderDetail
values (1, 1, 3),
(1, 3, 7),
(1, 4, 2),
(2, 1, 1),
(3, 1, 8),
(2, 5, 4),
(2, 3, 3);
-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select oID, oDate, oTotalPrice
from `Order`;
-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select O.oID, C.cID, C.cName, P.pID, P.pName
from `Order` O 
join Orderdetail Od on O.oID = Od.oID
join Customer C on O.cID = C.cID
join Product P on Od.pID = P.pID;
-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select *
from Customer C, `Order` O
where O.cID <> C.cID;
-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn 
-- (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. 
-- Giá bán của từng loại được tính = odQTY*pPrice)
select O.oID, O.oDate, O.oTotalPrice
from `Order` O 
join Orderdetail Od on O.oID = Od.oID
join Product P on Od.pID = P.pID;
# and O.oTotalPrice = Od.odQTY * P.pPrice;
