package dhhighschool.studentmanagedh.dao;

import dhhighschool.studentmanagedh.model.Classes;
import dhhighschool.studentmanagedh.model.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO implements IRoleDAO{
    private final String jdbcURL = "jdbc:mysql://localhost:3306/studentmanage?useSSL=false";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "Trantrung.00";
    private static final String SELECT_ALL_ROLES = "SELECT * FROM role;";
    private static final String SELECT_ROLES_SQL = "SELECT * FROM role WHERE id=?;";
    private static final String INSERT_ROLES_SQL = "INSERT INTO role (name) VALUES (?);";


    public RoleDAO() {

    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<Role> selectAllRoles() {
        List<Role> roles = new ArrayList<> ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection ();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement ( SELECT_ALL_ROLES );) {
            System.out.println ( preparedStatement );
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery ();

            // Step 4: Process the ResultSet object.
            while (rs.next ()) {
                int id = rs.getInt ( "r_id" );
                String name = rs.getString ( "roleName" );
                roles.add ( new Role ( id, name ) );
            }
        } catch (SQLException e) {
            printSQLException ( e );
        }
        return roles;
    }

//    public static void main(String[] args) {
//        RoleDAO roleDAO = new RoleDAO ();
//        System.out.println (roleDAO.selectAllRoles ());
//    }

    @Override
    public Role selectRole(int id) {
        Role role = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection ();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement ( SELECT_ROLES_SQL );) {
            preparedStatement.setInt ( 1, id );
            System.out.println ( preparedStatement );
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery ();
            // Step 4: Process the ResultSet object.
            while (rs.next ()) {
                String roleName = rs.getString ( "roleName" );
                role = new Role ( id, roleName );
            }
        } catch (SQLException e) {
            printSQLException ( e );
        }
        return role;
    }

    @Override
    public void insertRole(Role role) throws SQLException {
// try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection (); PreparedStatement preparedStatement = connection.prepareStatement ( INSERT_ROLES_SQL )) {
            preparedStatement.setString ( 1, role.getRoleName () );
            System.out.println ( preparedStatement );
            preparedStatement.executeUpdate ();
        } catch (SQLException e) {
            printSQLException ( e );
        }
    }

    @Override
    public boolean checkRoleById(int id) throws SQLException, ClassNotFoundException {
        List<Role> listRoles = selectAllRoles ();
        for (Role role : listRoles) {
            if (role.getR_id () == id) {
                return true;
            }
        }
        return false;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
