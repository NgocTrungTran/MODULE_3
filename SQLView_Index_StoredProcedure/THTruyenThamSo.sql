use classicmodels;
-- Tham so loai IN 
DELIMITER //
create procedure getCusById(IN cusNum INT(11))
begin
	select * from customers where customerNumber = cusNum;
end //
DELIMITER ;
call getCusById(175);

-- Tham so loai out
DELIMITER // 
drop procedure if exists `GetCustomersCountByCity` //
create procedure GetCustomersCountByCity(IN in_city VARCHAR(50), OUT total INT)
begin
	select count(customerNumber)
    into total
    from customers
    where city = in_city;
end //
DELIMITER ;
call GetCustomersCountByCity('Madrid',@total);
select @total;

-- Tham so loai INOUT
DELIMITER //
create procedure SetCounter(INOUT counter int, in inc int)
begin 
	set counter = counter + inc;
end //
DELIMITER ;
set @counter = 1;
call SetCounter(@counter,1); -- 2
call SetCounter(@counter,1); -- 3
call SetCounter(@counter,5); -- 8
select @counter; -- 8
