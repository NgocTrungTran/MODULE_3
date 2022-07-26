package dhhighschool.studentmanagedh.dao;

import dhhighschool.studentmanagedh.model.Classes;
import dhhighschool.studentmanagedh.model.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassDAO implements IClassDAO {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/studentmanage?useSSL=false";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "Trantrung.00";

    private static final String SELECT_ALL_CLASSES = "SELECT * FROM classes;";
    private static final String SELECT_CLASSES_SQL = "SELECT * FROM classes WHERE c_id = ?;";
    private static final String INSERT_CLASSES_SQL = "INSERT INTO classes (name) VALUES (?);";

    public ClassDAO() {

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
    public List<Classes> selectAllClass() {
        List<Classes> classesList = new ArrayList<> ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection ();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement ( SELECT_ALL_CLASSES );) {
            System.out.println ( preparedStatement );
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery ();

            // Step 4: Process the ResultSet object.
            while (rs.next ()) {
                int id = rs.getInt ( "c_id" );
                String name = rs.getString ( "className" );
                classesList.add ( new Classes ( id, name ) );
            }
        } catch (SQLException e) {
            printSQLException ( e );
        }
        return classesList;
    }

    //    public static void main(String[] args) {
//        IClassDAO classDAO = new ClassDAO ();
//        System.out.println (classDAO.selectAllClass ());
//    }
    @Override
    public Classes selectClasses(int id) {
        Classes classes = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection ();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement ( SELECT_CLASSES_SQL );) {
            preparedStatement.setInt ( 1, id );
            System.out.println ( preparedStatement );
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery ();
            // Step 4: Process the ResultSet object.
            while (rs.next ()) {
                String className = rs.getString ( "className" );
                classes = new Classes ( id, className );
            }
        } catch (SQLException e) {
            printSQLException ( e );
        }
        return classes;
    }

    @Override
    public void insertClasses(Classes classes) throws SQLException {
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection (); PreparedStatement preparedStatement = connection.prepareStatement ( INSERT_CLASSES_SQL )) {
            preparedStatement.setString ( 1, classes.getClassName () );
            System.out.println ( preparedStatement );
            preparedStatement.executeUpdate ();
        } catch (SQLException e) {
            printSQLException ( e );
        }
    }

    @Override
    public boolean checkClassById(int id) throws SQLException, ClassNotFoundException {
        List<Classes> classesList = selectAllClass ();
        for (Classes role : classesList) {
            if (role.getC_id () == id) {
                return true;
            }
        }
        return false;
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
