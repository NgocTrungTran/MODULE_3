package dhhighschool.studentmanagedh.dao;

import dhhighschool.studentmanagedh.model.Student;
import dhhighschool.studentmanagedh.model.TestScores;

import java.sql.SQLException;
import java.util.List;

public interface ITestScoreDAO {
    List<TestScores> selectAllTestScores();
    TestScores selectByCodeSubid(String student_code);
    boolean editScore(TestScores scores) throws SQLException;
    TestScores selectByCodeSubid(String student_code, int subject_id);
    void insertTestScores(TestScores testScores) throws SQLException;
    List<TestScores> leaderboard();

}
