USE quanlysinhvien;
INSERT INTO class(ClassID, ClassName, StartDate, Status)
VALUES (1, 'A1', '2008-12-20', 1),
	   (2, 'A2', '2008-12-22', 1),
	   (3, 'B3', current_timestamp(), 1);
INSERT INTO class
VALUES (4, 'B3', current_timestamp(), 1);
INSERT INTO class
VALUES (5, 'B4', current_timestamp(), 1);
INSERT INTO student(StudentId, StudentName, Address, Phone, Status, ClassId)
VALUES (1,'Hung', 'Ha Noi', '0912113113', 1, 1);
INSERT INTO student(StudentId, StudentName, Address, Status, ClassId)
VALUES (2,'Hoa', 'Hai Phong', 1, 1);
INSERT INTO student(StudentId, StudentName, Address, Phone, Status, ClassId)
VALUES (3,'Manh', 'HCM', '0123123123', 0, 2);
INSERT INTO Subject 
value (1, 'CF', 5, 1),
(2, 'C', 6, 1),
(3, 'HDJ', 5, 1),
(4, 'RDBMS', 10, 1);
INSERT INTO MARK(SubId, StudentId, Mark, ExamTimes)
VALUES (1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 1, 12, 1);