package dhhighschool.studentmanagedh.dao;


import dhhighschool.studentmanagedh.model.Student;
import dhhighschool.studentmanagedh.model.TestScores;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IStudentDAO {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/studentmanage?useSSL=false";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "Trantrung.00";

    private static final String INSERT_STUDENT_SQL = "INSERT INTO students(code ,firstName, lastName, dayBirth, email, phoneNum, address, avatar, class_id, role_id)\n" +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_SCORE_STUDENTS_SQL = "SELECT \n" +
            "        `s`.`code` AS `code`,\n" +
            "        `s`.`firstName` AS `firstName`,\n" +
            "        `s`.`lastName` AS `lastName`,\n" +
            "        `s`.`class_id` AS `class_id`,\n" +
            "        `t`.`subjects_id` AS `subjects_id`,\n" +
            "        `t`.`f_testScore` AS `f_testScore`,\n" +
            "        `t`.`s_testScore` AS `s_testScore`,\n" +
            "        `t`.`t_testScore` AS `t_testScore`,\n" +
            "        `t`.`classification_id` AS `classification_id`\n" +
            "    FROM\n" +
            "        (`students` `s`\n" +
            "        JOIN `testscores` `t` ON ((`s`.`code` = `t`.`student_code`)))\n" +
            "    WHERE\n" +
            "        (`s`.`code` = ?);";
    private static final String SELECT_ALL_STUDENTS_SQL = "select *\n" +
            "from students\n" +
            "WHERE role_id = 2 and remove = 1;";
    private static final String SELECT_TRASH_STUDENTS_SQL = "select *\n" +
            "from students\n" +
            "WHERE role_id = 2 and remove = 0;";
    private static final String SELECT_STUDENT_BY_CODE = "select * from students where code =?;";
    private static final String SELECT_STUDENT_BY_PHONE = "select * from students where phoneNum = ?;";
    private static final String SELECT_STUDENT_BY_EMAIL = "select * from students where email = ?;";
    private static final String UPDATE_USERS_SQL = "UPDATE `studentmanage`.`students` SET \n" +
            "`firstName` = ?, `lastName` = ?, `dayBirth` = ?, `email` = ?, `phoneNum` = ?, `address` = ?, `avatar` = ?, `class_id` = ?,`updateDate` = ?\n" +
            "WHERE (`code` = ?);";
    private static final String DELETE_STUDENT_SQL = "delete from students where code = ?;";
    private static final String REMOVE_STUDENT_SQL = "UPDATE `studentmanage`.`students` SET `remove` = '0' WHERE (`code` = ?);";
    private static final String RESTORE_STUDENT_SQL = "UPDATE `studentmanage`.`students` SET `remove` = '1' WHERE (`code` = ?);";
    Connection connection;
    Statement stmt;
    private int noOfRecords;

    public StudentDAO() {

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
    public List<Student> selectAllStudent() {
        List<Student> students = new ArrayList<> ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection ();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement ( SELECT_ALL_STUDENTS_SQL );) {
            System.out.println ( preparedStatement );
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery ();

            // Step 4: Process the ResultSet object.
            while (rs.next ()) {
                String code = rs.getString ( "code" );
                String firstName = rs.getString ( "firstName" );
                String lastName = rs.getString ( "lastName" );
                String dayBirth = rs.getString ( "dayBirth" );
                String email = rs.getString ( "email" );
                String phoneNum = rs.getString ( "phoneNum" );
                String address = rs.getString ( "address" );
                String avatar = rs.getString ( "avatar" );
                int classId = rs.getInt ( "class_id" );
                Timestamp createDate = rs.getTimestamp ( "createDate" );
                Timestamp updateDate = rs.getTimestamp ( "updateDate" );
                int roleId = rs.getInt ( "role_id" );
                int testScore_id = rs.getInt ( "testScore_id" );
                int classification_id = rs.getInt ( "classification_id" );
                int remove = rs.getInt ( "remove" );

                students.add ( new Student ( code, firstName, lastName, dayBirth, email, phoneNum, address, avatar, classId, createDate, updateDate, roleId, testScore_id, classification_id, remove ) );
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        return students;
    }

    @Override
    public List<Student> selectListClassStudent(int offset, int noOfRecords, int classId) throws SQLException {
        Connection connection = getConnection ();
        String query = "select SQL_CALC_FOUND_ROWS * from students WHERE role_id = 2 and remove = 1 and class_id = ? limit " + offset + "," + noOfRecords;
        List<Student> list = new ArrayList<> ();
        PreparedStatement ps = connection.prepareStatement ( query );
        ps.setInt ( 1, classId );

        ResultSet rs = ps.executeQuery ();
        while (rs.next ()) {
            Student student = new Student ();
            student.setCode ( rs.getString ( "code" ) );
            student.setFirstName ( rs.getString ( "firstName" ) );
            student.setLastName ( rs.getString ( "lastName" ) );
            student.setDayBirth ( rs.getString ( "dayBirth" ) );
            student.setEmail ( rs.getString ( "email" ) );
            student.setPhoneNum ( rs.getString ( "phoneNum" ) );
            student.setAddress ( rs.getString ( "address" ) );
            student.setAvatar ( rs.getString ( "avatar" ) );
            student.setClass_id ( rs.getInt ( "class_id" ) );
            student.setCreateDate ( rs.getTimestamp ( "createDate" ) );
            student.setUpdateDate ( rs.getTimestamp ( "updateDate" ) );
            student.setRole_id ( rs.getInt ( "role_id" ) );
            student.setTestScore_id ( rs.getInt ( "testScore_id" ) );
            student.setClassification_id ( rs.getInt ( "classification_id" ) );

            list.add ( student );
        }
        rs = ps.executeQuery ( "SELECT FOUND_ROWS()" );
        if ( rs.next () ) {
            this.noOfRecords = rs.getInt ( 1 );
        }
        connection.close ();
        return list;
    }

    @Override
    public List<Student> selectTrashListStudent() {
        List<Student> students = new ArrayList<> ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection ();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement ( SELECT_TRASH_STUDENTS_SQL );) {
            System.out.println ( preparedStatement );

            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery ();

            // Step 4: Process the ResultSet object.
            while (rs.next ()) {
                String code = rs.getString ( "code" );
                String firstName = rs.getString ( "firstName" );
                String lastName = rs.getString ( "lastName" );
                String dayBirth = rs.getString ( "dayBirth" );
                String email = rs.getString ( "email" );
                String phoneNum = rs.getString ( "phoneNum" );
                String address = rs.getString ( "address" );
                String avatar = rs.getString ( "avatar" );
                int classId = rs.getInt ( "class_id" );
                Timestamp createDate = rs.getTimestamp ( "createDate" );
                Timestamp updateDate = rs.getTimestamp ( "updateDate" );
                int roleId = rs.getInt ( "role_id" );
                int testScore_id = rs.getInt ( "testScore_id" );
                int classification_id = rs.getInt ( "classification_id" );
                int remove = rs.getInt ( "remove" );

                students.add ( new Student ( code, firstName, lastName, dayBirth, email, phoneNum, address, avatar, classId, createDate, updateDate, roleId, testScore_id, classification_id, remove ) );
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        return students;
    }

    //    public static void main(String[] args) {
//        StudentDAO studentDAO = new StudentDAO ();
//
//        System.out.println (studentDAO.selectAllStudent ());
//    }
    @Override
    public void insertStudent(Student student) throws SQLException {
// try-with-resource statement will auto close the connection.
        //INSERT INTO peoples(code ,firstName, lastName, dayBirth, email, phoneNum, address, avatar, c_id, role_id)
        try (Connection connection = getConnection (); PreparedStatement preparedStatement = connection.prepareStatement ( INSERT_STUDENT_SQL )) {
            preparedStatement.setString ( 1, student.getCode () );
            preparedStatement.setString ( 2, student.getFirstName () );
            preparedStatement.setString ( 3, student.getLastName () );
            preparedStatement.setString ( 4, student.getDayBirth () );
            preparedStatement.setString ( 5, student.getEmail () );
            preparedStatement.setString ( 6, student.getPhoneNum () );
            preparedStatement.setString ( 7, student.getAddress () );
            preparedStatement.setString ( 8, student.getAvatar () );
            preparedStatement.setInt ( 9, student.getClass_id () );
            preparedStatement.setInt ( 10, student.getRole_id () );
            System.out.println ( this.getClass () + " insertStudent(): " + preparedStatement );
            preparedStatement.executeUpdate ();
        } catch (SQLException e) {
            printSQLException ( e );
        }
    }

    @Override
    public Student selectStudent(String code) {

        Student student = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection ();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement ( SELECT_STUDENT_BY_CODE );) {
            preparedStatement.setString ( 1, code );
            System.out.println ( preparedStatement );
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery ();

            // Step 4: Process the ResultSet object.
            while (rs.next ()) {
                String firstName = rs.getString ( "firstName" );
                String lastName = rs.getString ( "lastName" );
                String dayBirth = rs.getString ( "dayBirth" );
                String email = rs.getString ( "email" );
                String phoneNum = rs.getString ( "phoneNum" );
                String address = rs.getString ( "address" );
                String avatar = rs.getString ( "avatar" );
                int classId = rs.getInt ( "class_id" );
                Timestamp createDate = rs.getTimestamp ( "createDate" );
                Timestamp updateDate = rs.getTimestamp ( "updateDate" );
                int roleId = rs.getInt ( "role_id" );
                int testScore_id = rs.getInt ( "testScore_id" );
                int classification_id = rs.getInt ( "classification_id" );
                int remove = rs.getInt ( "remove" );

                student = new Student ( code, firstName, lastName, dayBirth, email, phoneNum, address, avatar, classId, createDate, updateDate, roleId, testScore_id, classification_id, remove );
            }
        } catch (SQLException e) {
            printSQLException ( e );
        }
        return student;
    }
    public Student selectScore(String code) {

        Student student = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection ();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement ( SELECT_SCORE_STUDENTS_SQL );) {
            preparedStatement.setString ( 1, code );
            System.out.println ( preparedStatement );
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery ();

            // Step 4: Process the ResultSet object.
            while (rs.next ()) {
                String firstName = rs.getString ( "firstName" );
                String lastName = rs.getString ( "lastName" );
                int class_id = rs.getInt ( "class_id" );
                int subjects_id = rs.getInt ( "subjects_id" );
                float f_testScore = rs.getFloat ( "f_testScore" );
                float s_testScore = rs.getFloat ( "s_testScore" );
                float t_testScore = rs.getFloat ( "t_testScore" );
                int classification_id = rs.getInt ( "classification_id" );

//                student = new Student ( code, firstName, lastName, dayBirth, email, phoneNum, address, avatar, classId, createDate, updateDate, roleId, testScore_id, classification_id, remove );
            }
        } catch (SQLException e) {
            printSQLException ( e );
        }
        return student;
    }

    @Override
    public Student selectStudentByPhone(String phone) {
        Student student = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection ();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement ( SELECT_STUDENT_BY_PHONE );) {
            preparedStatement.setString ( 1, phone );
            System.out.println ( preparedStatement );
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery ();

            // Step 4: Process the ResultSet object.
            while (rs.next ()) {
                String code = rs.getString ( "code" );
                String firstName = rs.getString ( "firstName" );
                String lastName = rs.getString ( "lastName" );
                String dayBirth = rs.getString ( "dayBirth" );
                String email = rs.getString ( "email" );
                String phoneNum = rs.getString ( "phoneNum" );
                String address = rs.getString ( "address" );
                String avatar = rs.getString ( "avatar" );
                int class_id = rs.getInt ( "class_id" );
                Timestamp createDate = rs.getTimestamp ( "createDate" );
                Timestamp updateDate = rs.getTimestamp ( "updateDate" );
                int role_id = rs.getInt ( "role_id" );
                int testScore_id = rs.getInt ( "testScore_id" );
                int classification_id = rs.getInt ( "classification_id" );
                int remove = rs.getInt ( "remove" );

                student = new Student ( code, firstName, lastName, dayBirth, email, phoneNum, address, avatar, class_id, createDate, updateDate, role_id, testScore_id, classification_id, remove );
                return student;
            }
        } catch (SQLException e) {
            printSQLException ( e );
        }
        return null;
    }

    @Override
    public Student selectStudentByEmail(String email) {
        Student student = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection ();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement ( SELECT_STUDENT_BY_EMAIL );) {
            preparedStatement.setString ( 1, email );
            System.out.println ( preparedStatement );
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery ();

            // Step 4: Process the ResultSet object.
            while (rs.next ()) {
                String code = rs.getString ( "code" );
                String firstName = rs.getString ( "firstName" );
                String lastName = rs.getString ( "lastName" );
                String dayBirth = rs.getString ( "dayBirth" );
                String getEmail = rs.getString ( "email" );
                String phoneNum = rs.getString ( "phoneNum" );
                String address = rs.getString ( "address" );
                String avatar = rs.getString ( "avatar" );
                int class_id = rs.getInt ( "class_id" );
                Timestamp createDate = rs.getTimestamp ( "createDate" );
                Timestamp updateDate = rs.getTimestamp ( "updateDate" );
                int role_id = rs.getInt ( "role_id" );
                int testScore_id = rs.getInt ( "testScore_id" );
                int classification_id = rs.getInt ( "classification_id" );
                int remove = rs.getInt ( "remove" );

                student = new Student ( code, firstName, lastName, dayBirth, getEmail, phoneNum, address, avatar, class_id, createDate, updateDate, role_id, testScore_id, classification_id, remove );
                return student;
            }
        } catch (SQLException e) {
            printSQLException ( e );
        }
        return null;
    }

    @Override
    public boolean deleteStudent(String code) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection (); PreparedStatement statement = connection.prepareStatement ( DELETE_STUDENT_SQL );) {
            statement.setString ( 1, code );
            rowDeleted = statement.executeUpdate () > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean removeStudent(String code) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection (); PreparedStatement statement = connection.prepareStatement ( REMOVE_STUDENT_SQL );) {
            statement.setString ( 1, code );
            rowDeleted = statement.executeUpdate () > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean restoreStudent(String code) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection (); PreparedStatement statement = connection.prepareStatement ( RESTORE_STUDENT_SQL );) {
            statement.setString ( 1, code );
            rowDeleted = statement.executeUpdate () > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateStudent(Student student) throws SQLException {
        boolean rowUpdated;
//        UPDATE `studentmanage`.`students` SET \n" +
//        "`firstName` = ?, `lastName` = ?, `dayBirth` = ?, `email` = ?, `phoneNum` = ?, `address` = ?, `avatar` = ? \n" +
//                "WHERE (`code` = ?);
        try (Connection connection = getConnection (); PreparedStatement statement = connection.prepareStatement ( UPDATE_USERS_SQL );) {
            statement.setString ( 1, student.getFirstName () );
            statement.setString ( 2, student.getLastName () );
            statement.setString ( 3, student.getDayBirth () );
            statement.setString ( 4, student.getEmail () );
            statement.setString ( 5, student.getPhoneNum () );
            statement.setString ( 6, student.getAddress () );
            statement.setString ( 7, student.getAvatar () );
            statement.setInt ( 8, student.getClass_id () );
            statement.setTimestamp ( 9, student.getUpdateDate () );
            statement.setString ( 10, student.getCode () );

            rowUpdated = statement.executeUpdate () > 0;
        }
        return rowUpdated;
    }

    @Override
    public List<Student> searchStudent(int offset, int noOfRecords, String search) throws SQLException {
        Connection connection = getConnection ();
        System.out.println ( "numberpage" );

        String query = "select SQL_CALC_FOUND_ROWS * from students WHERE role_id = 2 and remove = 1 and code like ? OR firstName like ? OR lastName like ? OR email like ? or phoneNum like ? or address like ? limit " + offset + "," + noOfRecords;
        List<Student> list = new ArrayList<> ();
        PreparedStatement ps = connection.prepareStatement ( query );
        ps.setString ( 1, '%' + search + '%' );
        ps.setString ( 2, '%' + search + '%' );
        ps.setString ( 3, '%' + search + '%' );
        ps.setString ( 4, '%' + search + '%' );
        ps.setString ( 5, '%' + search + '%' );
        ps.setString ( 6, '%' + search + '%' );

        System.out.println ( this.getClass () + " getNumberPage() query: " + ps );
        ResultSet rs = ps.executeQuery ();
        while (rs.next ()) {
            Student student = new Student ();
            student.setCode ( rs.getString ( "code" ) );
            student.setFirstName ( rs.getString ( "firstName" ) );
            student.setLastName ( rs.getString ( "lastName" ) );
            student.setDayBirth ( rs.getString ( "dayBirth" ) );
            student.setEmail ( rs.getString ( "email" ) );
            student.setPhoneNum ( rs.getString ( "phoneNum" ) );
            student.setAddress ( rs.getString ( "address" ) );
            student.setAvatar ( rs.getString ( "avatar" ) );
            student.setClass_id ( rs.getInt ( "class_id" ) );
            student.setCreateDate ( rs.getTimestamp ( "createDate" ) );
            student.setUpdateDate ( rs.getTimestamp ( "updateDate" ) );
            student.setRole_id ( rs.getInt ( "role_id" ) );
            student.setTestScore_id ( rs.getInt ( "testScore_id" ) );
            student.setClassification_id ( rs.getInt ( "classification_id" ) );

            list.add ( student );
        }
        rs = ps.executeQuery ( "SELECT FOUND_ROWS()" );
        if ( rs.next () ) {
            this.noOfRecords = rs.getInt ( 1 );
        }
        connection.close ();
        return list;
    }

    //    public static void main(String[] args) throws SQLException {
//        StudentDAO studentDAO = new StudentDAO ();
//        System.out.println (studentDAO.searchStudent ( 0, 3,"damon" ));
//    }
    @Override
    public List<Student> sortFullNameADC(List<Student> userList) {
        return null;
    }

    @Override
    public List<Student> sortFullNameDEC(List<Student> userList) {
        return null;
    }

    @Override
    public List<Student> searchNameStudent(String name) {
        return null;
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

    public List<Student> viewAllStudent(int offset, int noOfRecords) {
//        String query = "select SQL_CALC_FOUND_ROWS * from students limit "
//                + offset + ", " + noOfRecords;
        String query = "select SQL_CALC_FOUND_ROWS * from students WHERE role_id = 2 and remove = 1 ORDER BY createDate desc limit " + offset + ", " + noOfRecords + ";";
        List<Student> list = new ArrayList<Student> ();
        Student student = null;
        try {
            connection = getConnection ();
            stmt = connection.createStatement ();
            ResultSet rs = stmt.executeQuery ( query );
            while (rs.next ()) {
                student = new Student ();
                student.setCode ( rs.getString ( "code" ) );
                student.setFirstName ( rs.getString ( "firstName" ) );
                student.setLastName ( rs.getString ( "lastName" ) );
                student.setDayBirth ( rs.getString ( "dayBirth" ) );
                student.setEmail ( rs.getString ( "email" ) );
                student.setPhoneNum ( rs.getString ( "phoneNum" ) );
                student.setAddress ( rs.getString ( "address" ) );
                student.setAvatar ( rs.getString ( "avatar" ) );
                student.setClass_id ( rs.getInt ( "class_id" ) );
                student.setCreateDate ( rs.getTimestamp ( "createDate" ) );
                student.setUpdateDate ( rs.getTimestamp ( "updateDate" ) );
                student.setRole_id ( rs.getInt ( "role_id" ) );
                student.setTestScore_id ( rs.getInt ( "testScore_id" ) );
                student.setClassification_id ( rs.getInt ( "classification_id" ) );
                student.setRemove ( rs.getInt ( "remove" ) );

                list.add ( student );
            }
            rs.close ();

            rs = stmt.executeQuery ( "SELECT FOUND_ROWS()" );
            if ( rs.next () ) {
                this.noOfRecords = rs.getInt ( 1 );
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        } finally {
            try {
                if ( stmt != null )
                    stmt.close ();
                if ( connection != null )
                    connection.close ();
            } catch (SQLException e) {
                e.printStackTrace ();
            }
        }
        return list;
    }

    public int getNoOfRecords() {
        return noOfRecords;
    }
}
