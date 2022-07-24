package dhhighschool.studentmanagedh.dao;

import dhhighschool.studentmanagedh.model.Classification;
import dhhighschool.studentmanagedh.model.Subjects;

import java.sql.SQLException;
import java.util.List;

public interface ISubjectDAO {
    List<Subjects> selectAllSubjectDAO();
    Subjects selectSubjectDAO(int id);
    void insertSubjectDAO(Subjects subjectDAO) throws SQLException;
}
