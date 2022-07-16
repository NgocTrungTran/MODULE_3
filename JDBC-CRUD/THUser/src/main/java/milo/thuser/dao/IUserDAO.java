package milo.thuser.dao;

import milo.thuser.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    void insertUser(User user) throws SQLException;
    User selectUser(int id);
    List<User> selectAllUsers();
    boolean deleteUser(int id) throws SQLException;
    boolean updateUser(User user) throws SQLException;
    User getUserById(int id);

    void insertUserStore(User user) throws SQLException;

    List<User> sortFullNameADC(List<User> userList);
    List<User> sortFullNameDEC(List<User> userList);
    List<User> searchNameStudent(String name);
    void addUserTransaction(User user, int[] permisions);
    void insertUpdateWithoutTransaction();
}
