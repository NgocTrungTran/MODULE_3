USE quanlysinhvien;
-- Lay fu lieu hoc vien tu bang Student
SELECT 
    *
FROM
    Student;
-- Lay du lieu hoc vien tu bang Student co Status la 1
SELECT 
    *
FROM
    Student
WHERE
    Status = TRUE;
-- Lay du lieu mon hoc co thoi gian hoc nho hon 10
SELECT 
    *
FROM
    Subject
WHERE
    Credit < 10;
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