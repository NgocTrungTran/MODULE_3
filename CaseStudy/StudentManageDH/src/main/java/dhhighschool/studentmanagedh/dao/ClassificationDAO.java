package dhhighschool.studentmanagedh.dao;

import dhhighschool.studentmanagedh.model.Classes;
import dhhighschool.studentmanagedh.model.Classification;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassificationDAO implements IClassificationDAO {

    private final String jdbcURL = "jdbc:mysql://localhost:3306/studentmanage?useSSL=false";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "Trantrung.00";
    private static final String SELECT_ALL_Classification = "SELECT * FROM classifications;";
    private static final String SELECT_Classification_SQL = "SELECT * FROM classifications WHERE id=?;";
    private static final String INSERT_Classification_SQL = "INSERT INTO classifications (name) VALUES (?);";

    public ClassificationDAO() {
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
    public List<Classification> selectAllClassification() {
        List<Classification> classifications = new ArrayList<> ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection ();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement ( SELECT_ALL_Classification );) {
            System.out.println ( preparedStatement );
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery ();

            // Step 4: Process the ResultSet object.
            while (rs.next ()) {
                int id = rs.getInt ( "classification_id" );
                String name = rs.getString ( "classification" );
                classifications.add ( new Classification ( id, name ) );
            }
        } catch (SQLException e) {
            printSQLException ( e );
        }
        return classifications;
    }

    @Override
    public Classification selectClassification(int id) {
        Classification classification = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection ();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement ( SELECT_Classification_SQL );) {
            preparedStatement.setInt ( 1, id );
            System.out.println ( preparedStatement );
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery ();
            // Step 4: Process the ResultSet object.
            while (rs.next ()) {
                String className = rs.getString ( "classification" );
                classification = new Classification ( id, className );
            }
        } catch (SQLException e) {
            printSQLException ( e );
        }
        return classification;
    }

    @Override
    public void insertClassification(Classification classification) throws SQLException {
        try (Connection connection = getConnection (); PreparedStatement preparedStatement = connection.prepareStatement ( INSERT_Classification_SQL )) {
            preparedStatement.setString ( 1, classification.getClassification () );
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

