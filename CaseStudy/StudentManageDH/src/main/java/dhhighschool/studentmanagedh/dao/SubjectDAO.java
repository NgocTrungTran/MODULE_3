package dhhighschool.studentmanagedh.dao;

import dhhighschool.studentmanagedh.model.Subjects;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAO implements ISubjectDAO{
    private final String jdbcURL = "jdbc:mysql://localhost:3306/studentmanage?useSSL=false";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "Trantrung.00";
    private static final String SELECT_ALL_Subjects = "SELECT * FROM subjects;";
    private static final String SELECT_Subjects_SQL = "SELECT * FROM subjects WHERE id=?;";
    private static final String INSERT_Subjects_SQL = "INSERT INTO subjects (sub_name) VALUES (?);";

    public SubjectDAO() {
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
    public List<Subjects> selectAllSubjectDAO() {
        List<Subjects> subjectDAOS = new ArrayList<> ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection ();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement ( SELECT_ALL_Subjects );) {
            System.out.println ( preparedStatement );
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery ();

            // Step 4: Process the ResultSet object.
            while (rs.next ()) {
                int subjects_id = rs.getInt ( "subjects_id" );
                String sub_name = rs.getString ( "sub_name" );
                subjectDAOS.add ( new Subjects ( subjects_id, sub_name ) );
            }
        } catch (SQLException e) {
            printSQLException ( e );
        }
        return subjectDAOS;
    }

    @Override
    public Subjects selectSubjectDAO(int id) {
        Subjects subjects = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection ();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement ( SELECT_Subjects_SQL );) {
            preparedStatement.setInt ( 1, id );
            System.out.println ( preparedStatement );
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery ();
            // Step 4: Process the ResultSet object.
            while (rs.next ()) {
                String className = rs.getString ( "classification" );
                subjects = new Subjects ( id, className );
            }
        } catch (SQLException e) {
            printSQLException ( e );
        }
        return subjects;
    }

    @Override
    public void insertSubjectDAO(Subjects subject) throws SQLException {
        try (Connection connection = getConnection (); PreparedStatement preparedStatement = connection.prepareStatement ( INSERT_Subjects_SQL )) {
            preparedStatement.setString ( 1, subject.getSub_name () );
            System.out.println ( preparedStatement );
            preparedStatement.executeUpdate ();
        } catch (SQLException e) {
            printSQLException ( e );
        }
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
