package dhhighschool.studentmanagedh.dao;

import dhhighschool.studentmanagedh.model.Classification;
import dhhighschool.studentmanagedh.model.TestScores;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestScoreDAO implements ITestScoreDAO{
    private final String jdbcURL = "jdbc:mysql://localhost:3306/studentmanage?useSSL=false";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "Trantrung.00";
    private static final String SELECT_ALL_TESTSCORE = "SELECT * FROM testscores;";
    private static final String SELECT_TESTSCORE_SQL = "SELECT * FROM testscores WHERE student_code=?;";
    private static final String SELECT_TESTSCORE_CODE_SUBID = "SELECT * FROM testscores WHERE student_code =? and subjects_id = ?;";
    private static final String INSERT_TESTSCORE_SQL = "INSERT INTO testscores(student_code, subjects_id, f_testScore, s_testScore, t_testScore, classification_id, sum) \n" +
            "VALUES (?, ?, ?, ?, ?, ?, ?);";
    private static final String UPDATE_SCORE_SQL = "UPDATE studentmanage.testscores SET f_testScore = ?, s_testScore = ?, t_testScore = ? \n" +
            "WHERE student_code = ? and subjects_id = ?;";
    private static final String SELECT_LEADERBOARD_SQL = "select * from leaderboard;";

    public TestScoreDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName ( "com.mysql.jdbc.Driver" );
            connection = DriverManager.getConnection ( jdbcURL, jdbcUsername, jdbcPassword );
        } catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace ();
        }
        return connection;
    }

    @Override
    public List<TestScores> selectAllTestScores() {
        List<TestScores> testScores = new ArrayList<> ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection ();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement ( SELECT_ALL_TESTSCORE );) {
            System.out.println ( preparedStatement );
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery ();

            // Step 4: Process the ResultSet object.
            while (rs.next ()) {
                int testScores_id = rs.getInt ( "testScores_id" );
                int subjects_id = rs.getInt ( "subjects_id" );
                String student_code = rs.getString ( "student_code" );
                float f_testScore = rs.getFloat ( "f_testScore" );
                float s_testScore = rs.getFloat ( "s_testScore" );
                float t_testScore = rs.getFloat ( "t_testScore" );
                int classification_id = rs.getInt ( "classification_id" );
                float sum = rs.getFloat ("sum");

                testScores.add ( new TestScores ( testScores_id, student_code, subjects_id, f_testScore, s_testScore, t_testScore, classification_id, sum ) );
            }
        } catch (SQLException e) {
            printSQLException ( e );
        }
        return testScores;
    }

    @Override
    public TestScores selectByCodeSubid(String student_code) {
        TestScores testScores = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection ();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement ( SELECT_TESTSCORE_SQL );) {
            preparedStatement.setString ( 1, student_code );
            System.out.println ( preparedStatement );
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery ();
            // Step 4: Process the ResultSet object.
            while (rs.next ()) {
                int testScores_id = rs.getInt ( "testScores_id" );
                int subjects_id = rs.getInt ( "subjects_id" );
                float f_testScore = rs.getFloat ("f_testScore");
                float s_testScore = rs.getFloat ("s_testScore");
                float t_testScore = rs.getFloat ("t_testScore");
                int classification_id = rs.getInt ( "classification_id" );
                float sum = rs.getFloat ("sum");

                testScores = new TestScores ( testScores_id, student_code, subjects_id, f_testScore, s_testScore, t_testScore, classification_id, sum );
            }
        } catch (SQLException e) {
            printSQLException ( e );
        }
        return testScores;
    }

    @Override
    public TestScores selectByCodeSubid(String student_code, int subject_id) {
        TestScores testScores = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection ();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement ( SELECT_TESTSCORE_CODE_SUBID );) {
            preparedStatement.setString ( 1, student_code );
            preparedStatement.setInt ( 2, subject_id );
            System.out.println ( preparedStatement );
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery ();
            // Step 4: Process the ResultSet object.
            while (rs.next ()) {
                int testScores_id = rs.getInt ( "testScores_id" );
                float f_testScore = rs.getFloat ("f_testScore");
                float s_testScore = rs.getFloat ("s_testScore");
                float t_testScore = rs.getFloat ("t_testScore");
                int classification_id = rs.getInt ( "classification_id" );
                float sum = rs.getFloat ("sum");
                testScores = new TestScores ( testScores_id, student_code, subject_id, f_testScore, s_testScore, t_testScore, classification_id, sum );
            }
        } catch (SQLException e) {
            printSQLException ( e );
        }
        return testScores;
    }

    @Override
    public void insertTestScores(TestScores testScores) throws SQLException {
        try (Connection connection = getConnection (); PreparedStatement preparedStatement = connection.prepareStatement ( INSERT_TESTSCORE_SQL )) {
            preparedStatement.setString ( 1, testScores.getStudent_code () );
            preparedStatement.setInt ( 2, testScores.getSubjects_id () );
            preparedStatement.setFloat ( 3, testScores.getF_testScore () );
            preparedStatement.setFloat ( 4, testScores.getS_testScore () );
            preparedStatement.setFloat ( 5, testScores.getT_testScore () );
            preparedStatement.setInt ( 6, testScores.getClassification_id () );
            preparedStatement.setFloat ( 7, testScores.getSum () );
            System.out.println ( preparedStatement );
            preparedStatement.executeUpdate ();
        } catch (SQLException e) {
            printSQLException ( e );
        }
    }

    @Override
    public boolean editScore(TestScores scores) throws SQLException {
        boolean rowUpdated;
//        "UPDATE studentmanage.testscores SET f_testScore = ?, s_testScore = ?, t_testScore = ? \n" +
//                "WHERE student_code = ? and subjects_id = ?;";
        try (Connection connection = getConnection (); PreparedStatement statement = connection.prepareStatement ( UPDATE_SCORE_SQL );) {
            statement.setFloat ( 1, scores.getF_testScore () );
            statement.setFloat ( 2, scores.getS_testScore () );
            statement.setFloat ( 3, scores.getT_testScore () );
            statement.setString ( 4, scores.getStudent_code () );
            statement.setInt ( 5, scores.getSubjects_id () );

            rowUpdated = statement.executeUpdate () > 0;
        }
        return rowUpdated;
    }
    @Override
    public List<TestScores> leaderboard() {
        List<TestScores> leaderboards = new ArrayList<> ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection ();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement ( SELECT_LEADERBOARD_SQL );) {
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery ();

            // Step 4: Process the ResultSet object.
            while (rs.next ()) {
                String code = rs.getString ( "student_code" );
                float sumAll = rs.getFloat ( "sum(sum)" );

                leaderboards.add ( new TestScores ( code, sumAll) );
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        return leaderboards;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if ( e instanceof SQLException ) {
                e.printStackTrace ( System.err );
                System.err.println ( "SQLState: " + ((SQLException) e).getSQLState () );
                System.err.println ( "Error Code: " + ((SQLException) e).getErrorCode () );
                System.err.println ( "Message: " + e.getMessage () );
                Throwable t = ex.getCause ();
                while (t != null) {
                    System.out.println ( "Cause: " + t );
                    t = t.getCause ();
                }
            }
        }
    }
}
