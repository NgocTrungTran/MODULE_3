package dhhighschool.studentmanagedh.dao;

import dhhighschool.studentmanagedh.model.Student;
import dhhighschool.studentmanagedh.model.TestScores;

import java.sql.SQLException;
import java.util.List;

public interface IStudentDAO {
    List<Student> selectAllStudent();
    List<Student> selectTrashListStudent();
    public void insertStudent(Student student) throws SQLException;
    Student selectStudent(String code);
    Student selectStudentByPhone(String phone);
    Student selectStudentByEmail(String email);
    List<Student> selectListClassStudent(int offset, int noOfRecords, int classId) throws SQLException;
    List<Student> searchStudent(int offset, int noOfRecords, String search) throws SQLException;
    boolean deleteStudent(String code) throws SQLException;
    boolean removeStudent(String code) throws SQLException;
    boolean restoreStudent(String code) throws SQLException;

    boolean updateStudent(Student student) throws SQLException;

    List<Student> sortFullNameADC(List<Student> userList);
    List<Student> sortFullNameDEC(List<Student> userList);
    List<Student> searchNameStudent(String name);
    public int getNoOfRecords();
}
