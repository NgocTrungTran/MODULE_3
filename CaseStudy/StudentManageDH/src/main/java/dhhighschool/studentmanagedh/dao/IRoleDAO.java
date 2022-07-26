package dhhighschool.studentmanagedh.dao;

import dhhighschool.studentmanagedh.model.Role;

import java.sql.SQLException;
import java.util.List;

public interface IRoleDAO {
    List<Role> selectAllRoles();
    Role selectRole(int id);
    void insertRole(Role role) throws SQLException;
    boolean checkRoleById(int id) throws SQLException, ClassNotFoundException;
}
