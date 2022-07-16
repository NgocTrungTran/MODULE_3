package milo.thuser.dao;

import milo.thuser.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UserDAO implements IUserDAO{
    private final String jdbcURL = "jdbc:mysql://localhost:3306/usermanage?useSSL=false";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "Trantrung.00";

    private static final String INSERT_USERS_SQL = "INSERT INTO users (name, email, idcountry) VALUES (?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "select id,name,email,idcountry from users where id =?;";
    private static final String SELECT_ALL_USERS = "select * from users;";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, idcountry =? where id = ?;";
    private static final String SELECT_USER_BY_EMAIL = "select u.id,u.name,u.email, u.idcountry\r\n"
            + "    		 from users as u inner join country as c\r\n"
            + "    		where u.email = ? and u.idcountry = c.id;";
    public UserDAO() {

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
    public void insertUser(User user) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setInt(3, user.getCountry());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public User selectUser(int id) {
        User user = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                int idCountry = rs.getInt ("idCountry");
                user = new User(id, name, email, idCountry);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<> ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int idCountry = rs.getInt ("idCountry");
                users.add(new User(id, name, email, idCountry));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;

    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setInt (3, user.getCountry());
            statement.setInt(4, user.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
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
    public List<User> sortAllUsersByName() {
        List<User> users = new ArrayList<> ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int idCountry = rs.getInt ("idCountry");
                users.add(new User(id, name, email, idCountry));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }
    public User selectUserByEmail(String _email) {
        User user = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             //SELCT_USER_BY_EMAIL = "select id,name,email from users where email = ?";
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_EMAIL);) {
            preparedStatement.setString(1, _email);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int idCountry = rs.getInt("idcountry");
                user = new User(id, name, email, idCountry);

                return user;
            }
            return null;
        } catch (SQLException e) {
            printSQLException(e);
            return null;

        }
    }

    @Override
    public List<User> sortFullNameADC(List<User> userList) {
        userList.sort ( new Comparator<User> () {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName ().compareTo ( o2.getName () );
            }
        } );
        return userList;
    }

    @Override
    public List<User> sortFullNameDEC(List<User> userList) {
        userList.sort ( new Comparator<User> () {
            @Override
            public int compare(User o1, User o2) {
                return o2.getName ().compareTo ( o1.getName () );
            }
        } );
        return userList;
    }
    @Override
    public List<User> searchNameStudent(String name) {
        List<User> users = selectAllUsers ();
        List<User> usersSearch = new ArrayList<>();
        for (User user:users) {
            if ( user.getName ().toLowerCase ().contains ( name.toLowerCase ().trim () ) ){
                usersSearch.add ( user );
            }
        }
        return usersSearch;
    }

    @Override
    public User getUserById(int id) {
        User user = null;

        String query = "{CALL get_user_by_id(?)}";

        // Step 1: Establishing a Connection

        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object

             CallableStatement callableStatement = connection.prepareCall(query);) {

            callableStatement.setInt(1, id);

            // Step 3: Execute the query or update query

            ResultSet rs = callableStatement.executeQuery();

            // Step 4: Process the ResultSet object.

            while (rs.next()) {

                String name = rs.getString("name");

                String email = rs.getString("email");

                int idCountry = rs.getInt ("idCountry");

                user = new User(id, name, email, idCountry);

            }

        } catch (SQLException e) {

            printSQLException(e);

        }

        return user;
    }

    @Override
    public void insertUserStore(User user) throws SQLException {
        String query = "{CALL insert_user(?,?,?,?)}";

        // try-with-resource statement will auto close the connection.

        try (Connection connection = getConnection();

             CallableStatement callableStatement = connection.prepareCall(query);) {

            callableStatement.setString(1, user.getName());

            callableStatement.setString(2, user.getEmail());

            callableStatement.setInt (3, user.getCountry());
            callableStatement.setString (4, user.getPassword ());

            System.out.println(callableStatement);

            callableStatement.executeUpdate();

        } catch (SQLException e) {

            printSQLException(e);
        }
    }

    @Override
    public void addUserTransaction(User user, int[] permisions) {
        Connection conn = null;

        // for insert a new user

        PreparedStatement pstmt = null;

        // for assign permision to user

        PreparedStatement pstmtAssignment = null;

        // for getting user id

        ResultSet rs = null;

        try {

            conn = getConnection();

            // set auto commit to false

            conn.setAutoCommit(false);

            //

            // Insert user

            //

            pstmt = conn.prepareStatement(INSERT_USERS_SQL, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, user.getName());

            pstmt.setString(2, user.getEmail());

            pstmt.setInt (3, user.getCountry());

            int rowAffected = pstmt.executeUpdate();

            // get user id

            rs = pstmt.getGeneratedKeys();

            int userId = 0;

            if (rs.next())

                userId = rs.getInt(1);

            //

            // in case the insert operation successes, assign permision to user

            //

            if (rowAffected == 1) {

                // assign permision to user

                String sqlPivot = "INSERT INTO user_permision(user_id,permision_id) "

                        + "VALUES(?,?)";

                pstmtAssignment = conn.prepareStatement(sqlPivot);

                for (int permisionId : permisions) {

                    pstmtAssignment.setInt(1, userId);

                    pstmtAssignment.setInt(2, permisionId);

                    pstmtAssignment.executeUpdate();

                }

                conn.commit();

            } else {

                conn.rollback();

            }

        } catch (SQLException ex) {

            // roll back the transaction

            try {

                if (conn != null)

                    conn.rollback();

            } catch (SQLException e) {

                System.out.println(e.getMessage());

            }

            System.out.println(ex.getMessage());

        } finally {

            try {

                if (rs != null) rs.close();

                if (pstmt != null) pstmt.close();

                if (pstmtAssignment != null) pstmtAssignment.close();

                if (conn != null) conn.close();

            } catch (SQLException e) {

                System.out.println(e.getMessage());

            }

        }
    }
}
