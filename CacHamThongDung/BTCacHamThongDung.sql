use quanlysinhvien;
-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
SELECT 
    SubId, SubName, MAX(Credit)
FROM
    subject
GROUP BY SubId , SubName
HAVING MAX(Credit) >= ALL (SELECT 
        MAX(Credit)
    FROM
        subject
);
-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
SELECT 
    Sub.SubId, Sub.SubName, Sub.Credit, Sub.Status, MAX(Mark)
FROM
    Subject Sub
        JOIN
    Mark M ON Sub.SubId = M.SubId
GROUP BY Sub.SubId , Sub.SubName , Sub.Credit , Sub.Status
HAVING MAX(Mark) >= ALL (SELECT 
        MAX(Mark)
    FROM
        Mark
	GROUP BY Mark.SubId);
-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên,
-- xếp hạng theo thứ tự điểm giảm dần
SELECT 
    S.StudentID, S.StudentName, S.Address, S.Phone, AVG(Mark)
FROM
    Student S
        JOIN
    Mark M ON S.StudentId = M.StudentId
GROUP BY S.StudentID, S.StudentName, S.Address, S.Phone
ORDER BY AVG(Mark) DESC;
        