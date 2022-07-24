package dhhighschool.studentmanagedh.model;

public class Classes {
    private int c_id;
    private String className;

    public Classes(String className) {
        this.className = className;
    }

    public Classes(int c_id, String className) {
        this.c_id = c_id;
        this.className = className;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "c_id=" + c_id +
                ", className='" + className + '\'' +
                '}';
    }
}
