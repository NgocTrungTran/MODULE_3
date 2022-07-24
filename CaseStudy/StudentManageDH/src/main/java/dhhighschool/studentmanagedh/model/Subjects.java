package dhhighschool.studentmanagedh.model;

public class Subjects {
    private int subjects_id;
    private String sub_name;

    public Subjects() {
    }

    public Subjects(int subjects_id, String sub_name) {
        this.subjects_id = subjects_id;
        this.sub_name = sub_name;
    }

    public int getSubjects_id() {
        return subjects_id;
    }

    public void setSubjects_id(int subjects_id) {
        this.subjects_id = subjects_id;
    }

    public String getSub_name() {
        return sub_name;
    }

    public void setSub_name(String sub_name) {
        this.sub_name = sub_name;
    }

    @Override
    public String toString() {
        return "subjects{" +
                "subjects_id=" + subjects_id +
                ", sub_name='" + sub_name + '\'' +
                '}';
    }
}
