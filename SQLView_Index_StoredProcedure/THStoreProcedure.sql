use quanlybanhang;
-- Tao Procedure moi
DELIMITER $$
create procedure findAllCustomers()
begin
	select * from customer;
end; $$
DELIMITER 
-- goi Procedure
call findAllCustomers();
-- Xoa va tao lai procedure
DELIMITER $$
drop procedure if exists `findAllCustomers` $$
create procedure findAllCustomers()
begin
	select * from customer where cAge = 50;
end; $$