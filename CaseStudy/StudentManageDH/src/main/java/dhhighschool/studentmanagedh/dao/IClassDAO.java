package dhhighschool.studentmanagedh.dao;

import dhhighschool.studentmanagedh.model.Classes;

import java.sql.SQLException;
import java.util.List;

public interface IClassDAO {
    List<Classes> selectAllClass();
    Classes selectClasses(int id);
    void insertClasses(Classes classes) throws SQLException;
    boolean checkClassById(int id) throws SQLException, ClassNotFoundException;
}
