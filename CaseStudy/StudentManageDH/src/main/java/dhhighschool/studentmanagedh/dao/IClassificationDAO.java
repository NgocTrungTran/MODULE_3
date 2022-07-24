package dhhighschool.studentmanagedh.dao;

import dhhighschool.studentmanagedh.model.Classes;
import dhhighschool.studentmanagedh.model.Classification;

import java.sql.SQLException;
import java.util.List;

public interface IClassificationDAO {
    List<Classification> selectAllClassification();
    Classification selectClassification(int id);
    void insertClassification(Classification classification) throws SQLException;
}
