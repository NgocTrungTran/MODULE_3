EXPLAIN SELECT * FROM customers where customerName = 'Land of Toys Inc.';
-- them chi muc cho cot customerName
ALTER TABLE customers ADD INDEX idx_customerName(customerName);
-- phan tich cac truy van CSDL
EXPLAIN SELECT * FROM customers WHERE customerName = 'Land of Toys Inc.';
SELECT * FROM customers WHERE customerName = 'Land of Toys Inc.';
-- them chi muc cho 2 cot contactFirstName va contactLastName
alter table customers add index idx_full_name(contactFirstName, contactLastName);
explain select * from customers where contactFirstName = 'Jean' or contactFirstName = 'King';
select * from customers where contactFirstName = 'Jean' or contactFirstName = 'King';
-- xoa chi muc trong bang
alter table customers drop index idx_full_name;
explain select * from customers where contactFirstName = 'Jean' or contactFirstName = 'King';