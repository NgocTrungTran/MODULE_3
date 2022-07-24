package dhhighschool.studentmanagedh.model;

public class Role {
    private int r_id;
    private String roleName;

    public Role() {
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public Role(int r_id, String roleName) {
        this.r_id = r_id;
        this.roleName = roleName;
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "r_id=" + r_id +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
