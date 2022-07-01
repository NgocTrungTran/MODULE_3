USE quanlysinhvien;
-- Hien thi danh sach hoc vien lop A1 bang JOIN va WHERE
SELECT 
    S.StudentId, S.StudentName, C.ClassName
FROM
    Student S
        JOIN
    Class C ON S.ClassId = C.ClassID
WHERE
    C.ClassName = 'A1';
-- Hien thi cac mo CF cua hoc vien
# Hien thi tat ca cac diem dang co cua hoc vien
SELECT 
    S.StudentId, S.StudentName, Sub.SubName, M.Mark
FROM
    Student S
        JOIN
    Mark M ON S.StudentId = M.StudentId
        JOIN
    Subject Sub ON M.SubId = Sub.SubId;
# Hien thi diem mon CF
SELECT 
    S.StudentId, S.StudentName, Sub.SubName, M.Mark
FROM
    Student S
        JOIN
    Mark M ON S.StudentId = M.StudentId
        JOIN
    Subject Sub ON M.SubId = Sub.SubId
WHERE
    Sub.SubName = 'CF';
    -- BT Truy van CSDL
-- Hien thi tat ca sinh vien co ten bat dau bang ky tu 'h'
SELECT 
    *
FROM
    Student
WHERE
    StudentName LIKE 'h%';
-- Hien thi tat ca lop hoc bat dau vao thang 12
SELECT 
    *
FROM
    Class
WHERE
StartDate Like '_____12%';
 #   StartDate BETWEEN '2008-12-01' AND '2008-12-31';
 -- Hien thi thong tin mon hoc co Credit trong khoang 3 - 5
SELECT 
    *
FROM
    Subject
WHERE
    Credit BETWEEN 3 AND 5;
-- Thay doi ma lop cua hoc vien hung la 2
UPDATE Student 
SET 
    ClassId = 2
WHERE
    StudentName = 'Hung';
-- Hiển thị các thông tin: StudentName, SubName, Mark. 
-- Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.
SELECT 
    S.StudentId, S.StudentName, Sub.SubName, M.Mark
FROM
    Student S
        JOIN
    Mark M ON S.StudentId = M.StudentId
        JOIN
    Subject Sub ON Sub.SubId = M.SubId
ORDER BY M.Mark DESC, S.StudentName ASC;

